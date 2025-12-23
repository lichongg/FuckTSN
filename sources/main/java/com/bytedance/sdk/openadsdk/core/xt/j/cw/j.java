package com.bytedance.sdk.openadsdk.core.xt.j.cw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.ws.r;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {
    protected String ae;

    /* renamed from: m, reason: collision with root package name */
    protected Map<String, Object> f31324m;
    private String qv;
    protected boolean tl;
    protected oq up;
    private com.bytedance.sdk.openadsdk.core.video.xt.xt vl;

    /* renamed from: g, reason: collision with root package name */
    private int f31323g = -1;
    private int oq = -1;
    private boolean jy = false;

    public j() {
    }

    public void j(boolean z5) {
        this.jy = z5;
    }

    public void xt(boolean z5) {
        this.tl = z5;
    }

    public String cw() {
        return this.qv;
    }

    public void j(String str) {
        this.ae = str;
    }

    protected oq r() {
        int i6 = this.f31323g;
        if (i6 != -1) {
            this.f31323g = -1;
        } else {
            i6 = -1;
        }
        float m6 = ed.m(this.xt);
        int tl = ed.tl(this.xt);
        float ae = ed.ae(this.xt);
        View ae2 = this.cw.ae();
        View m7 = this.cw.m();
        return new oq.j().m(this.cw.ws()).up(this.cw.az()).r(this.cw.av()).cw(this.cw.i()).xt(this.cw.vl()).j(this.cw.jy()).xt(ed.j(ae2)).j(ed.j(m7)).cw(ed.cw(ae2)).r(ed.cw(m7)).cw(this.cw.xt()).r(this.cw.cw()).up(this.cw.r()).j(this.cw.oq()).xt(com.bytedance.sdk.openadsdk.core.oq.i().cw() ? 1 : 2).j(this.qv).j(m6).j(tl).xt(ae).m(i6).ae(this.oq).tl(this.cw.mi()).up(this.cw.w()).j(this.cw.j()).j();
    }

    public Map<String, Object> up() {
        return this.f31324m;
    }

    public void xt() {
        this.oq = 1;
    }

    private void m() {
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        long xt = j6.xt("click_to_live_duration", 0L);
        if (xt == 0) {
            Map<String, Object> map = this.f31324m;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - xt;
        HashMap hashMap = new HashMap();
        hashMap.put("click_livead_duration", Long.valueOf(currentTimeMillis));
        j(hashMap);
        j6.xt("click_to_live_duration", 0L);
    }

    public void j() {
        this.f31323g = 1;
    }

    public void xt(String str) {
        this.qv = str;
    }

    public void j(oq oqVar) {
        this.up = oqVar;
    }

    public j(n nVar, Context context) {
        this.f31325j = nVar;
        this.xt = context;
        this.f31324m = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.xt, com.bytedance.sdk.openadsdk.core.xt.j.j
    public int j(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xt.j.cw cwVar) {
        if (this.jy) {
            return 0;
        }
        com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar = this.vl;
        if (xtVar != null && xtVar.qv() == 1) {
            return 0;
        }
        if (this.cw == null) {
            this.cw = new qv();
        }
        if ("splash_ad".equals(this.ae) || "cache_splash_ad".equals(this.ae) || "splash_ad_landingpage".equals(this.ae)) {
            this.f31323g = this.f31323g == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean booleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.up == null) {
            this.up = r();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            m();
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.f31324m.put("refer", "banner");
        }
        if (l.j(this.f31325j) && !r.j(String.valueOf(uf.g(this.f31325j))) && this.f31325j.ng() != null) {
            this.f31324m.put("refresh_num", Integer.valueOf(this.f31325j.ng().cw()));
        }
        Object obj3 = map.get("click_saas_action");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.f31324m.put("click_saas_action", obj3);
        }
        Object obj4 = map.get("click_saas_area");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.f31324m.put("click_saas_area", obj4);
        }
        j(true);
        com.bytedance.sdk.openadsdk.core.jy.cw.j(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, this.f31325j, this.up, this.ae, booleanValue, this.f31324m, this.cw.up() ? 1 : 2, this.tl);
        return 0;
    }

    public void j(Map<String, Object> map) {
        Map<String, Object> map2 = this.f31324m;
        if (map2 == null) {
            this.f31324m = map;
        } else {
            map2.putAll(map);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.video.xt.xt xtVar) {
        this.vl = xtVar;
    }
}
