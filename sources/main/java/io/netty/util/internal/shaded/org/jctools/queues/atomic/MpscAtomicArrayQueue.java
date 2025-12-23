package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i6) {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i7 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        for (int i8 = 0; i8 < i6; i8++) {
            long j6 = i8 + lpConsumerIndex;
            int calcElementOffset = calcElementOffset(j6, i7);
            Object lvElement = AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
            if (lvElement == null) {
                return i8;
            }
            AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
            soConsumerIndex(j6 + 1);
            consumer.accept(lvElement);
        }
        return i6;
    }

    public final int failFastOffer(E e6) {
        if (e6 == null) {
            throw null;
        }
        int i6 = this.mask;
        long j6 = i6 + 1;
        long lvProducerIndex = lvProducerIndex();
        if (lvProducerIndex >= lvProducerLimit()) {
            long lvConsumerIndex = lvConsumerIndex() + j6;
            if (lvProducerIndex >= lvConsumerIndex) {
                return 1;
            }
            soProducerLimit(lvConsumerIndex);
        }
        if (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
            return -1;
        }
        AtomicReferenceArrayQueue.soElement(this.buffer, calcElementOffset(lvProducerIndex, i6), e6);
        return 0;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e6) {
        long lvProducerIndex;
        if (e6 == null) {
            throw null;
        }
        int i6 = this.mask;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit) {
                lvProducerLimit = lvConsumerIndex() + i6 + 1;
                if (lvProducerIndex >= lvProducerLimit) {
                    return false;
                }
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        AtomicReferenceArrayQueue.soElement(this.buffer, calcElementOffset(lvProducerIndex, i6), e6);
        return true;
    }

    public boolean offerIfBelowThreshold(E e6, int i6) {
        long lvProducerIndex;
        if (e6 == null) {
            throw null;
        }
        int i7 = this.mask;
        long j6 = i7 + 1;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j7 = i6;
            if (j6 - (lvProducerLimit - lvProducerIndex) >= j7) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvProducerIndex - lvConsumerIndex >= j7) {
                    return false;
                }
                lvProducerLimit = lvConsumerIndex + j6;
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        AtomicReferenceArrayQueue.soElement(this.buffer, calcElementOffset(lvProducerIndex, i7), e6);
        return true;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        E e6;
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e7 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
        if (e7 != null) {
            return e7;
        }
        if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        }
        do {
            e6 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
        } while (e6 == null);
        return e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) AtomicReferenceArrayQueue.lvElement(this.buffer, calcElementOffset(lpConsumerIndex(), this.mask));
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e6 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
        if (e6 == null) {
            return null;
        }
        AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e6;
    }

    public MpscAtomicArrayQueue(int i6) {
        super(i6);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i6) {
        long lvProducerIndex;
        int i7;
        int min;
        int i8 = this.mask;
        long j6 = i8 + 1;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j7 = lvProducerLimit - lvProducerIndex;
            if (j7 <= 0) {
                lvProducerLimit = lvConsumerIndex() + j6;
                j7 = lvProducerLimit - lvProducerIndex;
                if (j7 <= 0) {
                    return 0;
                }
                soProducerLimit(lvProducerLimit);
            }
            min = Math.min((int) j7, i6);
        } while (!casProducerIndex(lvProducerIndex, min + lvProducerIndex));
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        for (i7 = 0; i7 < min; i7++) {
            AtomicReferenceArrayQueue.soElement(atomicReferenceArray, calcElementOffset(i7 + lvProducerIndex, i8), supplier.get());
        }
        return min;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        int calcElementOffset = calcElementOffset(lpConsumerIndex);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E e6 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
        if (e6 == null) {
            if (lpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e6 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
            } while (e6 == null);
        }
        AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e6) {
        return offer(e6);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public int weakOffer(E e6) {
        return failFastOffer(e6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i6 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        int i7 = 0;
        while (exitCondition.keepRunning()) {
            for (int i8 = 0; i8 < 4096; i8++) {
                int calcElementOffset = calcElementOffset(lpConsumerIndex, i6);
                Object lvElement = AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
                if (lvElement == null) {
                    i7 = waitStrategy.idle(i7);
                } else {
                    lpConsumerIndex++;
                    AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
                    soConsumerIndex(lpConsumerIndex);
                    consumer.accept(lvElement);
                    i7 = 0;
                }
            }
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (true) {
            while (exitCondition.keepRunning()) {
                int idle = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0 ? waitStrategy.idle(idle) : 0;
            }
            return;
        }
    }
}
