package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class vl implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "convert_from_landing_page")
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n f29082j;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = SocialConstants.PARAM_SOURCE)
    private int f29083m;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "event_tag")
    private String f29084r;

    @com.bytedance.sdk.component.qv.xt.j(j = "wc_miniapp_info")
    private JSONObject up;

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        if (!j()) {
            jVar.xt(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.g.j.j.j.tl tlVar = new com.bytedance.sdk.openadsdk.core.g.j.j.j.tl(xp.j(this.up), this.xt, this.cw, this.f29084r, map2, jVar, this.f29083m);
        tlVar.j(this.f29082j);
        if (tlVar.j(new HashMap())) {
            jVar.j(map2);
        } else {
            jVar.xt(map2);
        }
        return true;
    }

    private boolean j() {
        return (this.f29082j == null || this.xt == null || this.up == null) ? false : true;
    }
}
