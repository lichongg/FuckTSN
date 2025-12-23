package com.bytedance.adsdk.lottie.model;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private final PointF cw;

    /* renamed from: j, reason: collision with root package name */
    private final PointF f23356j;
    private final PointF xt;

    public j() {
        this.f23356j = new PointF();
        this.xt = new PointF();
        this.cw = new PointF();
    }

    public void cw(float f6, float f7) {
        this.cw.set(f6, f7);
    }

    public void j(float f6, float f7) {
        this.f23356j.set(f6, f7);
    }

    public void xt(float f6, float f7) {
        this.xt.set(f6, f7);
    }

    public PointF cw() {
        return this.cw;
    }

    public PointF j() {
        return this.f23356j;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.cw.x), Float.valueOf(this.cw.y), Float.valueOf(this.f23356j.x), Float.valueOf(this.f23356j.y), Float.valueOf(this.xt.x), Float.valueOf(this.xt.y));
    }

    public PointF xt() {
        return this.xt;
    }

    public j(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f23356j = pointF;
        this.xt = pointF2;
        this.cw = pointF3;
    }
}
