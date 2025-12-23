package com.bytedance.sdk.openadsdk.m.cw;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements r {

    /* renamed from: j, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.cw.r f31591j;

    public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        this.f31591j = rVar;
    }

    public com.bykv.vk.openvk.component.video.api.cw.r j() {
        return this.f31591j;
    }

    protected void j(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.cw.r rVar = this.f31591j;
            if (rVar == null || jSONObject == null) {
                return;
            }
            JSONObject j6 = rVar.j();
            jSONObject.put("pitaya_cache_size", this.f31591j.xt());
            jSONObject.put("pitaya_code", this.f31591j.cw());
            jSONObject.put("pitaya_msg", this.f31591j.r());
            jSONObject.put("ext_plugin_code", j6.optInt("ext_plugin_code"));
            jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, j6.optJSONObject(WiseOpenHianalyticsData.UNION_PACKAGE));
        } catch (Exception unused) {
        }
    }
}
