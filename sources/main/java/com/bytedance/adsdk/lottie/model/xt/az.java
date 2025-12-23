package com.bytedance.adsdk.lottie.model.xt;

import android.graphics.Path;

/* loaded from: D:\Downloads\app\classes3.dex */
public class az implements cw {
    private final String cw;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f23448j;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f23449m;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.j f23450r;
    private final com.bytedance.adsdk.lottie.model.j.r up;
    private final Path.FillType xt;

    public String j() {
        return this.cw;
    }

    public com.bytedance.adsdk.lottie.model.j.r cw() {
        return this.up;
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new com.bytedance.adsdk.lottie.j.j.ae(tlVar, cwVar, this);
    }

    public Path.FillType r() {
        return this.xt;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f23448j + '}';
    }

    public boolean up() {
        return this.f23449m;
    }

    public com.bytedance.adsdk.lottie.model.j.j xt() {
        return this.f23450r;
    }

    public az(String str, boolean z5, Path.FillType fillType, com.bytedance.adsdk.lottie.model.j.j jVar, com.bytedance.adsdk.lottie.model.j.r rVar, boolean z6) {
        this.cw = str;
        this.f23448j = z5;
        this.xt = fillType;
        this.f23450r = jVar;
        this.up = rVar;
        this.f23449m = z6;
    }
}
