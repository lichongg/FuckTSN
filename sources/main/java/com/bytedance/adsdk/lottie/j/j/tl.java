package com.bytedance.adsdk.lottie.j.j;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.j.xt.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl implements qv, up, j.InterfaceC0316j {
    private final Path ae;
    private com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> av;
    private final com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> az;
    private final boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private final RectF f23275g;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.j.xt.i f23276i;

    /* renamed from: j, reason: collision with root package name */
    float f23277j;
    private final com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> jy;
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> kt;
    private final int mi;
    private final List<jy> oq;
    private final com.bytedance.adsdk.lottie.model.xt.ae qv;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.cw f23279r;
    private com.bytedance.adsdk.lottie.j.xt.cw tj;
    private final Paint tl;
    private final com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.r, com.bytedance.adsdk.lottie.model.xt.r> vl;

    /* renamed from: w, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.tl f23280w;
    private final com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> ws;
    private final String xt;
    private final LongSparseArray<LinearGradient> up = new LongSparseArray<>();

    /* renamed from: m, reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f23278m = new LongSparseArray<>();

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        this.f23280w.invalidateSelf();
    }

    private int r() {
        int round = Math.round(this.ws.tl() * this.mi);
        int round2 = Math.round(this.az.tl() * this.mi);
        int round3 = Math.round(this.vl.tl() * this.mi);
        int i6 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i6 = i6 * 31 * round2;
        }
        return round3 != 0 ? i6 * 31 * round3 : i6;
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        for (int i6 = 0; i6 < list2.size(); i6++) {
            cw cwVar = list2.get(i6);
            if (cwVar instanceof jy) {
                this.oq.add((jy) cwVar);
            }
        }
    }

    public tl(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.up upVar) {
        Path path = new Path();
        this.ae = path;
        this.tl = new com.bytedance.adsdk.lottie.j.j(1);
        this.f23275g = new RectF();
        this.oq = new ArrayList();
        this.f23277j = 0.0f;
        this.f23279r = cwVar;
        this.xt = upVar.j();
        this.cw = upVar.tl();
        this.f23280w = tlVar;
        this.qv = upVar.xt();
        path.setFillType(upVar.cw());
        this.mi = (int) (mVar.up() / 32.0f);
        com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.r, com.bytedance.adsdk.lottie.model.xt.r> j6 = upVar.r().j();
        this.vl = j6;
        j6.j(this);
        cwVar.j(j6);
        com.bytedance.adsdk.lottie.j.xt.j<Integer, Integer> j7 = upVar.up().j();
        this.jy = j7;
        j7.j(this);
        cwVar.j(j7);
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j8 = upVar.m().j();
        this.ws = j8;
        j8.j(this);
        cwVar.j(j8);
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j9 = upVar.ae().j();
        this.az = j9;
        j9.j(this);
        cwVar.j(j9);
        if (cwVar.vl() != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j10 = cwVar.vl().j().j();
            this.kt = j10;
            j10.j(this);
            cwVar.j(this.kt);
        }
        if (cwVar.jy() != null) {
            this.tj = new com.bytedance.adsdk.lottie.j.xt.cw(this, cwVar, cwVar.jy());
        }
    }

    private RadialGradient cw() {
        float f6;
        long r5 = r();
        RadialGradient radialGradient = this.f23278m.get(r5);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF ae = this.ws.ae();
        PointF ae2 = this.az.ae();
        com.bytedance.adsdk.lottie.model.xt.r ae3 = this.vl.ae();
        int[] j6 = j(ae3.xt());
        float[] j7 = ae3.j();
        float f7 = ae.x;
        float f8 = ae.y;
        float hypot = (float) Math.hypot(ae2.x - f7, ae2.y - f8);
        if (hypot <= 0.0f) {
            f6 = 0.001f;
        } else {
            f6 = hypot;
        }
        RadialGradient radialGradient2 = new RadialGradient(f7, f8, f6, j6, j7, Shader.TileMode.CLAMP);
        this.f23278m.put(r5, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient xt() {
        long r5 = r();
        LinearGradient linearGradient = this.up.get(r5);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF ae = this.ws.ae();
        PointF ae2 = this.az.ae();
        com.bytedance.adsdk.lottie.model.xt.r ae3 = this.vl.ae();
        LinearGradient linearGradient2 = new LinearGradient(ae.x, ae.y, ae2.x, ae2.y, j(ae3.xt()), ae3.j(), Shader.TileMode.CLAMP);
        this.up.put(r5, linearGradient2);
        return linearGradient2;
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(Canvas canvas, Matrix matrix, int i6) {
        Shader cw;
        if (this.cw) {
            return;
        }
        com.bytedance.adsdk.lottie.up.j("GradientFillContent#draw");
        this.ae.reset();
        for (int i7 = 0; i7 < this.oq.size(); i7++) {
            this.ae.addPath(this.oq.get(i7).r(), matrix);
        }
        this.ae.computeBounds(this.f23275g, false);
        if (this.qv == com.bytedance.adsdk.lottie.model.xt.ae.LINEAR) {
            cw = xt();
        } else {
            cw = cw();
        }
        cw.setLocalMatrix(matrix);
        this.tl.setShader(cw);
        com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> jVar = this.av;
        if (jVar != null) {
            this.tl.setColorFilter(jVar.ae());
        }
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> jVar2 = this.kt;
        if (jVar2 != null) {
            float floatValue = jVar2.ae().floatValue();
            if (floatValue == 0.0f) {
                this.tl.setMaskFilter(null);
            } else if (floatValue != this.f23277j) {
                this.tl.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f23277j = floatValue;
        }
        com.bytedance.adsdk.lottie.j.xt.cw cwVar = this.tj;
        if (cwVar != null) {
            cwVar.j(this.tl);
        }
        this.tl.setAlpha(com.bytedance.adsdk.lottie.up.tl.j((int) ((((i6 / 255.0f) * this.jy.ae().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.ae, this.tl);
        com.bytedance.adsdk.lottie.up.xt("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        this.ae.reset();
        for (int i6 = 0; i6 < this.oq.size(); i6++) {
            this.ae.addPath(this.oq.get(i6).r(), matrix);
        }
        this.ae.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private int[] j(int[] iArr) {
        com.bytedance.adsdk.lottie.j.xt.i iVar = this.f23276i;
        if (iVar != null) {
            Integer[] numArr = (Integer[]) iVar.ae();
            int i6 = 0;
            if (iArr.length == numArr.length) {
                while (i6 < iArr.length) {
                    iArr[i6] = numArr[i6].intValue();
                    i6++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i6 < numArr.length) {
                    iArr[i6] = numArr[i6].intValue();
                    i6++;
                }
            }
        }
        return iArr;
    }
}
