package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BaseMpscLinkedArrayQueue<E> extends BaseMpscLinkedArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final int CONTINUE_TO_P_INDEX_CAS = 0;
    private static final Object JUMP = new Object();
    private static final int QUEUE_FULL = 2;
    private static final int QUEUE_RESIZE = 3;
    private static final int RETRY = 1;

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

    protected abstract int getNextBufferSize(E[] eArr);

    private long newBufferAndOffset(E[] eArr, long j6) {
        this.consumerBuffer = eArr;
        long length = (LinkedArrayQueueUtil.length(eArr) - 2) << 1;
        this.consumerMask = length;
        return LinkedArrayQueueUtil.modifiedCalcElementOffset(j6, length);
    }

    private long nextArrayOffset(long j6) {
        return LinkedArrayQueueUtil.modifiedCalcElementOffset(j6 + 2, Long.MAX_VALUE);
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
                E[] eArr = this.producerBuffer;
                if (lvProducerLimit <= lvProducerIndex) {
                    int offerSlowPath = offerSlowPath(j6, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else {
                        if (offerSlowPath == 2) {
                            return false;
                        }
                        if (offerSlowPath == 3) {
                            resize(j6, eArr, lvProducerIndex, e6);
                            return true;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                    UnsafeRefArrayAccess.soElement(eArr, LinkedArrayQueueUtil.modifiedCalcElementOffset(lvProducerIndex, j6), e6);
                    return true;
                }
            }
        }
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        long modifiedCalcElementOffset = LinkedArrayQueueUtil.modifiedCalcElementOffset(j6, j7);
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset);
        if (e6 == null && j6 != lvProducerIndex()) {
            do {
                e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset);
            } while (e6 == null);
        }
        return e6 == JUMP ? newBufferPeek(getNextBuffer(eArr, j7), j6) : e6;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        E[] eArr = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        long modifiedCalcElementOffset = LinkedArrayQueueUtil.modifiedCalcElementOffset(j6, j7);
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset);
        if (e6 == null) {
            if (j6 == lvProducerIndex()) {
                return null;
            }
            do {
                e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset);
            } while (e6 == null);
        }
        if (e6 == JUMP) {
            return newBufferPoll(getNextBuffer(eArr, j7), j6);
        }
        UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset, null);
        soConsumerIndex(j6 + 2);
        return e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        E[] eArr = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, LinkedArrayQueueUtil.modifiedCalcElementOffset(j6, j7));
        return e6 == JUMP ? newBufferPeek(getNextBuffer(eArr, j7), j6) : e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.consumerBuffer;
        long j6 = this.consumerIndex;
        long j7 = this.consumerMask;
        long modifiedCalcElementOffset = LinkedArrayQueueUtil.modifiedCalcElementOffset(j6, j7);
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset);
        if (e6 == null) {
            return null;
        }
        if (e6 == JUMP) {
            return newBufferPoll(getNextBuffer(eArr, j7), j6);
        }
        UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset, null);
        soConsumerIndex(j6 + 2);
        return e6;
    }

    public BaseMpscLinkedArrayQueue(int i6) {
        RangeUtil.checkGreaterThanOrEqual(i6, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i6);
        long j6 = (roundToPowerOfTwo - 1) << 1;
        E[] eArr = (E[]) CircularArrayOffsetCalculator.allocate(roundToPowerOfTwo + 1);
        this.producerBuffer = eArr;
        this.producerMask = j6;
        this.consumerBuffer = eArr;
        this.consumerMask = j6;
        soProducerLimit(j6);
    }

    private E[] getNextBuffer(E[] eArr, long j6) {
        long nextArrayOffset = nextArrayOffset(j6);
        E[] eArr2 = (E[]) ((Object[]) UnsafeRefArrayAccess.lvElement(eArr, nextArrayOffset));
        UnsafeRefArrayAccess.soElement(eArr, nextArrayOffset, null);
        return eArr2;
    }

    private E newBufferPeek(E[] eArr, long j6) {
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, newBufferAndOffset(eArr, j6));
        if (e6 != null) {
            return e6;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(E[] eArr, long j6) {
        long newBufferAndOffset = newBufferAndOffset(eArr, j6);
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, newBufferAndOffset);
        if (e6 != null) {
            UnsafeRefArrayAccess.soElement(eArr, newBufferAndOffset, null);
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

    private void resize(long j6, E[] eArr, long j7, E e6) {
        int nextBufferSize = getNextBufferSize(eArr);
        E[] eArr2 = (E[]) CircularArrayOffsetCalculator.allocate(nextBufferSize);
        this.producerBuffer = eArr2;
        long j8 = (nextBufferSize - 2) << 1;
        this.producerMask = j8;
        long modifiedCalcElementOffset = LinkedArrayQueueUtil.modifiedCalcElementOffset(j7, j6);
        UnsafeRefArrayAccess.soElement(eArr2, LinkedArrayQueueUtil.modifiedCalcElementOffset(j7, j8), e6);
        UnsafeRefArrayAccess.soElement(eArr, nextArrayOffset(j6), eArr2);
        long availableInQueue = availableInQueue(j7, lvConsumerIndex());
        RangeUtil.checkPositive(availableInQueue, "availableInQueue");
        soProducerLimit(Math.min(j8, availableInQueue) + j7);
        soProducerIndex(j7 + 2);
        UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset, JUMP);
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
                E[] eArr = this.producerBuffer;
                long min = Math.min(lvProducerLimit, (i6 * 2) + lvProducerIndex);
                if (lvProducerIndex >= lvProducerLimit || lvProducerLimit < min) {
                    int offerSlowPath = offerSlowPath(j6, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath != 0 && offerSlowPath != 1) {
                        if (offerSlowPath == 2) {
                            return 0;
                        }
                        if (offerSlowPath == 3) {
                            resize(j6, eArr, lvProducerIndex, supplier.get());
                            return 1;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, min)) {
                    int i7 = (int) ((min - lvProducerIndex) / 2);
                    for (int i8 = 0; i8 < i7; i8++) {
                        UnsafeRefArrayAccess.soElement(eArr, LinkedArrayQueueUtil.modifiedCalcElementOffset((i8 * 2) + lvProducerIndex, j6), supplier.get());
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
            if (fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                int i6 = 0;
                while (exitCondition.keepRunning() && fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                    i6 = waitStrategy.idle(i6);
                }
            }
        }
    }
}
