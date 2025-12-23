package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p6 {

    /* renamed from: a, reason: collision with root package name */
    private final o3 f34683a;

    public void a(int[] iArr, int i6) throws a {
        p3 p3Var = new p3(this.f34683a, iArr);
        int[] iArr2 = new int[i6];
        boolean z5 = true;
        for (int i7 = 0; i7 < i6; i7++) {
            o3 o3Var = this.f34683a;
            int a6 = p3Var.a(o3Var.a(o3Var.a() + i7));
            iArr2[(i6 - 1) - i7] = a6;
            if (a6 != 0) {
                z5 = false;
            }
        }
        if (z5) {
            return;
        }
        p3[] a7 = a(this.f34683a.b(i6, 1), new p3(this.f34683a, iArr2), i6);
        p3 p3Var2 = a7[0];
        p3 p3Var3 = a7[1];
        int[] a8 = a(p3Var2);
        int[] a9 = a(p3Var3, a8);
        for (int i8 = 0; i8 < a8.length; i8++) {
            int length = (iArr.length - 1) - this.f34683a.c(a8[i8]);
            if (length < 0) {
                throw a.a("Bad error location");
            }
            iArr[length] = o3.a(iArr[length], a9[i8]);
        }
    }

    public p6(o3 o3Var) {
        this.f34683a = o3Var;
    }

    private p3[] a(p3 p3Var, p3 p3Var2, int i6) throws a {
        if (p3Var.b() >= p3Var2.b()) {
            p3Var2 = p3Var;
            p3Var = p3Var2;
        }
        p3 d6 = this.f34683a.d();
        p3 b6 = this.f34683a.b();
        while (true) {
            p3 p3Var3 = b6;
            p3 p3Var4 = d6;
            d6 = p3Var3;
            if (p3Var.b() >= i6 / 2) {
                if (!p3Var.c()) {
                    p3 d7 = this.f34683a.d();
                    int b7 = this.f34683a.b(p3Var.b(p3Var.b()));
                    while (p3Var2.b() >= p3Var.b() && !p3Var2.c()) {
                        int b8 = p3Var2.b() - p3Var.b();
                        int c6 = this.f34683a.c(p3Var2.b(p3Var2.b()), b7);
                        d7 = d7.a(this.f34683a.b(b8, c6));
                        p3Var2 = p3Var2.a(p3Var.a(b8, c6));
                    }
                    b6 = d7.c(d6).a(p3Var4);
                    if (p3Var2.b() >= p3Var.b()) {
                        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                    }
                    p3 p3Var5 = p3Var2;
                    p3Var2 = p3Var;
                    p3Var = p3Var5;
                } else {
                    throw a.a("r_{i-1} was zero");
                }
            } else {
                int b9 = d6.b(0);
                if (b9 != 0) {
                    int b10 = this.f34683a.b(b9);
                    return new p3[]{d6.c(b10), p3Var.c(b10)};
                }
                throw a.a("sigmaTilde(0) was zero");
            }
        }
    }

    private int[] a(p3 p3Var) throws a {
        int b6 = p3Var.b();
        if (b6 == 1) {
            return new int[]{p3Var.b(1)};
        }
        int[] iArr = new int[b6];
        int i6 = 0;
        for (int i7 = 1; i7 < this.f34683a.c() && i6 < b6; i7++) {
            if (p3Var.a(i7) == 0) {
                iArr[i6] = this.f34683a.b(i7);
                i6++;
            }
        }
        if (i6 == b6) {
            return iArr;
        }
        throw a.a("Error locator degree does not match number of roots");
    }

    private int[] a(p3 p3Var, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            int b6 = this.f34683a.b(iArr[i6]);
            int i7 = 1;
            for (int i8 = 0; i8 < length; i8++) {
                if (i6 != i8) {
                    int c6 = this.f34683a.c(iArr[i8], b6);
                    i7 = this.f34683a.c(i7, (c6 & 1) == 0 ? c6 | 1 : c6 & (-2));
                }
            }
            iArr2[i6] = this.f34683a.c(p3Var.a(b6), this.f34683a.b(i7));
            if (this.f34683a.a() != 0) {
                iArr2[i6] = this.f34683a.c(iArr2[i6], b6);
            }
        }
        return iArr2;
    }
}
