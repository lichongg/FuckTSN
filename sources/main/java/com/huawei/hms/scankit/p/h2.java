package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h2 {

    /* renamed from: a, reason: collision with root package name */
    private final s f34333a;

    /* renamed from: b, reason: collision with root package name */
    private v6 f34334b;

    public final f3[] a(Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.f34512j);
        this.f34334b = v6Var;
        return new j3(this.f34333a, v6Var).a(map);
    }

    public h2(s sVar) {
        this.f34333a = sVar;
    }

    private static float b(float f6, float f7, float f8) {
        return Math.min(Math.min(f6, f7), f8);
    }

    public static boolean a(f3 f3Var, f3 f3Var2, f3 f3Var3) {
        float[] fArr = new float[3];
        a(f3Var, f3Var2, f3Var3, fArr);
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float sqrt = (float) Math.sqrt(f7);
        float sqrt2 = (float) Math.sqrt(f8);
        float sqrt3 = (float) Math.sqrt(f6);
        if (sqrt / sqrt2 >= 1.8f || sqrt2 / sqrt >= 1.8f || b(sqrt, sqrt2, sqrt3) <= a(f3Var.e(), f3Var2.e(), f3Var3.e()) * 6.0f) {
            return false;
        }
        float f9 = ((f7 + f8) - f6) / ((sqrt * 2.0f) * sqrt2);
        float f10 = sqrt3 * 2.0f;
        float f11 = ((f6 + f7) - f8) / (sqrt * f10);
        float f12 = ((f6 + f8) - f7) / (f10 * sqrt2);
        return Math.abs(f9) <= 0.342f && f11 >= 0.5736f && f11 <= 0.8191f && f12 >= 0.5736f && f12 <= 0.8191f;
    }

    private static void a(f3 f3Var, f3 f3Var2, f3 f3Var3, float[] fArr) {
        float b6 = f3Var.b() - f3Var2.b();
        float c6 = f3Var.c() - f3Var2.c();
        float f6 = (b6 * b6) + (c6 * c6);
        float b7 = f3Var.b() - f3Var3.b();
        float c7 = f3Var.c() - f3Var3.c();
        float f7 = (b7 * b7) + (c7 * c7);
        float b8 = f3Var2.b() - f3Var3.b();
        float c8 = f3Var2.c() - f3Var3.c();
        float f8 = (b8 * b8) + (c8 * c8);
        if (f6 > f8 && f6 > f7) {
            fArr[0] = f6;
            fArr[1] = f7;
            fArr[2] = f8;
        } else if (f8 > f6 && f8 > f7) {
            fArr[0] = f8;
            fArr[1] = f6;
            fArr[2] = f7;
        } else {
            fArr[0] = f7;
            fArr[1] = f6;
            fArr[2] = f8;
        }
    }

    private static float a(float f6, float f7, float f8) {
        return Math.max(Math.max(f6, f7), f8);
    }

    public static boolean a(f3[] f3VarArr, f3[] f3VarArr2, int[] iArr) {
        f3 f3Var = f3VarArr[0];
        f3 f3Var2 = f3VarArr[1];
        f3 f3Var3 = f3VarArr[2];
        int i6 = iArr[0];
        int i7 = iArr[1];
        int i8 = iArr[2];
        float b6 = (f3Var3.b() - f3Var2.b()) + f3Var.b();
        float c6 = (f3Var3.c() - f3Var2.c()) + f3Var.c();
        float e6 = ((f3Var.e() + f3Var2.e()) + f3Var3.e()) / 3.0f;
        for (int i9 = 0; i9 < f3VarArr2.length; i9++) {
            if (i9 != i6 && i9 != i7 && i9 != i8) {
                f3 f3Var4 = f3VarArr2[i9];
                float b7 = b6 - f3Var4.b();
                float c7 = c6 - f3Var4.c();
                if (((float) Math.sqrt((b7 * b7) + (c7 * c7))) < 10.0f * e6) {
                    return true;
                }
            }
        }
        return false;
    }
}
