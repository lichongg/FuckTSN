package kotlinx.coroutines;

import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCompletionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n+ 2 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,67:1\n61#2,2:68\n61#2,2:70\n*S KotlinDebug\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n*L\n21#1:68,2\n27#1:70,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i0 {
    @NotNull
    public static final <T> Object a(@Nullable Object obj, @NotNull kotlin.coroutines.e<? super T> eVar) {
        if (obj instanceof d0) {
            Result.a aVar = Result.Companion;
            return Result.m130constructorimpl(kotlin.g0.a(((d0) obj).f48476a));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m130constructorimpl(obj);
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }

    @Nullable
    public static final <T> Object b(@NotNull Object obj, @Nullable Function1<? super Throwable, kotlin.n1> function1) {
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        if (m133exceptionOrNullimpl == null) {
            if (function1 != null) {
                return new e0(obj, function1);
            }
            return obj;
        }
        return new d0(m133exceptionOrNullimpl, false, 2, null);
    }

    @Nullable
    public static final <T> Object c(@NotNull Object obj, @NotNull p<?> pVar) {
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        if (m133exceptionOrNullimpl == null) {
            return obj;
        }
        return new d0(m133exceptionOrNullimpl, false, 2, null);
    }
}
