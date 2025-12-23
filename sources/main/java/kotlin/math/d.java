package kotlin.math;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d extends c {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float B(float f6) {
        return (float) Math.cos(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float B0(float f6, float f7) {
        return Math.nextAfter(f6, f7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float D(float f6) {
        return (float) Math.cosh(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float F(float f6) {
        return (float) Math.exp(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double F0(double d6, int i6) {
        return Math.pow(d6, i6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float G0(float f6, float f7) {
        return (float) Math.pow(f6, f7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float H(float f6) {
        return (float) Math.expm1(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float H0(float f6, int i6) {
        return (float) Math.pow(f6, i6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float J(float f6) {
        return (float) Math.floor(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float J0(float f6) {
        return (float) Math.rint(f6);
    }

    @SinceKotlin(version = "1.2")
    public static final long N0(float f6) {
        return M0(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float R0(float f6) {
        return (float) Math.sin(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float T0(float f6) {
        return (float) Math.sinh(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float V0(float f6) {
        return (float) Math.sqrt(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float X0(float f6) {
        return (float) Math.tan(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float Z0(float f6) {
        return (float) Math.tanh(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float d(float f6, float f7) {
        return (float) Math.IEEEremainder(f6, f7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double d1(double d6, int i6) {
        return Math.copySign(d6, i6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f0(float f6, float f7) {
        return (float) Math.hypot(f6, f7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f1(float f6, int i6) {
        return Math.copySign(f6, i6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float h0(float f6) {
        return (float) Math.log(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float j(float f6) {
        return (float) Math.acos(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float j0(float f6) {
        return (float) Math.log1p(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float l(float f6) {
        return (float) k(f6);
    }

    @SinceKotlin(version = "1.2")
    public static final float l0(float f6, float f7) {
        if (f7 <= 0.0f || f7 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f6) / Math.log(f7));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float n(float f6) {
        return (float) Math.asin(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float n0(float f6) {
        return (float) Math.log10(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float p(float f6) {
        return (float) o(f6);
    }

    @SinceKotlin(version = "1.2")
    public static final float p0(float f6) {
        return (float) (Math.log(f6) / a.f44115b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float r(float f6) {
        return (float) Math.atan(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float t(float f6, float f7) {
        return (float) Math.atan2(f6, f7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float v(float f6) {
        return (float) u(f6);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final float x(float f6) {
        return (float) Math.cbrt(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float z(float f6) {
        return (float) Math.ceil(f6);
    }

    @SinceKotlin(version = "1.2")
    public static final double k(double d6) {
        if (d6 < 1.0d) {
            return Double.NaN;
        }
        if (d6 > a.f44119f) {
            return Math.log(d6) + a.f44115b;
        }
        double d7 = 1;
        double d8 = d6 - d7;
        if (d8 >= a.f44118e) {
            return Math.log(d6 + Math.sqrt((d6 * d6) - d7));
        }
        double sqrt = Math.sqrt(d8);
        if (sqrt >= a.f44117d) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return Math.sqrt(2.0d) * sqrt;
    }

    @SinceKotlin(version = "1.2")
    public static final double k0(double d6, double d7) {
        if (d7 <= 0.0d || d7 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d6) / Math.log(d7);
    }

    @SinceKotlin(version = "1.2")
    public static final double o(double d6) {
        double d7 = a.f44118e;
        if (d6 < d7) {
            return d6 <= (-d7) ? -o(-d6) : Math.abs(d6) >= a.f44117d ? d6 - (((d6 * d6) * d6) / 6) : d6;
        }
        if (d6 <= a.f44120g) {
            return Math.log(d6 + Math.sqrt((d6 * d6) + 1));
        }
        if (d6 > a.f44119f) {
            return Math.log(d6) + a.f44115b;
        }
        double d8 = d6 * 2;
        return Math.log(d8 + (1 / d8));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double y0(double d6) {
        return Math.nextAfter(d6, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float z0(float f6) {
        return Math.nextAfter(f6, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double A(double d6) {
        return Math.cos(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double A0(double d6, double d7) {
        return Math.nextAfter(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double C(double d6) {
        return Math.cosh(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double C0(double d6) {
        return Math.nextUp(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float D0(float f6) {
        return Math.nextUp(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double E(double d6) {
        return Math.exp(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double E0(double d6, double d7) {
        return Math.pow(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double G(double d6) {
        return Math.expm1(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double I(double d6) {
        return Math.floor(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double I0(double d6) {
        return Math.rint(d6);
    }

    private static final double K(double d6) {
        return Math.abs(d6);
    }

    @SinceKotlin(version = "1.2")
    public static int K0(double d6) {
        if (!Double.isNaN(d6)) {
            if (d6 > 2.147483647E9d) {
                return Integer.MAX_VALUE;
            }
            if (d6 < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d6);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    private static final float L(float f6) {
        return Math.abs(f6);
    }

    @SinceKotlin(version = "1.2")
    public static final int L0(float f6) {
        if (!Float.isNaN(f6)) {
            return Math.round(f6);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    private static final int M(int i6) {
        return Math.abs(i6);
    }

    @SinceKotlin(version = "1.2")
    public static long M0(double d6) {
        if (!Double.isNaN(d6)) {
            return Math.round(d6);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    private static final long N(long j6) {
        return Math.abs(j6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double O0(double d6) {
        return Math.signum(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float P0(float f6) {
        return Math.signum(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double Q0(double d6) {
        return Math.sin(d6);
    }

    private static final double S(double d6) {
        return Math.signum(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double S0(double d6) {
        return Math.sinh(d6);
    }

    private static final float T(float f6) {
        return Math.signum(f6);
    }

    public static int U(int i6) {
        return Integer.signum(i6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double U0(double d6) {
        return Math.sqrt(d6);
    }

    public static int V(long j6) {
        return Long.signum(j6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double W0(double d6) {
        return Math.tan(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double Y0(double d6) {
        return Math.tanh(d6);
    }

    private static final double a0(double d6) {
        return Math.ulp(d6);
    }

    @SinceKotlin(version = "1.2")
    public static final double a1(double d6) {
        if (!Double.isNaN(d6) && !Double.isInfinite(d6)) {
            if (d6 > 0.0d) {
                return Math.floor(d6);
            }
            return Math.ceil(d6);
        }
        return d6;
    }

    private static final float b0(float f6) {
        return Math.ulp(f6);
    }

    @SinceKotlin(version = "1.2")
    public static final float b1(float f6) {
        double ceil;
        if (!Float.isNaN(f6) && !Float.isInfinite(f6)) {
            if (f6 > 0.0f) {
                ceil = Math.floor(f6);
            } else {
                ceil = Math.ceil(f6);
            }
            return (float) ceil;
        }
        return f6;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double c(double d6, double d7) {
        return Math.IEEEremainder(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double c1(double d6, double d7) {
        return Math.copySign(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double e(double d6) {
        return Math.abs(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double e0(double d6, double d7) {
        return Math.hypot(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float e1(float f6, float f7) {
        return Math.copySign(f6, f7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f(float f6) {
        return Math.abs(f6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int g(int i6) {
        return Math.abs(i6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double g0(double d6) {
        return Math.log(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long h(long j6) {
        return Math.abs(j6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double i(double d6) {
        return Math.acos(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double i0(double d6) {
        return Math.log1p(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double m(double d6) {
        return Math.asin(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double m0(double d6) {
        return Math.log10(d6);
    }

    @SinceKotlin(version = "1.2")
    public static final double o0(double d6) {
        return Math.log(d6) / a.f44115b;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double q(double d6) {
        return Math.atan(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double q0(double d6, double d7) {
        return Math.max(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float r0(float f6, float f7) {
        return Math.max(f6, f7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double s(double d6, double d7) {
        return Math.atan2(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int s0(int i6, int i7) {
        return Math.max(i6, i7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long t0(long j6, long j7) {
        return Math.max(j6, j7);
    }

    @SinceKotlin(version = "1.2")
    public static final double u(double d6) {
        if (Math.abs(d6) < a.f44118e) {
            if (Math.abs(d6) > a.f44117d) {
                return d6 + (((d6 * d6) * d6) / 3);
            }
            return d6;
        }
        double d7 = 1;
        return Math.log((d7 + d6) / (d7 - d6)) / 2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double u0(double d6, double d7) {
        return Math.min(d6, d7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float v0(float f6, float f7) {
        return Math.min(f6, f7);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final double w(double d6) {
        return Math.cbrt(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int w0(int i6, int i7) {
        return Math.min(i6, i7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long x0(long j6, long j7) {
        return Math.min(j6, j7);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double y(double d6) {
        return Math.ceil(d6);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void O(double d6) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void P(float f6) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void Q(int i6) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void R(long j6) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void W(double d6) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void X(float f6) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void Y(int i6) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void Z(long j6) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void c0(double d6) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void d0(float f6) {
    }
}
