package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class b implements v {

    /* renamed from: a, reason: collision with root package name */
    private Context f33498a = y0.q();

    /* renamed from: b, reason: collision with root package name */
    private String f33499b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f33500c;

    /* renamed from: d, reason: collision with root package name */
    private String f33501d;

    /* renamed from: e, reason: collision with root package name */
    private String f33502e;

    /* renamed from: f, reason: collision with root package name */
    private String f33503f;

    /* renamed from: g, reason: collision with root package name */
    private String f33504g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f33505h;

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        j1.h("hmsSdk", "Begin to run EventRecordTask...");
        int o5 = y0.o();
        int l6 = c.l(this.f33501d, this.f33502e);
        if (h.c(this.f33498a, "stat_v2_1", o5 * 1048576)) {
            j1.h("hmsSdk", "stat sp file reach max limited size, discard new event");
            o.a().f("", "alltype");
            return;
        }
        f fVar = new f();
        fVar.e(this.f33499b);
        fVar.b(this.f33500c.toString());
        fVar.i(this.f33502e);
        fVar.g(this.f33503f);
        fVar.k(this.f33504g);
        Boolean bool = this.f33505h;
        fVar.j(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject h6 = fVar.h();
            String d6 = q0.d(this.f33501d, this.f33502e);
            String b6 = l.b(this.f33498a, "stat_v2_1", d6, "");
            try {
                jSONArray = !TextUtils.isEmpty(b6) ? new JSONArray(b6) : new JSONArray();
            } catch (JSONException unused) {
                j1.j("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(h6);
            l.g(this.f33498a, "stat_v2_1", d6, jSONArray.toString());
            if (jSONArray.toString().length() > l6 * 1024) {
                o.a().f(this.f33501d, this.f33502e);
            }
        } catch (JSONException unused2) {
            j1.l("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }

    public b(String str, JSONObject jSONObject, String str2, String str3, long j6) {
        this.f33499b = str;
        this.f33500c = jSONObject;
        this.f33501d = str2;
        this.f33502e = str3;
        this.f33503f = String.valueOf(j6);
        if (r1.i(str2, "oper")) {
            v0 b6 = p1.c().b(str2, j6);
            this.f33504g = b6.a();
            this.f33505h = Boolean.valueOf(b6.f());
        }
    }
}
