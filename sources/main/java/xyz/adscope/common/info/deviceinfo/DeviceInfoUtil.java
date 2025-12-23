package xyz.adscope.common.info.deviceinfo;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.DeviceInfoEnum;
import xyz.adscope.common.sp.CommonSpUtil;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.MD5Util;
import xyz.adscope.common.tool.thread.CommonThreadPool;
import xyz.adscope.common.v2.dev.info.SystemPropertiesUtil;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.DeviceID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.DeviceIdentifier;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DeviceInfoUtil {

    /* renamed from: a, reason: collision with root package name */
    private static String f56414a;

    /* renamed from: b, reason: collision with root package name */
    private static String f56415b;

    private static void c(final Context context) {
        try {
            new DevicesIDsHelper(new DevicesIDsHelper.AppIdsUpdater() { // from class: xyz.adscope.common.info.deviceinfo.DeviceInfoUtil.2
                @Override // xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper.AppIdsUpdater
                public void OnIdsValid(String str) {
                    try {
                        LogUtil.e("DeviceInfoUtil", "cn oaid:" + str);
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (TextUtils.isEmpty(DeviceInfoUtil.f56414a)) {
                            String unused = DeviceInfoUtil.f56414a = str;
                        }
                        CommonSpUtil.putString(context, CommonConstants.DEVICE_OAID_KEY, DeviceInfoUtil.f56414a);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).getOAID(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int dip2px(Context context, float f6) {
        if (context == null) {
            return 0;
        }
        try {
            return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    private static boolean e(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static int isDevelop(Context context) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 1) {
            return 1;
        }
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if ("tun0".equals(nextElement.getName()) || "ppp0".equals(nextElement.getName())) {
                return 1;
            }
        }
        return 0;
    }

    public static int px2dip(Context context, float f6) {
        if (context == null) {
            return 0;
        }
        try {
            return (int) ((f6 / context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static String getAndroidVersion() {
        try {
            return Build.VERSION.SDK_INT + "";
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return "";
        }
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getCarrier(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                String simOperator = telephonyManager.getSimOperator();
                if (simOperator == null) {
                    return DeviceInfoEnum.CARRIER_TYPE.CARRIER_UNKNOWN.getValue();
                }
                if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                    if (simOperator.equals("46001")) {
                        return DeviceInfoEnum.CARRIER_TYPE.CARRIER_CUCC.getValue();
                    }
                    if (simOperator.equals("46003")) {
                        return DeviceInfoEnum.CARRIER_TYPE.CARRIER_CTCC.getValue();
                    }
                }
                return DeviceInfoEnum.CARRIER_TYPE.CARRIER_CMCC.getValue();
            }
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
        return DeviceInfoEnum.CARRIER_TYPE.CARRIER_UNKNOWN.getValue();
    }

    public static int getConnectType(Context context) {
        try {
            if (context == null) {
                return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null) {
                return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_WIFI.getCode();
            }
            if (type != 0) {
                return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
            }
            int subtype = activeNetworkInfo.getSubtype();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    break;
                case 13:
                case 18:
                    break;
                case 19:
                default:
                    if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName)) {
                        break;
                    }
                    break;
                case 20:
                    break;
            }
            return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
        } catch (Throwable unused) {
            return DeviceInfoEnum.CONNECT_TYPE.CONNECT_TYPE_UNKNOWN.getCode();
        }
    }

    public static float getDensity(Context context) {
        if (context == null) {
            return 0.0f;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.density;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0.0f;
        }
    }

    public static String getDeviceBootMark() {
        return "";
    }

    public static String getDeviceUpdateMark() {
        try {
            return new DeviceInfoSystemMark().getDeviceUpdateMark();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getFileMark() {
        long j6;
        try {
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            j6 = Math.max(SysProp.getLong(SystemPropertiesUtil.PROP_UTC, -1L), Math.max(Environment.getRootDirectory().lastModified(), Build.TIME));
            return j6 + "";
        }
        j6 = 0;
        return j6 + "";
    }

    public static String getGaid(Context context) {
        try {
            if (!TextUtils.isEmpty(f56415b)) {
                return f56415b;
            }
            String string = CommonSpUtil.getString(context, CommonConstants.DEVICE_GAID_KEY);
            f56415b = string;
            return string;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getHmsCoreVersion(Context context) {
        return getVersionCode(context, "com.huawei.hwid");
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    @TargetApi(3)
    public static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return null;
        }
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOaid(Context context) {
        try {
            if (!TextUtils.isEmpty(f56414a)) {
                return f56414a;
            }
            String string = CommonSpUtil.getString(context, CommonConstants.DEVICE_OAID_KEY);
            f56414a = string;
            return string;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int getOs() {
        return DeviceInfoEnum.OS_TYPE.OS_ANDROID.getCode();
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static float getPPI(Context context) {
        if (context == null) {
            return 0.0f;
        }
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
            return r0.densityDpi;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0.0f;
        }
    }

    public static String getSdkId(Context context) {
        String str = (String) CommonSpUtil.get(context, CommonConstants.APP_SDK_ID, "");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String c6 = c();
        CommonSpUtil.put(context, CommonConstants.APP_SDK_ID, c6);
        return c6;
    }

    public static String getUserAgent(Context context) {
        return CommonSpUtil.getString(context, CommonConstants.USER_AGENT_KEY);
    }

    private static String a(Context context) {
        try {
            return context.getResources().getConfiguration().locale.getCountry();
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context) {
        try {
            DeviceID.getGAID(context, new IGetter() { // from class: xyz.adscope.common.info.deviceinfo.DeviceInfoUtil.3
                @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                public void onOAIDGetComplete(String str) {
                    try {
                        LogUtil.e("DeviceInfoUtil", "sm gaid:" + str);
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (TextUtils.isEmpty(DeviceInfoUtil.f56415b)) {
                            String unused = DeviceInfoUtil.f56415b = str;
                        }
                        CommonSpUtil.putString(context, CommonConstants.DEVICE_GAID_KEY, DeviceInfoUtil.f56415b);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                public void onOAIDGetError(Exception exc) {
                    LogUtil.e("DeviceInfoUtil", "sm gaid error:" + exc.getMessage());
                }
            });
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
    }

    private static void d(final Context context) {
        try {
            DeviceIdentifier.register((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()));
            if (DeviceID.supportedOAID(context)) {
                DeviceID.getOAID(context, new IGetter() { // from class: xyz.adscope.common.info.deviceinfo.DeviceInfoUtil.1
                    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                    public void onOAIDGetComplete(String str) {
                        LogUtil.e("DeviceInfoUtil", "sm oaid:" + str);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            if (TextUtils.isEmpty(DeviceInfoUtil.f56414a)) {
                                String unused = DeviceInfoUtil.f56414a = str;
                            }
                            CommonSpUtil.putString(context, CommonConstants.DEVICE_OAID_KEY, DeviceInfoUtil.f56414a);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                    public void onOAIDGetError(Exception exc) {
                    }
                });
            }
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Context context) {
        d(context);
        c(context);
    }

    public static String getCountry(Context context) {
        return a(context);
    }

    public static int getCountryCN(Context context) {
        String a6 = a(context);
        if (!TextUtils.isEmpty(a6)) {
            a6 = a6.toUpperCase();
        }
        DeviceInfoEnum.DEVICE_COUNTRY_TYPE device_country_type = DeviceInfoEnum.DEVICE_COUNTRY_TYPE.COUNTRY_CHINA_TYPE;
        if (device_country_type.getCountry().equals(a6)) {
            return device_country_type.getCode();
        }
        return DeviceInfoEnum.DEVICE_COUNTRY_TYPE.COUNTRY_OTHER_TYPE.getCode();
    }

    public static String getDeviceName(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), bi.J);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return "";
        }
    }

    public static int getDeviceType(Context context) {
        if (e(context)) {
            return DeviceInfoEnum.DEVICE_TYPE.TYPE_TABLET.getCode();
        }
        return DeviceInfoEnum.DEVICE_TYPE.TYPE_PHONE.getCode();
    }

    public static String getHardDisk() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize = statFs.getBlockSize();
                long blockCount = statFs.getBlockCount();
                statFs.getAvailableBlocks();
                return String.valueOf(blockSize * blockCount);
            }
            LogUtil.i("DeviceInfoUtil", "");
            return "0";
        } catch (Throwable th) {
            th.printStackTrace();
            return "0";
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getOrientation(Context context) {
        try {
            return context.getResources().getConfiguration().orientation;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static String getPhysicalMemory(Context context) {
        try {
            return String.valueOf(getMemoryInfo(context).totalMem);
        } catch (Throwable th) {
            th.printStackTrace();
            return "0";
        }
    }

    public static float getPxRatio(Context context) {
        return getDensity(context);
    }

    public static int getScreenHeight(Context context) {
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static int getScreenHeightDp(Context context) {
        try {
            return px2dip(context, context.getResources().getDisplayMetrics().heightPixels);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static int getScreenWidthDp(Context context) {
        try {
            float f6 = context.getResources().getDisplayMetrics().density;
            float f7 = context.getResources().getDisplayMetrics().widthPixels;
            if (f6 <= 0.0f) {
                f6 = 1.0f;
            }
            return (int) ((f7 / f6) + 0.5f);
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
            return 0;
        }
    }

    public static long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public static String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(true, 0);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getVersionCode(Context context, String str) {
        try {
            int i6 = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            if (i6 != 0) {
                return String.valueOf(i6);
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void initOaid(final Context context) {
        try {
            String oaid = getOaid(context);
            f56414a = oaid;
            if (TextUtils.isEmpty(oaid)) {
                d(context);
                c(context);
            } else {
                CommonThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.common.info.deviceinfo.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceInfoUtil.f(context);
                    }
                });
            }
            String gaid = getGaid(context);
            f56415b = gaid;
            if (TextUtils.isEmpty(gaid)) {
                b(context);
            } else {
                CommonThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.common.info.deviceinfo.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceInfoUtil.b(context);
                    }
                });
            }
        } catch (Throwable th) {
            LogUtil.e("DeviceInfoUtil", "e : " + th);
        }
    }

    private static String c() {
        try {
            StringBuilder sb = new StringBuilder();
            String brand = getBrand();
            String model = getModel();
            String hardDisk = getHardDisk();
            String osVersion = getOsVersion();
            String fileMark = getFileMark();
            String deviceUpdateMark = getDeviceUpdateMark();
            long currentTimeMillis = System.currentTimeMillis();
            sb.append(brand);
            sb.append(model);
            sb.append(hardDisk);
            sb.append(osVersion);
            sb.append(fileMark);
            sb.append(deviceUpdateMark);
            sb.append(currentTimeMillis);
            return MD5Util.md5(sb.toString());
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }
}
