package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class q3 extends o {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f34705d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private byte[] f34706b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f34707c;

    @Override // com.huawei.hms.scankit.p.o
    public r a(int i6, r rVar) throws a {
        p4 c6 = c();
        int c7 = c6.c();
        if (rVar == null || rVar.e() < c7) {
            rVar = new r(c7);
        } else {
            rVar.a();
        }
        a(c7);
        byte[] a6 = c6.a(i6, this.f34706b);
        int[] iArr = this.f34707c;
        for (int i7 = 0; i7 < c7; i7++) {
            int i8 = (a6[i7] & 255) >> 3;
            iArr[i8] = iArr[i8] + 1;
        }
        int a7 = a(iArr, false);
        if (c7 < 3) {
            for (int i9 = 0; i9 < c7; i9++) {
                if ((a6[i9] & 255) < a7) {
                    rVar.g(i9);
                }
            }
        } else {
            int i10 = a6[0] & 255;
            int i11 = a6[1] & 255;
            int i12 = 1;
            while (i12 < c7 - 1) {
                int i13 = i12 + 1;
                int i14 = a6[i13] & 255;
                if ((((i11 * 4) - i10) - i14) / 2 < a7) {
                    rVar.g(i12);
                }
                i10 = i11;
                i12 = i13;
                i11 = i14;
            }
        }
        return rVar;
    }

    public q3(p4 p4Var) {
        super(p4Var);
        this.f34706b = f34705d;
        this.f34707c = new int[32];
    }

    @Override // com.huawei.hms.scankit.p.o
    public s a() throws a {
        p4 c6 = c();
        int c7 = c6.c();
        int a6 = c6.a();
        a(c7);
        int[] iArr = this.f34707c;
        for (int i6 = 1; i6 < 5; i6++) {
            byte[] a7 = c6.a((a6 * i6) / 5, this.f34706b);
            int i7 = (c7 * 4) / 5;
            for (int i8 = c7 / 5; i8 < i7; i8++) {
                int i9 = (a7[i8] & 255) >> 3;
                iArr[i9] = iArr[i9] + 1;
            }
        }
        int a8 = a(iArr, true);
        byte[] b6 = c6.b();
        int i10 = (c7 + 31) / 32;
        int[] iArr2 = new int[i10 * a6];
        for (int i11 = 0; i11 < a6; i11++) {
            int i12 = i11 * c7;
            for (int i13 = 0; i13 < c7; i13++) {
                if ((b6[i12 + i13] & 255) < a8) {
                    int i14 = (i11 * i10) + (i13 >> 5);
                    iArr2[i14] = iArr2[i14] | (1 << (i13 & 31));
                }
            }
        }
        return new s(c7, a6, i10, iArr2);
    }

    @Override // com.huawei.hms.scankit.p.o
    public o a(p4 p4Var) {
        return new q3(p4Var);
    }

    private void a(int i6) {
        if (this.f34706b.length < i6) {
            this.f34706b = new byte[i6];
        }
        for (int i7 = 0; i7 < 32; i7++) {
            this.f34707c[i7] = 0;
        }
    }

    private static int a(int[] iArr, boolean z5) throws a {
        int length = iArr.length;
        boolean z6 = false;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = iArr[i9];
            if (i10 > i6) {
                i8 = i9;
                i6 = i10;
            }
            if (i10 > i7) {
                i7 = i10;
            }
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = i13 - i8;
            int i15 = iArr[i13] * i14 * i14;
            if (i15 > i12) {
                i11 = i13;
                i12 = i15;
            }
        }
        if (i8 <= i11) {
            int i16 = i8;
            i8 = i11;
            i11 = i16;
        }
        int i17 = i8 - i11;
        if (i17 <= length / 16) {
            throw a.a();
        }
        int i18 = i8 - 1;
        int i19 = i18;
        int i20 = -1;
        while (i18 > i11) {
            int i21 = i18 - i11;
            int i22 = i21 * i21 * (i8 - i18) * (i7 - iArr[i18]);
            if (i22 > i20) {
                i19 = i18;
                i20 = i22;
            }
            i18--;
        }
        if (z5) {
            if (i19 < 10 && i20 < 100000 && i17 < 10) {
                z6 = true;
            }
            r3.f34749t = z6;
        }
        return i19 << 3;
    }
}
