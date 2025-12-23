package com.huawei.hms.scankit.p;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class v7 {
    public static List<s6> a(List<s6> list) {
        for (int i6 = 0; i6 < list.size() - 1; i6++) {
            for (int size = list.size() - 1; size > i6; size--) {
                if (list.get(i6).k().equals(list.get(size).k()) && a(r2.j(), r3.j()) > 0.5d) {
                    list.remove(size);
                }
            }
        }
        return list;
    }

    public static float a(u6[] u6VarArr, u6[] u6VarArr2) {
        float f6 = Float.MIN_VALUE;
        float f7 = Float.MAX_VALUE;
        float f8 = Float.MIN_VALUE;
        float f9 = Float.MAX_VALUE;
        float f10 = Float.MIN_VALUE;
        float f11 = Float.MAX_VALUE;
        for (u6 u6Var : u6VarArr) {
            if (u6Var.b() > f8) {
                f8 = u6Var.b();
            }
            if (u6Var.b() < f9) {
                f9 = u6Var.b();
            }
            if (u6Var.c() > f10) {
                f10 = u6Var.c();
            }
            if (u6Var.c() < f11) {
                f11 = u6Var.c();
            }
        }
        float f12 = Float.MIN_VALUE;
        float f13 = Float.MAX_VALUE;
        for (u6 u6Var2 : u6VarArr2) {
            if (u6Var2.b() > f6) {
                f6 = u6Var2.b();
            }
            if (u6Var2.b() < f7) {
                f7 = u6Var2.b();
            }
            if (u6Var2.c() > f12) {
                f12 = u6Var2.c();
            }
            if (u6Var2.c() < f13) {
                f13 = u6Var2.c();
            }
        }
        float f14 = (f6 < f8 ? f6 : f8) - (f7 > f9 ? f7 : f9);
        float f15 = (f12 < f10 ? f12 : f10) - (f13 > f11 ? f13 : f11);
        if (f14 < 0.0f) {
            f14 = 0.0f;
        }
        if (f15 < 0.0f) {
            f15 = 0.0f;
        }
        float f16 = f14 * f15;
        return f16 / ((((f8 - f9) * (f10 - f11)) + ((f6 - f7) * (f12 - f13))) - f16);
    }
}
