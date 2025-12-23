package com.bytedance.adsdk.ugeno.swiper.j;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements ViewPager.up {

    /* renamed from: j, reason: collision with root package name */
    private String f23737j;

    public void j(String str) {
        this.f23737j = str;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.up
    public void j(View view, float f6) {
        if (f6 < -1.0f || f6 > 1.0f) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f6));
            view.setTranslationY(view.getHeight() * f6);
        }
        if (TextUtils.equals(this.f23737j, "cube")) {
            float height = f6 < 0.0f ? view.getHeight() : 0.0f;
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(height);
            view.setRotationX(f6 * (-90.0f));
        }
    }
}
