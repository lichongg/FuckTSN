package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class f extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.rn f29131j;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ae.xt> xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ae.xt> weakReference) {
        iVar.j("pauseRewardCountDown", (com.bytedance.sdk.component.j.up<?, ?>) new f(rnVar, weakReference));
    }

    public f(com.bytedance.sdk.openadsdk.core.rn rnVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ae.xt> weakReference) {
        this.f29131j = rnVar;
        this.xt = weakReference;
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ae.xt> weakReference = this.xt;
        if (weakReference != null && weakReference.get() != null) {
            this.xt.get().j();
            jSONObject2.put("success", true);
            return jSONObject2;
        }
        jSONObject2.put("success", false);
        return jSONObject2;
    }
}
