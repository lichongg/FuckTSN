package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f1 {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] a(int i6, Function1<? super Integer, d1> init) {
        kotlin.jvm.internal.g0.p(init, "init");
        long[] jArr = new long[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            jArr[i7] = init.invoke(Integer.valueOf(i7)).q0();
        }
        return e1.f(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] b(long... jArr) {
        kotlin.jvm.internal.g0.p(jArr, "$v$c$kotlin-ULongArray$-elements$0");
        return jArr;
    }
}
