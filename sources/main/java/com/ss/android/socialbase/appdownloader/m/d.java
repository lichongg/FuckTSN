package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.l3;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f38485a;

    /* renamed from: b, reason: collision with root package name */
    private static String f38486b;

    /* renamed from: c, reason: collision with root package name */
    private static String f38487c;

    /* renamed from: d, reason: collision with root package name */
    private static String f38488d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f38489e;

    public static int b(Context context) {
        if (context != null) {
            return o(m(), e()) ? Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1 : Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    private static int d(int i6) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i6))).intValue();
        } catch (Throwable th) {
            vl.j(th);
            return 1;
        }
    }

    private static String f(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, null).invoke(cls, null).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int j(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static String a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", null).invoke(cls, null);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c() {
        if (f38487c == null) {
            f38487c = f("getReleaseType");
        }
        return f38487c;
    }

    public static String e() {
        if (f38485a == null) {
            f38485a = f("getApiVersion");
        }
        return f38485a;
    }

    private static String g(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static boolean h(Context context) {
        return context != null && b(context) == 0 && l();
    }

    public static String k() {
        if (f38488d == null) {
            f38488d = f("getBuildVersion");
        }
        return f38488d;
    }

    public static boolean l() {
        if (f38489e == null) {
            f38489e = Boolean.FALSE;
            try {
                f38489e = Boolean.valueOf("156".equals(g("ro.config.hw_optb", "0")) && "true".equals(g("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return f38489e.booleanValue();
    }

    public static String m() {
        if (f38486b == null) {
            f38486b = f("getVersion");
        }
        return f38486b;
    }

    public static boolean n(Context context) {
        return context != null && j(context) == 0 && i();
    }

    public static boolean i() {
        if (l() && o(m(), e()) && d(Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    private static boolean o(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str.startsWith("3")) {
            return true;
        }
        return false;
    }
}
