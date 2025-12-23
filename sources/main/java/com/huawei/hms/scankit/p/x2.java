package com.huawei.hms.scankit.p;

import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class x2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f35001a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i6, boolean z5) {
        return ((z5 ? 88 : 112) + (i6 * 16)) * i6;
    }

    public static f a(byte[] bArr, int i6, int i7) {
        r rVar;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        r a6 = new c4(bArr).a();
        int e6 = ((a6.e() * i6) / 100) + 11;
        int e7 = a6.e() + e6;
        int i12 = 0;
        int i13 = 1;
        if (i7 == 0) {
            r rVar2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i14 <= 32) {
                boolean z6 = i14 <= 3;
                int i16 = z6 ? i14 + 1 : i14;
                int a7 = a(i16, z6);
                if (e7 <= a7) {
                    if (rVar2 == null || i15 != f35001a[i16]) {
                        int i17 = f35001a[i16];
                        i15 = i17;
                        rVar2 = a(a6, i17);
                    }
                    int i18 = a7 - (a7 % i15);
                    if ((!z6 || rVar2.e() <= i15 * 64) && rVar2.e() + e6 <= i18) {
                        rVar = rVar2;
                        i8 = i15;
                        z5 = z6;
                        i9 = i16;
                        i10 = a7;
                    }
                }
                i14++;
                i12 = 0;
                i13 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z5 = i7 < 0;
        i9 = Math.abs(i7);
        if (i9 > (z5 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Illegal value %s for layers", Integer.valueOf(i7)));
        }
        i10 = a(i9, z5);
        i8 = f35001a[i9];
        int i19 = i10 - (i10 % i8);
        rVar = a(a6, i8);
        if (rVar.e() + e6 > i19) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z5 && rVar.e() > i8 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        r b6 = b(rVar, i10, i8);
        int e8 = rVar.e() / i8;
        r a8 = a(z5, i9, e8);
        int i20 = (z5 ? 11 : 14) + (i9 * 4);
        int[] iArr = new int[i20];
        int i21 = 2;
        if (z5) {
            for (int i22 = 0; i22 < i20; i22++) {
                iArr[i22] = i22;
            }
            i11 = i20;
        } else {
            int i23 = i20 / 2;
            i11 = i20 + 1 + (((i23 - 1) / 15) * 2);
            int i24 = i11 / 2;
            for (int i25 = 0; i25 < i23; i25++) {
                iArr[(i23 - i25) - 1] = (i24 - r15) - 1;
                iArr[i23 + i25] = (i25 / 15) + i25 + i24 + i13;
            }
        }
        s sVar = new s(i11);
        int i26 = 0;
        int i27 = 0;
        while (i26 < i9) {
            int i28 = ((i9 - i26) * 4) + (z5 ? 9 : 12);
            int i29 = 0;
            while (i29 < i28) {
                int i30 = i29 * 2;
                while (i12 < i21) {
                    if (b6.b(i27 + i30 + i12)) {
                        int i31 = i26 * 2;
                        sVar.c(iArr[i31 + i12], iArr[i31 + i29]);
                    }
                    if (b6.b((i28 * 2) + i27 + i30 + i12)) {
                        int i32 = i26 * 2;
                        sVar.c(iArr[i32 + i29], iArr[((i20 - 1) - i32) - i12]);
                    }
                    if (b6.b((i28 * 4) + i27 + i30 + i12)) {
                        int i33 = (i20 - 1) - (i26 * 2);
                        sVar.c(iArr[i33 - i12], iArr[i33 - i29]);
                    }
                    if (b6.b((i28 * 6) + i27 + i30 + i12)) {
                        int i34 = i26 * 2;
                        sVar.c(iArr[((i20 - 1) - i34) - i29], iArr[i34 + i12]);
                    }
                    i12++;
                    i21 = 2;
                }
                i29++;
                i12 = 0;
                i21 = 2;
            }
            i27 += i28 * 8;
            i26++;
            i12 = 0;
            i21 = 2;
        }
        a(sVar, z5, i11, a8);
        if (z5) {
            a(sVar, i11 / 2, 5);
        } else {
            int i35 = i11 / 2;
            a(sVar, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i36 < (i20 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i11; i38 += 2) {
                    int i39 = i35 - i37;
                    sVar.c(i39, i38);
                    int i40 = i35 + i37;
                    sVar.c(i40, i38);
                    sVar.c(i38, i39);
                    sVar.c(i38, i40);
                }
                i36 += 15;
                i37 += 16;
            }
        }
        f fVar = new f();
        fVar.a(z5);
        fVar.c(i11);
        fVar.b(i9);
        fVar.a(e8);
        fVar.a(sVar);
        return fVar;
    }

    private static r b(r rVar, int i6, int i7) {
        int e6 = rVar.e() / i7;
        q6 q6Var = new q6(a(i7));
        int i8 = i6 / i7;
        int[] a6 = a(rVar, i7, i8);
        q6Var.a(a6, i8 - e6);
        r rVar2 = new r();
        rVar2.a(0, i6 % i7);
        for (int i9 : a6) {
            rVar2.a(i9, i7);
        }
        return rVar2;
    }

    private static void a(s sVar, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8 += 2) {
            int i9 = i6 - i8;
            int i10 = i9;
            while (true) {
                int i11 = i6 + i8;
                if (i10 <= i11) {
                    sVar.c(i10, i9);
                    sVar.c(i10, i11);
                    sVar.c(i9, i10);
                    sVar.c(i11, i10);
                    i10++;
                }
            }
        }
        int i12 = i6 - i7;
        sVar.c(i12, i12);
        int i13 = i12 + 1;
        sVar.c(i13, i12);
        sVar.c(i12, i13);
        int i14 = i6 + i7;
        sVar.c(i14, i12);
        sVar.c(i14, i13);
        sVar.c(i14, i14 - 1);
    }

    static r a(boolean z5, int i6, int i7) {
        r rVar = new r();
        if (z5) {
            rVar.a(i6 - 1, 2);
            rVar.a(i7 - 1, 6);
            return b(rVar, 28, 4);
        }
        rVar.a(i6 - 1, 5);
        rVar.a(i7 - 1, 11);
        return b(rVar, 40, 4);
    }

    private static void a(s sVar, boolean z5, int i6, r rVar) {
        int i7 = i6 / 2;
        int i8 = 0;
        if (z5) {
            while (i8 < 7) {
                int i9 = (i7 - 3) + i8;
                if (rVar.b(i8)) {
                    sVar.c(i9, i7 - 5);
                }
                if (rVar.b(i8 + 7)) {
                    sVar.c(i7 + 5, i9);
                }
                if (rVar.b(20 - i8)) {
                    sVar.c(i9, i7 + 5);
                }
                if (rVar.b(27 - i8)) {
                    sVar.c(i7 - 5, i9);
                }
                i8++;
            }
            return;
        }
        while (i8 < 10) {
            int i10 = (i7 - 5) + i8 + (i8 / 5);
            if (rVar.b(i8)) {
                sVar.c(i10, i7 - 7);
            }
            if (rVar.b(i8 + 10)) {
                sVar.c(i7 + 7, i10);
            }
            if (rVar.b(29 - i8)) {
                sVar.c(i10, i7 + 7);
            }
            if (rVar.b(39 - i8)) {
                sVar.c(i7 - 7, i10);
            }
            i8++;
        }
    }

    private static int[] a(r rVar, int i6, int i7) {
        int[] iArr = new int[i7];
        int e6 = rVar.e() / i6;
        for (int i8 = 0; i8 < e6; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 |= rVar.b((i8 * i6) + i10) ? 1 << ((i6 - i10) - 1) : 0;
            }
            iArr[i8] = i9;
        }
        return iArr;
    }

    private static o3 a(int i6) {
        if (i6 == 4) {
            return o3.f34648k;
        }
        if (i6 == 6) {
            return o3.f34647j;
        }
        if (i6 == 8) {
            return o3.f34651n;
        }
        if (i6 == 10) {
            return o3.f34646i;
        }
        if (i6 == 12) {
            return o3.f34645h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i6);
    }

    static r a(r rVar, int i6) {
        r rVar2 = new r();
        int e6 = rVar.e();
        int i7 = (1 << i6) - 2;
        int i8 = 0;
        while (i8 < e6) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i8 + i10;
                if (i11 >= e6 || rVar.b(i11)) {
                    i9 |= 1 << ((i6 - 1) - i10);
                }
            }
            int i12 = i9 & i7;
            if (i12 == i7) {
                rVar2.a(i12, i6);
            } else if (i12 == 0) {
                rVar2.a(i9 | 1, i6);
            } else {
                rVar2.a(i9, i6);
                i8 += i6;
            }
            i8--;
            i8 += i6;
        }
        return rVar2;
    }
}
