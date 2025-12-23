package xyz.adscope.common.v2.dev.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.bi;
import java.util.Locale;
import java.util.TimeZone;
import xyz.adscope.common.v2.dev.DeviceInfoConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DeviceUtil {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.dev.info.DeviceUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SystemMarkHelper {
        private final DevSysMark mSystemMark;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class InstanceHolder {
            private static final SystemMarkHelper instance = new SystemMarkHelper(null);

            private InstanceHolder() {
            }
        }

        /* synthetic */ SystemMarkHelper(AnonymousClass1 anonymousClass1) {
            this();
        }

        private SystemMarkHelper() {
            this.mSystemMark = new DevSysMark();
        }

        String getUpdateMark() {
            return this.mSystemMark.getSysUpdateMark();
        }

        static SystemMarkHelper getInstance() {
            return InstanceHolder.instance;
        }
    }

    public static int getOS() {
        return 2;
    }

    public static boolean isTablet(Context context) {
        Configuration configuration;
        if (context != null) {
            try {
                if (context.getResources() != null && (configuration = context.getResources().getConfiguration()) != null) {
                    if ((configuration.screenLayout & 15) >= 3) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String getAndroidRelease() {
        return Build.VERSION.RELEASE;
    }

    public static int getAndroidVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static String getCarrier(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && 5 == telephonyManager.getSimState() && (simOperator = telephonyManager.getSimOperator()) != null) {
                int hashCode = simOperator.hashCode();
                if (hashCode != 49679477) {
                    switch (hashCode) {
                        case 49679470:
                            if (simOperator.equals("46000")) {
                                return DeviceInfoConstants.CarrierType.CARRIER_CMCC;
                            }
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                return DeviceInfoConstants.CarrierType.CARRIER_CUCC;
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                return DeviceInfoConstants.CarrierType.CARRIER_CMCC;
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                return DeviceInfoConstants.CarrierType.CARRIER_CTCC;
                            }
                            break;
                    }
                } else if (simOperator.equals("46007")) {
                    return DeviceInfoConstants.CarrierType.CARRIER_CMCC;
                }
            }
        } catch (Throwable unused) {
        }
        return DeviceInfoConstants.CarrierType.CARRIER_UNKNOWN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r2 = r2.get(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCountryCode(android.content.Context r2) {
        /*
            if (r2 == 0) goto L37
            android.content.res.Resources r0 = r2.getResources()     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L37
            android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Throwable -> L37
            android.content.res.Configuration r2 = r2.getConfiguration()     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L37
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r1 = 24
            if (r0 < r1) goto L2e
            android.os.LocaleList r2 = androidx.appcompat.app.c.a(r2)     // Catch: java.lang.Throwable -> L37
            boolean r0 = androidx.appcompat.app.s.a(r2)     // Catch: java.lang.Throwable -> L37
            if (r0 != 0) goto L37
            r0 = 0
            java.util.Locale r2 = androidx.core.os.f.a(r2, r0)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L37
            java.lang.String r2 = r2.getCountry()     // Catch: java.lang.Throwable -> L37
            return r2
        L2e:
            java.util.Locale r2 = r2.locale     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L37
            java.lang.String r2 = r2.getCountry()     // Catch: java.lang.Throwable -> L37
            return r2
        L37:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.v2.dev.info.DeviceUtil.getCountryCode(android.content.Context):java.lang.String");
    }

    public static String getDeviceName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getContentResolver() != null ? Build.VERSION.SDK_INT >= 25 ? Settings.Global.getString(context.getContentResolver(), bi.J) : Settings.Global.getString(context.getContentResolver(), bi.J) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long getFileMark() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return Math.max(SystemPropertiesUtil.getLong(SystemPropertiesUtil.PROP_UTC, -1L), Math.max(Environment.getRootDirectory().lastModified(), Build.TIME));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    private static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    private DeviceUtil() {
    }

    public static int getCountryCN(Context context) {
        String countryCode = getCountryCode(context);
        if (!TextUtils.isEmpty(countryCode)) {
            countryCode = countryCode.toUpperCase();
        }
        DeviceInfoConstants.CountryType countryType = DeviceInfoConstants.CountryType.COUNTRY_CHINA_TYPE;
        if (countryType.getCountry().equals(countryCode)) {
            return countryType.getCode();
        }
        return DeviceInfoConstants.CountryType.COUNTRY_OTHER_TYPE.getCode();
    }

    public static int getDeviceType(Context context) {
        if (isTablet(context)) {
            return 101;
        }
        return 100;
    }

    public static String getDeviceUpdateMark() {
        return SystemMarkHelper.getInstance().getUpdateMark();
    }

    public static String getHardDisk() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return String.valueOf(statFs.getBlockSizeLong() * statFs.getBlockCountLong());
            }
            return "0";
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getPhysicalMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo(context);
        if (memoryInfo != null) {
            return String.valueOf(memoryInfo.totalMem);
        }
        return "";
    }

    public static String getTimeZone() {
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone != null) {
            return timeZone.getDisplayName(true, 0);
        }
        return "";
    }
}
