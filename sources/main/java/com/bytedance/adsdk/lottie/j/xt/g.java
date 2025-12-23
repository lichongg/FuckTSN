package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends com.bytedance.adsdk.lottie.m.j<PointF> {
    private Path oq;
    private final com.bytedance.adsdk.lottie.m.j<PointF> qv;

    public g(com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.m.j<PointF> jVar) {
        super(mVar, jVar.f23337j, jVar.xt, jVar.cw, jVar.f23339r, jVar.up, jVar.f23338m, jVar.ae);
        this.qv = jVar;
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        T t5;
        T t6;
        T t7 = this.xt;
        boolean z5 = (t7 == 0 || (t6 = this.f23337j) == 0 || !((PointF) t6).equals(((PointF) t7).x, ((PointF) t7).y)) ? false : true;
        T t8 = this.f23337j;
        if (t8 == 0 || (t5 = this.xt) == 0 || z5) {
            return;
        }
        com.bytedance.adsdk.lottie.m.j<PointF> jVar = this.qv;
        this.oq = com.bytedance.adsdk.lottie.up.g.j((PointF) t8, (PointF) t5, jVar.tl, jVar.f23336g);
    }

    Path xt() {
        return this.oq;
    }
}
