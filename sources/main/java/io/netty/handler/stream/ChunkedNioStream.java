package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChunkedNioStream implements ChunkedInput<ByteBuf> {
    private final ByteBuffer byteBuffer;
    private final int chunkSize;
    private final ReadableByteChannel in;
    private long offset;

    public ChunkedNioStream(ReadableByteChannel readableByteChannel) {
        this(readableByteChannel, 8192);
    }

    public ChunkedNioStream(ReadableByteChannel readableByteChannel, int i6) {
        if (readableByteChannel == null) {
            throw new NullPointerException("in");
        }
        if (i6 > 0) {
            this.in = readableByteChannel;
            this.offset = 0L;
            this.chunkSize = i6;
            this.byteBuffer = ByteBuffer.allocate(i6);
            return;
        }
        throw new IllegalArgumentException("chunkSize: " + i6 + " (expected: a positive integer)");
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.in.close();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        int read;
        if (this.byteBuffer.position() > 0) {
            return false;
        }
        if (!this.in.isOpen() || (read = this.in.read(this.byteBuffer)) < 0) {
            return true;
        }
        this.offset += read;
        return false;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return -1L;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset;
    }

    public long transferredBytes() {
        return this.offset;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        if (isEndOfInput()) {
            return null;
        }
        int position = this.byteBuffer.position();
        do {
            int read = this.in.read(this.byteBuffer);
            if (read < 0) {
                break;
            }
            position += read;
            this.offset += read;
        } while (position != this.chunkSize);
        this.byteBuffer.flip();
        ByteBuf buffer = byteBufAllocator.buffer(this.byteBuffer.remaining());
        try {
            buffer.writeBytes(this.byteBuffer);
            this.byteBuffer.clear();
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }
}
