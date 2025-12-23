package kotlinx.coroutines;

import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {
    @NotNull
    public static final <T> x0<T> a(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) {
        return k.a(r0Var, iVar, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object c(@NotNull m0 m0Var, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return k.c(m0Var, function2, eVar);
    }

    @NotNull
    public static final e2 d(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super kotlin.n1>, ? extends Object> function2) {
        return k.e(r0Var, iVar, coroutineStart, function2);
    }

    public static final <T> T f(@NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) throws InterruptedException {
        return (T) j.a(iVar, function2);
    }

    @Nullable
    public static final <T> Object h(@NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return k.g(iVar, function2, eVar);
    }
}
