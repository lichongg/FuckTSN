package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.j1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,134:1\n66#1,8:135\n66#1,8:143\n28#2,4:151\n28#2,4:156\n20#3:155\n20#3:160\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n48#1:135,8\n55#1:143,8\n79#1:151,4\n92#1:156,4\n79#1:155\n92#1:160\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s extends kotlinx.coroutines.m0 implements kotlinx.coroutines.z0 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49305f = AtomicIntegerFieldUpdater.newUpdater(s.class, "runningWorkers");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlinx.coroutines.m0 f49306a;

    /* renamed from: b, reason: collision with root package name */
    private final int f49307b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ kotlinx.coroutines.z0 f49308c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final z<Runnable> f49309d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Object f49310e;

    @Volatile
    private volatile int runningWorkers;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private Runnable f49311a;

        @Override // java.lang.Runnable
        public void run() {
            int i6 = 0;
            while (true) {
                try {
                    this.f49311a.run();
                } catch (Throwable th) {
                    kotlinx.coroutines.o0.b(EmptyCoroutineContext.INSTANCE, th);
                }
                Runnable w5 = s.this.w();
                if (w5 == null) {
                    return;
                }
                this.f49311a = w5;
                i6++;
                if (i6 >= 16 && s.this.f49306a.isDispatchNeeded(s.this)) {
                    s.this.f49306a.dispatch(s.this, this);
                    return;
                }
            }
        }

        public a(@NotNull Runnable runnable) {
            this.f49311a = runnable;
        }
    }

    private final void v(Runnable runnable, Function1<? super a, n1> function1) {
        Runnable w5;
        this.f49309d.a(runnable);
        if (f49305f.get(this) < this.f49307b && x() && (w5 = w()) != null) {
            function1.invoke(new a(w5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable w() {
        while (true) {
            Runnable h6 = this.f49309d.h();
            if (h6 != null) {
                return h6;
            }
            synchronized (this.f49310e) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49305f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f49309d.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean x() {
        synchronized (this.f49310e) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49305f;
            if (atomicIntegerFieldUpdater.get(this) >= this.f49307b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        Runnable w5;
        this.f49309d.a(runnable);
        if (f49305f.get(this) >= this.f49307b || !x() || (w5 = w()) == null) {
            return;
        }
        this.f49306a.dispatch(this, new a(w5));
    }

    @Override // kotlinx.coroutines.m0
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        Runnable w5;
        this.f49309d.a(runnable);
        if (f49305f.get(this) >= this.f49307b || !x() || (w5 = w()) == null) {
            return;
        }
        this.f49306a.dispatchYield(this, new a(w5));
    }

    @Override // kotlinx.coroutines.z0
    public void i(long j6, @NotNull kotlinx.coroutines.p<? super n1> pVar) {
        this.f49308c.i(j6, pVar);
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public j1 m(long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar) {
        return this.f49308c.m(j6, runnable, iVar);
    }

    @Override // kotlinx.coroutines.z0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object r(long j6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return this.f49308c.r(j6, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(@NotNull kotlinx.coroutines.m0 m0Var, int i6) {
        kotlinx.coroutines.z0 z0Var;
        this.f49306a = m0Var;
        this.f49307b = i6;
        if (m0Var instanceof kotlinx.coroutines.z0) {
            z0Var = (kotlinx.coroutines.z0) m0Var;
        } else {
            z0Var = null;
        }
        this.f49308c = z0Var == null ? kotlinx.coroutines.w0.a() : z0Var;
        this.f49309d = new z<>(false);
        this.f49310e = new Object();
    }

    @Override // kotlinx.coroutines.m0
    @ExperimentalCoroutinesApi
    @NotNull
    public kotlinx.coroutines.m0 limitedParallelism(int i6) {
        t.a(i6);
        if (i6 >= this.f49307b) {
            return this;
        }
        return super.limitedParallelism(i6);
    }
}
