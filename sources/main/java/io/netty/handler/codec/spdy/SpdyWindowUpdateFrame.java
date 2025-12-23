package io.netty.handler.codec.spdy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SpdyWindowUpdateFrame extends SpdyFrame {
    int deltaWindowSize();

    SpdyWindowUpdateFrame setDeltaWindowSize(int i6);

    SpdyWindowUpdateFrame setStreamId(int i6);

    int streamId();
}
