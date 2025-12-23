package kotlin.comparisons;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h extends g {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final byte K(byte b6, @NotNull byte... other) {
        g0.p(other, "other");
        for (byte b7 : other) {
            b6 = (byte) Math.max((int) b6, (int) b7);
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final double N(double d6, @NotNull double... other) {
        g0.p(other, "other");
        for (double d7 : other) {
            d6 = Math.max(d6, d7);
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final float Q(float f6, @NotNull float... other) {
        g0.p(other, "other");
        for (float f7 : other) {
            f6 = Math.max(f6, f7);
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final int T(int i6, @NotNull int... other) {
        g0.p(other, "other");
        for (int i7 : other) {
            i6 = Math.max(i6, i7);
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final long W(long j6, @NotNull long... other) {
        g0.p(other, "other");
        for (long j7 : other) {
            j6 = Math.max(j6, j7);
        }
        return j6;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <T extends Comparable<? super T>> T X(@NotNull T a6, @NotNull T b6) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        return a6.compareTo(b6) >= 0 ? a6 : b6;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T Y(@NotNull T a6, @NotNull T b6, @NotNull T c6) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        g0.p(c6, "c");
        return (T) X(a6, X(b6, c6));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T extends Comparable<? super T>> T Z(@NotNull T a6, @NotNull T... other) {
        g0.p(a6, "a");
        g0.p(other, "other");
        for (T t5 : other) {
            a6 = (T) X(a6, t5);
        }
        return a6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final short c0(short s5, @NotNull short... other) {
        g0.p(other, "other");
        for (short s6 : other) {
            s5 = (short) Math.max((int) s5, (int) s6);
        }
        return s5;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final byte f0(byte b6, @NotNull byte... other) {
        g0.p(other, "other");
        for (byte b7 : other) {
            b6 = (byte) Math.min((int) b6, (int) b7);
        }
        return b6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final double i0(double d6, @NotNull double... other) {
        g0.p(other, "other");
        for (double d7 : other) {
            d6 = Math.min(d6, d7);
        }
        return d6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final float l0(float f6, @NotNull float... other) {
        g0.p(other, "other");
        for (float f7 : other) {
            f6 = Math.min(f6, f7);
        }
        return f6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final int o0(int i6, @NotNull int... other) {
        g0.p(other, "other");
        for (int i7 : other) {
            i6 = Math.min(i6, i7);
        }
        return i6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final long r0(long j6, @NotNull long... other) {
        g0.p(other, "other");
        for (long j7 : other) {
            j6 = Math.min(j6, j7);
        }
        return j6;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T s0(@NotNull T a6, @NotNull T b6) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        return a6.compareTo(b6) <= 0 ? a6 : b6;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T t0(@NotNull T a6, @NotNull T b6, @NotNull T c6) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        g0.p(c6, "c");
        return (T) s0(a6, s0(b6, c6));
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T extends Comparable<? super T>> T u0(@NotNull T a6, @NotNull T... other) {
        g0.p(a6, "a");
        g0.p(other, "other");
        for (T t5 : other) {
            a6 = (T) s0(a6, t5);
        }
        return a6;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static final short x0(short s5, @NotNull short... other) {
        g0.p(other, "other");
        for (short s6 : other) {
            s5 = (short) Math.min((int) s5, (int) s6);
        }
        return s5;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte I(byte b6, byte b7) {
        return (byte) Math.max((int) b6, (int) b7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte J(byte b6, byte b7, byte b8) {
        return (byte) Math.max((int) b6, Math.max((int) b7, (int) b8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double L(double d6, double d7) {
        return Math.max(d6, d7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double M(double d6, double d7, double d8) {
        return Math.max(d6, Math.max(d7, d8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float O(float f6, float f7) {
        return Math.max(f6, f7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float P(float f6, float f7, float f8) {
        return Math.max(f6, Math.max(f7, f8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int R(int i6, int i7) {
        return Math.max(i6, i7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int S(int i6, int i7, int i8) {
        return Math.max(i6, Math.max(i7, i8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long U(long j6, long j7) {
        return Math.max(j6, j7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long V(long j6, long j7, long j8) {
        return Math.max(j6, Math.max(j7, j8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short a0(short s5, short s6) {
        return (short) Math.max((int) s5, (int) s6);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short b0(short s5, short s6, short s7) {
        return (short) Math.max((int) s5, Math.max((int) s6, (int) s7));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte d0(byte b6, byte b7) {
        return (byte) Math.min((int) b6, (int) b7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte e0(byte b6, byte b7, byte b8) {
        return (byte) Math.min((int) b6, Math.min((int) b7, (int) b8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double g0(double d6, double d7) {
        return Math.min(d6, d7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double h0(double d6, double d7, double d8) {
        return Math.min(d6, Math.min(d7, d8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float j0(float f6, float f7) {
        return Math.min(f6, f7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float k0(float f6, float f7, float f8) {
        return Math.min(f6, Math.min(f7, f8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int m0(int i6, int i7) {
        return Math.min(i6, i7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int n0(int i6, int i7, int i8) {
        return Math.min(i6, Math.min(i7, i8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long p0(long j6, long j7) {
        return Math.min(j6, j7);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long q0(long j6, long j7, long j8) {
        return Math.min(j6, Math.min(j7, j8));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short v0(short s5, short s6) {
        return (short) Math.min((int) s5, (int) s6);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short w0(short s5, short s6, short s7) {
        return (short) Math.min((int) s5, Math.min((int) s6, (int) s7));
    }
}
