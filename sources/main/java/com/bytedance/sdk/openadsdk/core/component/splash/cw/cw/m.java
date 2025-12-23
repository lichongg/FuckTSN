package com.bytedance.sdk.openadsdk.core.component.splash.cw.cw;

import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl;
import com.bytedance.sdk.openadsdk.core.tj.hh;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private cw<tl, ae> cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.xt.j f28647j;
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xt;

    public boolean j() {
        return this.f28647j instanceof com.bytedance.sdk.openadsdk.core.component.splash.xt.j.r;
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar = this.xt;
        if (xtVar == null || this.cw == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.cw.xt.j jVar = this.f28647j;
        if (jVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.xt.j.xt) {
            jVar.j(xtVar, new cw<tl, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.m.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void cw(tl tlVar) {
                    if (tlVar != null) {
                        tlVar.up(false);
                    }
                    m.this.cw.cw(tlVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
                public void xt(tl tlVar) {
                    if (tlVar != null) {
                        tlVar.up(true);
                    }
                    m.this.cw.xt(tlVar);
                    com.bytedance.sdk.openadsdk.core.component.splash.m.j(m.this.xt.vl());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
                public void j(ae aeVar) {
                    m.this.cw.j(aeVar);
                }
            });
        } else {
            jVar.j(xtVar, new cw<tl, ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.m.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public void cw(tl tlVar) {
                    if (tlVar != null) {
                        tlVar.up(false);
                    }
                    m.this.cw.cw(tlVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
                public void xt(tl tlVar) {
                    if (tlVar != null) {
                        tlVar.up(true);
                    }
                    m.this.cw.xt(tlVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
                public void j(ae aeVar) {
                    if (m.this.xt.jy() && m.this.xt.xt() != null) {
                        hh.j(m.this.xt.xt(), 1);
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.xt().j(m.this.xt, m.this.cw);
                }
            });
        }
    }

    public m(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar, cw<tl, ae> cwVar) {
        if (xtVar != null && cwVar != null) {
            this.xt = xtVar;
            this.cw = cwVar;
            if (xtVar.qv() == 1) {
                this.f28647j = new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.xt();
            } else {
                this.f28647j = new com.bytedance.sdk.openadsdk.core.component.splash.xt.j.r();
            }
        }
    }
}
