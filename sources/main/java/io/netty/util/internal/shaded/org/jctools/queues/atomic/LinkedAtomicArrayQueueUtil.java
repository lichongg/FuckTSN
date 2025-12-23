package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class LinkedAtomicArrayQueueUtil {
    static int calcElementOffset(long j6, long j7) {
        return (int) (j6 & j7);
    }

    static int modifiedCalcElementOffset(long j6, long j7) {
        return ((int) (j6 & j7)) >> 1;
    }

    static <E> AtomicReferenceArray<E> allocate(int i6) {
        return new AtomicReferenceArray<>(i6);
    }

    private LinkedAtomicArrayQueueUtil() {
    }

    static int length(AtomicReferenceArray<?> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    public static <E> E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i6) {
        return (E) AtomicReferenceArrayQueue.lpElement(atomicReferenceArray, i6);
    }

    public static <E> E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i6) {
        return (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, i6);
    }

    static int nextArrayOffset(AtomicReferenceArray<?> atomicReferenceArray) {
        return length(atomicReferenceArray) - 1;
    }

    static <E> void soElement(AtomicReferenceArray atomicReferenceArray, int i6, Object obj) {
        atomicReferenceArray.lazySet(i6, obj);
    }

    public static <E> void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        AtomicReferenceArrayQueue.spElement(atomicReferenceArray, i6, e6);
    }

    public static <E> void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        AtomicReferenceArrayQueue.svElement(atomicReferenceArray, i6, e6);
    }
}
