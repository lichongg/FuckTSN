package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int i6) {
        return byteBuf.arrayOffset() + i6;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf abstractByteBuf, int i6) {
        return PlatformDependent.getInt(abstractByteBuf.array(), idx(abstractByteBuf, i6));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf abstractByteBuf, int i6) {
        return PlatformDependent.getLong(abstractByteBuf.array(), idx(abstractByteBuf, i6));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf abstractByteBuf, int i6) {
        return PlatformDependent.getShort(abstractByteBuf.array(), idx(abstractByteBuf, i6));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf abstractByteBuf, int i6, int i7) {
        PlatformDependent.putInt(abstractByteBuf.array(), idx(abstractByteBuf, i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setLong(AbstractByteBuf abstractByteBuf, int i6, long j6) {
        PlatformDependent.putLong(abstractByteBuf.array(), idx(abstractByteBuf, i6), j6);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf abstractByteBuf, int i6, short s5) {
        PlatformDependent.putShort(abstractByteBuf.array(), idx(abstractByteBuf, i6), s5);
    }
}
