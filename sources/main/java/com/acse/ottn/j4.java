package com.acse.ottn;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.util.HelpShopAppUtil;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j4 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4664a = "harmony";

    public static String a() {
        String e6 = j3.a().e("getDeviceBoard");
        if (!TextUtils.isEmpty(e6)) {
            return e6;
        }
        String lowerCase = Build.BOARD.toLowerCase();
        j3.a().b("getDeviceBoard", lowerCase);
        return lowerCase;
    }

    public static int b(Context context) {
        int c6 = j3.a().c("getDeviceHeight");
        if (c6 != 0) {
            return c6;
        }
        int i6 = context.getResources().getDisplayMetrics().heightPixels;
        j3.a().a("getDeviceHeight", i6);
        return i6;
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        int c6 = j3.a().c("getDeviceWidth");
        if (c6 != 0) {
            return c6;
        }
        int i6 = context.getResources().getDisplayMetrics().widthPixels;
        j3.a().a("getDeviceWidth", i6);
        return i6;
    }

    public static String d() {
        String e6 = j3.a().e("getDeviceDevice");
        if (!TextUtils.isEmpty(e6)) {
            return e6;
        }
        String lowerCase = Build.DEVICE.toLowerCase();
        j3.a().b("getDeviceDevice", lowerCase);
        return lowerCase;
    }

    public static String e() {
        return Build.DISPLAY.toLowerCase();
    }

    public static boolean t() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", null);
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null || classLoader.getParent() != null) {
                return false;
            }
            return f4664a.equals(method.invoke(cls, null));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
    }

    public static String m() {
        c2.a("wangjie", "Local:" + Locale.GERMAN);
        c2.a("wangjie", "Local:" + Locale.ENGLISH);
        c2.a("wangjie", "Local:" + Locale.US);
        c2.a("wangjie", "Local:" + Locale.CHINESE);
        c2.a("wangjie", "Local:" + Locale.TAIWAN);
        c2.a("wangjie", "Local:" + Locale.FRANCE);
        c2.a("wangjie", "Local:" + Locale.FRENCH);
        c2.a("wangjie", "Local:" + Locale.GERMANY);
        c2.a("wangjie", "Local:" + Locale.ITALIAN);
        c2.a("wangjie", "Local:" + Locale.JAPAN);
        c2.a("wangjie", "Local:" + Locale.JAPANESE);
        return Locale.getAvailableLocales().toString();
    }

    public static String q() {
        return Build.VERSION.RELEASE.toLowerCase();
    }

    public static String s() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String f() {
        String e6 = j3.a().e("getDeviceFubgerprint");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.FINGERPRINT.toLowerCase();
            j3.a().b("getDeviceFubgerprint", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String g() {
        String e6 = j3.a().e("getDeviceHardware");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.HARDWARE.toLowerCase();
            j3.a().b("getDeviceHardware", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String h() {
        String e6 = j3.a().e("getDeviceHost");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.HOST.toLowerCase();
            j3.a().b("getDeviceHost", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String i() {
        String e6 = j3.a().e("getDeviceManufacturer");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            j3.a().b("getDeviceManufacturer", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String j() {
        String e6 = j3.a().e("getDeviceProduct");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.PRODUCT.toLowerCase();
            j3.a().b("getDeviceProduct", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static int k() {
        int c6 = j3.a().c("getDeviceSDK");
        if (c6 == 0) {
            int i6 = Build.VERSION.SDK_INT;
            j3.a().a("getDeviceSDK", i6);
            return i6;
        }
        return c6;
    }

    public static String l() {
        String e6 = j3.a().e("getDeviceSerial");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.SERIAL.toLowerCase();
            j3.a().b("getDeviceSerial", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String n() {
        String e6 = j3.a().e("getDeviceUser");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.USER.toLowerCase();
            j3.a().b("getDeviceUser", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String o() {
        String e6 = j3.a().e("getMobileId");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.ID.toLowerCase();
            j3.a().b("getMobileId", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String p() {
        String e6 = j3.a().e("getSystemModel");
        if (TextUtils.isEmpty(e6)) {
            String lowerCase = Build.MODEL.toLowerCase();
            j3.a().b("getSystemModel", lowerCase);
            return lowerCase;
        }
        return e6;
    }

    public static String r() {
        if (HelpShopAppUtil.getContext() == null) {
            return "";
        }
        String str = "0";
        try {
            PackageInfo packageInfo = HelpShopAppUtil.getContext().getPackageManager().getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0);
            str = packageInfo.versionCode + "";
            j3.a().b("appName", packageInfo.packageName);
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
        }
        j3.a().b("app_version_code", str);
        return str;
    }

    public static String b() {
        if (j3.a() == null) {
            return "";
        }
        String e6 = j3.a().e("getDeviceBrand");
        if (!TextUtils.isEmpty(j3.a().e("getDeviceBrand"))) {
            return e6;
        }
        String lowerCase = Build.BRAND.toLowerCase();
        j3.a().b("getDeviceBrand", lowerCase);
        return lowerCase;
    }

    public static String c() {
        return Locale.getDefault().getLanguage().toLowerCase();
    }

    public static String a(Context context) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n2. 设备宽度:\n\t\t");
        sb.append(c(context));
        sb.append("\n\n3. 设备高度:\n\t\t");
        sb.append(b(context));
        sb.append("\n\n10. 系统默认语言:\n\t\t");
        sb.append(c());
        sb.append("\n\n11. 硬件序列号(设备名):\n\t\t");
        sb.append(l());
        sb.append("\n\n12. 手机型号:\n\t\t");
        sb.append(p());
        sb.append("\n\n13. 生产厂商:\n\t\t");
        sb.append(i());
        sb.append("\n\n14. 手机Fingerprint标识:\n\t\t");
        sb.append(f());
        sb.append("\n\n15. Android 版本:\n\t\t");
        sb.append(q());
        sb.append("\n\n16. Android SDK版本:\n\t\t");
        sb.append(k());
        sb.append("\n\n17. 安全patch 时间:\n\t\t");
        str = Build.VERSION.SECURITY_PATCH;
        sb.append(str);
        sb.append("\n\n19. 版本类型:\n\t\t");
        sb.append(Build.TYPE);
        sb.append("\n\n20. 用户名:\n\t\t");
        sb.append(n());
        sb.append("\n\n21. 产品名:\n\t\t");
        sb.append(j());
        sb.append("\n\n22. ID:\n\t\t");
        sb.append(o());
        sb.append("\n\n23. 显示ID:\n\t\t");
        sb.append(e());
        sb.append("\n\n24. 硬件名:\n\t\t");
        sb.append(g());
        sb.append("\n\n25. 产品名:\n\t\t");
        sb.append(d());
        sb.append("\n\n26. Bootloader:\n\t\t");
        sb.append(Build.BOOTLOADER);
        sb.append("\n\n27. 主板名:\n\t\t");
        sb.append(a());
        sb.append("\n\n28. CodeName:\n\t\t");
        sb.append(Build.VERSION.CODENAME);
        return sb.toString();
    }

    public static boolean d(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) != 0;
    }
}
