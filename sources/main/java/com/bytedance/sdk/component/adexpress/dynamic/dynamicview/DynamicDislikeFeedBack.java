package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            ImageView imageView = new ImageView(context);
            this.az = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ae = this.tl;
        } else {
            this.az = new TextView(context);
        }
        this.az.setTag(3);
        addView(this.az, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.az);
        if (dynamicRootView.getRenderRequest() != null) {
            if (!dynamicRootView.getRenderRequest().qv() || !dynamicRootView.getRenderRequest().l()) {
                this.az.setVisibility(8);
                setVisibility(8);
            }
        }
    }

    public String getText() {
        return kt.j(com.bytedance.sdk.component.adexpress.r.getContext(), "tt_reward_feedback");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            Drawable j6 = com.bytedance.sdk.component.adexpress.r.r.j(getContext(), this.vl);
            if (j6 != null) {
                ((ImageView) this.az).setBackground(j6);
            }
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int up = kt.up(getContext(), "tt_reward_full_feedback");
            if (up > 0) {
                ((ImageView) this.az).setImageResource(up);
            }
            return true;
        }
        ((TextView) this.az).setText(getText());
        this.az.setTextAlignment(this.vl.tl());
        ((TextView) this.az).setTextColor(this.vl.ae());
        ((TextView) this.az).setTextSize(this.vl.up());
        this.az.setBackground(getBackgroundDrawable());
        if (!this.vl.f()) {
            ((TextView) this.az).setMaxLines(1);
            ((TextView) this.az).setGravity(17);
            ((TextView) this.az).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int v5 = this.vl.v();
            if (v5 > 0) {
                ((TextView) this.az).setLines(v5);
                ((TextView) this.az).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.az.setPadding((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.cw()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.xt()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.r()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.j()));
        ((TextView) this.az).setGravity(17);
        return true;
    }
}
