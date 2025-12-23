package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d<E> extends a<E> {

    /* renamed from: g, reason: collision with root package name */
    private static final Integer f54108g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: c, reason: collision with root package name */
    final AtomicLong f54109c;

    /* renamed from: d, reason: collision with root package name */
    long f54110d;

    /* renamed from: e, reason: collision with root package name */
    final AtomicLong f54111e;

    /* renamed from: f, reason: collision with root package name */
    final int f54112f;

    private long r() {
        return this.f54111e.get();
    }

    private long s() {
        return this.f54109c.get();
    }

    private void t(long j6) {
        this.f54111e.lazySet(j6);
    }

    private void u(long j6) {
        this.f54109c.lazySet(j6);
    }

    @Override // java.util.Queue
    public boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.f54104a;
        int i6 = this.f54105b;
        long j6 = this.f54109c.get();
        int d6 = d(j6, i6);
        if (j6 >= this.f54110d) {
            long j7 = this.f54112f + j6;
            if (j(atomicReferenceArray, d(j7, i6)) == null) {
                this.f54110d = j7;
            } else if (j(atomicReferenceArray, d6) != null) {
                return false;
            }
        }
        n(atomicReferenceArray, d6, e6);
        u(j6 + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return g(a(this.f54111e.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j6 = this.f54111e.get();
        int a6 = a(j6);
        AtomicReferenceArray<E> atomicReferenceArray = this.f54104a;
        E j7 = j(atomicReferenceArray, a6);
        if (j7 == null) {
            return null;
        }
        n(atomicReferenceArray, a6, null);
        t(j6 + 1);
        return j7;
    }

    public d(int i6) {
        super(i6);
        this.f54109c = new AtomicLong();
        this.f54111e = new AtomicLong();
        this.f54112f = Math.min(i6 / 4, f54108g.intValue());
    }

    @Override // rx.internal.util.atomic.a, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (s() == r()) {
            return true;
        }
        return false;
    }

    @Override // rx.internal.util.atomic.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long r5 = r();
        while (true) {
            long s5 = s();
            long r6 = r();
            if (r5 == r6) {
                return (int) (s5 - r6);
            }
            r5 = r6;
        }
    }
}
