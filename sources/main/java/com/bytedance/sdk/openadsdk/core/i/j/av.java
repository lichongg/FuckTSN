package com.bytedance.sdk.openadsdk.core.i.j;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29127j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("getPlayTimeCurrent", (com.bytedance.sdk.component.j.up<?, ?>) new av(rnVar));
    }

    public av(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29127j = new WeakReference<>(rnVar);
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29127j;
        if (weakReference != null && weakReference.get() != null) {
            com.bytedance.sdk.openadsdk.core.rn rnVar = this.f29127j.get();
            jSONObject2.put("currentTime", rnVar != null ? rnVar.h() : 0);
        }
        return jSONObject2;
    }
}
