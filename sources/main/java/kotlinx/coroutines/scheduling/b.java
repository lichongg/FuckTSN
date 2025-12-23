package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.t;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.internal.v0;
import kotlinx.coroutines.internal.x0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b extends t1 implements Executor {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f49483b = new b();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final m0 f49484c;

    static {
        int e6;
        o oVar = o.f49517a;
        e6 = x0.e(h1.f49213a, t.u(64, v0.a()), 0, 0, 12, null);
        f49484c = oVar.limitedParallelism(e6);
    }

    @Override // kotlinx.coroutines.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        f49484c.dispatch(iVar, runnable);
    }

    @Override // kotlinx.coroutines.m0
    @InternalCoroutinesApi
    public void dispatchYield(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        f49484c.dispatchYield(iVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.m0
    @ExperimentalCoroutinesApi
    @NotNull
    public m0 limitedParallelism(int i6) {
        return o.f49517a.limitedParallelism(i6);
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        return "Dispatchers.IO";
    }

    private b() {
    }

    @Override // kotlinx.coroutines.t1
    @NotNull
    public Executor t() {
        return this;
    }
}
