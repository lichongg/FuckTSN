package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l1 {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] a(int i6, Function1<? super Integer, j1> init) {
        kotlin.jvm.internal.g0.p(init, "init");
        short[] sArr = new short[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            sArr[i7] = init.invoke(Integer.valueOf(i7)).o0();
        }
        return k1.f(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] b(short... sArr) {
        kotlin.jvm.internal.g0.p(sArr, "$v$c$kotlin-UShortArray$-elements$0");
        return sArr;
    }
}
