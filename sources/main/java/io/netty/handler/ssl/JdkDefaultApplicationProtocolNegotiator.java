package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLEngine;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class JdkDefaultApplicationProtocolNegotiator implements JdkApplicationProtocolNegotiator {
    public static final JdkDefaultApplicationProtocolNegotiator INSTANCE = new JdkDefaultApplicationProtocolNegotiator();
    private static final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory DEFAULT_SSL_ENGINE_WRAPPER_FACTORY = new JdkApplicationProtocolNegotiator.SslEngineWrapperFactory() { // from class: io.netty.handler.ssl.JdkDefaultApplicationProtocolNegotiator.1
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.SslEngineWrapperFactory
        public SSLEngine wrapSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z5) {
            return sSLEngine;
        }
    };

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolListenerFactory() {
        throw new UnsupportedOperationException("Application protocol negotiation unsupported");
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory() {
        throw new UnsupportedOperationException("Application protocol negotiation unsupported");
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return Collections.EMPTY_LIST;
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory() {
        return DEFAULT_SSL_ENGINE_WRAPPER_FACTORY;
    }

    private JdkDefaultApplicationProtocolNegotiator() {
    }
}
