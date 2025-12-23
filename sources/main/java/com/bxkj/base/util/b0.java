package com.bxkj.base.util;

import android.content.Context;
import android.os.Build;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b0 {
    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static synchronized String b(Context context) {
        String string;
        synchronized (b0.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e6) {
                e6.printStackTrace();
                return null;
            }
        }
        return string;
    }

    public static String c() {
        k kVar = k.f16630a;
        return kVar.d() ? kVar.b() : Build.VERSION.RELEASE;
    }

    public static String d() {
        return a(Build.MANUFACTURER);
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? a(str2) : str2;
    }

    public static String f() {
        return k.f16630a.d() ? "HarmonyOS" : "Android";
    }

    public static String h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e6) {
            e6.printStackTrace();
            return "1.0";
        }
    }
}
