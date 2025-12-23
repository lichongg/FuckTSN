package com.bytedance.msdk.j.up;

import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.common.util.Logger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static int cw = 4;

    /* renamed from: j, reason: collision with root package name */
    static boolean f25143j = true;
    private static boolean xt;

    public static void cw(String str, String str2) {
        if (xt() && str2 != null && cw <= 5) {
            vl.xt(str, str2);
        }
    }

    public static void j(int i6) {
        cw = i6;
    }

    public static boolean xt() {
        return com.bytedance.msdk.tl.vl.f25240j || xt;
    }

    public static void j() {
        xt = true;
        j(3);
    }

    public static void xt(String str) {
        if (xt()) {
            xt(Logger.f33115b, str);
        }
    }

    public static void r(String str, String str2) {
        if (xt() && str2 != null && cw <= 6) {
            vl.r(str, str2);
        }
    }

    public static void cw(String str) {
        if (xt()) {
            r(Logger.f33115b, str);
        }
    }

    public static void j(String str) {
        if (xt()) {
            j(Logger.f33115b, str);
        }
    }

    public static void xt(String str, String str2) {
        if (xt() && str2 != null && cw <= 4) {
            vl.j(str, str2);
        }
    }

    public static void j(String str, String str2) {
        xt();
    }

    public static void j(String str, String str2, Throwable th) {
        xt();
    }

    public static void xt(String str, String str2, Throwable th) {
        if (xt()) {
            if (!(str2 == null && th == null) && cw <= 6) {
                vl.cw(str, str2, th);
            }
        }
    }
}
