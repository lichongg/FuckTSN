package com.amap.api.col.p0003l;

import com.autonavi.amap.mapcore.DPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l2 {

    /* renamed from: a, reason: collision with root package name */
    public final double f6728a;

    /* renamed from: b, reason: collision with root package name */
    public final double f6729b;

    /* renamed from: c, reason: collision with root package name */
    public final double f6730c;

    /* renamed from: d, reason: collision with root package name */
    public final double f6731d;

    /* renamed from: e, reason: collision with root package name */
    public final double f6732e;

    /* renamed from: f, reason: collision with root package name */
    public final double f6733f;

    private boolean b(double d6, double d7, double d8, double d9) {
        return d6 < this.f6730c && this.f6728a < d7 && d8 < this.f6731d && this.f6729b < d9;
    }

    public final boolean a(double d6, double d7) {
        return this.f6728a <= d6 && d6 <= this.f6730c && this.f6729b <= d7 && d7 <= this.f6731d;
    }

    public final boolean c(l2 l2Var) {
        return b(l2Var.f6728a, l2Var.f6730c, l2Var.f6729b, l2Var.f6731d);
    }

    public final boolean d(DPoint dPoint) {
        return a(dPoint.f9903x, dPoint.f9904y);
    }

    public final boolean e(l2 l2Var) {
        return l2Var.f6728a >= this.f6728a && l2Var.f6730c <= this.f6730c && l2Var.f6729b >= this.f6729b && l2Var.f6731d <= this.f6731d;
    }

    public l2(double d6, double d7, double d8, double d9) {
        this.f6728a = d6;
        this.f6729b = d8;
        this.f6730c = d7;
        this.f6731d = d9;
        this.f6732e = (d6 + d7) / 2.0d;
        this.f6733f = (d8 + d9) / 2.0d;
    }
}
