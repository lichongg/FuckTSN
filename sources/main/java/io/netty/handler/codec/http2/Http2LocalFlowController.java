package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2LocalFlowController extends Http2FlowController {
    boolean consumeBytes(Http2Stream http2Stream, int i6) throws Http2Exception;

    Http2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter);

    int initialWindowSize(Http2Stream http2Stream);

    void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i6, boolean z5) throws Http2Exception;

    int unconsumedBytes(Http2Stream http2Stream);
}
