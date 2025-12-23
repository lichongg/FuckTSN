package com.amap.api.col.p0003l;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class kr extends ko implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public int f6719j;

    /* renamed from: k, reason: collision with root package name */
    public int f6720k;

    /* renamed from: l, reason: collision with root package name */
    public int f6721l;

    /* renamed from: m, reason: collision with root package name */
    public int f6722m;

    /* renamed from: n, reason: collision with root package name */
    public int f6723n;

    public kr() {
        this.f6719j = 0;
        this.f6720k = 0;
        this.f6721l = Integer.MAX_VALUE;
        this.f6722m = Integer.MAX_VALUE;
        this.f6723n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.ko
    /* renamed from: a */
    public final ko clone() {
        kr krVar = new kr(this.f6706h);
        krVar.a(this);
        krVar.f6719j = this.f6719j;
        krVar.f6720k = this.f6720k;
        krVar.f6721l = this.f6721l;
        krVar.f6722m = this.f6722m;
        krVar.f6723n = this.f6723n;
        return krVar;
    }

    @Override // com.amap.api.col.p0003l.ko
    public final String toString() {
        return "AmapCellLte{tac=" + this.f6719j + ", ci=" + this.f6720k + ", pci=" + this.f6721l + ", earfcn=" + this.f6722m + ", timingAdvance=" + this.f6723n + ", mcc='" + this.f6699a + "', mnc='" + this.f6700b + "', signalStrength=" + this.f6701c + ", asuLevel=" + this.f6702d + ", lastUpdateSystemMills=" + this.f6703e + ", lastUpdateUtcMills=" + this.f6704f + ", age=" + this.f6705g + ", main=" + this.f6706h + ", newApi=" + this.f6707i + '}';
    }

    public kr(boolean z5) {
        super(z5, true);
        this.f6719j = 0;
        this.f6720k = 0;
        this.f6721l = Integer.MAX_VALUE;
        this.f6722m = Integer.MAX_VALUE;
        this.f6723n = Integer.MAX_VALUE;
    }
}
