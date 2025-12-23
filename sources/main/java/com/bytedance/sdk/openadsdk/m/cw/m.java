package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements r {

    /* renamed from: j, reason: collision with root package name */
    private long f31594j;
    private long xt;

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f31594j);
            jSONObject.put("total_duration", this.xt);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void j(long j6) {
        this.f31594j = j6;
    }

    public void xt(long j6) {
        this.xt = j6;
    }
}
