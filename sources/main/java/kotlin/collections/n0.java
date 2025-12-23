package kotlin.collections;

import java.util.List;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class n0 extends m0 {
    @NotNull
    public static final <T> List<T> c1(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return new s1(list);
    }

    @JvmName(name = "asReversedMutable")
    @NotNull
    public static <T> List<T> d1(@NotNull List<T> list) {
        kotlin.jvm.internal.g0.p(list, "<this>");
        return new r1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e1(List<?> list, int i6) {
        if (i6 >= 0 && i6 <= h0.L(list)) {
            return h0.L(list) - i6;
        }
        throw new IndexOutOfBoundsException("Element index " + i6 + " must be in range [" + new kotlin.ranges.m(0, h0.L(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g1(List<?> list, int i6) {
        if (i6 >= 0 && i6 <= list.size()) {
            return list.size() - i6;
        }
        throw new IndexOutOfBoundsException("Position index " + i6 + " must be in range [" + new kotlin.ranges.m(0, list.size()) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f1(List<?> list, int i6) {
        return h0.L(list) - i6;
    }
}
