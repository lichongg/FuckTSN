package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.component.j.r;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends com.bytedance.sdk.component.j.r<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.w.cw cw;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.rn> f29143j;
    private n xt;

    public m(com.bytedance.sdk.openadsdk.core.rn rnVar, n nVar) {
        this.f29143j = new WeakReference<>(rnVar);
        this.xt = nVar;
    }

    public static void j(com.bytedance.sdk.component.j.i iVar, final com.bytedance.sdk.openadsdk.core.rn rnVar, final n nVar) {
        iVar.j("getNetworkData", new r.xt() { // from class: com.bytedance.sdk.openadsdk.core.i.j.m.1
            @Override // com.bytedance.sdk.component.j.r.xt
            public com.bytedance.sdk.component.j.r j() {
                return new m(com.bytedance.sdk.openadsdk.core.rn.this, nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.j.r
    public void j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.rn rnVar = this.f29143j.get();
        if (rnVar == null) {
            cw();
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.cw = new com.bytedance.sdk.openadsdk.core.w.cw() { // from class: com.bytedance.sdk.openadsdk.core.i.j.m.2
            @Override // com.bytedance.sdk.openadsdk.core.w.cw
            public void j(boolean z5, List<n> list, boolean z6) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (z5) {
                        jSONObject2.put("creatives", com.bytedance.sdk.openadsdk.core.rn.j(list));
                        jSONObject2.put("is_cache", z6);
                        if (z6) {
                            jSONObject2.put("prefetch_opt_time", currentTimeMillis - com.bytedance.sdk.openadsdk.core.playable.xt.j().cw(m.this.xt));
                        }
                        m.this.j((m) jSONObject2);
                    } else {
                        m.this.j((m) jSONObject2);
                    }
                    com.bytedance.sdk.openadsdk.core.oq.i().z();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.cw("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        if (jSONObject != null && jSONObject.optBoolean("is_first_request", false) && com.bytedance.sdk.openadsdk.core.playable.xt.j().j(this.xt, this.cw)) {
            return;
        }
        rnVar.j(jSONObject, this.cw);
    }

    @Override // com.bytedance.sdk.component.j.r
    protected void r() {
    }
}
