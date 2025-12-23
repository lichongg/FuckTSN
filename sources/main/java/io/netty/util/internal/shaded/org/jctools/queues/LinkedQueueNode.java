package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class LinkedQueueNode<E> {
    private static final long NEXT_OFFSET;
    private volatile LinkedQueueNode<E> next;
    private E value;

    LinkedQueueNode() {
        this(null);
    }

    static {
        try {
            NEXT_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(LinkedQueueNode.class.getDeclaredField("next"));
        } catch (NoSuchFieldException e6) {
            throw new RuntimeException(e6);
        }
    }

    LinkedQueueNode(E e6) {
        spValue(e6);
    }

    public E lpValue() {
        return this.value;
    }

    public LinkedQueueNode<E> lvNext() {
        return this.next;
    }

    public void soNext(LinkedQueueNode<E> linkedQueueNode) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, NEXT_OFFSET, linkedQueueNode);
    }

    public void spValue(E e6) {
        this.value = e6;
    }

    public E getAndNullValue() {
        E lpValue = lpValue();
        spValue(null);
        return lpValue;
    }
}
