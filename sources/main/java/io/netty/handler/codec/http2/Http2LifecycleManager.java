package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2LifecycleManager {
    void closeStream(Http2Stream http2Stream, ChannelFuture channelFuture);

    void closeStreamLocal(Http2Stream http2Stream, ChannelFuture channelFuture);

    void closeStreamRemote(Http2Stream http2Stream, ChannelFuture channelFuture);

    ChannelFuture goAway(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf, ChannelPromise channelPromise);

    void onError(ChannelHandlerContext channelHandlerContext, boolean z5, Throwable th);

    ChannelFuture resetStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise);
}
