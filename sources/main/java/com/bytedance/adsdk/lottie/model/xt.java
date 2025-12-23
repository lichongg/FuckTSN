package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public float ae;
    public float cw;

    /* renamed from: g, reason: collision with root package name */
    @ColorInt
    public int f23442g;

    /* renamed from: j, reason: collision with root package name */
    public String f23443j;
    public PointF jy;

    /* renamed from: m, reason: collision with root package name */
    public float f23444m;
    public float oq;
    public boolean qv;

    /* renamed from: r, reason: collision with root package name */
    public j f23445r;

    @ColorInt
    public int tl;
    public int up;
    public PointF vl;
    public String xt;

    public enum j {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public xt(String str, String str2, float f6, j jVar, int i6, float f7, float f8, @ColorInt int i7, @ColorInt int i8, float f9, boolean z5, PointF pointF, PointF pointF2) {
        j(str, str2, f6, jVar, i6, f7, f8, i7, i8, f9, z5, pointF, pointF2);
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f23443j.hashCode() * 31) + this.xt.hashCode()) * 31) + this.cw)) * 31) + this.f23445r.ordinal()) * 31) + this.up;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f23444m);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.tl;
    }

    public void j(String str, String str2, float f6, j jVar, int i6, float f7, float f8, @ColorInt int i7, @ColorInt int i8, float f9, boolean z5, PointF pointF, PointF pointF2) {
        this.f23443j = str;
        this.xt = str2;
        this.cw = f6;
        this.f23445r = jVar;
        this.up = i6;
        this.f23444m = f7;
        this.ae = f8;
        this.tl = i7;
        this.f23442g = i8;
        this.oq = f9;
        this.qv = z5;
        this.vl = pointF;
        this.jy = pointF2;
    }

    public xt() {
    }
}
