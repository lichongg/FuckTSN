package com.scwang.smartrefresh.header.internal;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
abstract class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f37178a;

    /* renamed from: b, reason: collision with root package name */
    private final float f37179b;

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f37178a;
        int min = Math.min((int) ((fArr.length - 1) * f6), fArr.length - 2);
        float f7 = this.f37179b;
        float f8 = (f6 - (min * f7)) / f7;
        float[] fArr2 = this.f37178a;
        float f9 = fArr2[min];
        return f9 + (f8 * (fArr2[min + 1] - f9));
    }

    public b(float[] fArr) {
        this.f37178a = fArr;
        this.f37179b = 1.0f / (fArr.length - 1);
    }
}
