package kotlin;

import kotlin.Result;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,340:1\n1#2:341\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g0 {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Object a(@NotNull Throwable exception) {
        kotlin.jvm.internal.g0.p(exception, "exception");
        return new Result.Failure(exception);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> R b(Object obj, Function1<? super T, ? extends R> onSuccess, Function1<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.g0.p(onSuccess, "onSuccess");
        kotlin.jvm.internal.g0.p(onFailure, "onFailure");
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        return m133exceptionOrNullimpl == null ? onSuccess.invoke(obj) : onFailure.invoke(m133exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R d(Object obj, Function1<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.g0.p(onFailure, "onFailure");
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        return m133exceptionOrNullimpl == null ? obj : onFailure.invoke(m133exceptionOrNullimpl);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object f(Object obj, Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(transform, "transform");
        if (!Result.m137isSuccessimpl(obj)) {
            return Result.m130constructorimpl(obj);
        }
        Result.a aVar = Result.Companion;
        return Result.m130constructorimpl(transform.invoke(obj));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object g(Object obj, Function1<? super T, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(transform, "transform");
        if (!Result.m137isSuccessimpl(obj)) {
            return Result.m130constructorimpl(obj);
        }
        try {
            Result.a aVar = Result.Companion;
            return Result.m130constructorimpl(transform.invoke(obj));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m130constructorimpl(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object h(Object obj, Function1<? super Throwable, n1> action) {
        kotlin.jvm.internal.g0.p(action, "action");
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        if (m133exceptionOrNullimpl != null) {
            action.invoke(m133exceptionOrNullimpl);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object i(Object obj, Function1<? super T, n1> action) {
        kotlin.jvm.internal.g0.p(action, "action");
        if (Result.m137isSuccessimpl(obj)) {
            action.invoke(obj);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object j(Object obj, Function1<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(transform, "transform");
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        if (m133exceptionOrNullimpl == null) {
            return obj;
        }
        Result.a aVar = Result.Companion;
        return Result.m130constructorimpl(transform.invoke(m133exceptionOrNullimpl));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object k(Object obj, Function1<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(transform, "transform");
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        if (m133exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.a aVar = Result.Companion;
            return Result.m130constructorimpl(transform.invoke(m133exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m130constructorimpl(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R> Object l(T t5, Function1<? super T, ? extends R> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        try {
            Result.a aVar = Result.Companion;
            return Result.m130constructorimpl(block.invoke(t5));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m130constructorimpl(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R> Object m(Function0<? extends R> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        try {
            Result.a aVar = Result.Companion;
            return Result.m130constructorimpl(block.invoke());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m130constructorimpl(a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void n(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R c(Object obj, R r5) {
        if (Result.m136isFailureimpl(obj)) {
            return r5;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> T e(Object obj) {
        n(obj);
        return obj;
    }
}
