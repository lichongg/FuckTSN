package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;

    /* renamed from: j, reason: collision with root package name */
    private final double f32578j;
    private final double jstar;

    /* renamed from: m, reason: collision with root package name */
    private final double f32579m;

    /* renamed from: q, reason: collision with root package name */
    private final double f32580q;

    /* renamed from: s, reason: collision with root package name */
    private final double f32581s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    public static Cam16 fromInt(int i6) {
        return fromIntInViewingConditions(i6, ViewingConditions.DEFAULT);
    }

    static Cam16 fromIntInViewingConditions(int i6, ViewingConditions viewingConditions) {
        double linearized = ColorUtils.linearized((16711680 & i6) >> 16);
        double linearized2 = ColorUtils.linearized((65280 & i6) >> 8);
        double linearized3 = ColorUtils.linearized(i6 & 255);
        return fromXyzInViewingConditions((0.41233895d * linearized) + (0.35762064d * linearized2) + (0.18051042d * linearized3), (0.2126d * linearized) + (0.7152d * linearized2) + (0.0722d * linearized3), (linearized * 0.01932141d) + (linearized2 * 0.11916382d) + (linearized3 * 0.95034478d), viewingConditions);
    }

    static Cam16 fromJch(double d6, double d7, double d8) {
        return fromJchInViewingConditions(d6, d7, d8, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcs(double d6, double d7, double d8) {
        return fromUcsInViewingConditions(d6, d7, d8, ViewingConditions.DEFAULT);
    }

    static Cam16 fromXyzInViewingConditions(double d6, double d7, double d8, ViewingConditions viewingConditions) {
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d9 = (dArr2[0] * d6) + (dArr2[1] * d7) + (dArr2[2] * d8);
        double[] dArr3 = dArr[1];
        double d10 = (dArr3[0] * d6) + (dArr3[1] * d7) + (dArr3[2] * d8);
        double[] dArr4 = dArr[2];
        double d11 = (dArr4[0] * d6) + (dArr4[1] * d7) + (dArr4[2] * d8);
        double d12 = viewingConditions.getRgbD()[0] * d9;
        double d13 = viewingConditions.getRgbD()[1] * d10;
        double d14 = viewingConditions.getRgbD()[2] * d11;
        double pow = Math.pow((viewingConditions.getFl() * Math.abs(d12)) / 100.0d, 0.42d);
        double pow2 = Math.pow((viewingConditions.getFl() * Math.abs(d13)) / 100.0d, 0.42d);
        double pow3 = Math.pow((viewingConditions.getFl() * Math.abs(d14)) / 100.0d, 0.42d);
        double signum = ((Math.signum(d12) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d13) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d14) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d15 = (((signum * 11.0d) + ((-12.0d) * signum2)) + signum3) / 11.0d;
        double d16 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d17 = signum2 * 20.0d;
        double d18 = (((signum * 20.0d) + d17) + (21.0d * signum3)) / 20.0d;
        double d19 = (((signum * 40.0d) + d17) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d16, d15));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d20 = degrees;
        double radians = Math.toRadians(d20);
        double pow4 = Math.pow((d19 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double d21 = pow4 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (4.0d / viewingConditions.getC()) * Math.sqrt(d21) * (viewingConditions.getAw() + 4.0d);
        double pow5 = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d) * Math.pow(((((((Math.cos(Math.toRadians(d20 < 20.14d ? d20 + 360.0d : d20) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * viewingConditions.getNc()) * viewingConditions.getNcb()) * Math.hypot(d15, d16)) / (d18 + 0.305d), 0.9d);
        double sqrt = pow5 * Math.sqrt(d21);
        double flRoot2 = sqrt * viewingConditions.getFlRoot();
        double sqrt2 = Math.sqrt((pow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d22 = (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d20, sqrt, pow4, flRoot, flRoot2, sqrt2, d22, log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.f32578j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.f32579m;
    }

    public double getQ() {
        return this.f32580q;
    }

    public double getS() {
        return this.f32581s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2]);
    }

    private Cam16(double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14) {
        this.hue = d6;
        this.chroma = d7;
        this.f32578j = d8;
        this.f32580q = d9;
        this.f32579m = d10;
        this.f32581s = d11;
        this.jstar = d12;
        this.astar = d13;
        this.bstar = d14;
    }

    private static Cam16 fromJchInViewingConditions(double d6, double d7, double d8, ViewingConditions viewingConditions) {
        double d9 = d6 / 100.0d;
        double c6 = (4.0d / viewingConditions.getC()) * Math.sqrt(d9) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
        double flRoot = d7 * viewingConditions.getFlRoot();
        double sqrt = Math.sqrt(((d7 / Math.sqrt(d9)) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d8);
        double d10 = (1.7000000000000002d * d6) / ((0.007d * d6) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot) * 43.859649122807014d;
        return new Cam16(d8, d7, d6, c6, flRoot, sqrt, d10, log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public static Cam16 fromUcsInViewingConditions(double d6, double d7, double d8, ViewingConditions viewingConditions) {
        double expm1 = (Math.expm1(Math.hypot(d7, d8) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double atan2 = Math.atan2(d8, d7) * 57.29577951308232d;
        if (atan2 < 0.0d) {
            atan2 += 360.0d;
        }
        return fromJchInViewingConditions(d6 / (1.0d - ((d6 - 100.0d) * 0.007d)), expm1, atan2, viewingConditions);
    }

    double distance(Cam16 cam16) {
        double jstar = getJstar() - cam16.getJstar();
        double astar = getAstar() - cam16.getAstar();
        double bstar = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((jstar * jstar) + (astar * astar) + (bstar * bstar)), 0.63d) * 1.41d;
    }

    double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double d6;
        if (getChroma() != 0.0d && getJ() != 0.0d) {
            d6 = getChroma() / Math.sqrt(getJ() / 100.0d);
        } else {
            d6 = 0.0d;
        }
        double pow = Math.pow(d6 / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double cos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double aw = viewingConditions.getAw() * Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ());
        double nc = cos * 3846.153846153846d * viewingConditions.getNc() * viewingConditions.getNcb();
        double nbb = aw / viewingConditions.getNbb();
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians);
        double d7 = (((0.305d + nbb) * 23.0d) * pow) / (((nc * 23.0d) + ((11.0d * pow) * cos2)) + ((pow * 108.0d) * sin));
        double d8 = cos2 * d7;
        double d9 = d7 * sin;
        double d10 = nbb * 460.0d;
        double d11 = (((451.0d * d8) + d10) + (288.0d * d9)) / 1403.0d;
        double d12 = ((d10 - (891.0d * d8)) - (261.0d * d9)) / 1403.0d;
        double d13 = ((d10 - (d8 * 220.0d)) - (d9 * 6300.0d)) / 1403.0d;
        double signum = Math.signum(d11) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d11) * 27.13d) / (400.0d - Math.abs(d11))), 2.380952380952381d);
        double signum2 = Math.signum(d12) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d12) * 27.13d) / (400.0d - Math.abs(d12))), 2.380952380952381d);
        double signum3 = Math.signum(d13) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d13) * 27.13d) / (400.0d - Math.abs(d13))), 2.380952380952381d);
        double d14 = signum / viewingConditions.getRgbD()[0];
        double d15 = signum2 / viewingConditions.getRgbD()[1];
        double d16 = signum3 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d17 = (dArr3[0] * d14) + (dArr3[1] * d15) + (dArr3[2] * d16);
        double[] dArr4 = dArr2[1];
        double d18 = (dArr4[0] * d14) + (dArr4[1] * d15) + (dArr4[2] * d16);
        double[] dArr5 = dArr2[2];
        double d19 = (d14 * dArr5[0]) + (d15 * dArr5[1]) + (d16 * dArr5[2]);
        if (dArr != null) {
            dArr[0] = d17;
            dArr[1] = d18;
            dArr[2] = d19;
            return dArr;
        }
        return new double[]{d17, d18, d19};
    }
}
