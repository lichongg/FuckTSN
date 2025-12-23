package kotlin;

import kotlin.coroutines.RestrictsSuspension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.7")
@RestrictsSuspension
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class j<T, R> {
    public /* synthetic */ j(kotlin.jvm.internal.v vVar) {
        this();
    }

    @Nullable
    public abstract Object b(T t5, @NotNull kotlin.coroutines.e<? super R> eVar);

    @Nullable
    public abstract <U, S> Object c(@NotNull h<U, S> hVar, U u5, @NotNull kotlin.coroutines.e<? super S> eVar);

    private j() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    @NotNull
    public final Void d(@NotNull h<?, ?> hVar, @Nullable Object obj) {
        kotlin.jvm.internal.g0.p(hVar, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
