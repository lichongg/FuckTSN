package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class MathUtils {
    public static double differenceDegrees(double d6, double d7) {
        return 180.0d - Math.abs(Math.abs(d6 - d7) - 180.0d);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d6 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d7 = dArr3[0] * d6;
        double d8 = dArr[1];
        double d9 = d7 + (dArr3[1] * d8);
        double d10 = dArr[2];
        double d11 = d9 + (dArr3[2] * d10);
        double[] dArr4 = dArr2[1];
        double d12 = (dArr4[0] * d6) + (dArr4[1] * d8) + (dArr4[2] * d10);
        double[] dArr5 = dArr2[2];
        return new double[]{d11, d12, (d6 * dArr5[0]) + (d8 * dArr5[1]) + (d10 * dArr5[2])};
    }

    public static double rotationDirection(double d6, double d7) {
        return sanitizeDegreesDouble(d7 - d6) <= 180.0d ? 1.0d : -1.0d;
    }

    public static double clampDouble(double d6, double d7, double d8) {
        return d8 < d6 ? d6 : d8 > d7 ? d7 : d8;
    }

    public static int clampInt(int i6, int i7, int i8) {
        return i8 < i6 ? i6 : i8 > i7 ? i7 : i8;
    }

    public static double lerp(double d6, double d7, double d8) {
        return ((1.0d - d8) * d6) + (d8 * d7);
    }

    public static int sanitizeDegreesInt(int i6) {
        int i7 = i6 % 360;
        return i7 < 0 ? i7 + 360 : i7;
    }

    public static int signum(double d6) {
        if (d6 < 0.0d) {
            return -1;
        }
        return d6 == 0.0d ? 0 : 1;
    }

    private MathUtils() {
    }

    public static double sanitizeDegreesDouble(double d6) {
        double d7 = d6 % 360.0d;
        if (d7 < 0.0d) {
            return d7 + 360.0d;
        }
        return d7;
    }
}
