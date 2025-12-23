package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PowerUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33341a = "PowerUtils";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class PowerMode {
        static final int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static final int POWER_SAVER_MODE = 4;
        static final String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isAppIdleMode(Context context) {
        UsageStatsManager usageStatsManager;
        boolean isAppInactive;
        if (context == null) {
            Logger.i(f33341a, "isAppIdleMode Context is null!");
            return false;
        }
        String packageName = context.getPackageName();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 22) {
            Object systemService = context.getSystemService("usagestats");
            usageStatsManager = systemService instanceof UsageStatsManager ? (UsageStatsManager) systemService : null;
            return false;
        }
        if (usageStatsManager == null) {
            Logger.i(f33341a, "isAppIdleMode statsManager is null!");
            return false;
        }
        if (i6 >= 23) {
            isAppInactive = usageStatsManager.isAppInactive(packageName);
            return isAppInactive;
        }
        return false;
    }

    public static boolean isDozeIdleMode(Context context) {
        boolean isDeviceIdleMode;
        if (context == null) {
            Logger.i(f33341a, "isDozeIdleMode Context is null!");
            return false;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            Logger.i(f33341a, "isDozeIdleMode powerManager is null!");
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            Logger.i(f33341a, "isDozeIdleMode is version control state!");
            return false;
        }
        try {
            isDeviceIdleMode = powerManager.isDeviceIdleMode();
            return isDeviceIdleMode;
        } catch (RuntimeException e6) {
            Logger.e(f33341a, "dealType rethrowFromSystemServer:", e6);
            return false;
        }
    }

    public static boolean isInteractive(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        if (!(systemService instanceof PowerManager)) {
            return false;
        }
        try {
            return ((PowerManager) systemService).isInteractive();
        } catch (RuntimeException e6) {
            Logger.i(f33341a, "getActiveNetworkInfo failed, exception:" + e6.getClass().getSimpleName() + e6.getMessage());
            return false;
        }
    }

    public static boolean isWhilteList(Context context) {
        boolean isIgnoringBatteryOptimizations;
        if (context == null) {
            return false;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        String packageName = context.getPackageName();
        if (powerManager == null || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(packageName);
            return isIgnoringBatteryOptimizations;
        } catch (RuntimeException e6) {
            Logger.e(f33341a, "dealType rethrowFromSystemServer:", e6);
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        int restrictBackgroundStatus;
        if (context == null) {
            Logger.i(f33341a, "readDataSaverMode manager is null!");
            return 0;
        }
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            Logger.i(f33341a, "readDataSaverMode Context is null!");
            return 0;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (!ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36042b)) {
            if (!connectivityManager.isActiveNetworkMetered()) {
                Logger.v(f33341a, "ConnectType is not Mobile Network!");
                return 0;
            }
            if (i6 >= 24) {
                restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
                return restrictBackgroundStatus;
            }
        }
        return 0;
    }

    public static int readPowerSaverMode(Context context) {
        if (context == null) {
            Logger.i(f33341a, "readPowerSaverMode Context is null!");
            return 0;
        }
        int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), "SmartModeStatus", 0);
        if (systemInt != 0) {
            return systemInt;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            return systemInt;
        }
        try {
            return powerManager.isPowerSaveMode() ? 4 : 0;
        } catch (RuntimeException e6) {
            Logger.e(f33341a, "dealType rethrowFromSystemServer:", e6);
            return systemInt;
        }
    }
}
