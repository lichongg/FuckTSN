package com.bytedance.sdk.openadsdk.core.component.splash.cw.cw;

import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private r<g, ae> cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.r.xt f28645j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.xt.xt f28646r;
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw xt;

    public void j(int i6) {
        com.bytedance.sdk.openadsdk.core.component.splash.r.xt xtVar = this.f28645j;
        if (xtVar != null) {
            xtVar.xt(i6);
        }
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.core.component.splash.r.xt xtVar = this.f28645j;
        if (xtVar != null) {
            xtVar.j(this.xt, this.cw);
        }
    }

    public j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw cwVar, r<g, ae> rVar, com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar) {
        if (cwVar != null && rVar != null) {
            this.xt = cwVar;
            this.cw = rVar;
            com.bytedance.sdk.openadsdk.core.component.splash.r.xt xtVar = new com.bytedance.sdk.openadsdk.core.component.splash.r.xt(cwVar.getContext(), cwVar.ae(), cwVar.m(), this.xt.tl(), cwVar, rVar, jVar);
            this.f28645j = xtVar;
            this.f28646r = xtVar;
        }
    }

    public void j(m mVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw cwVar = this.xt;
        if (cwVar == null || cwVar.f28666r == null || mVar == null) {
            return;
        }
        boolean j6 = mVar.j();
        this.xt.f28666r.j(j6);
        com.bytedance.sdk.openadsdk.core.component.splash.r.xt xtVar = this.f28645j;
        if (xtVar != null) {
            xtVar.xt(j6);
        }
    }

    public com.bytedance.sdk.openadsdk.i.cw.xt.xt j() {
        return this.f28646r;
    }
}
