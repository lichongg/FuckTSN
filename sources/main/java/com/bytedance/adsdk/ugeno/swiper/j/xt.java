package com.bytedance.adsdk.ugeno.swiper.j;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements ViewPager.up {

    /* renamed from: j, reason: collision with root package name */
    final float f23738j = 0.8f;
    final float xt = 0.5f;

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.up
    public void j(View view, float f6) {
        float f7 = ((f6 < 0.0f ? 0.19999999f : -0.19999999f) * f6) + 1.0f;
        float f8 = (f6 * (f6 < 0.0f ? 0.5f : -0.5f)) + 1.0f;
        if (f6 < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f7);
        view.setScaleY(f7);
        view.setAlpha(Math.abs(f8));
    }
}
