package kotlinx.coroutines.internal;

import defpackage.H5BaseWebChromeClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n299#2,3:309\n299#2,3:312\n299#2,3:315\n299#2,3:318\n299#2,3:321\n299#2,3:325\n299#2,3:328\n1#3:324\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n91#1:309,3\n92#1:312,3\n107#1:315,3\n167#1:318,3\n200#1:321,3\n231#1:325,3\n247#1:328,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0<E> {

    /* renamed from: h, reason: collision with root package name */
    public static final int f49219h = 8;

    /* renamed from: i, reason: collision with root package name */
    public static final int f49220i = 30;

    /* renamed from: j, reason: collision with root package name */
    public static final int f49221j = 1073741823;

    /* renamed from: k, reason: collision with root package name */
    public static final int f49222k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static final long f49223l = 1073741823;

    /* renamed from: m, reason: collision with root package name */
    public static final int f49224m = 30;

    /* renamed from: n, reason: collision with root package name */
    public static final long f49225n = 1152921503533105152L;

    /* renamed from: o, reason: collision with root package name */
    public static final int f49226o = 60;

    /* renamed from: p, reason: collision with root package name */
    public static final long f49227p = 1152921504606846976L;

    /* renamed from: q, reason: collision with root package name */
    public static final int f49228q = 61;

    /* renamed from: r, reason: collision with root package name */
    public static final long f49229r = 2305843009213693952L;

    /* renamed from: s, reason: collision with root package name */
    public static final int f49230s = 1024;

    /* renamed from: u, reason: collision with root package name */
    public static final int f49232u = 0;

    /* renamed from: v, reason: collision with root package name */
    public static final int f49233v = 1;

    /* renamed from: w, reason: collision with root package name */
    public static final int f49234w = 2;

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    private final int f49235a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f49236b;

    /* renamed from: c, reason: collision with root package name */
    private final int f49237c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray f49238d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f49216e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49217f = AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f49218g = AtomicLongFieldUpdater.newUpdater(a0.class, "_state");

    /* renamed from: t, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final s0 f49231t = new s0("REMOVE_FROZEN");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        public final long e(long j6, long j7) {
            return j6 & (~j7);
        }

        private a() {
        }

        public final int a(long j6) {
            return (j6 & a0.f49229r) != 0 ? 2 : 1;
        }

        public final long b(long j6, int i6) {
            return e(j6, a0.f49223l) | i6;
        }

        public final <T> T d(long j6, @NotNull Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return function2.invoke(Integer.valueOf((int) (a0.f49223l & j6)), Integer.valueOf((int) ((j6 & a0.f49225n) >> 30)));
        }

        public final long c(long j6, int i6) {
            return e(j6, a0.f49225n) | (i6 << 30);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        public final int f49239a;

        public b(int i6) {
            this.f49239a = i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final a0<E> b(long j6) {
        a0<E> a0Var = new a0<>(this.f49235a * 2, this.f49236b);
        int i6 = (int) (f49223l & j6);
        int i7 = (int) ((f49225n & j6) >> 30);
        while (true) {
            int i8 = this.f49237c;
            if ((i6 & i8) == (i7 & i8)) {
                f49218g.set(a0Var, f49216e.e(j6, f49227p));
                return a0Var;
            }
            Object obj = this.f49238d.get(i8 & i6);
            if (obj == null) {
                obj = new b(i6);
            }
            a0Var.f49238d.set(a0Var.f49237c & i6, obj);
            i6++;
        }
    }

    private final a0<E> c(long j6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49217f;
        while (true) {
            a0<E> a0Var = (a0) atomicReferenceFieldUpdater.get(this);
            if (a0Var != null) {
                return a0Var;
            }
            androidx.concurrent.futures.a.a(f49217f, this, null, b(j6));
        }
    }

    private final a0<E> e(int i6, E e6) {
        Object obj = this.f49238d.get(this.f49237c & i6);
        if (!(obj instanceof b) || ((b) obj).f49239a != i6) {
            return null;
        }
        this.f49238d.set(i6 & this.f49237c, e6);
        return this;
    }

    private final long l() {
        long j6;
        long j7;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49218g;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            if ((j6 & f49227p) != 0) {
                return j6;
            }
            j7 = f49227p | j6;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, j7));
        return j7;
    }

    private final a0<E> o(int i6, int i7) {
        long j6;
        int i8;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49218g;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            i8 = (int) (f49223l & j6);
            if ((f49227p & j6) != 0) {
                return m();
            }
        } while (!f49218g.compareAndSet(this, j6, f49216e.b(j6, i7)));
        this.f49238d.set(this.f49237c & i8, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(@org.jetbrains.annotations.NotNull E r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.a0.f49218g
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L16
            kotlinx.coroutines.internal.a0$a r13 = kotlinx.coroutines.internal.a0.f49216e
            int r13 = r13.a(r3)
            return r13
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r9 = (int) r5
            int r10 = r12.f49237c
            int r1 = r9 + 2
            r1 = r1 & r10
            r5 = r2 & r10
            r6 = 1
            if (r1 != r5) goto L30
            return r6
        L30:
            boolean r1 = r12.f49236b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f49238d
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L4f
            int r1 = r12.f49235a
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L4e
            int r9 = r9 - r2
            r2 = r9 & r5
            int r1 = r1 >> 1
            if (r2 <= r1) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.a0.f49218g
            kotlinx.coroutines.internal.a0$a r5 = kotlinx.coroutines.internal.a0.f49216e
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r2.f49238d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r2
        L6a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.a0.f49218g
            long r3 = r1.get(r0)
            r5 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r3 = r3 & r5
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 == 0) goto L81
            kotlinx.coroutines.internal.a0 r0 = r0.m()
            kotlinx.coroutines.internal.a0 r0 = r0.e(r9, r13)
            if (r0 != 0) goto L6a
        L81:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.a0.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49218g;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            if ((j6 & f49229r) != 0) {
                return true;
            }
            if ((f49227p & j6) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, f49229r | j6));
        return true;
    }

    public final int f() {
        long j6 = f49218g.get(this);
        return 1073741823 & (((int) ((j6 & f49225n) >> 30)) - ((int) (f49223l & j6)));
    }

    public final boolean g() {
        return (f49218g.get(this) & f49229r) != 0;
    }

    public final boolean h() {
        long j6 = f49218g.get(this);
        return ((int) (f49223l & j6)) == ((int) ((j6 & f49225n) >> 30));
    }

    @NotNull
    public final <R> List<R> k(@NotNull Function1<? super E, ? extends R> function1) {
        ArrayList arrayList = new ArrayList(this.f49235a);
        long j6 = f49218g.get(this);
        int i6 = (int) (f49223l & j6);
        int i7 = (int) ((j6 & f49225n) >> 30);
        while (true) {
            int i8 = this.f49237c;
            if ((i6 & i8) == (i7 & i8)) {
                return arrayList;
            }
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) this.f49238d.get(i8 & i6);
            if (h5BaseWebChromeClient != null && !(h5BaseWebChromeClient instanceof b)) {
                arrayList.add(function1.invoke(h5BaseWebChromeClient));
            }
            i6++;
        }
    }

    @Nullable
    public final Object n() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49218g;
        while (true) {
            long j6 = atomicLongFieldUpdater.get(this);
            if ((f49227p & j6) != 0) {
                return f49231t;
            }
            int i6 = (int) (f49223l & j6);
            int i7 = (int) ((f49225n & j6) >> 30);
            int i8 = this.f49237c;
            if ((i7 & i8) == (i6 & i8)) {
                return null;
            }
            Object obj = this.f49238d.get(i8 & i6);
            if (obj == null) {
                if (this.f49236b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i9 = (i6 + 1) & f49221j;
                if (f49218g.compareAndSet(this, j6, f49216e.b(j6, i9))) {
                    this.f49238d.set(this.f49237c & i6, null);
                    return obj;
                }
                if (this.f49236b) {
                    a0<E> a0Var = this;
                    do {
                        a0Var = a0Var.o(i6, i9);
                    } while (a0Var != null);
                    return obj;
                }
            }
        }
    }

    public a0(int i6, boolean z5) {
        this.f49235a = i6;
        this.f49236b = z5;
        int i7 = i6 - 1;
        this.f49237c = i7;
        this.f49238d = new AtomicReferenceArray(i6);
        if (i7 <= 1073741823) {
            if ((i6 & i7) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    private final void i(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, n1> function1, Object obj) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final void j(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final void p(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1, Object obj) {
        while (true) {
            long j6 = atomicLongFieldUpdater.get(obj);
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            Object obj2 = obj;
            if (atomicLongFieldUpdater2.compareAndSet(obj2, j6, function1.invoke(Long.valueOf(j6)).longValue())) {
                return;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            obj = obj2;
        }
    }

    private final long q(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1, Object obj) {
        while (true) {
            long j6 = atomicLongFieldUpdater.get(obj);
            Long invoke = function1.invoke(Long.valueOf(j6));
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            Object obj2 = obj;
            if (atomicLongFieldUpdater2.compareAndSet(obj2, j6, invoke.longValue())) {
                return invoke.longValue();
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            obj = obj2;
        }
    }

    @NotNull
    public final a0<E> m() {
        return c(l());
    }
}
