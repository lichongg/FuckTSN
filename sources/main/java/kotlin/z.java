package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class z extends y {
    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long S(byte b6, long j6) {
        long j7 = b6;
        long j8 = j7 / j6;
        return ((j7 ^ j6) >= 0 || j6 * j8 == j7) ? j8 : j8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long T(int i6, long j6) {
        long j7 = i6;
        long j8 = j7 / j6;
        return ((j7 ^ j6) >= 0 || j6 * j8 == j7) ? j8 : j8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long U(long j6, byte b6) {
        long j7 = b6;
        long j8 = j6 / j7;
        return ((j6 ^ j7) >= 0 || j7 * j8 == j6) ? j8 : j8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long V(long j6, int i6) {
        long j7 = i6;
        long j8 = j6 / j7;
        return ((j6 ^ j7) >= 0 || j7 * j8 == j6) ? j8 : j8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long X(long j6, short s5) {
        long j7 = s5;
        long j8 = j6 / j7;
        return ((j6 ^ j7) >= 0 || j7 * j8 == j6) ? j8 : j8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long Y(short s5, long j6) {
        long j7 = s5;
        long j8 = j7 / j6;
        return ((j7 ^ j6) >= 0 || j6 * j8 == j7) ? j8 : j8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte Z(byte b6, byte b7) {
        int i6 = b6 % b7;
        return (byte) (i6 + (b7 & (((i6 ^ b7) & ((-i6) | i6)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte a0(int i6, byte b6) {
        int i7 = i6 % b6;
        return (byte) (i7 + (b6 & (((i7 ^ b6) & ((-i7) | i7)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte b0(long j6, byte b6) {
        long j7 = j6 % b6;
        return (byte) (j7 + (r0 & (((j7 ^ r0) & ((-j7) | j7)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte c0(short s5, byte b6) {
        int i6 = s5 % b6;
        return (byte) (i6 + (b6 & (((i6 ^ b6) & ((-i6) | i6)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double d0(double d6, double d7) {
        double d8 = d6 % d7;
        return d8 == 0.0d ? d8 : Math.signum(d8) == Math.signum(d7) ? d8 : d8 + d7;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double e0(double d6, float f6) {
        double d7 = f6;
        double d8 = d6 % d7;
        return d8 == 0.0d ? d8 : Math.signum(d8) == Math.signum(d7) ? d8 : d8 + d7;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double f0(float f6, double d6) {
        double d7 = f6 % d6;
        return d7 == 0.0d ? d7 : Math.signum(d7) == Math.signum(d6) ? d7 : d7 + d6;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final float g0(float f6, float f7) {
        float f8 = f6 % f7;
        return f8 == 0.0f ? f8 : Math.signum(f8) == Math.signum(f7) ? f8 : f8 + f7;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int h0(byte b6, int i6) {
        int i7 = b6 % i6;
        return i7 + (i6 & (((i7 ^ i6) & ((-i7) | i7)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int i0(int i6, int i7) {
        int i8 = i6 % i7;
        return i8 + (i7 & (((i8 ^ i7) & ((-i8) | i8)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int j0(long j6, int i6) {
        long j7 = i6;
        long j8 = j6 % j7;
        return (int) (j8 + (j7 & (((j8 ^ j7) & ((-j8) | j8)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int k0(short s5, int i6) {
        int i7 = s5 % i6;
        return i7 + (i6 & (((i7 ^ i6) & ((-i7) | i7)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long l0(byte b6, long j6) {
        long j7 = b6 % j6;
        return j7 + (j6 & (((j7 ^ j6) & ((-j7) | j7)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long m0(int i6, long j6) {
        long j7 = i6 % j6;
        return j7 + (j6 & (((j7 ^ j6) & ((-j7) | j7)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long n0(long j6, long j7) {
        long j8 = j6 % j7;
        return j8 + (j7 & (((j8 ^ j7) & ((-j8) | j8)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long o0(short s5, long j6) {
        long j7 = s5 % j6;
        return j7 + (j6 & (((j7 ^ j6) & ((-j7) | j7)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short p0(byte b6, short s5) {
        int i6 = b6 % s5;
        return (short) (i6 + (s5 & (((i6 ^ s5) & ((-i6) | i6)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short q0(int i6, short s5) {
        int i7 = i6 % s5;
        return (short) (i7 + (s5 & (((i7 ^ s5) & ((-i7) | i7)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short r0(long j6, short s5) {
        long j7 = j6 % s5;
        return (short) (j7 + (r0 & (((j7 ^ r0) & ((-j7) | j7)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short s0(short s5, short s6) {
        int i6 = s5 % s6;
        return (short) (i6 + (s6 & (((i6 ^ s6) & ((-i6) | i6)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int J(byte b6, byte b7) {
        int i6 = b6 / b7;
        return ((b6 ^ b7) >= 0 || b7 * i6 == b6) ? i6 : i6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int K(byte b6, int i6) {
        int i7 = b6 / i6;
        return ((b6 ^ i6) >= 0 || i6 * i7 == b6) ? i7 : i7 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int L(byte b6, short s5) {
        int i6 = b6 / s5;
        return ((b6 ^ s5) >= 0 || s5 * i6 == b6) ? i6 : i6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int M(int i6, byte b6) {
        int i7 = i6 / b6;
        return ((i6 ^ b6) >= 0 || b6 * i7 == i6) ? i7 : i7 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int N(int i6, int i7) {
        int i8 = i6 / i7;
        return ((i6 ^ i7) >= 0 || i7 * i8 == i6) ? i8 : i8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int O(int i6, short s5) {
        int i7 = i6 / s5;
        return ((i6 ^ s5) >= 0 || s5 * i7 == i6) ? i7 : i7 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int P(short s5, byte b6) {
        int i6 = s5 / b6;
        return ((s5 ^ b6) >= 0 || b6 * i6 == s5) ? i6 : i6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int Q(short s5, int i6) {
        int i7 = s5 / i6;
        return ((s5 ^ i6) >= 0 || i6 * i7 == s5) ? i7 : i7 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int R(short s5, short s6) {
        int i6 = s5 / s6;
        return ((s5 ^ s6) >= 0 || s6 * i6 == s5) ? i6 : i6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long W(long j6, long j7) {
        long j8 = j6 / j7;
        return ((j6 ^ j7) >= 0 || j7 * j8 == j6) ? j8 : j8 - 1;
    }
}
