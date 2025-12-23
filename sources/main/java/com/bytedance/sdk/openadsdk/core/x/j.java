package com.bytedance.sdk.openadsdk.core.x;

import com.bytedance.sdk.openadsdk.core.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    Boolean f31307j = null;
    Boolean xt = null;
    Boolean cw = null;

    public boolean cw() {
        if (this.cw == null) {
            com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
            this.cw = Boolean.valueOf(w5 == null || w5.j());
        }
        return this.cw.booleanValue();
    }

    public boolean j() {
        if (this.f31307j == null) {
            com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
            this.f31307j = Boolean.valueOf(w5 == null || w5.cw());
        }
        return this.f31307j.booleanValue();
    }

    public boolean xt() {
        if (this.xt == null) {
            com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
            this.xt = Boolean.valueOf(w5 == null || w5.r());
        }
        return this.xt.booleanValue();
    }
}
