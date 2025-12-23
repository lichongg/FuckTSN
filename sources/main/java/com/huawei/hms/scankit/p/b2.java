package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class b2 extends a2 {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f34013c;

    void a(k kVar) throws a {
        x0[] b6 = b();
        f();
        a(b6, kVar);
        a0 a6 = a();
        u6 g6 = this.f34013c ? a6.g() : a6.h();
        u6 a7 = this.f34013c ? a6.a() : a6.b();
        int c6 = c((int) g6.c());
        int c7 = c((int) a7.c());
        int i6 = -1;
        int i7 = 0;
        int i8 = 1;
        while (c6 < c7) {
            x0 x0Var = b6[c6];
            if (x0Var != null) {
                int c8 = x0Var.c() - i6;
                if (c8 == 0) {
                    i7++;
                } else {
                    if (c8 == 1) {
                        i8 = Math.max(i8, i7);
                        i6 = x0Var.c();
                    } else if (c8 < 0 || x0Var.c() >= kVar.c() || c8 > c6) {
                        b6[c6] = null;
                    } else {
                        if (i8 > 2) {
                            c8 *= i8 - 2;
                        }
                        boolean z5 = c8 >= c6;
                        for (int i9 = 1; i9 <= c8 && !z5; i9++) {
                            z5 = b6[c6 - i9] != null;
                        }
                        if (z5) {
                            b6[c6] = null;
                        } else {
                            i6 = x0Var.c();
                        }
                    }
                    i7 = 1;
                }
            }
            c6++;
        }
    }

    boolean e() {
        return this.f34013c;
    }

    @Override // com.huawei.hms.scankit.p.a2
    public String toString() {
        return "IsLeft: " + this.f34013c + '\n' + super.toString();
    }

    b2(a0 a0Var, boolean z5) {
        super(a0Var);
        this.f34013c = z5;
    }

    private void b(k kVar) {
        u6 h6;
        u6 b6;
        a0 a6 = a();
        if (this.f34013c) {
            h6 = a6.g();
        } else {
            h6 = a6.h();
        }
        if (this.f34013c) {
            b6 = a6.a();
        } else {
            b6 = a6.b();
        }
        int c6 = c((int) b6.c());
        x0[] b7 = b();
        int i6 = -1;
        int i7 = 0;
        int i8 = 1;
        for (int c7 = c((int) h6.c()); c7 < c6; c7++) {
            x0 x0Var = b7[c7];
            if (x0Var != null) {
                x0Var.h();
                int c8 = x0Var.c() - i6;
                if (c8 == 0) {
                    i7++;
                } else {
                    if (c8 == 1) {
                        i8 = Math.max(i8, i7);
                        i6 = x0Var.c();
                    } else if (x0Var.c() >= kVar.c()) {
                        b7[c7] = null;
                    } else {
                        i6 = x0Var.c();
                    }
                    i7 = 1;
                }
            }
        }
    }

    private void f() {
        for (x0 x0Var : b()) {
            if (x0Var != null) {
                x0Var.h();
            }
        }
    }

    k c() throws a {
        x0[] b6 = b();
        m mVar = new m();
        m mVar2 = new m();
        m mVar3 = new m();
        m mVar4 = new m();
        for (x0 x0Var : b6) {
            if (x0Var != null) {
                x0Var.h();
                int e6 = x0Var.e() % 30;
                int c6 = x0Var.c();
                if (!this.f34013c) {
                    c6 += 2;
                }
                int i6 = c6 % 3;
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 == 2) {
                            mVar.a(e6 + 1);
                        } else {
                            throw a.a();
                        }
                    } else {
                        mVar4.a(e6 / 3);
                        mVar3.a(e6 % 3);
                    }
                } else {
                    mVar2.a((e6 * 3) + 1);
                }
            }
        }
        if (mVar.a().length != 0 && mVar2.a().length != 0 && mVar3.a().length != 0 && mVar4.a().length != 0 && mVar.a()[0] >= 1 && mVar2.a()[0] + mVar3.a()[0] >= 3 && mVar2.a()[0] + mVar3.a()[0] <= 90) {
            k kVar = new k(mVar.a()[0], mVar2.a()[0], mVar3.a()[0], mVar4.a()[0]);
            a(b6, kVar);
            return kVar;
        }
        return null;
    }

    int[] d() throws a {
        int c6;
        k c7 = c();
        if (c7 == null) {
            return null;
        }
        b(c7);
        int c8 = c7.c();
        int[] iArr = new int[c8];
        for (x0 x0Var : b()) {
            if (x0Var != null && (c6 = x0Var.c()) < c8) {
                iArr[c6] = iArr[c6] + 1;
            }
        }
        return iArr;
    }

    private void a(x0[] x0VarArr, k kVar) throws a {
        for (int i6 = 0; i6 < x0VarArr.length; i6++) {
            x0 x0Var = x0VarArr[i6];
            if (x0Var != null) {
                int e6 = x0Var.e() % 30;
                int c6 = x0Var.c();
                if (c6 > kVar.c()) {
                    x0VarArr[i6] = null;
                } else {
                    if (!this.f34013c) {
                        c6 += 2;
                    }
                    int i7 = c6 % 3;
                    if (i7 != 0) {
                        if (i7 != 1) {
                            if (i7 == 2) {
                                if (e6 + 1 != kVar.a()) {
                                    x0VarArr[i6] = null;
                                }
                            } else {
                                throw a.a();
                            }
                        } else if (e6 / 3 != kVar.b() || e6 % 3 != kVar.d()) {
                            x0VarArr[i6] = null;
                        }
                    } else if ((e6 * 3) + 1 != kVar.e()) {
                        x0VarArr[i6] = null;
                    }
                }
            }
        }
    }
}
