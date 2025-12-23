package com.bytedance.adsdk.lottie.model.xt;

import android.graphics.PointF;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv implements cw {
    private final com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f23475j;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.xt f23476r;
    private final boolean up;
    private final com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> xt;

    public String j() {
        return this.f23475j;
    }

    public com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> cw() {
        return this.cw;
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new com.bytedance.adsdk.lottie.j.j.az(tlVar, cwVar, this);
    }

    public com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> r() {
        return this.xt;
    }

    public String toString() {
        return "RectangleShape{position=" + this.xt + ", size=" + this.cw + '}';
    }

    public boolean up() {
        return this.up;
    }

    public com.bytedance.adsdk.lottie.model.j.xt xt() {
        return this.f23476r;
    }

    public qv(String str, com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> jyVar, com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> jyVar2, com.bytedance.adsdk.lottie.model.j.xt xtVar, boolean z5) {
        this.f23475j = str;
        this.xt = jyVar;
        this.cw = jyVar2;
        this.f23476r = xtVar;
        this.up = z5;
    }
}
