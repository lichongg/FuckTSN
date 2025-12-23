package com.amap.api.col.p0003l;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class kp extends ko implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public int f6708j;

    /* renamed from: k, reason: collision with root package name */
    public int f6709k;

    /* renamed from: l, reason: collision with root package name */
    public int f6710l;

    /* renamed from: m, reason: collision with root package name */
    public int f6711m;

    /* renamed from: n, reason: collision with root package name */
    public int f6712n;

    public kp() {
        this.f6708j = 0;
        this.f6709k = 0;
        this.f6710l = 0;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        kp kpVar = new kp(this.f6706h, this.f6707i);
        kpVar.a(this);
        kpVar.f6708j = this.f6708j;
        kpVar.f6709k = this.f6709k;
        kpVar.f6710l = this.f6710l;
        kpVar.f6711m = this.f6711m;
        kpVar.f6712n = this.f6712n;
        return kpVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellCdma{sid=" + this.f6708j + ", nid=" + this.f6709k + ", bid=" + this.f6710l + ", latitude=" + this.f6711m + ", longitude=" + this.f6712n + ", mcc='" + this.f6699a + "', mnc='" + this.f6700b + "', signalStrength=" + this.f6701c + ", asuLevel=" + this.f6702d + ", lastUpdateSystemMills=" + this.f6703e + ", lastUpdateUtcMills=" + this.f6704f + ", age=" + this.f6705g + ", main=" + this.f6706h + ", newApi=" + this.f6707i + '}';
    }

    public kp(boolean z5, boolean z6) {
        super(z5, z6);
        this.f6708j = 0;
        this.f6709k = 0;
        this.f6710l = 0;
    }
}
