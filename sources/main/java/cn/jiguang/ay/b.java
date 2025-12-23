package cn.jiguang.ay;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f1839a = "D";

    public static void a(String str, String str2) {
        a.a(f1839a, str, true, 2, str2, null);
    }

    static {
        try {
            if (b.class.getCanonicalName().startsWith("cn.p.jiguang")) {
                f1839a = "D-P";
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, Throwable th) {
        a.a(f1839a, str, true, 5, str2, th);
    }

    public static void b(String str, String str2) {
        a.a(f1839a, str, true, 3, str2, null);
    }

    public static void c(String str, String str2) {
        a.a(f1839a, str, false, 3, str2, null);
    }

    public static void d(String str, String str2) {
        a.a(f1839a, str, false, 4, str2, null);
    }

    public static void e(String str, String str2) {
        a.a(f1839a, str, true, 5, str2, null);
    }

    public static void f(String str, String str2) {
        a.a(f1839a, str, false, 5, str2, null);
    }

    public static void g(String str, String str2) {
        a.a(f1839a, str, true, 6, str2, null);
    }
}
