package com.bytedance.adsdk.lottie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: D:\Downloads\app\classes3.dex */
class av implements Interpolator {

    /* renamed from: j, reason: collision with root package name */
    private final float[] f23216j;
    private final float[] xt;

    av(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i6 = (int) (length / 0.002f);
        int i7 = i6 + 1;
        this.f23216j = new float[i7];
        this.xt = new float[i7];
        float[] fArr = new float[2];
        for (int i8 = 0; i8 < i7; i8++) {
            pathMeasure.getPosTan((i8 * length) / i6, fArr, null);
            this.f23216j[i8] = fArr[0];
            this.xt[i8] = fArr[1];
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f23216j.length - 1;
        int i6 = 0;
        while (length - i6 > 1) {
            int i7 = (i6 + length) / 2;
            if (f6 < this.f23216j[i7]) {
                length = i7;
            } else {
                i6 = i7;
            }
        }
        float[] fArr = this.f23216j;
        float f7 = fArr[length];
        float f8 = fArr[i6];
        float f9 = f7 - f8;
        if (f9 == 0.0f) {
            return this.xt[i6];
        }
        float f10 = (f6 - f8) / f9;
        float[] fArr2 = this.xt;
        float f11 = fArr2[i6];
        return f11 + (f10 * (fArr2[length] - f11));
    }

    private static Path j(float f6, float f7, float f8, float f9) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f6, f7, f8, f9, 1.0f, 1.0f);
        return path;
    }

    av(float f6, float f7, float f8, float f9) {
        this(j(f6, f7, f8, f9));
    }
}
