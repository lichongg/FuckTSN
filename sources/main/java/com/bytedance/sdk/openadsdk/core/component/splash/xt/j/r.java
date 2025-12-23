package com.bytedance.sdk.openadsdk.core.component.splash.xt.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.up;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.g;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements com.bytedance.sdk.openadsdk.core.component.splash.cw.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private ae f28804j = new ae();

    private void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw<tl, ae> cwVar) {
        if (xtVar == null || cwVar == null) {
            return;
        }
        this.f28804j.xt(xtVar.ws());
        this.f28804j.j(xtVar.xt());
        int g6 = xtVar.g();
        com.bykv.vk.openvk.component.video.api.cw.cw tl = xtVar.tl();
        this.f28804j.j(true);
        if (tl == null) {
            this.f28804j.xt(2);
            this.f28804j.j("no video info");
            cwVar.j(this.f28804j);
            return;
        }
        String vl = tl.vl();
        if (TextUtils.isEmpty(vl)) {
            this.f28804j.xt(2);
            this.f28804j.j("no video url");
            cwVar.j(this.f28804j);
            return;
        }
        String az = tl.az();
        if (TextUtils.isEmpty(az)) {
            az = up.xt(vl);
        }
        if (TextUtils.isEmpty(az)) {
            this.f28804j.xt(2);
            this.f28804j.j("no video cahce filename");
            cwVar.j(this.f28804j);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "加载视频素材");
        n xt = xtVar.xt();
        if (xt == null) {
            return;
        }
        boolean oq = xtVar.oq();
        tl.up(1);
        if (tl.av() == 0) {
            tl.r(307200);
        }
        com.bykv.vk.openvk.component.video.api.cw.r j6 = oq ? ln.j(2, xt) : ln.j(3, xt);
        j6.j("material_meta", xt);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (g.j(xt.ly()).j(j6)) {
            tl tlVar = new tl(xtVar.xt(), xtVar.ws());
            tlVar.j(true);
            tlVar.cw(true);
            tlVar.j(xtVar.j());
            tlVar.up(xtVar.cw());
            cwVar.xt(tlVar);
            j6.g(1);
            com.bytedance.sdk.openadsdk.core.video.r.xt.j(j6, xt, SystemClock.elapsedRealtime() - elapsedRealtime);
            return;
        }
        if (v.xt().tl(String.valueOf(g6)) && !ws.r(v.getContext())) {
            this.f28804j.xt(2);
            this.f28804j.j("network error");
            cwVar.j(this.f28804j);
        } else {
            if (xtVar.xt() == null || xtVar.xt().wf() != 3) {
                com.bykv.vk.openvk.component.video.j.j.j();
                j(j6, xtVar, xtVar.xt(), cwVar);
                return;
            }
            tl tlVar2 = new tl(xtVar.xt(), xtVar.ws());
            tlVar2.j(true);
            tlVar2.cw(false);
            tlVar2.j(xtVar.j());
            tlVar2.up(xtVar.cw());
            tlVar2.j(ln.j(xtVar.xt()));
            cwVar.xt(tlVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.xt.j
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw<tl, ae> cwVar) {
        xt(xtVar, cwVar);
    }

    private void j(com.bykv.vk.openvk.component.video.api.cw.r rVar, final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar, n nVar, final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw<tl, ae> cwVar) {
        if (nVar == null || cwVar == null || xtVar == null || rVar == null || ln.ws(nVar) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.r.xt.j(rVar, new com.bykv.vk.openvk.component.video.api.up.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xt.j.r.1
            @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
            public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar2, int i6) {
                if (cwVar != null) {
                    tl tlVar = new tl(xtVar.xt(), xtVar.ws());
                    tlVar.j(true);
                    tlVar.cw(false);
                    tlVar.j((com.bytedance.sdk.component.g.xt) null);
                    tlVar.j(xtVar.j());
                    tlVar.up(xtVar.cw());
                    cwVar.xt(tlVar);
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
            public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar2, int i6, String str) {
                if (cwVar != null) {
                    r.this.f28804j.xt(2);
                    r.this.f28804j.j("preload video fail");
                    cwVar.j(r.this.f28804j);
                }
            }
        });
    }
}
