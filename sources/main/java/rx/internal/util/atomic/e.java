package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e<T> implements Queue<T> {

    /* renamed from: i, reason: collision with root package name */
    static final int f54113i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f54114j = new Object();

    /* renamed from: a, reason: collision with root package name */
    final AtomicLong f54115a;

    /* renamed from: b, reason: collision with root package name */
    int f54116b;

    /* renamed from: c, reason: collision with root package name */
    long f54117c;

    /* renamed from: d, reason: collision with root package name */
    int f54118d;

    /* renamed from: e, reason: collision with root package name */
    AtomicReferenceArray<Object> f54119e;

    /* renamed from: f, reason: collision with root package name */
    int f54120f;

    /* renamed from: g, reason: collision with root package name */
    AtomicReferenceArray<Object> f54121g;

    /* renamed from: h, reason: collision with root package name */
    final AtomicLong f54122h;

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
        this.f54116b = Math.min(i6 / 4, f54113i);
    }

    private long f() {
        return this.f54122h.get();
    }

    private long g() {
        return this.f54115a.get();
    }

    private long j() {
        return this.f54122h.get();
    }

    private long o() {
        return this.f54115a.get();
    }

    private T p(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6) {
        this.f54121g = atomicReferenceArray;
        return (T) m(atomicReferenceArray, e(j6, i6));
    }

    private T q(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6) {
        this.f54121g = atomicReferenceArray;
        int e6 = e(j6, i6);
        T t5 = (T) m(atomicReferenceArray, e6);
        if (t5 == null) {
            return null;
        }
        u(atomicReferenceArray, e6, null);
        t(j6 + 1);
        return t5;
    }

    private void t(long j6) {
        this.f54122h.lazySet(j6);
    }

    private void w(long j6) {
        this.f54115a.lazySet(j6);
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
    public boolean offer(T t5) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f54119e;
        long g6 = g();
        int i6 = this.f54118d;
        int e6 = e(g6, i6);
        if (g6 < this.f54117c) {
            return x(atomicReferenceArray, t5, g6, e6);
        }
        long j6 = this.f54116b + g6;
        if (m(atomicReferenceArray, e(j6, i6)) == null) {
            this.f54117c = j6 - 1;
            return x(atomicReferenceArray, t5, g6, e6);
        }
        if (m(atomicReferenceArray, e(g6 + 1, i6)) == null) {
            return x(atomicReferenceArray, t5, g6, e6);
        }
        s(atomicReferenceArray, g6, e6, t5, i6);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f54121g;
        long f6 = f();
        int i6 = this.f54120f;
        T t5 = (T) m(atomicReferenceArray, e(f6, i6));
        return t5 == f54114j ? p(n(atomicReferenceArray), f6, i6) : t5;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f54121g;
        long f6 = f();
        int i6 = this.f54120f;
        int e6 = e(f6, i6);
        T t5 = (T) m(atomicReferenceArray, e6);
        boolean z5 = t5 == f54114j;
        if (t5 == null || z5) {
            if (z5) {
                return q(n(atomicReferenceArray), f6, i6);
            }
            return null;
        }
        u(atomicReferenceArray, e6, null);
        t(f6 + 1);
        return t5;
    }

    public boolean r(T t5, T t6) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f54119e;
        long o5 = o();
        int i6 = this.f54118d;
        long j6 = 2 + o5;
        if (m(atomicReferenceArray, e(j6, i6)) == null) {
            int e6 = e(o5, i6);
            u(atomicReferenceArray, e6 + 1, t6);
            u(atomicReferenceArray, e6, t5);
            w(j6);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f54119e = atomicReferenceArray2;
        int e7 = e(o5, i6);
        u(atomicReferenceArray2, e7 + 1, t6);
        u(atomicReferenceArray2, e7, t5);
        v(atomicReferenceArray, atomicReferenceArray2);
        u(atomicReferenceArray, e7, f54114j);
        w(j6);
        return true;
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

    public e(int i6) {
        int b6 = p.b(i6);
        int i7 = b6 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b6 + 1);
        this.f54119e = atomicReferenceArray;
        this.f54118d = i7;
        a(b6);
        this.f54121g = atomicReferenceArray;
        this.f54120f = i7;
        this.f54117c = b6 - 2;
        this.f54115a = new AtomicLong();
        this.f54122h = new AtomicLong();
    }

    private static <E> Object m(AtomicReferenceArray<Object> atomicReferenceArray, int i6) {
        return atomicReferenceArray.get(i6);
    }

    private AtomicReferenceArray<Object> n(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) m(atomicReferenceArray, d(atomicReferenceArray.length() - 1));
    }

    private void s(AtomicReferenceArray<Object> atomicReferenceArray, long j6, int i6, T t5, long j7) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f54119e = atomicReferenceArray2;
        this.f54117c = (j7 + j6) - 1;
        u(atomicReferenceArray2, i6, t5);
        v(atomicReferenceArray, atomicReferenceArray2);
        u(atomicReferenceArray, i6, f54114j);
        w(j6 + 1);
    }

    private static void u(AtomicReferenceArray<Object> atomicReferenceArray, int i6, Object obj) {
        atomicReferenceArray.lazySet(i6, obj);
    }

    private void v(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        u(atomicReferenceArray, d(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private boolean x(AtomicReferenceArray<Object> atomicReferenceArray, T t5, long j6, int i6) {
        u(atomicReferenceArray, i6, t5);
        w(j6 + 1);
        return true;
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
