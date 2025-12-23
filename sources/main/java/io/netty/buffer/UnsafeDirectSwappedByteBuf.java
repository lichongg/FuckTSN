package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class UnsafeDirectSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    UnsafeDirectSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static long addr(AbstractByteBuf abstractByteBuf, int i6) {
        return abstractByteBuf.memoryAddress() + i6;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf abstractByteBuf, int i6) {
        return PlatformDependent.getInt(addr(abstractByteBuf, i6));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf abstractByteBuf, int i6) {
        return PlatformDependent.getLong(addr(abstractByteBuf, i6));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf abstractByteBuf, int i6) {
        return PlatformDependent.getShort(addr(abstractByteBuf, i6));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf abstractByteBuf, int i6, int i7) {
        PlatformDependent.putInt(addr(abstractByteBuf, i6), i7);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setLong(AbstractByteBuf abstractByteBuf, int i6, long j6) {
        PlatformDependent.putLong(addr(abstractByteBuf, i6), j6);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf abstractByteBuf, int i6, short s5) {
        PlatformDependent.putShort(addr(abstractByteBuf, i6), s5);
    }
}
