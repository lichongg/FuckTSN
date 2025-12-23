package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> implements IndexedQueueSizeUtil.IndexedQueue, QueueProgressIndicators, MessagePassingQueue<E> {
    protected final AtomicReferenceArray<E> buffer;
    protected final int mask;

    public static <E> E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i6) {
        return atomicReferenceArray.get(i6);
    }

    public static <E> E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i6) {
        return atomicReferenceArray.get(i6);
    }

    public static <E> void soElement(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        atomicReferenceArray.lazySet(i6, e6);
    }

    public static <E> void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        atomicReferenceArray.lazySet(i6, e6);
    }

    protected final int calcElementOffset(long j6, int i6) {
        return ((int) j6) & i6;
    }

    protected final int calcElementOffset(long j6) {
        return this.mask & ((int) j6);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int capacity() {
        return this.mask + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final E lpElement(int i6) {
        return this.buffer.get(i6);
    }

    protected final E lvElement(int i6) {
        return (E) lvElement(this.buffer, i6);
    }

    protected final void soElement(int i6, E e6) {
        this.buffer.lazySet(i6, e6);
    }

    protected final void spElement(int i6, E e6) {
        this.buffer.lazySet(i6, e6);
    }

    public AtomicReferenceArrayQueue(int i6) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i6);
        this.mask = roundToPowerOfTwo - 1;
        this.buffer = new AtomicReferenceArray<>(roundToPowerOfTwo);
    }

    public static <E> void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        atomicReferenceArray.set(i6, e6);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void clear() {
        while (poll() != null) {
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }
}
