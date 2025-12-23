package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.oq;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView xt;

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.xt == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.xt.setText(str);
            return;
        }
        try {
            this.xt.setText(kt.xt(this.xt.getContext(), "tt_splash_default_click_shake"));
        } catch (Exception e6) {
            vl.r("shakeClickView", e6.getMessage());
        }
    }

    public ShakeClickView(Context context, View view, oq oqVar, boolean z5, int i6) {
        super(context, view, oqVar, z5, i6);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    protected void j(Context context, View view) {
        addView(view);
        this.xt = (TextView) findViewById(2097610747);
    }
}
