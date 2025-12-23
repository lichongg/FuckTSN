package com.bytedance.adsdk.lottie.up;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static float j(float f6) {
        return f6 <= 0.0031308f ? f6 * 12.92f : (float) ((Math.pow(f6, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int j(float f6, int i6, int i7) {
        if (i6 == i7) {
            return i6;
        }
        float f7 = ((i6 >> 24) & 255) / 255.0f;
        float xt = xt(((i6 >> 16) & 255) / 255.0f);
        float xt2 = xt(((i6 >> 8) & 255) / 255.0f);
        float xt3 = xt((i6 & 255) / 255.0f);
        float xt4 = xt(((i7 >> 16) & 255) / 255.0f);
        float f8 = f7 + (((((i7 >> 24) & 255) / 255.0f) - f7) * f6);
        float xt5 = xt2 + ((xt(((i7 >> 8) & 255) / 255.0f) - xt2) * f6);
        float xt6 = xt3 + (f6 * (xt((i7 & 255) / 255.0f) - xt3));
        return (Math.round(j(xt + ((xt4 - xt) * f6)) * 255.0f) << 16) | (Math.round(f8 * 255.0f) << 24) | (Math.round(j(xt5) * 255.0f) << 8) | Math.round(j(xt6) * 255.0f);
    }

    private static float xt(float f6) {
        if (f6 <= 0.04045f) {
            return f6 / 12.92f;
        }
        return (float) Math.pow((f6 + 0.055f) / 1.055f, 2.4000000953674316d);
    }
}
