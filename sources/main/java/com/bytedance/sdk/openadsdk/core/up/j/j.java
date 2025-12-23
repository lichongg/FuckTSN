package com.bytedance.sdk.openadsdk.core.up.j;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.j.r;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.la;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.z;
import com.bytedance.sdk.openadsdk.core.up.up.up;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.analytics.pro.d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends cw {
    @Override // com.bytedance.sdk.openadsdk.core.up.j.cw
    protected boolean j() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.j.cw, com.bytedance.sdk.openadsdk.core.up.j.xt
    public com.bytedance.sdk.openadsdk.core.up.up.cw j(final n nVar, final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final up upVar, Bundle bundle) {
        final com.bytedance.sdk.openadsdk.core.component.reward.xt xtVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.xt(v.getContext(), nVar, xtVar);
        final boolean z5 = bundle.getBoolean("is_cache", false);
        final long j6 = bundle.getLong(d.f41197p);
        xtVar2.j(z5);
        xtVar2.j(z5 ? 101 : 102);
        if (nVar.xj() <= 0) {
            xtVar2.j(System.currentTimeMillis() + 10500000);
        } else {
            xtVar2.j(nVar.xj() * 1000);
        }
        if (!com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar) && !tj.cw(nVar) && !z.j(nVar) && z5) {
            xtVar2.m();
        }
        return new com.bytedance.sdk.openadsdk.core.up.up.cw() { // from class: com.bytedance.sdk.openadsdk.core.up.j.j.1
            @Override // com.bytedance.sdk.openadsdk.core.up.up.cw
            public void cw() {
                if (z5) {
                    com.bytedance.sdk.openadsdk.core.up.up.xt xtVar3 = j.this.f30861j;
                    if (xtVar3 != null) {
                        xtVar3.j().cw(xtVar, nVar);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.up.up.xt xtVar4 = j.this.f30861j;
                if (xtVar4 != null) {
                    xtVar4.j().xt(xtVar, nVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.up.up.cw
            public void j() {
                com.bytedance.sdk.openadsdk.core.up.up.xt xtVar3 = j.this.f30861j;
                if (xtVar3 != null) {
                    xtVar3.j().j(xtVar, nVar, xtVar2, z5);
                }
                up upVar2 = upVar;
                if (upVar2 != null) {
                    upVar2.j(xtVar2);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_from_cache", z5);
                    jSONObject.put("is_adm", !TextUtils.isEmpty(xtVar.tj()));
                    jSONObject.put("cache_strategy", r.j(j.this.j()));
                    jSONObject.put("src_req_id", nVar.hk());
                    jSONObject.put("is_map", nVar.ay());
                    jSONObject.put("load_duration", System.currentTimeMillis() - j6);
                } catch (JSONException unused) {
                }
                ws.j().j(nVar, "stats_reward_full_ad_loaded", jSONObject);
                j.this.j(this, nVar, xtVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.up.up.cw
            public void xt() {
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(nVar, uf.xt(xtVar.kt()), j6);
                xtVar2.xt(1);
                up upVar2 = upVar;
                if (upVar2 != null) {
                    upVar2.xt(xtVar2);
                }
            }
        };
    }

    public j(com.bytedance.sdk.openadsdk.core.up.up.xt xtVar) {
        super(xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.j.cw
    protected boolean j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        List<n> xt;
        if (jVar != null && (xt = jVar.xt()) != null) {
            n nVar = xt.get(0);
            if (l.j(nVar)) {
                return nVar.ng().cw() != 1;
            }
            if (la.xt(j(), nVar, false) && la.r(nVar) != 0) {
                return true;
            }
        }
        return false;
    }
}
