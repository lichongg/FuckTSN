package com.huawei.hms.hatool;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class l0 extends f1 {

    /* renamed from: b, reason: collision with root package name */
    private String f33605b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f33606c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f33607d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f33608e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f33609f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f33610g;

    @Override // com.huawei.hms.hatool.u0
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f33571a);
        jSONObject.put("oaid", this.f33610g);
        jSONObject.put("uuid", this.f33609f);
        jSONObject.put("upid", this.f33608e);
        jSONObject.put("imei", this.f33605b);
        jSONObject.put("sn", this.f33606c);
        jSONObject.put("udid", this.f33607d);
        return jSONObject;
    }

    public void b(String str) {
        this.f33605b = str;
    }

    public void c(String str) {
        this.f33610g = str;
    }

    public void d(String str) {
        this.f33606c = str;
    }

    public void e(String str) {
        this.f33607d = str;
    }

    public void f(String str) {
        this.f33608e = str;
    }

    public void g(String str) {
        this.f33609f = str;
    }
}
