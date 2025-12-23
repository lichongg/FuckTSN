package com.bytedance.adsdk.lottie.model.xt;

import android.graphics.PointF;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements cw {
    private final com.bytedance.adsdk.lottie.model.j.m cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f23498j;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f23499r;
    private final boolean up;
    private final com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> xt;

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new com.bytedance.adsdk.lottie.j.j.m(tlVar, cwVar, this);
    }

    public com.bytedance.adsdk.lottie.model.j.m cw() {
        return this.cw;
    }

    public String j() {
        return this.f23498j;
    }

    public boolean r() {
        return this.f23499r;
    }

    public boolean up() {
        return this.up;
    }

    public com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> xt() {
        return this.xt;
    }

    public xt(String str, com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> jyVar, com.bytedance.adsdk.lottie.model.j.m mVar, boolean z5, boolean z6) {
        this.f23498j = str;
        this.xt = jyVar;
        this.cw = mVar;
        this.f23499r = z5;
        this.up = z6;
    }
}
