package com.scwang.smartrefresh.layout.util;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private static final float f37478a = 8.0f;

    /* renamed from: b, reason: collision with root package name */
    private static final float f37479b;

    /* renamed from: c, reason: collision with root package name */
    private static final float f37480c;

    static {
        float a6 = 1.0f / a(1.0f);
        f37479b = a6;
        f37480c = 1.0f - (a6 * a(1.0f));
    }

    private static float a(float f6) {
        float f7 = f6 * f37478a;
        return f7 < 1.0f ? f7 - (1.0f - ((float) Math.exp(-f7))) : ((1.0f - ((float) Math.exp(1.0f - f7))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        float a6 = f37479b * a(f6);
        return a6 > 0.0f ? a6 + f37480c : a6;
    }
}
