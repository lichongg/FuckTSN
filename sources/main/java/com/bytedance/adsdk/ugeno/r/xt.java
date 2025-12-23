package com.bytedance.adsdk.ugeno.r;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.r;
import com.bytedance.adsdk.ugeno.r.j;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static String j(String str, JSONObject jSONObject) {
        j cw;
        j.InterfaceC0323j j6;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (str.startsWith("${") && str.endsWith("}") && (cw = r.j().cw()) != null && (j6 = cw.j(str.substring(2, str.length() - 1))) != null) {
                    return (String) j6.j(jSONObject);
                }
                return str;
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return str;
    }
}
