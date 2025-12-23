package com.bytedance.sdk.openadsdk.core.up.up;

import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    protected tl.j f30931j;
    protected int xt;
    protected com.bytedance.sdk.openadsdk.core.up.cw.j cw = xt();

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.up.j.xt f30932r = cw();

    public static tl.j j(int i6) {
        if (i6 == 7) {
            return tl.j();
        }
        if (i6 != 8) {
            return null;
        }
        return tl.xt();
    }

    private com.bytedance.sdk.openadsdk.core.up.j.xt cw() {
        int i6 = this.xt;
        if (i6 == 7) {
            return new com.bytedance.sdk.openadsdk.core.up.j.cw(this);
        }
        if (i6 != 8) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.up.j.j(this);
    }

    private int r() {
        tl.j jVar = this.f30931j;
        if (jVar == null) {
            return -2;
        }
        if (jVar.ae() && v.xt().vm()) {
            return this.f30931j.r();
        }
        return -1;
    }

    public xt(int i6) {
        this.xt = i6;
        this.f30931j = j(i6);
    }

    private com.bytedance.sdk.openadsdk.core.up.cw.j xt() {
        int r5 = r();
        if (r5 != -1) {
            if (r5 != 0) {
                if (r5 != 1) {
                    if (r5 != 3) {
                        return j.xt(this.xt);
                    }
                    return new com.bytedance.sdk.openadsdk.core.up.cw.r(this.xt);
                }
                return new com.bytedance.sdk.openadsdk.core.up.cw.up(this.xt);
            }
            return new com.bytedance.sdk.openadsdk.core.up.cw.xt(this.xt);
        }
        return new com.bytedance.sdk.openadsdk.core.up.cw.cw(this.xt);
    }

    protected boolean j(n nVar) {
        return com.bytedance.sdk.openadsdk.core.live.xt.j().cw(nVar) != 3;
    }

    public com.bytedance.sdk.openadsdk.core.up.cw.j j() {
        return this.cw;
    }
}
