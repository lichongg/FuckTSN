package com.bytedance.adsdk.lottie.model.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public class i implements cw {
    private final com.bytedance.adsdk.lottie.model.j.tl cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f23455j;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f23456r;
    private final int xt;

    public String j() {
        return this.f23455j;
    }

    public boolean cw() {
        return this.f23456r;
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new com.bytedance.adsdk.lottie.j.j.w(tlVar, cwVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.f23455j + ", index=" + this.xt + '}';
    }

    public com.bytedance.adsdk.lottie.model.j.tl xt() {
        return this.cw;
    }

    public i(String str, int i6, com.bytedance.adsdk.lottie.model.j.tl tlVar, boolean z5) {
        this.f23455j = str;
        this.xt = i6;
        this.cw = tlVar;
        this.f23456r = z5;
    }
}
