package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseMpscLinkedArrayQueueColdProducerFields<E> extends BaseMpscLinkedArrayQueuePad3<E> {
    private static final long P_LIMIT_OFFSET;
    protected E[] producerBuffer;
    private volatile long producerLimit;
    protected long producerMask;

    static {
        try {
            P_LIMIT_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(BaseMpscLinkedArrayQueueColdProducerFields.class.getDeclaredField("producerLimit"));
        } catch (NoSuchFieldException e6) {
            throw new RuntimeException(e6);
        }
    }

    final boolean casProducerLimit(long j6, long j7) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_LIMIT_OFFSET, j6, j7);
    }

    final long lvProducerLimit() {
        return this.producerLimit;
    }

    final void soProducerLimit(long j6) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, j6);
    }

    BaseMpscLinkedArrayQueueColdProducerFields() {
    }
}
