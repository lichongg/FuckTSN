package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    private final s f34837a;

    /* renamed from: b, reason: collision with root package name */
    private b8 f34838b;

    /* renamed from: c, reason: collision with root package name */
    private l3 f34839c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34840d;

    private int a(int i6, int i7, int i8) {
        return this.f34840d ? this.f34837a.b(i7, i6) : this.f34837a.b(i6, i7) ? (i8 << 1) | 1 : i8 << 1;
    }

    void a(boolean z5) {
        this.f34838b = null;
        this.f34839c = null;
        this.f34840d = z5;
    }

    byte[] b() throws a {
        l3 c6 = c();
        b8 d6 = d();
        g1 g1Var = g1.values()[c6.a()];
        int c7 = this.f34837a.c();
        g1Var.a(this.f34837a, c7);
        s a6 = d6.a();
        byte[] bArr = new byte[d6.e()];
        int i6 = c7 - 1;
        boolean z5 = true;
        int i7 = i6;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i7 > 0) {
            if (i7 == 6) {
                i7--;
            }
            for (int i11 = 0; i11 < c7; i11++) {
                int i12 = z5 ? i6 - i11 : i11;
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = i7 - i13;
                    if (!a6.b(i14, i12)) {
                        i10++;
                        i9 <<= 1;
                        if (this.f34837a.b(i14, i12)) {
                            i9 |= 1;
                        }
                        if (i10 == 8) {
                            bArr[i8] = (byte) i9;
                            i8++;
                            i9 = 0;
                            i10 = 0;
                        }
                    }
                }
            }
            z5 = !z5;
            i7 -= 2;
        }
        if (i8 == d6.e()) {
            return bArr;
        }
        throw a.a();
    }

    l3 c() throws a {
        l3 l3Var = this.f34839c;
        if (l3Var != null) {
            return l3Var;
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 6; i8++) {
            i7 = a(i8, 8, i7);
        }
        int a6 = a(8, 7, a(8, 8, a(7, 8, i7)));
        for (int i9 = 5; i9 >= 0; i9--) {
            a6 = a(8, i9, a6);
        }
        int c6 = this.f34837a.c();
        int i10 = c6 - 7;
        for (int i11 = c6 - 1; i11 >= i10; i11--) {
            i6 = a(8, i11, i6);
        }
        for (int i12 = c6 - 8; i12 < c6; i12++) {
            i6 = a(i12, 8, i6);
        }
        l3 a7 = l3.a(a6, i6);
        this.f34839c = a7;
        if (a7 != null) {
            return a7;
        }
        throw a.a();
    }

    b8 d() throws a {
        b8 b8Var = this.f34838b;
        if (b8Var != null) {
            return b8Var;
        }
        int c6 = this.f34837a.c();
        int i6 = (c6 - 17) / 4;
        if (i6 <= 6) {
            return b8.c(i6);
        }
        int i7 = c6 - 11;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 5; i10 >= 0; i10--) {
            for (int i11 = c6 - 9; i11 >= i7; i11--) {
                i9 = a(i11, i10, i9);
            }
        }
        b8 a6 = b8.a(i9);
        if (a6 != null && a6.d() == c6) {
            this.f34838b = a6;
            return a6;
        }
        for (int i12 = 5; i12 >= 0; i12--) {
            for (int i13 = c6 - 9; i13 >= i7; i13--) {
                i8 = a(i12, i13, i8);
            }
        }
        b8 a7 = b8.a(i8);
        if (a7 == null || a7.d() != c6) {
            throw a.a();
        }
        this.f34838b = a7;
        return a7;
    }

    void e() {
        if (this.f34839c == null) {
            return;
        }
        g1.values()[this.f34839c.a()].a(this.f34837a, this.f34837a.c());
    }

    u(s sVar) throws a {
        int c6 = sVar.c();
        if (c6 >= 21 && (c6 & 3) == 1) {
            this.f34837a = sVar;
            return;
        }
        throw a.a();
    }

    void a() {
        int i6 = 0;
        while (i6 < this.f34837a.e()) {
            int i7 = i6 + 1;
            for (int i8 = i7; i8 < this.f34837a.c(); i8++) {
                if (this.f34837a.b(i6, i8) != this.f34837a.b(i8, i6)) {
                    this.f34837a.a(i8, i6);
                    this.f34837a.a(i6, i8);
                }
            }
            i6 = i7;
        }
    }
}
