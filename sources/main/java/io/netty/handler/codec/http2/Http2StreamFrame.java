package io.netty.handler.codec.http2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2StreamFrame extends Http2Frame {
    Http2FrameStream stream();

    Http2StreamFrame stream(Http2FrameStream http2FrameStream);
}
