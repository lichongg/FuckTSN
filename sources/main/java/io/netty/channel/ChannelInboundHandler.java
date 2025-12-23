package io.netty.channel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ChannelInboundHandler extends ChannelHandler {
    void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception;

    void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception;

    void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception;

    void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception;

    void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception;
}
