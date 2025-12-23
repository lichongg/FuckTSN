package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Java9SslEngine extends JdkSslEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AlpnSelector alpnSelector;
    private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener selectionListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class AlpnSelector implements BiFunction<SSLEngine, List<String>, String> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean called;
        private final JdkApplicationProtocolNegotiator.ProtocolSelector selector;

        AlpnSelector(JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector) {
            this.selector = protocolSelector;
        }

        @Override // java.util.function.BiFunction
        public String apply(SSLEngine sSLEngine, List<String> list) {
            this.called = true;
            try {
                String select = this.selector.select(list);
                return select == null ? "" : select;
            } catch (Exception unused) {
                return null;
            }
        }

        void checkUnsupported() {
            if (!this.called && Java9SslEngine.this.getApplicationProtocol().isEmpty()) {
                this.selector.unsupported();
            }
        }
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBuffer2));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return verifyProtocolSelection(super.wrap(byteBuffer, byteBuffer2));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBufferArr));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) throws SSLException {
        return verifyProtocolSelection(super.wrap(byteBufferArr, byteBuffer));
    }

    Java9SslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z5) {
        super(sSLEngine);
        if (z5) {
            this.selectionListener = null;
            AlpnSelector alpnSelector = new AlpnSelector(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())));
            this.alpnSelector = alpnSelector;
            Java9SslUtils.setHandshakeApplicationProtocolSelector(sSLEngine, alpnSelector);
            return;
        }
        this.selectionListener = jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols());
        this.alpnSelector = null;
        Java9SslUtils.setApplicationProtocols(sSLEngine, jdkApplicationProtocolNegotiator.protocols());
    }

    private SSLEngineResult verifyProtocolSelection(SSLEngineResult sSLEngineResult) throws SSLException {
        if (sSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
            AlpnSelector alpnSelector = this.alpnSelector;
            if (alpnSelector == null) {
                try {
                    String applicationProtocol = getApplicationProtocol();
                    if (applicationProtocol.isEmpty()) {
                        this.selectionListener.unsupported();
                        return sSLEngineResult;
                    }
                    this.selectionListener.selected(applicationProtocol);
                    return sSLEngineResult;
                } catch (Throwable th) {
                    throw SslUtils.toSSLHandshakeException(th);
                }
            }
            alpnSelector.checkUnsupported();
        }
        return sSLEngineResult;
    }

    @Override // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return Java9SslUtils.getApplicationProtocol(getWrappedEngine());
    }

    @Override // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return Java9SslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    @Override // javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return Java9SslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        String applicationProtocol = getApplicationProtocol();
        if (applicationProtocol != null && applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        Java9SslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), biFunction);
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i6, int i7) throws SSLException {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBufferArr, i6, i7));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i6, int i7, ByteBuffer byteBuffer) throws SSLException {
        return verifyProtocolSelection(super.wrap(byteBufferArr, i6, i7, byteBuffer));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine
    void setNegotiatedApplicationProtocol(String str) {
    }
}
