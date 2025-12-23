package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private String f33591a;

    /* renamed from: b, reason: collision with root package name */
    private String f33592b;

    /* renamed from: c, reason: collision with root package name */
    private String f33593c;

    /* renamed from: d, reason: collision with root package name */
    private List<f> f33594d;

    /* renamed from: e, reason: collision with root package name */
    private String f33595e;

    private byte[] c(x xVar) {
        String str;
        try {
            JSONObject a6 = xVar.a();
            if (a6 != null) {
                return i0.g(a6.toString().getBytes("UTF-8"));
            }
            j1.l("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            j1.l("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            j1.l("hmsSdk", str);
            return new byte[0];
        }
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = this.f33594d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().h());
            } catch (JSONException unused) {
                j1.h("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    private x f() {
        return g0.f(this.f33594d, this.f33591a, this.f33592b, this.f33595e, this.f33593c);
    }

    public void b() {
        String a6 = a(this.f33591a, this.f33592b);
        if (TextUtils.isEmpty(a6) && !"preins".equals(this.f33592b)) {
            j1.l("hmsSdk", "collectUrl is empty");
            return;
        }
        if (!"_hms_config_tag".equals(this.f33591a) && !"_openness_config_tag".equals(this.f33591a)) {
            d();
        }
        x f6 = f();
        if (f6 == null) {
            e.d().b(new k(this.f33594d, this.f33591a, this.f33595e, this.f33592b));
            return;
        }
        byte[] c6 = c(f6);
        if (c6.length == 0) {
            j1.l("hmsSdk", "request body is empty");
        } else {
            e.c().b(new s(c6, a6, this.f33591a, this.f33592b, this.f33595e, this.f33594d));
        }
    }

    public j0(String str, String str2, String str3, List<f> list, String str4) {
        this.f33591a = str;
        this.f33592b = str2;
        this.f33593c = str3;
        this.f33594d = list;
        this.f33595e = str4;
    }

    private String a(String str, String str2) {
        String str3;
        String g6 = c.g(str, str2);
        if (TextUtils.isEmpty(g6)) {
            j1.c("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else {
            if (!"diffprivacy".equals(str2)) {
                return "";
            }
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", g6);
    }

    private void d() {
        if (h.c(y0.q(), "backup_event", 5242880)) {
            j1.j("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray e6 = e();
        String e7 = q0.e(this.f33591a, this.f33592b, this.f33595e);
        j1.h("hmsSdk", "Update data cached into backup,spKey: " + e7);
        l.g(y0.q(), "backup_event", e7, e6.toString());
    }
}
