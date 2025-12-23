package com.tsn.chat.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends ByteToMessageDecoder {
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        byteBuf.markReaderIndex();
        byteBuf.readByte();
        short readShort = byteBuf.readShort();
        byteBuf.resetReaderIndex();
        if (readableBytes < readShort) {
            return;
        }
        list.add(byteBuf.readBytes(readShort));
    }
}
