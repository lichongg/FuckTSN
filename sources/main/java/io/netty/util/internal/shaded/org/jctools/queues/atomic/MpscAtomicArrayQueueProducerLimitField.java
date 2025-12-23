package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class MpscAtomicArrayQueueProducerLimitField<E> extends MpscAtomicArrayQueueMidPad<E> {
    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerLimitField> P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerLimitField.class, "producerLimit");
    private volatile long producerLimit;

    protected final long lvProducerLimit() {
        return this.producerLimit;
    }

    protected final void soProducerLimit(long j6) {
        P_LIMIT_UPDATER.lazySet(this, j6);
    }

    public MpscAtomicArrayQueueProducerLimitField(int i6) {
        super(i6);
        this.producerLimit = i6;
    }
}
