package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: s, reason: collision with root package name */
    protected static final int f54242s;

    /* renamed from: t, reason: collision with root package name */
    protected static final int f54243t = 32;

    /* renamed from: u, reason: collision with root package name */
    private static final long f54244u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f54245v;

    /* renamed from: q, reason: collision with root package name */
    protected final long f54246q;

    /* renamed from: r, reason: collision with root package name */
    protected final E[] f54247r;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        f54242s = intValue;
        int arrayIndexScale = n0.f54298a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f54245v = intValue + 2;
        } else {
            if (8 != arrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f54245v = intValue + 3;
        }
        f54244u = r1.arrayBaseOffset(Object[].class) + (32 << (f54245v - intValue));
    }

    protected final long a(long j6) {
        return d(j6, this.f54246q);
    }

    protected final long d(long j6, long j7) {
        return f54244u + ((j6 & j7) << f54245v);
    }

    protected final E e(long j6) {
        return f(this.f54247r, j6);
    }

    protected final E f(E[] eArr, long j6) {
        return (E) n0.f54298a.getObject(eArr, j6);
    }

    protected final E g(long j6) {
        return j(this.f54247r, j6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final E j(E[] eArr, long j6) {
        return (E) n0.f54298a.getObjectVolatile(eArr, j6);
    }

    protected final void m(long j6, E e6) {
        n(this.f54247r, j6, e6);
    }

    protected final void n(E[] eArr, long j6, E e6) {
        n0.f54298a.putOrderedObject(eArr, j6, e6);
    }

    protected final void o(long j6, E e6) {
        p(this.f54247r, j6, e6);
    }

    protected final void p(E[] eArr, long j6, E e6) {
        n0.f54298a.putObject(eArr, j6, e6);
    }

    public f(int i6) {
        int b6 = p.b(i6);
        this.f54246q = b6 - 1;
        this.f54247r = (E[]) new Object[(b6 << f54242s) + 64];
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}
