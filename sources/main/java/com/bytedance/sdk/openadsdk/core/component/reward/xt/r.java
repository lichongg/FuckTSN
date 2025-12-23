package com.bytedance.sdk.openadsdk.core.component.reward.xt;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private n cw;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f28520j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28521m = false;

    /* renamed from: r, reason: collision with root package name */
    private xt f28522r;
    private up up;
    private final TTBaseVideoActivity xt;

    public void j(xt xtVar, n nVar, String str, up upVar) {
        if (this.f28521m) {
            return;
        }
        this.f28521m = true;
        this.f28522r = xtVar;
        this.cw = nVar;
        this.up = upVar;
    }

    public void xt() {
        if (tj.xt(this.cw)) {
            if (this.f28522r.rn() || r()) {
                boolean z5 = !this.f28520j;
                this.f28520j = z5;
                this.f28522r.j(z5);
            }
        }
    }

    public void cw() {
        this.f28522r.a();
        this.up.j(this.xt.e().ya());
    }

    public boolean m() {
        return this.f28520j;
    }

    public boolean r() {
        xt xtVar = this.f28522r;
        if (xtVar != null) {
            return xtVar.p();
        }
        return false;
    }

    public boolean up() {
        if (tj.cw(this.cw)) {
            return this.f28522r.gq();
        }
        return false;
    }

    public r(TTBaseVideoActivity tTBaseVideoActivity) {
        this.xt = tTBaseVideoActivity;
    }

    public void xt(boolean z5) {
        this.f28522r.m(z5);
    }

    public void j() {
        if (tj.xt(this.cw) && !this.f28522r.rn()) {
            r();
        }
    }

    public void j(boolean z5) {
        xt xtVar = this.f28522r;
        if (xtVar != null && xtVar.l()) {
            this.f28520j = z5;
            this.up.r(z5);
            this.f28522r.j(this.f28520j);
        }
    }

    public void j(boolean z5, boolean z6) {
        this.f28522r.x();
        j(z5);
        xt(z6);
    }

    public void j(int i6, int i7) {
        this.f28522r.xt(i6, i7);
    }

    public void j(n nVar) {
        this.cw = nVar;
    }
}
