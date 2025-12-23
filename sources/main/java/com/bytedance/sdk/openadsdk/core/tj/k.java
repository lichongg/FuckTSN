package com.bytedance.sdk.openadsdk.core.tj;

/* loaded from: D:\Downloads\app\classes4.dex */
public class k {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30310j;
    private int xt;

    public int cw() {
        return this.cw;
    }

    public int j() {
        return this.f30310j;
    }

    public int xt() {
        return this.xt;
    }

    public void cw(int i6) {
        if (i6 > 0 && i6 < r()) {
            this.cw = i6;
            return;
        }
        int i7 = this.f30310j;
        if (i7 == 1) {
            this.cw = 90;
        } else if (i7 == 2) {
            this.cw = 150;
        }
    }

    public void j(int i6) {
        if (i6 != 1 && i6 != 2) {
            i6 = 0;
        }
        this.f30310j = i6;
    }

    public void xt(int i6) {
        if (i6 > 0 && i6 < r()) {
            this.xt = i6;
            return;
        }
        int i7 = this.f30310j;
        if (i7 == 1) {
            this.xt = 90;
        } else if (i7 == 2) {
            this.xt = 150;
        }
    }

    private int r() {
        return com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), com.bytedance.sdk.openadsdk.core.rn.ed.up(com.bytedance.sdk.openadsdk.core.v.getContext()));
    }
}
