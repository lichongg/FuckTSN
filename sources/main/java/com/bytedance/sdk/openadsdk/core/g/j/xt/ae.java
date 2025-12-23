package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.ss.android.j.j.cw.e;
import com.umeng.analytics.pro.d;
import java.util.Map;
import org.json.JSONObject;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements com.bytedance.sdk.component.qv.j.j.cw {

    /* renamed from: g, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "is_click_button")
    private volatile boolean f29016g;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    protected n f29017j;

    @com.bytedance.sdk.component.qv.xt.j(j = "dialog_to_landing_page_convert")
    private com.bytedance.sdk.openadsdk.core.g.j.j.j jy;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "download_popup_manager")
    protected com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw f29018m;

    @com.bytedance.sdk.component.qv.xt.j(j = "download_url")
    private String oq;

    @com.bytedance.sdk.component.qv.xt.j(j = "download_conf")
    private JSONObject qv;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "event_tag")
    protected String f29019r;

    @com.bytedance.sdk.component.qv.xt.j(j = "is_open_oppo_market_auto_download")
    private volatile boolean tl;

    @com.bytedance.sdk.component.qv.xt.j(j = "download_status_listener")
    protected e up;

    @com.bytedance.sdk.component.qv.xt.j(j = "app_info")
    private JSONObject vl;

    @com.bytedance.sdk.component.qv.xt.j(j = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.xt.xt ws;

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    protected Context xt;

    @com.bytedance.sdk.component.qv.xt.j(j = "convert_from_landing_page")
    protected volatile boolean cw = false;

    @com.bytedance.sdk.component.qv.xt.j(j = "need_check_compliance")
    private int ae = 0;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        if (!j()) {
            jVar.xt(map2);
            return true;
        }
        int cw = com.bytedance.sdk.openadsdk.core.g.j.j.j.j.cw(map2);
        com.bytedance.sdk.openadsdk.core.g.j.j.j.r rVar = new com.bytedance.sdk.openadsdk.core.g.j.j.j.r(this.f29017j, this.xt, this.f29019r, this.f29018m, this.oq);
        rVar.xt(this.f29016g);
        rVar.j(this.tl, cw);
        rVar.j(this.up);
        rVar.j(this.cw);
        rVar.j(this.ae);
        rVar.j(this.jy);
        rVar.j(new tj(this.qv));
        if (new com.bytedance.sdk.openadsdk.core.g.j.j.xt.xt(rVar, this.ws).j(map2)) {
            jVar.j(map2);
        } else {
            jVar.xt(map2);
        }
        return true;
    }

    private boolean j() {
        if (this.f29017j == null || this.xt == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.oq)) {
            return (TextUtils.isEmpty(this.f29019r) || this.f29018m == null) ? false : true;
        }
        com.bytedance.sdk.openadsdk.core.tj.up xt = com.bytedance.sdk.openadsdk.core.j.xt(this.vl);
        if (xt != null) {
            this.oq = xt.xt();
        }
        return false;
    }
}
