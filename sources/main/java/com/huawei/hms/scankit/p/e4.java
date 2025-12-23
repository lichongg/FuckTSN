package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e4 extends q3 {

    /* renamed from: f, reason: collision with root package name */
    private static int f34216f = 3;

    /* renamed from: g, reason: collision with root package name */
    private static int f34217g = 8;

    /* renamed from: h, reason: collision with root package name */
    private static int f34218h = 7;

    /* renamed from: i, reason: collision with root package name */
    private static int f34219i = 40;

    /* renamed from: j, reason: collision with root package name */
    private static int f34220j = 24;

    /* renamed from: e, reason: collision with root package name */
    private s f34221e;

    private static int a(int i6, int i7, int i8) {
        return i6 < i7 ? i7 : i6 > i8 ? i8 : i6;
    }

    private void a(boolean z5) {
        if (z5) {
            f34216f = 2;
            f34217g = 4;
            f34218h = 3;
            f34219i = 20;
            return;
        }
        f34216f = 3;
        f34217g = 8;
        f34218h = 7;
        f34219i = 40;
    }

    public e4(p4 p4Var) {
        super(p4Var);
        a(r3.f34743n);
    }

    @Override // com.huawei.hms.scankit.p.q3, com.huawei.hms.scankit.p.o
    public s a() throws a {
        s sVar = this.f34221e;
        if (sVar != null) {
            return sVar;
        }
        p4 c6 = c();
        int c7 = c6.c();
        int a6 = c6.a();
        int i6 = f34219i;
        if (c7 >= i6 && a6 >= i6) {
            byte[] b6 = c6.b();
            int i7 = f34216f;
            int i8 = c7 >> i7;
            int i9 = f34218h;
            if ((c7 & i9) != 0) {
                i8++;
            }
            int i10 = a6 >> i7;
            if ((i9 & a6) != 0) {
                i10++;
            }
            int i11 = i10;
            this.f34221e = a(b6, i8, i11, c7, a6, a(b6, i8, i11, c7, a6));
        } else {
            this.f34221e = super.a();
        }
        return this.f34221e;
    }

    @Override // com.huawei.hms.scankit.p.q3, com.huawei.hms.scankit.p.o
    public o a(p4 p4Var) {
        return new e4(p4Var);
    }

    private static s a(byte[] bArr, int i6, int i7, int i8, int i9, int[][] iArr) {
        int i10;
        int i11;
        int i12;
        int[] iArr2 = new int[i6 * i7];
        for (int i13 = 0; i13 < i7; i13++) {
            int a6 = a(i13, 2, i7 - 3);
            for (int i14 = 0; i14 < i6; i14++) {
                int a7 = a(i14, 2, i6 - 3);
                int[] iArr3 = iArr[a6 + 2];
                int i15 = a7 + 2;
                int i16 = iArr3[i15];
                if (a6 == 2 && a7 == 2) {
                    i12 = 0;
                } else if (a6 == 2) {
                    i11 = iArr3[a7 - 3];
                    i12 = 0;
                    i10 = 0;
                    iArr2[(i13 * i6) + i14] = (((i16 + i10) - i12) - i11) / 25;
                } else if (a7 == 2) {
                    i12 = iArr[a6 - 3][i15];
                } else {
                    int[] iArr4 = iArr[a6 - 3];
                    int i17 = a7 - 3;
                    i10 = iArr4[i17];
                    int i18 = iArr4[i15];
                    i11 = iArr3[i17];
                    i12 = i18;
                    iArr2[(i13 * i6) + i14] = (((i16 + i10) - i12) - i11) / 25;
                }
                i11 = 0;
                i10 = 0;
                iArr2[(i13 * i6) + i14] = (((i16 + i10) - i12) - i11) / 25;
            }
        }
        return new s(i8, i9, (i8 + 31) / 32, a(bArr, iArr2, i6, i7, i8, i9));
    }

    private static int[] a(byte[] bArr, int[] iArr, int i6, int i7, int i8, int i9) {
        int i10;
        int i11 = (i8 + 31) / 32;
        int i12 = i11 * i9;
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr2[i13] = 0;
        }
        int i14 = f34217g;
        for (int i15 = 0; i15 < i9; i15++) {
            int i16 = i15 / i14;
            for (int i17 = 0; i17 < i8; i17++) {
                if ((bArr[(i15 * i8) + i17] & 255) <= iArr[(i16 * i6) + (i17 / i14)] && (i10 = (i15 * i11) + (i17 / 32)) < i12) {
                    iArr2[i10] = iArr2[i10] | (1 << (i17 & 31));
                }
            }
        }
        return iArr2;
    }

    private static int[][] a(byte[] bArr, int i6, int i7, int i8, int i9) {
        int i10 = f34217g;
        int i11 = i9 - i10;
        int i12 = i8 - i10;
        char c6 = 1;
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, i7, i6);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, i7, i6);
        int i13 = 0;
        while (i13 < i7) {
            int i14 = i13 << f34216f;
            if (i14 > i11) {
                i14 = i11;
            }
            int i15 = 0;
            int i16 = 0;
            while (i15 < i6) {
                int i17 = i15 << f34216f;
                if (i17 > i12) {
                    i17 = i12;
                }
                int[] a6 = a(i17, i14, i8, bArr);
                int i18 = a6[0];
                int i19 = a6[c6];
                int i20 = a6[2];
                int i21 = i18 >> (f34216f * 2);
                if (i20 - i19 <= f34220j) {
                    i21 = i19 / 2;
                    if (i13 > 0 && i15 > 0) {
                        int[] iArr3 = iArr2[i13 - 1];
                        int i22 = i15 - 1;
                        int i23 = ((iArr3[i15] + (iArr2[i13][i22] * 2)) + iArr3[i22]) / 4;
                        if (i19 < i23) {
                            i21 = i23;
                        }
                    }
                }
                i16 += i21;
                iArr2[i13][i15] = i21;
                if (i13 == 0 && i15 == 0) {
                    iArr[i13][i15] = i21;
                } else if (i13 == 0) {
                    iArr[i13][i15] = i16;
                } else {
                    iArr[i13][i15] = iArr[i13 - 1][i15] + i16;
                }
                i15++;
                c6 = 1;
            }
            i13++;
            c6 = 1;
        }
        return iArr;
    }

    private static int[] a(int i6, int i7, int i8, byte[] bArr) {
        int i9 = (i7 * i8) + i6;
        int i10 = 0;
        int i11 = 0;
        int i12 = 255;
        int i13 = 0;
        while (i10 < f34217g) {
            for (int i14 = 0; i14 < f34217g; i14++) {
                int i15 = bArr[i9 + i14] & 255;
                i11 += i15;
                if (i15 < i12) {
                    i12 = i15;
                }
                if (i15 > i13) {
                    i13 = i15;
                }
            }
            if (i13 - i12 > f34220j) {
                while (true) {
                    i10++;
                    i9 += i8;
                    if (i10 < f34217g) {
                        for (int i16 = 0; i16 < f34217g; i16++) {
                            i11 += bArr[i9 + i16] & 255;
                        }
                    }
                }
            }
            i10++;
            i9 += i8;
        }
        return new int[]{i11, i12, i13};
    }
}
