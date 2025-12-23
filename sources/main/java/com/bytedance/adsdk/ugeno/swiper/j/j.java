package com.bytedance.adsdk.ugeno.swiper.j;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements ViewPager.up {
    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.up
    public void j(View view, float f6) {
        view.setPivotX(f6 < 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f6 * 90.0f);
    }
}
