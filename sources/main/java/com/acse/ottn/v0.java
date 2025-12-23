package com.acse.ottn;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class v0 extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final float f5378c = 0.75f;

    /* renamed from: b, reason: collision with root package name */
    public float f5379b;

    public v0() {
        this.f5379b = 0.75f;
    }

    public v0(float f6) {
        this.f5379b = f6;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f6) {
        int width = view.getWidth();
        if (f6 < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f6 <= 0.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            return;
        }
        if (f6 <= 1.0f) {
            view.setVisibility(0);
            view.setAlpha(1.0f - f6);
            view.setTranslationX(width * (-f6));
            float f7 = this.f5379b;
            float abs = f7 + ((1.0f - f7) * (1.0f - Math.abs(f6)));
            view.setScaleX(abs);
            view.setScaleY(abs);
            if (f6 == 1.0f) {
                view.setVisibility(4);
                return;
            }
            return;
        }
        view.setAlpha(0.0f);
    }
}
