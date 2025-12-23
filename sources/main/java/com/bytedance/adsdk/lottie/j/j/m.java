package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.j.xt.j;
import com.bytedance.adsdk.lottie.model.xt.mi;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m implements jy, qv, j.InterfaceC0316j {
    private final com.bytedance.adsdk.lottie.tl cw;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.xt.xt f23266m;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.j.xt.j<?, PointF> f23267r;
    private boolean tl;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, PointF> up;
    private final String xt;

    /* renamed from: j, reason: collision with root package name */
    private final Path f23265j = new Path();
    private final xt ae = new xt();

    private void xt() {
        this.tl = false;
        this.cw.invalidateSelf();
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
                    this.ae.j(tjVar);
                    tjVar.j(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.j.jy
    public Path r() {
        if (this.tl) {
            return this.f23265j;
        }
        this.f23265j.reset();
        if (this.f23266m.up()) {
            this.tl = true;
            return this.f23265j;
        }
        PointF ae = this.f23267r.ae();
        float f6 = ae.x / 2.0f;
        float f7 = ae.y / 2.0f;
        float f8 = f6 * 0.55228f;
        float f9 = 0.55228f * f7;
        this.f23265j.reset();
        if (this.f23266m.r()) {
            float f10 = -f7;
            this.f23265j.moveTo(0.0f, f10);
            float f11 = 0.0f - f8;
            float f12 = -f6;
            float f13 = 0.0f - f9;
            this.f23265j.cubicTo(f11, f10, f12, f13, f12, 0.0f);
            float f14 = f9 + 0.0f;
            this.f23265j.cubicTo(f12, f14, f11, f7, 0.0f, f7);
            float f15 = f8 + 0.0f;
            this.f23265j.cubicTo(f15, f7, f6, f14, f6, 0.0f);
            this.f23265j.cubicTo(f6, f13, f15, f10, 0.0f, f10);
        } else {
            float f16 = -f7;
            this.f23265j.moveTo(0.0f, f16);
            float f17 = f8 + 0.0f;
            float f18 = 0.0f - f9;
            this.f23265j.cubicTo(f17, f16, f6, f18, f6, 0.0f);
            float f19 = f9 + 0.0f;
            this.f23265j.cubicTo(f6, f19, f17, f7, 0.0f, f7);
            float f20 = 0.0f - f8;
            float f21 = -f6;
            this.f23265j.cubicTo(f20, f7, f21, f19, f21, 0.0f);
            this.f23265j.cubicTo(f21, f18, f20, f16, 0.0f, f16);
        }
        PointF ae2 = this.up.ae();
        this.f23265j.offset(ae2.x, ae2.y);
        this.f23265j.close();
        this.ae.j(this.f23265j);
        this.tl = true;
        return this.f23265j;
    }

    public m(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.xt xtVar) {
        this.xt = xtVar.j();
        this.cw = tlVar;
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j6 = xtVar.cw().j();
        this.f23267r = j6;
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j7 = xtVar.xt().j();
        this.up = j7;
        this.f23266m = xtVar;
        cwVar.j(j6);
        cwVar.j(j7);
        j6.j(this);
        j7.j(this);
    }
}
