package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.j.xt.j;
import com.bytedance.adsdk.lottie.model.xt.mi;
import com.bytedance.adsdk.lottie.model.xt.oq;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws implements jy, qv, j.InterfaceC0316j {
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> ae;
    private boolean az;
    private final com.bytedance.adsdk.lottie.tl cw;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> f23288g;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> jy;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f23290m;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> oq;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> qv;

    /* renamed from: r, reason: collision with root package name */
    private final oq.j f23291r;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, PointF> tl;
    private final boolean up;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> vl;
    private final String xt;

    /* renamed from: j, reason: collision with root package name */
    private final Path f23289j = new Path();
    private final xt ws = new xt();

    private void xt() {
        this.az = false;
        this.cw.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        xt();
    }

    /* renamed from: com.bytedance.adsdk.lottie.j.j.ws$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23292j;

        static {
            int[] iArr = new int[oq.j.values().length];
            f23292j = iArr;
            try {
                iArr[oq.j.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23292j[oq.j.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void cw() {
        int i6;
        float f6;
        float f7;
        float cos;
        float sin;
        float f8;
        float f9;
        double d6;
        float f10;
        int i7;
        float f11;
        double d7;
        float f12;
        float f13;
        double d8;
        float f14;
        float f15;
        float floatValue = this.ae.ae().floatValue();
        double radians = Math.toRadians((this.f23288g == null ? 0.0d : r2.ae().floatValue()) - 90.0d);
        double d9 = floatValue;
        float f16 = (float) (6.283185307179586d / d9);
        if (this.f23290m) {
            f16 *= -1.0f;
        }
        float f17 = f16 / 2.0f;
        float f18 = floatValue - ((int) floatValue);
        int i8 = (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1));
        if (i8 != 0) {
            radians += (1.0f - f18) * f17;
        }
        float floatValue2 = this.qv.ae().floatValue();
        float floatValue3 = this.oq.ae().floatValue();
        com.bytedance.adsdk.lottie.j.xt.j<?, Float> jVar = this.vl;
        float floatValue4 = jVar != null ? jVar.ae().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.lottie.j.xt.j<?, Float> jVar2 = this.jy;
        float floatValue5 = jVar2 != null ? jVar2.ae().floatValue() / 100.0f : 0.0f;
        if (i8 != 0) {
            f10 = ((floatValue2 - floatValue3) * f18) + floatValue3;
            i6 = i8;
            f6 = 0.0f;
            double d10 = f10;
            f7 = 2.0f;
            float cos2 = (float) (d10 * Math.cos(radians));
            sin = (float) (d10 * Math.sin(radians));
            this.f23289j.moveTo(cos2, sin);
            d6 = radians + ((f16 * f18) / 2.0f);
            f8 = f18;
            cos = cos2;
            f9 = f17;
        } else {
            i6 = i8;
            f6 = 0.0f;
            f7 = 2.0f;
            double d11 = floatValue2;
            cos = (float) (Math.cos(radians) * d11);
            sin = (float) (d11 * Math.sin(radians));
            this.f23289j.moveTo(cos, sin);
            f8 = f18;
            f9 = f17;
            d6 = radians + f9;
            f10 = 0.0f;
        }
        double ceil = Math.ceil(d9) * 2.0d;
        int i9 = 0;
        boolean z5 = false;
        double d12 = d6;
        float f19 = sin;
        float f20 = cos;
        double d13 = d12;
        while (true) {
            double d14 = i9;
            if (d14 >= ceil) {
                PointF ae = this.tl.ae();
                this.f23289j.offset(ae.x, ae.y);
                this.f23289j.close();
                return;
            }
            float f21 = z5 ? floatValue2 : floatValue3;
            if (f10 == f6 || d14 != ceil - 2.0d) {
                i7 = i9;
                f11 = f9;
            } else {
                i7 = i9;
                f11 = (f16 * f8) / f7;
            }
            if (f10 == f6 || d14 != ceil - 1.0d) {
                d7 = d14;
                f12 = f21;
            } else {
                d7 = d14;
                f12 = f10;
            }
            double d15 = f12;
            float cos3 = (float) (d15 * Math.cos(d13));
            float f22 = f16;
            float sin2 = (float) (d15 * Math.sin(d13));
            if (floatValue4 == f6 && floatValue5 == f6) {
                this.f23289j.lineTo(cos3, sin2);
                f15 = cos3;
                f14 = sin2;
                f13 = f9;
                d8 = d13;
            } else {
                f13 = f9;
                d8 = d13;
                double atan2 = (float) (Math.atan2(f19, f20) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                float f23 = f20;
                float f24 = f19;
                f14 = sin2;
                double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f25 = z5 ? floatValue4 : floatValue5;
                float f26 = z5 ? floatValue5 : floatValue4;
                float f27 = (z5 ? floatValue3 : floatValue2) * f25 * 0.47829f;
                float f28 = cos4 * f27;
                float f29 = f27 * sin3;
                float f30 = (z5 ? floatValue2 : floatValue3) * f26 * 0.47829f;
                float f31 = cos5 * f30;
                float f32 = f30 * sin4;
                if (i6 != 0) {
                    if (i7 == 0) {
                        f28 *= f8;
                        f29 *= f8;
                    } else if (d7 == ceil - 1.0d) {
                        f31 *= f8;
                        f32 *= f8;
                    }
                }
                f15 = cos3;
                this.f23289j.cubicTo(f23 - f28, f24 - f29, cos3 + f31, f14 + f32, f15, f14);
            }
            d13 = d8 + f11;
            z5 = !z5;
            i9 = i7 + 1;
            f9 = f13;
            f20 = f15;
            f19 = f14;
            f16 = f22;
        }
    }

    private void up() {
        double d6;
        int floor = (int) Math.floor(this.ae.ae().floatValue());
        double radians = Math.toRadians((this.f23288g == null ? 0.0d : r2.ae().floatValue()) - 90.0d);
        double d7 = floor;
        float floatValue = this.jy.ae().floatValue() / 100.0f;
        float floatValue2 = this.qv.ae().floatValue();
        double d8 = floatValue2;
        float cos = (float) (Math.cos(radians) * d8);
        float sin = (float) (Math.sin(radians) * d8);
        this.f23289j.moveTo(cos, sin);
        double d9 = (float) (6.283185307179586d / d7);
        double d10 = radians + d9;
        double ceil = Math.ceil(d7);
        int i6 = 0;
        while (i6 < ceil) {
            float cos2 = (float) (Math.cos(d10) * d8);
            int i7 = i6;
            double d11 = d10;
            float sin2 = (float) (d8 * Math.sin(d10));
            if (floatValue != 0.0f) {
                d6 = ceil;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f6 = floatValue2 * floatValue * 0.25f;
                this.f23289j.cubicTo(cos - (f6 * cos3), sin - (f6 * sin3), cos2 + (((float) Math.cos(atan22)) * f6), sin2 + (f6 * ((float) Math.sin(atan22))), cos2, sin2);
                cos = cos2;
                sin = sin2;
            } else {
                sin = sin2;
                d6 = ceil;
                cos = cos2;
                this.f23289j.lineTo(cos, sin);
            }
            d10 = d11 + d9;
            i6 = i7 + 1;
            ceil = d6;
        }
        PointF ae = this.tl.ae();
        this.f23289j.offset(ae.x, ae.y);
        this.f23289j.close();
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            cw cwVar = list.get(i6);
            if (cwVar instanceof tj) {
                tj tjVar = (tj) cwVar;
                if (tjVar.getType() == mi.j.SIMULTANEOUSLY) {
                    this.ws.j(tjVar);
                    tjVar.j(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.j.jy
    public Path r() {
        if (this.az) {
            return this.f23289j;
        }
        this.f23289j.reset();
        if (this.up) {
            this.az = true;
            return this.f23289j;
        }
        int i6 = AnonymousClass1.f23292j[this.f23291r.ordinal()];
        if (i6 == 1) {
            cw();
        } else if (i6 == 2) {
            up();
        }
        this.f23289j.close();
        this.ws.j(this.f23289j);
        this.az = true;
        return this.f23289j;
    }

    public ws(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.oq oqVar) {
        this.cw = tlVar;
        this.xt = oqVar.j();
        oq.j type = oqVar.getType();
        this.f23291r = type;
        this.up = oqVar.g();
        this.f23290m = oqVar.oq();
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j6 = oqVar.xt().j();
        this.ae = j6;
        com.bytedance.adsdk.lottie.j.xt.j<PointF, PointF> j7 = oqVar.cw().j();
        this.tl = j7;
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j8 = oqVar.r().j();
        this.f23288g = j8;
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j9 = oqVar.m().j();
        this.qv = j9;
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j10 = oqVar.tl().j();
        this.jy = j10;
        oq.j jVar = oq.j.STAR;
        if (type == jVar) {
            this.oq = oqVar.up().j();
            this.vl = oqVar.ae().j();
        } else {
            this.oq = null;
            this.vl = null;
        }
        cwVar.j(j6);
        cwVar.j(j7);
        cwVar.j(j8);
        cwVar.j(j9);
        cwVar.j(j10);
        if (type == jVar) {
            cwVar.j(this.oq);
            cwVar.j(this.vl);
        }
        j6.j(this);
        j7.j(this);
        j8.j(this);
        j9.j(this);
        j10.j(this);
        if (type == jVar) {
            this.oq.j(this);
            this.vl.j(this);
        }
    }
}
