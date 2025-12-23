package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class WebSocketProtocolHandler extends MessageToMessageDecoder<WebSocketFrame> {
    private final boolean dropPongFrames;

    WebSocketProtocolHandler() {
        this(true);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    WebSocketProtocolHandler(boolean z5) {
        this.dropPongFrames = z5;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (webSocketFrame instanceof PingWebSocketFrame) {
            webSocketFrame.content().retain();
            channelHandlerContext.channel().writeAndFlush(new PongWebSocketFrame(webSocketFrame.content()));
            readIfNeeded(channelHandlerContext);
        } else if ((webSocketFrame instanceof PongWebSocketFrame) && this.dropPongFrames) {
            readIfNeeded(channelHandlerContext);
        } else {
            list.add(webSocketFrame.retain());
        }
    }

    private static void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        channelHandlerContext.fireExceptionCaught(th);
        channelHandlerContext.close();
    }
}
