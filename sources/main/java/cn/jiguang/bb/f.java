package cn.jiguang.bb;

import cn.jiguang.internal.JConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, Set<String>> f1975a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static long f1976b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static String f1977c = "[key-step]";

    public static void a(int i6, String str, String str2) {
        try {
            if (f1976b > 102400) {
                f1975a.clear();
                f1976b = 0L;
            }
            if (!f1975a.containsKey(Integer.valueOf(i6))) {
                f1975a.put(Integer.valueOf(i6), new HashSet());
            }
            Set<String> set = f1975a.get(Integer.valueOf(i6));
            if (set.contains(str2)) {
                return;
            }
            c(str, str2);
            long length = f1976b + str2.length();
            f1976b = length;
            f1976b = length + String.valueOf(i6).length();
            set.add(str2);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 2, str2, null);
    }

    public static void c(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 3, str2, null);
    }

    public static void d(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 3, str2, null);
    }

    public static void e(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 3, f1977c + str2, null);
    }

    public static void f(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 4, str2, null);
    }

    public static void g(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 4, str2, null);
    }

    public static void i(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 5, str2, null);
    }

    public static void j(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 5, str2, null);
    }

    public static void l(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 6, str2, null);
    }

    public static void m(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 6, str2, null);
    }

    public static void a(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, true, 2, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, true, 5, str2, th);
    }

    public static void c(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, false, 5, str2, th);
    }

    public static void d(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, true, 6, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, false, 6, str2, th);
    }

    public static void f(String str, String str2, Throwable th) {
        e(str, str2, th);
    }

    public static void h(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 4, f1977c + str2, null);
    }

    public static void k(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 5, f1977c + str2, null);
    }

    public static void n(String str, String str2) {
        c.a(JConstants.SDK_TYPE, str, false, 6, f1977c + str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        c.a(JConstants.SDK_TYPE, str, false, 3, str2, th);
    }
}
