package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x0 {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] a(int i6, Function1<? super Integer, v0> init) {
        kotlin.jvm.internal.g0.p(init, "init");
        byte[] bArr = new byte[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            bArr[i7] = init.invoke(Integer.valueOf(i7)).o0();
        }
        return w0.f(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] b(byte... bArr) {
        kotlin.jvm.internal.g0.p(bArr, "$v$c$kotlin-UByteArray$-elements$0");
        return bArr;
    }
}
