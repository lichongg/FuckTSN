package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class c2 {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f34066g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    private final s f34067a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f34068b;

    /* renamed from: c, reason: collision with root package name */
    private int f34069c;

    /* renamed from: d, reason: collision with root package name */
    private int f34070d;

    /* renamed from: e, reason: collision with root package name */
    private int f34071e;

    /* renamed from: f, reason: collision with root package name */
    private int f34072f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f34073a;

        /* renamed from: b, reason: collision with root package name */
        private final int f34074b;

        int a() {
            return this.f34073a;
        }

        int b() {
            return this.f34074b;
        }

        u6 c() {
            return new u6(this.f34073a, this.f34074b);
        }

        public String toString() {
            return "<" + this.f34073a + ' ' + this.f34074b + kotlin.text.v0.f47962f;
        }

        a(int i6, int i7) {
            this.f34073a = i6;
            this.f34074b = i7;
        }
    }

    private a b() {
        u6 c6;
        u6 u6Var;
        u6 u6Var2;
        u6 u6Var3;
        u6 c7;
        u6 c8;
        u6 c9;
        u6 c10;
        try {
            u6[] a6 = new j8(this.f34067a).a();
            u6Var2 = a6[0];
            u6Var3 = a6[1];
            u6Var = a6[2];
            c6 = a6[3];
        } catch (com.huawei.hms.scankit.p.a unused) {
            int e6 = this.f34067a.e() / 2;
            int c11 = this.f34067a.c() / 2;
            int i6 = e6 + 7;
            int i7 = c11 - 7;
            u6 c12 = a(new a(i6, i7), false, 1, -1).c();
            int i8 = c11 + 7;
            u6 c13 = a(new a(i6, i8), false, 1, 1).c();
            int i9 = e6 - 7;
            u6 c14 = a(new a(i9, i8), false, -1, 1).c();
            c6 = a(new a(i9, i7), false, -1, -1).c();
            u6Var = c14;
            u6Var2 = c12;
            u6Var3 = c13;
        }
        int a7 = s4.a((((u6Var2.b() + c6.b()) + u6Var3.b()) + u6Var.b()) / 4.0f);
        int a8 = s4.a((((u6Var2.c() + c6.c()) + u6Var3.c()) + u6Var.c()) / 4.0f);
        try {
            u6[] a9 = new j8(this.f34067a, 15, a7, a8).a();
            c7 = a9[0];
            c8 = a9[1];
            c9 = a9[2];
            c10 = a9[3];
        } catch (com.huawei.hms.scankit.p.a unused2) {
            int i10 = a7 + 7;
            int i11 = a8 - 7;
            c7 = a(new a(i10, i11), false, 1, -1).c();
            int i12 = a8 + 7;
            c8 = a(new a(i10, i12), false, 1, 1).c();
            int i13 = a7 - 7;
            c9 = a(new a(i13, i12), false, -1, 1).c();
            c10 = a(new a(i13, i11), false, -1, -1).c();
        }
        return new a(s4.a((((c7.b() + c10.b()) + c8.b()) + c9.b()) / 4.0f), s4.a((((c7.c() + c10.c()) + c8.c()) + c9.c()) / 4.0f));
    }

    public g a(boolean z5) throws com.huawei.hms.scankit.p.a {
        u6[] a6 = a(b());
        if (z5) {
            u6 u6Var = a6[0];
            a6[0] = a6[2];
            a6[2] = u6Var;
        }
        a(a6);
        s sVar = this.f34067a;
        int i6 = this.f34072f;
        return new g(a(sVar, a6[i6 % 4], a6[(i6 + 1) % 4], a6[(i6 + 2) % 4], a6[(i6 + 3) % 4]), b(a6), this.f34068b, this.f34070d, this.f34069c);
    }

    public c2(s sVar) {
        this.f34067a = sVar;
    }

    private void a(u6[] u6VarArr) throws com.huawei.hms.scankit.p.a {
        long j6;
        long j7;
        if (a(u6VarArr[0]) && a(u6VarArr[1]) && a(u6VarArr[2]) && a(u6VarArr[3])) {
            int i6 = this.f34071e * 2;
            int[] iArr = {a(u6VarArr[0], u6VarArr[1], i6), a(u6VarArr[1], u6VarArr[2], i6), a(u6VarArr[2], u6VarArr[3], i6), a(u6VarArr[3], u6VarArr[0], i6)};
            this.f34072f = a(iArr, i6);
            long j8 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                int i8 = iArr[(this.f34072f + i7) % 4];
                if (this.f34068b) {
                    j6 = j8 << 7;
                    j7 = (i8 >> 1) & 127;
                } else {
                    j6 = j8 << 10;
                    j7 = ((i8 >> 2) & 992) + ((i8 >> 1) & 31);
                }
                j8 = j6 + j7;
            }
            int a6 = a(j8, this.f34068b);
            if (this.f34068b) {
                this.f34069c = (a6 >> 6) + 1;
                this.f34070d = (a6 & 63) + 1;
                return;
            } else {
                this.f34069c = (a6 >> 11) + 1;
                this.f34070d = (a6 & 2047) + 1;
                return;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private u6[] b(u6[] u6VarArr) {
        return a(u6VarArr, this.f34071e * 2, a());
    }

    private boolean b(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int b6 = b(aVar8, aVar5);
        return b6 != 0 && b(aVar5, aVar6) == b6 && b(aVar6, aVar7) == b6 && b(aVar7, aVar8) == b6;
    }

    private static int a(int[] iArr, int i6) throws com.huawei.hms.scankit.p.a {
        int i7 = 0;
        for (int i8 : iArr) {
            i7 = (i7 << 3) + ((i8 >> (i6 - 2)) << 1) + (i8 & 1);
        }
        int i9 = ((i7 & 1) << 11) + (i7 >> 1);
        for (int i10 = 0; i10 < 4; i10++) {
            if (Integer.bitCount(f34066g[i10] ^ i9) <= 2) {
                return i10;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static int a(long j6, boolean z5) throws com.huawei.hms.scankit.p.a {
        int i6;
        int i7;
        if (z5) {
            i6 = 7;
            i7 = 2;
        } else {
            i6 = 10;
            i7 = 4;
        }
        int i8 = i6 - i7;
        int[] iArr = new int[i6];
        for (int i9 = i6 - 1; i9 >= 0; i9--) {
            iArr[i9] = ((int) j6) & 15;
            j6 >>= 4;
        }
        try {
            new p6(o3.f34648k).a(iArr, i8);
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                i10 = (i10 << 4) + iArr[i11];
            }
            return i10;
        } catch (com.huawei.hms.scankit.p.a unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private int b(a aVar, a aVar2) {
        float a6 = a(aVar, aVar2);
        float a7 = (aVar2.a() - aVar.a()) / a6;
        float b6 = (aVar2.b() - aVar.b()) / a6;
        float a8 = aVar.a();
        float b7 = aVar.b();
        boolean b8 = this.f34067a.b(aVar.a(), aVar.b());
        int ceil = (int) Math.ceil(a6);
        int i6 = 0;
        for (int i7 = 0; i7 < ceil; i7++) {
            a8 += a7;
            b7 += b6;
            if (this.f34067a.b(s4.a(a8), s4.a(b7)) != b8) {
                i6++;
            }
        }
        float f6 = i6 / a6;
        if (f6 <= 0.1f || f6 >= 0.9f) {
            return (f6 <= 0.1f) == b8 ? 1 : -1;
        }
        return 0;
    }

    private u6[] a(a aVar) throws com.huawei.hms.scankit.p.a {
        char c6;
        int i6 = 1;
        this.f34071e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z5 = true;
        while (true) {
            if (this.f34071e >= 9) {
                c6 = 1;
                break;
            }
            a a6 = a(aVar5, z5, i6, -1);
            a a7 = a(aVar4, z5, i6, i6);
            a a8 = a(aVar3, z5, -1, i6);
            a a9 = a(aVar2, z5, -1, -1);
            if (this.f34071e > 2) {
                c6 = 1;
                double a10 = (a(a9, a6) * this.f34071e) / (a(aVar2, aVar5) * (this.f34071e + 2));
                if (a10 < 0.75d) {
                    break;
                }
                if (a10 > 1.25d) {
                    break;
                }
                if (!a(a6, a7, a8, a9)) {
                    break;
                }
                if (!b(a6, a7, a8, a9)) {
                    int i7 = this.f34071e;
                    if (i7 == 5 || i7 == 7) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            z5 = !z5;
            this.f34071e++;
            aVar2 = a9;
            aVar5 = a6;
            aVar4 = a7;
            aVar3 = a8;
            i6 = 1;
        }
        int i8 = this.f34071e;
        if (i8 != 5 && i8 != 7) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        this.f34068b = i8 == 5;
        u6 u6Var = new u6(aVar5.a() + 0.5f, aVar5.b() - 0.5f);
        u6 u6Var2 = new u6(aVar4.a() + 0.5f, aVar4.b() + 0.5f);
        u6 u6Var3 = new u6(aVar3.a() - 0.5f, aVar3.b() + 0.5f);
        u6 u6Var4 = new u6(aVar2.a() - 0.5f, aVar2.b() - 0.5f);
        u6[] u6VarArr = new u6[4];
        u6VarArr[0] = u6Var;
        u6VarArr[c6] = u6Var2;
        u6VarArr[2] = u6Var3;
        u6VarArr[3] = u6Var4;
        int i9 = this.f34071e * 2;
        return a(u6VarArr, i9 - 3, i9);
    }

    private s a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) throws com.huawei.hms.scankit.p.a {
        s3 a6 = s3.a();
        int a7 = a();
        float f6 = a7 / 2.0f;
        float f7 = this.f34071e;
        float f8 = f6 - f7;
        float f9 = f6 + f7;
        return a6.a(sVar, a7, a7, f8, f8, f9, f8, f9, f9, f8, f9, u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), u6Var3.b(), u6Var3.c(), u6Var4.b(), u6Var4.c());
    }

    private int a(u6 u6Var, u6 u6Var2, int i6) {
        float a6 = a(u6Var, u6Var2);
        float f6 = a6 / i6;
        float b6 = u6Var.b();
        float c6 = u6Var.c();
        float b7 = ((u6Var2.b() - u6Var.b()) * f6) / a6;
        float c7 = (f6 * (u6Var2.c() - u6Var.c())) / a6;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            float f7 = i8;
            if (this.f34067a.b(s4.a((f7 * b7) + b6), s4.a((f7 * c7) + c6))) {
                i7 |= 1 << ((i6 - i8) - 1);
            }
        }
        return i7;
    }

    private boolean a(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a((int) Math.ceil((((aVar.f34073a + aVar2.f34073a) + aVar3.f34073a) + aVar4.f34073a) / 4.0f), (int) Math.ceil((((aVar.f34074b + aVar2.f34074b) + aVar3.f34074b) + aVar4.f34074b) / 4.0f));
        float a6 = a(aVar5, aVar);
        float a7 = a(aVar5, aVar2);
        float a8 = a(aVar5, aVar3);
        float a9 = a(aVar5, aVar4);
        double d6 = a6 / a7;
        if (d6 <= 0.75d || d6 >= 1.25d) {
            return false;
        }
        double d7 = a6 / a8;
        if (d7 <= 0.75d || d7 >= 1.25d) {
            return false;
        }
        double d8 = a6 / a9;
        return d8 > 0.75d && d8 < 1.25d;
    }

    private a a(a aVar, boolean z5, int i6, int i7) {
        int a6 = aVar.a() + i6;
        int b6 = aVar.b();
        while (true) {
            b6 += i7;
            if (!a(a6, b6) || this.f34067a.b(a6, b6) != z5) {
                break;
            }
            a6 += i6;
        }
        int i8 = a6 - i6;
        int i9 = b6 - i7;
        while (a(i8, i9) && this.f34067a.b(i8, i9) == z5) {
            i8 += i6;
        }
        int i10 = i8 - i6;
        while (a(i10, i9) && this.f34067a.b(i10, i9) == z5) {
            i9 += i7;
        }
        return new a(i10, i9 - i7);
    }

    private static u6[] a(u6[] u6VarArr, int i6, int i7) {
        float f6 = i7 / (i6 * 2.0f);
        float b6 = u6VarArr[0].b() - u6VarArr[2].b();
        float c6 = u6VarArr[0].c() - u6VarArr[2].c();
        float b7 = (u6VarArr[0].b() + u6VarArr[2].b()) / 2.0f;
        float c7 = (u6VarArr[0].c() + u6VarArr[2].c()) / 2.0f;
        float f7 = b6 * f6;
        float f8 = c6 * f6;
        u6 u6Var = new u6(b7 + f7, c7 + f8);
        u6 u6Var2 = new u6(b7 - f7, c7 - f8);
        float b8 = u6VarArr[1].b() - u6VarArr[3].b();
        float c8 = u6VarArr[1].c() - u6VarArr[3].c();
        float b9 = (u6VarArr[1].b() + u6VarArr[3].b()) / 2.0f;
        float c9 = (u6VarArr[1].c() + u6VarArr[3].c()) / 2.0f;
        float f9 = b8 * f6;
        float f10 = f6 * c8;
        return new u6[]{u6Var, new u6(b9 + f9, c9 + f10), u6Var2, new u6(b9 - f9, c9 - f10)};
    }

    private boolean a(int i6, int i7) {
        return i6 >= 0 && i6 < this.f34067a.e() && i7 > 0 && i7 < this.f34067a.c();
    }

    private boolean a(u6 u6Var) {
        return a(s4.a(u6Var.b()), s4.a(u6Var.c()));
    }

    private static float a(a aVar, a aVar2) {
        return s4.a(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float a(u6 u6Var, u6 u6Var2) {
        return s4.a(u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c());
    }

    private int a() {
        if (this.f34068b) {
            return (this.f34069c * 4) + 11;
        }
        int i6 = this.f34069c;
        return i6 <= 4 ? (i6 * 4) + 15 : (i6 * 4) + ((((i6 - 4) / 8) + 1) * 2) + 15;
    }
}
