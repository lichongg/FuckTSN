package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.common.util.Logger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl {
    private static com.bytedance.sdk.component.j cw = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f26903j = false;

    /* renamed from: r, reason: collision with root package name */
    private static String f26904r = "";
    private static int xt = 4;

    public static boolean cw() {
        return f26903j;
    }

    public static void j(com.bytedance.sdk.component.j jVar) {
        cw = jVar;
    }

    public static void r(String str, String str2) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.cw(r(str), str2);
        }
        if (f26903j && str2 != null && xt <= 6) {
            r(str);
        }
    }

    public static void xt() {
        f26903j = true;
        j(3);
    }

    public static void cw(String str, String str2) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.j(r(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = Logger.f33115b;
        }
        r(str);
    }

    public static void j(int i6) {
        xt = i6;
    }

    public static boolean j() {
        return xt <= 3;
    }

    public static void xt(String str) {
        if (f26903j) {
            xt(Logger.f33115b, str);
        }
    }

    public static void j(String str) {
        if (f26903j) {
            j(Logger.f33115b, str);
        }
    }

    public static void xt(String str, String str2) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.xt(r(str), str2);
        }
        if (f26903j && str2 != null && xt <= 5) {
            r(str);
        }
    }

    public static void cw(String str) {
        if (f26903j) {
            r(Logger.f33115b, str);
        }
    }

    public static void j(String str, String str2) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.j(r(str), str2);
        }
        if (f26903j && str2 != null && xt <= 4) {
            r(str);
        }
    }

    public static String r(String str) {
        if (TextUtils.isEmpty(f26904r)) {
            return str;
        }
        return j("[" + f26904r + "]-[" + str + "]");
    }

    public static void cw(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.xt(r(str), str2, th);
        }
        if (f26903j) {
            if (!(str2 == null && th == null) && xt <= 6) {
                r(str);
            }
        }
    }

    public static void xt(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.j(r(str), str2, th);
        }
        if (f26903j) {
            if (!(str2 == null && th == null) && xt <= 5) {
                r(str);
            }
        }
    }

    public static void j(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.j(r(str), str2 + Log.getStackTraceString(th));
        }
        if (f26903j) {
            if (!(str2 == null && th == null) && xt <= 4) {
                r(str);
            }
        }
    }

    public static void cw(String str, Object... objArr) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.cw(r(str), j(objArr));
        }
        if (f26903j && objArr != null && xt <= 6) {
            r(str);
            j(objArr);
        }
    }

    public static void xt(String str, Object... objArr) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.xt(r(str), j(objArr));
        }
        if (f26903j && objArr != null && xt <= 5) {
            r(str);
            j(objArr);
        }
    }

    public static void j(String str, Object... objArr) {
        com.bytedance.sdk.component.j jVar = cw;
        if (jVar != null) {
            jVar.j(r(str), j(objArr));
        }
        if (f26903j && objArr != null && xt <= 4) {
            r(str);
            j(objArr);
        }
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

    public static void j(Throwable th) {
        xt(f26904r, "", th);
    }

    public static void j(int i6, String str, String str2) {
        j(str, str2);
    }
}
