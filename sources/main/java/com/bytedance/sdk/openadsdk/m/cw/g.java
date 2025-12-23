package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g implements r {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private long f31583j;

    /* renamed from: r, reason: collision with root package name */
    private int f31584r;
    private long xt;

    public void j(long j6) {
        this.f31583j = j6;
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
            jSONObject.put("video_start_duration", this.f31583j);
            jSONObject.put("video_cache_size", this.xt);
            jSONObject.put("is_auto_play", this.cw);
            jSONObject.put("is_supplement_replay", this.f31584r);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void j(int i6) {
        this.f31584r = i6;
    }

    public void xt(int i6) {
        this.cw = i6;
    }
}
