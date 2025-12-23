package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04d;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4d;
    public static final double RATIO_30 = 3.0d;
    public static final double RATIO_45 = 4.5d;
    public static final double RATIO_70 = 7.0d;
    public static final double RATIO_MAX = 21.0d;
    public static final double RATIO_MIN = 1.0d;

    public static double darker(double d6, double d7) {
        if (d6 >= 0.0d && d6 <= 100.0d) {
            double yFromLstar = ColorUtils.yFromLstar(d6);
            double d8 = ((yFromLstar + 5.0d) / d7) - 5.0d;
            if (d8 >= 0.0d && d8 <= 100.0d) {
                double ratioOfYs = ratioOfYs(yFromLstar, d8);
                double abs = Math.abs(ratioOfYs - d7);
                if (ratioOfYs < d7 && abs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double lstarFromY = ColorUtils.lstarFromY(d8) - LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (lstarFromY >= 0.0d && lstarFromY <= 100.0d) {
                    return lstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double lighter(double d6, double d7) {
        if (d6 >= 0.0d && d6 <= 100.0d) {
            double yFromLstar = ColorUtils.yFromLstar(d6);
            double d8 = ((yFromLstar + 5.0d) * d7) - 5.0d;
            if (d8 >= 0.0d && d8 <= 100.0d) {
                double ratioOfYs = ratioOfYs(d8, yFromLstar);
                double abs = Math.abs(ratioOfYs - d7);
                if (ratioOfYs < d7 && abs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double lstarFromY = ColorUtils.lstarFromY(d8) + LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (lstarFromY >= 0.0d && lstarFromY <= 100.0d) {
                    return lstarFromY;
                }
            }
        }
        return -1.0d;
    }

    private Contrast() {
    }

    public static double darkerUnsafe(double d6, double d7) {
        return Math.max(0.0d, darker(d6, d7));
    }

    public static double lighterUnsafe(double d6, double d7) {
        double lighter = lighter(d6, d7);
        if (lighter < 0.0d) {
            return 100.0d;
        }
        return lighter;
    }

    public static double ratioOfTones(double d6, double d7) {
        return ratioOfYs(ColorUtils.yFromLstar(d6), ColorUtils.yFromLstar(d7));
    }

    public static double ratioOfYs(double d6, double d7) {
        double max = Math.max(d6, d7);
        if (max != d7) {
            d6 = d7;
        }
        return (max + 5.0d) / (d6 + 5.0d);
    }
}
