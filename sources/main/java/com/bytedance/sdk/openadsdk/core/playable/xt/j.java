package com.bytedance.sdk.openadsdk.core.playable.xt;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static boolean j(Context context) {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (lowerCase.contains("vivo")) {
                    return r(context);
                }
                if (lowerCase.contains("oppo")) {
                    return up(context);
                }
                if (!lowerCase.contains("xiaomi") && !lowerCase.contains("redmi")) {
                    if (lowerCase.contains("samsung")) {
                        return false;
                    }
                    return m(context);
                }
                return cw(context);
            }
            return xt(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean cw(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            return false;
        }
        return true;
    }

    private static boolean m(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0) {
            return false;
        }
        return true;
    }

    private static boolean r(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
            return false;
        }
        return true;
    }

    private static boolean up(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) == 0) {
            return false;
        }
        return true;
    }

    private static boolean xt(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains("huawei") || lowerCase.contains("honor") || lowerCase.contains("vivo") || lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase.contains("oppo");
    }
}
