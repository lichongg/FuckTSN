package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultFullHttpResponse extends DefaultHttpResponse implements FullHttpResponse {
    private final ByteBuf content;
    private int hash;
    private final HttpHeaders trailingHeaders;

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0));
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf) {
        this(httpVersion, httpResponseStatus, byteBuf, true);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse, io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultFullHttpResponse)) {
            return false;
        }
        DefaultFullHttpResponse defaultFullHttpResponse = (DefaultFullHttpResponse) obj;
        return super.equals(defaultFullHttpResponse) && content().equals(defaultFullHttpResponse.content()) && trailingHeaders().equals(defaultFullHttpResponse.trailingHeaders());
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse, io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        int hashCode;
        int i6 = this.hash;
        if (i6 != 0) {
            return i6;
        }
        if (content().refCnt() != 0) {
            try {
                hashCode = content().hashCode() + 31;
            } catch (IllegalReferenceCountException unused) {
            }
            int hashCode2 = (((hashCode * 31) + trailingHeaders().hashCode()) * 31) + super.hashCode();
            this.hash = hashCode2;
            return hashCode2;
        }
        hashCode = 31;
        int hashCode22 = (((hashCode * 31) + trailingHeaders().hashCode()) * 31) + super.hashCode();
        this.hash = hashCode22;
        return hashCode22;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return this.content.release(i6);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse, io.netty.handler.codec.http.HttpResponse, io.netty.handler.codec.http.FullHttpResponse
    public FullHttpResponse setStatus(HttpResponseStatus httpResponseStatus) {
        super.setStatus(httpResponseStatus);
        return this;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse
    public String toString() {
        return HttpMessageUtil.appendFullResponse(new StringBuilder(256), this).toString();
    }

    @Override // io.netty.handler.codec.http.LastHttpContent
    public HttpHeaders trailingHeaders() {
        return this.trailingHeaders;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z5) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0), z5, false);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpResponse, io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    public FullHttpResponse setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, boolean z5, boolean z6) {
        this(httpVersion, httpResponseStatus, Unpooled.buffer(0), z5, z6);
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, boolean z5) {
        this(httpVersion, httpResponseStatus, byteBuf, z5, false);
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse copy() {
        return replace(content().copy());
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse replace(ByteBuf byteBuf) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(protocolVersion(), status(), byteBuf, headers().copy(), trailingHeaders().copy());
        defaultFullHttpResponse.setDecoderResult(decoderResult());
        return defaultFullHttpResponse;
    }

    @Override // io.netty.handler.codec.http.LastHttpContent, io.netty.handler.codec.http.HttpContent, io.netty.buffer.ByteBufHolder
    public FullHttpResponse retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, boolean z5, boolean z6) {
        super(httpVersion, httpResponseStatus, z5, z6);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeaders = z6 ? new CombinedHttpHeaders(z5) : new DefaultHttpHeaders(z5);
    }

    public DefaultFullHttpResponse(HttpVersion httpVersion, HttpResponseStatus httpResponseStatus, ByteBuf byteBuf, HttpHeaders httpHeaders, HttpHeaders httpHeaders2) {
        super(httpVersion, httpResponseStatus, httpHeaders);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.trailingHeaders = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders2, "trailingHeaders");
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse retain(int i6) {
        this.content.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FullHttpResponse touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
