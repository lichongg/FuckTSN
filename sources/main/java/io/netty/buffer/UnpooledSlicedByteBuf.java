package io.netty.buffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class UnpooledSlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }

    UnpooledSlicedByteBuf(AbstractByteBuf abstractByteBuf, int i6, int i7) {
        super(abstractByteBuf, i6, i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return unwrap()._getByte(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return unwrap()._getInt(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return unwrap()._getIntLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return unwrap()._getLong(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return unwrap()._getLongLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return unwrap()._getShort(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return unwrap()._getShortLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return unwrap()._getUnsignedMedium(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return unwrap()._getUnsignedMediumLE(idx(i6));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        unwrap()._setByte(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        unwrap()._setInt(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        unwrap()._setIntLE(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        unwrap()._setLong(idx(i6), j6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        unwrap()._setLongLE(idx(i6), j6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        unwrap()._setMedium(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        unwrap()._setMediumLE(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        unwrap()._setShort(idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        unwrap()._setShortLE(idx(i6), i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }
}
