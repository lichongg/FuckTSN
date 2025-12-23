package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq extends ae<PointF> {
    private g ae;

    /* renamed from: m, reason: collision with root package name */
    private final PathMeasure f23310m;

    /* renamed from: r, reason: collision with root package name */
    private final PointF f23311r;
    private final float[] up;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public PointF j(com.bytedance.adsdk.lottie.m.j<PointF> jVar, float f6) {
        float f7;
        g gVar = (g) jVar;
        Path xt = gVar.xt();
        if (xt == null) {
            return jVar.f23337j;
        }
        com.bytedance.adsdk.lottie.m.cw<A> cwVar = this.cw;
        if (cwVar != 0) {
            f7 = f6;
            PointF pointF = (PointF) cwVar.j(gVar.f23338m, gVar.ae.floatValue(), gVar.f23337j, gVar.xt, r(), f7, tl());
            if (pointF != null) {
                return pointF;
            }
        } else {
            f7 = f6;
        }
        if (this.ae != gVar) {
            this.f23310m.setPath(xt, false);
            this.ae = gVar;
        }
        PathMeasure pathMeasure = this.f23310m;
        pathMeasure.getPosTan(pathMeasure.getLength() * f7, this.up, null);
        PointF pointF2 = this.f23311r;
        float[] fArr = this.up;
        pointF2.set(fArr[0], fArr[1]);
        return this.f23311r;
    }

    public oq(List<? extends com.bytedance.adsdk.lottie.m.j<PointF>> list) {
        super(list);
        this.f23311r = new PointF();
        this.up = new float[2];
        this.f23310m = new PathMeasure();
    }
}
