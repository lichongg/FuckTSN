package com.bytedance.sdk.openadsdk.core.qv.cw.cw;

import com.bytedance.sdk.openadsdk.core.tj.tj;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {
    private boolean up = false;

    /* renamed from: m, reason: collision with root package name */
    private int f29898m = 0;
    private boolean ae = false;

    public void cw(boolean z5) {
        this.ae = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.cw.j
    protected boolean cw() {
        this.cw = 1;
        boolean z5 = m.f29897r;
        int vl = tj.vl(this.xt);
        if (z5) {
            vl = 0;
            m.f29897r = false;
        }
        if (this.ae) {
            return r();
        }
        if (this.up) {
            int i6 = this.f29898m;
            if (i6 == 2) {
                return r();
            }
            if (vl == 2 && i6 == 1) {
                return r();
            }
        }
        if (vl == 0) {
            return r();
        }
        return true;
    }

    public void j(int i6) {
        this.f29898m = i6;
    }

    public void xt(boolean z5) {
        this.up = z5;
    }
}
