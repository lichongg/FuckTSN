package com.tsn.chat.handler;

import com.tsn.chat.model.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.PrintStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends MessageToByteEncoder<Object> {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, ByteBuf byteBuf) throws Exception {
        RequestMessage requestMessage = (RequestMessage) obj;
        PrintStream printStream = System.out;
        requestMessage.toString();
        printStream.getClass();
        byteBuf.writeByte(requestMessage.getHeader());
        byteBuf.writeShort(requestMessage.getLength());
        byteBuf.writeByte(requestMessage.getControlType());
        byteBuf.writeBytes(requestMessage.getDatas().getBytes());
        byteBuf.writeShort(0);
    }
}
