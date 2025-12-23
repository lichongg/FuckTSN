package kotlinx.coroutines;

import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d3 {
    @NotNull
    public static final b0 a(@Nullable e2 e2Var) {
        return new c3(e2Var);
    }

    public static /* synthetic */ b0 c(e2 e2Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            e2Var = null;
        }
        return a(e2Var);
    }

    public static /* synthetic */ e2 d(e2 e2Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            e2Var = null;
        }
        return a(e2Var);
    }

    @Nullable
    public static final <R> Object e(@NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        b3 b3Var = new b3(eVar.getContext(), eVar);
        Object e6 = o4.b.e(b3Var, b3Var, function2);
        if (e6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return e6;
    }
}
