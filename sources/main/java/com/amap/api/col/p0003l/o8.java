package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o8 extends x9 {
    public static int b(w9 w9Var, int i6, int i7, int i8) {
        w9Var.q(3);
        h(w9Var, i8);
        g(w9Var, i7);
        e(w9Var, i6);
        return a(w9Var);
    }

    public static int c(w9 w9Var, byte[] bArr) {
        w9Var.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            w9Var.d(bArr[length]);
        }
        return w9Var.a();
    }

    public static int d(w9 w9Var, int[] iArr) {
        w9Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            w9Var.e(iArr[length]);
        }
        return w9Var.a();
    }

    private static void e(w9 w9Var, int i6) {
        w9Var.r(0, i6);
    }

    public static int f(w9 w9Var, byte[] bArr) {
        w9Var.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            w9Var.d(bArr[length]);
        }
        return w9Var.a();
    }

    private static void g(w9 w9Var, int i6) {
        w9Var.r(1, i6);
    }

    private static void h(w9 w9Var, int i6) {
        w9Var.r(2, i6);
    }

    private static int a(w9 w9Var) {
        return w9Var.n();
    }
}
