package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class k2 {

    /* renamed from: a, reason: collision with root package name */
    private static d5 f34490a;

    /* renamed from: b, reason: collision with root package name */
    private static p f34491b;

    public static List<i2> a(boolean z5, p pVar, int i6, boolean z6) {
        int e6 = pVar.e();
        int c6 = pVar.c();
        byte[] b6 = pVar.a().c().b();
        d5 d5Var = new d5();
        f34490a = d5Var;
        d5Var.a(z5, b6, c6, e6, i6, z6);
        return f34490a.f34124a;
    }

    public static boolean a(boolean z5, p pVar, i2 i2Var) throws a {
        float i6;
        int e6 = pVar.e();
        int c6 = pVar.c();
        float[] fArr = {i2Var.j(), i2Var.k(), i2Var.f(), i2Var.c()};
        if (z5) {
            i2Var.f34387n = Math.max(i2Var.m(), i2Var.l());
            i2Var.f34388o = Math.min(i2Var.m(), i2Var.l());
            i6 = i2Var.i();
            if (i2Var.g() == 11.0f || i2Var.g() == 0.0f) {
                i6 = 0.0f;
            }
            i2Var.f34395v = Math.max(fArr[2], fArr[3]);
            i2Var.f34391r = (int) Math.max(fArr[0] - (fArr[2] * 0.5d), 0.0d);
            i2Var.f34392s = (int) Math.max(fArr[1] - (fArr[3] * 0.5d), 0.0d);
        } else {
            i6 = i2Var.i();
            i2Var.f34395v = Math.max(fArr[2], fArr[3]);
            i2Var.f34391r = (int) i2Var.d();
            i2Var.f34392s = (int) i2Var.e();
        }
        i2Var.f34389p = Math.min(e6 - i2Var.f34391r, (int) fArr[2]);
        int min = Math.min(c6 - i2Var.f34392s, (int) fArr[3]);
        i2Var.f34390q = min;
        int i7 = i2Var.f34389p;
        if (i7 > 0 && min > 0) {
            p a6 = pVar.a(i2Var.f34391r, i2Var.f34392s, i7, min);
            f34491b = a6;
            a(a6, i6, i2Var, fArr);
            return true;
        }
        throw a.a("crop_w <= 0 || crop_h <= 0");
    }

    private static void a(p pVar, float f6, i2 i2Var, float[] fArr) {
        byte[] b6;
        float min;
        float max;
        float radians = (float) Math.toRadians(f6);
        double d6 = radians;
        int abs = (int) ((i2Var.f34389p * Math.abs(Math.sin(d6))) + (i2Var.f34390q * Math.abs(Math.cos(d6))));
        int abs2 = (int) ((i2Var.f34390q * Math.abs(Math.sin(d6))) + (i2Var.f34389p * Math.abs(Math.cos(d6))));
        float[] fArr2 = i2Var.f34386m;
        fArr2[0] = abs2 * 0.5f;
        fArr2[1] = abs * 0.5f;
        fArr2[2] = (abs2 - i2Var.f34389p) * 0.5f;
        fArr2[3] = (abs - i2Var.f34390q) * 0.5f;
        fArr2[4] = radians;
        if (!r3.f34731b) {
            b6 = LoadOpencvJNIUtil.removeMoirePattern(pVar.a().c().b(), i2Var.f34390q, i2Var.f34389p);
        } else {
            b6 = pVar.a().c().b();
        }
        if (f6 == 0.0f) {
            i2Var.f34393t = 0;
            i2Var.f34394u = 0;
            int i6 = i2Var.f34389p;
            int i7 = i2Var.f34390q;
            i2Var.f34385l = new p(new q3(new e6(b6, i6, i7, 0, 0, i6, i7, false)));
            return;
        }
        p pVar2 = new p(new q3(new e6(LoadOpencvJNIUtil.imageRotate(b6, i2Var.f34390q, i2Var.f34389p, abs, abs2, f6, 1.0d), abs2, abs, 0, 0, abs2, abs, false)));
        if ((i2Var.g() == 3.0f || i2Var.g() == 4.0f) && pVar2.c() > pVar2.e()) {
            min = Math.min(fArr[2], fArr[3]);
            max = Math.max(fArr[2], fArr[3]);
        } else {
            min = Math.max(fArr[2], fArr[3]);
            max = Math.min(fArr[2], fArr[3]);
        }
        i2Var.f34393t = (int) Math.max((abs2 * 0.5d) - (min * 0.5d), 0.0d);
        i2Var.f34394u = (int) Math.max((abs * 0.5d) - (max * 0.5d), 0.0d);
        i2Var.f34385l = pVar2.a(i2Var.f34393t, i2Var.f34394u, Math.min(abs2 - i2Var.f34393t, (int) min), Math.min(abs - i2Var.f34394u, (int) max));
    }

    public static void a(s sVar, s6 s6Var, float f6, i2 i2Var) {
        int c6;
        int c7;
        u6[] j6 = s6Var.j();
        float min = Math.min(j6[0].b(), j6[1].b());
        float max = Math.max(j6[0].b(), j6[1].b());
        float c8 = j6[0].c();
        if (max > sVar.e() - 1) {
            max = sVar.e() - 1;
        }
        if (c8 > sVar.c() - 1) {
            c8 = sVar.c() - 1;
        }
        float f7 = c8;
        int c9 = sVar.c();
        float f8 = max;
        try {
            int[] a6 = a(sVar, j6, min, f8, f7, c9, new int[c9]);
            c6 = a6[0];
            c7 = a6[1];
        } catch (IndexOutOfBoundsException unused) {
            c6 = (int) j6[0].c();
            c7 = (int) j6[0].c();
        }
        float f9 = c6;
        float f10 = c7;
        u6[] u6VarArr = {new u6(min, f9), new u6(f8, f9), new u6(f8, f10), new u6(min, f10)};
        if (i2Var != null) {
            a(u6VarArr, f6, i2Var);
        }
        s6Var.a();
        s6Var.a(u6VarArr);
    }

    private static int[] a(s sVar, u6[] u6VarArr, float f6, float f7, float f8, int i6, int[] iArr) {
        int i7;
        int i8;
        int i9;
        int i10 = (int) f6;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            i7 = ((int) f7) - 1;
            if (i11 >= i7) {
                break;
            }
            int i13 = (int) f8;
            boolean b6 = sVar.b(i11, i13);
            i11++;
            if (sVar.b(i11, i13) ^ b6) {
                i12++;
            }
        }
        int i14 = 0;
        for (int i15 = 0; i15 < i6; i15++) {
            int i16 = i10;
            int i17 = 0;
            while (i16 < i7) {
                boolean b7 = sVar.b(i16, i15);
                i16++;
                if (b7 ^ sVar.b(i16, i15)) {
                    i17++;
                }
            }
            float f9 = i12;
            if (i17 > 1.5f * f9) {
                i17 = 0;
            }
            if (i17 < f9 * 0.5f) {
                i17 = 0;
            }
            iArr[i15] = i17;
            if (i17 > i14) {
                i14 = i17;
            }
        }
        if (i14 > 0) {
            float[] fArr = new float[i6];
            for (int i18 = 0; i18 < i6; i18++) {
                fArr[i18] = iArr[i18] / i14;
            }
            float f10 = 0.0f;
            for (int i19 = 0; i19 < i6; i19++) {
                f10 += fArr[i19];
            }
            float f11 = f10 / i6;
            if (f11 > 1.0d) {
                f11 = 0.99f;
            }
            i8 = (int) f8;
            i9 = i8;
            while (true) {
                if (i9 < 0) {
                    i9 = 0;
                    break;
                }
                if (fArr[i9] < f11) {
                    break;
                }
                i9--;
            }
            while (true) {
                if (i8 >= i6) {
                    i8 = 0;
                    break;
                }
                if (fArr[i8] < f11) {
                    break;
                }
                i8++;
            }
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (i9 == 0 && i8 == 0) {
            i9 = ((int) u6VarArr[0].c()) + (-10) < 0 ? 0 : ((int) u6VarArr[0].c()) - 10;
            i8 = i6 - 1;
            if (((int) u6VarArr[0].c()) + 10 <= i8) {
                i8 = ((int) u6VarArr[0].c()) + 10;
            }
        }
        return new int[]{i9, i8};
    }

    private static u6 a(float f6, float f7, i2 i2Var) {
        float[] fArr = i2Var.f34386m;
        if (fArr != null && fArr.length == 5) {
            float f8 = -fArr[4];
            double d6 = f6 - fArr[0];
            double d7 = f8;
            int cos = (int) ((d6 * Math.cos(d7)) + ((f7 - i2Var.f34386m[1]) * Math.sin(d7)) + i2Var.f34386m[0]);
            int sin = (int) (((-(f6 - r2)) * Math.sin(d7)) + ((f7 - i2Var.f34386m[1]) * Math.cos(d7)) + i2Var.f34386m[1]);
            float[] fArr2 = i2Var.f34386m;
            return new u6((cos - fArr2[2]) + i2Var.f34391r, (sin - fArr2[3]) + i2Var.f34392s);
        }
        return new u6(f6, f7);
    }

    public static void a(u6[] u6VarArr, float f6, i2 i2Var) {
        if (i2Var == null || u6VarArr == null) {
            return;
        }
        for (int i6 = 0; i6 < u6VarArr.length; i6++) {
            u6VarArr[i6] = a((u6VarArr[i6].b() * f6) + i2Var.f34393t, (u6VarArr[i6].c() * f6) + i2Var.f34394u, i2Var);
        }
    }
}
