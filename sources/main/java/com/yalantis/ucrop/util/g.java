package com.yalantis.ucrop.util;

import android.graphics.RectF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g {
    public static float[] c(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow(fArr[0] - fArr[2], 2.0d) + Math.pow(fArr[1] - fArr[3], 2.0d)), (float) Math.sqrt(Math.pow(fArr[2] - fArr[4], 2.0d) + Math.pow(fArr[3] - fArr[5], 2.0d))};
    }

    public static float[] b(RectF rectF) {
        float f6 = rectF.left;
        float f7 = rectF.top;
        float f8 = rectF.right;
        float f9 = rectF.bottom;
        return new float[]{f6, f7, f8, f7, f8, f9, f6, f9};
    }

    public static RectF d(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i6 = 1; i6 < fArr.length; i6 += 2) {
            float round = Math.round(fArr[i6 - 1] * 10.0f) / 10.0f;
            float round2 = Math.round(fArr[i6] * 10.0f) / 10.0f;
            float f6 = rectF.left;
            if (round < f6) {
                f6 = round;
            }
            rectF.left = f6;
            float f7 = rectF.top;
            if (round2 < f7) {
                f7 = round2;
            }
            rectF.top = f7;
            float f8 = rectF.right;
            if (round <= f8) {
                round = f8;
            }
            rectF.right = round;
            float f9 = rectF.bottom;
            if (round2 <= f9) {
                round2 = f9;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }

    public static float[] a(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }
}
