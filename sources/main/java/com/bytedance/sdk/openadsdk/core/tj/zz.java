package com.bytedance.sdk.openadsdk.core.tj;

/* loaded from: D:\Downloads\app\classes4.dex */
public class zz {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30506j;

    /* renamed from: r, reason: collision with root package name */
    private int f30507r = 1;
    private int up = 0;
    private int xt;

    public int cw() {
        return this.cw;
    }

    public int j() {
        return this.f30506j;
    }

    public int r() {
        return this.f30507r == 2 ? 2 : 1;
    }

    public int up() {
        return this.up;
    }

    public int xt() {
        return this.xt;
    }

    public void cw(int i6) {
        if (i6 > 0 && i6 < m()) {
            this.cw = i6;
            return;
        }
        int i7 = this.f30506j;
        if (i7 == 3 || i7 == 4) {
            this.cw = 30;
        } else {
            this.cw = 16;
        }
    }

    public void j(int i6) {
        if (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4) {
            this.f30506j = i6;
        } else {
            this.f30506j = 2;
        }
    }

    public void r(int i6) {
        this.f30507r = i6;
    }

    public void up(int i6) {
        this.up = i6;
    }

    public void xt(int i6) {
        if (i6 <= 0 || i6 >= ae()) {
            this.xt = 16;
        } else {
            this.xt = i6;
        }
    }

    private int ae() {
        return com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext()));
    }

    private int m() {
        return com.bytedance.sdk.openadsdk.core.rn.ed.r(com.bytedance.sdk.openadsdk.core.v.getContext(), com.bytedance.sdk.openadsdk.core.rn.ed.up(com.bytedance.sdk.openadsdk.core.v.getContext()));
    }

    public static boolean j(n nVar) {
        return (nVar == null || nVar.pq() == null || nVar.pq().up() != 1) ? false : true;
    }
}
