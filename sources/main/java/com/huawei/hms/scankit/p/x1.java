package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class x1 extends s3 {
    @Override // com.huawei.hms.scankit.p.s3
    public s a(s sVar, int i6, int i7, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21) throws a {
        return a(sVar, i6, i7, d6.a(f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21), false);
    }

    public s b(s sVar, int i6, int i7, d6 d6Var) throws a {
        if (i6 <= 0 || i7 <= 0) {
            throw a.a();
        }
        s sVar2 = new s(i6, i7);
        int i8 = i6 * 2;
        float[] fArr = new float[i8];
        for (int i9 = 0; i9 < i7; i9++) {
            float f6 = i9 + 0.5f;
            for (int i10 = 0; i10 < i8; i10 += 2) {
                fArr[i10] = (i10 / 2) + 0.5f;
                fArr[i10 + 1] = f6;
            }
            if (r3.f34745p && r3.f34742m) {
                d6Var.b(fArr);
            } else {
                d6Var.a(fArr);
            }
            int e6 = sVar.e();
            int c6 = sVar.c();
            for (int i11 = 0; i11 < i8; i11 += 2) {
                try {
                    int i12 = (int) fArr[i11];
                    int i13 = (int) fArr[i11 + 1];
                    if (i12 >= -1 && i12 <= e6 && i13 >= -1 && i13 <= c6) {
                        if (sVar.b(i12, i13)) {
                            sVar2.c(i11 / 2, i9);
                        }
                    }
                    sVar2.c(i11 / 2, i9);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw a.a();
                }
            }
        }
        return sVar2;
    }

    @Override // com.huawei.hms.scankit.p.s3
    public s a(s sVar, int i6, int i7, d6 d6Var, boolean z5) throws a {
        boolean z6 = r3.f34743n;
        if ((z6 && z5) || ((!z6 && !z5) || r3.f34750u)) {
            return b(sVar, i6, i7, d6Var);
        }
        return a(sVar, i6, i7, d6Var);
    }

    public s a(s sVar, int i6, int i7, d6 d6Var) throws a {
        if (i6 > 0 && i7 > 0) {
            s sVar2 = new s(i6, i7);
            char c6 = 0;
            int i8 = 0;
            while (i8 < i7) {
                int i9 = 0;
                while (i9 < i6) {
                    float f6 = i9;
                    float f7 = (f6 - 0.2f) + 0.5f;
                    float f8 = i8;
                    float f9 = f8 + 0.5f;
                    float f10 = f6 + 0.2f + 0.5f;
                    float f11 = f6 + 0.5f;
                    float[] fArr = new float[10];
                    fArr[c6] = f7;
                    fArr[1] = f9;
                    fArr[2] = f10;
                    fArr[3] = f9;
                    fArr[4] = f11;
                    fArr[5] = (f8 - 0.2f) + 0.5f;
                    fArr[6] = f11;
                    fArr[7] = f8 + 0.2f + 0.5f;
                    fArr[8] = f11;
                    fArr[9] = f9;
                    if (r3.f34745p && r3.f34742m) {
                        d6Var.b(fArr);
                    } else {
                        d6Var.a(fArr);
                    }
                    int e6 = sVar.e();
                    int c7 = sVar.c();
                    int i10 = 0;
                    for (int i11 = 0; i11 < 5; i11++) {
                        int i12 = i11 * 2;
                        try {
                            int i13 = (int) fArr[i12];
                            int i14 = (int) fArr[i12 + 1];
                            if (i13 >= -1 && i13 <= e6 && i14 >= -1 && i14 <= c7) {
                                if (sVar.b(i13, i14)) {
                                    i10++;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            throw a.a();
                        }
                    }
                    if (i10 >= 3) {
                        sVar2.c(i9, i8);
                    }
                    i9++;
                    c6 = 0;
                }
                i8++;
                c6 = 0;
            }
            return sVar2;
        }
        throw a.a();
    }
}
