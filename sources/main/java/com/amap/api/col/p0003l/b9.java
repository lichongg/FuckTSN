package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b9 extends x9 {
    public static int b(w9 w9Var, int i6) {
        w9Var.q(1);
        d(w9Var, i6);
        return a(w9Var);
    }

    public static int c(w9 w9Var, int[] iArr) {
        w9Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            w9Var.e(iArr[length]);
        }
        return w9Var.a();
    }

    private static void d(w9 w9Var, int i6) {
        w9Var.r(0, i6);
    }

    private static int a(w9 w9Var) {
        return w9Var.n();
    }
}
