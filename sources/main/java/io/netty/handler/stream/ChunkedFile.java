package io.netty.handler.stream;

import com.kuaishou.weapon.p0.t;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChunkedFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final RandomAccessFile file;
    private long offset;
    private final long startOffset;

    public ChunkedFile(File file) throws IOException {
        this(file, 8192);
    }

    public ChunkedFile(File file, int i6) throws IOException {
        this(new RandomAccessFile(file, t.f36150k), i6);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.file.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.file.getChannel().isOpen();
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

    public ChunkedFile(RandomAccessFile randomAccessFile) throws IOException {
        this(randomAccessFile, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, int i6) throws IOException {
        this(randomAccessFile, 0L, randomAccessFile.length(), i6);
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
        ByteBuf heapBuffer = byteBufAllocator.heapBuffer(min);
        try {
            this.file.readFully(heapBuffer.array(), heapBuffer.arrayOffset(), min);
            heapBuffer.writerIndex(min);
            this.offset = j6 + min;
            return heapBuffer;
        } catch (Throwable th) {
            heapBuffer.release();
            throw th;
        }
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, long j6, long j7, int i6) throws IOException {
        if (randomAccessFile == null) {
            throw new NullPointerException(b.f50156c);
        }
        if (j6 < 0) {
            throw new IllegalArgumentException("offset: " + j6 + " (expected: 0 or greater)");
        }
        if (j7 < 0) {
            throw new IllegalArgumentException("length: " + j7 + " (expected: 0 or greater)");
        }
        if (i6 > 0) {
            this.file = randomAccessFile;
            this.startOffset = j6;
            this.offset = j6;
            this.endOffset = j7 + j6;
            this.chunkSize = i6;
            randomAccessFile.seek(j6);
            return;
        }
        throw new IllegalArgumentException("chunkSize: " + i6 + " (expected: a positive integer)");
    }
}
