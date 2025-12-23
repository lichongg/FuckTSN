package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0 {
    private static final Object i(kotlin.coroutines.e<? super kotlin.coroutines.i> eVar) {
        kotlin.jvm.internal.d0.e(3);
        throw null;
    }

    @NotNull
    public static final r0 a(@NotNull kotlin.coroutines.i iVar) {
        b0 c6;
        if (iVar.get(e2.f48569s0) == null) {
            c6 = j2.c(null, 1, null);
            iVar = iVar.plus(c6);
        }
        return new kotlinx.coroutines.internal.h(iVar);
    }

    @NotNull
    public static final r0 b() {
        return new kotlinx.coroutines.internal.h(d3.c(null, 1, null).plus(g1.e()));
    }

    public static /* synthetic */ void e(r0 r0Var, String str, Throwable th, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            th = null;
        }
        c(r0Var, str, th);
    }

    public static /* synthetic */ void f(r0 r0Var, CancellationException cancellationException, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            cancellationException = null;
        }
        d(r0Var, cancellationException);
    }

    @Nullable
    public static final <R> Object g(@NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        kotlinx.coroutines.internal.o0 o0Var = new kotlinx.coroutines.internal.o0(eVar.getContext(), eVar);
        Object e6 = o4.b.e(o0Var, o0Var, function2);
        if (e6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return e6;
    }

    @NotNull
    public static final r0 m(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar) {
        return new kotlinx.coroutines.internal.h(r0Var.getCoroutineContext().plus(iVar));
    }

    public static final void c(@NotNull r0 r0Var, @NotNull String str, @Nullable Throwable th) {
        d(r0Var, s1.a(str, th));
    }

    public static final void d(@NotNull r0 r0Var, @Nullable CancellationException cancellationException) {
        e2 e2Var = (e2) r0Var.getCoroutineContext().get(e2.f48569s0);
        if (e2Var != null) {
            e2Var.b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r0Var).toString());
    }

    @Nullable
    public static final Object h(@NotNull kotlin.coroutines.e<? super kotlin.coroutines.i> eVar) {
        return eVar.getContext();
    }

    public static final void j(@NotNull r0 r0Var) {
        h2.z(r0Var.getCoroutineContext());
    }

    public static final boolean k(@NotNull r0 r0Var) {
        e2 e2Var = (e2) r0Var.getCoroutineContext().get(e2.f48569s0);
        if (e2Var != null) {
            return e2Var.isActive();
        }
        return true;
    }

    public static /* synthetic */ void l(r0 r0Var) {
    }
}
