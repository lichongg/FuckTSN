package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue<E>.Heap maxHeap;

    @VisibleForTesting
    final int maximumSize;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.collect.MinMaxPriorityQueue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        private int maximumSize;

        /* synthetic */ Builder(Comparator comparator, AnonymousClass1 anonymousClass1) {
            this(comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.EMPTY_SET);
        }

        private Builder(Comparator<B> comparator) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable), null);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i6) {
            Preconditions.checkArgument(i6 >= 0);
            this.expectedSize = i6;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i6) {
            Preconditions.checkArgument(i6 > 0);
            this.maximumSize = i6;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class Heap {
        final Ordering<E> ordering;

        @Weak
        @MonotonicNonNullDecl
        MinMaxPriorityQueue<E>.Heap otherHeap;

        @CanIgnoreReturnValue
        int bubbleUpAlternatingLevels(int i6, E e6) {
            while (i6 > 2) {
                int grandparentIndex = getGrandparentIndex(i6);
                Object elementData = MinMaxPriorityQueue.this.elementData(grandparentIndex);
                if (this.ordering.compare(elementData, e6) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i6] = elementData;
                i6 = grandparentIndex;
            }
            MinMaxPriorityQueue.this.queue[i6] = e6;
            return i6;
        }

        Heap(Ordering<E> ordering) {
            this.ordering = ordering;
        }

        private int getLeftChildIndex(int i6) {
            return (i6 * 2) + 1;
        }

        private int getParentIndex(int i6) {
            return (i6 - 1) / 2;
        }

        private int getRightChildIndex(int i6) {
            return (i6 * 2) + 2;
        }

        int compareElements(int i6, int i7) {
            return this.ordering.compare(MinMaxPriorityQueue.this.elementData(i6), MinMaxPriorityQueue.this.elementData(i7));
        }

        int crossOverUp(int i6, E e6) {
            int rightChildIndex;
            if (i6 == 0) {
                MinMaxPriorityQueue.this.queue[0] = e6;
                return 0;
            }
            int parentIndex = getParentIndex(i6);
            Object elementData = MinMaxPriorityQueue.this.elementData(parentIndex);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object elementData2 = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData2, elementData) < 0) {
                    parentIndex = rightChildIndex;
                    elementData = elementData2;
                }
            }
            if (this.ordering.compare(elementData, e6) >= 0) {
                MinMaxPriorityQueue.this.queue[i6] = e6;
                return i6;
            }
            MinMaxPriorityQueue.this.queue[i6] = elementData;
            MinMaxPriorityQueue.this.queue[parentIndex] = e6;
            return parentIndex;
        }

        int findMin(int i6, int i7) {
            if (i6 >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i6 > 0);
            int min = Math.min(i6, MinMaxPriorityQueue.this.size - i7) + i7;
            for (int i8 = i6 + 1; i8 < min; i8++) {
                if (compareElements(i8, i6) < 0) {
                    i6 = i8;
                }
            }
            return i6;
        }

        int swapWithConceptuallyLastElement(E e6) {
            int rightChildIndex;
            int parentIndex = getParentIndex(MinMaxPriorityQueue.this.size);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object elementData = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData, e6) < 0) {
                    MinMaxPriorityQueue.this.queue[rightChildIndex] = e6;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = elementData;
                    return rightChildIndex;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        private int getGrandparentIndex(int i6) {
            return getParentIndex(getParentIndex(i6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean verifyIndex(int i6) {
            if (getLeftChildIndex(i6) < MinMaxPriorityQueue.this.size && compareElements(i6, getLeftChildIndex(i6)) > 0) {
                return false;
            }
            if (getRightChildIndex(i6) < MinMaxPriorityQueue.this.size && compareElements(i6, getRightChildIndex(i6)) > 0) {
                return false;
            }
            if (i6 > 0 && compareElements(i6, getParentIndex(i6)) > 0) {
                return false;
            }
            if (i6 > 2 && compareElements(getGrandparentIndex(i6), i6) > 0) {
                return false;
            }
            return true;
        }

        void bubbleUp(int i6, E e6) {
            Heap heap;
            int crossOverUp = crossOverUp(i6, e6);
            if (crossOverUp == i6) {
                crossOverUp = i6;
                heap = this;
            } else {
                heap = this.otherHeap;
            }
            heap.bubbleUpAlternatingLevels(crossOverUp, e6);
        }

        int crossOver(int i6, E e6) {
            int findMinChild = findMinChild(i6);
            if (findMinChild > 0 && this.ordering.compare(MinMaxPriorityQueue.this.elementData(findMinChild), e6) < 0) {
                MinMaxPriorityQueue.this.queue[i6] = MinMaxPriorityQueue.this.elementData(findMinChild);
                MinMaxPriorityQueue.this.queue[findMinChild] = e6;
                return findMinChild;
            }
            return crossOverUp(i6, e6);
        }

        int fillHoleAt(int i6) {
            while (true) {
                int findMinGrandChild = findMinGrandChild(i6);
                if (findMinGrandChild > 0) {
                    MinMaxPriorityQueue.this.queue[i6] = MinMaxPriorityQueue.this.elementData(findMinGrandChild);
                    i6 = findMinGrandChild;
                } else {
                    return i6;
                }
            }
        }

        int findMinChild(int i6) {
            return findMin(getLeftChildIndex(i6), 2);
        }

        int findMinGrandChild(int i6) {
            int leftChildIndex = getLeftChildIndex(i6);
            if (leftChildIndex < 0) {
                return -1;
            }
            return findMin(getLeftChildIndex(leftChildIndex), 4);
        }

        MoveDesc<E> tryCrossOverAndBubbleUp(int i6, int i7, E e6) {
            Object elementData;
            int crossOver = crossOver(i7, e6);
            if (crossOver == i7) {
                return null;
            }
            if (crossOver < i6) {
                elementData = MinMaxPriorityQueue.this.elementData(i6);
            } else {
                elementData = MinMaxPriorityQueue.this.elementData(getParentIndex(i6));
            }
            if (this.otherHeap.bubbleUpAlternatingLevels(crossOver, e6) >= i6) {
                return null;
            }
            return new MoveDesc<>(e6, elementData);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;

        @MonotonicNonNullDecl
        private Queue<E> forgetMeNot;

        @NullableDecl
        private E lastFromForgetMeNot;
        private int nextCursor;

        @MonotonicNonNullDecl
        private List<E> skipMe;

        private QueueIterator() {
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.this.modCount;
        }

        private boolean removeExact(Object obj) {
            for (int i6 = 0; i6 < MinMaxPriorityQueue.this.size; i6++) {
                if (MinMaxPriorityQueue.this.queue[i6] == obj) {
                    MinMaxPriorityQueue.this.removeAt(i6);
                    return true;
                }
            }
            return false;
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void nextNotInSkipMe(int i6) {
            if (this.nextCursor < i6) {
                if (this.skipMe != null) {
                    while (i6 < MinMaxPriorityQueue.this.size() && foundAndRemovedExactReference(this.skipMe, MinMaxPriorityQueue.this.elementData(i6))) {
                        i6++;
                    }
                }
                this.nextCursor = i6;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor >= MinMaxPriorityQueue.this.size()) {
                Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
                this.lastFromForgetMeNot = null;
                return;
            }
            MoveDesc<E> removeAt = MinMaxPriorityQueue.this.removeAt(this.cursor);
            if (removeAt != null) {
                if (this.forgetMeNot == null) {
                    this.forgetMeNot = new ArrayDeque();
                    this.skipMe = new ArrayList(3);
                }
                if (!foundAndRemovedExactReference(this.skipMe, removeAt.toTrickle)) {
                    this.forgetMeNot.add(removeAt.toTrickle);
                }
                if (!foundAndRemovedExactReference(this.forgetMeNot, removeAt.replaced)) {
                    this.skipMe.add(removeAt.replaced);
                }
            }
            this.cursor--;
            this.nextCursor--;
        }

        private boolean foundAndRemovedExactReference(Iterable<E> iterable, E e6) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e6) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Queue<E> queue;
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size() || ((queue = this.forgetMeNot) != null && !queue.isEmpty())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                int i6 = this.nextCursor;
                this.cursor = i6;
                this.canRemove = true;
                return (E) MinMaxPriorityQueue.this.elementData(i6);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                E poll = this.forgetMeNot.poll();
                this.lastFromForgetMeNot = poll;
                if (poll != null) {
                    this.canRemove = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        /* synthetic */ QueueIterator(MinMaxPriorityQueue minMaxPriorityQueue, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* synthetic */ MinMaxPriorityQueue(Builder builder, int i6, AnonymousClass1 anonymousClass1) {
        this(builder, i6);
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural(), null).create();
    }

    @VisibleForTesting
    static int initialQueueSize(int i6, int i7, Iterable<?> iterable) {
        if (i6 == -1) {
            i6 = 11;
        }
        if (iterable instanceof Collection) {
            i6 = Math.max(i6, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i6, i7);
    }

    @VisibleForTesting
    static boolean isEvenLevel(int i6) {
        int i7 = ~(~(i6 + 1));
        Preconditions.checkState(i7 > 0, "negative index");
        return (EVEN_POWERS_OF_TWO & i7) > (i7 & ODD_POWERS_OF_TWO);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i6 = 0; i6 < this.size; i6++) {
            this.queue[i6] = null;
        }
        this.size = 0;
    }

    @VisibleForTesting
    boolean isIntact() {
        for (int i6 = 1; i6 < this.size; i6++) {
            if (!heapForIndex(i6).verifyIndex(i6)) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class MoveDesc<E> {
        final E replaced;
        final E toTrickle;

        MoveDesc(E e6, E e7) {
            this.toTrickle = e6;
            this.replaced = e7;
        }
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i6) {
        Ordering ordering = builder.ordering();
        MinMaxPriorityQueue<E>.Heap heap = new Heap(ordering);
        this.minHeap = heap;
        MinMaxPriorityQueue<E>.Heap heap2 = new Heap(ordering.reverse());
        this.maxHeap = heap2;
        heap.otherHeap = heap2;
        heap2.otherHeap = heap;
        this.maximumSize = ((Builder) builder).maximumSize;
        this.queue = new Object[i6];
    }

    private int calculateNewCapacity() {
        int length = this.queue.length;
        return capAtMaximumSize(length < 64 ? (length + 1) * 2 : IntMath.checkedMultiply(length / 2, 3), this.maximumSize);
    }

    private static int capAtMaximumSize(int i6, int i7) {
        return Math.min(i6 - 1, i7) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural(), null).create(iterable);
    }

    public static Builder<Comparable> expectedSize(int i6) {
        return new Builder(Ordering.natural(), null).expectedSize(i6);
    }

    private int getMaxElementIndex() {
        int i6 = this.size;
        if (i6 != 1) {
            return (i6 == 2 || this.maxHeap.compareElements(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    public static Builder<Comparable> maximumSize(int i6) {
        return new Builder(Ordering.natural(), null).maximumSize(i6);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator, null);
    }

    @VisibleForTesting
    int capacity() {
        return this.queue.length;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    E elementData(int i6) {
        return (E) this.queue[i6];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new QueueIterator(this, null);
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    MoveDesc<E> removeAt(int i6) {
        Preconditions.checkPositionIndex(i6, this.size);
        this.modCount++;
        int i7 = this.size - 1;
        this.size = i7;
        if (i7 == i6) {
            this.queue[i7] = null;
            return null;
        }
        E elementData = elementData(i7);
        int swapWithConceptuallyLastElement = heapForIndex(this.size).swapWithConceptuallyLastElement(elementData);
        if (swapWithConceptuallyLastElement == i6) {
            this.queue[this.size] = null;
            return null;
        }
        E elementData2 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> fillHole = fillHole(i6, elementData2);
        return swapWithConceptuallyLastElement < i6 ? fillHole == null ? new MoveDesc<>(elementData, elementData2) : new MoveDesc<>(elementData, fillHole.replaced) : fillHole;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i6 = this.size;
        Object[] objArr = new Object[i6];
        System.arraycopy(this.queue, 0, objArr, 0, i6);
        return objArr;
    }

    private MoveDesc<E> fillHole(int i6, E e6) {
        MinMaxPriorityQueue<E>.Heap heapForIndex = heapForIndex(i6);
        int fillHoleAt = heapForIndex.fillHoleAt(i6);
        int bubbleUpAlternatingLevels = heapForIndex.bubbleUpAlternatingLevels(fillHoleAt, e6);
        if (bubbleUpAlternatingLevels == fillHoleAt) {
            return heapForIndex.tryCrossOverAndBubbleUp(i6, fillHoleAt, e6);
        }
        if (bubbleUpAlternatingLevels < i6) {
            return new MoveDesc<>(e6, elementData(i6));
        }
        return null;
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int i6) {
        if (isEvenLevel(i6)) {
            return this.minHeap;
        }
        return this.maxHeap;
    }

    private E removeAndGet(int i6) {
        E elementData = elementData(i6);
        removeAt(i6);
        return elementData;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e6) {
        offer(e6);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            offer(it.next());
            z5 = true;
        }
        return z5;
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e6) {
        Preconditions.checkNotNull(e6);
        this.modCount++;
        int i6 = this.size;
        this.size = i6 + 1;
        growIfNeeded();
        heapForIndex(i6).bubbleUp(i6, e6);
        if (this.size <= this.maximumSize || pollLast() != e6) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elementData(getMaxElementIndex());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (!isEmpty()) {
            return removeAndGet(getMaxElementIndex());
        }
        throw new NoSuchElementException();
    }
}
