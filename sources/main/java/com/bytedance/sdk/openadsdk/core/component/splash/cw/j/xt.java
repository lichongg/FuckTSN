package com.bytedance.sdk.openadsdk.core.component.splash.cw.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.aq;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.rr;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {
    private int ae;

    /* renamed from: g, reason: collision with root package name */
    private int f28683g;
    private boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private int f28684m;
    private boolean oq;
    private com.bytedance.sdk.openadsdk.core.tj.j qv;

    /* renamed from: r, reason: collision with root package name */
    private int f28685r;
    private com.bykv.vk.openvk.component.video.api.cw.cw tl;
    private com.bytedance.sdk.openadsdk.ws.xt up;
    private boolean vl;

    private boolean j(aq aqVar) {
        return aqVar != null && j(aqVar.tl()) == 2;
    }

    private void m(n nVar) {
        this.tl = ln.ws(nVar);
        this.f28683g = uf.g(nVar);
        this.oq = nVar.ih();
    }

    private void up(n nVar) {
        h hVar;
        if (nVar.fp() == null || (hVar = nVar.fp().get(0)) == null) {
            return;
        }
        String j6 = hVar.j();
        if (TextUtils.isEmpty(j6)) {
            return;
        }
        this.f28684m = hVar.xt();
        this.ae = hVar.cw();
        this.up = new com.bytedance.sdk.openadsdk.ws.xt(j6, hVar.ae());
    }

    private void xt(n nVar) {
        int wf = nVar.wf();
        aq m6 = hh.m(nVar);
        rr ae = hh.ae(nVar);
        if (TextUtils.isEmpty(ln.j(nVar))) {
            this.f28685r = 1;
        } else if (cw(nVar)) {
            if (j(m6) || j(ae)) {
                this.f28685r = 2;
            } else {
                if (xt(m6) || xt(ae)) {
                    hh.j(nVar, 1);
                }
                this.f28685r = 1;
            }
        } else if (wf == 1) {
            this.f28685r = 1;
        } else {
            this.f28685r = 2;
        }
        r(nVar);
    }

    public boolean r() {
        return this.f28685r == 2;
    }

    private boolean j(rr rrVar) {
        return rrVar != null && rrVar.ae() == 2;
    }

    private void r(n nVar) {
        up(nVar);
        m(nVar);
    }

    public int ae() {
        return this.ae;
    }

    public int g() {
        return this.f28683g;
    }

    public boolean jy() {
        return this.vl;
    }

    public boolean oq() {
        return this.oq;
    }

    public int qv() {
        return this.f28685r;
    }

    public com.bykv.vk.openvk.component.video.api.cw.cw tl() {
        return this.tl;
    }

    public com.bytedance.sdk.openadsdk.core.tj.j vl() {
        return this.qv;
    }

    public boolean ws() {
        return this.jy;
    }

    public xt(n nVar, boolean z5) {
        boolean z6;
        if (nVar == null) {
            return;
        }
        this.xt = nVar;
        this.jy = z5;
        if (hh.j(nVar) == 2) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.vl = z6;
        xt(nVar);
    }

    private boolean cw(n nVar) {
        if (hh.j(nVar) == 2) {
            return true;
        }
        return false;
    }

    private int j(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int m() {
        return this.f28684m;
    }

    public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar) {
        this.qv = jVar;
    }

    public void j(boolean z5) {
        this.jy = z5;
    }

    public com.bytedance.sdk.openadsdk.ws.xt up() {
        return this.up;
    }

    private boolean xt(aq aqVar) {
        return aqVar != null && j(aqVar.tl()) == 0;
    }

    private boolean xt(rr rrVar) {
        return rrVar != null && rrVar.ae() == 0;
    }
}
