package io.netty.util.internal.shaded.org.jctools.queues;

import com.google.android.gms.internal.mlkit_acceleration.a;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    protected static final long P_NODE_OFFSET;
    protected LinkedQueueNode<E> producerNode;

    static {
        try {
            P_NODE_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(BaseLinkedQueueProducerNodeRef.class.getDeclaredField("producerNode"));
        } catch (NoSuchFieldException e6) {
            throw new RuntimeException(e6);
        }
    }

    protected final boolean casProducerNode(LinkedQueueNode<E> linkedQueueNode, LinkedQueueNode<E> linkedQueueNode2) {
        return a.a(UnsafeAccess.UNSAFE, this, P_NODE_OFFSET, linkedQueueNode, linkedQueueNode2);
    }

    protected final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode;
    }

    protected final LinkedQueueNode<E> lvProducerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
    }

    protected final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }

    BaseLinkedQueueProducerNodeRef() {
    }
}
