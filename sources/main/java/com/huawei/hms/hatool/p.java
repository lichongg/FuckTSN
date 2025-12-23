package com.huawei.hms.hatool;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class p extends h0 {

    /* renamed from: g, reason: collision with root package name */
    private String f33629g = "";

    @Override // com.huawei.hms.hatool.u0
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f33580d);
        jSONObject.put("appid", this.f33577a);
        jSONObject.put("hmac", this.f33629g);
        jSONObject.put("chifer", this.f33582f);
        jSONObject.put("timestamp", this.f33578b);
        jSONObject.put("servicetag", this.f33579c);
        jSONObject.put("requestid", this.f33581e);
        return jSONObject;
    }

    public void g(String str) {
        this.f33629g = str;
    }
}
