package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k5 extends q3 {

    /* renamed from: e, reason: collision with root package name */
    private s f34497e;

    /* renamed from: f, reason: collision with root package name */
    private p4 f34498f;

    @Override // com.huawei.hms.scankit.p.q3, com.huawei.hms.scankit.p.o
    public s a() {
        s sVar = this.f34497e;
        if (sVar != null) {
            return sVar;
        }
        p4 c6 = c();
        int c7 = c6.c();
        int a6 = c6.a();
        byte[] b6 = c6.b();
        s sVar2 = new s(c7, a6);
        byte[] b7 = this.f34498f.b();
        int c8 = this.f34498f.c();
        int a7 = this.f34498f.a();
        int[] iArr = new int[256];
        for (int i6 = 0; i6 < a7; i6++) {
            int i7 = i6 * c8;
            for (int i8 = 0; i8 < c8; i8++) {
                int i9 = b7[i7 + i8] & 255;
                iArr[i9] = iArr[i9] + 1;
            }
        }
        int i10 = 0;
        int i11 = 0;
        double d6 = 0.0d;
        for (int i12 = 256; i10 < i12; i12 = 256) {
            int i13 = 0;
            int i14 = 0;
            double d7 = 0.0d;
            while (i13 < i10) {
                i14 += iArr[i13];
                d7 += r12 * i13;
                i13++;
                iArr = iArr;
            }
            int[] iArr2 = iArr;
            int i15 = i10;
            int i16 = 0;
            double d8 = 0.0d;
            while (i15 < 256) {
                i16 += iArr2[i15];
                d8 += r12 * i15;
                i15++;
                i14 = i14;
            }
            int i17 = i14;
            double d9 = i17;
            int i18 = i10;
            int i19 = c8;
            double d10 = c8 * a7;
            double d11 = d9 / d10;
            double d12 = i16;
            double d13 = d12 / d10;
            double d14 = i17 > 0 ? d7 / d9 : 0.0d;
            double d15 = i16 > 0 ? d8 / d12 : 0.0d;
            double d16 = (d11 * d14) + (d13 * d15);
            double d17 = d14 - d16;
            double d18 = d15 - d16;
            double d19 = (d11 * d17 * d17) + (d13 * d18 * d18);
            if (d19 > d6) {
                i11 = i18;
                d6 = d19;
            }
            i10 = i18 + 1;
            c8 = i19;
            iArr = iArr2;
        }
        for (int i20 = 0; i20 < a6; i20++) {
            int i21 = i20 * c7;
            for (int i22 = 0; i22 < c7; i22++) {
                if ((b6[i21 + i22] & 255) <= i11) {
                    sVar2.c(i22, i20);
                }
            }
        }
        this.f34497e = sVar2;
        return sVar2;
    }

    public k5(p4 p4Var) {
        super(p4Var);
        this.f34498f = p4Var;
    }
}
