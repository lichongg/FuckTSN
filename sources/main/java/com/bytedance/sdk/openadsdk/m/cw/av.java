package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av implements r {

    /* renamed from: j, reason: collision with root package name */
    private long f31575j;
    private boolean xt;

    public void j(long j6) {
        this.f31575j = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.f31575j);
            jSONObject.put("is_auto_play", this.xt);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public void j(boolean z5) {
        this.xt = z5;
    }
}
