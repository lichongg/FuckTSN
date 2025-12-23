package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a, reason: collision with root package name */
    static double[] f40745a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f40746b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f40747c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f40748d = null;

    /* renamed from: e, reason: collision with root package name */
    private static int f40749e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = au.b().b(au.A);

    /* renamed from: f, reason: collision with root package name */
    private static Object f40750f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static boolean f40751g = false;

    /* renamed from: h, reason: collision with root package name */
    private static String f40752h = "";

    static void a(String str) {
        f40747c = str;
    }

    static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
        } else {
            f40748d = str;
            com.umeng.common.b.a(context).a(f40748d);
        }
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f40745a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f40750f) {
            str = f40752h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f40748d)) {
            f40748d = com.umeng.common.b.a(context).c();
        }
        return f40748d;
    }

    public static int getVerticalType(Context context) {
        if (f40749e == 0) {
            f40749e = com.umeng.common.b.a(context).d();
        }
        return f40749e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z5;
        synchronized (f40750f) {
            z5 = f40751g;
        }
        return z5;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f40750f) {
            f40751g = false;
            f40752h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f40750f) {
            try {
                f40751g = true;
                if (map != null && map.containsKey(DEBUG_KEY)) {
                    f40752h = map.get(DEBUG_KEY);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    static void a(Context context, int i6) {
        f40749e = i6;
        com.umeng.common.b.a(context).a(f40749e);
    }
}
