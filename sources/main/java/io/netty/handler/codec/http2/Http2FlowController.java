package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2FlowController {
    void channelHandlerContext(ChannelHandlerContext channelHandlerContext) throws Http2Exception;

    void incrementWindowSize(Http2Stream http2Stream, int i6) throws Http2Exception;

    int initialWindowSize();

    void initialWindowSize(int i6) throws Http2Exception;

    int windowSize(Http2Stream http2Stream);
}
