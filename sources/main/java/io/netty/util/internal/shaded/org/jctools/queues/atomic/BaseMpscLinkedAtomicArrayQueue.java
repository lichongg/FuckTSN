package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BaseMpscLinkedAtomicArrayQueue<E> extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final Object JUMP = new Object();

    protected abstract long availableInQueue(long j6, long j7);

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public abstract int capacity();

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int capacity = capacity();
        long j6 = 0;
        do {
            int fill = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (fill == 0) {
                return (int) j6;
            }
            j6 += fill;
        } while (j6 <= capacity);
        return (int) j6;
    }

    protected abstract long getCurrentBufferCapacity(long j6);

    protected abstract int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray);

    private int newBufferAndOffset(AtomicReferenceArray<E> atomicReferenceArray, long j6) {
        this.consumerBuffer = atomicReferenceArray;
        long length = (LinkedAtomicArrayQueueUtil.length(atomicReferenceArray) - 2) << 1;
        this.consumerMask = length;
        return LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j6, length);
    }

    private int nextArrayOffset(long j6) {
        return LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j6 + 2, Long.MAX_VALUE);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i6) {
        int i7 = 0;
        while (i7 < i6) {
            E relaxedPoll = relaxedPoll();
            if (relaxedPoll == null) {
                break;
            }
            consumer.accept(relaxedPoll);
            i7++;
        }
        return i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e6) {
        if (e6 == null) {
            throw null;
        }
        while (true) {
            long lvProducerLimit = lvProducerLimit();
            long lvProducerIndex = lvProducerIndex();
            if ((lvProducerIndex & 1) != 1) {
                long j6 = this.producerMask;
                AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                if (lvProducerLimit <= lvProducerIndex) {
                    int offerSlowPath = offerSlowPath(j6, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else {
                        if (offerSlowPath == 2) {
                            return false;
                        }
                        if (offerSlowPath == 3) {
                            resize(j6, atomicReferenceArray, lvProducerIndex, e6);
                            return true;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                    LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(lvProducerIndex, j6), e6);
                    return true;
                }
            }
        }
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        int modifiedCalcElementOffset = LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j6, j7);
        E e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, modifiedCalcElementOffset);
        if (e6 == null && j6 != lvProducerIndex()) {
            do {
                e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, modifiedCalcElementOffset);
            } while (e6 == null);
        }
        return e6 == JUMP ? newBufferPeek(getNextBuffer(atomicReferenceArray, j7), j6) : e6;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        int modifiedCalcElementOffset = LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j6, j7);
        E e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, modifiedCalcElementOffset);
        if (e6 == null) {
            if (j6 == lvProducerIndex()) {
                return null;
            }
            do {
                e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, modifiedCalcElementOffset);
            } while (e6 == null);
        }
        if (e6 == JUMP) {
            return newBufferPoll(getNextBuffer(atomicReferenceArray, j7), j6);
        }
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, modifiedCalcElementOffset, null);
        soConsumerIndex(j6 + 2);
        return e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        E e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j6, j7));
        return e6 == JUMP ? newBufferPeek(getNextBuffer(atomicReferenceArray, j7), j6) : e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        int modifiedCalcElementOffset = LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j6, j7);
        E e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, modifiedCalcElementOffset);
        if (e6 == null) {
            return null;
        }
        if (e6 == JUMP) {
            return newBufferPoll(getNextBuffer(atomicReferenceArray, j7), j6);
        }
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, modifiedCalcElementOffset, null);
        soConsumerIndex(j6 + 2);
        return e6;
    }

    public BaseMpscLinkedAtomicArrayQueue(int i6) {
        RangeUtil.checkGreaterThanOrEqual(i6, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i6);
        long j6 = (roundToPowerOfTwo - 1) << 1;
        AtomicReferenceArray<E> allocate = LinkedAtomicArrayQueueUtil.allocate(roundToPowerOfTwo + 1);
        this.producerBuffer = allocate;
        this.producerMask = j6;
        this.consumerBuffer = allocate;
        this.consumerMask = j6;
        soProducerLimit(j6);
    }

    private AtomicReferenceArray<E> getNextBuffer(AtomicReferenceArray<E> atomicReferenceArray, long j6) {
        int nextArrayOffset = nextArrayOffset(j6);
        AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, nextArrayOffset);
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, nextArrayOffset, null);
        return atomicReferenceArray2;
    }

    private E newBufferPeek(AtomicReferenceArray<E> atomicReferenceArray, long j6) {
        E e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, newBufferAndOffset(atomicReferenceArray, j6));
        if (e6 != null) {
            return e6;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(AtomicReferenceArray<E> atomicReferenceArray, long j6) {
        int newBufferAndOffset = newBufferAndOffset(atomicReferenceArray, j6);
        E e6 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, newBufferAndOffset);
        if (e6 != null) {
            LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, newBufferAndOffset, null);
            soConsumerIndex(j6 + 2);
            return e6;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private int offerSlowPath(long j6, long j7, long j8) {
        long lvConsumerIndex = lvConsumerIndex();
        long currentBufferCapacity = getCurrentBufferCapacity(j6) + lvConsumerIndex;
        if (currentBufferCapacity > j7) {
            if (!casProducerLimit(j8, currentBufferCapacity)) {
                return 1;
            }
            return 0;
        }
        if (availableInQueue(j7, lvConsumerIndex) <= 0) {
            return 2;
        }
        if (!casProducerIndex(j7, 1 + j7)) {
            return 1;
        }
        return 3;
    }

    private void resize(long j6, AtomicReferenceArray<E> atomicReferenceArray, long j7, E e6) {
        int nextBufferSize = getNextBufferSize(atomicReferenceArray);
        AtomicReferenceArray<E> allocate = LinkedAtomicArrayQueueUtil.allocate(nextBufferSize);
        this.producerBuffer = allocate;
        long j8 = (nextBufferSize - 2) << 1;
        this.producerMask = j8;
        int modifiedCalcElementOffset = LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j7, j6);
        LinkedAtomicArrayQueueUtil.soElement(allocate, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j7, j8), e6);
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, nextArrayOffset(j6), allocate);
        long availableInQueue = availableInQueue(j7, lvConsumerIndex());
        RangeUtil.checkPositive(availableInQueue, "availableInQueue");
        soProducerLimit(Math.min(j8, availableInQueue) + j7);
        soProducerIndex(j7 + 2);
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, modifiedCalcElementOffset, JUMP);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex() / 2;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex() / 2;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i6) {
        while (true) {
            long lvProducerLimit = lvProducerLimit();
            long lvProducerIndex = lvProducerIndex();
            if ((lvProducerIndex & 1) != 1) {
                long j6 = this.producerMask;
                AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                long min = Math.min(lvProducerLimit, (i6 * 2) + lvProducerIndex);
                if (lvProducerIndex == lvProducerLimit || lvProducerLimit < min) {
                    int offerSlowPath = offerSlowPath(j6, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else {
                        if (offerSlowPath == 2) {
                            return 0;
                        }
                        if (offerSlowPath == 3) {
                            resize(j6, atomicReferenceArray, lvProducerIndex, supplier.get());
                            return 1;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, min)) {
                    int i7 = (int) ((min - lvProducerIndex) / 2);
                    for (int i8 = 0; i8 < i7; i8++) {
                        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset((i8 * 2) + lvProducerIndex, j6), supplier.get());
                    }
                    return i7;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        if (lvConsumerIndex() == lvProducerIndex()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e6) {
        return offer(e6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = lvConsumerIndex();
        while (true) {
            lvProducerIndex = lvProducerIndex();
            lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j6 = (lvProducerIndex - lvConsumerIndex) >> 1;
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j6;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        E relaxedPoll;
        while (true) {
            while (exitCondition.keepRunning()) {
                relaxedPoll = relaxedPoll();
                int idle = relaxedPoll == null ? waitStrategy.idle(idle) : 0;
            }
            return;
            consumer.accept(relaxedPoll);
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (exitCondition.keepRunning()) {
            while (fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) != 0 && exitCondition.keepRunning()) {
            }
            int i6 = 0;
            while (exitCondition.keepRunning() && fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                i6 = waitStrategy.idle(i6);
            }
        }
    }
}
