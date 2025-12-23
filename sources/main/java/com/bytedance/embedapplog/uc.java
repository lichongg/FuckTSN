package com.bytedance.embedapplog;

/* loaded from: D:\Downloads\app\classes3.dex */
public class uc {

    /* renamed from: j, reason: collision with root package name */
    public static boolean f24071j;
    public static boolean xt;

    public static void j(String str) {
    }

    public static void xt(String str) {
        xt(str, null);
    }

    public static void cw(String str, Throwable th) {
        com.bytedance.sdk.component.utils.vl.cw("TeaLog", str, th);
    }

    public static void j(String str, Throwable th) {
    }

    public static void r(String str, Throwable th) {
        com.bytedance.sdk.component.utils.vl.j("TeaLog", str, th);
    }

    public static void xt(String str, Throwable th) {
        com.bytedance.sdk.component.utils.vl.xt("TeaLog", str, th);
    }

    public static void j(Throwable th) {
        com.bytedance.sdk.component.utils.vl.cw("TeaLog", "", th);
    }

    public static void xt(Throwable th) {
        if (th != null) {
            com.bytedance.sdk.component.utils.vl.j("TeaLog", th.getMessage());
        }
    }
}
