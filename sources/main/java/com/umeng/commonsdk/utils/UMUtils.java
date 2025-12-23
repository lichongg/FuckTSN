package com.umeng.commonsdk.utils;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.acse.ottn.l3;
import com.baidu.mobads.sdk.internal.by;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_APP_KEY = "appkey";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LAST_APP_KEY = "last_appkey";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_SESSION_ID = "session_id";
    public static final String MOBILE_NETWORK = "2G/3G";
    private static final String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static final String KEY_SHARED_PREFERENCES_NAME = au.b().b(au.f40904i);
    private static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");
    private static final String SP_FILE_NAME = au.b().b(au.f40906k);
    private static Object spLock = new Object();
    public static String VALUE_ANALYTICS_VERSION = "";
    public static String VALUE_GAME_VERSION = "";
    public static String VALUE_PUSH_VERSION = "";
    public static String VALUE_SHARE_VERSION = "";
    public static String VALUE_APM_VERSION = "";
    public static String VALUE_VERIFY_VERSION = "";
    public static String VALUE_SMS_VERSION = "";
    public static String VALUE_REC_VERSION_NAME = "";
    public static String VALUE_VISUAL_VERSION = "";
    public static String VALUE_ASMS_VERSION = "";
    public static String VALUE_LINK_VERSION = "";
    public static String VALUE_ABTEST_VERSION = "";
    public static String VALUE_ANTI_VERSION = "";
    private static volatile String sAppVersionName = "";
    private static volatile String sAppVersionCode = "";

    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            try {
                try {
                    byte[] bytes = str.getBytes();
                    MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                    messageDigest.reset();
                    messageDigest.update(bytes);
                    byte[] digest = messageDigest.digest();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b6 : digest) {
                        stringBuffer.append(String.format("%02X", Byte.valueOf(b6)));
                    }
                    return stringBuffer.toString();
                } catch (Throwable th) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        th.toString();
                    }
                    return null;
                }
            } catch (Exception e6) {
                if (AnalyticsConstants.UM_DEBUG) {
                    e6.toString();
                }
                return null;
            }
        } catch (Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getActivityInfo(new ComponentName(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT + str + ":"));
            List<ResolveInfo> queryIntentActivities = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities.size() > 0) {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        }
        try {
            return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Exception e6) {
            UMCrashManager.reportCrash(context, e6);
            return false;
        }
    }

    public static boolean checkResource(Context context, String str, String str2) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier(str, str2, StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String encryptBySHA1(String str) {
        try {
            try {
                byte[] bytes = str.getBytes();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    messageDigest.update(bytes);
                    return bytes2Hex(messageDigest.digest());
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception e6) {
                if (AnalyticsConstants.UM_DEBUG) {
                    e6.toString();
                }
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            return null;
        }
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(sAppVersionName)) {
            return sAppVersionName;
        }
        if (context != null) {
            try {
                PackageInfo a6 = b.a().a(context, context.getPackageName(), 64);
                if (a6 != null) {
                    String str = a6.versionName;
                    sAppVersionName = str;
                    return str;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
                return "";
            }
        }
        return "";
    }

    public static String getAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !TextUtils.isEmpty(UMConfigure.sAppkey) ? UMConfigure.sAppkey : getMultiProcessSP(context, "appkey");
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !TextUtils.isEmpty(UMConfigure.sChannel) ? UMConfigure.sChannel : getMultiProcessSP(context, "channel");
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getDeviceToken(Context context) {
        Object invoke;
        Method method;
        Object invoke2;
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                Class<?> cls = Class.forName("com.umeng.message.PushAgent");
                Method method2 = cls.getMethod("getInstance", Context.class);
                if (method2 != null && (invoke = method2.invoke(cls, origApplicationContext)) != null && (method = cls.getMethod("getRegistrationId", null)) != null && (invoke2 = method.invoke(invoke, null)) != null && (invoke2 instanceof String)) {
                    return (String) invoke2;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String getLastAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, KEY_LAST_APP_KEY);
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static Locale getLocale(Context context) {
        Locale locale;
        try {
            if (context == null) {
                return null;
            }
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Exception e6) {
                try {
                    if (AnalyticsConstants.UM_DEBUG) {
                        e6.toString();
                    }
                    locale = null;
                } catch (Exception e7) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        e7.toString();
                    }
                    UMCrashManager.reportCrash(context, e7);
                    return null;
                }
            }
            return locale == null ? Locale.getDefault() : locale;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getMac(Context context) {
        if (context == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            if (checkPermission(context, g.f36044d)) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            boolean z5 = AnalyticsConstants.UM_DEBUG;
            return "";
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private static byte[] getMiniArray() {
        return new byte[]{1, 6, 8, 12, 13};
    }

    public static String getMultiProcessSP(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            if (isMainProgress(context)) {
                                sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                            } else {
                                String subProcessName = UMFrUtils.getSubProcessName(context);
                                sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(subProcessName + "_" + KEY_SHARED_PREFERENCES_NAME, 0);
                            }
                            if (sharedPreferences == null) {
                                return null;
                            }
                            return sharedPreferences.getString(str, null);
                        }
                    } finally {
                    }
                }
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
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
                    return strArr;
                }
            } catch (Exception e6) {
                if (AnalyticsConstants.UM_DEBUG) {
                    e6.toString();
                }
                UMCrashManager.reportCrash(context, e6);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
        return strArr;
    }

    public static String getSubOSName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
                    return TextUtils.isEmpty(property) ? isFlyMe() ? "Flyme" : !TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property : "MIUI";
                } catch (Exception e6) {
                    UMCrashManager.reportCrash(context, e6);
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
                UMCrashManager.reportCrash(context, th);
                return null;
            }
        } catch (Exception e7) {
            if (AnalyticsConstants.UM_DEBUG) {
                e7.toString();
            }
            UMCrashManager.reportCrash(context, e7);
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
                    if (TextUtils.isEmpty(property)) {
                        try {
                            return isFlyMe() ? getFlymeVersion(buildProp) : getYunOSVersion(buildProp);
                        } catch (Exception unused) {
                        }
                    }
                    return property;
                } catch (Exception e6) {
                    UMCrashManager.reportCrash(context, e6);
                    return null;
                }
            } catch (Exception e7) {
                if (AnalyticsConstants.UM_DEBUG) {
                    e7.toString();
                }
                UMCrashManager.reportCrash(context, e7);
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getUMId(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(StubApp.getOrigApplicationContext(context.getApplicationContext()), "umid", null);
            } catch (Exception e6) {
                UMCrashManager.reportCrash(context, e6);
            }
        }
        return null;
    }

    public static String getUmengToken(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ztoken", null);
            } catch (Exception e6) {
                UMCrashManager.reportCrash(context, e6);
            }
        }
        return null;
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        return b.a().a(context, str, 0) != null;
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e6) {
            UMCrashManager.reportCrash(context, e6);
            return false;
        }
    }

    private static String parseId(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @SuppressLint({"DefaultLocale"})
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
            sb.append(hexString.toUpperCase());
            if (i6 < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    private static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static String genId() {
        return "1234567890";
    }

    public static String getApmFlag() {
        Method declaredMethod;
        try {
            Class<?> cls = getClass("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getUMAPMFlag", null)) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, null);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppMD5Signature(Context context) {
        String str = "";
        try {
            String appMD5Signature = DeviceConfig.getAppMD5Signature(context);
            try {
                if (TextUtils.isEmpty(appMD5Signature)) {
                    return appMD5Signature;
                }
                str = appMD5Signature.replace(":", "");
                return str.toLowerCase();
            } catch (Throwable unused) {
                return appMD5Signature;
            }
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static String getAppVersinoCode(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageInfo a6 = b.a().a(context, str, 64);
                if (a6 != null) {
                    return String.valueOf(a6.versionCode);
                }
            } catch (Exception e6) {
                if (AnalyticsConstants.UM_DEBUG) {
                    e6.toString();
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
            }
        }
        return "";
    }

    public static String getAppVersionCode(Context context) {
        if (!TextUtils.isEmpty(sAppVersionCode)) {
            return sAppVersionCode;
        }
        if (context != null) {
            try {
                PackageInfo a6 = b.a().a(context, context.getPackageName(), 64);
                if (a6 != null) {
                    String valueOf = String.valueOf(a6.versionCode);
                    sAppVersionCode = valueOf;
                    return valueOf;
                }
            } catch (Exception e6) {
                if (AnalyticsConstants.UM_DEBUG) {
                    e6.toString();
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
                return "";
            }
        }
        return "";
    }

    public static Properties getBuildProp() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    return properties;
                } catch (IOException unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return properties;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused4) {
            return properties;
        }
    }

    public static String getCPU() {
        String str = null;
        try {
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e6) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        e6.toString();
                    }
                }
            } catch (Exception e7) {
                if (AnalyticsConstants.UM_DEBUG) {
                    e7.toString();
                }
                return "";
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
                return "";
            }
        } catch (FileNotFoundException e8) {
            if (AnalyticsConstants.UM_DEBUG) {
                e8.toString();
            }
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i6 = displayMetrics.widthPixels;
            return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i6);
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getFileMD5(File file) {
        try {
            try {
                byte[] bArr = new byte[1024];
                try {
                    if (!file.isFile()) {
                        return "";
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            fileInputStream.close();
                            return String.format("%1$032x", new BigInteger(1, messageDigest.digest()));
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Exception unused) {
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
                return null;
            }
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            return new String[0];
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            return new String[0];
        }
    }

    public static String getOaidRequiredTime(Context context) {
        if (!FieldManager.allow(d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(h.f41959a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(h.f41961c, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(l3.f4736f, String.class, String.class).invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
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

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    private static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        if (UMConfigure.isDebugLog()) {
            UMLog.mutlInfo(2, "统计SDK版本号: 9.6.5");
        }
        VALUE_ANALYTICS_VERSION = "9.6.5";
        String b6 = com.umeng.commonsdk.internal.c.b();
        if (!TextUtils.isEmpty(b6)) {
            VALUE_ASMS_VERSION = b6;
            if (UMConfigure.isDebugLog()) {
                UMLog.mutlInfo(2, "ZID SDK版本号: " + b6);
            }
        }
        Class<?> cls = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls != null) {
            stringBuffer.append("g");
            try {
                String str = (String) cls.getDeclaredField("SDK_VERSION").get(cls);
                if (!TextUtils.isEmpty(str)) {
                    VALUE_GAME_VERSION = str;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "游戏统计SDK版本号: " + str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Class<?> cls2 = getClass("com.umeng.vt.V");
        if (cls2 != null) {
            stringBuffer.append("v");
            try {
                String str2 = (String) cls2.getDeclaredField(Field.VERSION).get(cls2);
                if (!TextUtils.isEmpty(str2)) {
                    VALUE_VISUAL_VERSION = str2;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "可视化埋点SDK版本号: " + str2);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append("p");
            Class<?> cls3 = getClass("com.umeng.message.MsgConstant");
            if (cls3 != null) {
                try {
                    String str3 = (String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!TextUtils.isEmpty(str3)) {
                        VALUE_PUSH_VERSION = str3;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "推送SDK版本号: " + str3);
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
        if (cls4 != null) {
            stringBuffer.append("s");
            Class<?> cls5 = getClass("com.umeng.a");
            if (cls5 != null) {
                try {
                    String str4 = (String) cls5.getDeclaredField("g").get(cls5);
                    if (!TextUtils.isEmpty(str4)) {
                        VALUE_SHARE_VERSION = str4;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "分享SDK版本号: " + str4);
                        }
                    }
                } catch (Throwable unused4) {
                }
            }
            if (TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                try {
                    Method declaredMethod = cls4.getDeclaredMethod("getSdkVersion", null);
                    declaredMethod.setAccessible(true);
                    VALUE_SHARE_VERSION = (String) declaredMethod.invoke(cls4, null);
                } catch (Throwable unused5) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.ZIDManager") != null) {
            stringBuffer.append(bi.aG);
        }
        stringBuffer.append("i");
        if (SdkVersion.SDK_TYPE != 1 && getClass("com.umeng.commonsdk.internal.UMOplus") != null) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append("u");
            Class<?> cls6 = getClass("com.umeng.airec.BuildConfig");
            if (cls6 != null) {
                try {
                    String str5 = (String) cls6.getDeclaredField("VERSION_NAME").get(cls6);
                    if (!TextUtils.isEmpty(str5)) {
                        VALUE_REC_VERSION_NAME = str5;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "智能推荐SDK版本号: " + str5);
                        }
                    }
                } catch (Throwable unused6) {
                }
            }
        }
        if (getClass("com.umeng.umverify.UMVerifyHelper") != null) {
            stringBuffer.append("n");
        }
        Class<?> cls7 = getClass("com.umeng.sms.UMSMS");
        if (cls7 != null) {
            stringBuffer.append(t.f36152m);
            try {
                Method declaredMethod2 = cls7.getDeclaredMethod("getVersion", null);
                if (declaredMethod2 != null) {
                    String str6 = (String) declaredMethod2.invoke(cls7, null);
                    if (!TextUtils.isEmpty(str6)) {
                        VALUE_SMS_VERSION = str6;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "短信验证码SDK版本号: " + str6);
                        }
                    }
                }
            } catch (Throwable unused7) {
            }
        }
        try {
            Class<?> cls8 = getClass("com.umeng.umcrash.UMCrash");
            if (cls8 != null) {
                stringBuffer.append("c");
                java.lang.reflect.Field declaredField = cls8.getDeclaredField("crashSdkVersion");
                declaredField.setAccessible(true);
                String str7 = (String) declaredField.get(cls8);
                if (!TextUtils.isEmpty(str7)) {
                    VALUE_APM_VERSION = str7;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "APM SDK版本号: " + str7);
                    }
                }
            }
        } catch (Throwable unused8) {
        }
        Class<?> cls9 = getClass("com.umeng.umlink.MobclickLink");
        if (cls9 != null) {
            stringBuffer.append(t.f36143d);
            try {
                Method declaredMethod3 = cls9.getDeclaredMethod("getVersion", null);
                if (declaredMethod3 != null) {
                    String str8 = (String) declaredMethod3.invoke(cls9, null);
                    if (!TextUtils.isEmpty(str8)) {
                        VALUE_LINK_VERSION = str8;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ULink SDK版本号: " + str8);
                        }
                    }
                }
            } catch (Throwable unused9) {
            }
        }
        Class<?> cls10 = getClass("com.umeng.cconfig.UMRemoteConfig");
        if (cls10 != null) {
            try {
                Method declaredMethod4 = cls10.getDeclaredMethod("getVersion", null);
                if (declaredMethod4 != null) {
                    stringBuffer.append(bi.aL);
                    String str9 = (String) declaredMethod4.invoke(cls10, null);
                    if (!TextUtils.isEmpty(str9)) {
                        VALUE_ABTEST_VERSION = str9;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "UABTEST SDK版本号: " + str9);
                        }
                    }
                }
            } catch (Throwable unused10) {
            }
        }
        Class<?> cls11 = getClass("com.uyumao.sdk.UYMManager");
        if (cls11 != null) {
            try {
                Method declaredMethod5 = cls11.getDeclaredMethod("getSdkVersion", null);
                if (declaredMethod5 != null) {
                    stringBuffer.append(t.f36150k);
                    String str10 = (String) declaredMethod5.invoke(cls11, null);
                    if (!TextUtils.isEmpty(str10)) {
                        VALUE_ANTI_VERSION = str10;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ANTI SDK版本号: " + str10);
                        }
                    }
                }
            } catch (Throwable unused11) {
            }
        }
        if (TextUtils.isEmpty(stringBuffer)) {
            return;
        }
        com.umeng.commonsdk.statistics.b.f41874a = stringBuffer.toString();
        String str11 = com.umeng.commonsdk.statistics.b.f41874a;
    }

    public static void setAppkey(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "appkey", str);
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setChannel(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "channel", str);
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setLastAppkey(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, KEY_LAST_APP_KEY, str);
        } catch (Exception e6) {
            if (AnalyticsConstants.UM_DEBUG) {
                e6.toString();
            }
            UMCrashManager.reportCrash(context, e6);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                th.toString();
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setMultiProcessSP(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    try {
                        if (!TextUtils.isEmpty(str) && str2 != null) {
                            if (isMainProgress(context)) {
                                sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                            } else {
                                String subProcessName = UMFrUtils.getSubProcessName(context);
                                sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(subProcessName + "_" + KEY_SHARED_PREFERENCES_NAME, 0);
                            }
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().putString(str, str2).commit();
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getApplicationInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData.get(str) != null) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static byte[] genIv() {
        byte[] miniArray = getMiniArray();
        return new byte[]{10, 1, (byte) (10 + 1), 5, 4, (byte) (10 + 5), 7, 9, 23, 3, miniArray[0], miniArray[1], miniArray[2], miniArray[3], miniArray[4], (byte) (100 - 9)};
    }

    public static String[] getActiveUser(Context context) {
        return com.umeng.analytics.c.a(context);
    }

    public static String getAppHashKey(Context context) {
        return DeviceConfig.getAppHashKey(context);
    }

    public static String getAppName(Context context) {
        return DeviceConfig.getAppName(context);
    }

    public static String getAppSHA1Key(Context context) {
        return DeviceConfig.getAppSHA1Key(context);
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("UMENG_CHANNEL")) != null) {
                String obj2 = obj.toString();
                if (obj2 != null) {
                    return obj2.trim();
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getNetworkOperatorName(Context context) {
        return DeviceConfig.getNetworkOperatorName(context);
    }

    public static String getOperator(Context context) {
        String registeredOperator = DeviceConfig.getRegisteredOperator(context);
        if (TextUtils.isEmpty(registeredOperator)) {
            return "Unknown";
        }
        return registeredOperator;
    }

    public static String getRegisteredOperator(Context context) {
        return DeviceConfig.getRegisteredOperator(context);
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getUUIDForZid(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(SP_FILE_NAME, 0);
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString("session_id", "");
    }

    public static String getZid(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (!UMConfigure.needSendZcfgEnv(origApplicationContext)) {
            return com.umeng.commonsdk.internal.b.a(origApplicationContext).a().a();
        }
        return null;
    }

    public static boolean isApplication(Context context) {
        try {
            String name = StubApp.getOrigApplicationContext(context.getApplicationContext()).getClass().getSuperclass().getName();
            if (!TextUtils.isEmpty(name)) {
                if (name.equals("android.app.Application")) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMainProgress(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName)) {
                if (currentProcessName.equals(packageName)) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdCardWrittenable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setUUIDForZid(Context context) {
        String str;
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(SP_FILE_NAME, 0);
        try {
            str = UUID.randomUUID().toString();
        } catch (Throwable unused) {
            str = "";
        }
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("session_id", str).commit();
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageInfo a6 = b.a().a(context, str, 64);
                if (a6 != null) {
                    return a6.versionName;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    th.toString();
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
        return "";
    }
}
