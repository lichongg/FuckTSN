package kotlinx.coroutines;

import kotlin.Result;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCompletableDeferred.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletableDeferred.kt\nkotlinx/coroutines/CompletableDeferredKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 {
    @NotNull
    public static final <T> y<T> a(T t5) {
        z zVar = new z(null);
        zVar.p(t5);
        return zVar;
    }

    @NotNull
    public static final <T> y<T> b(@Nullable e2 e2Var) {
        return new z(e2Var);
    }

    public static /* synthetic */ y c(e2 e2Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            e2Var = null;
        }
        return b(e2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean d(@NotNull y<T> yVar, @NotNull Object obj) {
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        if (m133exceptionOrNullimpl == null) {
            return yVar.p(obj);
        }
        return yVar.c(m133exceptionOrNullimpl);
    }
}
