package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class a7 extends i7 {

    /* renamed from: c, reason: collision with root package name */
    private final short f33992c;

    /* renamed from: d, reason: collision with root package name */
    private final short f33993d;

    @Override // com.huawei.hms.scankit.p.i7
    void a(r rVar, byte[] bArr) {
        rVar.a(this.f33992c, this.f33993d);
    }

    public String toString() {
        short s5 = this.f33992c;
        int i6 = 1 << this.f33993d;
        return kotlin.text.v0.f47961e + Integer.toBinaryString((s5 & (i6 - 1)) | i6 | (1 << this.f33993d)).substring(1) + kotlin.text.v0.f47962f;
    }

    a7(i7 i7Var, int i6, int i7) {
        super(i7Var);
        this.f33992c = (short) i6;
        this.f33993d = (short) i7;
    }
}
