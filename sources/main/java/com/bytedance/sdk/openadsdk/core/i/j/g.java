package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private n f29132j;
    private com.bytedance.sdk.openadsdk.core.rn xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, n nVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("adViewInfo", (com.bytedance.sdk.component.j.up<?, ?>) new g(nVar, rnVar));
    }

    public g(n nVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29132j = nVar;
        this.xt = rnVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("container", this.xt.j());
        jSONObject2.put("creative", this.xt.xt());
        return jSONObject2;
    }
}
