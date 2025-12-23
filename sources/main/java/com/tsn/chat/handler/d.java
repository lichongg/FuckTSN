package com.tsn.chat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import java.io.PrintStream;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends ChannelInitializer<SocketChannel> {
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        PrintStream printStream = System.out;
        Objects.toString(obj);
        printStream.getClass();
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.getClass();
        super.channelReadComplete(channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.ChannelInitializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("encoder", new c());
        pipeline.addLast("decoder", new b());
        pipeline.addLast("handler", new a());
    }
}
