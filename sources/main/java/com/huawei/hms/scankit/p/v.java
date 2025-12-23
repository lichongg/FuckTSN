package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    private final s f34882a;

    /* renamed from: b, reason: collision with root package name */
    private final s f34883b;

    /* renamed from: c, reason: collision with root package name */
    private final z7 f34884c;

    private static z7 b(s sVar) throws a {
        return z7.a(sVar.c(), sVar.e());
    }

    z7 a() {
        return this.f34884c;
    }

    private int[] a(int i6, int i7, int i8, int i9, byte[] bArr, int i10) {
        while (true) {
            if (i6 < i7 && i8 >= 0 && !this.f34883b.b(i8, i6)) {
                bArr[i10] = (byte) b(i6, i8, i7, i9);
                i10++;
            }
            int i11 = i6 - 2;
            int i12 = i8 + 2;
            if (i11 < 0 || i12 >= i9) {
                break;
            }
            i6 = i11;
            i8 = i12;
        }
        int i13 = i6 - 1;
        int i14 = i8 + 5;
        while (true) {
            if (i13 >= 0 && i14 < i9 && !this.f34883b.b(i14, i13)) {
                bArr[i10] = (byte) b(i13, i14, i7, i9);
                i10++;
            }
            int i15 = i13 + 2;
            int i16 = i14 - 2;
            if (i15 >= i7 || i16 < 0) {
                break;
            }
            i13 = i15;
            i14 = i16;
        }
        return new int[]{i13 + 5, i14 - 1, i10};
    }

    private int c(int i6, int i7) {
        int i8 = i6 - 1;
        int i9 = (a(i8, 0, i6, i7) ? 1 : 0) << 1;
        int i10 = i7 - 1;
        if (a(i8, i10, i6, i7)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        int i12 = i7 - 3;
        if (a(0, i12, i6, i7)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        int i14 = i7 - 2;
        if (a(0, i14, i6, i7)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        if (a(0, i10, i6, i7)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (a(1, i12, i6, i7)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (a(1, i14, i6, i7)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        return a(1, i10, i6, i7) ? i18 | 1 : i18;
    }

    private int d(int i6, int i7) {
        int i8 = (a(i6 + (-3), 0, i6, i7) ? 1 : 0) << 1;
        if (a(i6 - 2, 0, i6, i7)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(i6 - 1, 0, i6, i7)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(0, i7 - 2, i6, i7)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        int i12 = i7 - 1;
        if (a(0, i12, i6, i7)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        if (a(1, i12, i6, i7)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(2, i12, i6, i7)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(3, i12, i6, i7) ? i15 | 1 : i15;
    }

    v(s sVar) throws a {
        int c6 = sVar.c();
        if (c6 >= 8 && c6 <= 144 && (c6 & 1) == 0) {
            this.f34884c = b(sVar);
            s a6 = a(sVar);
            this.f34882a = a6;
            this.f34883b = new s(a6.e(), a6.c());
            return;
        }
        throw a.a();
    }

    byte[] b() throws a {
        byte[] bArr = new byte[this.f34884c.g()];
        int c6 = this.f34882a.c();
        int e6 = this.f34882a.e();
        int i6 = 4;
        int i7 = 0;
        int i8 = 0;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (true) {
            if (i6 == c6 && i7 == 0 && !z5) {
                bArr[i8] = (byte) a(c6, e6);
                i6 -= 2;
                i7 += 2;
                i8++;
                z5 = true;
            } else {
                int i9 = c6 - 2;
                if (i6 != i9 || i7 != 0 || (e6 & 3) == 0 || z6) {
                    if (i6 == c6 + 4 && i7 == 2 && (e6 & 7) == 0 && !z7) {
                        bArr[i8] = (byte) c(c6, e6);
                        i6 -= 2;
                        i7 += 2;
                        i8++;
                        z7 = true;
                    } else if (i6 == i9 && i7 == 0 && (e6 & 7) == 4 && !z8) {
                        bArr[i8] = (byte) d(c6, e6);
                        i6 -= 2;
                        i7 += 2;
                        i8++;
                        z8 = true;
                    } else {
                        int[] a6 = a(i6, c6, i7, e6, bArr, i8);
                        int i10 = a6[0];
                        int i11 = a6[1];
                        i8 = a6[2];
                        i6 = i10;
                        i7 = i11;
                    }
                    if (i6 < c6 && i7 >= e6) {
                        break;
                    }
                } else {
                    bArr[i8] = (byte) b(c6, e6);
                    i6 -= 2;
                    i7 += 2;
                    i8++;
                    z6 = true;
                }
            }
            if (i6 < c6) {
            }
        }
        if (i8 == this.f34884c.g()) {
            return bArr;
        }
        throw a.a();
    }

    private boolean a(int i6, int i7, int i8, int i9) {
        if (i6 < 0) {
            i6 += i8;
            i7 += 4 - ((i8 + 4) & 7);
        }
        if (i7 < 0) {
            i7 += i9;
            i6 += 4 - ((i9 + 4) & 7);
        }
        this.f34883b.c(i7, i6);
        return this.f34882a.b(i7, i6);
    }

    private int a(int i6, int i7) {
        int i8 = i6 - 1;
        int i9 = (a(i8, 0, i6, i7) ? 1 : 0) << 1;
        if (a(i8, 1, i6, i7)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(i8, 2, i6, i7)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(0, i7 - 2, i6, i7)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        int i13 = i7 - 1;
        if (a(0, i13, i6, i7)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        if (a(1, i13, i6, i7)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(2, i13, i6, i7)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return a(3, i13, i6, i7) ? i16 | 1 : i16;
    }

    private s a(s sVar) {
        int f6 = this.f34884c.f();
        int e6 = this.f34884c.e();
        if (sVar.c() == f6) {
            int c6 = this.f34884c.c();
            int b6 = this.f34884c.b();
            int i6 = f6 / c6;
            int i7 = e6 / b6;
            s sVar2 = new s(i7 * b6, i6 * c6);
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = i8 * c6;
                for (int i10 = 0; i10 < i7; i10++) {
                    int i11 = i10 * b6;
                    for (int i12 = 0; i12 < c6; i12++) {
                        int i13 = ((c6 + 2) * i8) + 1 + i12;
                        int i14 = i9 + i12;
                        for (int i15 = 0; i15 < b6; i15++) {
                            if (sVar.b(((b6 + 2) * i10) + 1 + i15, i13)) {
                                sVar2.c(i11 + i15, i14);
                            }
                        }
                    }
                }
            }
            return sVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int b(int i6, int i7, int i8, int i9) {
        int i10 = i6 - 2;
        int i11 = i7 - 2;
        int i12 = (a(i10, i11, i8, i9) ? 1 : 0) << 1;
        int i13 = i7 - 1;
        if (a(i10, i13, i8, i9)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        int i15 = i6 - 1;
        if (a(i15, i11, i8, i9)) {
            i14 |= 1;
        }
        int i16 = i14 << 1;
        if (a(i15, i13, i8, i9)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (a(i15, i7, i8, i9)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (a(i6, i11, i8, i9)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (a(i6, i13, i8, i9)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        return a(i6, i7, i8, i9) ? i20 | 1 : i20;
    }

    private int b(int i6, int i7) {
        int i8 = (a(i6 + (-3), 0, i6, i7) ? 1 : 0) << 1;
        if (a(i6 - 2, 0, i6, i7)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(i6 - 1, 0, i6, i7)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(0, i7 - 4, i6, i7)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(0, i7 - 3, i6, i7)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(0, i7 - 2, i6, i7)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        int i14 = i7 - 1;
        if (a(0, i14, i6, i7)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        return a(1, i14, i6, i7) ? i15 | 1 : i15;
    }
}
