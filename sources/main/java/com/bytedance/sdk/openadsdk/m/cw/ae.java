package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements r {
    private int cw = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f31574j;
    private long xt;

    public void j(long j6) {
        this.f31574j = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.f31574j);
            jSONObject.put("buffers_time", this.xt);
            jSONObject.put("video_backup", this.cw);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void j(int i6) {
        this.cw = i6;
    }

    public void xt(long j6) {
        this.xt = j6;
    }
}
