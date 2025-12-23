package com.yalantis.ucrop.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b {
    public static float a(float f6, float f7, float f8, float f9) {
        float f10 = f6 / f9;
        return (f8 * f10 * f10 * f10) + f7;
    }

    public static float c(float f6, float f7, float f8, float f9) {
        float f10 = (f6 / f9) - 1.0f;
        return (f8 * ((f10 * f10 * f10) + 1.0f)) + f7;
    }

    public static float b(float f6, float f7, float f8, float f9) {
        float f10;
        float f11 = f6 / (f9 / 2.0f);
        float f12 = f8 / 2.0f;
        if (f11 < 1.0f) {
            f10 = f12 * f11 * f11 * f11;
        } else {
            float f13 = f11 - 2.0f;
            f10 = f12 * ((f13 * f13 * f13) + 2.0f);
        }
        return f10 + f7;
    }
}
