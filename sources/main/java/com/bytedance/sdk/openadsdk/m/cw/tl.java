package com.bytedance.sdk.openadsdk.m.cw;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl implements r {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private long f31599j;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, Object> f31600r;
    private long xt;

    public void j(int i6) {
        this.cw = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.f31600r;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                }
            }
        }
        try {
            jSONObject.put("buffers_time", this.f31599j);
            jSONObject.put("total_duration", this.xt);
            jSONObject.put("vbtt_skip_type", this.cw);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.vl.j(th2);
        }
    }

    public void j(long j6) {
        this.f31599j = j6;
    }

    public void xt(long j6) {
        this.xt = j6;
    }

    public void j(Map<String, Object> map) {
        this.f31600r = map;
    }
}
