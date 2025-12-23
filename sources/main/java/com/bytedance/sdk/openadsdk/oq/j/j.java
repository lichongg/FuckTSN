package com.bytedance.sdk.openadsdk.oq.j;

import com.bytedance.sdk.component.j.i;
import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<rn> f31801j;

    public static void j(i iVar, final rn rnVar) {
        iVar.j("interstitial_webview_close", new r.xt() { // from class: com.bytedance.sdk.openadsdk.oq.j.j.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new j(rn.this);
            }
        });
    }

    public j(rn rnVar) {
        this.f31801j = new WeakReference<>(rnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        oq.i().z();
        vl.r("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        rn rnVar = this.f31801j.get();
        if (rnVar == null) {
            vl.r("DoInterstitialWebViewCloseMethod", "invoke error");
            cw();
        } else {
            rnVar.ws();
        }
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
