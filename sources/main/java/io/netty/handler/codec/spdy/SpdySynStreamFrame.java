package io.netty.handler.codec.spdy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SpdySynStreamFrame extends SpdyHeadersFrame {
    int associatedStreamId();

    boolean isUnidirectional();

    byte priority();

    SpdySynStreamFrame setAssociatedStreamId(int i6);

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    SpdySynStreamFrame setInvalid();

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdySynStreamFrame setLast(boolean z5);

    SpdySynStreamFrame setPriority(byte b6);

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdySynStreamFrame setStreamId(int i6);

    SpdySynStreamFrame setUnidirectional(boolean z5);
}
