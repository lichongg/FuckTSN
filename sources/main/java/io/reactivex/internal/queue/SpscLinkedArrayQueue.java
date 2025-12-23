package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    AtomicReferenceArray<Object> consumerBuffer;
    final int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    long producerLookAhead;
    int producerLookAheadStep;
    final int producerMask;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    private static int calcWrappedOffset(long j6, int i6) {
        return calcDirectOffset(((int) j6) & i6);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t5) {
        if (t5 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lpProducerIndex = lpProducerIndex();
        int i6 = this.producerMask;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i6);
        if (lpProducerIndex < this.producerLookAhead) {
            return writeToQueue(atomicReferenceArray, t5, lpProducerIndex, calcWrappedOffset);
        }
        long j6 = this.producerLookAheadStep + lpProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j6, i6)) == null) {
            this.producerLookAhead = j6 - 1;
            return writeToQueue(atomicReferenceArray, t5, lpProducerIndex, calcWrappedOffset);
        }
        if (lvElement(atomicReferenceArray, calcWrappedOffset(lpProducerIndex + 1, i6)) == null) {
            return writeToQueue(atomicReferenceArray, t5, lpProducerIndex, calcWrappedOffset);
        }
        resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t5, i6);
        return true;
    }

    private void adjustLookAheadStep(int i6) {
        this.producerLookAheadStep = Math.min(i6 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6) {
        this.consumerBuffer = atomicReferenceArray;
        return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j6, i6));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j6, i6);
        T t5 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t5 != null) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(j6 + 1);
        }
        return t5;
    }

    private void soConsumerIndex(long j6) {
        this.consumerIndex.lazySet(j6);
    }

    private void soProducerIndex(long j6) {
        this.producerIndex.lazySet(j6);
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i6 = this.consumerMask;
        T t5 = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i6));
        return t5 == HAS_NEXT ? newBufferPeek(lvNext(atomicReferenceArray), lpConsumerIndex, i6) : t5;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i6 = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i6);
        T t5 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z5 = t5 == HAS_NEXT;
        if (t5 == null || z5) {
            if (z5) {
                return newBufferPoll(lvNext(atomicReferenceArray), lpConsumerIndex, i6);
            }
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return t5;
    }

    public SpscLinkedArrayQueue(int i6) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i6));
        int i7 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i7;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i7;
        this.producerLookAhead = roundToPowerOfTwo - 2;
        soProducerIndex(0L);
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i6) {
        return atomicReferenceArray.get(i6);
    }

    private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1));
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6, T t5, long j7) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j7 + j6) - 1;
        soElement(atomicReferenceArray2, i6, t5);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i6, HAS_NEXT);
        soProducerIndex(j6 + 1);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i6, Object obj) {
        atomicReferenceArray.lazySet(i6, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t5, long j6, int i6) {
        soElement(atomicReferenceArray, i6, t5);
        soProducerIndex(j6 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (lvProducerIndex() == lvConsumerIndex()) {
            return true;
        }
        return false;
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t5, T t6) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i6 = this.producerMask;
        long j6 = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j6, i6)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i6);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t6);
            soElement(atomicReferenceArray, calcWrappedOffset, t5);
            soProducerIndex(j6);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i6);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t6);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t5);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j6);
        return true;
    }

    private static int calcDirectOffset(int i6) {
        return i6;
    }
}
