package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseMpscLinkedArrayQueueProducerFields<E> extends BaseMpscLinkedArrayQueuePad1<E> {
    private static final long P_INDEX_OFFSET;
    protected long producerIndex;

    static {
        try {
            P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(BaseMpscLinkedArrayQueueProducerFields.class.getDeclaredField("producerIndex"));
        } catch (NoSuchFieldException e6) {
            throw new RuntimeException(e6);
        }
    }

    final boolean casProducerIndex(long j6, long j7) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, j6, j7);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    final void soProducerIndex(long j6) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j6);
    }

    BaseMpscLinkedArrayQueueProducerFields() {
    }
}
