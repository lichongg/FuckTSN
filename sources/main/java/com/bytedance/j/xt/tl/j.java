package com.bytedance.j.xt.tl;

import android.text.TextUtils;
import com.bytedance.j.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {
    public static void b(com.bytedance.j.xt.cw.b bVar, com.bytedance.j.xt.cw.c cVar, cw cwVar) {
        if (bVar == null || bVar.k() == null || cwVar == null) {
            return;
        }
        JSONObject k6 = bVar.k();
        long optLong = k6.optLong("crash_time");
        int c6 = c(a(CommonNetImpl.AID));
        String a6 = com.bytedance.j.xt.e.b().a();
        if (optLong <= 0 || c6 <= 0 || TextUtils.isEmpty(a6) || "0".equals(a6) || TextUtils.isEmpty(cwVar.j())) {
            return;
        }
        try {
            String str = "android_" + c6 + "_" + a6 + "_" + optLong + "_" + cwVar;
            if (cVar == null) {
                k6.put("unique_key", str);
                return;
            }
            JSONObject e6 = cVar.e();
            if (e6 != null) {
                e6.put("unique_key", str);
            }
        } catch (JSONException e7) {
            vl.j(e7);
        }
    }

    public static String a(String str) {
        Map<String, Object> b6;
        if (com.bytedance.j.xt.e.d() != null && (b6 = com.bytedance.j.xt.e.d().b()) != null) {
            Object obj = b6.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e6) {
            i.c(e6);
            return 0;
        }
    }
}
