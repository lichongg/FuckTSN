package kotlin.ranges;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class u {
    public static final void a(boolean z5, @NotNull Number step) {
        g0.p(step, "step");
        if (z5) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/h<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean b(h hVar, Object obj) {
        g0.p(hVar, "<this>");
        return obj != null && hVar.contains((Comparable) obj);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/s<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final boolean c(s sVar, Object obj) {
        g0.p(sVar, "<this>");
        return obj != null && sVar.contains((Comparable) obj);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final g<Double> d(double d6, double d7) {
        return new e(d6, d7);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final g<Float> e(float f6, float f7) {
        return new f(f6, f7);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> h<T> f(@NotNull T t5, @NotNull T that) {
        g0.p(t5, "<this>");
        g0.p(that, "that");
        return new j(t5, that);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final s<Double> g(double d6, double d7) {
        return new q(d6, d7);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final s<Float> h(float f6, float f7) {
        return new r(f6, f7);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T extends Comparable<? super T>> s<T> i(@NotNull T t5, @NotNull T that) {
        g0.p(t5, "<this>");
        g0.p(that, "that");
        return new i(t5, that);
    }
}
