package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class ObjectEncoder extends MessageToByteEncoder<Serializable> {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) throws Exception {
        CompactObjectOutputStream compactObjectOutputStream;
        int writerIndex = byteBuf.writerIndex();
        ByteBufOutputStream byteBufOutputStream = new ByteBufOutputStream(byteBuf);
        CompactObjectOutputStream compactObjectOutputStream2 = null;
        try {
            byteBufOutputStream.write(LENGTH_PLACEHOLDER);
            compactObjectOutputStream = new CompactObjectOutputStream(byteBufOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            compactObjectOutputStream.writeObject(serializable);
            compactObjectOutputStream.flush();
            compactObjectOutputStream.close();
            byteBuf.setInt(writerIndex, (byteBuf.writerIndex() - writerIndex) - 4);
        } catch (Throwable th2) {
            th = th2;
            compactObjectOutputStream2 = compactObjectOutputStream;
            if (compactObjectOutputStream2 != null) {
                compactObjectOutputStream2.close();
            } else {
                byteBufOutputStream.close();
            }
            throw th;
        }
    }
}
