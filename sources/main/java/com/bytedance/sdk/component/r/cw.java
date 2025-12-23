package com.bytedance.sdk.component.r;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import org.json.JSONObject;

@ATSApi("event")
/* loaded from: D:\Downloads\app\classes4.dex */
public interface cw {
    @ATSMethod(2)
    void j(String str, JSONObject jSONObject);

    @ATSMethod(1)
    void j(String str, JSONObject jSONObject, Throwable th);
}
