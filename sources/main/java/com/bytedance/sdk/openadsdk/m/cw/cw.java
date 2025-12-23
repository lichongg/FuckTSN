package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements r {
    private int ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private long f31580j;

    /* renamed from: m, reason: collision with root package name */
    private long f31581m;

    /* renamed from: r, reason: collision with root package name */
    private int f31582r;
    private long up;
    private long xt;

    public void cw(long j6) {
        this.f31580j = j6;
    }

    public void j(long j6) {
        this.f31581m = j6;
    }

    public void xt(long j6) {
        this.up = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f31580j);
            jSONObject.put("total_duration", this.xt);
            jSONObject.put("vbtt_skip_type", this.cw);
            jSONObject.put("skip_reason", this.f31582r);
            jSONObject.put("video_cache_size", this.up);
            jSONObject.put("current", this.f31581m);
            jSONObject.put("percent", this.ae);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void cw(int i6) {
        this.f31582r = i6;
    }

    public void j(int i6) {
        this.ae = i6;
    }

    public void r(long j6) {
        this.xt = j6;
    }

    public void xt(int i6) {
        this.cw = i6;
    }
}
