package com.amap.api.col.p0003l;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ks extends ko implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public int f6724j;

    /* renamed from: k, reason: collision with root package name */
    public int f6725k;

    /* renamed from: l, reason: collision with root package name */
    public int f6726l;

    /* renamed from: m, reason: collision with root package name */
    public int f6727m;

    public ks() {
        this.f6724j = 0;
        this.f6725k = 0;
        this.f6726l = Integer.MAX_VALUE;
        this.f6727m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        ks ksVar = new ks(this.f6706h, this.f6707i);
        ksVar.a(this);
        ksVar.f6724j = this.f6724j;
        ksVar.f6725k = this.f6725k;
        ksVar.f6726l = this.f6726l;
        ksVar.f6727m = this.f6727m;
        return ksVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.f6724j + ", cid=" + this.f6725k + ", psc=" + this.f6726l + ", uarfcn=" + this.f6727m + ", mcc='" + this.f6699a + "', mnc='" + this.f6700b + "', signalStrength=" + this.f6701c + ", asuLevel=" + this.f6702d + ", lastUpdateSystemMills=" + this.f6703e + ", lastUpdateUtcMills=" + this.f6704f + ", age=" + this.f6705g + ", main=" + this.f6706h + ", newApi=" + this.f6707i + '}';
    }

    public ks(boolean z5, boolean z6) {
        super(z5, z6);
        this.f6724j = 0;
        this.f6725k = 0;
        this.f6726l = Integer.MAX_VALUE;
        this.f6727m = Integer.MAX_VALUE;
    }
}
