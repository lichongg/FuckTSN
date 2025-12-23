package com.bytedance.sdk.openadsdk.core.component.splash.cw.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends j {
    private long ae;

    /* renamed from: g, reason: collision with root package name */
    private long f28669g;

    /* renamed from: m, reason: collision with root package name */
    private long f28670m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.tj.j f28671r;
    private long tl;
    private boolean up;

    public com.bytedance.sdk.openadsdk.core.tj.j r() {
        return this.f28671r;
    }

    public boolean up() {
        return this.up;
    }

    public long ae() {
        return this.ae;
    }

    public void cw(long j6) {
        this.ae = j6;
    }

    public long g() {
        return this.f28669g;
    }

    public long m() {
        return this.f28670m;
    }

    public void r(long j6) {
        this.tl = j6;
    }

    public long tl() {
        return this.tl;
    }

    public void up(long j6) {
        this.f28669g = j6;
    }

    public void xt(long j6) {
        this.f28670m = j6;
    }

    public m(com.bytedance.sdk.openadsdk.core.tj.j jVar, boolean z5) {
        this.f28671r = jVar;
        if (jVar != null && jVar.xt() != null && !this.f28671r.xt().isEmpty()) {
            this.xt = this.f28671r.xt().get(0);
        }
        this.up = z5;
    }
}
