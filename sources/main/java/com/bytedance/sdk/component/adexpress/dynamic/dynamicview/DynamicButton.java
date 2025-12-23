package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        AnimationButton animationButton = new AnimationButton(context);
        this.az = animationButton;
        animationButton.setTag(Integer.valueOf(getClickArea()));
        addView(this.az, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.r.j() && "fillButton".equals(this.jy.oq().getType())) {
            ((TextView) this.az).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.az).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.vl.w() * 2;
            widgetLayoutParams.height -= this.vl.w() * 2;
            widgetLayoutParams.topMargin += this.vl.w();
            int w5 = widgetLayoutParams.leftMargin + this.vl.w();
            widgetLayoutParams.leftMargin = w5;
            widgetLayoutParams.setMarginStart(w5);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        if (TextUtils.equals("download-progress-button", this.jy.oq().getType()) && TextUtils.isEmpty(this.vl.oq())) {
            this.az.setVisibility(4);
            return true;
        }
        this.az.setTextAlignment(this.vl.tl());
        ((TextView) this.az).setText(this.vl.oq());
        ((TextView) this.az).setTextColor(this.vl.ae());
        ((TextView) this.az).setTextSize(this.vl.up());
        ((TextView) this.az).setGravity(17);
        ((TextView) this.az).setIncludeFontPadding(false);
        if ("fillButton".equals(this.jy.oq().getType())) {
            this.az.setPadding(0, 0, 0, 0);
        } else {
            this.az.setPadding(this.vl.cw(), this.vl.xt(), this.vl.r(), this.vl.j());
        }
        return true;
    }
}
