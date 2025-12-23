package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.l3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ay {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40934a = "ro.build.version.emui";

    /* renamed from: b, reason: collision with root package name */
    private static final String f40935b = "hw_sc.build.platform.version";

    public static av a(Context context) {
        String str = Build.BRAND;
        bh.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new az();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new bg();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new bf();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new bd();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new ba();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new bc();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new be();
        }
        if (a()) {
            return new az();
        }
        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu") || c()) {
            return new bb();
        }
        if (b()) {
            return new ax();
        }
        return null;
    }

    private static boolean c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean b() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a(f40934a)) && TextUtils.isEmpty(a(f40935b))) ? false : true;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(l3.f4736f, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
