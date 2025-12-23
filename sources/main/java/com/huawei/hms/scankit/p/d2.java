package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    private final s f34118a;

    /* renamed from: b, reason: collision with root package name */
    private final j8 f34119b;

    private u6[] b(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[3];
        u6 u6Var4 = u6VarArr[2];
        int a6 = a(u6Var, u6Var2);
        int a7 = a(u6Var2, u6Var3);
        int a8 = a(u6Var3, u6Var4);
        int a9 = a(u6Var4, u6Var);
        u6[] u6VarArr2 = {u6Var4, u6Var, u6Var2, u6Var3};
        if (a6 > a7) {
            u6VarArr2[0] = u6Var;
            u6VarArr2[1] = u6Var2;
            u6VarArr2[2] = u6Var3;
            u6VarArr2[3] = u6Var4;
            a6 = a7;
        }
        if (a6 > a8) {
            u6VarArr2[0] = u6Var2;
            u6VarArr2[1] = u6Var3;
            u6VarArr2[2] = u6Var4;
            u6VarArr2[3] = u6Var;
        } else {
            a8 = a6;
        }
        if (a8 > a9) {
            u6VarArr2[0] = u6Var3;
            u6VarArr2[1] = u6Var4;
            u6VarArr2[2] = u6Var;
            u6VarArr2[3] = u6Var2;
        }
        return u6VarArr2;
    }

    private u6[] c(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[2];
        u6 u6Var4 = u6VarArr[3];
        int a6 = (a(u6Var, u6Var4) + 1) * 4;
        if (a(a(u6Var2, u6Var3, a6), u6Var) < a(a(u6Var3, u6Var2, a6), u6Var4)) {
            u6VarArr[0] = u6Var;
            u6VarArr[1] = u6Var2;
            u6VarArr[2] = u6Var3;
            u6VarArr[3] = u6Var4;
            return u6VarArr;
        }
        u6VarArr[0] = u6Var2;
        u6VarArr[1] = u6Var3;
        u6VarArr[2] = u6Var4;
        u6VarArr[3] = u6Var;
        return u6VarArr;
    }

    private u6[] d(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[2];
        u6 u6Var4 = u6VarArr[3];
        int a6 = a(u6Var, u6Var4) + 1;
        u6 a7 = a(u6Var, u6Var2, (a(u6Var3, u6Var4) + 1) * 4);
        u6 a8 = a(u6Var3, u6Var2, a6 * 4);
        int a9 = a(a7, u6Var4);
        int i6 = a9 + 1;
        int a10 = a(a8, u6Var4);
        int i7 = a10 + 1;
        if ((i6 & 1) == 1) {
            i6 = a9 + 2;
        }
        if ((i7 & 1) == 1) {
            i7 = a10 + 2;
        }
        float b6 = (((u6Var.b() + u6Var2.b()) + u6Var3.b()) + u6Var4.b()) / 4.0f;
        float c6 = (((u6Var.c() + u6Var2.c()) + u6Var3.c()) + u6Var4.c()) / 4.0f;
        u6 a11 = a(u6Var, b6, c6);
        u6 a12 = a(u6Var2, b6, c6);
        u6 a13 = a(u6Var3, b6, c6);
        u6 a14 = a(u6Var4, b6, c6);
        int i8 = i7 * 4;
        int i9 = i6 * 4;
        return new u6[]{a(a(a11, a12, i8), a14, i9), a(a(a12, a11, i8), a13, i9), a(a(a13, a14, i8), a12, i9), a(a(a14, a13, i8), a11, i9)};
    }

    public j2 a() throws a {
        int i6;
        u6[] c6 = c(b(this.f34119b.a()));
        u6 a6 = a(c6);
        c6[3] = a6;
        if (a6 == null) {
            throw a.a();
        }
        u6[] d6 = d(c6);
        u6 u6Var = d6[0];
        u6 u6Var2 = d6[1];
        u6 u6Var3 = d6[2];
        u6 u6Var4 = d6[3];
        int a7 = a(u6Var, u6Var4);
        int i7 = a7 + 1;
        int a8 = a(u6Var3, u6Var4);
        int i8 = a8 + 1;
        if ((i7 & 1) == 1) {
            i7 = a7 + 2;
        }
        if ((i8 & 1) == 1) {
            i8 = a8 + 2;
        }
        if (i7 * 4 >= i8 * 7 || i8 * 4 >= i7 * 7) {
            i6 = i7;
        } else {
            i6 = Math.max(i7, i8);
            i8 = i6;
        }
        return new j2(a(this.f34118a, u6Var, u6Var2, u6Var3, u6Var4, i6, i8), new u6[]{u6Var, u6Var2, u6Var3, u6Var4});
    }

    public d2(s sVar) throws a {
        this.f34118a = sVar;
        this.f34119b = new j8(sVar);
    }

    private static u6 a(u6 u6Var, u6 u6Var2, int i6) {
        float f6 = i6 + 1;
        return new u6(u6Var.b() + ((u6Var2.b() - u6Var.b()) / f6), u6Var.c() + ((u6Var2.c() - u6Var.c()) / f6));
    }

    private static u6 a(u6 u6Var, float f6, float f7) {
        float b6 = u6Var.b();
        float c6 = u6Var.c();
        return new u6(b6 < f6 ? b6 - 1.0f : b6 + 1.0f, c6 < f7 ? c6 - 1.0f : c6 + 1.0f);
    }

    private u6 a(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[2];
        u6 u6Var4 = u6VarArr[3];
        int a6 = a(u6Var, u6Var4);
        u6 a7 = a(u6Var, u6Var2, (a(u6Var2, u6Var4) + 1) * 4);
        u6 a8 = a(u6Var3, u6Var2, (a6 + 1) * 4);
        int a9 = a(a7, u6Var4);
        int a10 = a(a8, u6Var4);
        float f6 = a9 + 1;
        u6 u6Var5 = new u6(u6Var4.b() + ((u6Var3.b() - u6Var2.b()) / f6), u6Var4.c() + ((u6Var3.c() - u6Var2.c()) / f6));
        float f7 = a10 + 1;
        u6 u6Var6 = new u6(u6Var4.b() + ((u6Var.b() - u6Var2.b()) / f7), u6Var4.c() + ((u6Var.c() - u6Var2.c()) / f7));
        if (!a(u6Var5)) {
            if (!a(u6Var6)) {
                return null;
            }
        } else if (!a(u6Var6) || a(a7, u6Var5) + a(a8, u6Var5) > a(a7, u6Var6) + a(a8, u6Var6)) {
            return u6Var5;
        }
        return u6Var6;
    }

    private boolean a(u6 u6Var) {
        return u6Var.b() >= 0.0f && u6Var.b() < ((float) this.f34118a.e()) && u6Var.c() > 0.0f && u6Var.c() < ((float) this.f34118a.c());
    }

    private static s a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, int i6, int i7) throws a {
        float f6 = i6 - 0.5f;
        float f7 = i7 - 0.5f;
        return s3.a().a(sVar, i6, i7, 0.5f, 0.5f, f6, 0.5f, f6, f7, 0.5f, f7, u6Var.b(), u6Var.c(), u6Var4.b(), u6Var4.c(), u6Var3.b(), u6Var3.c(), u6Var2.b(), u6Var2.c());
    }

    private int a(u6 u6Var, u6 u6Var2) {
        int i6;
        boolean z5;
        d2 d2Var = this;
        int b6 = (int) u6Var.b();
        int c6 = (int) u6Var.c();
        int b7 = (int) u6Var2.b();
        int c7 = (int) u6Var2.c();
        boolean z6 = Math.abs(c7 - c6) > Math.abs(b7 - b6);
        if (!z6) {
            c6 = b6;
            b6 = c6;
            c7 = b7;
            b7 = c7;
        }
        int abs = Math.abs(c7 - c6);
        int abs2 = Math.abs(b7 - b6);
        int i7 = (-abs) / 2;
        int i8 = b6 < b7 ? 1 : -1;
        int i9 = c6 < c7 ? 1 : -1;
        boolean b8 = d2Var.f34118a.b(z6 ? b6 : c6, z6 ? c6 : b6);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (c6 != c7) {
            boolean b9 = d2Var.f34118a.b(z6 ? b6 : c6, z6 ? c6 : b6);
            i10++;
            if (b9 != b8) {
                i6 = c7;
                z5 = z6;
                if (i10 > Math.ceil(i11 / 1.5d)) {
                    i12++;
                    i11 -= (i11 - i10) / i12;
                    b8 = b9;
                    i10 = 0;
                }
            } else {
                i6 = c7;
                z5 = z6;
            }
            i7 += abs2;
            if (i7 > 0) {
                if (b6 == b7) {
                    return i12;
                }
                b6 += i8;
                i7 -= abs;
            }
            c6 += i9;
            d2Var = this;
            z6 = z5;
            c7 = i6;
        }
        return i12;
    }
}
