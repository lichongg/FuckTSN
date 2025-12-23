package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class l1 {
    private static void a(String str, String str2) {
        e.a().b(new f0(str, str2));
    }

    public static void c(String str, String str2) {
        p0 p0Var;
        String str3;
        String replace = "{url}/getPublicKey?keytype=4".replace("{url}", c.g(str, str2));
        String k6 = y0.k();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", k6);
        try {
            p0Var = k1.a(replace, new byte[0], hashMap);
        } catch (Exception e6) {
            j1.l("GetPublicKey", "get pubKey response Exception :" + e6.getMessage());
            p0Var = null;
        }
        if (p0Var == null) {
            str3 = "get pubKey response is null";
        } else if (p0Var.b() == 200) {
            if (TextUtils.isEmpty(p0Var.a())) {
                return;
            }
            e(p0Var.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + p0Var.b();
        }
        j1.l("GetPublicKey", str3);
    }

    private static void e(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString("timeInterval");
            l.g(y0.q(), "Privacy_MY", "public_key_oper", a2.h.g("HiAnalytics_Sdk_Public_Sp_Key", optString));
            l.g(y0.q(), "Privacy_MY", "public_key_maint", a2.h.g("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            l.g(y0.q(), "Privacy_MY", "public_key_time_interval", optString4);
            l.g(y0.q(), "Privacy_MY", "public_key_version", optString3);
            l.g(y0.q(), "Privacy_MY", "public_key_time_last", str3);
            y0.j(optString);
            y0.h(optString2);
            y0.n(optString3);
            y0.f(str3);
            y0.l(optString4);
        } catch (JSONException e6) {
            j1.l("GetPublicKey", "get pubKey parse json JSONException :" + e6.getMessage());
        }
    }

    public static boolean b() {
        String a6 = y0.a();
        if (TextUtils.isEmpty(a6)) {
            a6 = l.b(y0.q(), "Privacy_MY", "public_key_time_interval", "");
            y0.l(a6);
        }
        String u5 = y0.u();
        if (TextUtils.isEmpty(u5)) {
            u5 = l.b(y0.q(), "Privacy_MY", "public_key_time_last", "");
            y0.f(u5);
        }
        if (!TextUtils.isEmpty(a6) && !TextUtils.isEmpty(u5)) {
            try {
                if (System.currentTimeMillis() - Long.parseLong(u5) > Integer.parseInt(a6)) {
                    return true;
                }
                return false;
            } catch (NumberFormatException e6) {
                j1.l("GetPublicKey", "checkCachePubKey NumberFormatException :" + e6.getMessage());
            }
        }
        return true;
    }

    public static String d(String str, String str2) {
        String w5;
        String e6 = y0.e();
        if (TextUtils.isEmpty(e6)) {
            e6 = l.b(y0.q(), "Privacy_MY", "public_key_version", "");
            y0.n(e6);
        }
        if (!"2.0".equals(e6)) {
            a(str, str2);
            return null;
        }
        if ("maint".equals(str2)) {
            w5 = y0.v();
            if (TextUtils.isEmpty(w5)) {
                w5 = a2.h.d("HiAnalytics_Sdk_Public_Sp_Key", l.b(y0.q(), "Privacy_MY", "public_key_maint", ""));
                y0.h(w5);
            }
        } else {
            w5 = y0.w();
            if (TextUtils.isEmpty(w5)) {
                w5 = a2.h.d("HiAnalytics_Sdk_Public_Sp_Key", l.b(y0.q(), "Privacy_MY", "public_key_oper", ""));
                y0.j(w5);
            }
        }
        if (!TextUtils.isEmpty(w5) && !b()) {
            return w5;
        }
        a(str, str2);
        return null;
    }
}
