package io.netty.buffer;

import io.netty.util.Recycler;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class PooledByteBuf<T> extends AbstractReferenceCountedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ByteBufAllocator allocator;
    PoolThreadCache cache;
    protected PoolChunk<T> chunk;
    protected long handle;
    protected int length;
    int maxLength;
    protected T memory;
    protected int offset;
    private final Recycler.Handle<PooledByteBuf<T>> recyclerHandle;
    ByteBuffer tmpNioBuf;

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.length;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i6, GatheringByteChannel gatheringByteChannel, int i7) throws IOException {
        return gatheringByteChannel.write(duplicateInternalNioBuffer(i6, i7));
    }

    protected final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer newInternalNioBuffer = newInternalNioBuffer(this.memory);
        this.tmpNioBuf = newInternalNioBuffer;
        return newInternalNioBuffer;
    }

    protected abstract ByteBuffer newInternalNioBuffer(T t5);

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException {
        checkReadableBytes(i6);
        int write = gatheringByteChannel.write(_internalNioBuffer(this.readerIndex, i6, false));
        this.readerIndex += write;
        return write;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice() {
        int readerIndex = readerIndex();
        return retainedSlice(readerIndex, writerIndex() - readerIndex);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i6, ScatteringByteChannel scatteringByteChannel, int i7) throws IOException {
        try {
            return scatteringByteChannel.read(internalNioBuffer(i6, i7));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    private void init0(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j6, int i6, int i7, int i8, PoolThreadCache poolThreadCache) {
        this.chunk = poolChunk;
        this.memory = poolChunk.memory;
        this.tmpNioBuf = byteBuffer;
        this.allocator = poolChunk.arena.parent;
        this.cache = poolThreadCache;
        this.handle = j6;
        this.offset = i6;
        this.length = i7;
        this.maxLength = i8;
    }

    private void recycle() {
        this.recyclerHandle.recycle(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i6) {
        if (i6 == this.length) {
            ensureAccessible();
            return this;
        }
        checkNewCapacity(i6);
        PoolChunk<T> poolChunk = this.chunk;
        if (!poolChunk.unpooled) {
            if (i6 <= this.length) {
                int i7 = this.maxLength;
                if (i6 > (i7 >>> 1) && (i7 > 512 || i6 > i7 - 16)) {
                    this.length = i6;
                    setIndex(Math.min(readerIndex(), i6), Math.min(writerIndex(), i6));
                    return this;
                }
            } else if (i6 <= this.maxLength) {
                this.length = i6;
                return this;
            }
        }
        poolChunk.arena.reallocate(this, i6, true);
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        long j6 = this.handle;
        if (j6 >= 0) {
            this.handle = -1L;
            this.memory = null;
            PoolChunk<T> poolChunk = this.chunk;
            poolChunk.arena.free(poolChunk, this.tmpNioBuf, j6, this.maxLength, this.cache);
            this.tmpNioBuf = null;
            this.chunk = null;
            recycle();
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        return fileChannel.write(duplicateInternalNioBuffer(i6, i7), j6);
    }

    protected final int idx(int i6) {
        return this.offset + i6;
    }

    void initUnpooled(PoolChunk<T> poolChunk, int i6) {
        init0(poolChunk, null, 0L, poolChunk.offset, i6, i6, null);
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return Math.min(this.maxLength, maxCapacity()) - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i6, FileChannel fileChannel, long j6, int i7) throws IOException {
        try {
            return fileChannel.read(internalNioBuffer(i6, i7), j6);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected PooledByteBuf(Recycler.Handle<? extends PooledByteBuf<T>> handle, int i6) {
        super(i6);
        this.recyclerHandle = handle;
    }

    final ByteBuffer _internalNioBuffer(int i6, int i7, boolean z5) {
        ByteBuffer internalNioBuffer;
        int idx = idx(i6);
        if (z5) {
            internalNioBuffer = newInternalNioBuffer(this.memory);
        } else {
            internalNioBuffer = internalNioBuffer();
        }
        internalNioBuffer.limit(i7 + idx).position(idx);
        return internalNioBuffer;
    }

    ByteBuffer duplicateInternalNioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        return _internalNioBuffer(i6, i7, true);
    }

    void init(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j6, int i6, int i7, int i8, PoolThreadCache poolThreadCache) {
        init0(poolChunk, byteBuffer, j6, i6, i7, i8, poolThreadCache);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        return _internalNioBuffer(i6, i7, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i6, int i7) {
        return duplicateInternalNioBuffer(i6, i7).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i6, int i7) {
        return new ByteBuffer[]{nioBuffer(i6, i7)};
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this, this, readerIndex(), writerIndex());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice(int i6, int i7) {
        return PooledSlicedByteBuf.newInstance(this, this, i6, i7);
    }

    final void reuse(int i6) {
        maxCapacity(i6);
        resetRefCnt();
        setIndex0(0, 0);
        discardMarks();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        checkReadableBytes(i6);
        int write = fileChannel.write(_internalNioBuffer(this.readerIndex, i6, false), j6);
        this.readerIndex += write;
        return write;
    }
}
