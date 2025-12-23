package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class qv implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "handle_chain_data")
    private Map<String, Object> ae;

    @com.bytedance.sdk.component.qv.xt.j(j = "event_tag")
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n f29067j;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "view")
    private View f29068m;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "dpa_tag")
    private String f29069r;

    @com.bytedance.sdk.component.qv.xt.j(j = "live_saas_interaction_type")
    private int up = -1;

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        if (!j()) {
            jVar.xt(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.g.j.j.j.m mVar = new com.bytedance.sdk.openadsdk.core.g.j.j.j.m(this.f29067j, this.xt, this.cw, this.f29069r);
        int i6 = this.up;
        if (i6 != -1) {
            mVar.xt(i6);
        }
        mVar.j(this.f29068m);
        mVar.xt(this.ae);
        if (new com.bytedance.sdk.openadsdk.core.g.j.j.j.xt(new com.bytedance.sdk.openadsdk.core.g.j.j.j.up(mVar, this.f29067j, jVar, map2, this.cw), this.xt, this.f29067j, this.cw, map2, jVar).j(new HashMap())) {
            jVar.j(map2);
            return false;
        }
        jVar.xt(map2);
        return false;
    }

    private boolean j() {
        return (this.f29067j == null || this.xt == null) ? false : true;
    }
}
