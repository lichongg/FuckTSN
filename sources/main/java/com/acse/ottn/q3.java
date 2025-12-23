package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q3 extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final float f5026c = 35.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f5027b;

    public q3() {
        this.f5027b = 35.0f;
    }

    public q3(float f6) {
        this.f5027b = f6;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        view.setPivotY(view.getHeight() / 2);
        if (f6 < -1.0f) {
            view.setRotationY(this.f5027b * (-1.0f));
            view.setPivotX(view.getWidth());
            return;
        }
        if (f6 <= 1.0f) {
            view.setRotationY(this.f5027b * f6);
            if (f6 < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f6) * 0.5f) + 0.5f));
                view.setPivotX(view.getWidth());
                return;
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f6));
                view.setPivotX(0.0f);
                return;
            }
        }
        view.setRotationY(this.f5027b * 1.0f);
        view.setPivotX(0.0f);
    }
}
