package com.bytedance.adsdk.lottie.model.xt;

import android.graphics.PointF;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq implements cw {
    private final com.bytedance.adsdk.lottie.model.j.xt ae;
    private final com.bytedance.adsdk.lottie.model.j.xt cw;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.xt f23469g;

    /* renamed from: j, reason: collision with root package name */
    private final String f23470j;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.xt f23471m;
    private final boolean oq;
    private final boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> f23472r;
    private final com.bytedance.adsdk.lottie.model.j.xt tl;
    private final com.bytedance.adsdk.lottie.model.j.xt up;
    private final j xt;

    public String j() {
        return this.f23470j;
    }

    public enum j {
        STAR(1),
        POLYGON(2);

        private final int cw;

        j(int i6) {
            this.cw = i6;
        }

        public static j j(int i6) {
            for (j jVar : values()) {
                if (jVar.cw == i6) {
                    return jVar;
                }
            }
            return null;
        }
    }

    public com.bytedance.adsdk.lottie.model.j.xt ae() {
        return this.tl;
    }

    public com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> cw() {
        return this.f23472r;
    }

    public boolean g() {
        return this.oq;
    }

    public j getType() {
        return this.xt;
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new com.bytedance.adsdk.lottie.j.j.ws(tlVar, cwVar, this);
    }

    public com.bytedance.adsdk.lottie.model.j.xt m() {
        return this.ae;
    }

    public boolean oq() {
        return this.qv;
    }

    public com.bytedance.adsdk.lottie.model.j.xt r() {
        return this.up;
    }

    public com.bytedance.adsdk.lottie.model.j.xt tl() {
        return this.f23469g;
    }

    public com.bytedance.adsdk.lottie.model.j.xt up() {
        return this.f23471m;
    }

    public com.bytedance.adsdk.lottie.model.j.xt xt() {
        return this.cw;
    }

    public oq(String str, j jVar, com.bytedance.adsdk.lottie.model.j.xt xtVar, com.bytedance.adsdk.lottie.model.j.jy<PointF, PointF> jyVar, com.bytedance.adsdk.lottie.model.j.xt xtVar2, com.bytedance.adsdk.lottie.model.j.xt xtVar3, com.bytedance.adsdk.lottie.model.j.xt xtVar4, com.bytedance.adsdk.lottie.model.j.xt xtVar5, com.bytedance.adsdk.lottie.model.j.xt xtVar6, boolean z5, boolean z6) {
        this.f23470j = str;
        this.xt = jVar;
        this.cw = xtVar;
        this.f23472r = jyVar;
        this.up = xtVar2;
        this.f23471m = xtVar3;
        this.ae = xtVar4;
        this.tl = xtVar5;
        this.f23469g = xtVar6;
        this.oq = z5;
        this.qv = z6;
    }
}
