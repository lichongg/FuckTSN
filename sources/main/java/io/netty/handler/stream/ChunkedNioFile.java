package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChunkedNioFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final FileChannel in;
    private long offset;
    private final long startOffset;

    public ChunkedNioFile(File file) throws IOException {
        this(new FileInputStream(file).getChannel());
    }

    public ChunkedNioFile(File file, int i6) throws IOException {
        this(new FileInputStream(file).getChannel(), i6);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.in.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.in.isOpen();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }

    public long startOffset() {
        return this.startOffset;
    }

    public ChunkedNioFile(FileChannel fileChannel) throws IOException {
        this(fileChannel, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedNioFile(FileChannel fileChannel, int i6) throws IOException {
        this(fileChannel, 0L, fileChannel.size(), i6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        long j6 = this.offset;
        long j7 = this.endOffset;
        if (j6 >= j7) {
            return null;
        }
        int min = (int) Math.min(this.chunkSize, j7 - j6);
        ByteBuf buffer = byteBufAllocator.buffer(min);
        int i6 = 0;
        do {
            try {
                int writeBytes = buffer.writeBytes(this.in, min - i6);
                if (writeBytes < 0) {
                    break;
                }
                i6 += writeBytes;
            } catch (Throwable th) {
                buffer.release();
                throw th;
            }
        } while (i6 != min);
        this.offset += i6;
        return buffer;
    }

    public ChunkedNioFile(FileChannel fileChannel, long j6, long j7, int i6) throws IOException {
        if (fileChannel == null) {
            throw new NullPointerException("in");
        }
        if (j6 < 0) {
            throw new IllegalArgumentException("offset: " + j6 + " (expected: 0 or greater)");
        }
        if (j7 < 0) {
            throw new IllegalArgumentException("length: " + j7 + " (expected: 0 or greater)");
        }
        if (i6 > 0) {
            if (j6 != 0) {
                fileChannel.position(j6);
            }
            this.in = fileChannel;
            this.chunkSize = i6;
            this.startOffset = j6;
            this.offset = j6;
            this.endOffset = j6 + j7;
            return;
        }
        throw new IllegalArgumentException("chunkSize: " + i6 + " (expected: a positive integer)");
    }
}
