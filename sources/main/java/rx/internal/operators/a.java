package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final long f52486a = Long.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    static final long f52487b = Long.MAX_VALUE;

    public static long a(long j6, long j7) {
        long j8 = j6 + j7;
        if (j8 < 0) {
            return Long.MAX_VALUE;
        }
        return j8;
    }

    public static long c(long j6, long j7) {
        long j8 = j6 * j7;
        if (((j6 | j7) >>> 31) == 0 || j7 == 0 || j8 / j7 == j6) {
            return j8;
        }
        return Long.MAX_VALUE;
    }

    public static <T, R> boolean h(AtomicLong atomicLong, long j6, Queue<T> queue, rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar) {
        long j7;
        long j8;
        if (j6 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j6);
        }
        if (j6 == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        }
        do {
            j7 = atomicLong.get();
            j8 = j7 & Long.MIN_VALUE;
        } while (!atomicLong.compareAndSet(j7, a(Long.MAX_VALUE & j7, j6) | j8));
        if (j7 != Long.MIN_VALUE) {
            return j8 == 0;
        }
        f(atomicLong, queue, lVar, pVar);
        return false;
    }

    public static boolean j(long j6) {
        if (j6 >= 0) {
            return j6 != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j6);
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static long b(AtomicLong atomicLong, long j6) {
        long j7;
        do {
            j7 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j7, a(j7, j6)));
        return j7;
    }

    public static <T> void d(AtomicLong atomicLong, Queue<T> queue, rx.l<? super T> lVar) {
        e(atomicLong, queue, lVar, rx.internal.util.n.c());
    }

    public static <T, R> void e(AtomicLong atomicLong, Queue<T> queue, rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar) {
        long j6;
        do {
            j6 = atomicLong.get();
            if ((j6 & Long.MIN_VALUE) != 0) {
                return;
            }
        } while (!atomicLong.compareAndSet(j6, Long.MIN_VALUE | j6));
        if (j6 != 0) {
            f(atomicLong, queue, lVar, pVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        r0 = r10.addAndGet(-(r6 & Long.MAX_VALUE));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T, R> void f(java.util.concurrent.atomic.AtomicLong r10, java.util.Queue<T> r11, rx.l<? super R> r12, rx.functions.p<? super T, ? extends R> r13) {
        /*
            long r0 = r10.get()
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L26
        Ld:
            boolean r10 = r12.isUnsubscribed()
            if (r10 == 0) goto L14
            goto L6f
        L14:
            java.lang.Object r10 = r11.poll()
            if (r10 != 0) goto L1e
            r12.onCompleted()
            return
        L1e:
            java.lang.Object r10 = r13.call(r10)
            r12.onNext(r10)
            goto Ld
        L26:
            r4 = -9223372036854775808
        L28:
            r6 = r4
        L29:
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 == 0) goto L49
            boolean r8 = r12.isUnsubscribed()
            if (r8 == 0) goto L34
            goto L6f
        L34:
            java.lang.Object r8 = r11.poll()
            if (r8 != 0) goto L3e
            r12.onCompleted()
            return
        L3e:
            java.lang.Object r8 = r13.call(r8)
            r12.onNext(r8)
            r8 = 1
            long r6 = r6 + r8
            goto L29
        L49:
            if (r8 != 0) goto L5c
            boolean r0 = r12.isUnsubscribed()
            if (r0 == 0) goto L52
            goto L6f
        L52:
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L5c
            r12.onCompleted()
            return
        L5c:
            long r0 = r10.get()
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 != 0) goto L29
            long r0 = r6 & r2
            long r0 = -r0
            long r0 = r10.addAndGet(r0)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L28
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.a.f(java.util.concurrent.atomic.AtomicLong, java.util.Queue, rx.l, rx.functions.p):void");
    }

    public static <T> boolean g(AtomicLong atomicLong, long j6, Queue<T> queue, rx.l<? super T> lVar) {
        return h(atomicLong, j6, queue, lVar, rx.internal.util.n.c());
    }

    public static long i(AtomicLong atomicLong, long j6) {
        long j7;
        long j8;
        do {
            j7 = atomicLong.get();
            if (j7 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j8 = j7 - j6;
            if (j8 < 0) {
                throw new IllegalStateException("More produced than requested: " + j8);
            }
        } while (!atomicLong.compareAndSet(j7, j8));
        return j8;
    }
}
