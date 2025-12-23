package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final char a(int i6) {
        if (i6 >= 0 && i6 <= 65535) {
            return (char) i6;
        }
        throw new IllegalArgumentException("Invalid Char code: " + i6);
    }

    private static final int b(char c6) {
        return c6;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    public static /* synthetic */ void c(char c6) {
    }
}
