package io.netty.handler.codec.spdy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SpdyHeadersFrame extends SpdyStreamFrame {
    SpdyHeaders headers();

    boolean isInvalid();

    boolean isTruncated();

    SpdyHeadersFrame setInvalid();

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdyHeadersFrame setLast(boolean z5);

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdyHeadersFrame setStreamId(int i6);

    SpdyHeadersFrame setTruncated();
}
