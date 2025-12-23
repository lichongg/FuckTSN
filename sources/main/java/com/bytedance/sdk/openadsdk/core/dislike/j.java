package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.openadsdk.core.dislike.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private final n f28872j;

    @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.j
    public boolean j(String str, Dialog dialog) {
        return false;
    }

    public j(n nVar) {
        this.f28872j = nVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.j
    public boolean j(m mVar, String str, Dialog dialog) {
        if (!"7:1".equals(mVar.j())) {
            return false;
        }
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.dislike.j.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("stats_feedback_cannot_close");
                if (j.this.f28872j != null) {
                    j6.m(j.this.f28872j.ej()).tl(j.this.f28872j.os());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("render_control", hh.xt(j.this.f28872j));
                    jSONObject.put("ad_info", j.this.f28872j.fj());
                    jSONObject.put("render_sequence", hh.xt(j.this.f28872j));
                    j6.xt(jSONObject.toString());
                }
                return j6;
            }
        }, "stats_feedback_cannot_close");
        return true;
    }

    public static void j(com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar, n nVar) {
        if (jVar == null || nVar == null) {
            return;
        }
        jVar.j(new j(nVar));
    }
}
