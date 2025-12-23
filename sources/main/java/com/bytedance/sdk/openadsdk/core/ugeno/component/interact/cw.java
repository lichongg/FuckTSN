package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    n f30595j;

    public void j(final int i6, final boolean z5) {
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.cw.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i6));
                jSONObject.putOpt("is_root_container", Boolean.valueOf(z5));
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().tl(cw.this.f30595j.os()).j("stats_easy_playable_render_start").xt(jSONObject.toString());
            }
        }, "stats_easy_playable_render_start");
    }

    public void j(final int i6) {
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.cw.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i6));
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().tl(cw.this.f30595j.os()).j("stats_easy_playable_render_exec").xt(jSONObject.toString());
            }
        }, "stats_easy_playable_render_exec");
    }

    cw(n nVar) {
        this.f30595j = nVar;
    }

    public void j(boolean z5, Map<String, Object> map) {
        int i6;
        String cw = a.cw(this.f30595j);
        if (map != null) {
            Object obj = map.get("render_type");
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                i6 = 1;
                if (intValue != 1) {
                    if (intValue == 0) {
                        i6 = 2;
                    }
                }
                oq.j(this.f30595j, z5, cw, i6, map);
            }
        }
        i6 = -1;
        oq.j(this.f30595j, z5, cw, i6, map);
    }

    public void xt(final int i6) {
        ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.cw.3
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i6));
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().tl(cw.this.f30595j.os()).j("stats_easy_playable_inject_view").xt(jSONObject.toString());
            }
        }, "stats_easy_playable_inject_view");
    }
}
