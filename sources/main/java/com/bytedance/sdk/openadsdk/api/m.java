package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f27552j = false;
    private static int xt = 4;

    public static void cw(String str, String str2) {
        if (f27552j && str2 != null && xt <= 4) {
            vl.j(str, str2);
        }
    }

    public static void j(String str, String str2) {
    }

    public static void r(String str, String str2) {
        if (f27552j && str2 != null && xt <= 5) {
            vl.xt(str, str2);
        }
    }

    public static void up(String str, String str2) {
        if (f27552j && str2 != null && xt <= 6) {
            vl.r(str, str2);
        }
    }

    public static void xt(String str, String str2) {
    }

    public static void j(String str, String str2, Throwable th) {
    }

    public static void xt(String str, String str2, Throwable th) {
    }

    public static void j(int i6) {
        xt = i6;
    }

    public static void xt(String str) {
        if (f27552j) {
            r("TTLogger", str);
        }
    }

    public static void cw(String str, String str2, Throwable th) {
        if (f27552j) {
            if (!(str2 == null && th == null) && xt <= 4) {
                vl.j(str, str2, th);
            }
        }
    }

    public static void j() {
        f27552j = true;
        j(3);
    }

    public static void r(String str, String str2, Throwable th) {
        if (f27552j) {
            if (!(str2 == null && th == null) && xt <= 5) {
                vl.xt(str, str2, th);
            }
        }
    }

    public static void up(String str, String str2, Throwable th) {
        if (f27552j) {
            if (!(str2 == null && th == null) && xt <= 6) {
                vl.cw(str, str2, th);
            }
        }
    }

    public static void xt(String str, Object... objArr) {
        if (f27552j && objArr != null && xt <= 5) {
            j(objArr);
        }
    }

    public static void j(String str, Object... objArr) {
        if (f27552j && objArr != null && xt <= 3) {
            j(objArr);
        }
    }

    public static void cw(String str) {
        if (f27552j) {
            up("TTLogger", str);
        }
    }

    public static void j(String str) {
        if (f27552j) {
            cw("TTLogger", str);
        }
    }

    public static void j(Throwable th) {
        r("TTLogger", "", th);
    }

    private static String j(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                } else {
                    sb.append(" null ");
                }
                sb.append(" ");
            }
            return sb.toString();
        }
        return "";
    }
}
