package io.netty.handler.codec.http2;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2FrameListenerDecorator implements Http2FrameListener {
    protected final Http2FrameListener listener;

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception {
        this.listener.onHeadersRead(channelHandlerContext, i6, http2Headers, i7, z5);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) throws Http2Exception {
        return this.listener.onDataRead(channelHandlerContext, i6, byteBuf, i7, z5);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i6, long j6, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onGoAwayRead(channelHandlerContext, i6, j6, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) throws Http2Exception {
        this.listener.onHeadersRead(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
        this.listener.onPingAckRead(channelHandlerContext, j6);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPingRead(ChannelHandlerContext channelHandlerContext, long j6) throws Http2Exception {
        this.listener.onPingRead(channelHandlerContext, j6);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, short s5, boolean z5) throws Http2Exception {
        this.listener.onPriorityRead(channelHandlerContext, i6, i7, s5, z5);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8) throws Http2Exception {
        this.listener.onPushPromiseRead(channelHandlerContext, i6, i7, http2Headers, i8);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i6, long j6) throws Http2Exception {
        this.listener.onRstStreamRead(channelHandlerContext, i6, j6);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
        this.listener.onSettingsAckRead(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
        this.listener.onSettingsRead(channelHandlerContext, http2Settings);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b6, int i6, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onUnknownFrame(channelHandlerContext, b6, i6, http2Flags, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i6, int i7) throws Http2Exception {
        this.listener.onWindowUpdateRead(channelHandlerContext, i6, i7);
    }

    public Http2FrameListenerDecorator(Http2FrameListener http2FrameListener) {
        this.listener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }
}
