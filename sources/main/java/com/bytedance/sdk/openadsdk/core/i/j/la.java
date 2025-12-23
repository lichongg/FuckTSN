package com.bytedance.sdk.openadsdk.core.i.j;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class la extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29142j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("sendPlayableReward", (com.bytedance.sdk.component.j.up<?, ?>) new la(rnVar));
    }

    public la(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29142j = new WeakReference<>(rnVar);
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.rn rnVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29142j;
        if (weakReference != null && weakReference.get() != null && (rnVar = this.f29142j.get()) != null) {
            rnVar.p();
        }
        return jSONObject2;
    }
}
