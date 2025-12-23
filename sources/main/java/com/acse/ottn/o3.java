package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o3 extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final float f4975c = 15.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f4976b;

    public o3() {
        this.f4976b = 15.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        if (f6 < -1.0f) {
            view.setRotation(this.f4976b * (-1.0f));
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else {
            if (f6 > 1.0f) {
                view.setRotation(this.f4976b);
                view.getWidth();
                view.setPivotX(0);
                view.setPivotY(view.getHeight());
                return;
            }
            if (f6 < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f6) * 0.5f) + 0.5f));
                view.setPivotY(view.getHeight());
                view.setRotation(this.f4976b * f6);
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f6));
                view.setPivotY(view.getHeight());
                view.setRotation(this.f4976b * f6);
            }
        }
    }

    public o3(float f6) {
        this.f4976b = f6;
    }
}
