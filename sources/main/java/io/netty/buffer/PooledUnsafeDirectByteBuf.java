package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PooledUnsafeDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final Recycler<PooledUnsafeDirectByteBuf> RECYCLER = new Recycler<PooledUnsafeDirectByteBuf>() { // from class: io.netty.buffer.PooledUnsafeDirectByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledUnsafeDirectByteBuf newObject(Recycler.Handle<PooledUnsafeDirectByteBuf> handle) {
            return new PooledUnsafeDirectByteBuf(handle, 0);
        }
    };
    private long memoryAddress;

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        UnsafeByteBufUtil.getBytes(this, addr(i6), i6, byteBuf, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7, int i8) {
        UnsafeByteBufUtil.setBytes(this, addr(i6), i6, byteBuf, i7, i8);
        return this;
    }

    private PooledUnsafeDirectByteBuf(Recycler.Handle<PooledUnsafeDirectByteBuf> handle, int i6) {
        super(handle, i6);
    }

    private long addr(int i6) {
        return this.memoryAddress + i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initMemoryAddress() {
        this.memoryAddress = PlatformDependent.directBufferAddress((ByteBuffer) this.memory) + this.offset;
    }

    static PooledUnsafeDirectByteBuf newInstance(int i6) {
        PooledUnsafeDirectByteBuf pooledUnsafeDirectByteBuf = RECYCLER.get();
        pooledUnsafeDirectByteBuf.reuse(i6);
        return pooledUnsafeDirectByteBuf;
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
    public ByteBuf getBytes(int i6, byte[] bArr, int i7, int i8) {
        UnsafeByteBufUtil.getBytes(this, addr(i6), i6, bArr, i7, i8);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr, int i7, int i8) {
        UnsafeByteBufUtil.setBytes(this, addr(i6), i6, bArr, i7, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return UnsafeByteBufUtil.getByte(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return UnsafeByteBufUtil.getInt(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return UnsafeByteBufUtil.getIntLE(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return UnsafeByteBufUtil.getLong(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return UnsafeByteBufUtil.getLongLE(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return UnsafeByteBufUtil.getShort(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return UnsafeByteBufUtil.getShortLE(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(addr(i6));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        UnsafeByteBufUtil.setByte(addr(i6), (byte) i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        UnsafeByteBufUtil.setInt(addr(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        UnsafeByteBufUtil.setIntLE(addr(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        UnsafeByteBufUtil.setLong(addr(i6), j6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        UnsafeByteBufUtil.setLongLE(addr(i6), j6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        UnsafeByteBufUtil.setMedium(addr(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        UnsafeByteBufUtil.setMediumLE(addr(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        UnsafeByteBufUtil.setShort(addr(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        UnsafeByteBufUtil.setShortLE(addr(i6), i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i6, int i7) {
        return UnsafeByteBufUtil.copy(this, addr(i6), i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.getBytes(this, addr(i6), i6, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.PooledByteBuf
    void init(PoolChunk<ByteBuffer> poolChunk, ByteBuffer byteBuffer, long j6, int i6, int i7, int i8, PoolThreadCache poolThreadCache) {
        super.init(poolChunk, byteBuffer, j6, i6, i7, i8, poolThreadCache);
        initMemoryAddress();
    }

    @Override // io.netty.buffer.PooledByteBuf
    void initUnpooled(PoolChunk<ByteBuffer> poolChunk, int i6) {
        super.initUnpooled(poolChunk, i6);
        initMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes(this, addr(i6), i6, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i6, int i7) {
        checkIndex(i6, i7);
        UnsafeByteBufUtil.setZero(addr(i6), i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i6) {
        ensureWritable(i6);
        int i7 = this.writerIndex;
        UnsafeByteBufUtil.setZero(addr(i7), i6);
        this.writerIndex = i7 + i6;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, OutputStream outputStream, int i7) throws IOException {
        UnsafeByteBufUtil.getBytes(this, addr(i6), i6, outputStream, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i6, InputStream inputStream, int i7) throws IOException {
        return UnsafeByteBufUtil.setBytes(this, addr(i6), i6, inputStream, i7);
    }
}
