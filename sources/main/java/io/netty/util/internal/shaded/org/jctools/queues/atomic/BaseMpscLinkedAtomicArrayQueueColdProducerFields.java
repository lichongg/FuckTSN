package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> extends BaseMpscLinkedAtomicArrayQueuePad3<E> {
    private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueColdProducerFields> P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueColdProducerFields.class, "producerLimit");
    protected AtomicReferenceArray<E> producerBuffer;
    protected volatile long producerLimit;
    protected long producerMask;

    final boolean casProducerLimit(long j6, long j7) {
        return P_LIMIT_UPDATER.compareAndSet(this, j6, j7);
    }

    final long lvProducerLimit() {
        return this.producerLimit;
    }

    final void soProducerLimit(long j6) {
        P_LIMIT_UPDATER.lazySet(this, j6);
    }

    BaseMpscLinkedAtomicArrayQueueColdProducerFields() {
    }
}
