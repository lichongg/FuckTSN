package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.random.Random;
import kotlin.ranges.t;
import kotlinx.coroutines.internal.n0;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 7 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1033:1\n285#1:1036\n283#1:1037\n283#1:1038\n285#1:1039\n280#1:1045\n281#1,5:1046\n291#1:1052\n283#1:1053\n284#1:1054\n283#1:1060\n284#1:1061\n280#1:1062\n288#1:1063\n283#1:1064\n283#1:1067\n284#1:1068\n285#1:1069\n93#2:1034\n93#2:1051\n1#3:1035\n28#4,4:1040\n28#4,4:1055\n20#5:1044\n20#5:1059\n90#6:1065\n610#7:1066\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n281#1:1036\n288#1:1037\n289#1:1038\n298#1:1039\n347#1:1045\n375#1:1046,5\n398#1:1052\n445#1:1053\n446#1:1054\n482#1:1060\n483#1:1061\n489#1:1062\n498#1:1063\n498#1:1064\n576#1:1067\n577#1:1068\n578#1:1069\n119#1:1034\n395#1:1051\n347#1:1040,4\n478#1:1055,4\n347#1:1044\n478#1:1059\n515#1:1065\n522#1:1066\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f49448h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f49449i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f49450j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49451k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* renamed from: l, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final s0 f49452l = new s0("NOT_IN_STACK");

    /* renamed from: m, reason: collision with root package name */
    private static final int f49453m = -1;

    /* renamed from: n, reason: collision with root package name */
    private static final int f49454n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static final int f49455o = 1;

    /* renamed from: p, reason: collision with root package name */
    private static final int f49456p = 21;

    /* renamed from: q, reason: collision with root package name */
    private static final long f49457q = 2097151;

    /* renamed from: r, reason: collision with root package name */
    private static final long f49458r = 4398044413952L;

    /* renamed from: s, reason: collision with root package name */
    private static final int f49459s = 42;

    /* renamed from: t, reason: collision with root package name */
    private static final long f49460t = 9223367638808264704L;

    /* renamed from: u, reason: collision with root package name */
    public static final int f49461u = 1;

    /* renamed from: v, reason: collision with root package name */
    public static final int f49462v = 2097150;

    /* renamed from: w, reason: collision with root package name */
    private static final long f49463w = 2097151;

    /* renamed from: x, reason: collision with root package name */
    private static final long f49464x = -2097152;

    /* renamed from: y, reason: collision with root package name */
    private static final long f49465y = 2097152;

    @Volatile
    private volatile int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    public final int f49466a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public final int f49467b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    public final long f49468c;

    @Volatile
    private volatile long controlState;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public final String f49469d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public final e f49470e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public final e f49471f;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public final n0<c> f49472g;

    @Volatile
    private volatile long parkedWorkersStack;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/Task\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1033:1\n298#2:1034\n285#2:1035\n299#2,4:1036\n304#2:1040\n294#2,2:1041\n294#2,2:1045\n280#2:1052\n289#2:1053\n283#2:1054\n280#2:1055\n1#3:1043\n90#4:1044\n28#5,4:1047\n20#6:1051\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n665#1:1034\n665#1:1035\n665#1:1036,4\n679#1:1040\n753#1:1041,2\n807#1:1045,2\n855#1:1052\n881#1:1053\n881#1:1054\n963#1:1055\n790#1:1044\n851#1:1047,4\n851#1:1051\n*E\n"})
    public final class c extends Thread {

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        private static final AtomicIntegerFieldUpdater f49474i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @NotNull
        public final p f49475a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final Ref.ObjectRef<j> f49476b;

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        @NotNull
        public WorkerState f49477c;

        /* renamed from: d, reason: collision with root package name */
        private long f49478d;

        /* renamed from: e, reason: collision with root package name */
        private long f49479e;

        /* renamed from: f, reason: collision with root package name */
        private int f49480f;

        /* renamed from: g, reason: collision with root package name */
        @JvmField
        public boolean f49481g;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;

        @Volatile
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.f49475a = new p();
            this.f49476b = new Ref.ObjectRef<>();
            this.f49477c = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f49452l;
            this.f49480f = Random.Default.nextInt();
        }

        private final j s() {
            if (q(2) == 0) {
                j h6 = CoroutineScheduler.this.f49470e.h();
                return h6 != null ? h6 : CoroutineScheduler.this.f49471f.h();
            }
            j h7 = CoroutineScheduler.this.f49471f.h();
            return h7 != null ? h7 : CoroutineScheduler.this.f49470e.h();
        }

        private final void u() {
            loop0: while (true) {
                boolean z5 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f49477c != WorkerState.TERMINATED) {
                    j h6 = h(this.f49481g);
                    if (h6 != null) {
                        this.f49479e = 0L;
                        d(h6);
                    } else {
                        this.f49481g = false;
                        if (this.f49479e == 0) {
                            y();
                        } else if (z5) {
                            z(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f49479e);
                            this.f49479e = 0L;
                        } else {
                            z5 = true;
                        }
                    }
                }
            }
            z(WorkerState.TERMINATED);
        }

        private final j A(int i6) {
            int i7 = (int) (CoroutineScheduler.f49450j.get(CoroutineScheduler.this) & 2097151);
            if (i7 < 2) {
                return null;
            }
            int q5 = q(i7);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j6 = Long.MAX_VALUE;
            for (int i8 = 0; i8 < i7; i8++) {
                q5++;
                if (q5 > i7) {
                    q5 = 1;
                }
                c b6 = coroutineScheduler.f49472g.b(q5);
                if (b6 != null && b6 != this) {
                    long p5 = b6.f49475a.p(i6, this.f49476b);
                    if (p5 == -1) {
                        Ref.ObjectRef<j> objectRef = this.f49476b;
                        j jVar = objectRef.element;
                        objectRef.element = null;
                        return jVar;
                    }
                    if (p5 > 0) {
                        j6 = Math.min(j6, p5);
                    }
                }
            }
            if (j6 == Long.MAX_VALUE) {
                j6 = 0;
            }
            this.f49479e = j6;
            return null;
        }

        private final void B() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f49472g) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.f49450j.get(coroutineScheduler) & 2097151)) <= coroutineScheduler.f49466a) {
                        return;
                    }
                    if (f49474i.compareAndSet(this, -1, 1)) {
                        int i6 = this.indexInArray;
                        v(0);
                        coroutineScheduler.x(this, i6, 0);
                        int andDecrement = (int) (2097151 & CoroutineScheduler.f49450j.getAndDecrement(coroutineScheduler));
                        if (andDecrement != i6) {
                            c b6 = coroutineScheduler.f49472g.b(andDecrement);
                            g0.m(b6);
                            c cVar = b6;
                            coroutineScheduler.f49472g.c(i6, cVar);
                            cVar.v(i6);
                            coroutineScheduler.x(cVar, andDecrement, i6);
                        }
                        coroutineScheduler.f49472g.c(andDecrement, null);
                        n1 n1Var = n1.f44123a;
                        this.f49477c = WorkerState.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private final void b(int i6) {
            if (i6 == 0) {
                return;
            }
            CoroutineScheduler.f49450j.addAndGet(CoroutineScheduler.this, CoroutineScheduler.f49464x);
            if (this.f49477c != WorkerState.TERMINATED) {
                this.f49477c = WorkerState.DORMANT;
            }
        }

        private final void c(int i6) {
            if (i6 != 0 && z(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.C();
            }
        }

        private final void d(j jVar) {
            int q5 = jVar.f49504b.q();
            n(q5);
            c(q5);
            CoroutineScheduler.this.z(jVar);
            b(q5);
        }

        private final j e(boolean z5) {
            j s5;
            j s6;
            if (z5) {
                boolean z6 = q(CoroutineScheduler.this.f49466a * 2) == 0;
                if (z6 && (s6 = s()) != null) {
                    return s6;
                }
                j h6 = this.f49475a.h();
                if (h6 != null) {
                    return h6;
                }
                if (!z6 && (s5 = s()) != null) {
                    return s5;
                }
            } else {
                j s7 = s();
                if (s7 != null) {
                    return s7;
                }
            }
            return A(3);
        }

        private final j f() {
            j i6 = this.f49475a.i();
            if (i6 != null) {
                return i6;
            }
            j h6 = CoroutineScheduler.this.f49471f.h();
            return h6 == null ? A(1) : h6;
        }

        private final j g() {
            j k6 = this.f49475a.k();
            if (k6 != null) {
                return k6;
            }
            j h6 = CoroutineScheduler.this.f49471f.h();
            return h6 == null ? A(2) : h6;
        }

        @NotNull
        public static final AtomicIntegerFieldUpdater m() {
            return f49474i;
        }

        private final void n(int i6) {
            this.f49478d = 0L;
            if (this.f49477c == WorkerState.PARKING) {
                this.f49477c = WorkerState.BLOCKING;
            }
        }

        private final boolean o() {
            return this.nextParkedWorker != CoroutineScheduler.f49452l;
        }

        private final void r() {
            if (this.f49478d == 0) {
                this.f49478d = System.nanoTime() + CoroutineScheduler.this.f49468c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f49468c);
            if (System.nanoTime() - this.f49478d >= 0) {
                this.f49478d = 0L;
                B();
            }
        }

        private final boolean x() {
            long j6;
            if (this.f49477c == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f49450j;
            do {
                j6 = atomicLongFieldUpdater.get(coroutineScheduler);
                if (((int) ((CoroutineScheduler.f49460t & j6) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.f49450j.compareAndSet(coroutineScheduler, j6, j6 - 4398046511104L));
            this.f49477c = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final int i() {
            return this.indexInArray;
        }

        @Nullable
        public final Object j() {
            return this.nextParkedWorker;
        }

        public final int l() {
            return this.workerCtl;
        }

        public final boolean p() {
            return this.f49477c == WorkerState.BLOCKING;
        }

        public final int q(int i6) {
            int i7 = this.f49480f;
            int i8 = i7 ^ (i7 << 13);
            int i9 = i8 ^ (i8 >> 17);
            int i10 = i9 ^ (i9 << 5);
            this.f49480f = i10;
            int i11 = i6 - 1;
            return (i11 & i6) == 0 ? i10 & i11 : (i10 & Integer.MAX_VALUE) % i6;
        }

        public final long t() {
            boolean z5 = this.f49477c == WorkerState.CPU_ACQUIRED;
            j g6 = z5 ? g() : f();
            if (g6 == null) {
                long j6 = this.f49479e;
                if (j6 == 0) {
                    return -1L;
                }
                return j6;
            }
            CoroutineScheduler.this.z(g6);
            if (!z5) {
                CoroutineScheduler.f49450j.addAndGet(CoroutineScheduler.this, CoroutineScheduler.f49464x);
            }
            return 0L;
        }

        public final void v(int i6) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f49469d);
            sb.append("-worker-");
            sb.append(i6 == 0 ? "TERMINATED" : String.valueOf(i6));
            setName(sb.toString());
            this.indexInArray = i6;
        }

        public final void w(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean z(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.f49477c;
            boolean z5 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z5) {
                CoroutineScheduler.f49450j.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f49477c = workerState;
            }
            return z5;
        }

        private final void y() {
            if (!o()) {
                CoroutineScheduler.this.w(this);
                return;
            }
            f49474i.set(this, -1);
            while (o() && f49474i.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.f49477c != WorkerState.TERMINATED) {
                z(WorkerState.PARKING);
                Thread.interrupted();
                r();
            }
        }

        @Nullable
        public final j h(boolean z5) {
            if (x()) {
                return e(z5);
            }
            return f();
        }

        @NotNull
        public final CoroutineScheduler k() {
            return CoroutineScheduler.this;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            u();
        }

        public c(CoroutineScheduler coroutineScheduler, int i6) {
            this();
            v(i6);
        }
    }

    public CoroutineScheduler(int i6, int i7, long j6, @NotNull String str) {
        this.f49466a = i6;
        this.f49467b = i7;
        this.f49468c = j6;
        this.f49469d = str;
        if (i6 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i6 + " should be at least 1").toString());
        }
        if (i7 < i6) {
            throw new IllegalArgumentException(("Max pool size " + i7 + " should be greater than or equals to core pool size " + i6).toString());
        }
        if (i7 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i7 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j6 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j6 + " must be positive").toString());
        }
        this.f49470e = new e();
        this.f49471f = new e();
        this.f49472g = new n0<>((i6 + 1) * 2);
        this.controlState = i6 << 42;
        this._isTerminated = 0;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        n(this, runnable, null, false, 6, null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49473a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f49473a = iArr;
        }
    }

    private final void B(long j6, boolean z5) {
        if (z5 || H() || F(j6)) {
            return;
        }
        H();
    }

    private final j D(c cVar, j jVar, boolean z5) {
        if (cVar == null || cVar.f49477c == WorkerState.TERMINATED) {
            return jVar;
        }
        if (jVar.f49504b.q() == 0 && cVar.f49477c == WorkerState.BLOCKING) {
            return jVar;
        }
        cVar.f49481g = true;
        return cVar.f49475a.a(jVar, z5);
    }

    static /* synthetic */ boolean G(CoroutineScheduler coroutineScheduler, long j6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = f49450j.get(coroutineScheduler);
        }
        return coroutineScheduler.F(j6);
    }

    private final boolean b(j jVar) {
        return jVar.f49504b.q() == 1 ? this.f49471f.a(jVar) : this.f49470e.a(jVar);
    }

    private final int e() {
        synchronized (this.f49472g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f49450j;
                long j6 = atomicLongFieldUpdater.get(this);
                int i6 = (int) (j6 & 2097151);
                int u5 = t.u(i6 - ((int) ((j6 & f49458r) >> 21)), 0);
                if (u5 >= this.f49466a) {
                    return 0;
                }
                if (i6 >= this.f49467b) {
                    return 0;
                }
                int i7 = ((int) (f49450j.get(this) & 2097151)) + 1;
                if (i7 <= 0 || this.f49472g.b(i7) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i7);
                this.f49472g.c(i7, cVar);
                if (i7 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i8 = u5 + 1;
                cVar.start();
                return i8;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void n(CoroutineScheduler coroutineScheduler, Runnable runnable, k kVar, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            kVar = n.f49515i;
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        coroutineScheduler.m(runnable, kVar, z5);
    }

    private final int o() {
        return (int) ((f49450j.get(this) & f49460t) >> 42);
    }

    private final long q() {
        return f49450j.addAndGet(this, 2097152L);
    }

    private final int s() {
        return (int) (f49450j.incrementAndGet(this) & 2097151);
    }

    private final c v() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49449i;
        while (true) {
            long j6 = atomicLongFieldUpdater.get(this);
            c b6 = this.f49472g.b((int) (2097151 & j6));
            if (b6 == null) {
                return null;
            }
            long j7 = (2097152 + j6) & f49464x;
            int u5 = u(b6);
            if (u5 >= 0 && f49449i.compareAndSet(this, j6, u5 | j7)) {
                b6.w(f49452l);
                return b6;
            }
        }
    }

    public final void A(long j6) {
        int i6;
        j h6;
        if (f49451k.compareAndSet(this, 0, 1)) {
            c h7 = h();
            synchronized (this.f49472g) {
                i6 = (int) (f49450j.get(this) & 2097151);
            }
            if (1 <= i6) {
                int i7 = 1;
                while (true) {
                    c b6 = this.f49472g.b(i7);
                    g0.m(b6);
                    c cVar = b6;
                    if (cVar != h7) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j6);
                        }
                        cVar.f49475a.g(this.f49471f);
                    }
                    if (i7 == i6) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.f49471f.b();
            this.f49470e.b();
            while (true) {
                if (h7 != null) {
                    h6 = h7.h(true);
                    if (h6 != null) {
                        continue;
                        z(h6);
                    }
                }
                h6 = this.f49470e.h();
                if (h6 == null && (h6 = this.f49471f.h()) == null) {
                    break;
                }
                z(h6);
            }
            if (h7 != null) {
                h7.z(WorkerState.TERMINATED);
            }
            f49449i.set(this, 0L);
            f49450j.set(this, 0L);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        A(10000L);
    }

    @NotNull
    public final j f(@NotNull Runnable runnable, @NotNull k kVar) {
        long a6 = n.f49512f.a();
        if (!(runnable instanceof j)) {
            return new m(runnable, a6, kVar);
        }
        j jVar = (j) runnable;
        jVar.f49503a = a6;
        jVar.f49504b = kVar;
        return jVar;
    }

    public final boolean isTerminated() {
        return f49451k.get(this) != 0;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a6 = this.f49472g.a();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 1; i11 < a6; i11++) {
            c b6 = this.f49472g.b(i11);
            if (b6 != null) {
                int f6 = b6.f49475a.f();
                int i12 = b.f49473a[b6.f49477c.ordinal()];
                if (i12 == 1) {
                    i8++;
                } else if (i12 == 2) {
                    i7++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(f6);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i12 == 3) {
                    i6++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(f6);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i12 == 4) {
                    i9++;
                    if (f6 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(f6);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i12 == 5) {
                    i10++;
                }
            }
        }
        long j6 = f49450j.get(this);
        return this.f49469d + '@' + u0.b(this) + "[Pool Size {core = " + this.f49466a + ", max = " + this.f49467b + "}, Worker States {CPU = " + i6 + ", blocking = " + i7 + ", parked = " + i8 + ", dormant = " + i9 + ", terminated = " + i10 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f49470e.c() + ", global blocking queue size = " + this.f49471f.c() + ", Control State {created workers= " + ((int) (2097151 & j6)) + ", blocking tasks = " + ((int) ((f49458r & j6) >> 21)) + ", CPUs acquired = " + (this.f49466a - ((int) ((f49460t & j6) >> 42))) + "}]";
    }

    public final void x(@NotNull c cVar, int i6, int i7) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49449i;
        while (true) {
            long j6 = atomicLongFieldUpdater.get(this);
            int i8 = (int) (2097151 & j6);
            long j7 = (2097152 + j6) & f49464x;
            if (i8 == i6) {
                i8 = i7 == 0 ? u(cVar) : i7;
            }
            if (i8 >= 0 && f49449i.compareAndSet(this, j6, j7 | i8)) {
                return;
            }
        }
    }

    private final boolean E() {
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49450j;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            if (((int) ((f49460t & j6) >> 42)) != 0) {
            } else {
                return false;
            }
        } while (!f49450j.compareAndSet(this, j6, j6 - 4398046511104L));
        return true;
    }

    private final boolean F(long j6) {
        if (t.u(((int) (2097151 & j6)) - ((int) ((j6 & f49458r) >> 21)), 0) < this.f49466a) {
            int e6 = e();
            if (e6 == 1 && this.f49466a > 1) {
                e();
            }
            if (e6 > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean H() {
        c v5;
        do {
            v5 = v();
            if (v5 == null) {
                return false;
            }
        } while (!c.m().compareAndSet(v5, -1, 0));
        LockSupport.unpark(v5);
        return true;
    }

    private final int g(long j6) {
        return (int) (j6 & 2097151);
    }

    private final c h() {
        c cVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof c) {
            cVar = (c) currentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !g0.g(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    private final void k() {
        f49450j.addAndGet(this, f49464x);
    }

    private final int l() {
        return (int) (f49450j.getAndDecrement(this) & 2097151);
    }

    private final int p() {
        return (int) (f49450j.get(this) & 2097151);
    }

    private final void t(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, n1> function1, Object obj) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final int u(c cVar) {
        Object j6 = cVar.j();
        while (j6 != f49452l) {
            if (j6 == null) {
                return 0;
            }
            c cVar2 = (c) j6;
            int i6 = cVar2.i();
            if (i6 != 0) {
                return i6;
            }
            j6 = cVar2.j();
        }
        return -1;
    }

    private final long y() {
        return f49450j.addAndGet(this, 4398046511104L);
    }

    public final void C() {
        if (H() || G(this, 0L, 1, null)) {
            return;
        }
        H();
    }

    public final void m(@NotNull Runnable runnable, @NotNull k kVar, boolean z5) {
        boolean z6;
        long j6;
        kotlinx.coroutines.b b6 = kotlinx.coroutines.c.b();
        if (b6 != null) {
            b6.e();
        }
        j f6 = f(runnable, kVar);
        boolean z7 = false;
        if (f6.f49504b.q() == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            j6 = f49450j.addAndGet(this, 2097152L);
        } else {
            j6 = 0;
        }
        c h6 = h();
        j D = D(h6, f6, z5);
        if (D != null && !b(D)) {
            throw new RejectedExecutionException(this.f49469d + " was terminated");
        }
        if (z5 && h6 != null) {
            z7 = true;
        }
        if (z6) {
            B(j6, z7);
        } else {
            if (z7) {
                return;
            }
            C();
        }
    }

    public final boolean w(@NotNull c cVar) {
        long j6;
        long j7;
        int i6;
        if (cVar.j() != f49452l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f49449i;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            j7 = (2097152 + j6) & f49464x;
            i6 = cVar.i();
            cVar.w(this.f49472g.b((int) (2097151 & j6)));
        } while (!f49449i.compareAndSet(this, j6, j7 | i6));
        return true;
    }

    public final void z(@NotNull j jVar) {
        try {
            jVar.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                kotlinx.coroutines.b b6 = kotlinx.coroutines.c.b();
                if (b6 != null) {
                    b6.f();
                }
            } finally {
                kotlinx.coroutines.b b7 = kotlinx.coroutines.c.b();
                if (b7 != null) {
                    b7.f();
                }
            }
        }
    }

    private final int d(long j6) {
        return (int) ((j6 & f49458r) >> 21);
    }

    public final int c(long j6) {
        return (int) ((j6 & f49460t) >> 42);
    }

    public /* synthetic */ CoroutineScheduler(int i6, int i7, long j6, String str, int i8, v vVar) {
        this(i6, i7, (i8 & 4) != 0 ? n.f49511e : j6, (i8 & 8) != 0 ? n.f49507a : str);
    }
}
