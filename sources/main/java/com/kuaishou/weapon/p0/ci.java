package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ci {

    /* renamed from: a, reason: collision with root package name */
    private Context f35865a;

    /* renamed from: b, reason: collision with root package name */
    private int f35866b;

    public JSONObject a() {
        long currentTimeMillis;
        JSONObject jSONObject;
        JSONArray a6;
        try {
            currentTimeMillis = System.currentTimeMillis();
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        if (!WeaponHI.as) {
            return null;
        }
        h a7 = h.a(this.f35865a, "re_po_rt");
        int b6 = a7.b(df.f36002o, 0);
        boolean e6 = a7.e("a1_p_s_p_s");
        boolean e7 = a7.e("a1_p_s_p_s_c_b");
        if (b6 == 1 && ((e6 || e7) && (a6 = new w(this.f35865a).a(0)) != null)) {
            jSONObject.put("10000", a6);
            try {
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Mo().Mn()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Mo().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Mo().getAppId()));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        }
        return null;
    }

    public ci(Context context, int i6) {
        this.f35865a = context;
        this.f35866b = i6;
    }

    public String a(String str) {
        JSONObject a6;
        try {
            JSONObject a7 = new cm(str, ck.f35879l).a(this.f35865a);
            if (a7 == null || (a6 = a()) == null) {
                return null;
            }
            a7.put("module_section", a6);
            return a7.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
