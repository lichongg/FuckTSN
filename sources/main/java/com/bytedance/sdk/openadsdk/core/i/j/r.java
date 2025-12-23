package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.rn f29153j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("businessStatusNotify", (com.bytedance.sdk.component.j.up<?, ?>) new r(rnVar));
    }

    public r(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29153j = rnVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.rn rnVar;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null && (rnVar = this.f29153j) != null) {
            rnVar.rn();
        }
        return jSONObject2;
    }
}
