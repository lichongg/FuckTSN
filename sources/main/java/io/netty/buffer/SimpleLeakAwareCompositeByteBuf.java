package io.netty.buffer;

import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class SimpleLeakAwareCompositeByteBuf extends WrappedCompositeByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final ResourceLeakTracker<ByteBuf> leak;

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf) {
        return newLeakAwareByteBuf(byteBuf, unwrap(), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        ByteBuf unwrap = unwrap();
        if (!super.release()) {
            return false;
        }
        closeLeak(unwrap);
        return true;
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return newLeakAwareByteBuf(super.retainedSlice());
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return newLeakAwareByteBuf(super.slice());
    }

    private void closeLeak(ByteBuf byteBuf) {
        this.leak.close(byteBuf);
    }

    protected SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new SimpleLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        return newLeakAwareByteBuf(super.retainedSlice(i6, i7));
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        return newLeakAwareByteBuf(super.slice(i6, i7));
    }

    SimpleLeakAwareCompositeByteBuf(CompositeByteBuf compositeByteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(compositeByteBuf);
        this.leak = (ResourceLeakTracker) ObjectUtil.checkNotNull(resourceLeakTracker, "leak");
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return newLeakAwareByteBuf(super.asReadOnly());
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return newLeakAwareByteBuf(super.duplicate());
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (order() == byteOrder) {
            return this;
        }
        return newLeakAwareByteBuf(super.order(byteOrder));
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        return newLeakAwareByteBuf(super.readRetainedSlice(i6));
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        return newLeakAwareByteBuf(super.readSlice(i6));
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return newLeakAwareByteBuf(super.retainedDuplicate());
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        ByteBuf unwrap = unwrap();
        if (!super.release(i6)) {
            return false;
        }
        closeLeak(unwrap);
        return true;
    }
}
