package com.huawei.hms.hatool;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class j1 {

    /* renamed from: a, reason: collision with root package name */
    private static m0 f33596a = new m0();

    public static void a(int i6) {
        f33596a.b(i6);
    }

    private static boolean d() {
        return f33596a.e(3);
    }

    private static boolean g() {
        return f33596a.e(6);
    }

    private static boolean i() {
        return f33596a.e(4);
    }

    public static void j(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f33596a.d(4, str, str2);
    }

    private static boolean k() {
        return f33596a.e(5);
    }

    public static void l(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f33596a.d(5, str, str2);
    }

    public static void b(String str, String str2) {
        if (d() && str != null && str2 != null) {
            f33596a.d(3, str, str2);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (i() && str != null && str2 != null) {
            f33596a.d(4, str, String.format(str2, objArr));
        }
    }

    public static void e(String str, String str2) {
        if (g() && str != null && str2 != null) {
            f33596a.d(6, str, str2);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        j(str, String.format(str2, objArr));
    }

    public static void h(String str, String str2) {
        if (i() && str != null && str2 != null) {
            f33596a.d(4, str, str2);
        }
    }

    public static void m(String str, String str2) {
        if (k() && str != null && str2 != null) {
            f33596a.d(5, str, str2);
        }
    }
}
