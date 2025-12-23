package com.google.android.material.math;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    public static float dist(float f6, float f7, float f8, float f9) {
        return (float) Math.hypot(f8 - f6, f9 - f7);
    }

    public static float floorMod(float f6, int i6) {
        float f7 = i6;
        int i7 = (int) (f6 / f7);
        if (Math.signum(f6) * f7 < 0.0f && i7 * i6 != f6) {
            i7--;
        }
        return f6 - (i7 * i6);
    }

    public static boolean geq(float f6, float f7, float f8) {
        return f6 + f8 >= f7;
    }

    public static int floorMod(int i6, int i7) {
        int i8 = i6 / i7;
        if ((i6 ^ i7) < 0 && i8 * i7 != i6) {
            i8--;
        }
        return i6 - (i8 * i7);
    }

    public static float lerp(float f6, float f7, float f8) {
        return ((1.0f - f8) * f6) + (f8 * f7);
    }

    private static float max(float f6, float f7, float f8, float f9) {
        return (f6 <= f7 || f6 <= f8 || f6 <= f9) ? (f7 <= f8 || f7 <= f9) ? f8 > f9 ? f8 : f9 : f7 : f6;
    }

    private MathUtils() {
    }

    public static float distanceToFurthestCorner(float f6, float f7, float f8, float f9, float f10, float f11) {
        return max(dist(f6, f7, f8, f9), dist(f6, f7, f10, f9), dist(f6, f7, f10, f11), dist(f6, f7, f8, f11));
    }
}
