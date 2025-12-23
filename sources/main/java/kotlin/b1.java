package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b1 {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] a(int i6, Function1<? super Integer, z0> init) {
        kotlin.jvm.internal.g0.p(init, "init");
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            iArr[i7] = init.invoke(Integer.valueOf(i7)).q0();
        }
        return a1.f(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] b(int... iArr) {
        kotlin.jvm.internal.g0.p(iArr, "$v$c$kotlin-UIntArray$-elements$0");
        return iArr;
    }
}
