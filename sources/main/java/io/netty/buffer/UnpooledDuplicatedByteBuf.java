package io.netty.buffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class UnpooledDuplicatedByteBuf extends DuplicatedByteBuf {
    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.ByteBuf
    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }

    UnpooledDuplicatedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return unwrap()._getByte(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return unwrap()._getInt(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return unwrap()._getIntLE(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return unwrap()._getLong(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return unwrap()._getLongLE(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return unwrap()._getShort(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return unwrap()._getShortLE(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return unwrap()._getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return unwrap()._getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        unwrap()._setByte(i6, i7);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        unwrap()._setInt(i6, i7);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        unwrap()._setIntLE(i6, i7);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        unwrap()._setLong(i6, j6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        unwrap()._setLongLE(i6, j6);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        unwrap()._setMedium(i6, i7);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        unwrap()._setMediumLE(i6, i7);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        unwrap()._setShort(i6, i7);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        unwrap()._setShortLE(i6, i7);
    }
}
