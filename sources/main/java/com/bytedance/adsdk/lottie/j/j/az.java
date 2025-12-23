package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.j.xt.j;
import com.bytedance.adsdk.lottie.model.xt.mi;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class az implements jy, qv, j.InterfaceC0316j {
    private final com.bytedance.adsdk.lottie.j.xt.j<?, PointF> ae;
    private final String cw;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.j.xt.j<?, PointF> f23250m;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f23251r;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> tl;
    private final com.bytedance.adsdk.lottie.tl up;

    /* renamed from: j, reason: collision with root package name */
    private final Path f23249j = new Path();
    private final RectF xt = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final xt f23248g = new xt();
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> oq = null;

    private void xt() {
        this.qv = false;
        this.up.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        xt();
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            cw cwVar = list.get(i6);
            if (cwVar instanceof tj) {
                tj tjVar = (tj) cwVar;
                if (tjVar.getType() == mi.j.SIMULTANEOUSLY) {
                    this.f23248g.j(tjVar);
                    tjVar.j(this);
                }
            }
            if (cwVar instanceof i) {
                this.oq = ((i) cwVar).xt();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.j.jy
    public Path r() {
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> jVar;
        if (this.qv) {
            return this.f23249j;
        }
        this.f23249j.reset();
        if (this.f23251r) {
            this.qv = true;
            return this.f23249j;
        }
        PointF ae = this.ae.ae();
        float f6 = ae.x / 2.0f;
        float f7 = ae.y / 2.0f;
        com.bytedance.adsdk.lottie.j.xt.j<?, Float> jVar2 = this.tl;
        float g6 = jVar2 == null ? 0.0f : ((com.bytedance.adsdk.lottie.j.xt.r) jVar2).g();
        if (g6 == 0.0f && (jVar = this.oq) != null) {
            g6 = Math.min(jVar.ae().floatValue(), Math.min(f6, f7));
        }
        float min = Math.min(f6, f7);
        if (g6 > min) {
            g6 = min;
        }
        PointF ae2 = this.f23250m.ae();
        this.f23249j.moveTo(ae2.x + f6, (ae2.y - f7) + g6);
        this.f23249j.lineTo(ae2.x + f6, (ae2.y + f7) - g6);
        if (g6 > 0.0f) {
            RectF rectF = this.xt;
            float f8 = ae2.x;
            float f9 = g6 * 2.0f;
            float f10 = ae2.y;
            rectF.set((f8 + f6) - f9, (f10 + f7) - f9, f8 + f6, f10 + f7);
            this.f23249j.arcTo(this.xt, 0.0f, 90.0f, false);
        }
        this.f23249j.lineTo((ae2.x - f6) + g6, ae2.y + f7);
        if (g6 > 0.0f) {
            RectF rectF2 = this.xt;
            float f11 = ae2.x;
            float f12 = ae2.y;
            float f13 = g6 * 2.0f;
            rectF2.set(f11 - f6, (f12 + f7) - f13, (f11 - f6) + f13, f12 + f7);
            this.f23249j.arcTo(this.xt, 90.0f, 90.0f, false);
        }
        this.f23249j.lineTo(ae2.x - f6, (ae2.y - f7) + g6);
        if (g6 > 0.0f) {
            RectF rectF3 = this.xt;
            float f14 = ae2.x;
            float f15 = ae2.y;
            float f16 = g6 * 2.0f;
            rectF3.set(f14 - f6, f15 - f7, (f14 - f6) + f16, (f15 - f7) + f16);
            this.f23249j.arcTo(this.xt, 180.0f, 90.0f, false);
        }
        this.f23249j.lineTo((ae2.x + f6) - g6, ae2.y - f7);
        if (g6 > 0.0f) {
            RectF rectF4 = this.xt;
            float f17 = ae2.x;
            float f18 = g6 * 2.0f;
            float f19 = ae2.y;
            rectF4.set((f17 + f6) - f18, f19 - f7, f17 + f6, (f19 - f7) + f18);
            this.f23249j.arcTo(this.xt, 270.0f, 90.0f, false);
        }
        this.f23249j.close();
        this.f23248g.j(this.f23249j);
        this.qv = true;
        return this.f23249j;
    }

    public az(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.qv qvVar) {
        this.cw = qvVar.j();
        this.f23251r = qvVar.up();
        this.up = tlVar;
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j6 = qvVar.r().j();
        this.f23250m = j6;
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j7 = qvVar.cw().j();
        this.ae = j7;
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j8 = qvVar.xt().j();
        this.tl = j8;
        cwVar.j(j6);
        cwVar.j(j7);
        cwVar.j(j8);
        j6.j(this);
        j7.j(this);
        j8.j(this);
    }
}
