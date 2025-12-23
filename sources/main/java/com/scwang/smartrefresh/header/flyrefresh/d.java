package com.scwang.smartrefresh.header.flyrefresh;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(9)
@TargetApi(9)
/* loaded from: D:\Downloads\app\classes6.dex */
class d implements Interpolator {

    /* renamed from: c, reason: collision with root package name */
    private static final float f37092c = 0.002f;

    /* renamed from: a, reason: collision with root package name */
    private final float[] f37093a;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f37094b;

    public d(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i6 = (int) (length / 0.002f);
        int i7 = i6 + 1;
        this.f37093a = new float[i7];
        this.f37094b = new float[i7];
        float[] fArr = new float[2];
        for (int i8 = 0; i8 < i7; i8++) {
            pathMeasure.getPosTan((i8 * length) / i6, fArr, null);
            this.f37093a[i8] = fArr[0];
            this.f37094b[i8] = fArr[1];
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
        int length = this.f37093a.length - 1;
        int i6 = 0;
        while (length - i6 > 1) {
            int i7 = (i6 + length) / 2;
            if (f6 < this.f37093a[i7]) {
                length = i7;
            } else {
                i6 = i7;
            }
        }
        float[] fArr = this.f37093a;
        float f7 = fArr[length];
        float f8 = fArr[i6];
        float f9 = f7 - f8;
        if (f9 == 0.0f) {
            return this.f37094b[i6];
        }
        float f10 = (f6 - f8) / f9;
        float[] fArr2 = this.f37094b;
        float f11 = fArr2[i6];
        return f11 + (f10 * (fArr2[length] - f11));
    }

    private static Path a(float f6, float f7, float f8, float f9) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f6, f7, f8, f9, 1.0f, 1.0f);
        return path;
    }

    private static Path b(float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f6, f7, 1.0f, 1.0f);
        return path;
    }

    public d(float f6, float f7) {
        this(b(f6, f7));
    }

    public d(float f6, float f7, float f8, float f9) {
        this(a(f6, f7, f8, f9));
    }
}
