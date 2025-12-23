package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class h2 {
    public static final void A(@NotNull e2 e2Var) {
        j2.y(e2Var);
    }

    @NotNull
    public static final e2 B(@NotNull kotlin.coroutines.i iVar) {
        return j2.z(iVar);
    }

    public static final boolean C(@NotNull kotlin.coroutines.i iVar) {
        return j2.A(iVar);
    }

    @NotNull
    public static final b0 a(@Nullable e2 e2Var) {
        return j2.a(e2Var);
    }

    public static final void f(@NotNull kotlin.coroutines.i iVar, @Nullable CancellationException cancellationException) {
        j2.f(iVar, cancellationException);
    }

    public static final void g(@NotNull e2 e2Var, @NotNull String str, @Nullable Throwable th) {
        j2.g(e2Var, str, th);
    }

    @Nullable
    public static final Object l(@NotNull e2 e2Var, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        return j2.l(e2Var, eVar);
    }

    public static final void o(@NotNull kotlin.coroutines.i iVar, @Nullable CancellationException cancellationException) {
        j2.o(iVar, cancellationException);
    }

    public static final void r(@NotNull e2 e2Var, @Nullable CancellationException cancellationException) {
        j2.r(e2Var, cancellationException);
    }

    public static final void w(@NotNull p<?> pVar, @NotNull Future<?> future) {
        i2.a(pVar, future);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final j1 x(@NotNull e2 e2Var, @NotNull Future<?> future) {
        return i2.b(e2Var, future);
    }

    @NotNull
    public static final j1 y(@NotNull e2 e2Var, @NotNull j1 j1Var) {
        return j2.w(e2Var, j1Var);
    }

    public static final void z(@NotNull kotlin.coroutines.i iVar) {
        j2.x(iVar);
    }
}
