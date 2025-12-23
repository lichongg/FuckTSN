package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class MpscAtomicArrayQueueProducerIndexField<E> extends MpscAtomicArrayQueueL1Pad<E> {
    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerIndexField> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerIndexField.class, "producerIndex");
    private volatile long producerIndex;

    protected final boolean casProducerIndex(long j6, long j7) {
        return P_INDEX_UPDATER.compareAndSet(this, j6, j7);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    public MpscAtomicArrayQueueProducerIndexField(int i6) {
        super(i6);
    }
}
