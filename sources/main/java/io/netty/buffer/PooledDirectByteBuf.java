package io.netty.buffer;

import io.netty.util.Recycler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final Recycler<PooledDirectByteBuf> RECYCLER = new Recycler<PooledDirectByteBuf>() { // from class: io.netty.buffer.PooledDirectByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledDirectByteBuf newObject(Recycler.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    };

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        _setShort(i6, ByteBufUtil.swapShort((short) i7));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkDstIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.setBytes(i7, this, i6, i8);
            return this;
        }
        ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i7, i8);
        for (ByteBuffer byteBuffer : nioBuffers) {
            int remaining = byteBuffer.remaining();
            getBytes(i6, byteBuffer);
            i6 += remaining;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i6, int i7) {
        checkDstIndex(i7, i6, bArr.length);
        _internalNioBuffer(this.readerIndex, i7, false).get(bArr, i6, i7);
        this.readerIndex += i7;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i6, byteBuf.array(), byteBuf.arrayOffset() + i7, i8);
            return this;
        }
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.getBytes(i7, this, i6, i8);
            return this;
        }
        ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i7, i8);
        for (ByteBuffer byteBuffer : nioBuffers) {
            int remaining = byteBuffer.remaining();
            setBytes(i6, byteBuffer);
            i6 += remaining;
        }
        return this;
    }

    private PooledDirectByteBuf(Recycler.Handle<PooledDirectByteBuf> handle, int i6) {
        super(handle, i6);
    }

    static PooledDirectByteBuf newInstance(int i6) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i6);
        return pooledDirectByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return ((ByteBuffer) this.memory).get(idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return ((ByteBuffer) this.memory).getInt(idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return ((ByteBuffer) this.memory).getLong(idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return ((ByteBuffer) this.memory).getShort(idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        ((ByteBuffer) this.memory).put(idx(i6), (byte) i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        ((ByteBuffer) this.memory).putInt(idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        ((ByteBuffer) this.memory).putLong(idx(i6), j6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        ((ByteBuffer) this.memory).putShort(idx(i6), (short) i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return ByteBufUtil.swapInt(_getInt(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return ByteBufUtil.swapLong(_getLong(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return ByteBufUtil.swapShort(_getShort(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        int idx = idx(i6);
        return (((ByteBuffer) this.memory).get(idx + 2) & 255) | ((((ByteBuffer) this.memory).get(idx) & 255) << 16) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        int idx = idx(i6);
        return ((((ByteBuffer) this.memory).get(idx + 2) & 255) << 16) | (((ByteBuffer) this.memory).get(idx) & 255) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        _setInt(i6, ByteBufUtil.swapInt(i7));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        _setLong(i6, ByteBufUtil.swapLong(j6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        int idx = idx(i6);
        ((ByteBuffer) this.memory).put(idx, (byte) (i7 >>> 16));
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i7 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        int idx = idx(i6);
        ((ByteBuffer) this.memory).put(idx, (byte) i7);
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i7 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) (i7 >>> 16));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        checkIndex(i6, i7);
        return alloc().directBuffer(i7, maxCapacity()).writeBytes(this, i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        byteBuffer.put(_internalNioBuffer(this.readerIndex, remaining, false));
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i6) throws IOException {
        checkReadableBytes(i6);
        getBytes(this.readerIndex, outputStream, i6, true);
        this.readerIndex += i6;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        checkDstIndex(i6, i8, i7, bArr.length);
        _internalNioBuffer(i6, i8, true).get(bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        checkSrcIndex(i6, i8, i7, bArr.length);
        _internalNioBuffer(i6, i8, false).put(bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        byteBuffer.put(duplicateInternalNioBuffer(i6, byteBuffer.remaining()));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i6, remaining);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int idx = idx(i6);
        internalNioBuffer.clear().position(idx).limit(idx + remaining);
        internalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        getBytes(i6, outputStream, i7, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i6, OutputStream outputStream, int i7, boolean z5) throws IOException {
        checkIndex(i6, i7);
        if (i7 == 0) {
            return;
        }
        ByteBufUtil.readBytes(alloc(), z5 ? internalNioBuffer() : ((ByteBuffer) this.memory).duplicate(), idx(i6), i7, outputStream);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        checkIndex(i6, i7);
        byte[] threadLocalTempArray = ByteBufUtil.threadLocalTempArray(i7);
        int read = inputStream.read(threadLocalTempArray, 0, i7);
        if (read <= 0) {
            return read;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(idx(i6));
        internalNioBuffer.put(threadLocalTempArray, 0, read);
        return read;
    }
}
