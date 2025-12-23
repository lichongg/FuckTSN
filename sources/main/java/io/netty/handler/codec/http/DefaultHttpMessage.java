package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class DefaultHttpMessage extends DefaultHttpObject implements HttpMessage {
    private static final int HASH_CODE_PRIME = 31;
    private final HttpHeaders headers;
    private HttpVersion version;

    protected DefaultHttpMessage(HttpVersion httpVersion) {
        this(httpVersion, true, false);
    }

    protected DefaultHttpMessage(HttpVersion httpVersion, boolean z5, boolean z6) {
        this(httpVersion, z6 ? new CombinedHttpHeaders(z5) : new DefaultHttpHeaders(z5));
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpMessage)) {
            return false;
        }
        DefaultHttpMessage defaultHttpMessage = (DefaultHttpMessage) obj;
        return headers().equals(defaultHttpMessage.headers()) && protocolVersion().equals(defaultHttpMessage.protocolVersion()) && super.equals(obj);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((((this.headers.hashCode() + 31) * 31) + this.version.hashCode()) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpVersion protocolVersion() {
        return this.version;
    }

    public HttpMessage setProtocolVersion(HttpVersion httpVersion) {
        if (httpVersion == null) {
            throw new NullPointerException("version");
        }
        this.version = httpVersion;
        return this;
    }

    protected DefaultHttpMessage(HttpVersion httpVersion, HttpHeaders httpHeaders) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, "version");
        this.headers = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders, "headers");
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    @Deprecated
    public HttpVersion getProtocolVersion() {
        return protocolVersion();
    }
}
