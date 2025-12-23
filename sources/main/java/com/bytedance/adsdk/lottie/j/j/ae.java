package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.j.xt.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae implements qv, up, j.InterfaceC0316j {
    private final List<jy> ae;
    private final Paint cw;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> f23240g;

    /* renamed from: j, reason: collision with root package name */
    float f23241j;
    private com.bytedance.adsdk.lottie.j.xt.cw jy;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f23242m;
    private com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> oq;
    private final com.bytedance.adsdk.lottie.tl qv;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.cw f23243r;
    private final com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> tl;
    private final String up;
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> vl;
    private final Path xt;

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        this.qv.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        for (int i6 = 0; i6 < list2.size(); i6++) {
            cw cwVar = list2.get(i6);
            if (cwVar instanceof jy) {
                this.ae.add((jy) cwVar);
            }
        }
    }

    public ae(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.az azVar) {
        Path path = new Path();
        this.xt = path;
        this.cw = new com.bytedance.adsdk.lottie.j.j(1);
        this.ae = new ArrayList();
        this.f23243r = cwVar;
        this.up = azVar.j();
        this.f23242m = azVar.up();
        this.qv = tlVar;
        if (cwVar.vl() != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j6 = cwVar.vl().j().j();
            this.vl = j6;
            j6.j(this);
            cwVar.j(this.vl);
        }
        if (cwVar.jy() != null) {
            this.jy = new com.bytedance.adsdk.lottie.j.xt.cw(this, cwVar, cwVar.jy());
        }
        if (azVar.xt() != null && azVar.cw() != null) {
            path.setFillType(azVar.r());
            com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> j7 = azVar.xt().j();
            this.tl = j7;
            j7.j(this);
            cwVar.j(j7);
            com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> j8 = azVar.cw().j();
            this.f23240g = j8;
            j8.j(this);
            cwVar.j(j8);
            return;
        }
        this.tl = null;
        this.f23240g = null;
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(Canvas canvas, Matrix matrix, int i6) {
        if (this.f23242m) {
            return;
        }
        com.bytedance.adsdk.lottie.up.j("FillContent#draw");
        this.cw.setColor((com.bytedance.adsdk.lottie.up.tl.j((int) ((((i6 / 255.0f) * this.f23240g.ae().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.lottie.j.xt.xt) this.tl).g() & 16777215));
        com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> jVar = this.oq;
        if (jVar != null) {
            this.cw.setColorFilter(jVar.ae());
        }
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> jVar2 = this.vl;
        if (jVar2 != null) {
            float floatValue = jVar2.ae().floatValue();
            if (floatValue == 0.0f) {
                this.cw.setMaskFilter(null);
            } else if (floatValue != this.f23241j) {
                this.cw.setMaskFilter(this.f23243r.xt(floatValue));
            }
            this.f23241j = floatValue;
        }
        com.bytedance.adsdk.lottie.j.xt.cw cwVar = this.jy;
        if (cwVar != null) {
            cwVar.j(this.cw);
        }
        this.xt.reset();
        for (int i7 = 0; i7 < this.ae.size(); i7++) {
            this.xt.addPath(this.ae.get(i7).r(), matrix);
        }
        canvas.drawPath(this.xt, this.cw);
        com.bytedance.adsdk.lottie.up.xt("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        this.xt.reset();
        for (int i6 = 0; i6 < this.ae.size(); i6++) {
            this.xt.addPath(this.ae.get(i6).r(), matrix);
        }
        this.xt.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
