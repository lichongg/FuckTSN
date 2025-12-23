package kotlinx.coroutines;

import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q1 {
    @NotNull
    public static final n1 a() {
        return new h(Thread.currentThread());
    }

    @InternalCoroutinesApi
    @PublishedApi
    @DelicateCoroutinesApi
    public static final boolean b(@NotNull Thread thread) {
        if (thread instanceof CoroutineScheduler.c) {
            return ((CoroutineScheduler.c) thread).p();
        }
        return false;
    }

    @InternalCoroutinesApi
    public static final long d() {
        n1 a6 = g3.f49210a.a();
        if (a6 != null) {
            return a6.J();
        }
        return Long.MAX_VALUE;
    }

    public static final void c(@NotNull Function0<kotlin.n1> function0) {
        function0.invoke();
    }

    @InternalCoroutinesApi
    @PublishedApi
    @DelicateCoroutinesApi
    public static final long e() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof CoroutineScheduler.c) {
            return ((CoroutineScheduler.c) currentThread).t();
        }
        throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + currentThread);
    }
}
