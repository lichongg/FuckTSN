package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    private int px;
    private String qe;
    private String yl;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.j
    public void j(int i6, int i7, int i8) {
        if (i8 <= 0 && !TextUtils.isEmpty(((j) this).oy)) {
            String str = ((j) this).oy;
            ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = str;
            vl(str);
            return;
        }
        int i9 = this.px;
        int i10 = i9 - i7;
        if (i9 <= 0) {
            ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = this.qe;
        } else if (i10 > 0) {
            ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = this.yl;
        } else {
            ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = this.qe;
        }
        String replace = ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j.replace("${_countdownTime_}", String.valueOf(i10)).replace("${_remainTime_}", String.valueOf(i8));
        ((com.bytedance.adsdk.ugeno.widget.text.xt) this).f23853j = replace;
        vl(replace);
    }

    public cw(Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.j, com.bytedance.adsdk.ugeno.widget.text.xt, com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        char c6;
        super.j(str, str2);
        str.getClass();
        switch (str.hashCode()) {
            case 110256292:
                if (str.equals("text1")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case 110256293:
                if (str.equals("text2")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case 996930575:
                if (str.equals("startCountDown")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        switch (c6) {
            case 0:
                this.yl = str2;
                break;
            case 1:
                this.qe = str2;
                break;
            case 2:
                this.px = com.bytedance.adsdk.ugeno.m.cw.j(str2, -1);
                break;
        }
    }
}
