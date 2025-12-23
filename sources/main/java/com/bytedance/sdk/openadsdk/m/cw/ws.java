package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws implements r {
    public long cw;

    /* renamed from: j, reason: collision with root package name */
    public long f31604j;
    public int xt;

    public void j(long j6) {
        this.f31604j = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f31604j);
            jSONObject.put("buffers_count", this.xt);
            jSONObject.put("total_duration", this.cw);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void j(int i6) {
        this.xt = i6;
    }

    public void xt(long j6) {
        this.cw = j6;
    }
}
