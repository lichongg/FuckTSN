package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.lottie.j.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements j.InterfaceC0316j {
    private boolean ae = true;
    private final j<Float, Float> cw;

    /* renamed from: j, reason: collision with root package name */
    private final j.InterfaceC0316j f23298j;

    /* renamed from: m, reason: collision with root package name */
    private final j<Float, Float> f23299m;

    /* renamed from: r, reason: collision with root package name */
    private final j<Float, Float> f23300r;
    private final j<Float, Float> up;
    private final j<Integer, Integer> xt;

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        this.ae = true;
        this.f23298j.j();
    }

    public cw(j.InterfaceC0316j interfaceC0316j, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.r.oq oqVar) {
        this.f23298j = interfaceC0316j;
        j<Integer, Integer> j6 = oqVar.j().j();
        this.xt = j6;
        j6.j(this);
        cwVar.j(j6);
        j<Float, Float> j7 = oqVar.xt().j();
        this.cw = j7;
        j7.j(this);
        cwVar.j(j7);
        j<Float, Float> j8 = oqVar.cw().j();
        this.f23300r = j8;
        j8.j(this);
        cwVar.j(j8);
        j<Float, Float> j9 = oqVar.r().j();
        this.up = j9;
        j9.j(this);
        cwVar.j(j9);
        j<Float, Float> j10 = oqVar.up().j();
        this.f23299m = j10;
        j10.j(this);
        cwVar.j(j10);
    }

    public void j(Paint paint) {
        if (this.ae) {
            this.ae = false;
            double floatValue = this.f23300r.ae().floatValue() * 0.017453292519943295d;
            float floatValue2 = this.up.ae().floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = this.xt.ae().intValue();
            paint.setShadowLayer(this.f23299m.ae().floatValue(), sin, cos, Color.argb(Math.round(this.cw.ae().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }
}
