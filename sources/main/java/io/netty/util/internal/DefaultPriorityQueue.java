package io.netty.util.internal;

import io.netty.util.internal.PriorityQueueNode;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultPriorityQueue<T extends PriorityQueueNode> extends AbstractQueue<T> implements PriorityQueue<T> {
    private static final PriorityQueueNode[] EMPTY_ARRAY = new PriorityQueueNode[0];
    private final Comparator<T> comparator;
    private T[] queue;
    private int size;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.internal.DefaultPriorityQueue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class PriorityQueueIterator implements Iterator<T> {
        private int index;

        private PriorityQueueIterator() {
        }

        /* synthetic */ PriorityQueueIterator(DefaultPriorityQueue defaultPriorityQueue, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < DefaultPriorityQueue.this.size;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.index >= DefaultPriorityQueue.this.size) {
                throw new NoSuchElementException();
            }
            PriorityQueueNode[] priorityQueueNodeArr = DefaultPriorityQueue.this.queue;
            int i6 = this.index;
            this.index = i6 + 1;
            return (T) priorityQueueNodeArr[i6];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i6 = 0; i6 < this.size; i6++) {
            T t5 = this.queue[i6];
            if (t5 != null) {
                t5.priorityQueueIndex(this, -1);
                this.queue[i6] = null;
            }
        }
        this.size = 0;
    }

    @Override // io.netty.util.internal.PriorityQueue
    public void clearIgnoringIndexes() {
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof PriorityQueueNode)) {
            return false;
        }
        PriorityQueueNode priorityQueueNode = (PriorityQueueNode) obj;
        return contains(priorityQueueNode, priorityQueueNode.priorityQueueIndex(this));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    private void bubbleDown(int i6, T t5) {
        int i7 = this.size >>> 1;
        while (i6 < i7) {
            int i8 = i6 << 1;
            int i9 = i8 + 1;
            T[] tArr = this.queue;
            T t6 = tArr[i9];
            int i10 = i8 + 2;
            if (i10 >= this.size || this.comparator.compare(t6, tArr[i10]) <= 0) {
                i10 = i9;
            } else {
                t6 = this.queue[i10];
            }
            if (this.comparator.compare(t5, t6) <= 0) {
                break;
            }
            this.queue[i6] = t6;
            t6.priorityQueueIndex(this, i6);
            i6 = i10;
        }
        this.queue[i6] = t5;
        t5.priorityQueueIndex(this, i6);
    }

    private void bubbleUp(int i6, T t5) {
        while (i6 > 0) {
            int i7 = (i6 - 1) >>> 1;
            T t6 = this.queue[i7];
            if (this.comparator.compare(t5, t6) >= 0) {
                break;
            }
            this.queue[i6] = t6;
            t6.priorityQueueIndex(this, i6);
            i6 = i7;
        }
        this.queue[i6] = t5;
        t5.priorityQueueIndex(this, i6);
    }

    @Override // io.netty.util.internal.PriorityQueue
    public boolean containsTyped(T t5) {
        return contains(t5, t5.priorityQueueIndex(this));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new PriorityQueueIterator(this, null);
    }

    @Override // java.util.Queue
    public boolean offer(T t5) {
        if (t5.priorityQueueIndex(this) == -1) {
            int i6 = this.size;
            T[] tArr = this.queue;
            if (i6 >= tArr.length) {
                this.queue = (T[]) ((PriorityQueueNode[]) Arrays.copyOf(tArr, tArr.length + (tArr.length < 64 ? tArr.length + 2 : tArr.length >>> 1)));
            }
            int i7 = this.size;
            this.size = i7 + 1;
            bubbleUp(i7, t5);
            return true;
        }
        throw new IllegalArgumentException("e.priorityQueueIndex(): " + t5.priorityQueueIndex(this) + " (expected: -1) + e: " + t5);
    }

    @Override // java.util.Queue
    public T peek() {
        if (this.size == 0) {
            return null;
        }
        return this.queue[0];
    }

    @Override // java.util.Queue
    public T poll() {
        if (this.size == 0) {
            return null;
        }
        T t5 = this.queue[0];
        t5.priorityQueueIndex(this, -1);
        T[] tArr = this.queue;
        int i6 = this.size - 1;
        this.size = i6;
        T t6 = tArr[i6];
        tArr[i6] = null;
        if (i6 != 0) {
            bubbleDown(0, t6);
        }
        return t5;
    }

    @Override // io.netty.util.internal.PriorityQueue
    public void priorityChanged(T t5) {
        int priorityQueueIndex = t5.priorityQueueIndex(this);
        if (contains(t5, priorityQueueIndex)) {
            if (priorityQueueIndex == 0) {
                bubbleDown(priorityQueueIndex, t5);
                return;
            }
            if (this.comparator.compare(t5, this.queue[(priorityQueueIndex - 1) >>> 1]) < 0) {
                bubbleUp(priorityQueueIndex, t5);
            } else {
                bubbleDown(priorityQueueIndex, t5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return removeTyped((DefaultPriorityQueue<T>) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // io.netty.util.internal.PriorityQueue
    public boolean removeTyped(T t5) {
        int priorityQueueIndex = t5.priorityQueueIndex(this);
        if (!contains(t5, priorityQueueIndex)) {
            return false;
        }
        t5.priorityQueueIndex(this, -1);
        int i6 = this.size - 1;
        this.size = i6;
        if (i6 == 0 || i6 == priorityQueueIndex) {
            this.queue[priorityQueueIndex] = null;
            return true;
        }
        T[] tArr = this.queue;
        T t6 = tArr[i6];
        tArr[priorityQueueIndex] = t6;
        tArr[i6] = null;
        if (this.comparator.compare(t5, t6) < 0) {
            bubbleDown(priorityQueueIndex, t6);
        } else {
            bubbleUp(priorityQueueIndex, t6);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <X> X[] toArray(X[] xArr) {
        int length = xArr.length;
        int i6 = this.size;
        if (length < i6) {
            return (X[]) Arrays.copyOf(this.queue, i6, xArr.getClass());
        }
        System.arraycopy(this.queue, 0, xArr, 0, i6);
        int length2 = xArr.length;
        int i7 = this.size;
        if (length2 > i7) {
            xArr[i7] = null;
        }
        return xArr;
    }

    public DefaultPriorityQueue(Comparator<T> comparator, int i6) {
        PriorityQueueNode[] priorityQueueNodeArr;
        this.comparator = (Comparator) ObjectUtil.checkNotNull(comparator, "comparator");
        if (i6 != 0) {
            priorityQueueNodeArr = new PriorityQueueNode[i6];
        } else {
            priorityQueueNodeArr = EMPTY_ARRAY;
        }
        this.queue = (T[]) priorityQueueNodeArr;
    }

    private boolean contains(PriorityQueueNode priorityQueueNode, int i6) {
        return i6 >= 0 && i6 < this.size && priorityQueueNode.equals(this.queue[i6]);
    }
}
