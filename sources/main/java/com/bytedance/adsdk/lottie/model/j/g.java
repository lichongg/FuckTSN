package com.bytedance.adsdk.lottie.model.j;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements jy<PointF, PointF> {

    /* renamed from: j, reason: collision with root package name */
    private final xt f23357j;
    private final xt xt;

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public List<com.bytedance.adsdk.lottie.m.j<PointF>> cw() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j() {
        return new com.bytedance.adsdk.lottie.j.xt.ws(this.f23357j.j(), this.xt.j());
    }

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public boolean xt() {
        return this.f23357j.xt() && this.xt.xt();
    }

    public g(xt xtVar, xt xtVar2) {
        this.f23357j = xtVar;
        this.xt = xtVar2;
    }
}
