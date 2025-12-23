package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2ConnectionEncoder extends Http2FrameWriter {
    Http2Connection connection();

    Http2RemoteFlowController flowController();

    Http2FrameWriter frameWriter();

    void lifecycleManager(Http2LifecycleManager http2LifecycleManager);

    Http2Settings pollSentSettings();

    void remoteSettings(Http2Settings http2Settings) throws Http2Exception;

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise);
}
