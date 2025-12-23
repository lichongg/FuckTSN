package io.netty.buffer;

import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class SimpleLeakAwareByteBuf extends WrappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final ResourceLeakTracker<ByteBuf> leak;
    private final ByteBuf trackedByteBuf;

    SimpleLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(byteBuf);
        this.trackedByteBuf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf2, "trackedByteBuf");
        this.leak = (ResourceLeakTracker) ObjectUtil.checkNotNull(resourceLeakTracker, "leak");
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return newLeakAwareByteBuf(byteBuf, byteBuf, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        if (!super.release()) {
            return false;
        }
        closeLeak();
        return true;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return unwrappedDerived(super.retainedSlice());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return newSharedLeakAwareByteBuf(super.slice());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    private void closeLeak() {
        this.leak.close(this.trackedByteBuf);
    }

    private SimpleLeakAwareByteBuf newSharedLeakAwareByteBuf(ByteBuf byteBuf) {
        return newLeakAwareByteBuf(byteBuf, this.trackedByteBuf, this.leak);
    }

    private static ByteBuf unwrapSwapped(ByteBuf byteBuf) {
        if (byteBuf instanceof SwappedByteBuf) {
            do {
                byteBuf = byteBuf.unwrap();
            } while (byteBuf instanceof SwappedByteBuf);
        }
        return byteBuf;
    }

    protected SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new SimpleLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        return unwrappedDerived(super.retainedSlice(i6, i7));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        return newSharedLeakAwareByteBuf(super.slice(i6, i7));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    private ByteBuf unwrappedDerived(ByteBuf byteBuf) {
        ByteBuf unwrapSwapped = unwrapSwapped(byteBuf);
        if (unwrapSwapped instanceof AbstractPooledDerivedByteBuf) {
            ((AbstractPooledDerivedByteBuf) unwrapSwapped).parent(this);
            ResourceLeakTracker<ByteBuf> track = AbstractByteBuf.leakDetector.track(byteBuf);
            if (track == null) {
                return byteBuf;
            }
            return newLeakAwareByteBuf(byteBuf, track);
        }
        return newSharedLeakAwareByteBuf(byteBuf);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return newSharedLeakAwareByteBuf(super.asReadOnly());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return newSharedLeakAwareByteBuf(super.duplicate());
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (order() == byteOrder) {
            return this;
        }
        return newSharedLeakAwareByteBuf(super.order(byteOrder));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        return unwrappedDerived(super.readRetainedSlice(i6));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        return newSharedLeakAwareByteBuf(super.readSlice(i6));
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        if (!super.release(i6)) {
            return false;
        }
        closeLeak();
        return true;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return unwrappedDerived(super.retainedDuplicate());
    }

    SimpleLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        this(byteBuf, byteBuf, resourceLeakTracker);
    }
}
