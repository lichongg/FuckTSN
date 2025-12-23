package com.bytedance.sdk.component.adexpress.r;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.kt;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f25848j;

    public static float cw(Context context, float f6) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext();
        }
        return f6 * up(context);
    }

    public static int j(float f6, float f7, float f8, float f9) {
        return (((int) ((f6 * 255.0f) + 0.5f)) << 24) | (((int) ((f7 * 255.0f) + 0.5f)) << 16) | (((int) ((f8 * 255.0f) + 0.5f)) << 8) | ((int) ((f9 * 255.0f) + 0.5f));
    }

    public static int xt(Context context, float f6) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext();
        }
        float up = up(context);
        if (up <= 0.0f) {
            up = 1.0f;
        }
        return (int) ((f6 / up) + 0.5f);
    }

    public static float j(Context context, float f6) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext();
        }
        return (f6 * up(context)) + 0.5f;
    }

    public static String r(Context context) {
        String str;
        Locale locale;
        LocaleList locales;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locales = kt.j(context).getConfiguration().getLocales();
                locale = locales.get(0);
            } else {
                locale = Locale.getDefault();
            }
            str = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    str = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return j(str);
    }

    private static float up(Context context) {
        try {
            if (f25848j) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", null).setAccessible(true);
                return ((Integer) r1.invoke(r0, null)).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int cw(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int xt(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int j(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static String j(String str) {
        str.getClass();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
