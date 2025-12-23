package io.netty.buffer;

import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class UnreleasableByteBuf extends WrappedByteBuf {
    private SwappedByteBuf swappedBuf;

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        return false;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return this;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return slice();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return new UnreleasableByteBuf(this.buf.slice());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    UnreleasableByteBuf(ByteBuf byteBuf) {
        super(byteBuf instanceof UnreleasableByteBuf ? byteBuf.unwrap() : byteBuf);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.buf.isReadOnly() ? this : new UnreleasableByteBuf(this.buf.asReadOnly());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return new UnreleasableByteBuf(this.buf.duplicate());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf = this.swappedBuf;
        if (swappedByteBuf != null) {
            return swappedByteBuf;
        }
        SwappedByteBuf swappedByteBuf2 = new SwappedByteBuf(this);
        this.swappedBuf = swappedByteBuf2;
        return swappedByteBuf2;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        return new UnreleasableByteBuf(this.buf.readSlice(i6));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return false;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i6) {
        return this;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        return slice(i6, i7);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        return new UnreleasableByteBuf(this.buf.slice(i6, i7));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        return readSlice(i6);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return duplicate();
    }
}
