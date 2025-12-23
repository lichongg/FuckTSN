package com.bytedance.sdk.openadsdk.core.xt.j.j;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.ae;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.core.xt.j.j.j;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    private ae ae;

    /* renamed from: m, reason: collision with root package name */
    private int f31327m;
    private boolean tl;

    private boolean xt(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387670 || view.getId() == 2114387957 || view.getId() == 2114387770 || view.getId() == 2114387692 || view.getId() == 2114387632) {
            return true;
        }
        if (view instanceof ViewGroup) {
            int i6 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i6 >= viewGroup.getChildCount()) {
                    break;
                }
                if (xt(viewGroup.getChildAt(i6))) {
                    return true;
                }
                i6++;
            }
        }
        return false;
    }

    private boolean g() {
        if (this.f31325j == null || oq() || !n.xt(this.f31325j)) {
            return false;
        }
        if (this.f31327m == 0) {
            this.f31327m = uf.tl(this.f31325j);
        }
        up();
        ae();
        m();
        if (this.f31327m == 5 && qv() && ae() && !up() && !m()) {
            return false;
        }
        int i6 = this.f31327m;
        return i6 == 1 || i6 == 2 || i6 == 5;
    }

    private boolean oq() {
        return this.tl;
    }

    private boolean qv() {
        n nVar = this.f31325j;
        return nVar != null && nVar.k() == 1 && n.xt(this.f31325j);
    }

    protected boolean ae() {
        n nVar = this.f31325j;
        if (nVar == null) {
            return true;
        }
        int ae = v.xt().ae(uf.g(nVar));
        if (ae == 1) {
            return ws.r(this.xt);
        }
        if (ae == 2) {
            return ws.up(this.xt) || ws.r(this.xt) || ws.m(this.xt);
        }
        if (ae != 3) {
            return ae != 5 || ws.r(this.xt) || ws.m(this.xt);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.j.j.j, com.bytedance.sdk.openadsdk.core.xt.j.j
    public int j(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xt.j.cw cwVar) {
        boolean z5;
        xt(this.f31325j.jl());
        cw();
        final j.InterfaceC0499j j6 = this.up.j();
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.j.cw.1
            @Override // java.lang.Runnable
            public void run() {
                j.InterfaceC0499j interfaceC0499j = j6;
                if (interfaceC0499j != null) {
                    interfaceC0499j.j(((com.bytedance.sdk.openadsdk.core.xt.j.j) cw.this).f31326r, cw.this.up.cw());
                }
            }
        });
        Map<String, Object> tl = this.up.tl();
        String tj = this.cw.tj();
        if (TextUtils.isEmpty(tj)) {
            tj = "clickEvent";
        }
        String str = tj;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        tl.put("click_from_uchain", 1);
        tl.put("event_type", str);
        uf.a();
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.f31325j);
        hashMap.put("click_chain", cwVar);
        hashMap.put("dpa_tag", this.cw.kt());
        hashMap.put(d.X, this.xt);
        hashMap.put("event_tag", this.up.g());
        hashMap.put(SocialConstants.PARAM_SOURCE, Integer.valueOf(this.up.ae()));
        hashMap.put("view", this.f31326r);
        View view = this.f31326r;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            z5 = text != null && (text.toString().contains("下载") || text.toString().contains("安装"));
            if (this.f31326r instanceof Button) {
                z5 = true;
            }
        } else {
            z5 = false;
        }
        hashMap.put("is_click_button", Boolean.valueOf(z5 || this.cw.j()));
        hashMap.put("handle_chain_data", map);
        com.bytedance.sdk.openadsdk.core.qv.xt.cw m6 = this.up.m();
        if (m6 != null) {
            hashMap.put("download_adapter", m6);
            hashMap.put("is_market_covert", Boolean.valueOf(m6.cw()));
            hashMap.putAll(m6.up());
        }
        Map<String, Object> j7 = com.bytedance.sdk.component.qv.up.j.j().j(this.f31325j.hashCode() + this.f31325j.ej());
        this.ae = (ae) x.j(this.f31325j.hm(), ae.class);
        Object remove = j7.remove("is_express_ad");
        if (remove instanceof Boolean) {
            this.tl = ((Boolean) remove).booleanValue();
        }
        hashMap.put("is_video_lp", Boolean.valueOf(tl()));
        hashMap.putAll(j7);
        Boolean bool = Boolean.FALSE;
        hashMap.put("convert_from_downloader", bool);
        hashMap.put("convert_from_landing_page", Boolean.valueOf(this.up.xt()));
        hashMap.put("pip_controller", this.up.vl());
        com.bytedance.sdk.openadsdk.core.g.j.j.xt.j jVar = new com.bytedance.sdk.openadsdk.core.g.j.j.xt.j(this.f31325j, this.xt, this.up.g(), this.up.ae());
        jVar.j(!tl() && this.up.r());
        jVar.xt(this.up.oq());
        hashMap.put("is_open_web_page", bool);
        jVar.xt(hashMap);
        hashMap.put("activity_type", Integer.valueOf(uf.j(jVar.j())));
        hashMap.put("is_feed_register_direct_download", Boolean.valueOf(this.cw.j()));
        com.bytedance.sdk.openadsdk.core.g.j.r.j.j(this.f31325j, tl, str, hashMap, this.up.g(), new HashMap());
        r();
        return 0;
    }

    public boolean m() {
        ae aeVar = this.ae;
        if (aeVar == null) {
            return false;
        }
        return aeVar.xt();
    }

    public boolean up() {
        ae aeVar = this.ae;
        if (aeVar == null) {
            return false;
        }
        return aeVar.j();
    }

    private boolean tl() {
        if (!g() || !xt(this.f31326r) || this.up.xt()) {
            return false;
        }
        return true;
    }
}
