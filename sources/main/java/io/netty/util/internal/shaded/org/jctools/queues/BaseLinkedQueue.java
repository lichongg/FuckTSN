package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class BaseLinkedQueue<E> extends BaseLinkedQueuePad2<E> {
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

    protected final LinkedQueueNode<E> newNode() {
        return new LinkedQueueNode<>();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i6) {
        LinkedQueueNode<E> linkedQueueNode = this.consumerNode;
        int i7 = 0;
        while (i7 < i6) {
            LinkedQueueNode<E> lvNext = linkedQueueNode.lvNext();
            if (lvNext == null) {
                return i7;
            }
            consumer.accept(getSingleConsumerNodeValue(linkedQueueNode, lvNext));
            i7++;
            linkedQueueNode = lvNext;
        }
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final LinkedQueueNode<E> newNode(E e6) {
        return new LinkedQueueNode<>(e6);
    }

    BaseLinkedQueue() {
    }

    protected E getSingleConsumerNodeValue(LinkedQueueNode<E> linkedQueueNode, LinkedQueueNode<E> linkedQueueNode2) {
        E andNullValue = linkedQueueNode2.getAndNullValue();
        linkedQueueNode.soNext(linkedQueueNode);
        spConsumerNode(linkedQueueNode2);
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
        LinkedQueueNode<E> lvNext = lpConsumerNode().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        LinkedQueueNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> lvNext = lpConsumerNode.lvNext();
        if (lvNext != null) {
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext);
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        LinkedQueueNode<E> lvConsumerNode = lvConsumerNode();
        LinkedQueueNode<E> lvProducerNode = lvProducerNode();
        int i6 = 0;
        while (lvConsumerNode != lvProducerNode && lvConsumerNode != null && i6 < Integer.MAX_VALUE) {
            LinkedQueueNode<E> lvNext = lvConsumerNode.lvNext();
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
        LinkedQueueNode<E> linkedQueueNode = this.consumerNode;
        int i6 = 0;
        while (exitCondition.keepRunning()) {
            for (int i7 = 0; i7 < 4096; i7++) {
                LinkedQueueNode<E> lvNext = linkedQueueNode.lvNext();
                if (lvNext == null) {
                    i6 = waitStrategy.idle(i6);
                } else {
                    consumer.accept(getSingleConsumerNodeValue(linkedQueueNode, lvNext));
                    linkedQueueNode = lvNext;
                    i6 = 0;
                }
            }
        }
    }
}
