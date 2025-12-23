package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u1 extends t1 implements z0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Executor f49662b;

    private final void u(kotlin.coroutines.i iVar, RejectedExecutionException rejectedExecutionException) {
        h2.f(iVar, s1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> v(ScheduledExecutorService scheduledExecutorService, Runnable runnable, kotlin.coroutines.i iVar, long j6) {
        try {
            return scheduledExecutorService.schedule(runnable, j6, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e6) {
            u(iVar, e6);
            return null;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof u1) && ((u1) obj).t() == t();
    }

    @Override // kotlinx.coroutines.t1
    @NotNull
    public Executor t() {
        return this.f49662b;
    }

    public u1(@NotNull Executor executor) {
        this.f49662b = executor;
        kotlinx.coroutines.internal.e.c(t());
    }

    @Override // kotlinx.coroutines.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ExecutorService executorService;
        Executor t5 = t();
        if (t5 instanceof ExecutorService) {
            executorService = (ExecutorService) t5;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor t5 = t();
            b b6 = c.b();
            if (b6 != null) {
                runnable2 = b6.i(runnable);
                if (runnable2 == null) {
                }
                t5.execute(runnable2);
            }
            runnable2 = runnable;
            t5.execute(runnable2);
        } catch (RejectedExecutionException e6) {
            b b7 = c.b();
            if (b7 != null) {
                b7.f();
            }
            u(iVar, e6);
            g1.c().dispatch(iVar, runnable);
        }
    }

    public int hashCode() {
        return System.identityHashCode(t());
    }

    @Override // kotlinx.coroutines.z0
    public void i(long j6, @NotNull p<? super kotlin.n1> pVar) {
        ScheduledExecutorService scheduledExecutorService;
        long j7;
        Executor t5 = t();
        ScheduledFuture<?> scheduledFuture = null;
        if (t5 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) t5;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            j7 = j6;
            scheduledFuture = v(scheduledExecutorService, new x2(this, pVar), pVar.getContext(), j7);
        } else {
            j7 = j6;
        }
        if (scheduledFuture != null) {
            h2.w(pVar, scheduledFuture);
        } else {
            v0.f49663g.i(j7, pVar);
        }
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public j1 m(long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar) {
        ScheduledExecutorService scheduledExecutorService;
        long j7;
        Runnable runnable2;
        kotlin.coroutines.i iVar2;
        Executor t5 = t();
        ScheduledFuture<?> scheduledFuture = null;
        if (t5 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) t5;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            j7 = j6;
            runnable2 = runnable;
            iVar2 = iVar;
            scheduledFuture = v(scheduledExecutorService, runnable2, iVar2, j7);
        } else {
            j7 = j6;
            runnable2 = runnable;
            iVar2 = iVar;
        }
        if (scheduledFuture != null) {
            return new i1(scheduledFuture);
        }
        return v0.f49663g.m(j7, runnable2, iVar2);
    }

    @Override // kotlinx.coroutines.z0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object r(long j6, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        return z0.a.a(this, j6, eVar);
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        return t().toString();
    }
}
