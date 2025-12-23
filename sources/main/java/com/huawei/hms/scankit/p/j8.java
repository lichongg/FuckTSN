package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j8 {

    /* renamed from: a, reason: collision with root package name */
    private final s f34466a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34467b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34468c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34469d;

    /* renamed from: e, reason: collision with root package name */
    private final int f34470e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34471f;

    /* renamed from: g, reason: collision with root package name */
    private final int f34472g;

    public j8(s sVar) throws a {
        this(sVar, 10, sVar.e() / 2, sVar.c() / 2);
    }

    private u6[] b(int[] iArr) throws a {
        int i6 = iArr[1] - iArr[0];
        u6 u6Var = null;
        u6 u6Var2 = null;
        for (int i7 = 1; u6Var2 == null && i7 < i6; i7++) {
            u6Var2 = a(iArr[0], r6 - i7, r4 + i7, iArr[3]);
        }
        if (u6Var2 == null) {
            throw a.a();
        }
        u6 u6Var3 = null;
        for (int i8 = 1; u6Var3 == null && i8 < i6; i8++) {
            u6Var3 = a(iArr[0], r8 + i8, r5 + i8, iArr[2]);
        }
        if (u6Var3 == null) {
            throw a.a();
        }
        u6 u6Var4 = null;
        for (int i9 = 1; u6Var4 == null && i9 < i6; i9++) {
            u6Var4 = a(iArr[1], r10 + i9, r2 - i9, iArr[2]);
        }
        if (u6Var4 == null) {
            throw a.a();
        }
        for (int i10 = 1; u6Var == null && i10 < i6; i10++) {
            u6Var = a(iArr[1], r9 - i10, r3 - i10, iArr[3]);
        }
        if (u6Var != null) {
            return a(u6Var, u6Var2, u6Var4, u6Var3);
        }
        throw a.a();
    }

    private void c(int[] iArr) {
        int i6;
        boolean z5 = true;
        while (true) {
            if ((!z5 && iArr[9] == 1) || (i6 = iArr[0]) < 0) {
                return;
            }
            boolean a6 = a(iArr[2], iArr[3], i6, false);
            if (a6) {
                iArr[0] = iArr[0] - 1;
                iArr[5] = 1;
                iArr[9] = 1;
            } else if (iArr[9] != 1) {
                iArr[0] = iArr[0] - 1;
            }
            z5 = a6;
        }
    }

    private void d(int[] iArr) {
        int i6;
        boolean z5 = true;
        while (true) {
            if ((!z5 && iArr[7] == 1) || (i6 = iArr[1]) >= this.f34468c) {
                return;
            }
            z5 = a(iArr[2], iArr[3], i6, false);
            if (z5) {
                iArr[1] = iArr[1] + 1;
                iArr[5] = 1;
                iArr[7] = 1;
            } else if (iArr[7] != 1) {
                iArr[1] = iArr[1] + 1;
            }
        }
    }

    private void e(int[] iArr) {
        int i6;
        boolean z5 = true;
        while (true) {
            if ((!z5 && iArr[10] == 1) || (i6 = iArr[2]) < 0) {
                return;
            }
            boolean a6 = a(iArr[0], iArr[1], i6, true);
            if (a6) {
                iArr[2] = iArr[2] - 1;
                iArr[5] = 1;
                iArr[10] = 1;
            } else if (iArr[10] != 1) {
                iArr[2] = iArr[2] - 1;
            }
            z5 = a6;
        }
    }

    public u6[] a() throws a {
        int[] iArr = {this.f34469d, this.f34470e, this.f34472g, this.f34471f, 0, 1, 0, 0, 0, 0, 0};
        while (true) {
            if (iArr[5] != 1) {
                break;
            }
            iArr[5] = 0;
            d(iArr);
            if (iArr[1] >= this.f34468c) {
                iArr[4] = 1;
                break;
            }
            a(iArr);
            if (iArr[3] >= this.f34467b) {
                iArr[4] = 1;
                break;
            }
            c(iArr);
            if (iArr[0] < 0) {
                iArr[4] = 1;
                break;
            }
            e(iArr);
            if (iArr[2] < 0) {
                iArr[4] = 1;
                break;
            }
            if (iArr[5] == 1) {
                iArr[6] = 1;
            }
        }
        if (iArr[4] == 1 || iArr[6] != 1) {
            throw a.a();
        }
        return b(iArr);
    }

    public j8(s sVar, int i6, int i7, int i8) throws a {
        this.f34466a = sVar;
        int c6 = sVar.c();
        this.f34467b = c6;
        int e6 = sVar.e();
        this.f34468c = e6;
        int i9 = i6 / 2;
        int i10 = i7 - i9;
        this.f34469d = i10;
        int i11 = i7 + i9;
        this.f34470e = i11;
        int i12 = i8 - i9;
        this.f34472g = i12;
        int i13 = i8 + i9;
        this.f34471f = i13;
        if (i12 < 0 || i10 < 0 || i13 >= c6 || i11 >= e6) {
            throw a.a();
        }
    }

    private void a(int[] iArr) {
        int i6;
        boolean z5 = true;
        while (true) {
            if ((!z5 && iArr[8] == 1) || (i6 = iArr[3]) >= this.f34467b) {
                return;
            }
            boolean a6 = a(iArr[0], iArr[1], i6, true);
            if (a6) {
                iArr[3] = iArr[3] + 1;
                iArr[5] = 1;
                iArr[8] = 1;
            } else if (iArr[8] != 1) {
                iArr[3] = iArr[3] + 1;
            }
            z5 = a6;
        }
    }

    private u6 a(float f6, float f7, float f8, float f9) {
        int a6 = s4.a(s4.a(f6, f7, f8, f9));
        float f10 = a6;
        float f11 = (f8 - f6) / f10;
        float f12 = (f9 - f7) / f10;
        for (int i6 = 0; i6 < a6; i6++) {
            float f13 = i6;
            int a7 = s4.a((f13 * f11) + f6);
            int a8 = s4.a((f13 * f12) + f7);
            if (this.f34466a.b(a7, a8)) {
                return new u6(a7, a8);
            }
        }
        return null;
    }

    private u6[] a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) {
        float b6 = u6Var.b();
        float c6 = u6Var.c();
        float b7 = u6Var2.b();
        float c7 = u6Var2.c();
        float b8 = u6Var3.b();
        float c8 = u6Var3.c();
        float b9 = u6Var4.b();
        float c9 = u6Var4.c();
        if (b6 < this.f34468c / 2.0f) {
            return new u6[]{new u6(b9 - 1.0f, c9 + 1.0f), new u6(b7 + 1.0f, c7 + 1.0f), new u6(b8 - 1.0f, c8 - 1.0f), new u6(b6 + 1.0f, c6 - 1.0f)};
        }
        return new u6[]{new u6(b9 + 1.0f, c9 + 1.0f), new u6(b7 + 1.0f, c7 - 1.0f), new u6(b8 - 1.0f, c8 + 1.0f), new u6(b6 - 1.0f, c6 - 1.0f)};
    }

    private boolean a(int i6, int i7, int i8, boolean z5) {
        if (z5) {
            while (i6 <= i7) {
                if (this.f34466a.b(i6, i8)) {
                    return true;
                }
                i6++;
            }
            return false;
        }
        while (i6 <= i7) {
            if (this.f34466a.b(i8, i6)) {
                return true;
            }
            i6++;
        }
        return false;
    }
}
