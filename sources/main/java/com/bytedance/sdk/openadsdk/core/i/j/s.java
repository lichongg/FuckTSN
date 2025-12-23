package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class s extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.xt f29155j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.ugeno.xt xtVar) {
        iVar.j("RendUgenDownloadDialogState", (com.bytedance.sdk.component.j.up<?, ?>) new s(xtVar));
    }

    public JSONObject cw() {
        return new JSONObject();
    }

    public s(com.bytedance.sdk.openadsdk.core.ugeno.xt xtVar) {
        this.f29155j = xtVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        j(jSONObject);
        return cw();
    }

    private void j(JSONObject jSONObject) {
        if (jSONObject == null || this.f29155j == null) {
            return;
        }
        int optInt = jSONObject.optInt("code");
        if (optInt == 200) {
            this.f29155j.j();
        } else {
            this.f29155j.j(optInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
        }
    }
}
