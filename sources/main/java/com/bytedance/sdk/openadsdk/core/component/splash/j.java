package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.core.h;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.r.j.xt.j.xt f28686j;

    public void j(com.bytedance.sdk.openadsdk.r.j.xt.j.xt xtVar) {
        this.f28686j = xtVar;
    }

    public boolean cw() {
        return h.xt < 4700 || this.f28686j == null;
    }

    public void j() {
        com.bytedance.sdk.openadsdk.r.j.xt.j.xt xtVar;
        if (h.xt < 4700 || (xtVar = this.f28686j) == null) {
            return;
        }
        xtVar.xt();
        this.f28686j = null;
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.r.j.xt.j.xt xtVar;
        if (h.xt < 4700 || (xtVar = this.f28686j) == null) {
            return;
        }
        xtVar.j();
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        com.bytedance.sdk.openadsdk.r.j.xt.j.xt xtVar2;
        if (h.xt < 4700 || (xtVar2 = this.f28686j) == null) {
            return;
        }
        xtVar2.j(xtVar);
    }
}
