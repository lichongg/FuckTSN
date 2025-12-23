package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        checkIndex(i6, 4);
        return _getInt(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        checkIndex(i6, 4);
        return _getIntLE(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        checkIndex(i6, 2);
        return _getShort(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        checkIndex(i6, 2);
        return _getShortLE(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        checkIndex(i6, 3);
        return _getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        checkIndex(i6, 3);
        return _getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i6, int i7) {
        checkIndex(i6, 4);
        _setInt(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        checkIndex(i6, 4);
        _setIntLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        checkIndex(i6, 3);
        _setMedium(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        checkIndex(i6, 3);
        _setMediumLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        checkIndex(i6, 2);
        _setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        checkIndex(i6, 2);
        _setShortLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return UnsafeByteBufUtil.getByte(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return UnsafeByteBufUtil.getInt(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return UnsafeByteBufUtil.getIntLE(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return UnsafeByteBufUtil.getLong(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return UnsafeByteBufUtil.getLongLE(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return UnsafeByteBufUtil.getShort(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return UnsafeByteBufUtil.getShortLE(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        UnsafeByteBufUtil.setByte(this.array, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        UnsafeByteBufUtil.setInt(this.array, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        UnsafeByteBufUtil.setIntLE(this.array, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        UnsafeByteBufUtil.setLong(this.array, i6, j6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        UnsafeByteBufUtil.setLongLE(this.array, i6, j6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        UnsafeByteBufUtil.setMedium(this.array, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        UnsafeByteBufUtil.setMediumLE(this.array, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        UnsafeByteBufUtil.setShort(this.array, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        UnsafeByteBufUtil.setShortLE(this.array, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        checkIndex(i6, 8);
        return _getLong(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        checkIndex(i6, 8);
        return _getLongLE(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i6, long j6) {
        checkIndex(i6, 8);
        _setLong(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        checkIndex(i6, 8);
        _setLongLE(i6, j6);
        return this;
    }

    public UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator, int i6, int i7) {
        super(byteBufAllocator, i6, i7);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf
    protected byte[] allocateArray(int i6) {
        return PlatformDependent.allocateUninitializedArray(i6);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        checkIndex(i6);
        return _getByte(i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    @Deprecated
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i6, int i7) {
        checkIndex(i6);
        _setByte(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i6, int i7) {
        if (PlatformDependent.javaVersion() >= 7) {
            checkIndex(i6, i7);
            UnsafeByteBufUtil.setZero(this.array, i6, i7);
            return this;
        }
        return super.setZero(i6, i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i6) {
        if (PlatformDependent.javaVersion() >= 7) {
            ensureWritable(i6);
            int i7 = this.writerIndex;
            UnsafeByteBufUtil.setZero(this.array, i7, i6);
            this.writerIndex = i7 + i6;
            return this;
        }
        return super.writeZero(i6);
    }
}
