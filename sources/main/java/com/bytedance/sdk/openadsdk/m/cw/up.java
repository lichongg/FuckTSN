package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements r {
    public int cw;

    /* renamed from: j, reason: collision with root package name */
    public long f31601j;

    /* renamed from: r, reason: collision with root package name */
    public int f31602r = 0;
    private int up;
    public long xt;

    public void j(int i6) {
        this.up = i6;
    }

    public void xt(long j6) {
        this.xt = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.f31601j);
            jSONObject.put("buffers_time", this.xt);
            jSONObject.put("break_reason", this.cw);
            jSONObject.put("video_backup", this.f31602r);
            jSONObject.put("vbtt_skip_type", this.up);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void cw(int i6) {
        this.f31602r = i6;
    }

    public void j(long j6) {
        this.f31601j = j6;
    }

    public void xt(int i6) {
        this.cw = i6;
    }
}
