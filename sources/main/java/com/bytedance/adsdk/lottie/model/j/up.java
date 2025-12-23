package com.bytedance.adsdk.lottie.model.j;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements jy<PointF, PointF> {

    /* renamed from: j, reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.m.j<PointF>> f23360j;

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public List<com.bytedance.adsdk.lottie.m.j<PointF>> cw() {
        return this.f23360j;
    }

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j() {
        return this.f23360j.get(0).up() ? new com.bytedance.adsdk.lottie.j.xt.qv(this.f23360j) : new com.bytedance.adsdk.lottie.j.xt.oq(this.f23360j);
    }

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public boolean xt() {
        return this.f23360j.size() == 1 && this.f23360j.get(0).up();
    }

    public up(List<com.bytedance.adsdk.lottie.m.j<PointF>> list) {
        this.f23360j = list;
    }
}
