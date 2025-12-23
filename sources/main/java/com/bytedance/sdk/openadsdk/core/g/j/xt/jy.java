package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.analytics.pro.d;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class jy implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "convert_from_downloader")
    private boolean ae;

    @com.bytedance.sdk.component.qv.xt.j(j = "event_tag")
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "download_adapter")
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw f29057g;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n f29058j;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "convert_from_landing_page")
    private boolean f29059m;

    @com.bytedance.sdk.component.qv.xt.j(j = "convert_tag")
    private String oq;

    @com.bytedance.sdk.component.qv.xt.j(j = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.xt.xt qv;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "deep_link")
    private JSONObject f29060r;

    @com.bytedance.sdk.component.qv.xt.j(j = "is_market_covert")
    private boolean tl;

    @com.bytedance.sdk.component.qv.xt.j(j = "app_info")
    private JSONObject up;

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        com.bytedance.sdk.openadsdk.core.g.j.j.j.ae aeVar = new com.bytedance.sdk.openadsdk.core.g.j.j.j.ae(com.bytedance.sdk.openadsdk.core.j.xt(this.up), this.xt);
        aeVar.j(this.f29058j);
        aeVar.j(this.cw);
        com.bytedance.sdk.openadsdk.core.g.j.j.j.cw cwVar = new com.bytedance.sdk.openadsdk.core.g.j.j.j.cw(aeVar, this.f29058j, this.cw, new com.bytedance.sdk.openadsdk.core.tj.i(this.f29060r), this.xt);
        cwVar.xt(this.ae);
        cwVar.j(this.f29059m);
        cwVar.cw(this.tl);
        cwVar.j(this.f29057g);
        cwVar.j(this.oq);
        cwVar.j(this.qv);
        if (cwVar.j(map2)) {
            jVar.j(map2);
            return true;
        }
        jVar.xt(map2);
        return true;
    }
}
