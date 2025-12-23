package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2FrameListener {
    int onDataRead(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) throws Http2Exception;

    void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf) throws Http2Exception;

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) throws Http2Exception;

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception;

    void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception;

    void onPingRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception;

    void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5) throws Http2Exception;

    void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8) throws Http2Exception;

    void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i6, long j6) throws Http2Exception;

    void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception;

    void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception;

    void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception;

    void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i6, int i7) throws Http2Exception;
}
