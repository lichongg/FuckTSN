package com.bytedance.sdk.openadsdk.core.kt;

import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import org.json.JSONObject;

@ATS(single = true, value = {"event"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.component.r.cw {
    @Override // com.bytedance.sdk.component.r.cw
    @ATSMethod(1)
    public void j(String str, JSONObject jSONObject, Throwable th) {
        if (up.j(str, 1.0d)) {
            ws.j().j(str, jSONObject, th);
        }
    }

    @Override // com.bytedance.sdk.component.r.cw
    @ATSMethod(2)
    public void j(String str, JSONObject jSONObject) {
        ws.j().j(str, jSONObject);
    }
}
