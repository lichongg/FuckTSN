package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressAnimalSniffer
/* loaded from: D:\Downloads\app\classes9.dex */
public class h0<E> extends j0<E> implements q {

    /* renamed from: u, reason: collision with root package name */
    private static final long f54268u;

    /* renamed from: v, reason: collision with root package name */
    private static final long f54269v;

    /* renamed from: w, reason: collision with root package name */
    private static final long f54270w;

    /* renamed from: x, reason: collision with root package name */
    private static final int f54271x;

    /* renamed from: t, reason: collision with root package name */
    static final int f54267t = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: y, reason: collision with root package name */
    private static final Object f54272y = new Object();

    private static long e(long j6, long j7) {
        return d(j6 & j7);
    }

    private E[] j(E[] eArr) {
        return (E[]) ((Object[]) g(eArr, d(eArr.length - 1)));
    }

    private void p(E[] eArr, long j6, long j7, E e6, long j8) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.f54293d = eArr2;
        this.f54291b = (j8 + j6) - 1;
        r(eArr2, j7, e6);
        s(eArr, eArr2);
        r(eArr, j7, f54272y);
        t(j6 + 1);
    }

    private void s(E[] eArr, E[] eArr2) {
        r(eArr, d(eArr.length - 1), eArr2);
    }

    static {
        Unsafe unsafe = n0.f54298a;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f54271x = 2;
        } else {
            if (8 != arrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f54271x = 3;
        }
        f54270w = unsafe.arrayBaseOffset(Object[].class);
        try {
            f54268u = unsafe.objectFieldOffset(m0.class.getDeclaredField("producerIndex"));
            try {
                f54269v = unsafe.objectFieldOffset(j0.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e6) {
                InternalError internalError = new InternalError();
                internalError.initCause(e6);
                throw internalError;
            }
        } catch (NoSuchFieldException e7) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e7);
            throw internalError2;
        }
    }

    private void a(int i6) {
        this.f54290a = Math.min(i6 / 4, f54267t);
    }

    private static long d(long j6) {
        return f54270w + (j6 << f54271x);
    }

    private long f() {
        return n0.f54298a.getLongVolatile(this, f54269v);
    }

    private static <E> Object g(E[] eArr, long j6) {
        return n0.f54298a.getObjectVolatile(eArr, j6);
    }

    private long m() {
        return n0.f54298a.getLongVolatile(this, f54268u);
    }

    private E n(E[] eArr, long j6, long j7) {
        this.f54274s = eArr;
        return (E) g(eArr, e(j6, j7));
    }

    private E o(E[] eArr, long j6, long j7) {
        this.f54274s = eArr;
        long e6 = e(j6, j7);
        E e7 = (E) g(eArr, e6);
        if (e7 == null) {
            return null;
        }
        r(eArr, e6, null);
        q(j6 + 1);
        return e7;
    }

    private void q(long j6) {
        n0.f54298a.putOrderedLong(this, f54269v, j6);
    }

    private static void r(Object[] objArr, long j6, Object obj) {
        n0.f54298a.putOrderedObject(objArr, j6, obj);
    }

    private void t(long j6) {
        n0.f54298a.putOrderedLong(this, f54268u, j6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(E e6) {
        if (e6 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.f54293d;
        long j6 = this.producerIndex;
        long j7 = this.f54292c;
        long e7 = e(j6, j7);
        if (j6 < this.f54291b) {
            return u(eArr, e6, j6, e7);
        }
        long j8 = this.f54290a + j6;
        if (g(eArr, e(j8, j7)) == null) {
            this.f54291b = j8 - 1;
            return u(eArr, e6, j6, e7);
        }
        if (g(eArr, e(j6 + 1, j7)) != null) {
            return u(eArr, e6, j6, e7);
        }
        p(eArr, j6, e7, e6, j7);
        return true;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.f54274s;
        long j6 = this.consumerIndex;
        long j7 = this.f54273r;
        E e6 = (E) g(eArr, e(j6, j7));
        return e6 == f54272y ? n(j(eArr), j6, j7) : e6;
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.f54274s;
        long j6 = this.consumerIndex;
        long j7 = this.f54273r;
        long e6 = e(j6, j7);
        E e7 = (E) g(eArr, e6);
        boolean z5 = e7 == f54272y;
        if (e7 == null || z5) {
            if (z5) {
                return o(j(eArr), j6, j7);
            }
            return null;
        }
        r(eArr, e6, null);
        q(j6 + 1);
        return e7;
    }

    public h0(int i6) {
        int b6 = p.b(i6);
        long j6 = b6 - 1;
        E[] eArr = (E[]) new Object[b6 + 1];
        this.f54293d = eArr;
        this.f54292c = j6;
        a(b6);
        this.f54274s = eArr;
        this.f54273r = j6;
        this.f54291b = j6 - 1;
        t(0L);
    }

    private boolean u(E[] eArr, E e6, long j6, long j7) {
        r(eArr, j7, e6);
        t(j6 + 1);
        return true;
    }

    @Override // rx.internal.util.unsafe.q
    public long currentConsumerIndex() {
        return f();
    }

    @Override // rx.internal.util.unsafe.q
    public long currentProducerIndex() {
        return m();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long f6 = f();
        while (true) {
            long m6 = m();
            long f7 = f();
            if (f6 == f7) {
                return (int) (m6 - f7);
            }
            f6 = f7;
        }
    }
}
