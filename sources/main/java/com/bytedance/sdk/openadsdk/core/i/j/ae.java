package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.component.j.r;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29125j;

    public static void j(com.bytedance.sdk.component.j.i iVar, final com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("newClickEvent", new r.xt() { // from class: com.bytedance.sdk.openadsdk.core.i.j.ae.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new ae(com.bytedance.sdk.openadsdk.core.rn.this);
            }
        });
    }

    public ae(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29125j = new WeakReference<>(rnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.rn rnVar = this.f29125j.get();
        if (rnVar == null) {
            cw();
        } else {
            rnVar.oq(jSONObject);
        }
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
