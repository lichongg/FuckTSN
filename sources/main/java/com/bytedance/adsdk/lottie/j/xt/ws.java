package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws extends j<PointF, PointF> {
    private final PointF ae;

    /* renamed from: g, reason: collision with root package name */
    private final j<Float, Float> f23316g;

    /* renamed from: m, reason: collision with root package name */
    private final PointF f23317m;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.adsdk.lottie.m.cw<Float> f23318r;
    private final j<Float, Float> tl;
    protected com.bytedance.adsdk.lottie.m.cw<Float> up;

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public PointF ae() {
        return j(null, 0.0f);
    }

    public ws(j<Float, Float> jVar, j<Float, Float> jVar2) {
        super(Collections.EMPTY_LIST);
        this.f23317m = new PointF();
        this.ae = new PointF();
        this.tl = jVar;
        this.f23316g = jVar2;
        j(tl());
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    public void j(float f6) {
        this.tl.j(f6);
        this.f23316g.j(f6);
        this.f23317m.set(this.tl.ae().floatValue(), this.f23316g.ae().floatValue());
        for (int i6 = 0; i6 < this.f23302j.size(); i6++) {
            this.f23302j.get(i6).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public PointF j(com.bytedance.adsdk.lottie.m.j<PointF> jVar, float f6) {
        float f7;
        Float f8;
        com.bytedance.adsdk.lottie.m.j<Float> cw;
        com.bytedance.adsdk.lottie.m.j<Float> cw2;
        Float f9 = null;
        if (this.f23318r == null || (cw2 = this.tl.cw()) == null) {
            f7 = f6;
            f8 = null;
        } else {
            float up = this.tl.up();
            Float f10 = cw2.ae;
            com.bytedance.adsdk.lottie.m.cw<Float> cwVar = this.f23318r;
            float f11 = cw2.f23338m;
            f7 = f6;
            f8 = cwVar.j(f11, f10 == null ? f11 : f10.floatValue(), cw2.f23337j, cw2.xt, f6, f6, up);
        }
        if (this.up != null && (cw = this.f23316g.cw()) != null) {
            float up2 = this.f23316g.up();
            Float f12 = cw.ae;
            com.bytedance.adsdk.lottie.m.cw<Float> cwVar2 = this.up;
            float f13 = cw.f23338m;
            f9 = cwVar2.j(f13, f12 == null ? f13 : f12.floatValue(), cw.f23337j, cw.xt, f7, f7, up2);
        }
        if (f8 == null) {
            this.ae.set(this.f23317m.x, 0.0f);
        } else {
            this.ae.set(f8.floatValue(), 0.0f);
        }
        if (f9 == null) {
            PointF pointF = this.ae;
            pointF.set(pointF.x, this.f23317m.y);
        } else {
            PointF pointF2 = this.ae;
            pointF2.set(pointF2.x, f9.floatValue());
        }
        return this.ae;
    }
}
