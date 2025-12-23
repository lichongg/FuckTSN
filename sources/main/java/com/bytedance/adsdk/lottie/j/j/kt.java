package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* loaded from: D:\Downloads\app\classes3.dex */
public class kt extends j {
    private final com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> ae;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f23263m;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.cw f23264r;
    private com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> tl;
    private final String up;

    @Override // com.bytedance.adsdk.lottie.j.j.j, com.bytedance.adsdk.lottie.j.j.up
    public void j(Canvas canvas, Matrix matrix, int i6) {
        if (this.f23263m) {
            return;
        }
        this.xt.setColor(((com.bytedance.adsdk.lottie.j.xt.xt) this.ae).g());
        com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> jVar = this.tl;
        if (jVar != null) {
            this.xt.setColorFilter(jVar.ae());
        }
        super.j(canvas, matrix, i6);
    }

    public kt(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.w wVar) {
        super(tlVar, cwVar, wVar.ae().j(), wVar.tl().j(), wVar.g(), wVar.cw(), wVar.r(), wVar.up(), wVar.m());
        this.f23264r = cwVar;
        this.up = wVar.j();
        this.f23263m = wVar.oq();
        com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> j6 = wVar.xt().j();
        this.ae = j6;
        j6.j(this);
        cwVar.j(j6);
    }
}
