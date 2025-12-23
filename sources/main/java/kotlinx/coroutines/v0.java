package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.o1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v0 extends o1 implements Runnable {

    @Nullable
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final v0 f49663g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final String f49664h = "kotlinx.coroutines.DefaultExecutor";

    /* renamed from: i, reason: collision with root package name */
    private static final long f49665i = 1000;

    /* renamed from: j, reason: collision with root package name */
    private static final long f49666j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f49667k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f49668l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f49669m = 2;

    /* renamed from: n, reason: collision with root package name */
    private static final int f49670n = 3;

    /* renamed from: o, reason: collision with root package name */
    private static final int f49671o = 4;

    private final synchronized void g0() {
        if (l0()) {
            debugStatus = 3;
            a0();
            kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread h0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, f49664h);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final synchronized boolean n0() {
        if (l0()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final synchronized void i0() {
        debugStatus = 0;
        h0();
        while (debugStatus == 0) {
            kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        }
    }

    public final synchronized void p0(long j6) {
        kotlin.n1 n1Var;
        try {
            long currentTimeMillis = System.currentTimeMillis() + j6;
            if (!l0()) {
                debugStatus = 2;
            }
            while (debugStatus != 3 && _thread != null) {
                Thread thread = _thread;
                if (thread != null) {
                    b b6 = c.b();
                    if (b6 != null) {
                        b6.g(thread);
                        n1Var = kotlin.n1.f44123a;
                    } else {
                        n1Var = null;
                    }
                    if (n1Var == null) {
                        LockSupport.unpark(thread);
                    }
                }
                if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                    break;
                }
                kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type java.lang.Object");
                wait(j6);
            }
            debugStatus = 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // kotlinx.coroutines.o1, kotlinx.coroutines.n1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    static {
        Long l6;
        v0 v0Var = new v0();
        f49663g = v0Var;
        n1.B(v0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l6 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l6 = 1000L;
        }
        f49666j = timeUnit.toNanos(l6.longValue());
    }

    private final boolean k0() {
        return debugStatus == 4;
    }

    private final boolean l0() {
        int i6 = debugStatus;
        return i6 == 2 || i6 == 3;
    }

    private final void o0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.p1
    @NotNull
    protected Thread P() {
        Thread thread = _thread;
        return thread == null ? h0() : thread;
    }

    public final boolean m0() {
        return _thread != null;
    }

    @Override // java.lang.Runnable
    public void run() {
        kotlin.n1 n1Var;
        g3.f49210a.d(this);
        b b6 = c.b();
        if (b6 != null) {
            b6.d();
        }
        try {
            if (!n0()) {
                _thread = null;
                g0();
                b b7 = c.b();
                if (b7 != null) {
                    b7.h();
                }
                if (C()) {
                    return;
                }
                P();
                return;
            }
            long j6 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long J = J();
                if (J == Long.MAX_VALUE) {
                    b b8 = c.b();
                    long b9 = b8 != null ? b8.b() : System.nanoTime();
                    if (j6 == Long.MAX_VALUE) {
                        j6 = f49666j + b9;
                    }
                    long j7 = j6 - b9;
                    if (j7 <= 0) {
                        _thread = null;
                        g0();
                        b b10 = c.b();
                        if (b10 != null) {
                            b10.h();
                        }
                        if (C()) {
                            return;
                        }
                        P();
                        return;
                    }
                    J = kotlin.ranges.t.C(J, j7);
                } else {
                    j6 = Long.MAX_VALUE;
                }
                if (J > 0) {
                    if (l0()) {
                        _thread = null;
                        g0();
                        b b11 = c.b();
                        if (b11 != null) {
                            b11.h();
                        }
                        if (C()) {
                            return;
                        }
                        P();
                        return;
                    }
                    b b12 = c.b();
                    if (b12 != null) {
                        b12.c(this, J);
                        n1Var = kotlin.n1.f44123a;
                    } else {
                        n1Var = null;
                    }
                    if (n1Var == null) {
                        LockSupport.parkNanos(this, J);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            g0();
            b b13 = c.b();
            if (b13 != null) {
                b13.h();
            }
            if (!C()) {
                P();
            }
            throw th;
        }
    }

    private v0() {
    }

    @Override // kotlinx.coroutines.p1
    protected void Q(long j6, @NotNull o1.c cVar) {
        o0();
    }

    @Override // kotlinx.coroutines.o1
    public void W(@NotNull Runnable runnable) {
        if (k0()) {
            o0();
        }
        super.W(runnable);
    }

    @Override // kotlinx.coroutines.o1, kotlinx.coroutines.z0
    @NotNull
    public j1 m(long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar) {
        return d0(j6, runnable);
    }

    private static /* synthetic */ void j0() {
    }
}
