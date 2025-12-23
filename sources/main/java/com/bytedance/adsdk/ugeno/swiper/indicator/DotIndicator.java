package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\Downloads\app\classes3.dex */
public class DotIndicator extends BaseIndicator {
    @Override // com.bytedance.adsdk.ugeno.swiper.indicator.BaseIndicator
    public Drawable xt(int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i6);
        return gradientDrawable;
    }

    public DotIndicator(Context context) {
        super(context);
    }
}
