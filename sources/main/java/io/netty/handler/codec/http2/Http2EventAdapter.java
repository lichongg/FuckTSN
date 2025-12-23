package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2EventAdapter implements Http2Connection.Listener, Http2FrameListener {
    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) throws Http2Exception {
        return byteBuf.readableBytes() + i7;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamActive(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamAdded(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamClosed(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamHalfClosed(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamRemoved(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPingRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onGoAwayReceived(int i6, long j6, ByteBuf byteBuf) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onGoAwaySent(int i6, long j6, ByteBuf byteBuf) {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i6, long j6) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i6, int i7) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8) throws Http2Exception {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
    }
}
