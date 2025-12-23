package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends j {
    private final LongSparseArray<RadialGradient> ae;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.xt.ae f23252g;
    private final com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> jy;

    /* renamed from: m, reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f23253m;
    private final int oq;
    private final com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.r, com.bytedance.adsdk.lottie.model.xt.r> qv;

    /* renamed from: r, reason: collision with root package name */
    private final String f23254r;
    private final RectF tl;
    private final boolean up;
    private final com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> vl;
    private com.bytedance.adsdk.lottie.j.xt.i ws;

    @Override // com.bytedance.adsdk.lottie.j.j.j, com.bytedance.adsdk.lottie.j.j.up
    public void j(Canvas canvas, Matrix matrix, int i6) {
        if (this.up) {
            return;
        }
        j(this.tl, matrix, false);
        Shader xt = this.f23252g == com.bytedance.adsdk.lottie.model.xt.ae.LINEAR ? xt() : cw();
        xt.setLocalMatrix(matrix);
        this.xt.setShader(xt);
        super.j(canvas, matrix, i6);
    }

    private int r() {
        int round = Math.round(this.vl.tl() * this.oq);
        int round2 = Math.round(this.jy.tl() * this.oq);
        int round3 = Math.round(this.qv.tl() * this.oq);
        int i6 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i6 = i6 * 31 * round2;
        }
        return round3 != 0 ? i6 * 31 * round3 : i6;
    }

    public g(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.m mVar) {
        super(tlVar, cwVar, mVar.tl().j(), mVar.g().j(), mVar.vl(), mVar.r(), mVar.ae(), mVar.oq(), mVar.qv());
        this.f23253m = new LongSparseArray<>();
        this.ae = new LongSparseArray<>();
        this.tl = new RectF();
        this.f23254r = mVar.j();
        this.f23252g = mVar.xt();
        this.up = mVar.jy();
        this.oq = (int) (tlVar.a().up() / 32.0f);
        com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.r, com.bytedance.adsdk.lottie.model.xt.r> j6 = mVar.cw().j();
        this.qv = j6;
        j6.j(this);
        cwVar.j(j6);
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j7 = mVar.up().j();
        this.vl = j7;
        j7.j(this);
        cwVar.j(j7);
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j8 = mVar.m().j();
        this.jy = j8;
        j8.j(this);
        cwVar.j(j8);
    }

    private RadialGradient cw() {
        long r5 = r();
        RadialGradient radialGradient = this.ae.get(r5);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF ae = this.vl.ae();
        PointF ae2 = this.jy.ae();
        com.bytedance.adsdk.lottie.model.xt.r ae3 = this.qv.ae();
        int[] j6 = j(ae3.xt());
        float[] j7 = ae3.j();
        RadialGradient radialGradient2 = new RadialGradient(ae.x, ae.y, (float) Math.hypot(ae2.x - r7, ae2.y - r8), j6, j7, Shader.TileMode.CLAMP);
        this.ae.put(r5, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient xt() {
        long r5 = r();
        LinearGradient linearGradient = this.f23253m.get(r5);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF ae = this.vl.ae();
        PointF ae2 = this.jy.ae();
        com.bytedance.adsdk.lottie.model.xt.r ae3 = this.qv.ae();
        LinearGradient linearGradient2 = new LinearGradient(ae.x, ae.y, ae2.x, ae2.y, j(ae3.xt()), ae3.j(), Shader.TileMode.CLAMP);
        this.f23253m.put(r5, linearGradient2);
        return linearGradient2;
    }

    private int[] j(int[] iArr) {
        com.bytedance.adsdk.lottie.j.xt.i iVar = this.ws;
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
