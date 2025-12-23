package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseLinkedAtomicQueue<E> extends BaseLinkedAtomicQueuePad2<E> {
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        long j6 = 0;
        do {
            int drain = drain(consumer, 4096);
            j6 += drain;
            if (drain != 4096) {
                break;
            }
        } while (j6 <= 2147479551);
        return (int) j6;
    }

    protected final LinkedQueueAtomicNode<E> newNode() {
        return new LinkedQueueAtomicNode<>();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i6) {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNode = this.consumerNode;
        int i7 = 0;
        while (i7 < i6) {
            LinkedQueueAtomicNode<E> lvNext = linkedQueueAtomicNode.lvNext();
            if (lvNext == null) {
                return i7;
            }
            consumer.accept(getSingleConsumerNodeValue(linkedQueueAtomicNode, lvNext));
            i7++;
            linkedQueueAtomicNode = lvNext;
        }
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final LinkedQueueAtomicNode<E> newNode(E e6) {
        return new LinkedQueueAtomicNode<>(e6);
    }

    BaseLinkedAtomicQueue() {
    }

    protected E getSingleConsumerNodeValue(LinkedQueueAtomicNode<E> linkedQueueAtomicNode, LinkedQueueAtomicNode<E> linkedQueueAtomicNode2) {
        E andNullValue = linkedQueueAtomicNode2.getAndNullValue();
        linkedQueueAtomicNode.soNext(linkedQueueAtomicNode);
        spConsumerNode(linkedQueueAtomicNode2);
        return andNullValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        if (lvConsumerNode() == lvProducerNode()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e6) {
        return offer(e6);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        LinkedQueueAtomicNode<E> lvNext = lpConsumerNode().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        LinkedQueueAtomicNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> lvNext = lpConsumerNode.lvNext();
        if (lvNext != null) {
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext);
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        LinkedQueueAtomicNode<E> lvConsumerNode = lvConsumerNode();
        LinkedQueueAtomicNode<E> lvProducerNode = lvProducerNode();
        int i6 = 0;
        while (lvConsumerNode != lvProducerNode && lvConsumerNode != null && i6 < Integer.MAX_VALUE) {
            LinkedQueueAtomicNode<E> lvNext = lvConsumerNode.lvNext();
            if (lvNext == lvConsumerNode) {
                break;
            }
            i6++;
            lvConsumerNode = lvNext;
        }
        return i6;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNode = this.consumerNode;
        int i6 = 0;
        while (exitCondition.keepRunning()) {
            for (int i7 = 0; i7 < 4096; i7++) {
                LinkedQueueAtomicNode<E> lvNext = linkedQueueAtomicNode.lvNext();
                if (lvNext == null) {
                    i6 = waitStrategy.idle(i6);
                } else {
                    consumer.accept(getSingleConsumerNodeValue(linkedQueueAtomicNode, lvNext));
                    linkedQueueAtomicNode = lvNext;
                    i6 = 0;
                }
            }
        }
    }
}
