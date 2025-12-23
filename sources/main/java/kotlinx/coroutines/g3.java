package kotlinx.coroutines;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/ThreadLocalEventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g3 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g3 f49210a = new g3();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ThreadLocal<n1> f49211b = kotlinx.coroutines.internal.b1.b(new kotlinx.coroutines.internal.s0("ThreadLocalEventLoop"));

    @Nullable
    public final n1 a() {
        return f49211b.get();
    }

    @NotNull
    public final n1 b() {
        ThreadLocal<n1> threadLocal = f49211b;
        n1 n1Var = threadLocal.get();
        if (n1Var != null) {
            return n1Var;
        }
        n1 a6 = q1.a();
        threadLocal.set(a6);
        return a6;
    }

    public final void c() {
        f49211b.set(null);
    }

    public final void d(@NotNull n1 n1Var) {
        f49211b.set(n1Var);
    }

    private g3() {
    }
}
