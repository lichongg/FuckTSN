package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class p extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29150j;

    public static void j(com.bytedance.sdk.component.j.i iVar, final com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("commonConvert", new r.xt() { // from class: com.bytedance.sdk.openadsdk.core.i.j.p.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new p(com.bytedance.sdk.openadsdk.core.rn.this);
            }
        });
    }

    public p(com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29150j = new WeakReference<>(rnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ugeno.g.j h6;
        JSONObject xt;
        com.bytedance.sdk.openadsdk.core.oq.i().z();
        JSONObject jSONObject2 = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.rn> weakReference = this.f29150j;
            if (weakReference == null) {
                com.bytedance.sdk.openadsdk.core.kt.ws.j().j("commonConvert", "js", 1, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xt.j().r(null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.rn rnVar = weakReference.get();
            if (rnVar == null) {
                cw();
                com.bytedance.sdk.openadsdk.core.kt.ws.j().j("commonConvert", "js", 2, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xt.j().r(null);
                return;
            }
            if (jSONObject == null) {
                com.bytedance.sdk.openadsdk.core.kt.ws.j().j("commonConvert", "js", 3, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xt.j().r(null);
                return;
            }
            n j6 = com.bytedance.sdk.openadsdk.core.j.j(jSONObject);
            int optInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
            if (j6 == null) {
                com.bytedance.sdk.openadsdk.core.kt.ws.j().j("commonConvert", "js", 4, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.xt.j().r(j6);
                return;
            }
            j6.j(true);
            jSONObject2.putOpt("live_interaction_type", Integer.valueOf(j6.ww()));
            jSONObject2.putOpt(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, j6.os());
            if (j6.ml() == null && (h6 = j6.h()) != null && (xt = h6.xt()) != null) {
                j6.j(com.bytedance.sdk.openadsdk.core.tj.ws.j(xt));
            }
            rnVar.j(j6, optInt);
            com.bytedance.sdk.openadsdk.core.kt.ws.j().j("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.xt.j().r(j6);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 200);
                j((p) jSONObject3);
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j("xeasy", e6.getMessage());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.core.kt.ws.j().j("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.xt.j().r(null);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
