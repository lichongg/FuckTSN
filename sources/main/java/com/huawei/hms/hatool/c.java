package com.huawei.hms.hatool;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class c {
    public static void a(String str, String str2, long j6) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            i6.b(j6);
        }
    }

    public static boolean b(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.f();
        }
        return true;
    }

    public static int c(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.n();
        }
        return 7;
    }

    public static boolean d(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.w();
        }
        return true;
    }

    public static String e(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.t();
        }
        return "";
    }

    public static boolean f(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.y();
        }
        return false;
    }

    public static String g(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.x();
        }
        return "";
    }

    public static String h(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.D();
        }
        return "";
    }

    private static c1 i(String str, String str2) {
        k0 a6 = d1.e().a(str);
        if (a6 != null) {
            if ("alltype".equals(str2)) {
                c1 b6 = a6.b("oper");
                if (b6 == null) {
                    return a6.b("maint");
                }
                return b6;
            }
            return a6.b(str2);
        }
        return null;
    }

    public static Map<String, String> j(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.A();
        }
        return null;
    }

    public static long k(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.B();
        }
        return 0L;
    }

    public static int l(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.g();
        }
        return 10;
    }

    public static String m(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.E();
        }
        return "";
    }

    public static String n(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.G();
        }
        return "";
    }

    public static String o(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.C();
        }
        return "";
    }

    public static String p(String str, String str2) {
        c1 i6 = i(str, str2);
        if (i6 != null) {
            return i6.F();
        }
        return "";
    }
}
