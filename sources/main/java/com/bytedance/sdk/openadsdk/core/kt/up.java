package com.bytedance.sdk.openadsdk.core.kt;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    public static boolean j(String str, double d6) {
        JSONObject kc = v.xt().kc();
        if (kc != null && !TextUtils.isEmpty(str)) {
            try {
                double optDouble = kc.optDouble(str, d6);
                if (optDouble >= 1.0d || optDouble < 0.0d || com.bytedance.sdk.openadsdk.core.jy.xt.f29319j.contains(str)) {
                    return true;
                }
                return com.bytedance.sdk.openadsdk.core.m.xt.j((float) optDouble, false);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.cw("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }
}
