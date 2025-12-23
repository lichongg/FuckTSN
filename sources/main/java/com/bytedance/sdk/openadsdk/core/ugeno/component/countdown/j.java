package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.adsdk.ugeno.widget.text.xt {
    protected String oy;
    private String qe;
    private String yl;

    public void j(int i6, int i7, int i8) {
        if (i6 <= 0 && !TextUtils.isEmpty(this.oy)) {
            String str = this.oy;
            ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = str;
            vl(str);
            return;
        }
        if (TextUtils.isEmpty(this.qe) || TextUtils.equals(this.qe, "null")) {
            this.qe = "";
        }
        if (TextUtils.isEmpty(this.yl) || TextUtils.equals(this.yl, "null")) {
            this.yl = "";
        }
        String str2 = this.yl + i6 + this.qe;
        ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = str2;
        vl(str2);
    }

    protected void vl(String str) {
        ((UGTextView) this.up).setText(str);
        try {
            float measureText = ((UGTextView) this.up).getPaint().measureText(str);
            if (measureText >= 0.0f) {
                r((int) measureText);
            }
        } catch (Throwable unused) {
        }
    }

    public j(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        if (TextUtils.isEmpty(this.qe) || TextUtils.equals(this.qe, "null")) {
            this.qe = "";
        }
        if (TextUtils.isEmpty(this.yl) || TextUtils.equals(this.yl, "null")) {
            this.yl = "";
        }
        String str = this.yl + this.qe;
        ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = str;
        vl(str);
        ((UGTextView) this.up).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "before":
                this.yl = str2;
                break;
            case "finish":
                this.oy = str2;
                break;
            case "after":
                this.qe = str2;
                break;
        }
    }
}
