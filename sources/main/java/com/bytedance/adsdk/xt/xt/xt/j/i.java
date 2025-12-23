package com.bytedance.adsdk.xt.xt.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class i implements com.bytedance.adsdk.xt.xt.xt.j {
    protected com.bytedance.adsdk.xt.xt.r.cw cw;

    /* renamed from: j, reason: collision with root package name */
    protected com.bytedance.adsdk.xt.xt.xt.j f23971j;
    protected com.bytedance.adsdk.xt.xt.xt.j xt;

    public void j(com.bytedance.adsdk.xt.xt.xt.j jVar) {
        this.f23971j = jVar;
    }

    public void xt(com.bytedance.adsdk.xt.xt.xt.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public com.bytedance.adsdk.xt.xt.r.up j() {
        return com.bytedance.adsdk.xt.xt.r.m.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public String xt() {
        return this.f23971j.xt() + this.cw.j() + this.xt.xt();
    }

    protected i(com.bytedance.adsdk.xt.xt.r.cw cwVar) {
        this.cw = cwVar;
    }

    public String toString() {
        return xt();
    }
}
