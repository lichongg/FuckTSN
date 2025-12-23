package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseMpscLinkedArrayQueueConsumerFields<E> extends BaseMpscLinkedArrayQueuePad2<E> {
    private static final long C_INDEX_OFFSET;
    protected E[] consumerBuffer;
    protected long consumerIndex;
    protected long consumerMask;

    static {
        try {
            C_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(BaseMpscLinkedArrayQueueConsumerFields.class.getDeclaredField("consumerIndex"));
        } catch (NoSuchFieldException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    final void soConsumerIndex(long j6) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j6);
    }

    BaseMpscLinkedArrayQueueConsumerFields() {
    }
}
