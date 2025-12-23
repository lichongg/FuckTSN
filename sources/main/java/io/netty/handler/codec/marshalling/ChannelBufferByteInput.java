package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jboss.marshalling.ByteInput;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class ChannelBufferByteInput implements ByteInput {
    private final ByteBuf buffer;

    public int read() throws IOException {
        if (this.buffer.isReadable()) {
            return this.buffer.readByte() & 255;
        }
        return -1;
    }

    public int available() throws IOException {
        return this.buffer.readableBytes();
    }

    public long skip(long j6) throws IOException {
        long readableBytes = this.buffer.readableBytes();
        if (readableBytes < j6) {
            j6 = readableBytes;
        }
        this.buffer.readerIndex((int) (r0.readerIndex() + j6));
        return j6;
    }

    ChannelBufferByteInput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        int min = Math.min(available, i7);
        this.buffer.readBytes(bArr, i6, min);
        return min;
    }

    public void close() throws IOException {
    }
}
