package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ch {

    /* renamed from: a, reason: collision with root package name */
    private Context f35863a;

    /* renamed from: b, reason: collision with root package name */
    private int f35864b;

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f35863a, "re_po_rt").b(df.f36012y, 1) != 1) {
                return null;
            }
            try {
                JSONArray a6 = new x().a(this.f35863a);
                if (a6 != null && a6.length() > 0) {
                    jSONObject.put("10000", a6);
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Mo().Mn()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Mo().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Mo().getAppId()));
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public ch(Context context, int i6) {
        this.f35863a = context;
        this.f35864b = i6;
    }

    public String a(String str) {
        JSONObject a6;
        try {
            JSONObject a7 = new cm(str, ck.f35879l).a(this.f35863a);
            if (a7 != null && (a6 = a()) != null && a6.length() != 0) {
                a7.put("module_section", a6);
                return a7.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
