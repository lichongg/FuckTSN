package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class o1 extends p1 implements z0 {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49406d = AtomicReferenceFieldUpdater.newUpdater(o1.class, Object.class, "_queue");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49407e = AtomicReferenceFieldUpdater.newUpdater(o1.class, Object.class, "_delayed");

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49408f = AtomicIntegerFieldUpdater.newUpdater(o1.class, "_isCompleted");

    @Volatile
    @Nullable
    private volatile Object _delayed;

    @Volatile
    private volatile int _isCompleted = 0;

    @Volatile
    @Nullable
    private volatile Object _queue;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
    private final class a extends c {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final p<kotlin.n1> f49409c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j6, @NotNull p<? super kotlin.n1> pVar) {
            super(j6);
            this.f49409c = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49409c.P(o1.this, kotlin.n1.f44123a);
        }

        @Override // kotlinx.coroutines.o1.c
        @NotNull
        public String toString() {
            return super.toString() + this.f49409c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b extends c {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final Runnable f49411c;

        @Override // java.lang.Runnable
        public void run() {
            this.f49411c.run();
        }

        @Override // kotlinx.coroutines.o1.c
        @NotNull
        public String toString() {
            return super.toString() + this.f49411c;
        }

        public b(long j6, @NotNull Runnable runnable) {
            super(j6);
            this.f49411c = runnable;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    public static abstract class c implements Runnable, Comparable<c>, j1, kotlinx.coroutines.internal.d1 {

        @Nullable
        private volatile Object _heap;

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        public long f49412a;

        /* renamed from: b, reason: collision with root package name */
        private int f49413b = -1;

        @Override // kotlinx.coroutines.j1
        public final void dispose() {
            kotlinx.coroutines.internal.s0 s0Var;
            kotlinx.coroutines.internal.s0 s0Var2;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    s0Var = r1.f49435a;
                    if (obj == s0Var) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.k(this);
                    }
                    s0Var2 = r1.f49435a;
                    this._heap = s0Var2;
                    kotlin.n1 n1Var = kotlin.n1.f44123a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int h(long j6, @NotNull d dVar, @NotNull o1 o1Var) {
            kotlinx.coroutines.internal.s0 s0Var;
            synchronized (this) {
                Object obj = this._heap;
                s0Var = r1.f49435a;
                if (obj == s0Var) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c f6 = dVar.f();
                        if (o1Var.isCompleted()) {
                            return 1;
                        }
                        if (f6 == null) {
                            dVar.f49414c = j6;
                        } else {
                            long j7 = f6.f49412a;
                            if (j7 - j6 < 0) {
                                j6 = j7;
                            }
                            if (j6 - dVar.f49414c > 0) {
                                dVar.f49414c = j6;
                            }
                        }
                        long j8 = this.f49412a;
                        long j9 = dVar.f49414c;
                        if (j8 - j9 < 0) {
                            this.f49412a = j9;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.d1
        public void a(@Nullable kotlinx.coroutines.internal.c1<?> c1Var) {
            kotlinx.coroutines.internal.s0 s0Var;
            Object obj = this._heap;
            s0Var = r1.f49435a;
            if (obj == s0Var) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = c1Var;
        }

        @Override // kotlinx.coroutines.internal.d1
        @Nullable
        public kotlinx.coroutines.internal.c1<?> c() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.c1) {
                return (kotlinx.coroutines.internal.c1) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull c cVar) {
            long j6 = this.f49412a - cVar.f49412a;
            if (j6 > 0) {
                return 1;
            }
            return j6 < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.internal.d1
        public int getIndex() {
            return this.f49413b;
        }

        public final boolean i(long j6) {
            return j6 - this.f49412a >= 0;
        }

        @Override // kotlinx.coroutines.internal.d1
        public void setIndex(int i6) {
            this.f49413b = i6;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.f49412a + ']';
        }

        public c(long j6) {
            this.f49412a = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends kotlinx.coroutines.internal.c1<c> {

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        public long f49414c;

        public d(long j6) {
            this.f49414c = j6;
        }
    }

    private final void T() {
        kotlinx.coroutines.internal.s0 s0Var;
        kotlinx.coroutines.internal.s0 s0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49406d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f49406d;
                s0Var = r1.f49442h;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, null, s0Var)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.a0) {
                    ((kotlinx.coroutines.internal.a0) obj).d();
                    return;
                }
                s0Var2 = r1.f49442h;
                if (obj == s0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.a0 a0Var = new kotlinx.coroutines.internal.a0(8, true);
                kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                a0Var.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f49406d, this, obj, a0Var)) {
                    return;
                }
            }
        }
    }

    private final Runnable V() {
        kotlinx.coroutines.internal.s0 s0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49406d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.a0) {
                kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.a0 a0Var = (kotlinx.coroutines.internal.a0) obj;
                Object n6 = a0Var.n();
                if (n6 != kotlinx.coroutines.internal.a0.f49231t) {
                    return (Runnable) n6;
                }
                androidx.concurrent.futures.a.a(f49406d, this, obj, a0Var.m());
            } else {
                s0Var = r1.f49442h;
                if (obj == s0Var) {
                    return null;
                }
                if (androidx.concurrent.futures.a.a(f49406d, this, obj, null)) {
                    kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean X(Runnable runnable) {
        kotlinx.coroutines.internal.s0 s0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49406d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f49406d, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.a0) {
                kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.a0 a0Var = (kotlinx.coroutines.internal.a0) obj;
                int a6 = a0Var.a(runnable);
                if (a6 == 0) {
                    return true;
                }
                if (a6 == 1) {
                    androidx.concurrent.futures.a.a(f49406d, this, obj, a0Var.m());
                } else if (a6 == 2) {
                    return false;
                }
            } else {
                s0Var = r1.f49442h;
                if (obj == s0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.a0 a0Var2 = new kotlinx.coroutines.internal.a0(8, true);
                kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                a0Var2.a((Runnable) obj);
                a0Var2.a(runnable);
                if (androidx.concurrent.futures.a.a(f49406d, this, obj, a0Var2)) {
                    return true;
                }
            }
        }
    }

    private final void e0(boolean z5) {
        f49408f.set(this, z5 ? 1 : 0);
    }

    private final boolean f0(c cVar) {
        d dVar = (d) f49407e.get(this);
        return (dVar != null ? dVar.i() : null) == cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return f49408f.get(this) != 0;
    }

    protected final void a0() {
        f49406d.set(this, null);
        f49407e.set(this, null);
    }

    @Override // kotlinx.coroutines.n1
    public void shutdown() {
        g3.f49210a.c();
        e0(true);
        T();
        while (J() <= 0) {
        }
        Z();
    }

    private final void Y(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, kotlin.n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final void Z() {
        long nanoTime;
        c n6;
        kotlinx.coroutines.b b6 = kotlinx.coroutines.c.b();
        if (b6 != null) {
            nanoTime = b6.b();
        } else {
            nanoTime = System.nanoTime();
        }
        while (true) {
            d dVar = (d) f49407e.get(this);
            if (dVar != null && (n6 = dVar.n()) != null) {
                Q(nanoTime, n6);
            } else {
                return;
            }
        }
    }

    private final int c0(long j6, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49407e;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, new d(j6));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.g0.m(obj);
            dVar = (d) obj;
        }
        return cVar.h(j6, dVar, this);
    }

    @Override // kotlinx.coroutines.n1
    protected boolean C() {
        kotlinx.coroutines.internal.s0 s0Var;
        if (!I()) {
            return false;
        }
        d dVar = (d) f49407e.get(this);
        if (dVar != null && !dVar.h()) {
            return false;
        }
        Object obj = f49406d.get(this);
        if (obj == null) {
            return true;
        }
        if (!(obj instanceof kotlinx.coroutines.internal.a0)) {
            s0Var = r1.f49442h;
            if (obj != s0Var) {
                return false;
            }
            return true;
        }
        return ((kotlinx.coroutines.internal.a0) obj).h();
    }

    @Override // kotlinx.coroutines.n1
    public long J() {
        long nanoTime;
        c cVar;
        boolean z5;
        if (N()) {
            return 0L;
        }
        d dVar = (d) f49407e.get(this);
        if (dVar != null && !dVar.h()) {
            kotlinx.coroutines.b b6 = kotlinx.coroutines.c.b();
            if (b6 != null) {
                nanoTime = b6.b();
            } else {
                nanoTime = System.nanoTime();
            }
            do {
                synchronized (dVar) {
                    try {
                        c f6 = dVar.f();
                        cVar = null;
                        if (f6 != null) {
                            c cVar2 = f6;
                            if (cVar2.i(nanoTime)) {
                                z5 = X(cVar2);
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                cVar = dVar.l(0);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (cVar != null);
        }
        Runnable V = V();
        if (V != null) {
            V.run();
            return 0L;
        }
        return x();
    }

    public void W(@NotNull Runnable runnable) {
        if (X(runnable)) {
            R();
        } else {
            v0.f49663g.W(runnable);
        }
    }

    public final void b0(long j6, @NotNull c cVar) {
        int c02 = c0(j6, cVar);
        if (c02 != 0) {
            if (c02 != 1) {
                if (c02 != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            } else {
                Q(j6, cVar);
                return;
            }
        }
        if (f0(cVar)) {
            R();
        }
    }

    @NotNull
    protected final j1 d0(long j6, @NotNull Runnable runnable) {
        long nanoTime;
        long d6 = r1.d(j6);
        if (d6 < kotlin.time.j.f48028c) {
            kotlinx.coroutines.b b6 = kotlinx.coroutines.c.b();
            if (b6 != null) {
                nanoTime = b6.b();
            } else {
                nanoTime = System.nanoTime();
            }
            b bVar = new b(d6 + nanoTime, runnable);
            b0(nanoTime, bVar);
            return bVar;
        }
        return s2.f49445a;
    }

    @Override // kotlinx.coroutines.m0
    public final void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        W(runnable);
    }

    @Override // kotlinx.coroutines.z0
    public void i(long j6, @NotNull p<? super kotlin.n1> pVar) {
        long nanoTime;
        long d6 = r1.d(j6);
        if (d6 < kotlin.time.j.f48028c) {
            kotlinx.coroutines.b b6 = kotlinx.coroutines.c.b();
            if (b6 != null) {
                nanoTime = b6.b();
            } else {
                nanoTime = System.nanoTime();
            }
            a aVar = new a(d6 + nanoTime, pVar);
            b0(nanoTime, aVar);
            s.a(pVar, aVar);
        }
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public j1 m(long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar) {
        return z0.a.b(this, j6, runnable, iVar);
    }

    @Override // kotlinx.coroutines.z0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object r(long j6, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        return z0.a.a(this, j6, eVar);
    }

    @Override // kotlinx.coroutines.n1
    protected long x() {
        c i6;
        long nanoTime;
        kotlinx.coroutines.internal.s0 s0Var;
        if (super.x() == 0) {
            return 0L;
        }
        Object obj = f49406d.get(this);
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.a0)) {
                s0Var = r1.f49442h;
                if (obj != s0Var) {
                    return 0L;
                }
                return Long.MAX_VALUE;
            }
            if (!((kotlinx.coroutines.internal.a0) obj).h()) {
                return 0L;
            }
        }
        d dVar = (d) f49407e.get(this);
        if (dVar == null || (i6 = dVar.i()) == null) {
            return Long.MAX_VALUE;
        }
        long j6 = i6.f49412a;
        kotlinx.coroutines.b b6 = kotlinx.coroutines.c.b();
        if (b6 != null) {
            nanoTime = b6.b();
        } else {
            nanoTime = System.nanoTime();
        }
        return kotlin.ranges.t.v(j6 - nanoTime, 0L);
    }
}
