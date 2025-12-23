package kotlin.comparisons;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.a1;
import kotlin.e1;
import kotlin.internal.InlineOnly;
import kotlin.j1;
import kotlin.jvm.internal.g0;
import kotlin.k1;
import kotlin.w0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class n {
    @SinceKotlin(version = "1.5")
    public static final byte c(byte b6, byte b7) {
        return g0.t(b6 & 255, b7 & 255) >= 0 ? b6 : b7;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final int d(int i6, @NotNull int... iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-other$0");
        int r5 = a1.r(iArr);
        for (int i7 = 0; i7 < r5; i7++) {
            i6 = b(i6, a1.p(iArr, i7));
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final long e(long j6, @NotNull long... jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-other$0");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            j6 = j(j6, e1.p(jArr, i6));
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final byte h(byte b6, @NotNull byte... bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-other$0");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            b6 = c(b6, w0.p(bArr, i6));
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final short l(short s5, @NotNull short... sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-other$0");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            s5 = a(s5, k1.p(sArr, i6));
        }
        return s5;
    }

    @SinceKotlin(version = "1.5")
    public static final byte o(byte b6, byte b7) {
        return g0.t(b6 & 255, b7 & 255) <= 0 ? b6 : b7;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final int p(int i6, @NotNull int... iArr) {
        g0.p(iArr, "$v$c$kotlin-UIntArray$-other$0");
        int r5 = a1.r(iArr);
        for (int i7 = 0; i7 < r5; i7++) {
            i6 = n(i6, a1.p(iArr, i7));
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final long q(long j6, @NotNull long... jArr) {
        g0.p(jArr, "$v$c$kotlin-ULongArray$-other$0");
        int r5 = e1.r(jArr);
        for (int i6 = 0; i6 < r5; i6++) {
            j6 = v(j6, e1.p(jArr, i6));
        }
        return j6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final byte t(byte b6, @NotNull byte... bArr) {
        g0.p(bArr, "$v$c$kotlin-UByteArray$-other$0");
        int r5 = w0.r(bArr);
        for (int i6 = 0; i6 < r5; i6++) {
            b6 = o(b6, w0.p(bArr, i6));
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalUnsignedTypes
    public static final short x(short s5, @NotNull short... sArr) {
        g0.p(sArr, "$v$c$kotlin-UShortArray$-other$0");
        int r5 = k1.r(sArr);
        for (int i6 = 0; i6 < r5; i6++) {
            s5 = m(s5, k1.p(sArr, i6));
        }
        return s5;
    }

    @SinceKotlin(version = "1.5")
    public static final short a(short s5, short s6) {
        if (g0.t(s5 & j1.f43986d, 65535 & s6) >= 0) {
            return s5;
        }
        return s6;
    }

    @SinceKotlin(version = "1.5")
    public static int b(int i6, int i7) {
        int compare;
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
        if (compare >= 0) {
            return i6;
        }
        return i7;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short f(short s5, short s6, short s7) {
        return a(s5, a(s6, s7));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int g(int i6, int i7, int i8) {
        return b(i6, b(i7, i8));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte i(byte b6, byte b7, byte b8) {
        return c(b6, c(b7, b8));
    }

    @SinceKotlin(version = "1.5")
    public static long j(long j6, long j7) {
        int compare;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
        if (compare >= 0) {
            return j6;
        }
        return j7;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long k(long j6, long j7, long j8) {
        return j(j6, j(j7, j8));
    }

    @SinceKotlin(version = "1.5")
    public static final short m(short s5, short s6) {
        if (g0.t(s5 & j1.f43986d, 65535 & s6) <= 0) {
            return s5;
        }
        return s6;
    }

    @SinceKotlin(version = "1.5")
    public static int n(int i6, int i7) {
        int compare;
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            return i6;
        }
        return i7;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short r(short s5, short s6, short s7) {
        return m(s5, m(s6, s7));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int s(int i6, int i7, int i8) {
        return n(i6, n(i7, i8));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte u(byte b6, byte b7, byte b8) {
        return o(b6, o(b7, b8));
    }

    @SinceKotlin(version = "1.5")
    public static long v(long j6, long j7) {
        int compare;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
        if (compare <= 0) {
            return j6;
        }
        return j7;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long w(long j6, long j7, long j8) {
        return v(j6, v(j7, j8));
    }
}
