package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.adsdk.ugeno.widget.text.xt {
    public void r(boolean z5) {
        if (z5) {
            xt(0);
            j(true, true);
        } else {
            r(0);
            up(0);
        }
    }

    public xt(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        if (TextUtils.isEmpty(((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j)) {
            ((UGTextView) this.up).setText("跳过");
        }
    }
}
