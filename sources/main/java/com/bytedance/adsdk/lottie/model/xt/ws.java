package com.bytedance.adsdk.lottie.model.xt;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.model.j> f23497j;
    private PointF xt;

    public ws(PointF pointF, boolean z5, List<com.bytedance.adsdk.lottie.model.j> list) {
        this.xt = pointF;
        this.cw = z5;
        this.f23497j = new ArrayList(list);
    }

    public void j(float f6, float f7) {
        if (this.xt == null) {
            this.xt = new PointF();
        }
        this.xt.set(f6, f7);
    }

    public List<com.bytedance.adsdk.lottie.model.j> cw() {
        return this.f23497j;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f23497j.size() + "closed=" + this.cw + '}';
    }

    public boolean xt() {
        return this.cw;
    }

    public PointF j() {
        return this.xt;
    }

    public ws() {
        this.f23497j = new ArrayList();
    }

    public void j(boolean z5) {
        this.cw = z5;
    }

    public void j(ws wsVar, ws wsVar2, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        if (this.xt == null) {
            this.xt = new PointF();
        }
        this.cw = wsVar.xt() || wsVar2.xt();
        if (wsVar.cw().size() != wsVar2.cw().size()) {
            com.bytedance.adsdk.lottie.up.up.xt("Curves must have the same number of control points. Shape 1: " + wsVar.cw().size() + "\tShape 2: " + wsVar2.cw().size());
        }
        int min = Math.min(wsVar.cw().size(), wsVar2.cw().size());
        if (this.f23497j.size() < min) {
            for (int size = this.f23497j.size(); size < min; size++) {
                this.f23497j.add(new com.bytedance.adsdk.lottie.model.j());
            }
        } else if (this.f23497j.size() > min) {
            for (int size2 = this.f23497j.size() - 1; size2 >= min; size2--) {
                List<com.bytedance.adsdk.lottie.model.j> list = this.f23497j;
                list.remove(list.size() - 1);
            }
        }
        PointF j6 = wsVar.j();
        PointF j7 = wsVar2.j();
        j(com.bytedance.adsdk.lottie.up.tl.j(j6.x, j7.x, f6), com.bytedance.adsdk.lottie.up.tl.j(j6.y, j7.y, f6));
        for (int size3 = this.f23497j.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.model.j jVar = wsVar.cw().get(size3);
            com.bytedance.adsdk.lottie.model.j jVar2 = wsVar2.cw().get(size3);
            PointF j8 = jVar.j();
            PointF xt = jVar.xt();
            PointF cw = jVar.cw();
            PointF j9 = jVar2.j();
            PointF xt2 = jVar2.xt();
            PointF cw2 = jVar2.cw();
            this.f23497j.get(size3).j(com.bytedance.adsdk.lottie.up.tl.j(j8.x, j9.x, f6), com.bytedance.adsdk.lottie.up.tl.j(j8.y, j9.y, f6));
            this.f23497j.get(size3).xt(com.bytedance.adsdk.lottie.up.tl.j(xt.x, xt2.x, f6), com.bytedance.adsdk.lottie.up.tl.j(xt.y, xt2.y, f6));
            this.f23497j.get(size3).cw(com.bytedance.adsdk.lottie.up.tl.j(cw.x, cw2.x, f6), com.bytedance.adsdk.lottie.up.tl.j(cw.y, cw2.y, f6));
        }
    }
}
