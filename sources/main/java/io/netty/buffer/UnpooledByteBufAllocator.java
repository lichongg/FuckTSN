package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    private final boolean disableLeakDetector;
    private final UnpooledByteBufAllocatorMetric metric;
    private final boolean noCleaner;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.buffer.UnpooledByteBufAllocator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class UnpooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
        final LongCounter directCounter;
        final LongCounter heapCounter;

        private UnpooledByteBufAllocatorMetric() {
            this.directCounter = PlatformDependent.newLongCounter();
            this.heapCounter = PlatformDependent.newLongCounter();
        }

        public String toString() {
            return StringUtil.simpleClassName(this) + "(usedHeapMemory: " + usedHeapMemory() + "; usedDirectMemory: " + usedDirectMemory() + ')';
        }

        @Override // io.netty.buffer.ByteBufAllocatorMetric
        public long usedDirectMemory() {
            return this.directCounter.value();
        }

        @Override // io.netty.buffer.ByteBufAllocatorMetric
        public long usedHeapMemory() {
            return this.heapCounter.value();
        }

        /* synthetic */ UnpooledByteBufAllocatorMetric(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public UnpooledByteBufAllocator(boolean z5) {
        this(z5, false);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InstrumentedUnpooledDirectByteBuf extends UnpooledDirectByteBuf {
        InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i6, int i7) {
            super(unpooledByteBufAllocator, i6, i7);
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i6) {
            ByteBuffer allocateDirect = super.allocateDirect(i6);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InstrumentedUnpooledHeapByteBuf extends UnpooledHeapByteBuf {
        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }

        InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i6, int i7) {
            super(unpooledByteBufAllocator, i6, i7);
        }

        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int i6) {
            byte[] allocateArray = super.allocateArray(i6);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(allocateArray.length);
            return allocateArray;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InstrumentedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i6, int i7) {
            super(unpooledByteBufAllocator, i6, i7);
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i6) {
            ByteBuffer allocateDirect = super.allocateDirect(i6);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InstrumentedUnpooledUnsafeHeapByteBuf extends UnpooledUnsafeHeapByteBuf {
        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }

        InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i6, int i7) {
            super(unpooledByteBufAllocator, i6, i7);
        }

        @Override // io.netty.buffer.UnpooledUnsafeHeapByteBuf, io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int i6) {
            byte[] allocateArray = super.allocateArray(i6);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(allocateArray.length);
            return allocateArray;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeNoCleanerDirectByteBuf {
        InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i6, int i7) {
            super(unpooledByteBufAllocator, i6, i7);
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i6) {
            ByteBuffer allocateDirect = super.allocateDirect(i6);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
        ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i6) {
            int capacity = byteBuffer.capacity();
            ByteBuffer reallocateDirect = super.reallocateDirect(byteBuffer, i6);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(reallocateDirect.capacity() - capacity);
            return reallocateDirect;
        }
    }

    public UnpooledByteBufAllocator(boolean z5, boolean z6) {
        this(z5, z6, PlatformDependent.useDirectBufferNoCleaner());
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator, io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i6) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, true, i6);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator, io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i6) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, false, i6);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    void decrementDirect(int i6) {
        this.metric.directCounter.add(-i6);
    }

    void decrementHeap(int i6) {
        this.metric.heapCounter.add(-i6);
    }

    void incrementDirect(int i6) {
        this.metric.directCounter.add(i6);
    }

    void incrementHeap(int i6) {
        this.metric.heapCounter.add(i6);
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetricProvider
    public ByteBufAllocatorMetric metric() {
        return this.metric;
    }

    public UnpooledByteBufAllocator(boolean z5, boolean z6, boolean z7) {
        super(z5);
        this.metric = new UnpooledByteBufAllocatorMetric(null);
        this.disableLeakDetector = z6;
        this.noCleaner = z7 && PlatformDependent.hasUnsafe() && PlatformDependent.hasDirectBufferNoCleanerConstructor();
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i6, int i7) {
        ByteBuf instrumentedUnpooledDirectByteBuf;
        if (PlatformDependent.hasUnsafe()) {
            if (this.noCleaner) {
                instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(this, i6, i7);
            } else {
                instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledUnsafeDirectByteBuf(this, i6, i7);
            }
        } else {
            instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledDirectByteBuf(this, i6, i7);
        }
        if (this.disableLeakDetector) {
            return instrumentedUnpooledDirectByteBuf;
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(instrumentedUnpooledDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i6, int i7) {
        if (PlatformDependent.hasUnsafe()) {
            return new InstrumentedUnpooledUnsafeHeapByteBuf(this, i6, i7);
        }
        return new InstrumentedUnpooledHeapByteBuf(this, i6, i7);
    }
}
