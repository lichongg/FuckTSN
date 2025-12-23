package xyz.adscope.common.v2.dev.info;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SettingCheckCompilation {
    private static final String HUAWEI = "HUAWEI";
    private static final String HYPER = "XIAOMI";
    private static final String MAGIC = "HONOR";
    private static final String OPPO = "OPPO";
    private static final String VIVO = "VIVO";

    public static int checkIntentPrompt(Context context) {
        String upperCase;
        try {
            upperCase = Build.BRAND.toUpperCase();
        } catch (Throwable unused) {
        }
        switch (upperCase.hashCode()) {
            case -1706170181:
                if (upperCase.equals(HYPER)) {
                    return checkHyperIntentPrompt(context);
                }
                return -1;
            case 2432928:
                if (upperCase.equals(OPPO)) {
                    return checkOppoIntentPrompt(context);
                }
                return -1;
            case 2634924:
                if (upperCase.equals(VIVO)) {
                    return checkVivoIntentPrompt(context);
                }
                return -1;
            case 68924490:
                if (upperCase.equals(MAGIC)) {
                    return checkMagicIntentPrompt(context);
                }
                return -1;
            case 2141820391:
                if (upperCase.equals(HUAWEI)) {
                    return checkHuaweiIntentPrompt(context);
                }
                return -1;
            default:
                return -1;
        }
    }

    private static int checkHyperIntentPrompt(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        Class cls = Integer.TYPE;
        Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOpNoThrow", cls, cls, String.class);
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        if (applicationInfo != null) {
            return Integer.valueOf(declaredMethod.invoke(appOpsManager, 10049, Integer.valueOf(applicationInfo.uid), context.getPackageName()).toString()).intValue();
        }
        return -1;
    }

    private static int checkVivoIntentPrompt(Context context) {
        Intent intent = new Intent("com.vivo.appfilter.ACTION_APP_JUMP_PROMPT");
        intent.setPackage("com.vivo.appfilter");
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty() ? 1 : 0;
    }

    private static int checkHuaweiIntentPrompt(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", -1) == 1) {
            return 0;
        }
        Method declaredMethod = Class.forName("com.huawei.android.os.SystemPropertiesEx").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
        declaredMethod.setAccessible(true);
        if (!((Boolean) declaredMethod.invoke(null, "hw_sc.appswitch_interceptor", Boolean.FALSE)).booleanValue()) {
            return 0;
        }
        return 1;
    }

    private static int checkMagicIntentPrompt(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "application_auto_jump_switch", -1);
    }

    private static int checkOppoIntentPrompt(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "app_start_confirm_rus_enable", -1);
    }
}
