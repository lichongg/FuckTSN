package com.bytedance.sdk.openadsdk.core.component.splash.xt.j;

import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.m.ws;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl;
import com.bytedance.sdk.openadsdk.core.rn.av;
import com.bytedance.sdk.openadsdk.core.rn.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.g;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.openadsdk.core.component.splash.cw.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private ae f28806j = new ae();

    private void xt(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar, final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw<tl, ae> cwVar) {
        if (xtVar == null || cwVar == null) {
            return;
        }
        this.f28806j.xt(xtVar.ws());
        this.f28806j.j(xtVar.xt());
        if (v.xt().g(xtVar.g()) == 4) {
            tl tlVar = new tl(xtVar.xt(), xtVar.ws());
            tlVar.j(false);
            tlVar.j(xtVar.j());
            tlVar.j(xtVar.cw());
            cwVar.xt(tlVar);
            return;
        }
        com.bytedance.sdk.openadsdk.ws.xt up = xtVar.up();
        if (up == null) {
            this.f28806j.xt(2);
            this.f28806j.j("image request fail");
            this.f28806j.j(false);
            cwVar.j(this.f28806j);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "加载图片素材 " + xtVar.xt().ej());
        i.j(up, xtVar.m(), xtVar.ae(), new i.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xt.j.xt.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.i.j
            public void j(com.bytedance.sdk.openadsdk.core.v.j.xt xtVar2, qv qvVar) {
                tl tlVar2 = new tl(xtVar2, xtVar.xt(), xtVar.ws());
                tlVar2.j(false);
                tlVar2.j(xtVar.j());
                tlVar2.up(xtVar.cw());
                if (qvVar != null) {
                    tlVar2.j(qvVar.ae());
                    tlVar2.xt(qvVar.g());
                    tlVar2.xt(av.j(qvVar.ae()));
                    if (qvVar.oq() != null) {
                        tlVar2.xt(qvVar.oq().xt());
                        tlVar2.cw(qvVar.oq().j());
                        tlVar2.r(qvVar.oq().cw());
                    }
                }
                cwVar.xt(tlVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.i.j
            public void j() {
                xt.this.f28806j.xt(2);
                xt.this.f28806j.j("load image fail");
                xt.this.f28806j.j(false);
                cwVar.j(xt.this.f28806j);
            }
        }, g.up(), 4, new ws() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xt.j.xt.2
            @Override // com.bytedance.sdk.component.m.ws
            @ATSMethod(1)
            public void j(int i6, Object obj) {
                if (i6 == 3 && xt.this.j(xtVar)) {
                    tl tlVar2 = new tl(xtVar.xt(), xtVar.ws());
                    tlVar2.j(false);
                    tlVar2.j(xtVar.j());
                    tlVar2.j(xtVar.cw());
                    tlVar2.r(true);
                    tlVar2.xt(false);
                    cwVar.cw(tlVar2);
                }
            }
        }, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.xt.j
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw<tl, ae> cwVar) {
        xt(xtVar, cwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar) {
        n xt;
        if (xtVar == null || (xt = xtVar.xt()) == null) {
            return false;
        }
        int xp = xt.xp();
        return xp == 3 || xp == 4;
    }
}
