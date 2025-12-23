package io.netty.channel;

import io.netty.channel.ChannelHandlerMask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {
    @ChannelHandlerMask.Skip
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelActive();
    }

    @ChannelHandlerMask.Skip
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelInactive();
    }

    @ChannelHandlerMask.Skip
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        channelHandlerContext.fireChannelRead(obj);
    }

    @ChannelHandlerMask.Skip
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelRegistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelUnregistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        channelHandlerContext.fireExceptionCaught(th);
    }

    @ChannelHandlerMask.Skip
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
