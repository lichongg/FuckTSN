package com.bytedance.sdk.openadsdk.core.i.j;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29152j;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("getAppManage", (com.bytedance.sdk.component.j.up<?, ?>) new qv(rnVar));
    }

    public JSONObject cw() {
        com.bytedance.sdk.openadsdk.core.rn rnVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29152j;
            if (weakReference != null && (rnVar = weakReference.get()) != null) {
                return rnVar.x();
            }
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public qv(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29152j = new WeakReference<>(rnVar);
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        return cw();
    }
}
