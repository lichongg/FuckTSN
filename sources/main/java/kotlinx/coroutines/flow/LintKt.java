package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.ReplaceWith;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class LintKt {
    public static /* synthetic */ void b(j jVar, CancellationException cancellationException, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            cancellationException = null;
        }
        a(jVar, cancellationException);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @InlineOnly
    private static final <T> i<T> d(x<? extends T> xVar, Function3<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return k.u(xVar, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    private static final <T> Object f(x<? extends T> xVar, kotlin.coroutines.e<? super Integer> eVar) {
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        kotlin.jvm.internal.d0.e(0);
        Object Y = k.Y(xVar, eVar);
        kotlin.jvm.internal.d0.e(1);
        return Y;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @InlineOnly
    private static final <T> i<T> m(x<? extends T> xVar, long j6, Function2<? super Throwable, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return k.w1(xVar, j6, function2);
    }

    static /* synthetic */ i n(x xVar, long j6, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = Long.MAX_VALUE;
        }
        if ((i6 & 2) != 0) {
            function2 = new LintKt$retry$1(null);
        }
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return k.w1(xVar, j6, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @InlineOnly
    private static final <T> i<T> o(x<? extends T> xVar, Function4<? super j<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function4) {
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return k.y1(xVar, function4);
    }

    @InlineOnly
    private static final <T> Object p(x<? extends T> xVar, List<T> list, kotlin.coroutines.e<?> eVar) {
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        kotlin.jvm.internal.d0.e(0);
        k.Y1(xVar, list, eVar);
        kotlin.jvm.internal.d0.e(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    private static final <T> Object q(x<? extends T> xVar, kotlin.coroutines.e<? super List<? extends T>> eVar) {
        Object c6;
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        kotlin.jvm.internal.d0.e(0);
        c6 = m.c(xVar, null, eVar, 1, null);
        kotlin.jvm.internal.d0.e(1);
        return c6;
    }

    @InlineOnly
    private static final <T> Object r(x<? extends T> xVar, Set<T> set, kotlin.coroutines.e<?> eVar) {
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        kotlin.jvm.internal.d0.e(0);
        k.a2(xVar, set, eVar);
        kotlin.jvm.internal.d0.e(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    private static final <T> Object s(x<? extends T> xVar, kotlin.coroutines.e<? super Set<? extends T>> eVar) {
        Object e6;
        kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        kotlin.jvm.internal.d0.e(0);
        e6 = m.e(xVar, null, eVar, 1, null);
        kotlin.jvm.internal.d0.e(1);
        return e6;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    public static final void a(@NotNull j<?> jVar, @Nullable CancellationException cancellationException) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    public static final <T> i<T> c(@NotNull x<? extends T> xVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    public static final <T> i<T> e(@NotNull h0<? extends T> h0Var) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    public static final <T> i<T> g(@NotNull h0<? extends T> h0Var) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @NotNull
    public static final <T> i<T> h(@NotNull x<? extends T> xVar, @NotNull kotlin.coroutines.i iVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public static final kotlin.coroutines.i i(@NotNull j<?> jVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    public static final boolean k(@NotNull j<?> jVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext()", imports = {}))
    public static /* synthetic */ void j(j jVar) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().isActive", imports = {}))
    public static /* synthetic */ void l(j jVar) {
    }
}
