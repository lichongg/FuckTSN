package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/CoroutineExceptionHandlerImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Collection<kotlinx.coroutines.n0> f49271a = kotlin.sequences.p.I3(kotlin.sequences.p.j(ServiceLoader.load(kotlinx.coroutines.n0.class, kotlinx.coroutines.n0.class.getClassLoader()).iterator()));

    public static final void a(@NotNull kotlinx.coroutines.n0 n0Var) {
        if (!f49271a.contains(n0Var)) {
            throw new IllegalStateException("Exception handler was not found via a ServiceLoader");
        }
    }

    @NotNull
    public static final Collection<kotlinx.coroutines.n0> b() {
        return f49271a;
    }

    public static final void c(@NotNull Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
