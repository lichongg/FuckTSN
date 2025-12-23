package com.bytedance.sdk.openadsdk.oq.j;

import com.bytedance.sdk.component.j.i;
import com.bytedance.sdk.openadsdk.core.rn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<rn> f31800j;

    public static void j(i iVar, rn rnVar) {
        iVar.j("rewardPlayAgain", (com.bytedance.sdk.component.j.up<?, ?>) new cw(rnVar));
    }

    public cw(rn rnVar) {
        this.f31800j = new WeakReference<>(rnVar);
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        rn rnVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<rn> weakReference = this.f31800j;
        if (weakReference != null && weakReference.get() != null && (rnVar = this.f31800j.get()) != null) {
            rnVar.i();
        }
        return jSONObject2;
    }
}
