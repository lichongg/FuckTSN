package xyz.adscope.common.v2.dev.info;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class PackageUtil {
    private static final String PACKAGE_HMS = "com.huawei.hwid";
    private static final String PACKAGE_HMS_STORE = "com.huawei.appmarket";
    private static final String TAG = "PackageUtil";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class PackageInfoHolder {
        private static volatile PackageInfoHolder instance;
        private volatile PackageInfo info;

        public static PackageInfoHolder getInstance() {
            if (instance == null) {
                synchronized (PackageInfoHolder.class) {
                    try {
                        if (instance == null) {
                            instance = new PackageInfoHolder();
                        }
                    } finally {
                    }
                }
            }
            return instance;
        }

        public PackageInfo getSelfPackageInfo(Context context) {
            if (this.info == null) {
                synchronized (PackageInfoHolder.class) {
                    if (this.info == null) {
                        try {
                            this.info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        } catch (PackageManager.NameNotFoundException unused) {
                            this.info = null;
                        }
                    }
                }
            }
            return this.info;
        }

        private PackageInfoHolder() {
        }
    }

    public static String getPackageVersionCode(Context context) {
        int i6;
        PackageInfo selfPackageInfo = PackageInfoHolder.getInstance().getSelfPackageInfo(context);
        return (selfPackageInfo == null || (i6 = selfPackageInfo.versionCode) == 0) ? "" : String.valueOf(i6);
    }

    public static boolean isInstall(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    if (packageManager.getPackageInfo(str, 0) != null) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static String getAppName(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0)).toString();
        } catch (PackageManager.NameNotFoundException e6) {
            SDKLog.stack(e6);
            return "";
        }
    }

    public static String getHmsCoreVersionCode(Context context) {
        return getPackageVersionCode(context, PACKAGE_HMS);
    }

    public static String getHmsStoreVersionCode(Context context) {
        return getPackageVersionCode(context, PACKAGE_HMS_STORE);
    }

    private PackageUtil() {
    }

    public static long getAppInstallDate(Context context) {
        PackageInfo selfPackageInfo = PackageInfoHolder.getInstance().getSelfPackageInfo(context);
        if (selfPackageInfo != null) {
            return selfPackageInfo.firstInstallTime;
        }
        return 0L;
    }

    public static long getAppLastUpdateTime(Context context) {
        PackageInfo selfPackageInfo = PackageInfoHolder.getInstance().getSelfPackageInfo(context);
        if (selfPackageInfo != null) {
            return selfPackageInfo.lastUpdateTime;
        }
        return 0L;
    }

    public static String getAppVersionCode(Context context) {
        return getPackageVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return getPackageVersionName(context);
    }

    public static String getPackageVersionName(Context context) {
        PackageInfo selfPackageInfo = PackageInfoHolder.getInstance().getSelfPackageInfo(context);
        if (selfPackageInfo != null) {
            return selfPackageInfo.versionName;
        }
        return "";
    }

    public static String getPackageVersionCode(Context context, String str) {
        int i6;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null && (i6 = packageInfo.versionCode) != 0) {
                    return String.valueOf(i6);
                }
                return "";
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }
        return "";
    }
}
