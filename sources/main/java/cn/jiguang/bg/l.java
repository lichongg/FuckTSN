package cn.jiguang.bg;

import android.text.TextUtils;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    LinkedHashSet<g> f2106a;

    /* renamed from: b, reason: collision with root package name */
    LinkedHashSet<g> f2107b;

    /* renamed from: c, reason: collision with root package name */
    LinkedHashSet<g> f2108c;

    /* renamed from: d, reason: collision with root package name */
    LinkedHashSet<g> f2109d;

    /* renamed from: e, reason: collision with root package name */
    LinkedHashSet<g> f2110e;

    /* renamed from: f, reason: collision with root package name */
    JSONObject f2111f;

    /* renamed from: g, reason: collision with root package name */
    transient g f2112g;

    /* renamed from: h, reason: collision with root package name */
    boolean f2113h;

    /* renamed from: i, reason: collision with root package name */
    int f2114i;

    private LinkedHashSet<g> a(JSONObject jSONObject, String str) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    g a6 = g.a(optJSONArray.optString(i6, null));
                    if (a6 != null && a6.a()) {
                        linkedHashSet.add(a6);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashSet;
    }

    public boolean a() {
        LinkedHashSet<g> linkedHashSet = this.f2106a;
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            return false;
        }
        LinkedHashSet<g> linkedHashSet2 = this.f2107b;
        return linkedHashSet2 == null || linkedHashSet2.isEmpty();
    }

    l(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.f2106a = a(jSONObject, "ips");
                this.f2107b = a(jSONObject, "ssl_ips");
                this.f2108c = a(jSONObject, "http_report");
                this.f2109d = a(jSONObject, "https_report");
                this.f2110e = a(jSONObject, "sis_ips");
                this.f2113h = jSONObject.optBoolean("data_report");
                this.f2111f = jSONObject.optJSONObject("tcp_report");
                this.f2114i = jSONObject.optInt("cert_ver", 0);
                cn.jiguang.bb.f.c("sis", "get sis=" + jSONObject.toString(2));
            }
        } catch (Throwable unused) {
        }
    }
}
