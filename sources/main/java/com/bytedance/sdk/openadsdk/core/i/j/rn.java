package com.bytedance.sdk.openadsdk.core.i.j;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class rn extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.rn f29154j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("ShowUgenDownloadDialog", (com.bytedance.sdk.component.j.up<?, ?>) new rn(rnVar));
    }

    public JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.rn rnVar = this.f29154j;
        if (rnVar != null) {
            return rnVar.qv();
        }
        try {
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "JsObject is null");
            return jSONObject;
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    public rn(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29154j = rnVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        return cw();
    }
}
