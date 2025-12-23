package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    int calcElementOffset(long j6, int i6) {
        return ((int) j6) & i6;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i6 = this.mask;
        long j6 = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j6, i6);
        if (j6 >= this.producerLookAhead) {
            long j7 = this.lookAheadStep + j6;
            if (lvElement(calcElementOffset(j7, i6)) == null) {
                this.producerLookAhead = j7;
            } else if (lvElement(calcElementOffset) != null) {
                return false;
            }
        }
        soElement(calcElementOffset, e6);
        soProducerIndex(j6 + 1);
        return true;
    }

    int calcElementOffset(long j6) {
        return this.mask & ((int) j6);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public E poll() {
        long j6 = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j6);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j6 + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    void soConsumerIndex(long j6) {
        this.consumerIndex.lazySet(j6);
    }

    void soProducerIndex(long j6) {
        this.producerIndex.lazySet(j6);
    }

    public SpscArrayQueue(int i6) {
        super(Pow2.roundToPowerOfTwo(i6));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i6 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    E lvElement(int i6) {
        return get(i6);
    }

    void soElement(int i6, E e6) {
        lazySet(i6, e6);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e6, E e7) {
        return offer(e6) && offer(e7);
    }
}
