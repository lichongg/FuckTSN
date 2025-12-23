package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SwiperView extends BaseSwiper<ViewGroup> {
    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View ae(int i6) {
        return (ViewGroup) this.f23721j.get(i6);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View j(int i6, int i7) {
        if (this.f23721j.isEmpty()) {
            return new View(getContext());
        }
        View ae = ae(i7);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (ae instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (ae.getParent() instanceof ViewGroup) {
            ((ViewGroup) ae.getParent()).removeView(ae);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(ae, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.r
    public void g(int i6) {
        super.g(i6);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.r
    public void tl(int i6) {
        super.tl(i6);
    }
}
