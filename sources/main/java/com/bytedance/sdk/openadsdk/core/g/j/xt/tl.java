package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.analytics.pro.d;
import java.util.Map;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class tl implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "download_url")
    private String ae;

    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n cw;

    /* renamed from: g, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "is_show_download_dialog")
    private boolean f29074g = true;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "convert_from_landing_page")
    protected boolean f29075j;

    @com.bytedance.sdk.component.qv.xt.j(j = "download_dialog_listener")
    private com.bytedance.sdk.openadsdk.core.qv.cw.j.j jy;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "event_tag")
    private String f29076m;

    @com.bytedance.sdk.component.qv.xt.j(j = "is_from_new_click_event")
    private boolean oq;

    @com.bytedance.sdk.component.qv.xt.j(j = "dynamic_download_dialog_type")
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "is_app_market_convert")
    private boolean f29077r;

    @com.bytedance.sdk.component.qv.xt.j(j = "start_download_listener")
    private com.bytedance.sdk.openadsdk.core.qv.cw.j.xt tl;

    @com.bytedance.sdk.component.qv.xt.j(j = "app_manage_model")
    private com.bytedance.sdk.openadsdk.core.tj.r up;

    @com.bytedance.sdk.component.qv.xt.j(j = "is_direct_download")
    private boolean vl;

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw cwVar = new com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw(this.xt, this.cw);
        cwVar.cw(this.vl);
        cwVar.j(this.f29074g);
        cwVar.j(this.qv);
        cwVar.xt(this.oq);
        cwVar.j(this.jy);
        cwVar.j(j());
        if (!cwVar.r(false)) {
            jVar.xt(map2);
            return true;
        }
        cwVar.j(this.up, this.f29076m, this.ae, this.tl);
        jVar.j(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.qv.cw.cw.j j() {
        if (this.f29077r) {
            return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.up();
        }
        if (this.f29075j) {
            return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.r();
        }
        return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.xt();
    }
}
