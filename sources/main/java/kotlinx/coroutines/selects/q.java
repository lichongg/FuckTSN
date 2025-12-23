package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q {
    @Nullable
    public static final <R> Object a(@NotNull Function1<? super c<? super R>, n1> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        s sVar = new s(eVar.getContext());
        function1.invoke(sVar);
        return sVar.y(eVar);
    }

    private static final <R> Object b(Function1<? super c<? super R>, n1> function1, kotlin.coroutines.e<? super R> eVar) {
        d0.e(3);
        throw null;
    }
}
