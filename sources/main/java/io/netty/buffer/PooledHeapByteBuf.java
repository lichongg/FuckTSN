package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class PooledHeapByteBuf extends PooledByteBuf<byte[]> {
    private static final Recycler<PooledHeapByteBuf> RECYCLER = new Recycler<PooledHeapByteBuf>() { // from class: io.netty.buffer.PooledHeapByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledHeapByteBuf newObject(Recycler.Handle<PooledHeapByteBuf> handle) {
            return new PooledHeapByteBuf(handle, 0);
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkDstIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory((byte[]) this.memory, idx(i6), i7 + byteBuf.memoryAddress(), i8);
            return this;
        }
        if (byteBuf.hasArray()) {
            getBytes(i6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        byteBuf.setBytes(i7, (byte[]) this.memory, idx(i6), i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + i7, (byte[]) this.memory, idx(i6), i8);
            return this;
        }
        if (byteBuf.hasArray()) {
            setBytes(i6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        byteBuf.getBytes(i7, (byte[]) this.memory, idx(i6), i8);
        return this;
    }

    static PooledHeapByteBuf newInstance(int i6) {
        PooledHeapByteBuf pooledHeapByteBuf = RECYCLER.get();
        pooledHeapByteBuf.reuse(i6);
        return pooledHeapByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return HeapByteBufUtil.getByte((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return HeapByteBufUtil.getInt((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return HeapByteBufUtil.getIntLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return HeapByteBufUtil.getLong((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return HeapByteBufUtil.getLongLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return HeapByteBufUtil.getShort((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return HeapByteBufUtil.getShortLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return HeapByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return HeapByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        HeapByteBufUtil.setByte((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        HeapByteBufUtil.setInt((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        HeapByteBufUtil.setIntLE((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        HeapByteBufUtil.setLong((byte[]) this.memory, idx(i6), j6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        HeapByteBufUtil.setLongLE((byte[]) this.memory, idx(i6), j6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        HeapByteBufUtil.setMedium((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        HeapByteBufUtil.setMediumLE((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        HeapByteBufUtil.setShort((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        HeapByteBufUtil.setShortLE((byte[]) this.memory, idx(i6), i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.offset;
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer newInternalNioBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    PooledHeapByteBuf(Recycler.Handle<? extends PooledHeapByteBuf> handle, int i6) {
        super(handle, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        ensureAccessible();
        return (byte[]) this.memory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int i6, int i7) {
        checkIndex(i6, i7);
        return alloc().heapBuffer(i7, maxCapacity()).writeBytes((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledByteBuf
    final ByteBuffer duplicateInternalNioBuffer(int i6, int i7) {
        checkIndex(i6, i7);
        return ByteBuffer.wrap((byte[]) this.memory, idx(i6), i7).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkDstIndex(i6, i8, i7, bArr.length);
        System.arraycopy(this.memory, idx(i6), bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, bArr.length);
        System.arraycopy(bArr, i7, this.memory, idx(i6), i8);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i6, remaining);
        byteBuffer.put((byte[]) this.memory, idx(i6), remaining);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i6, remaining);
        byteBuffer.get((byte[]) this.memory, idx(i6), remaining);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        checkIndex(i6, i7);
        outputStream.write((byte[]) this.memory, idx(i6), i7);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        checkIndex(i6, i7);
        return inputStream.read((byte[]) this.memory, idx(i6), i7);
    }
}
