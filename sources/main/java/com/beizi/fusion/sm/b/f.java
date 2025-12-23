package com.beizi.fusion.sm.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.l3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f {
    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e6) {
            e.a("System property invoke error: " + e6);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static boolean b() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static boolean c() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(a("ro.build.version.opporom", ""));
    }

    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(a("ro.vivo.os.version", ""));
    }

    public static boolean e() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public static boolean f() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean g() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean h() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean i() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean j() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean k() {
        if (Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("LENOVO") || str.equalsIgnoreCase("ZUK");
    }

    public static boolean l() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean m() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean n() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean o() {
        return !TextUtils.isEmpty(a("ro.build.freeme.label", ""));
    }

    public static boolean p() {
        return a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean a() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR");
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
