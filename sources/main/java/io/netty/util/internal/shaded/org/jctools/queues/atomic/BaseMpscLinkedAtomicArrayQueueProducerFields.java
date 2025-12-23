package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseMpscLinkedAtomicArrayQueueProducerFields<E> extends BaseMpscLinkedAtomicArrayQueuePad1<E> {
    private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueProducerFields> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueProducerFields.class, "producerIndex");
    protected volatile long producerIndex;

    final boolean casProducerIndex(long j6, long j7) {
        return P_INDEX_UPDATER.compareAndSet(this, j6, j7);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final void soProducerIndex(long j6) {
        P_INDEX_UPDATER.lazySet(this, j6);
    }

    BaseMpscLinkedAtomicArrayQueueProducerFields() {
    }
}
