package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p3 extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final float f5003c = 15.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f5004b;

    public p3() {
        this.f5004b = 15.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        if (f6 < -1.0f) {
            view.setRotation(this.f5004b);
            view.setPivotX(view.getWidth());
            view.setPivotY(0.0f);
        } else if (f6 > 1.0f) {
            view.setRotation(-this.f5004b);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
        } else if (f6 < 0.0f) {
            view.setPivotX(view.getWidth() * (((-f6) * 0.5f) + 0.5f));
            view.setPivotY(0.0f);
            view.setRotation((-this.f5004b) * f6);
        } else {
            view.setPivotX(view.getWidth() * 0.5f * (1.0f - f6));
            view.setPivotY(0.0f);
            view.setRotation((-this.f5004b) * f6);
        }
    }

    public p3(float f6) {
        this.f5004b = f6;
    }
}
