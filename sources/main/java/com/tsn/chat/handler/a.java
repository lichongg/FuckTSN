package com.tsn.chat.handler;

import com.tsn.chat.model.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.io.PrintStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends ChannelInboundHandlerAdapter {
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        com.tsn.chat.utils.b.f40740k = 1;
        com.tsn.chat.utils.b.f40730a.add(channelHandlerContext.channel());
        b3.a.a().m();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        ByteBuf byteBuf = (ByteBuf) obj;
        int readableBytes = byteBuf.readableBytes();
        byte[] bArr = new byte[readableBytes];
        if (readableBytes >= 4) {
            byteBuf.readByte();
            short readShort = byteBuf.readShort();
            byte readByte = byteBuf.readByte();
            byte[] bArr2 = new byte[readShort - 6];
            byteBuf.readBytes(bArr2);
            byteBuf.readBytes(new byte[2]);
            ResponseMessage responseMessage = new ResponseMessage(readByte, new String(bArr2));
            PrintStream printStream = System.out;
            responseMessage.toString();
            printStream.getClass();
            c3.a.a(responseMessage);
        }
        byte[] bArr3 = new byte[readableBytes];
        byteBuf.resetReaderIndex();
        for (int i6 = 0; i6 < readableBytes; i6++) {
            bArr3[i6] = byteBuf.readByte();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        PrintStream printStream = System.out;
        th.getMessage();
        printStream.getClass();
        com.tsn.chat.utils.b.f40731b = "";
        if (com.tsn.chat.utils.b.f40730a.size() > 0) {
            com.tsn.chat.utils.b.f40730a.close();
            com.tsn.chat.utils.b.f40730a.clear();
        }
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        System.out.getClass();
        com.tsn.chat.utils.b.f40731b = "";
        if (com.tsn.chat.utils.b.f40730a.size() > 0) {
            com.tsn.chat.utils.b.f40730a.close();
            com.tsn.chat.utils.b.f40730a.clear();
        }
        b3.a.a().k();
    }
}
