package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class w3 extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final float f5435c = 0.85f;

    /* renamed from: b, reason: collision with root package name */
    public float f5436b;

    public w3() {
        this.f5436b = 0.85f;
    }

    public w3(float f6) {
        this.f5436b = f6;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f6 < -1.0f) {
            view.setScaleX(this.f5436b);
            view.setScaleY(this.f5436b);
            view.setPivotX(width);
            return;
        }
        if (f6 <= 1.0f) {
            if (f6 < 0.0f) {
                float f7 = this.f5436b;
                float f8 = ((f6 + 1.0f) * (1.0f - f7)) + f7;
                view.setScaleX(f8);
                view.setScaleY(f8);
                view.setPivotX(width * (((-f6) * 0.5f) + 0.5f));
                return;
            }
            float f9 = 1.0f - f6;
            float f10 = this.f5436b;
            float f11 = ((1.0f - f10) * f9) + f10;
            view.setScaleX(f11);
            view.setScaleY(f11);
            view.setPivotX(width * f9 * 0.5f);
            return;
        }
        view.setPivotX(0.0f);
        view.setScaleX(this.f5436b);
        view.setScaleY(this.f5436b);
    }
}
