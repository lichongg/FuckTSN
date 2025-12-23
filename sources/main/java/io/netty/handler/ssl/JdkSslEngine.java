package io.netty.handler.ssl;

import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class JdkSslEngine extends SSLEngine implements ApplicationProtocolAccessor {
    private volatile String applicationProtocol;
    private final SSLEngine engine;

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.wrap(byteBuffer, byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        this.engine.beginHandshake();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        this.engine.closeInbound();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        this.engine.closeOutbound();
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return this.engine.getDelegatedTask();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getHandshakeSession() {
        SSLSession handshakeSession;
        handshakeSession = this.engine.getHandshakeSession();
        return handshakeSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.engine.getHandshakeStatus();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public String getPeerHost() {
        return this.engine.getPeerHost();
    }

    @Override // javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.engine.getPeerPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.engine.getSession();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    public SSLEngine getWrappedEngine() {
        return this.engine;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        return this.engine.isInboundDone();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        return this.engine.isOutboundDone();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z5) {
        this.engine.setEnableSessionCreation(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.engine.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.engine.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z5) {
        this.engine.setNeedClientAuth(z5);
    }

    void setNegotiatedApplicationProtocol(String str) {
        this.applicationProtocol = str;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        this.engine.setSSLParameters(sSLParameters);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z5) {
        this.engine.setUseClientMode(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z5) {
        this.engine.setWantClientAuth(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArr, byteBuffer);
    }

    JdkSslEngine(SSLEngine sSLEngine) {
        this.engine = sSLEngine;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i6, int i7) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArr, i6, i7);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i6, int i7, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArr, i6, i7, byteBuffer);
    }
}
