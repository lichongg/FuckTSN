package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class a3 {

    /* renamed from: a, reason: collision with root package name */
    private final w4 f33975a = w4.f34967f;

    public int a(int[] iArr, int i6, int[] iArr2) throws a {
        x4 x4Var = new x4(this.f33975a, iArr);
        int[] iArr3 = new int[i6];
        boolean z5 = false;
        for (int i7 = i6; i7 > 0; i7--) {
            int a6 = x4Var.a(this.f33975a.a(i7));
            iArr3[i6 - i7] = a6;
            if (a6 != 0) {
                z5 = true;
            }
        }
        if (!z5) {
            return 0;
        }
        x4 a7 = this.f33975a.a();
        if (iArr2 != null) {
            for (int i8 : iArr2) {
                int a8 = this.f33975a.a((iArr.length - 1) - i8);
                w4 w4Var = this.f33975a;
                a7 = a7.b(new x4(w4Var, new int[]{w4Var.d(0, a8), 1}));
            }
        }
        x4[] a9 = a(this.f33975a.b(i6, 1), new x4(this.f33975a, iArr3), i6);
        x4 x4Var2 = a9[0];
        x4 x4Var3 = a9[1];
        int[] a10 = a(x4Var2);
        int[] a11 = a(x4Var3, x4Var2, a10);
        for (int i9 = 0; i9 < a10.length; i9++) {
            int length = (iArr.length - 1) - this.f33975a.c(a10[i9]);
            if (length < 0) {
                throw a.a();
            }
            iArr[length] = this.f33975a.d(iArr[length], a11[i9]);
        }
        return a10.length;
    }

    private x4[] a(x4 x4Var, x4 x4Var2, int i6) throws a {
        if (x4Var.a() >= x4Var2.a()) {
            x4Var2 = x4Var;
            x4Var = x4Var2;
        }
        x4 c6 = this.f33975a.c();
        x4 a6 = this.f33975a.a();
        while (true) {
            x4 x4Var3 = a6;
            x4 x4Var4 = c6;
            c6 = x4Var3;
            if (x4Var.a() >= i6 / 2) {
                if (!x4Var.b()) {
                    x4 c7 = this.f33975a.c();
                    int b6 = this.f33975a.b(x4Var.b(x4Var.a()));
                    while (x4Var2.a() >= x4Var.a() && !x4Var2.b()) {
                        int a7 = x4Var2.a() - x4Var.a();
                        int c8 = this.f33975a.c(x4Var2.b(x4Var2.a()), b6);
                        c7 = c7.a(this.f33975a.b(a7, c8));
                        x4Var2 = x4Var2.c(x4Var.a(a7, c8));
                    }
                    a6 = c7.b(c6).c(x4Var4).c();
                    x4 x4Var5 = x4Var2;
                    x4Var2 = x4Var;
                    x4Var = x4Var5;
                } else {
                    throw a.a();
                }
            } else {
                int b7 = c6.b(0);
                if (b7 != 0) {
                    int b8 = this.f33975a.b(b7);
                    return new x4[]{c6.c(b8), x4Var.c(b8)};
                }
                throw a.a();
            }
        }
    }

    private int[] a(x4 x4Var) throws a {
        int a6 = x4Var.a();
        int[] iArr = new int[a6];
        int i6 = 0;
        for (int i7 = 1; i7 < this.f33975a.b() && i6 < a6; i7++) {
            if (x4Var.a(i7) == 0) {
                iArr[i6] = this.f33975a.b(i7);
                i6++;
            }
        }
        if (i6 == a6) {
            return iArr;
        }
        throw a.a();
    }

    private int[] a(x4 x4Var, x4 x4Var2, int[] iArr) {
        int a6 = x4Var2.a();
        int[] iArr2 = new int[a6];
        for (int i6 = 1; i6 <= a6; i6++) {
            iArr2[a6 - i6] = this.f33975a.c(i6, x4Var2.b(i6));
        }
        x4 x4Var3 = new x4(this.f33975a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            int b6 = this.f33975a.b(iArr[i7]);
            iArr3[i7] = this.f33975a.c(this.f33975a.d(0, x4Var.a(b6)), this.f33975a.b(x4Var3.a(b6)));
        }
        return iArr3;
    }
}
