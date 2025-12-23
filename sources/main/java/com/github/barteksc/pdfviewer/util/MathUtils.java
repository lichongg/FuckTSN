package com.github.barteksc.pdfviewer.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class MathUtils {
    private static final double BIG_ENOUGH_CEIL = 16384.999999999996d;
    private static final double BIG_ENOUGH_FLOOR = 16384.0d;
    private static final int BIG_ENOUGH_INT = 16384;

    public static int ceil(float f6) {
        return ((int) (f6 + BIG_ENOUGH_CEIL)) - 16384;
    }

    public static int floor(float f6) {
        return ((int) (f6 + BIG_ENOUGH_FLOOR)) - 16384;
    }

    public static float limit(float f6, float f7, float f8) {
        return f6 <= f7 ? f7 : f6 >= f8 ? f8 : f6;
    }

    public static float max(float f6, float f7) {
        return f6 > f7 ? f7 : f6;
    }

    public static float min(float f6, float f7) {
        return f6 < f7 ? f7 : f6;
    }

    public static int limit(int i6, int i7, int i8) {
        return i6 <= i7 ? i7 : i6 >= i8 ? i8 : i6;
    }

    public static int max(int i6, int i7) {
        return i6 > i7 ? i7 : i6;
    }

    public static int min(int i6, int i7) {
        return i6 < i7 ? i7 : i6;
    }

    private MathUtils() {
    }
}
