package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g2 {

    /* renamed from: a, reason: collision with root package name */
    private final s f34308a;

    /* renamed from: b, reason: collision with root package name */
    private v6 f34309b;

    private static d6 a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, u6 u6Var5, int i6) {
        float b6;
        float c6;
        float f6;
        float f7;
        float f8 = i6 - 3.5f;
        if (u6Var4 != null) {
            b6 = u6Var4.b();
            c6 = u6Var4.c();
            f6 = u6Var5.b();
            f7 = u6Var5.c();
        } else {
            b6 = (u6Var2.b() - u6Var.b()) + u6Var3.b();
            c6 = (u6Var2.c() - u6Var.c()) + u6Var3.c();
            f6 = f8;
            f7 = f6;
        }
        return d6.a(3.5f, 3.5f, f8, 3.5f, f6, f7, 3.5f, f8, u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), b6, c6, u6Var3.b(), u6Var3.c());
    }

    public g2(s sVar) {
        this.f34308a = sVar;
    }

    private float b(int i6, int i7, int i8, int i9) {
        float f6;
        float f7;
        float a6 = a(i6, i7, i8, i9);
        int i10 = i6 - (i8 - i6);
        if (i6 == i10) {
            return Float.NaN;
        }
        int i11 = 0;
        if (i10 < 0) {
            f6 = i6 / (i6 - i10);
            i10 = 0;
        } else if (i10 >= this.f34308a.e()) {
            f6 = ((this.f34308a.e() - 1) - i6) / (i10 - i6);
            i10 = this.f34308a.e() - 1;
        } else {
            f6 = 1.0f;
        }
        float f8 = i7;
        int i12 = (int) (f8 - ((i9 - i7) * f6));
        if (i7 == i12) {
            return Float.NaN;
        }
        if (i12 < 0) {
            f7 = f8 / (i7 - i12);
        } else if (i12 >= this.f34308a.c()) {
            f7 = ((this.f34308a.c() - 1) - i7) / (i12 - i7);
            i11 = this.f34308a.c() - 1;
        } else {
            i11 = i12;
            f7 = 1.0f;
        }
        float a7 = a(i6, i7, (int) (i6 + ((i10 - i6) * f7)), i11);
        if (Math.max(a6, a7) > Math.min(a6, a7) * 1.5d) {
            return Float.NaN;
        }
        return (a6 + a7) - 1.0f;
    }

    private static s a(s sVar, d6 d6Var, int i6) throws a {
        return s3.a().a(sVar, i6, i6, d6Var, true);
    }

    private static int a(u6 u6Var, u6 u6Var2, u6 u6Var3, float f6) throws a {
        int i6;
        int i7;
        try {
            i6 = ((s4.a(u6.a(u6Var, u6Var2) / f6) + s4.a(u6.a(u6Var, u6Var3) / f6)) / 2) + 7;
            i7 = i6 & 3;
        } catch (a unused) {
            int a6 = (((int) (u6.a(u6Var, u6Var2) / f6)) + ((int) (u6.a(u6Var, u6Var3) / f6))) / 2;
            i6 = a6 + 7;
            int i8 = i6 & 3;
            if (i8 != 0) {
                if (i8 != 2) {
                    return i8 != 3 ? i6 : a6 + 9;
                }
            }
        }
        if (i7 != 0) {
            if (i7 != 2) {
                if (i7 != 3) {
                    return i6;
                }
                throw a.a();
            }
            return i6 - 1;
        }
        return i6 + 1;
    }

    public final j2 a(Map<l1, ?> map) throws a {
        this.f34309b = map == null ? null : (v6) map.get(l1.f34512j);
        return a(new i3(this.f34308a, this.f34309b).b());
    }

    protected final j2 a(k3 k3Var) throws a {
        e3 b6 = k3Var.b();
        e3 c6 = k3Var.c();
        e3 a6 = k3Var.a();
        try {
            float a7 = a(b6, c6, a6);
            if (a7 >= 1.0f) {
                return a(b6, c6, a6, a7);
            }
            throw a.a();
        } catch (a unused) {
            float e6 = ((b6.e() + c6.e()) + a6.e()) / 3.0f;
            if (e6 >= 1.0f) {
                return a(b6, c6, a6, e6);
            }
            throw a.a();
        }
    }

    private j2 a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f6) throws a {
        int i6;
        int i7;
        g2 g2Var;
        d6 d6Var;
        u6[] u6VarArr;
        int a6 = a((u6) e3Var, (u6) e3Var2, (u6) e3Var3, f6);
        r3.f34752w.push(Integer.valueOf(a6));
        b8 b6 = b8.b(a6);
        if (r3.f34748s && r3.f34732c) {
            return a(e3Var, e3Var2, e3Var3, f6, a6);
        }
        int d6 = b6.d() - 7;
        int length = b6.c().length;
        int i8 = length * length;
        d[] dVarArr = new d[i8];
        d[] dVarArr2 = new d[i8];
        d[] dVarArr3 = new d[2];
        if (b6.c().length > 0) {
            i6 = length;
            i7 = a(e3Var, e3Var2, e3Var3, f6, a6, b6, dVarArr, dVarArr2, i6, d6, dVarArr3);
        } else {
            i6 = length;
            i7 = 0;
        }
        d dVar = dVarArr3[0];
        d6 a7 = a(e3Var, e3Var2, e3Var3, dVar, dVarArr3[1], a6);
        if (r3.f34745p && r3.f34742m) {
            g2Var = this;
            d6Var = a7;
            g2Var.a(d6Var, i6, a6, e3Var, e3Var2, e3Var3, dVarArr, i7, dVarArr2);
            a6 = a6;
        } else {
            g2Var = this;
            d6Var = a7;
        }
        s a8 = a(g2Var.f34308a, d6Var, a6);
        if (dVar == null) {
            u6VarArr = new u6[]{e3Var3, e3Var, e3Var2};
        } else {
            u6VarArr = new u6[]{e3Var3, e3Var, e3Var2, dVar};
        }
        float f7 = a6;
        float[] fArr = {0.0f, 0.0f, f7, 0.0f, f7, f7, 0.0f, f7};
        d6Var.a(fArr);
        return new j2(a8, u6VarArr, new u6[]{g2Var.a(new u6(fArr[6], fArr[7])), g2Var.a(new u6(fArr[0], fArr[1], e3Var.d())), g2Var.a(new u6(fArr[2], fArr[3], e3Var2.d())), g2Var.a(new u6(fArr[4], fArr[5], e3Var3.d()))}, f6);
    }

    private int a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f6, int i6, b8 b8Var, d[] dVarArr, d[] dVarArr2, int i7, int i8, d[] dVarArr3) {
        int i9;
        int i10;
        float f7;
        float b6 = (e3Var2.b() - e3Var.b()) + e3Var3.b();
        float c6 = (e3Var2.c() - e3Var.c()) + e3Var3.c();
        float f8 = i8;
        float f9 = 3.0f / f8;
        float f10 = 1.0f - f9;
        int b7 = (int) (e3Var.b() + ((b6 - e3Var.b()) * f10));
        int c7 = (int) (e3Var.c() + (f10 * (c6 - e3Var.c())));
        if (r3.f34751v[0] && i8 == 22) {
            i9 = 2;
            i10 = 8;
        } else {
            i9 = 4;
            i10 = 16;
        }
        for (int i11 = i9; i11 <= i10; i11 <<= 1) {
            try {
                dVarArr3[0] = a(f6, b7, c7, i11);
                break;
            } catch (a unused) {
            }
        }
        float f11 = i6 - 6.5f;
        dVarArr3[1] = new d(f11, f11, e3Var3.e());
        d dVar = dVarArr3[0];
        if (dVar != null) {
            f7 = 3.0f;
            if (s4.a(b7, c7, dVar.b(), dVarArr3[0].c()) > f6 * 4.0f) {
                dVarArr3[0] = null;
            }
        } else {
            f7 = 3.0f;
        }
        if (dVarArr3[0] == null && i7 > 2) {
            int i12 = i7 - 2;
            dVarArr3[1] = new d(b8Var.c()[i12] + 0.5f, f11, e3Var3.e());
            int c8 = (int) (e3Var3.c() - (f9 * (e3Var3.c() - e3Var.c())));
            int b8 = (int) ((((b8Var.c()[i12] - f7) / f8) * (e3Var2.b() - e3Var.b())) + e3Var3.b());
            while (i9 <= i10) {
                try {
                    dVarArr3[0] = a(f6, b8, c8, i9);
                    break;
                } catch (a unused2) {
                    i9 <<= 1;
                }
            }
            d dVar2 = dVarArr3[0];
            if (dVar2 != null && s4.a(b8, c8, dVar2.b(), dVarArr3[0].c()) > f6 * 4.0f) {
                dVarArr3[0] = null;
            }
        }
        if (r3.f34745p && r3.f34742m) {
            return a(b8Var, i8, e3Var2, e3Var, e3Var3, f6, i7, 0, dVarArr, dVarArr2);
        }
        return 0;
    }

    private int a(b8 b8Var, int i6, e3 e3Var, e3 e3Var2, e3 e3Var3, float f6, int i7, int i8, d[] dVarArr, d[] dVarArr2) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13 = i7;
        int i14 = i8;
        int i15 = 0;
        while (i15 < i13) {
            if (i15 == 0) {
                i9 = i13 - 1;
                i10 = 1;
            } else {
                i9 = i13;
                i10 = 0;
            }
            int i16 = i15 != i13 + (-1) ? i10 : 1;
            float f7 = 3.0f;
            float f8 = i6;
            float b6 = (((b8Var.c()[i15] - 3.0f) * (e3Var.b() - e3Var2.b())) / f8) + e3Var2.b();
            float c6 = (((b8Var.c()[i15] - 3.0f) * (e3Var.c() - e3Var2.c())) / f8) + e3Var2.c();
            while (i16 < i9) {
                int c7 = (int) (c6 - (((b8Var.c()[i16] - f7) * (e3Var2.c() - e3Var3.c())) / f8));
                int b7 = (int) (b6 - (((b8Var.c()[i16] - f7) * (e3Var2.b() - e3Var3.b())) / f8));
                int i17 = 4;
                int i18 = 4;
                while (true) {
                    if (i18 > i17) {
                        i11 = i15;
                        break;
                    }
                    int i19 = (i15 * i13) + i16;
                    try {
                        dVarArr[i19] = a(f6, b7, c7, i18);
                        i12 = i14;
                        try {
                            i11 = i15;
                            try {
                                dVarArr2[i19] = new d(b8Var.c()[i15] + 0.5f, b8Var.c()[i16] + 0.5f, e3Var3.e());
                                i14 = i12 + 1;
                                break;
                            } catch (a unused) {
                                continue;
                            }
                        } catch (a unused2) {
                            i11 = i15;
                            i18 <<= 1;
                            i13 = i7;
                            i15 = i11;
                            i14 = i12;
                            i17 = 4;
                        }
                    } catch (a unused3) {
                        i12 = i14;
                    }
                    i18 <<= 1;
                    i13 = i7;
                    i15 = i11;
                    i14 = i12;
                    i17 = 4;
                }
                i16++;
                i13 = i7;
                i15 = i11;
                f7 = 3.0f;
            }
            i15++;
            i13 = i7;
        }
        return i14;
    }

    private void a(d6 d6Var, int i6, int i7, e3 e3Var, e3 e3Var2, e3 e3Var3, d[] dVarArr, int i8, d[] dVarArr2) {
        int i9 = i8 + 3;
        int i10 = i9 * 2;
        float[] fArr = new float[i10];
        float[] fArr2 = new float[i10];
        fArr[0] = e3Var.b();
        fArr[1] = e3Var.c();
        fArr[2] = e3Var2.b();
        fArr[3] = e3Var2.c();
        fArr[4] = e3Var3.b();
        fArr[5] = e3Var3.c();
        fArr2[0] = 3.5f;
        fArr2[1] = 3.5f;
        float f6 = i7 - 3.5f;
        fArr2[2] = f6;
        fArr2[3] = 3.5f;
        fArr2[4] = 3.5f;
        fArr2[5] = f6;
        int i11 = 6;
        int i12 = 6;
        for (int i13 = 0; i13 < i6 * i6; i13++) {
            d dVar = dVarArr[i13];
            if (dVar != null) {
                int i14 = i12 + 1;
                fArr[i12] = dVar.b();
                i12 += 2;
                fArr[i14] = dVarArr[i13].c();
                int i15 = i11 + 1;
                fArr2[i11] = dVarArr2[i13].b();
                i11 += 2;
                fArr2[i15] = dVarArr2[i13].c();
            }
        }
        float[] QuadFitting = LoadOpencvJNIUtil.QuadFitting(fArr2, i9, fArr);
        if (QuadFitting.length != 0) {
            d6Var.a(QuadFitting[0], QuadFitting[1], QuadFitting[2], QuadFitting[3], QuadFitting[4], QuadFitting[5], QuadFitting[6], QuadFitting[7], QuadFitting[8], QuadFitting[9], QuadFitting[10], QuadFitting[11], QuadFitting[12], QuadFitting[13]);
        }
    }

    private j2 a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f6, int i6) {
        s sVar = new s(i6, i6);
        float f7 = i6;
        float c6 = this.f34308a.c() / f7;
        for (int i7 = 0; i7 < i6; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d6 = c6 * 0.5d;
                int i9 = (int) ((i8 * c6) + d6);
                int i10 = (int) ((i7 * c6) + d6);
                if (i9 >= -1 && i9 <= this.f34308a.e() && i10 >= -1 && i10 <= this.f34308a.c()) {
                    if (this.f34308a.b(i9, i10)) {
                        sVar.c(i8, i7);
                    }
                } else {
                    sVar.c(i8, i7);
                }
            }
        }
        u6[] u6VarArr = {e3Var3, e3Var, e3Var2};
        float[] fArr = {0.0f, 0.0f, f7, 0.0f, f7, f7, 0.0f, f7};
        a(e3Var, e3Var2, e3Var3, null, null, i6).a(fArr);
        return new j2(sVar, u6VarArr, new u6[]{a(new u6(fArr[6], fArr[7])), a(new u6(fArr[0], fArr[1])), a(new u6(fArr[2], fArr[3])), a(new u6(fArr[4], fArr[5]))}, f6);
    }

    protected final float a(u6 u6Var, u6 u6Var2, u6 u6Var3) {
        return (a(u6Var, u6Var2) + a(u6Var, u6Var3)) / 2.0f;
    }

    private float a(u6 u6Var, u6 u6Var2) {
        float b6 = b((int) u6Var.b(), (int) u6Var.c(), (int) u6Var2.b(), (int) u6Var2.c());
        float b7 = b((int) u6Var2.b(), (int) u6Var2.c(), (int) u6Var.b(), (int) u6Var.c());
        return Float.isNaN(b6) ? b7 / 7.0f : Float.isNaN(b7) ? b6 / 7.0f : (b6 + b7) / 14.0f;
    }

    private float a(int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = 1;
        boolean z5 = Math.abs(i9 - i7) > Math.abs(i8 - i6);
        if (z5) {
            i11 = i6;
            i10 = i7;
            i13 = i8;
            i12 = i9;
        } else {
            i10 = i6;
            i11 = i7;
            i12 = i8;
            i13 = i9;
        }
        int abs = Math.abs(i12 - i10);
        int abs2 = Math.abs(i13 - i11);
        int i15 = (-abs) / 2;
        int i16 = i10 < i12 ? 1 : -1;
        int i17 = i11 < i13 ? 1 : -1;
        int i18 = i12 + i16;
        int i19 = i10;
        int i20 = i11;
        int i21 = 0;
        while (i19 != i18) {
            boolean z6 = z5;
            int i22 = abs;
            if ((i21 == i14) == this.f34308a.b(z5 ? i20 : i19, z5 ? i19 : i20)) {
                if (i21 == 2) {
                    return s4.a(i19, i20, i10, i11);
                }
                i21++;
            }
            i15 += abs2;
            if (i15 > 0) {
                if (i20 == i13) {
                    break;
                }
                i20 += i17;
                i15 -= i22;
            }
            i19 += i16;
            abs = i22;
            z5 = z6;
            i14 = 1;
        }
        if (i21 == 2) {
            return s4.a(i18, i13, i10, i11);
        }
        return Float.NaN;
    }

    protected final d a(float f6, int i6, int i7, float f7) throws a {
        int i8 = (int) (f7 * f6);
        int max = Math.max(0, i6 - i8);
        int min = Math.min(this.f34308a.e() - 1, i6 + i8) - max;
        float f8 = 3.0f * f6;
        if (min >= f8) {
            int max2 = Math.max(0, i7 - i8);
            int min2 = Math.min(this.f34308a.c() - 1, i7 + i8) - max2;
            if (min2 >= f8) {
                return new e(this.f34308a, max, max2, min, min2, f6, this.f34309b).a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private u6 a(u6 u6Var) {
        float b6 = u6Var.b();
        float c6 = u6Var.c();
        int e6 = this.f34308a.e() - 1;
        int c7 = this.f34308a.c() - 1;
        if (b6 < 0.0f) {
            b6 = 0.0f;
        }
        float f6 = e6;
        if (b6 > f6) {
            b6 = f6;
        }
        if (c6 < 0.0f) {
            c6 = 0.0f;
        }
        float f7 = c7;
        if (c6 > f7) {
            c6 = f7;
        }
        return new u6(b6, c6, u6Var.d());
    }
}
