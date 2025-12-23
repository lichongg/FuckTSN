package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.cw {

    /* renamed from: j, reason: collision with root package name */
    private boolean f25702j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.cw
    public void j(CharSequence charSequence, boolean z5, int i6, boolean z6) {
        int i7 = 0;
        if (!z5 && !z6) {
            i7 = 8;
        }
        setVisibility(i7);
    }

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.f25702j = dynamicRootView.getRenderRequest().av();
        }
        this.ae = this.tl;
        ImageView imageView = new ImageView(context);
        this.az = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.az, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().l()) {
            this.az.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        Drawable cw;
        super.tl();
        ((ImageView) this.az).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable j6 = com.bytedance.sdk.component.adexpress.r.r.j(getContext(), this.vl);
        if (j6 != null) {
            ((ImageView) this.az).setBackground(j6);
        }
        if (this.f25702j) {
            cw = kt.cw(getContext(), "tt_close_btn");
        } else {
            cw = kt.cw(getContext(), "tt_skip_btn");
            if (cw != null) {
                cw.setAutoMirrored(true);
            }
        }
        if (cw != null) {
            ((ImageView) this.az).setImageDrawable(cw);
        }
        setVisibility(8);
        return true;
    }
}
