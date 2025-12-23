package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.l3;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* renamed from: j, reason: collision with root package name */
    private static final CharSequence f23991j = "sony";
    private static final CharSequence xt = "amigo";
    private static final CharSequence cw = "funtouch";

    /* renamed from: r, reason: collision with root package name */
    private static final j<Boolean> f23992r = new j<Boolean>() { // from class: com.bytedance.embedapplog.g.1
    };

    public static String j() {
        return xt("ro.build.version.emui");
    }

    public static boolean r() {
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("Honor", e6.getMessage());
        }
        return !TextUtils.isEmpty((String) cls.getDeclaredMethod(l3.f4736f, String.class).invoke(cls, "ro.build.version.emui"));
    }

    public static boolean up() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean xt() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("huawei")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("huawei");
    }

    static abstract class j<T> {
        j() {
        }
    }

    public static boolean ae() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public static boolean cw() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(str2);
    }

    public static boolean g() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            str = j();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || xt() || cw();
    }

    public static boolean m() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean oq() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean qv() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String xt2 = xt("ro.build.version.incremental");
        return !TextUtils.isEmpty(xt2) && xt2.contains("VIBEUI_V2");
    }

    public static boolean tl() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    private static String ws() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    private static String xt(String str) {
        String j6 = nt.j(str);
        return !TextUtils.isEmpty(j6) ? j6 : ri.j(str);
    }

    public static boolean jy() {
        return ws().toUpperCase().contains("ASUS");
    }

    public static boolean vl() {
        return ws().toUpperCase().contains("NUBIA");
    }

    public static boolean j(Context context) {
        return ws().toUpperCase().contains("HUAWEI");
    }
}
