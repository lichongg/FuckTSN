package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        long j6 = 0;
        do {
            fill(supplier, 4096);
            j6 += 4096;
        } while (j6 <= 2147479551);
        return (int) j6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i6) {
        return super.drain(consumer, i6);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i6) {
        if (i6 == 0) {
            return 0;
        }
        LinkedQueueNode<E> newNode = newNode(supplier.get());
        int i7 = 1;
        LinkedQueueNode<E> linkedQueueNode = newNode;
        while (i7 < i6) {
            LinkedQueueNode<E> newNode2 = newNode(supplier.get());
            linkedQueueNode.soNext(newNode2);
            i7++;
            linkedQueueNode = newNode2;
        }
        lpProducerNode().soNext(newNode);
        spProducerNode(linkedQueueNode);
        return i6;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e6) {
        if (e6 == null) {
            throw null;
        }
        LinkedQueueNode<E> newNode = newNode(e6);
        lpProducerNode().soNext(newNode);
        spProducerNode(newNode);
        return true;
    }

    public SpscLinkedQueue() {
        LinkedQueueNode<E> newNode = newNode();
        spProducerNode(newNode);
        spConsumerNode(newNode);
        newNode.soNext(null);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        return (E) relaxedPeek();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        return (E) relaxedPoll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        LinkedQueueNode<E> linkedQueueNode = this.producerNode;
        while (exitCondition.keepRunning()) {
            int i6 = 0;
            while (i6 < 4096) {
                LinkedQueueNode<E> newNode = newNode(supplier.get());
                linkedQueueNode.soNext(newNode);
                this.producerNode = newNode;
                i6++;
                linkedQueueNode = newNode;
            }
        }
    }
}
