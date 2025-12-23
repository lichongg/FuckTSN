package kotlin.comparisons;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Comparator;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class i extends h {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T> T A0(T t5, @NotNull T[] other, @NotNull Comparator<? super T> comparator) {
        g0.p(other, "other");
        g0.p(comparator, "comparator");
        for (T t6 : other) {
            if (comparator.compare(t5, t6) < 0) {
                t5 = t6;
            }
        }
        return t5;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T B0(T t5, T t6, T t7, @NotNull Comparator<? super T> comparator) {
        g0.p(comparator, "comparator");
        return (T) C0(t5, C0(t6, t7, comparator), comparator);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T C0(T t5, T t6, @NotNull Comparator<? super T> comparator) {
        g0.p(comparator, "comparator");
        return comparator.compare(t5, t6) <= 0 ? t5 : t6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final <T> T D0(T t5, @NotNull T[] other, @NotNull Comparator<? super T> comparator) {
        g0.p(other, "other");
        g0.p(comparator, "comparator");
        for (T t6 : other) {
            if (comparator.compare(t5, t6) > 0) {
                t5 = t6;
            }
        }
        return t5;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T y0(T t5, T t6, T t7, @NotNull Comparator<? super T> comparator) {
        g0.p(comparator, "comparator");
        return (T) z0(t5, z0(t6, t7, comparator), comparator);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T z0(T t5, T t6, @NotNull Comparator<? super T> comparator) {
        g0.p(comparator, "comparator");
        return comparator.compare(t5, t6) >= 0 ? t5 : t6;
    }
}
