package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChunkedStream implements ChunkedInput<ByteBuf> {
    static final int DEFAULT_CHUNK_SIZE = 8192;
    private final int chunkSize;
    private boolean closed;
    private final PushbackInputStream in;
    private long offset;

    public ChunkedStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.closed = true;
        this.in.close();
    }

    public ChunkedStream(InputStream inputStream, int i6) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        if (i6 > 0) {
            if (inputStream instanceof PushbackInputStream) {
                this.in = (PushbackInputStream) inputStream;
            } else {
                this.in = new PushbackInputStream(inputStream);
            }
            this.chunkSize = i6;
            return;
        }
        throw new IllegalArgumentException("chunkSize: " + i6 + " (expected: a positive integer)");
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        int read;
        if (this.closed || (read = this.in.read()) < 0) {
            return true;
        }
        this.in.unread(read);
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
        int min;
        if (isEndOfInput()) {
            return null;
        }
        if (this.in.available() <= 0) {
            min = this.chunkSize;
        } else {
            min = Math.min(this.chunkSize, this.in.available());
        }
        ByteBuf buffer = byteBufAllocator.buffer(min);
        try {
            this.offset += buffer.writeBytes(this.in, min);
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }
}
