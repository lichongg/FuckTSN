package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class f implements u0 {

    /* renamed from: a, reason: collision with root package name */
    private String f33563a;

    /* renamed from: b, reason: collision with root package name */
    private String f33564b;

    /* renamed from: c, reason: collision with root package name */
    private String f33565c;

    /* renamed from: d, reason: collision with root package name */
    private String f33566d;

    /* renamed from: e, reason: collision with root package name */
    private String f33567e;

    /* renamed from: f, reason: collision with root package name */
    private String f33568f;

    @Override // com.huawei.hms.hatool.u0
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f33563a);
        jSONObject.put("eventtime", this.f33566d);
        jSONObject.put("event", this.f33564b);
        jSONObject.put("event_session_name", this.f33567e);
        jSONObject.put("first_session_event", this.f33568f);
        if (TextUtils.isEmpty(this.f33565c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f33565c));
        return jSONObject;
    }

    public void b(String str) {
        this.f33565c = str;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f33564b = jSONObject.optString("event");
        this.f33565c = r0.b(jSONObject.optString("properties"), t0.g().a());
        this.f33563a = jSONObject.optString("type");
        this.f33566d = jSONObject.optString("eventtime");
        this.f33567e = jSONObject.optString("event_session_name");
        this.f33568f = jSONObject.optString("first_session_event");
    }

    public String d() {
        return this.f33566d;
    }

    public void e(String str) {
        this.f33564b = str;
    }

    public String f() {
        return this.f33563a;
    }

    public void g(String str) {
        this.f33566d = str;
    }

    public void i(String str) {
        this.f33563a = str;
    }

    public void j(String str) {
        this.f33568f = str;
    }

    public void k(String str) {
        this.f33567e = str;
    }

    public JSONObject h() {
        JSONObject a6 = a();
        a6.put("properties", r0.d(this.f33565c, t0.g().a()));
        return a6;
    }
}
