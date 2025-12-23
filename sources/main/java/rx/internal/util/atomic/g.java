package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g<T> implements Queue<T> {

    /* renamed from: i, reason: collision with root package name */
    static final int f54123i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f54124j = new Object();

    /* renamed from: a, reason: collision with root package name */
    final AtomicLong f54125a;

    /* renamed from: b, reason: collision with root package name */
    int f54126b;

    /* renamed from: c, reason: collision with root package name */
    long f54127c;

    /* renamed from: d, reason: collision with root package name */
    int f54128d;

    /* renamed from: e, reason: collision with root package name */
    AtomicReferenceArray<Object> f54129e;

    /* renamed from: f, reason: collision with root package name */
    int f54130f;

    /* renamed from: g, reason: collision with root package name */
    AtomicReferenceArray<Object> f54131g;

    /* renamed from: h, reason: collision with root package name */
    final AtomicLong f54132h;

    private static int e(long j6, int i6) {
        return d(((int) j6) & i6);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    private void a(int i6) {
        this.f54126b = Math.min(i6 / 4, f54123i);
    }

    private long f() {
        return this.f54132h.get();
    }

    private long g() {
        return this.f54125a.get();
    }

    private long j() {
        return this.f54132h.get();
    }

    private long o() {
        return this.f54125a.get();
    }

    private T p(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6) {
        this.f54131g = atomicReferenceArray;
        return (T) m(atomicReferenceArray, e(j6, i6));
    }

    private T q(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6) {
        this.f54131g = atomicReferenceArray;
        int e6 = e(j6, i6);
        T t5 = (T) m(atomicReferenceArray, e6);
        if (t5 == null) {
            return null;
        }
        s(j6 + 1);
        t(atomicReferenceArray, e6, null);
        return t5;
    }

    private void s(long j6) {
        this.f54132h.lazySet(j6);
    }

    private void v(long j6) {
        this.f54125a.lazySet(j6);
    }

    private boolean w(AtomicReferenceArray<Object> atomicReferenceArray, T t5, long j6, int i6) {
        v(j6 + 1);
        t(atomicReferenceArray, i6, t5);
        return true;
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

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f54131g;
        long f6 = f();
        int i6 = this.f54130f;
        T t5 = (T) m(atomicReferenceArray, e(f6, i6));
        return t5 == f54124j ? p(n(atomicReferenceArray), f6, i6) : t5;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f54131g;
        long f6 = f();
        int i6 = this.f54130f;
        int e6 = e(f6, i6);
        T t5 = (T) m(atomicReferenceArray, e6);
        boolean z5 = t5 == f54124j;
        if (t5 == null || z5) {
            if (z5) {
                return q(n(atomicReferenceArray), f6, i6);
            }
            return null;
        }
        s(f6 + 1);
        t(atomicReferenceArray, e6, null);
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
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public g(int i6) {
        int b6 = p.b(Math.max(8, i6));
        int i7 = b6 - 1;
        this.f54125a = new AtomicLong();
        this.f54132h = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b6 + 1);
        this.f54129e = atomicReferenceArray;
        this.f54128d = i7;
        a(b6);
        this.f54131g = atomicReferenceArray;
        this.f54130f = i7;
        this.f54127c = b6 - 2;
        v(0L);
    }

    private static <E> Object m(AtomicReferenceArray<Object> atomicReferenceArray, int i6) {
        return atomicReferenceArray.get(i6);
    }

    private AtomicReferenceArray<Object> n(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) m(atomicReferenceArray, d(atomicReferenceArray.length() - 1));
    }

    private void r(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6, T t5, long j7) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f54129e = atomicReferenceArray2;
        this.f54127c = (j7 + j6) - 1;
        v(j6 + 1);
        t(atomicReferenceArray2, i6, t5);
        u(atomicReferenceArray, atomicReferenceArray2);
        t(atomicReferenceArray, i6, f54124j);
    }

    private static void t(AtomicReferenceArray<Object> atomicReferenceArray, int i6, Object obj) {
        atomicReferenceArray.lazySet(i6, obj);
    }

    private void u(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        t(atomicReferenceArray, d(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (o() == j()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue
    public boolean offer(T t5) {
        t5.getClass();
        AtomicReferenceArray<Object> atomicReferenceArray = this.f54129e;
        long g6 = g();
        int i6 = this.f54128d;
        int e6 = e(g6, i6);
        if (g6 < this.f54127c) {
            return w(atomicReferenceArray, t5, g6, e6);
        }
        long j6 = this.f54126b + g6;
        if (m(atomicReferenceArray, e(j6, i6)) == null) {
            this.f54127c = j6 - 1;
            return w(atomicReferenceArray, t5, g6, e6);
        }
        if (m(atomicReferenceArray, e(g6 + 1, i6)) != null) {
            return w(atomicReferenceArray, t5, g6, e6);
        }
        r(atomicReferenceArray, g6, e6, t5, i6);
        return true;
    }

    @Override // java.util.Collection
    public int size() {
        long j6 = j();
        while (true) {
            long o5 = o();
            long j7 = j();
            if (j6 == j7) {
                return (int) (o5 - j7);
            }
            j6 = j7;
        }
    }

    private static int d(int i6) {
        return i6;
    }
}
