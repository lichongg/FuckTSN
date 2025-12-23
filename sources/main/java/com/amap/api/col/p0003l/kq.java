package com.amap.api.col.p0003l;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class kq extends ko implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public int f6713j;

    /* renamed from: k, reason: collision with root package name */
    public int f6714k;

    /* renamed from: l, reason: collision with root package name */
    public int f6715l;

    /* renamed from: m, reason: collision with root package name */
    public int f6716m;

    /* renamed from: n, reason: collision with root package name */
    public int f6717n;

    /* renamed from: o, reason: collision with root package name */
    public int f6718o;

    public kq() {
        this.f6713j = 0;
        this.f6714k = 0;
        this.f6715l = Integer.MAX_VALUE;
        this.f6716m = Integer.MAX_VALUE;
        this.f6717n = Integer.MAX_VALUE;
        this.f6718o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        kq kqVar = new kq(this.f6706h, this.f6707i);
        kqVar.a(this);
        kqVar.f6713j = this.f6713j;
        kqVar.f6714k = this.f6714k;
        kqVar.f6715l = this.f6715l;
        kqVar.f6716m = this.f6716m;
        kqVar.f6717n = this.f6717n;
        kqVar.f6718o = this.f6718o;
        return kqVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellGsm{lac=" + this.f6713j + ", cid=" + this.f6714k + ", psc=" + this.f6715l + ", arfcn=" + this.f6716m + ", bsic=" + this.f6717n + ", timingAdvance=" + this.f6718o + ", mcc='" + this.f6699a + "', mnc='" + this.f6700b + "', signalStrength=" + this.f6701c + ", asuLevel=" + this.f6702d + ", lastUpdateSystemMills=" + this.f6703e + ", lastUpdateUtcMills=" + this.f6704f + ", age=" + this.f6705g + ", main=" + this.f6706h + ", newApi=" + this.f6707i + '}';
    }

    public kq(boolean z5, boolean z6) {
        super(z5, z6);
        this.f6713j = 0;
        this.f6714k = 0;
        this.f6715l = Integer.MAX_VALUE;
        this.f6716m = Integer.MAX_VALUE;
        this.f6717n = Integer.MAX_VALUE;
        this.f6718o = Integer.MAX_VALUE;
    }
}
