package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CompatibleObjectEncoder extends MessageToByteEncoder<Serializable> {
    private final int resetInterval;
    private int writtenObjects;

    public CompatibleObjectEncoder() {
        this(16);
    }

    public CompatibleObjectEncoder(int i6) {
        if (i6 >= 0) {
            this.resetInterval = i6;
            return;
        }
        throw new IllegalArgumentException("resetInterval: " + i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) throws Exception {
        ObjectOutputStream newObjectOutputStream = newObjectOutputStream(new ByteBufOutputStream(byteBuf));
        try {
            int i6 = this.resetInterval;
            if (i6 != 0) {
                int i7 = this.writtenObjects + 1;
                this.writtenObjects = i7;
                if (i7 % i6 == 0) {
                    newObjectOutputStream.reset();
                }
            }
            newObjectOutputStream.writeObject(serializable);
            newObjectOutputStream.flush();
            newObjectOutputStream.close();
        } catch (Throwable th) {
            newObjectOutputStream.close();
            throw th;
        }
    }

    protected ObjectOutputStream newObjectOutputStream(OutputStream outputStream) throws Exception {
        return new ObjectOutputStream(outputStream);
    }
}
