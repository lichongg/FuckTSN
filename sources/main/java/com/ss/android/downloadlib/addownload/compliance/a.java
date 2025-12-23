package com.ss.android.downloadlib.addownload.compliance;

import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.addownload.o;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
class a {
    public static void f(String str, long j6) {
        e(str, null, j6);
    }

    public static void a(int i6, long j6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i6));
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().x("lp_compliance_error", jSONObject, o.f.c().r(j6));
    }

    public static void b(int i6, o.i iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i6));
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().x("lp_compliance_error", jSONObject, iVar);
    }

    public static void c(String str, long j6) {
        o.i r5 = o.f.c().r(j6);
        if (!r5.b()) {
            r5.f37962c.j(str);
            com.ss.android.downloadlib.r.b.a().w("lp_app_dialog_click", r5);
        }
    }

    public static void d(String str, o.i iVar) {
        com.ss.android.downloadlib.r.b.a().w(str, iVar);
    }

    public static void e(String str, JSONObject jSONObject, long j6) {
        com.ss.android.downloadlib.r.b.a().x(str, jSONObject, o.f.c().r(j6));
    }
}
