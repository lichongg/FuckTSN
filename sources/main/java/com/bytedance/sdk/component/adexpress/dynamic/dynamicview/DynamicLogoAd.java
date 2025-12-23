package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.dynamic.r.qv;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        TextView textView = new TextView(context);
        this.az = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.az, getWidgetLayoutParams());
    }

    private boolean g() {
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            return false;
        }
        if ((TextUtils.isEmpty(this.vl.xt) || !this.vl.xt.contains("adx:")) && !qv.xt()) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        this.az.setTextAlignment(this.vl.tl());
        ((TextView) this.az).setTextColor(this.vl.ae());
        ((TextView) this.az).setTextSize(this.vl.up());
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            ((TextView) this.az).setIncludeFontPadding(false);
            ((TextView) this.az).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.r.tl.xt(com.bytedance.sdk.component.adexpress.r.getContext(), this.tl) - this.vl.xt()) - this.vl.j()) - 0.5f, this.vl.up()));
            ((TextView) this.az).setText(kt.j(getContext(), "tt_logo_en"));
            return true;
        }
        if (g()) {
            if (qv.xt()) {
                ((TextView) this.az).setText(qv.j());
                return true;
            }
            ((TextView) this.az).setText(qv.j(this.vl.xt));
            return true;
        }
        ((TextView) this.az).setText(kt.xt(getContext(), "tt_logo_cn"));
        return true;
    }
}
