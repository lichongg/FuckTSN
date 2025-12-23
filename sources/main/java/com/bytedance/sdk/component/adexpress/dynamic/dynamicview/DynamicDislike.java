package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            this.az = new ImageView(context);
        } else {
            this.az = new DislikeView(context);
        }
        this.az.setTag(3);
        addView(this.az, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.az);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            Drawable j6 = com.bytedance.sdk.component.adexpress.r.r.j(getContext(), this.vl);
            if (j6 != null) {
                this.az.setBackground(j6);
            }
            int up = kt.up(getContext(), "tt_close_btn");
            if (up > 0) {
                ((ImageView) this.az).setImageResource(up);
            }
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int j7 = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.i());
        View view = this.az;
        if (view instanceof DislikeView) {
            ((DislikeView) view).setRadius((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.az()));
            ((DislikeView) this.az).setStrokeWidth(j7);
            ((DislikeView) this.az).setStrokeColor(this.vl.av());
            ((DislikeView) this.az).setBgColor(this.vl.l());
            ((DislikeView) this.az).setDislikeColor(this.vl.ae());
            ((DislikeView) this.az).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, 1.0f));
        }
        return true;
    }
}
