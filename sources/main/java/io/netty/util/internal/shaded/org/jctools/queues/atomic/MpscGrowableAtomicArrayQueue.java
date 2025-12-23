package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MpscGrowableAtomicArrayQueue<E> extends MpscChunkedAtomicArrayQueue<E> {
    public MpscGrowableAtomicArrayQueue(int i6) {
        super(Math.max(2, Pow2.roundToPowerOfTwo(i6 / 8)), i6);
    }

    public MpscGrowableAtomicArrayQueue(int i6, int i7) {
        super(i6, i7);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected long getCurrentBufferCapacity(long j6) {
        long j7 = 2 + j6;
        long j8 = this.maxQueueCapacity;
        return j7 == j8 ? j8 : j6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray) {
        RangeUtil.checkLessThanOrEqual(LinkedAtomicArrayQueueUtil.length(atomicReferenceArray), this.maxQueueCapacity / 2, "buffer.length");
        return ((LinkedAtomicArrayQueueUtil.length(atomicReferenceArray) - 1) * 2) + 1;
    }
}
