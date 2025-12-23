package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    final int capacitySkip;
    final AtomicLong consumerIndex;
    final int mask;
    final AtomicLong producerIndex;

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T peek() {
        return get(this.mask & ((int) this.consumerIndex.get()));
    }

    @Override // java.util.Queue
    public T poll() {
        long j6 = this.consumerIndex.get();
        int i6 = ((int) j6) & this.mask;
        T t5 = get(i6);
        if (t5 == null) {
            return null;
        }
        this.consumerIndex.lazySet(j6 + 1);
        lazySet(i6, null);
        return t5;
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long j6 = this.consumerIndex.get();
        while (true) {
            long j7 = this.producerIndex.get();
            long j8 = this.consumerIndex.get();
            if (j6 == j8) {
                return (int) (j7 - j8);
            }
            j6 = j8;
        }
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public SpscExactAtomicArrayQueue(int i6) {
        super(p.b(i6));
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i6;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Queue
    public boolean offer(T t5) {
        t5.getClass();
        long j6 = this.producerIndex.get();
        int i6 = this.mask;
        if (get(((int) (this.capacitySkip + j6)) & i6) != null) {
            return false;
        }
        this.producerIndex.lazySet(j6 + 1);
        lazySet(i6 & ((int) j6), t5);
        return true;
    }
}
