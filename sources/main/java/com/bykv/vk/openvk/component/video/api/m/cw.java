package com.bykv.vk.openvk.component.video.api.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.common.util.Logger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static String cw = "";

    /* renamed from: j, reason: collision with root package name */
    private static boolean f22967j = false;
    private static int xt = 4;

    public static void cw(String str, String str2) {
        if (f22967j && str2 != null && xt <= 6) {
            vl.r(cw(str), str2);
        }
    }

    public static void j(int i6) {
        xt = i6;
    }

    public static boolean xt() {
        return f22967j;
    }

    public static void j() {
        f22967j = true;
        j(3);
    }

    public static void xt(String str, String str2) {
        if (f22967j && str2 != null && xt <= 5) {
            vl.xt(cw(str), str2);
        }
    }

    public static void cw(String str, String str2, Throwable th) {
        if (f22967j) {
            if (!(str2 == null && th == null) && xt <= 6) {
                vl.cw(cw(str), str2, th);
            }
        }
    }

    public static void j(String str) {
        if (f22967j) {
            j(Logger.f33115b, str);
        }
    }

    public static void xt(String str, String str2, Throwable th) {
        if (f22967j) {
            if (!(str2 == null && th == null) && xt <= 5) {
                vl.xt(cw(str), str2, th);
            }
        }
    }

    public static void j(String str, String str2) {
        if (f22967j && str2 != null && xt <= 4) {
            vl.j(cw(str), str2);
        }
    }

    private static String cw(String str) {
        if (TextUtils.isEmpty(cw)) {
            return str;
        }
        return j("[" + cw + "]-[" + str + "]");
    }

    public static void xt(String str, Object... objArr) {
        if (f22967j && objArr != null && xt <= 5) {
            cw(str);
            j(objArr);
        }
    }

    public static void j(String str, String str2, Throwable th) {
        if (f22967j) {
            if (!(str2 == null && th == null) && xt <= 4) {
                vl.j(cw(str), str2, th);
            }
        }
    }

    public static void xt(String str) {
        if (f22967j) {
            cw(Logger.f33115b, str);
        }
    }

    public static void j(String str, Object... objArr) {
        if (f22967j && objArr != null && xt <= 4) {
            cw(str);
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
}
