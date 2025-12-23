package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private n f29128j;

    public static void j(com.bytedance.sdk.component.j.i iVar, n nVar) {
        iVar.j("getLiveSaasAuthStatus", (com.bytedance.sdk.component.j.up<?, ?>) new az(nVar));
    }

    public az(n nVar) {
        this.f29128j = nVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.tj.c j6;
        n nVar;
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.tj.i iVar = null;
        if (jSONObject != null) {
            try {
                j6 = com.bytedance.sdk.openadsdk.core.tj.c.j(jSONObject.optJSONObject("live_info"));
                JSONObject optJSONObject = jSONObject.optJSONObject("deep_link");
                if (optJSONObject != null) {
                    iVar = new com.bytedance.sdk.openadsdk.core.tj.i(optJSONObject);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.r("glsas", "method:" + th.getMessage());
                return jSONObject2;
            }
        } else {
            j6 = null;
        }
        if (iVar == null && (nVar = this.f29128j) != null) {
            iVar = nVar.m111if();
        }
        if (j6 == null) {
            j6 = this.f29128j.yx();
        }
        jSONObject2.put("has_live_silent_auth", j6 != null && j6.cw());
        jSONObject2.put("has_install_douyin", com.bytedance.sdk.openadsdk.core.live.up.j.j(iVar));
        jSONObject2.put("has_live_authed", com.bytedance.sdk.openadsdk.core.live.xt.j().up() == 2);
        boolean z5 = j6 != null && j6.r();
        if (z5) {
            z5 = com.bytedance.sdk.openadsdk.core.live.xt.j().cw() == 2;
        }
        jSONObject2.put("has_playable_auth_switch", z5);
        JSONObject jSONObject3 = new JSONObject();
        if (j6 != null) {
            jSONObject3.put("aweme_agreements", j6.up());
            jSONObject3.put("aweme_privacy", j6.m());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}
