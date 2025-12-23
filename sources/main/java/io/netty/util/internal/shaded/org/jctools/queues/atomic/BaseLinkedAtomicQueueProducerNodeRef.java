package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseLinkedAtomicQueueProducerNodeRef<E> extends BaseLinkedAtomicQueuePad0<E> {
    private static final AtomicReferenceFieldUpdater<BaseLinkedAtomicQueueProducerNodeRef, LinkedQueueAtomicNode> P_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicQueueProducerNodeRef.class, LinkedQueueAtomicNode.class, "producerNode");
    protected volatile LinkedQueueAtomicNode<E> producerNode;

    protected final boolean casProducerNode(LinkedQueueAtomicNode<E> linkedQueueAtomicNode, LinkedQueueAtomicNode<E> linkedQueueAtomicNode2) {
        return a.a(P_NODE_UPDATER, this, linkedQueueAtomicNode, linkedQueueAtomicNode2);
    }

    protected final LinkedQueueAtomicNode<E> lpProducerNode() {
        return this.producerNode;
    }

    protected final LinkedQueueAtomicNode<E> lvProducerNode() {
        return this.producerNode;
    }

    protected final void spProducerNode(LinkedQueueAtomicNode<E> linkedQueueAtomicNode) {
        P_NODE_UPDATER.lazySet(this, linkedQueueAtomicNode);
    }

    protected final LinkedQueueAtomicNode<E> xchgProducerNode(LinkedQueueAtomicNode<E> linkedQueueAtomicNode) {
        return P_NODE_UPDATER.getAndSet(this, linkedQueueAtomicNode);
    }

    BaseLinkedAtomicQueueProducerNodeRef() {
    }
}
