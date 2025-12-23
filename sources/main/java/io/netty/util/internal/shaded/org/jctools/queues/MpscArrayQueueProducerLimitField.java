package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class MpscArrayQueueProducerLimitField<E> extends MpscArrayQueueMidPad<E> {
    private static final long P_LIMIT_OFFSET;
    private volatile long producerLimit;

    static {
        try {
            P_LIMIT_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(MpscArrayQueueProducerLimitField.class.getDeclaredField("producerLimit"));
        } catch (NoSuchFieldException e6) {
            throw new RuntimeException(e6);
        }
    }

    protected final long lvProducerLimit() {
        return this.producerLimit;
    }

    protected final void soProducerLimit(long j6) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, j6);
    }

    public MpscArrayQueueProducerLimitField(int i6) {
        super(i6);
        this.producerLimit = i6;
    }
}
