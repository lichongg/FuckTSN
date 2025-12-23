package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultHttp2HeadersFrame extends AbstractHttp2StreamFrame implements Http2HeadersFrame {
    private final boolean endStream;
    private final Http2Headers headers;
    private final int padding;

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers) {
        this(http2Headers, false);
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z5) {
        this(http2Headers, z5, 0);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2HeadersFrame)) {
            return false;
        }
        DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = (DefaultHttp2HeadersFrame) obj;
        return super.equals(defaultHttp2HeadersFrame) && this.headers.equals(defaultHttp2HeadersFrame.headers) && this.endStream == defaultHttp2HeadersFrame.endStream && this.padding == defaultHttp2HeadersFrame.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public Http2Headers headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public boolean isEndStream() {
        return this.endStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "HEADERS";
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public int padding() {
        return this.padding;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(stream=" + stream() + ", headers=" + this.headers + ", endStream=" + this.endStream + ", padding=" + this.padding + ')';
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z5, int i6) {
        this.headers = (Http2Headers) ObjectUtil.checkNotNull(http2Headers, "headers");
        this.endStream = z5;
        Http2CodecUtil.verifyPadding(i6);
        this.padding = i6;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.headers.hashCode()) * 31) + (!this.endStream ? 1 : 0)) * 31) + this.padding;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2HeadersFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
