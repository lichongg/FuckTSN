package com.acse.ottn;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class z4 extends c0 {

    /* renamed from: d, reason: collision with root package name */
    public static final float f5569d = 0.85f;

    /* renamed from: e, reason: collision with root package name */
    public static final float f5570e = 0.5f;

    /* renamed from: b, reason: collision with root package name */
    public float f5571b;

    /* renamed from: c, reason: collision with root package name */
    public float f5572c;

    public z4() {
        this.f5571b = 0.85f;
        this.f5572c = 0.5f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f6) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f6 < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f6 <= 1.0f) {
            float max = Math.max(this.f5571b, 1.0f - Math.abs(f6));
            float f7 = 1.0f - max;
            float f8 = (height * f7) / 2.0f;
            float f9 = (width * f7) / 2.0f;
            if (f6 < 0.0f) {
                view.setTranslationX(f9 - (f8 / 2.0f));
            } else {
                view.setTranslationX((-f9) + (f8 / 2.0f));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            float f10 = this.f5572c;
            float f11 = this.f5571b;
            view.setAlpha(f10 + (((max - f11) / (1.0f - f11)) * (1.0f - f10)));
            return;
        }
        view.setAlpha(0.0f);
    }

    public z4(float f6, float f7) {
        this.f5571b = f6;
        this.f5572c = f7;
    }
}
