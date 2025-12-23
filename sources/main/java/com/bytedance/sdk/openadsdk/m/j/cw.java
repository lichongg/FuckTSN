package com.bytedance.sdk.openadsdk.m.j;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements xt {

    /* renamed from: j, reason: collision with root package name */
    xt f31607j;

    @Override // com.bytedance.sdk.openadsdk.m.j.xt
    public void j(JSONObject jSONObject) throws JSONException {
        xt xtVar = this.f31607j;
        if (xtVar != null) {
            xtVar.j(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
