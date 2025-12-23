package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g0 {
    public static final void c(@NotNull Function1<? super Throwable, kotlin.n1> function1, @Nullable Throwable th) {
        function1.invoke(th);
    }

    @NotNull
    public static final Function1<Throwable, kotlin.n1> a(@NotNull o oVar) {
        return oVar;
    }

    @NotNull
    public static final Function1<Throwable, kotlin.n1> b(@NotNull f0 f0Var) {
        return f0Var;
    }
}
