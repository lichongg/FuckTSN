package com.bytedance.sdk.openadsdk.core.i.j;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f29163j;

    public static void j(com.bytedance.sdk.component.j.i iVar, JSONObject jSONObject) {
        iVar.j("getData", (com.bytedance.sdk.component.j.up<?, ?>) new vl(jSONObject));
    }

    public vl(JSONObject jSONObject) {
        this.f29163j = jSONObject;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(this.f29163j, jSONObject);
    }
}
