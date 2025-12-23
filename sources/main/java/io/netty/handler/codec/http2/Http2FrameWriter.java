package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import java.io.Closeable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2FrameWriter extends Http2DataWriter, Closeable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Configuration {
        Http2FrameSizePolicy frameSizePolicy();

        Http2HeadersEncoder.Configuration headersConfiguration();
    }

    void close();

    Configuration configuration();

    ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise);

    ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf, ChannelPromise channelPromise);

    ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6, ChannelPromise channelPromise);

    ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5, ChannelPromise channelPromise);

    ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z5, long j6, ChannelPromise channelPromise);

    ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5, ChannelPromise channelPromise);

    ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8, ChannelPromise channelPromise);

    ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise);

    ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise);

    ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i6, int i7, ChannelPromise channelPromise);
}
