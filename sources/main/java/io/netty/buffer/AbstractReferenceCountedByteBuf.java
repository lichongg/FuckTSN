package io.netty.buffer;

import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    private volatile int refCnt;
    private static final long REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCountedByteBuf.class, "refCnt");
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
    private static final ReferenceCountUpdater<AbstractReferenceCountedByteBuf> updater = new ReferenceCountUpdater<AbstractReferenceCountedByteBuf>() { // from class: io.netty.buffer.AbstractReferenceCountedByteBuf.1
        @Override // io.netty.util.internal.ReferenceCountUpdater
        protected long unsafeOffset() {
            return AbstractReferenceCountedByteBuf.REFCNT_FIELD_OFFSET;
        }

        @Override // io.netty.util.internal.ReferenceCountUpdater
        protected AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> updater() {
            return AbstractReferenceCountedByteBuf.AIF_UPDATER;
        }
    };

    protected abstract void deallocate();

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return handleRelease(updater.release(this));
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    private boolean handleRelease(boolean z5) {
        if (z5) {
            deallocate();
        }
        return z5;
    }

    @Override // io.netty.buffer.ByteBuf
    boolean isAccessible() {
        return updater.isLiveNonVolatile(this);
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return updater.refCnt(this);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        return handleRelease(updater.release(this, i6));
    }

    protected final void resetRefCnt() {
        updater.resetRefCnt(this);
    }

    protected final void setRefCnt(int i6) {
        updater.setRefCnt(this, i6);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    protected AbstractReferenceCountedByteBuf(int i6) {
        super(i6);
        this.refCnt = updater.initialValue();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return updater.retain(this);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i6) {
        return updater.retain(this, i6);
    }
}
