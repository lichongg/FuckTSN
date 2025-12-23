package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends com.bytedance.adsdk.ugeno.widget.frame.j {
    private String ll;
    private final float[] oy;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.ll = str2;
        } else {
            super.j(str, str2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.frame.j, com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        qv(this.ll);
        super.xt();
    }

    public float[] ya() {
        return this.oy;
    }

    public qv(Context context) {
        super(context);
        this.oy = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    private void qv(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (trim.length() > 2 && (split = trim.substring(1, trim.length() - 1).split(",")) != null && split.length == 4) {
                for (int i6 = 0; i6 < split.length; i6++) {
                    String str2 = split[i6];
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            this.oy[i6] = Float.parseFloat(com.bytedance.sdk.openadsdk.upie.j.j.j(str2.trim(), this.f23872r));
                        } catch (NumberFormatException e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                }
            }
        }
    }
}
