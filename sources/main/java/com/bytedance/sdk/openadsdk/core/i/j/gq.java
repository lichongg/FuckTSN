package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.component.j.r;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class gq extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29133j;

    public static void j(com.bytedance.sdk.component.j.i iVar, final com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("showAppDetailOrPrivacyDialog", new r.xt() { // from class: com.bytedance.sdk.openadsdk.core.i.j.gq.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new gq(com.bytedance.sdk.openadsdk.core.rn.this);
            }
        });
    }

    public gq(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29133j = new WeakReference<>(rnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.oq.i().z();
        WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29133j;
        if (weakReference == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rn rnVar = weakReference.get();
        if (rnVar == null) {
            cw();
            return;
        }
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("show_dialog_style");
        if (optInt == 1) {
            rnVar.v();
        } else if (optInt == 2) {
            rnVar.f();
        }
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
