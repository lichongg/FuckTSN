package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseLinkedAtomicQueueConsumerNodeRef<E> extends BaseLinkedAtomicQueuePad1<E> {
    private static final AtomicReferenceFieldUpdater<BaseLinkedAtomicQueueConsumerNodeRef, LinkedQueueAtomicNode> C_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicQueueConsumerNodeRef.class, LinkedQueueAtomicNode.class, "consumerNode");
    protected volatile LinkedQueueAtomicNode<E> consumerNode;

    protected final LinkedQueueAtomicNode<E> lpConsumerNode() {
        return this.consumerNode;
    }

    protected final LinkedQueueAtomicNode<E> lvConsumerNode() {
        return this.consumerNode;
    }

    protected final void spConsumerNode(LinkedQueueAtomicNode<E> linkedQueueAtomicNode) {
        C_NODE_UPDATER.lazySet(this, linkedQueueAtomicNode);
    }

    BaseLinkedAtomicQueueConsumerNodeRef() {
    }
}
