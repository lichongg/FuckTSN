package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PooledUnsafeHeapByteBuf extends PooledHeapByteBuf {
    private static final Recycler<PooledUnsafeHeapByteBuf> RECYCLER = new Recycler<PooledUnsafeHeapByteBuf>() { // from class: io.netty.buffer.PooledUnsafeHeapByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledUnsafeHeapByteBuf newObject(Recycler.Handle<PooledUnsafeHeapByteBuf> handle) {
            return new PooledUnsafeHeapByteBuf(handle, 0);
        }
    };

    private PooledUnsafeHeapByteBuf(Recycler.Handle<PooledUnsafeHeapByteBuf> handle, int i6) {
        super(handle, i6);
    }

    static PooledUnsafeHeapByteBuf newUnsafeInstance(int i6) {
        PooledUnsafeHeapByteBuf pooledUnsafeHeapByteBuf = RECYCLER.get();
        pooledUnsafeHeapByteBuf.reuse(i6);
        return pooledUnsafeHeapByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i6) {
        return UnsafeByteBufUtil.getByte((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i6) {
        return UnsafeByteBufUtil.getInt((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i6) {
        return UnsafeByteBufUtil.getIntLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i6) {
        return UnsafeByteBufUtil.getLong((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i6) {
        return UnsafeByteBufUtil.getLongLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i6) {
        return UnsafeByteBufUtil.getShort((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i6) {
        return UnsafeByteBufUtil.getShortLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i6) {
        return UnsafeByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i6) {
        return UnsafeByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i6, int i7) {
        UnsafeByteBufUtil.setByte((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i6, int i7) {
        UnsafeByteBufUtil.setInt((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i6, int i7) {
        UnsafeByteBufUtil.setIntLE((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i6, long j6) {
        UnsafeByteBufUtil.setLong((byte[]) this.memory, idx(i6), j6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i6, long j6) {
        UnsafeByteBufUtil.setLongLE((byte[]) this.memory, idx(i6), j6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i6, int i7) {
        UnsafeByteBufUtil.setMedium((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i6, int i7) {
        UnsafeByteBufUtil.setMediumLE((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i6, int i7) {
        UnsafeByteBufUtil.setShort((byte[]) this.memory, idx(i6), i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i6, int i7) {
        UnsafeByteBufUtil.setShortLE((byte[]) this.memory, idx(i6), i7);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    @Deprecated
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i6, int i7) {
        if (PlatformDependent.javaVersion() >= 7) {
            checkIndex(i6, i7);
            UnsafeByteBufUtil.setZero((byte[]) this.memory, idx(i6), i7);
            return this;
        }
        return super.setZero(i6, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i6) {
        if (PlatformDependent.javaVersion() >= 7) {
            ensureWritable(i6);
            int i7 = this.writerIndex;
            UnsafeByteBufUtil.setZero((byte[]) this.memory, idx(i7), i6);
            this.writerIndex = i7 + i6;
            return this;
        }
        return super.writeZero(i6);
    }
}
