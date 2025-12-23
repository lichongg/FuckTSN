package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.j.xt.j;
import com.bytedance.adsdk.lottie.model.xt.mi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j implements qv, up, j.InterfaceC0316j {
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> av;
    private com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> az;
    float cw;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.cw f23258i;

    /* renamed from: j, reason: collision with root package name */
    protected final com.bytedance.adsdk.lottie.model.layer.cw f23259j;
    private final List<com.bytedance.adsdk.lottie.j.xt.j<?, Float>> jy;
    private final float[] oq;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> qv;
    private final com.bytedance.adsdk.lottie.tl tl;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Integer> vl;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> ws;
    final Paint xt;

    /* renamed from: r, reason: collision with root package name */
    private final PathMeasure f23261r = new PathMeasure();
    private final Path up = new Path();

    /* renamed from: m, reason: collision with root package name */
    private final Path f23260m = new Path();
    private final RectF ae = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List<C0315j> f23257g = new ArrayList();

    /* renamed from: com.bytedance.adsdk.lottie.j.j.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bytedance.adsdk.lottie.j.j.j$j, reason: collision with other inner class name */
    private static final class C0315j {

        /* renamed from: j, reason: collision with root package name */
        private final List<jy> f23262j;
        private final tj xt;

        /* synthetic */ C0315j(tj tjVar, AnonymousClass1 anonymousClass1) {
            this(tjVar);
        }

        private C0315j(tj tjVar) {
            this.f23262j = new ArrayList();
            this.xt = tjVar;
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        this.tl.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        AnonymousClass1 anonymousClass1 = null;
        tj tjVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            cw cwVar = list.get(size);
            if (cwVar instanceof tj) {
                tj tjVar2 = (tj) cwVar;
                if (tjVar2.getType() == mi.j.INDIVIDUALLY) {
                    tjVar = tjVar2;
                }
            }
        }
        if (tjVar != null) {
            tjVar.j(this);
        }
        C0315j c0315j = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            cw cwVar2 = list2.get(size2);
            if (cwVar2 instanceof tj) {
                tj tjVar3 = (tj) cwVar2;
                if (tjVar3.getType() == mi.j.INDIVIDUALLY) {
                    if (c0315j != null) {
                        this.f23257g.add(c0315j);
                    }
                    c0315j = new C0315j(tjVar3, anonymousClass1);
                    tjVar3.j(this);
                }
            }
            if (cwVar2 instanceof jy) {
                if (c0315j == null) {
                    c0315j = new C0315j(tjVar, anonymousClass1);
                }
                c0315j.f23262j.add((jy) cwVar2);
            }
        }
        if (c0315j != null) {
            this.f23257g.add(c0315j);
        }
    }

    j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, Paint.Cap cap, Paint.Join join, float f6, com.bytedance.adsdk.lottie.model.j.r rVar, com.bytedance.adsdk.lottie.model.j.xt xtVar, List<com.bytedance.adsdk.lottie.model.j.xt> list, com.bytedance.adsdk.lottie.model.j.xt xtVar2) {
        com.bytedance.adsdk.lottie.j.j jVar = new com.bytedance.adsdk.lottie.j.j(1);
        this.xt = jVar;
        this.cw = 0.0f;
        this.tl = tlVar;
        this.f23259j = cwVar;
        jVar.setStyle(Paint.Style.STROKE);
        jVar.setStrokeCap(cap);
        jVar.setStrokeJoin(join);
        jVar.setStrokeMiter(f6);
        this.vl = rVar.j();
        this.qv = xtVar.j();
        if (xtVar2 == null) {
            this.ws = null;
        } else {
            this.ws = xtVar2.j();
        }
        this.jy = new ArrayList(list.size());
        this.oq = new float[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.jy.add(list.get(i6).j());
        }
        cwVar.j(this.vl);
        cwVar.j(this.qv);
        for (int i7 = 0; i7 < this.jy.size(); i7++) {
            cwVar.j(this.jy.get(i7));
        }
        com.bytedance.adsdk.lottie.j.xt.j<?, Float> jVar2 = this.ws;
        if (jVar2 != null) {
            cwVar.j(jVar2);
        }
        this.vl.j(this);
        this.qv.j(this);
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.jy.get(i8).j(this);
        }
        com.bytedance.adsdk.lottie.j.xt.j<?, Float> jVar3 = this.ws;
        if (jVar3 != null) {
            jVar3.j(this);
        }
        if (cwVar.vl() != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j6 = cwVar.vl().j().j();
            this.av = j6;
            j6.j(this);
            cwVar.j(this.av);
        }
        if (cwVar.jy() != null) {
            this.f23258i = new com.bytedance.adsdk.lottie.j.xt.cw(this, cwVar, cwVar.jy());
        }
    }

    public void j(Canvas canvas, Matrix matrix, int i6) {
        com.bytedance.adsdk.lottie.up.j("StrokeContent#draw");
        if (com.bytedance.adsdk.lottie.up.g.xt(matrix)) {
            com.bytedance.adsdk.lottie.up.xt("StrokeContent#draw");
            return;
        }
        this.xt.setAlpha(com.bytedance.adsdk.lottie.up.tl.j((int) ((((i6 / 255.0f) * ((com.bytedance.adsdk.lottie.j.xt.m) this.vl).g()) / 100.0f) * 255.0f), 0, 255));
        this.xt.setStrokeWidth(((com.bytedance.adsdk.lottie.j.xt.r) this.qv).g() * com.bytedance.adsdk.lottie.up.g.j(matrix));
        if (this.xt.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.lottie.up.xt("StrokeContent#draw");
            return;
        }
        j(matrix);
        com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> jVar = this.az;
        if (jVar != null) {
            this.xt.setColorFilter(jVar.ae());
        }
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> jVar2 = this.av;
        if (jVar2 != null) {
            float floatValue = jVar2.ae().floatValue();
            if (floatValue == 0.0f) {
                this.xt.setMaskFilter(null);
            } else if (floatValue != this.cw) {
                this.xt.setMaskFilter(this.f23259j.xt(floatValue));
            }
            this.cw = floatValue;
        }
        com.bytedance.adsdk.lottie.j.xt.cw cwVar = this.f23258i;
        if (cwVar != null) {
            cwVar.j(this.xt);
        }
        for (int i7 = 0; i7 < this.f23257g.size(); i7++) {
            C0315j c0315j = this.f23257g.get(i7);
            if (c0315j.xt != null) {
                j(canvas, c0315j, matrix);
            } else {
                com.bytedance.adsdk.lottie.up.j("StrokeContent#buildPath");
                this.up.reset();
                for (int size = c0315j.f23262j.size() - 1; size >= 0; size--) {
                    this.up.addPath(((jy) c0315j.f23262j.get(size)).r(), matrix);
                }
                com.bytedance.adsdk.lottie.up.xt("StrokeContent#buildPath");
                com.bytedance.adsdk.lottie.up.j("StrokeContent#drawPath");
                canvas.drawPath(this.up, this.xt);
                com.bytedance.adsdk.lottie.up.xt("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.lottie.up.xt("StrokeContent#draw");
    }

    private void j(Canvas canvas, C0315j c0315j, Matrix matrix) {
        float f6;
        float f7;
        com.bytedance.adsdk.lottie.up.j("StrokeContent#applyTrimPath");
        if (c0315j.xt == null) {
            com.bytedance.adsdk.lottie.up.xt("StrokeContent#applyTrimPath");
            return;
        }
        this.up.reset();
        for (int size = c0315j.f23262j.size() - 1; size >= 0; size--) {
            this.up.addPath(((jy) c0315j.f23262j.get(size)).r(), matrix);
        }
        float floatValue = c0315j.xt.xt().ae().floatValue() / 100.0f;
        float floatValue2 = c0315j.xt.cw().ae().floatValue() / 100.0f;
        float floatValue3 = c0315j.xt.r().ae().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.up, this.xt);
            com.bytedance.adsdk.lottie.up.xt("StrokeContent#applyTrimPath");
            return;
        }
        this.f23261r.setPath(this.up, false);
        float length = this.f23261r.getLength();
        while (this.f23261r.nextContour()) {
            length += this.f23261r.getLength();
        }
        float f8 = floatValue3 * length;
        float f9 = (floatValue * length) + f8;
        float min = Math.min((floatValue2 * length) + f8, (f9 + length) - 1.0f);
        float f10 = 0.0f;
        for (int size2 = c0315j.f23262j.size() - 1; size2 >= 0; size2--) {
            this.f23260m.set(((jy) c0315j.f23262j.get(size2)).r());
            this.f23260m.transform(matrix);
            this.f23261r.setPath(this.f23260m, false);
            float length2 = this.f23261r.getLength();
            if (min > length) {
                float f11 = min - length;
                if (f11 < f10 + length2 && f10 < f11) {
                    f6 = f9 > length ? (f9 - length) / length2 : 0.0f;
                    f7 = Math.min(f11 / length2, 1.0f);
                    com.bytedance.adsdk.lottie.up.g.j(this.f23260m, f6, f7, 0.0f);
                    canvas.drawPath(this.f23260m, this.xt);
                    f10 += length2;
                }
            }
            float f12 = f10 + length2;
            if (f12 >= f9 && f10 <= min) {
                if (f12 <= min && f9 < f10) {
                    canvas.drawPath(this.f23260m, this.xt);
                } else {
                    f6 = f9 < f10 ? 0.0f : (f9 - f10) / length2;
                    f7 = min > f12 ? 1.0f : (min - f10) / length2;
                    com.bytedance.adsdk.lottie.up.g.j(this.f23260m, f6, f7, 0.0f);
                    canvas.drawPath(this.f23260m, this.xt);
                }
            }
            f10 += length2;
        }
        com.bytedance.adsdk.lottie.up.xt("StrokeContent#applyTrimPath");
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        com.bytedance.adsdk.lottie.up.j("StrokeContent#getBounds");
        this.up.reset();
        for (int i6 = 0; i6 < this.f23257g.size(); i6++) {
            C0315j c0315j = this.f23257g.get(i6);
            for (int i7 = 0; i7 < c0315j.f23262j.size(); i7++) {
                this.up.addPath(((jy) c0315j.f23262j.get(i7)).r(), matrix);
            }
        }
        this.up.computeBounds(this.ae, false);
        float g6 = ((com.bytedance.adsdk.lottie.j.xt.r) this.qv).g();
        RectF rectF2 = this.ae;
        float f6 = g6 / 2.0f;
        rectF2.set(rectF2.left - f6, rectF2.top - f6, rectF2.right + f6, rectF2.bottom + f6);
        rectF.set(this.ae);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.lottie.up.xt("StrokeContent#getBounds");
    }

    private void j(Matrix matrix) {
        com.bytedance.adsdk.lottie.up.j("StrokeContent#applyDashPattern");
        if (this.jy.isEmpty()) {
            com.bytedance.adsdk.lottie.up.xt("StrokeContent#applyDashPattern");
            return;
        }
        float j6 = com.bytedance.adsdk.lottie.up.g.j(matrix);
        for (int i6 = 0; i6 < this.jy.size(); i6++) {
            this.oq[i6] = this.jy.get(i6).ae().floatValue();
            if (i6 % 2 == 0) {
                float[] fArr = this.oq;
                if (fArr[i6] < 1.0f) {
                    fArr[i6] = 1.0f;
                }
            } else {
                float[] fArr2 = this.oq;
                if (fArr2[i6] < 0.1f) {
                    fArr2[i6] = 0.1f;
                }
            }
            float[] fArr3 = this.oq;
            fArr3[i6] = fArr3[i6] * j6;
        }
        com.bytedance.adsdk.lottie.j.xt.j<?, Float> jVar = this.ws;
        this.xt.setPathEffect(new DashPathEffect(this.oq, jVar == null ? 0.0f : j6 * jVar.ae().floatValue()));
        com.bytedance.adsdk.lottie.up.xt("StrokeContent#applyDashPattern");
    }
}
