package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MpscArrayQueue<E> extends MpscArrayQueueL3Pad<E> {
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
        E[] eArr = this.buffer;
        long j6 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        for (int i7 = 0; i7 < i6; i7++) {
            long j7 = i7 + lpConsumerIndex;
            long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(j7, j6);
            Object lvElement = UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
            if (lvElement == null) {
                return i7;
            }
            UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
            soConsumerIndex(j7 + 1);
            consumer.accept(lvElement);
        }
        return i6;
    }

    public final int failFastOffer(E e6) {
        if (e6 == null) {
            throw null;
        }
        long j6 = this.mask;
        long j7 = j6 + 1;
        long lvProducerIndex = lvProducerIndex();
        if (lvProducerIndex >= lvProducerLimit()) {
            long lvConsumerIndex = lvConsumerIndex() + j7;
            if (lvProducerIndex >= lvConsumerIndex) {
                return 1;
            }
            soProducerLimit(lvConsumerIndex);
        }
        if (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
            return -1;
        }
        UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j6), e6);
        return 0;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e6) {
        long lvProducerIndex;
        if (e6 == null) {
            throw null;
        }
        long j6 = this.mask;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit) {
                lvProducerLimit = lvConsumerIndex() + j6 + 1;
                if (lvProducerIndex >= lvProducerLimit) {
                    return false;
                }
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j6), e6);
        return true;
    }

    public boolean offerIfBelowThreshold(E e6, int i6) {
        if (e6 == null) {
            throw null;
        }
        long j6 = this.mask;
        long j7 = 1;
        long j8 = j6 + 1;
        long lvProducerLimit = lvProducerLimit();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long j9 = j7;
            long j10 = i6;
            if (j8 - (lvProducerLimit - lvProducerIndex) >= j10) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvProducerIndex - lvConsumerIndex >= j10) {
                    return false;
                }
                lvProducerLimit = lvConsumerIndex + j8;
                soProducerLimit(lvProducerLimit);
            }
            if (casProducerIndex(lvProducerIndex, lvProducerIndex + j9)) {
                UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j6), e6);
                return true;
            }
            j7 = j9;
        }
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        E e6;
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e7 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e7 != null) {
            return e7;
        }
        if (lpConsumerIndex == lvProducerIndex()) {
            return null;
        }
        do {
            e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        } while (e6 == null);
        return e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) UnsafeRefArrayAccess.lvElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lpConsumerIndex(), this.mask));
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e6 == null) {
            return null;
        }
        UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e6;
    }

    public MpscArrayQueue(int i6) {
        super(i6);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i6) {
        long lvProducerIndex;
        int i7;
        int min;
        long j6 = this.mask;
        long j7 = 1 + j6;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j8 = lvProducerLimit - lvProducerIndex;
            if (j8 <= 0) {
                lvProducerLimit = lvConsumerIndex() + j7;
                j8 = lvProducerLimit - lvProducerIndex;
                if (j8 <= 0) {
                    return 0;
                }
                soProducerLimit(lvProducerLimit);
            }
            min = Math.min((int) j8, i6);
        } while (!casProducerIndex(lvProducerIndex, min + lvProducerIndex));
        E[] eArr = this.buffer;
        for (i7 = 0; i7 < min; i7++) {
            UnsafeRefArrayAccess.soElement(eArr, ConcurrentCircularArrayQueue.calcElementOffset(i7 + lvProducerIndex, j6), supplier.get());
        }
        return min;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E[] eArr = this.buffer;
        E e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e6 == null) {
            if (lpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e6 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
            } while (e6 == null);
        }
        UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e6;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e6) {
        return offer(e6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        E[] eArr = this.buffer;
        long j6 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        int i6 = 0;
        while (exitCondition.keepRunning()) {
            for (int i7 = 0; i7 < 4096; i7++) {
                long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(lpConsumerIndex, j6);
                Object lvElement = UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
                if (lvElement == null) {
                    i6 = waitStrategy.idle(i6);
                } else {
                    lpConsumerIndex++;
                    UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
                    soConsumerIndex(lpConsumerIndex);
                    consumer.accept(lvElement);
                    i6 = 0;
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
