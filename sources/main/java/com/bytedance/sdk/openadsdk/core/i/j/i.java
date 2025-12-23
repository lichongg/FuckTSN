package com.bytedance.sdk.openadsdk.core.i.j;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29136j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("getSendRewardStatus", (com.bytedance.sdk.component.j.up<?, ?>) new i(rnVar));
    }

    public i(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29136j = new WeakReference<>(rnVar);
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.rn rnVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29136j;
        if (weakReference != null && weakReference.get() != null && (rnVar = this.f29136j.get()) != null) {
            jSONObject2.put("isReward", rnVar.ae());
        }
        return jSONObject2;
    }
}
