package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class l0 extends k0 {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void l0(List<T> list, T t5) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        Collections.fill(list, t5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void m0(List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        Collections.shuffle(list);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void n0(List<T> list, Random random) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(random, "random");
        Collections.shuffle(list, random);
    }

    public static <T extends Comparable<? super T>> void o0(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    @InlineOnly
    private static final <T> void p0(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @InlineOnly
    private static final <T> void q0(List<T> list, Function2<? super T, ? super T, Integer> comparison) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(comparison, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    public static <T> void r0(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
