package com.bytedance.sdk.openadsdk.upie.j;

import android.text.TextUtils;
import com.bytedance.adsdk.xt.qv;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static String j(String str, JSONObject jSONObject) {
        com.bytedance.adsdk.xt.xt.j j6;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (str.startsWith("${") && str.endsWith("}") && (j6 = com.bytedance.adsdk.xt.xt.j.j(str.substring(2, str.length() - 1))) != null) {
                    Object j7 = j6.j(jSONObject);
                    if (j7 instanceof String) {
                        return (String) j7;
                    }
                    if (j7 instanceof com.bytedance.adsdk.xt.xt.j.j) {
                        return String.valueOf(qv.j((com.bytedance.adsdk.xt.xt.j.j) j7));
                    }
                    return String.valueOf(j7);
                }
                return str;
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return str;
    }
}
