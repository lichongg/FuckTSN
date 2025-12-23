package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.j.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class av {
    private j<?, PointF> ae;
    private final Matrix cw;

    /* renamed from: g, reason: collision with root package name */
    private j<Float, Float> f23294g;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f23295j = new Matrix();
    private j<?, Float> jy;

    /* renamed from: m, reason: collision with root package name */
    private j<PointF, PointF> f23296m;
    private j<Integer, Integer> oq;
    private r qv;

    /* renamed from: r, reason: collision with root package name */
    private final Matrix f23297r;
    private j<com.bytedance.adsdk.lottie.m.r, com.bytedance.adsdk.lottie.m.r> tl;
    private final float[] up;
    private r vl;
    private j<?, Float> ws;
    private final Matrix xt;

    private void up() {
        for (int i6 = 0; i6 < 9; i6++) {
            this.up[i6] = 0.0f;
        }
    }

    public void j(com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        cwVar.j(this.oq);
        cwVar.j(this.jy);
        cwVar.j(this.ws);
        cwVar.j(this.f23296m);
        cwVar.j(this.ae);
        cwVar.j(this.tl);
        cwVar.j(this.f23294g);
        cwVar.j(this.qv);
        cwVar.j(this.vl);
    }

    public j<?, Float> xt() {
        return this.jy;
    }

    public j<?, Float> cw() {
        return this.ws;
    }

    public Matrix r() {
        PointF ae;
        PointF ae2;
        this.f23295j.reset();
        j<?, PointF> jVar = this.ae;
        if (jVar != null && (ae2 = jVar.ae()) != null) {
            float f6 = ae2.x;
            if (f6 != 0.0f || ae2.y != 0.0f) {
                this.f23295j.preTranslate(f6, ae2.y);
            }
        }
        j<Float, Float> jVar2 = this.f23294g;
        if (jVar2 != null) {
            float floatValue = jVar2 instanceof i ? jVar2.ae().floatValue() : ((r) jVar2).g();
            if (floatValue != 0.0f) {
                this.f23295j.preRotate(floatValue);
            }
        }
        if (this.qv != null) {
            float cos = this.vl == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.g()) + 90.0f));
            float sin = this.vl == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.g()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.g()));
            up();
            float[] fArr = this.up;
            fArr[0] = cos;
            fArr[1] = sin;
            float f7 = -sin;
            fArr[3] = f7;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.xt.setValues(fArr);
            up();
            float[] fArr2 = this.up;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.cw.setValues(fArr2);
            up();
            float[] fArr3 = this.up;
            fArr3[0] = cos;
            fArr3[1] = f7;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f23297r.setValues(fArr3);
            this.cw.preConcat(this.xt);
            this.f23297r.preConcat(this.cw);
            this.f23295j.preConcat(this.f23297r);
        }
        j<com.bytedance.adsdk.lottie.m.r, com.bytedance.adsdk.lottie.m.r> jVar3 = this.tl;
        if (jVar3 != null) {
            com.bytedance.adsdk.lottie.m.r ae3 = jVar3.ae();
            if (ae3.j() != 1.0f || ae3.xt() != 1.0f) {
                this.f23295j.preScale(ae3.j(), ae3.xt());
            }
        }
        j<PointF, PointF> jVar4 = this.f23296m;
        if (jVar4 != null && (((ae = jVar4.ae()) != null && ae.x != 0.0f) || ae.y != 0.0f)) {
            this.f23295j.preTranslate(-ae.x, -ae.y);
        }
        return this.f23295j;
    }

    public Matrix xt(float f6) {
        j<?, PointF> jVar = this.ae;
        PointF ae = jVar == null ? null : jVar.ae();
        j<com.bytedance.adsdk.lottie.m.r, com.bytedance.adsdk.lottie.m.r> jVar2 = this.tl;
        com.bytedance.adsdk.lottie.m.r ae2 = jVar2 == null ? null : jVar2.ae();
        this.f23295j.reset();
        if (ae != null) {
            this.f23295j.preTranslate(ae.x * f6, ae.y * f6);
        }
        if (ae2 != null) {
            double d6 = f6;
            this.f23295j.preScale((float) Math.pow(ae2.j(), d6), (float) Math.pow(ae2.xt(), d6));
        }
        j<Float, Float> jVar3 = this.f23294g;
        if (jVar3 != null) {
            float floatValue = jVar3.ae().floatValue();
            j<PointF, PointF> jVar4 = this.f23296m;
            PointF ae3 = jVar4 != null ? jVar4.ae() : null;
            this.f23295j.preRotate(floatValue * f6, ae3 == null ? 0.0f : ae3.x, ae3 != null ? ae3.y : 0.0f);
        }
        return this.f23295j;
    }

    public av(com.bytedance.adsdk.lottie.model.j.vl vlVar) {
        j<PointF, PointF> j6;
        j<PointF, PointF> j7;
        j<com.bytedance.adsdk.lottie.m.r, com.bytedance.adsdk.lottie.m.r> j8;
        j<Float, Float> j9;
        r rVar;
        r rVar2;
        if (vlVar.j() == null) {
            j6 = null;
        } else {
            j6 = vlVar.j().j();
        }
        this.f23296m = j6;
        if (vlVar.xt() == null) {
            j7 = null;
        } else {
            j7 = vlVar.xt().j();
        }
        this.ae = j7;
        if (vlVar.cw() == null) {
            j8 = null;
        } else {
            j8 = vlVar.cw().j();
        }
        this.tl = j8;
        if (vlVar.r() == null) {
            j9 = null;
        } else {
            j9 = vlVar.r().j();
        }
        this.f23294g = j9;
        if (vlVar.tl() == null) {
            rVar = null;
        } else {
            rVar = (r) vlVar.tl().j();
        }
        this.qv = rVar;
        if (rVar != null) {
            this.xt = new Matrix();
            this.cw = new Matrix();
            this.f23297r = new Matrix();
            this.up = new float[9];
        } else {
            this.xt = null;
            this.cw = null;
            this.f23297r = null;
            this.up = null;
        }
        if (vlVar.g() == null) {
            rVar2 = null;
        } else {
            rVar2 = (r) vlVar.g().j();
        }
        this.vl = rVar2;
        if (vlVar.up() != null) {
            this.oq = vlVar.up().j();
        }
        if (vlVar.m() != null) {
            this.jy = vlVar.m().j();
        } else {
            this.jy = null;
        }
        if (vlVar.ae() != null) {
            this.ws = vlVar.ae().j();
        } else {
            this.ws = null;
        }
    }

    public void j(j.InterfaceC0316j interfaceC0316j) {
        j<Integer, Integer> jVar = this.oq;
        if (jVar != null) {
            jVar.j(interfaceC0316j);
        }
        j<?, Float> jVar2 = this.jy;
        if (jVar2 != null) {
            jVar2.j(interfaceC0316j);
        }
        j<?, Float> jVar3 = this.ws;
        if (jVar3 != null) {
            jVar3.j(interfaceC0316j);
        }
        j<PointF, PointF> jVar4 = this.f23296m;
        if (jVar4 != null) {
            jVar4.j(interfaceC0316j);
        }
        j<?, PointF> jVar5 = this.ae;
        if (jVar5 != null) {
            jVar5.j(interfaceC0316j);
        }
        j<com.bytedance.adsdk.lottie.m.r, com.bytedance.adsdk.lottie.m.r> jVar6 = this.tl;
        if (jVar6 != null) {
            jVar6.j(interfaceC0316j);
        }
        j<Float, Float> jVar7 = this.f23294g;
        if (jVar7 != null) {
            jVar7.j(interfaceC0316j);
        }
        r rVar = this.qv;
        if (rVar != null) {
            rVar.j(interfaceC0316j);
        }
        r rVar2 = this.vl;
        if (rVar2 != null) {
            rVar2.j(interfaceC0316j);
        }
    }

    public void j(float f6) {
        j<Integer, Integer> jVar = this.oq;
        if (jVar != null) {
            jVar.j(f6);
        }
        j<?, Float> jVar2 = this.jy;
        if (jVar2 != null) {
            jVar2.j(f6);
        }
        j<?, Float> jVar3 = this.ws;
        if (jVar3 != null) {
            jVar3.j(f6);
        }
        j<PointF, PointF> jVar4 = this.f23296m;
        if (jVar4 != null) {
            jVar4.j(f6);
        }
        j<?, PointF> jVar5 = this.ae;
        if (jVar5 != null) {
            jVar5.j(f6);
        }
        j<com.bytedance.adsdk.lottie.m.r, com.bytedance.adsdk.lottie.m.r> jVar6 = this.tl;
        if (jVar6 != null) {
            jVar6.j(f6);
        }
        j<Float, Float> jVar7 = this.f23294g;
        if (jVar7 != null) {
            jVar7.j(f6);
        }
        r rVar = this.qv;
        if (rVar != null) {
            rVar.j(f6);
        }
        r rVar2 = this.vl;
        if (rVar2 != null) {
            rVar2.j(f6);
        }
    }

    public j<?, Integer> j() {
        return this.oq;
    }
}
