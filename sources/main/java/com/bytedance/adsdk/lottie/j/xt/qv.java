package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv extends ae<PointF> {

    /* renamed from: r, reason: collision with root package name */
    private final PointF f23312r;

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public PointF j(com.bytedance.adsdk.lottie.m.j<PointF> jVar, float f6) {
        return j(jVar, f6, f6, f6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public PointF j(com.bytedance.adsdk.lottie.m.j<PointF> jVar, float f6, float f7, float f8) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = jVar.f23337j;
        if (pointF3 == null || (pointF = jVar.xt) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.bytedance.adsdk.lottie.m.cw<A> cwVar = this.cw;
        if (cwVar != 0 && (pointF2 = (PointF) cwVar.j(jVar.f23338m, jVar.ae.floatValue(), pointF4, pointF5, f6, r(), tl())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f23312r;
        float f9 = pointF4.x;
        float f10 = f9 + (f7 * (pointF5.x - f9));
        float f11 = pointF4.y;
        pointF6.set(f10, f11 + (f8 * (pointF5.y - f11)));
        return this.f23312r;
    }

    public qv(List<com.bytedance.adsdk.lottie.m.j<PointF>> list) {
        super(list);
        this.f23312r = new PointF();
    }
}
