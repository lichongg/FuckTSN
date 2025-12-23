package com.bytedance.sdk.openadsdk.m.cw;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends j {

    /* renamed from: j, reason: collision with root package name */
    private String f31603j;
    private long xt;

    @Override // com.bytedance.sdk.openadsdk.m.cw.r
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f31603j);
            jSONObject.put("preload_size", this.xt);
            com.bykv.vk.openvk.component.video.api.cw.r j6 = j();
            if (j6 != null) {
                jSONObject.put("run_task_mills", j6.j().optLong("run_task_mills"));
            }
            j(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public vl(String str, long j6) {
        this.f31603j = str;
        this.xt = j6;
    }
}
