package com.umeng.commonsdk.statistics.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.acse.ottn.j4;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.timepicker.TimeModel;
import com.kuaishou.weapon.p0.g;
import com.umeng.analytics.pro.y;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    protected static final String LOG_TAG = "com.umeng.commonsdk.statistics.common.DeviceConfig";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    private static volatile String sWifiMac = "";
    private static volatile String sImei = "";
    private static volatile String sMeid = "";
    private static volatile String sImsi = "";
    private static volatile String sSerialNo = "";
    private static volatile String sAndroidID = "";
    private static volatile String sIDFA = "";
    private static volatile String sOAID = "";
    private static volatile String sSecondImei = "";
    private static volatile String sSimSerialNumber = "";
    private static volatile boolean hasReadImeiOrMeid = false;
    private static volatile boolean hasReadSimSerialNumber = false;
    private static volatile boolean hasReadIMEI2 = false;
    private static volatile boolean hasReadSerialNo = false;
    private static volatile boolean hasReadAndroidID = false;
    private static volatile boolean hasReadMac = false;
    private static volatile boolean hasReadImsi = false;
    private static volatile boolean hasReadOAID = false;
    private static volatile boolean hasReadIDFA = false;
    private static volatile String sAppName = "";
    private static volatile String sAppPkgName = "";
    private static volatile boolean hasReadOperator = false;
    private static volatile String sOperator = "";
    private static volatile boolean hasReadOperatorName = false;
    private static volatile String sOperatorName = "";
    private static volatile String sCustomAgt = "";

    public static boolean checkPermission(Context context, String str) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
            }
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
        }
        return false;
    }

    public static String getCPU() {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                MLog.e(LOG_TAG, "Could not read from file /proc/cpuinfo", th);
            }
        } catch (FileNotFoundException e6) {
            MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", e6);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    activity = (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable unused) {
        }
        return activity;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context != null) {
            try {
                Locale locale = getLocale(context);
                if (locale != null) {
                    strArr[0] = locale.getCountry();
                    strArr[1] = locale.getLanguage();
                }
                if (TextUtils.isEmpty(strArr[0])) {
                    strArr[0] = "Unknown";
                }
                if (TextUtils.isEmpty(strArr[1])) {
                    strArr[1] = "Unknown";
                }
            } catch (Throwable th) {
                MLog.e(LOG_TAG, "error in getLocaleInfo", th);
                return strArr;
            }
        }
        return strArr;
    }

    @SuppressLint({"DefaultLocale"})
    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        if (getImsi(context) == null) {
            return null;
        }
        int i6 = context.getResources().getConfiguration().mcc;
        int i7 = context.getResources().getConfiguration().mnc;
        if (i6 != 0) {
            String valueOf = String.valueOf(i7);
            if (i7 < 10) {
                valueOf = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i7));
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i6));
            stringBuffer.append(valueOf);
            return stringBuffer.toString();
        }
        return null;
    }

    public static String getMeid(Context context) {
        String str = null;
        if (context == null || ((TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.ak)) {
            try {
                if (checkPermission(context, g.f36043c)) {
                    if (Build.VERSION.SDK_INT < 26) {
                        str = getIMEI(context);
                    } else {
                        str = meid(context);
                        if (TextUtils.isEmpty(str)) {
                            str = getIMEI(context);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context != null) {
            try {
                if (!checkPermission(context, g.f36042b)) {
                    strArr[0] = "";
                    return strArr;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = "";
                    return strArr;
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "Wi-Fi";
                    return strArr;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                }
            } catch (Throwable unused) {
            }
        }
        return strArr;
    }

    public static int[] getResolutionArray(Context context) {
        if (context == null) {
            return null;
        }
        int[] iArr = new int[2];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Method method = Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class);
                if (method != null) {
                    method.invoke(defaultDisplay, displayMetrics);
                    int i6 = displayMetrics.widthPixels;
                    int i7 = displayMetrics.heightPixels;
                    if (i6 > i7) {
                        iArr[0] = i7;
                        iArr[1] = i6;
                    } else {
                        iArr[0] = i6;
                        iArr[1] = i7;
                    }
                    iArr[0] = i6;
                    iArr[1] = i7;
                    return iArr;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String getSecondSimIMEi(Context context) {
        return null;
    }

    public static boolean isChineseAera(Context context) {
        String imprintProperty;
        if (context == null) {
            return false;
        }
        try {
            imprintProperty = UMEnvelopeBuild.imprintProperty(context, "country", "");
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(imprintProperty)) {
            return imprintProperty.equals("cn");
        }
        if (getImsi(context) != null) {
            int i6 = context.getResources().getConfiguration().mcc;
            if (i6 != 460 && i6 != 461) {
                if (i6 == 0) {
                    String str = getLocaleInfo(context)[0];
                    if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("cn")) {
                    }
                }
            }
            return true;
        }
        String str2 = getLocaleInfo(context)[0];
        if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("cn")) {
            return true;
        }
        return false;
    }

    private static boolean isEmui(Properties properties) {
        return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, g.f36042b) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    private static String reaMac(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            FileReader fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                str2 = bufferedReader.readLine();
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                bufferedReader.close();
            } catch (Throwable th2) {
                th = th2;
                try {
                    fileReader.close();
                } catch (Throwable unused2) {
                }
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (Throwable unused3) {
                    throw th;
                }
            }
        } catch (Throwable unused4) {
        }
        return str2;
    }

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i6 = 0; i6 < bArr.length; i6++) {
            String hexString = Integer.toHexString(bArr[i6]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i6 < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo a6 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (a6 == null) {
                return null;
            }
            return byte2HexFormatted(MessageDigest.getInstance(by.f10823a).digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(a6.signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppName(Context context) {
        if (!TextUtils.isEmpty(sAppName)) {
            return sAppName;
        }
        if (context == null) {
            return null;
        }
        try {
            PackageInfo a6 = com.umeng.commonsdk.utils.b.a().a(context, context.getPackageName(), 64);
            if (a6 != null) {
                sAppName = a6.applicationInfo.loadLabel(context.getPackageManager()).toString();
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, th);
            }
        }
        return sAppName;
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    private static Properties getBuildProp() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    return properties;
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return properties;
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
        }
    }

    public static String getCustomAgt() {
        if (!TextUtils.isEmpty(sCustomAgt)) {
            return sCustomAgt;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dalvik/");
        sb.append(System.getProperty("java.vm.version"));
        sb.append(" (Linux; U; Android ");
        sb.append(")");
        sCustomAgt = sb.toString();
        return sCustomAgt;
    }

    public static String getDeviceIdForBox(Context context) {
        int i6;
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            i6 = Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
        }
        if (i6 < 23) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i)) {
                str = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + str);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String macBySystemInterface = getMacBySystemInterface(context);
            deviceTypeEnum = DeviceTypeEnum.MAC;
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface);
            }
            if (!TextUtils.isEmpty(macBySystemInterface)) {
                return macBySystemInterface;
            }
            String serialNo = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (!TextUtils.isEmpty(serialNo)) {
                return serialNo;
            }
            String imei = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            return imei;
        }
        if (i6 == 23) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i)) {
                str = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + str);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String macByJavaAPI = getMacByJavaAPI();
            DeviceTypeEnum deviceTypeEnum2 = DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum2;
            if (TextUtils.isEmpty(macByJavaAPI)) {
                if (AnalyticsConstants.CHECK_DEVICE) {
                    macByJavaAPI = getMacShell();
                    deviceTypeEnum = deviceTypeEnum2;
                } else {
                    macByJavaAPI = getMacBySystemInterface(context);
                    deviceTypeEnum = deviceTypeEnum2;
                }
            }
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
            }
            if (!TextUtils.isEmpty(macByJavaAPI)) {
                return macByJavaAPI;
            }
            String serialNo2 = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (!TextUtils.isEmpty(serialNo2)) {
                return serialNo2;
            }
            String imei2 = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            return imei2;
        }
        if (i6 >= 29) {
            String oaid = getOaid(context);
            deviceTypeEnum = DeviceTypeEnum.OAID;
            if (!TextUtils.isEmpty(oaid)) {
                return oaid;
            }
            String idfa = getIdfa(context);
            deviceTypeEnum = DeviceTypeEnum.IDFA;
            if (!TextUtils.isEmpty(idfa)) {
                return idfa;
            }
            String androidId = getAndroidId(context);
            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
            if (!TextUtils.isEmpty(androidId)) {
                return androidId;
            }
            String serialNo3 = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (!TextUtils.isEmpty(serialNo3)) {
                return serialNo3;
            }
            String macByJavaAPI2 = getMacByJavaAPI();
            DeviceTypeEnum deviceTypeEnum3 = DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum3;
            if (!TextUtils.isEmpty(macByJavaAPI2)) {
                return macByJavaAPI2;
            }
            String macBySystemInterface2 = getMacBySystemInterface(context);
            deviceTypeEnum = deviceTypeEnum3;
            return macBySystemInterface2;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i)) {
            str = getAndroidId(context);
            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, "getDeviceId: ANDROID_ID: " + str);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (TextUtils.isEmpty(str)) {
                str = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (TextUtils.isEmpty(str)) {
                    str = getMacByJavaAPI();
                    DeviceTypeEnum deviceTypeEnum4 = DeviceTypeEnum.MAC;
                    deviceTypeEnum = deviceTypeEnum4;
                    if (TextUtils.isEmpty(str)) {
                        str = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum4;
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId, MAC: " + str);
                        }
                    }
                }
            }
        }
        return str;
    }

    public static String getDeviceIdForGeneral(Context context) {
        int i6;
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            i6 = Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
        }
        if (i6 < 23) {
            String imei = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            if (!TextUtils.isEmpty(imei)) {
                return imei;
            }
            boolean z5 = AnalyticsConstants.UM_DEBUG;
            if (z5) {
                MLog.w(LOG_TAG, "No IMEI.");
            }
            String macBySystemInterface = getMacBySystemInterface(context);
            deviceTypeEnum = DeviceTypeEnum.MAC;
            if (!TextUtils.isEmpty(macBySystemInterface)) {
                return macBySystemInterface;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i)) {
                macBySystemInterface = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (z5) {
                    MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macBySystemInterface);
                }
            }
            if (!TextUtils.isEmpty(macBySystemInterface)) {
                return macBySystemInterface;
            }
            String serialNo = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            return serialNo;
        }
        if (i6 == 23) {
            String imei2 = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            if (!TextUtils.isEmpty(imei2)) {
                return imei2;
            }
            String macByJavaAPI = getMacByJavaAPI();
            DeviceTypeEnum deviceTypeEnum2 = DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum2;
            if (TextUtils.isEmpty(macByJavaAPI)) {
                if (AnalyticsConstants.CHECK_DEVICE) {
                    macByJavaAPI = getMacShell();
                    deviceTypeEnum = deviceTypeEnum2;
                } else {
                    macByJavaAPI = getMacBySystemInterface(context);
                    deviceTypeEnum = deviceTypeEnum2;
                }
            }
            boolean z6 = AnalyticsConstants.UM_DEBUG;
            if (z6) {
                MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
            }
            if (!TextUtils.isEmpty(macByJavaAPI)) {
                return macByJavaAPI;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i)) {
                macByJavaAPI = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (z6) {
                    MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macByJavaAPI);
                }
            }
            if (!TextUtils.isEmpty(macByJavaAPI)) {
                return macByJavaAPI;
            }
            String serialNo2 = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            return serialNo2;
        }
        if (i6 >= 29) {
            String oaid = getOaid(context);
            deviceTypeEnum = DeviceTypeEnum.OAID;
            if (!TextUtils.isEmpty(oaid)) {
                return oaid;
            }
            String idfa = getIdfa(context);
            deviceTypeEnum = DeviceTypeEnum.IDFA;
            if (!TextUtils.isEmpty(idfa)) {
                return idfa;
            }
            String androidId = getAndroidId(context);
            deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
            if (!TextUtils.isEmpty(androidId)) {
                return androidId;
            }
            String serialNo3 = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (!TextUtils.isEmpty(serialNo3)) {
                return serialNo3;
            }
            String macByJavaAPI2 = getMacByJavaAPI();
            DeviceTypeEnum deviceTypeEnum3 = DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum3;
            if (!TextUtils.isEmpty(macByJavaAPI2)) {
                return macByJavaAPI2;
            }
            String macBySystemInterface2 = getMacBySystemInterface(context);
            deviceTypeEnum = deviceTypeEnum3;
            return macBySystemInterface2;
        }
        str = getIMEI(context);
        deviceTypeEnum = DeviceTypeEnum.IMEI;
        if (TextUtils.isEmpty(str)) {
            str = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (TextUtils.isEmpty(str)) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = getMacByJavaAPI();
                    DeviceTypeEnum deviceTypeEnum4 = DeviceTypeEnum.MAC;
                    deviceTypeEnum = deviceTypeEnum4;
                    if (TextUtils.isEmpty(str)) {
                        str = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum4;
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId, MAC: " + str);
                        }
                    }
                }
            }
        }
        return str;
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceType(Context context) {
        if (context != null) {
            try {
                if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                    return "Tablet";
                }
            } catch (Throwable unused) {
            }
        }
        return "Phone";
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i6 = displayMetrics.widthPixels;
                return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i6);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    private static String getIMEI(Context context) {
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = "";
        if (hasReadImeiOrMeid) {
            return "";
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42118g)) {
            if (context == null) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    if (checkPermission(context, g.f36043c)) {
                        str = telephonyManager.getDeviceId();
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.i(LOG_TAG, "getDeviceId, IMEI: " + str);
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
        sImei = str;
        return sImei;
    }

    public static String getIdfa(Context context) {
        if (!TextUtils.isEmpty(sIDFA)) {
            return sIDFA;
        }
        if (hasReadIDFA) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42134w)) {
                sIDFA = a.a(context);
            }
        } catch (Throwable unused) {
        }
        hasReadIDFA = true;
        return sIDFA;
    }

    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        if (hasReadImeiOrMeid) {
            return null;
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42118g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, g.f36043c)) {
                str = telephonyManager.getDeviceId();
            }
        } finally {
            try {
                sImei = str;
                return str;
            } finally {
            }
        }
        sImei = str;
        return str;
    }

    public static String getImeiNew(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        if (hasReadImeiOrMeid) {
            return null;
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42118g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, g.f36043c)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Method method = telephonyManager.getClass().getMethod("getImei", null);
                        method.setAccessible(true);
                        str = (String) method.invoke(telephonyManager, null);
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = telephonyManager.getDeviceId();
                    }
                } else {
                    str = telephonyManager.getDeviceId();
                }
            }
        } finally {
            try {
                sImei = str;
                return str;
            } finally {
            }
        }
        sImei = str;
        return str;
    }

    public static String getImsi(Context context) {
        if (!TextUtils.isEmpty(sImsi)) {
            return sImsi;
        }
        String str = null;
        if (hasReadImsi || context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.aj)) {
            try {
                if (checkPermission(context, g.f36043c) && telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Throwable unused) {
            }
            hasReadImsi = true;
        }
        sImsi = str;
        return sImsi;
    }

    private static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable unused) {
            MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String getMac(Context context) {
        String str = "";
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42119h) && context != null) {
            try {
                int i6 = Build.VERSION.SDK_INT;
                if (i6 < 23) {
                    return getMacBySystemInterface(context);
                }
                if (i6 == 23) {
                    String macByJavaAPI = getMacByJavaAPI();
                    return TextUtils.isEmpty(macByJavaAPI) ? AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context) : macByJavaAPI;
                }
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    return getMacBySystemInterface(context);
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    @TargetApi(9)
    private static String getMacByJavaAPI() {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42119h)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if ("wlan0".equals(nextElement.getName()) || "eth0".equals(nextElement.getName())) {
                        byte[] hardwareAddress = nextElement.getHardwareAddress();
                        if (hardwareAddress == null || hardwareAddress.length == 0) {
                            sWifiMac = "";
                        }
                        StringBuilder sb = new StringBuilder();
                        for (byte b6 : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b6)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        sWifiMac = sb.toString().toLowerCase(Locale.getDefault());
                    }
                }
            }
        } catch (Throwable unused) {
        }
        hasReadMac = true;
        return sWifiMac;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String getMacBySystemInterface(Context context) {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac || context == null) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42119h)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (!checkPermission(context, g.f36044d)) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                    }
                    sWifiMac = "";
                } else if (wifiManager != null) {
                    sWifiMac = wifiManager.getConnectionInfo().getMacAddress();
                } else {
                    sWifiMac = "";
                }
            }
        } finally {
            try {
                return sWifiMac;
            } finally {
            }
        }
        return sWifiMac;
    }

    private static String getMacShell() {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42119h)) {
                String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
                for (int i6 = 0; i6 < 3; i6++) {
                    try {
                        String reaMac = reaMac(strArr[i6]);
                        if (reaMac != null) {
                            sWifiMac = reaMac;
                        }
                    } catch (Throwable th) {
                        if (AnalyticsConstants.UM_DEBUG) {
                            MLog.e(LOG_TAG, "open file  Failed", th);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        hasReadMac = true;
        return sWifiMac;
    }

    public static String getNetworkOperatorName(Context context) {
        if (!TextUtils.isEmpty(sOperatorName)) {
            return sOperatorName;
        }
        if (hasReadOperatorName || context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, g.f36043c) && telephonyManager != null) {
                sOperatorName = telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        hasReadOperatorName = true;
        return sOperatorName;
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, g.f36043c)) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return -100;
        }
    }

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (hasReadOAID) {
            return "";
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(h.f41959a, 0);
                if (sharedPreferences != null) {
                    sOAID = sharedPreferences.getString(h.f41960b, "");
                }
            } catch (Throwable unused) {
            }
            hasReadOAID = true;
        }
        return sOAID;
    }

    public static String getPackageName(Context context) {
        if (!TextUtils.isEmpty(sAppPkgName)) {
            return sAppPkgName;
        }
        if (context == null) {
            return null;
        }
        sAppPkgName = context.getPackageName();
        return sAppPkgName;
    }

    public static String getRegisteredOperator(Context context) {
        if (!TextUtils.isEmpty(sOperator)) {
            return sOperator;
        }
        if (hasReadOperator || context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, g.f36043c) && telephonyManager != null) {
                sOperator = telephonyManager.getNetworkOperator();
            }
        } catch (Throwable unused) {
        }
        hasReadOperator = true;
        return sOperator;
    }

    @TargetApi(9)
    private static String getSerialNo() {
        return "";
    }

    public static String getSimICCID(Context context) {
        if (!TextUtils.isEmpty(sSimSerialNumber)) {
            return sSimSerialNumber;
        }
        if (hasReadSimSerialNumber) {
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.an)) {
            if (context != null) {
                try {
                    if (UMUtils.checkPermission(context, g.f36043c)) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager == null) {
                            hasReadSimSerialNumber = true;
                            return null;
                        }
                        sSimSerialNumber = telephonyManager.getSimSerialNumber();
                    }
                } catch (Throwable unused) {
                }
            }
            hasReadSimSerialNumber = true;
        }
        return sSimSerialNumber;
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar calendar = Calendar.getInstance(getLocale(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasOpsPermission(Context context) {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.at)) {
            return false;
        }
        try {
            return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), getPackageName(context)) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasRequestPermission(Context context, String str) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.at)) {
            try {
                for (String str2 : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                    if (str2.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", null);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isSystemApp(Context context) {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.as)) {
            return false;
        }
        try {
            PackageInfo a6 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 1048576);
            if (a6 != null) {
                return (a6.applicationInfo.flags & 1) != 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String meid(Context context) {
        if (!TextUtils.isEmpty(sMeid)) {
            return sMeid;
        }
        String str = null;
        if (hasReadImeiOrMeid || context == null) {
            return null;
        }
        try {
            Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", null).invoke(null, null);
            if (invoke != null && (invoke instanceof String)) {
                str = (String) invoke;
            }
        } finally {
            try {
                sMeid = str;
                return sMeid;
            } finally {
            }
        }
        sMeid = str;
        return sMeid;
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getAndroidId(Context context) {
        if (!UMConfigure.shouldCollectAid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "disallow read aid.");
            return null;
        }
        if (!TextUtils.isEmpty(sAndroidID)) {
            return sAndroidID;
        }
        if (hasReadAndroidID) {
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42120i) && context != null) {
            try {
                try {
                    sAndroidID = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                } catch (Throwable unused) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.w("can't read android id");
                    }
                }
            } finally {
                hasReadAndroidID = true;
            }
        }
        return sAndroidID;
    }

    public static String getAppHashKey(Context context) {
        try {
            PackageInfo a6 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (a6 != null) {
                Signature[] signatureArr = a6.signatures;
                if (signatureArr.length > 0) {
                    Signature signature = signatureArr[0];
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(signature.toByteArray());
                    return Base64.encodeToString(messageDigest.digest(), 0).trim();
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppSHA1Key(Context context) {
        try {
            PackageInfo a6 = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (a6 != null) {
                return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(a6.signatures[0].toByteArray()))).getEncoded()));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static String getDeviceId(Context context) {
        if (AnalyticsConstants.getDeviceType() == 2) {
            return getDeviceIdForBox(context);
        }
        return getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getSerial() {
        return getSerialNo();
    }

    public static String getSid(Context context) {
        return y.a().d(context);
    }

    public static String getSubOSName(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (TextUtils.isEmpty(property)) {
                if (isFlyMe()) {
                    return "Flyme";
                }
                if (isEmui(buildProp)) {
                    return "Emui";
                }
                if (!TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                    return "YunOS";
                }
                return property;
            }
            return "MIUI";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (TextUtils.isEmpty(property)) {
                try {
                    if (isFlyMe()) {
                        property = getFlymeVersion(buildProp);
                    } else if (isEmui(buildProp)) {
                        property = getEmuiVersion(buildProp);
                    } else {
                        property = getYunOSVersion(buildProp);
                    }
                    return property;
                } catch (Throwable unused) {
                    return property;
                }
            }
            return property;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", ResIdentify.RES_TYPE_STRING, FaceEnvironment.OS)).equals(j4.f4664a);
        } catch (Throwable unused) {
            return false;
        }
    }
}
