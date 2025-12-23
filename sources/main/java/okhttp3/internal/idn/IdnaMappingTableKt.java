package okhttp3.internal.idn;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class IdnaMappingTableKt {
    public static final int binarySearch(int i6, int i7, @NotNull Function1<? super Integer, Integer> compare) {
        g0.p(compare, "compare");
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) / 2;
            int intValue = compare.invoke(Integer.valueOf(i9)).intValue();
            if (intValue < 0) {
                i8 = i9 - 1;
            } else {
                if (intValue <= 0) {
                    return i9;
                }
                i6 = i9 + 1;
            }
        }
        return (-i6) - 1;
    }

    public static final int read14BitInt(@NotNull String str, int i6) {
        g0.p(str, "<this>");
        char charAt = str.charAt(i6);
        return (charAt << 7) + str.charAt(i6 + 1);
    }
}
