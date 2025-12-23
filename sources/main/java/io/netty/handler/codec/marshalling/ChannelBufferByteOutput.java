package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteOutput;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf buffer;

    public void write(int i6) throws IOException {
        this.buffer.writeByte(i6);
    }

    ByteBuf getBuffer() {
        return this.buffer;
    }

    public void write(byte[] bArr) throws IOException {
        this.buffer.writeBytes(bArr);
    }

    ChannelBufferByteOutput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public void write(byte[] bArr, int i6, int i7) throws IOException {
        this.buffer.writeBytes(bArr, i6, i7);
    }

    public void close() throws IOException {
    }

    public void flush() throws IOException {
    }
}
