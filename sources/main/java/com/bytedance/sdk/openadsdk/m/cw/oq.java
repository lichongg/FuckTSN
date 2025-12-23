package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends j {

    /* renamed from: j, reason: collision with root package name */
    private String f31595j;
    private long xt;

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f31595j);
            jSONObject.put("preload_size", this.xt);
            j(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public oq(String str, long j6) {
        this.f31595j = str;
        this.xt = j6;
    }
}
