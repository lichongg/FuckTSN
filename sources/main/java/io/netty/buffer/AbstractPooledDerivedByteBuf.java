package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.ReferenceCounted;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class AbstractPooledDerivedByteBuf extends AbstractReferenceCountedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ByteBuf parent;
    private final Recycler.Handle<AbstractPooledDerivedByteBuf> recyclerHandle;
    private AbstractByteBuf rootParent;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PooledNonRetainedDuplicateByteBuf extends UnpooledDuplicatedByteBuf {
        private final ReferenceCounted referenceCountDelegate;

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        boolean release0() {
            return this.referenceCountDelegate.release();
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice() {
            return retainedSlice(readerIndex(), capacity());
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        boolean release0(int i6) {
            return this.referenceCountDelegate.release(i6);
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0(int i6) {
            this.referenceCountDelegate.retain(i6);
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice(int i6, int i7) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, i6, i7);
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0(Object obj) {
            this.referenceCountDelegate.touch(obj);
            return this;
        }

        PooledNonRetainedDuplicateByteBuf(ReferenceCounted referenceCounted, AbstractByteBuf abstractByteBuf) {
            super(abstractByteBuf);
            this.referenceCountDelegate = referenceCounted;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, this);
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, readerIndex(), writerIndex());
        }

        @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf slice(int i6, int i7) {
            checkIndex(i6, i7);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), i6, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PooledNonRetainedSlicedByteBuf extends UnpooledSlicedByteBuf {
        private final ReferenceCounted referenceCountDelegate;

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        boolean release0() {
            return this.referenceCountDelegate.release();
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice() {
            return retainedSlice(0, capacity());
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        boolean release0(int i6) {
            return this.referenceCountDelegate.release(i6);
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0(int i6) {
            this.referenceCountDelegate.retain(i6);
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice(int i6, int i7) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, idx(i6), i7);
        }

        @Override // io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0(Object obj) {
            this.referenceCountDelegate.touch(obj);
            return this;
        }

        PooledNonRetainedSlicedByteBuf(ReferenceCounted referenceCounted, AbstractByteBuf abstractByteBuf, int i6, int i7) {
            super(abstractByteBuf, i6, i7);
            this.referenceCountDelegate = referenceCounted;
        }

        @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, unwrap()).setIndex(idx(readerIndex()), idx(writerIndex()));
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
        }

        @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf slice(int i6, int i7) {
            checkIndex(i6, i7);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), idx(i6), i7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    AbstractPooledDerivedByteBuf(Recycler.Handle<? extends AbstractPooledDerivedByteBuf> handle) {
        super(0);
        this.recyclerHandle = handle;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        ByteBuf byteBuf = this.parent;
        this.recyclerHandle.recycle(this);
        byteBuf.release();
    }

    final void parent(ByteBuf byteBuf) {
        this.parent = byteBuf;
    }

    @Override // io.netty.buffer.ByteBuf
    public final AbstractByteBuf unwrap() {
        return this.rootParent;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    final ByteBuf duplicate0() {
        ensureAccessible();
        return new PooledNonRetainedDuplicateByteBuf(this, unwrap());
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final <U extends AbstractPooledDerivedByteBuf> U init(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i6, int i7, int i8) {
        byteBuf.retain();
        this.parent = byteBuf;
        this.rootParent = abstractByteBuf;
        try {
            maxCapacity(i8);
            setIndex0(i6, i7);
            resetRefCnt();
            return this;
        } catch (Throwable th) {
            this.rootParent = null;
            this.parent = null;
            byteBuf.release();
            throw th;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i6, int i7) {
        return nioBuffer(i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return unwrap().isDirect();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return unwrap().isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public final ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice() {
        int readerIndex = readerIndex();
        return retainedSlice(readerIndex, writerIndex() - readerIndex);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        ensureAccessible();
        return new PooledNonRetainedSlicedByteBuf(this, unwrap(), i6, i7);
    }
}
