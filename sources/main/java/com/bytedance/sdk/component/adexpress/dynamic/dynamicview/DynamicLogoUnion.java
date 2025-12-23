package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        ImageView imageView = new ImageView(context);
        this.az = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            this.tl = Math.max(dynamicRootView.getLogoUnionHeight(), this.tl);
        }
        addView(this.az, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.az).setImageResource(kt.up(getContext(), "tt_ad_logo"));
        ((ImageView) this.az).setColorFilter(this.vl.ae(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
