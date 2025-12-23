package com.umeng.socialize.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.kuaishou.weapon.p0.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DeviceConfigInternal {
    protected static final String LOG_TAG = "DeviceConfig";
    private static final String MOBILE_NETWORK = "2G/3G";
    protected static final String UNKNOW = "Unknown";
    private static final String WIFI = "Wi-Fi";
    public static Context context;
    private static Object object = new Object();

    public static boolean isAppInstalled(String str, Context context2) {
        boolean z5 = false;
        if (context2 == null) {
            return false;
        }
        synchronized (object) {
            try {
                context2.getPackageManager().getPackageInfo(str, 1);
                z5 = true;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return z5;
    }

    public static boolean isNetworkAvailable(Context context2) {
        return context2 != null && DeviceConfig.checkPermission(context2, g.f36042b) && DeviceConfig.isOnline(context2);
    }

    public static String getAndroidID(Context context2) {
        String androidId;
        return (context2 == null || (androidId = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(context2)) == null) ? "" : androidId;
    }

    public static String getAppVersion(String str, Context context2) {
        if (context2 == null) {
            return "";
        }
        try {
            return context2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPackageName(Context context2) {
        return context2 == null ? "" : context2.getPackageName();
    }

    public static boolean checkPermission(Context context2, String str) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(context2, str);
    }

    public static String getDeviceId(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceId(context2);
    }

    public static String getDeviceSN() {
        String serial = com.umeng.commonsdk.statistics.common.DeviceConfig.getSerial();
        if (serial == null) {
            return "unknown";
        }
        return serial;
    }

    public static String getMac(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(context2);
    }

    public static String[] getNetworkAccessMode(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(context2);
    }

    public static boolean isOnline(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.isOnline(context2);
    }
}
