package cn.jpush.android.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JCoreHelper {

    /* renamed from: a, reason: collision with root package name */
    private static Integer f3669a;

    private static void a(Context context, String str, int i6, int i7, long j6, long j7, byte[] bArr, boolean z5) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i6);
        bundle.putInt("ver", i7);
        bundle.putLong("rid", j6);
        bundle.putLong("timeout", j7);
        bundle.putByteArray("body", bArr);
        JCoreManager.onEvent(context, str, z5 ? 17 : 16, null, bundle, new Object[0]);
    }

    public static Boolean checkSdkBanned(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 82, null, null, new Object[0]);
        return onEvent instanceof Boolean ? (Boolean) onEvent : Boolean.FALSE;
    }

    public static void execue(Context context, String str, Runnable runnable) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 11, str, null, runnable);
    }

    public static JSONObject fillBase(Context context, JSONObject jSONObject, String str) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 26, "", null, jSONObject, str);
        if (onEvent instanceof JSONObject) {
            return (JSONObject) onEvent;
        }
        return null;
    }

    public static void futureExecutor(Context context, Runnable runnable) {
        futureExecutor(context, "FUTURE", runnable);
    }

    public static boolean geoEnable(Context context) {
        try {
            if (JConstants.SDK_VERSION_INT >= 490) {
                Bundle bundle = new Bundle();
                bundle.putInt("configID", AVMDLDataLoader.KeyIsIsTestSpeedVersion);
                bundle.putBoolean("isFromJCore", true);
                Object onEvent = JCoreManager.onEvent(null, null, 116, null, bundle, new Object[0]);
                if (onEvent instanceof Boolean) {
                    return ((Boolean) onEvent).booleanValue();
                }
            } else if (!cn.jpush.android.cache.a.s(context) && !cn.jpush.android.cache.a.o(context) && !cn.jpush.android.cache.a.q(context)) {
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static String getAppKey(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 7, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String getDeviceId(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 8, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static PackageInfo getPackageInfo(Context context, int i6) {
        if (context != null) {
            return getPackageInfo(context, context.getPackageName(), i6);
        }
        return null;
    }

    public static String getRegistrationID(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 4, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static long getUid(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 20, null, null, null);
        if (onEvent instanceof Long) {
            return ((Long) onEvent).longValue();
        }
        return 0L;
    }

    public static boolean isAuth(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 98, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return true;
    }

    public static boolean isIpv6Priority(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 121, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static void netMonitor(Context context, String str, String str2, long j6, int i6) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("type", str2);
        bundle.putLong("req", j6);
        bundle.putLong("res", i6);
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 122, null, bundle, new Object[0]);
    }

    public static void openLog(Context context, Bundle bundle) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 105, null, bundle, new Object[0]);
    }

    public static void runActionWithService(Context context, String str, String str2, Bundle bundle) {
        JCoreManager.onEvent(context, str, 3, str2, bundle, new Object[0]);
    }

    public static void saEvent(Context context, String str, Object obj) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 56, str, null, obj);
    }

    public static void sendRequest(Context context, String str, int i6, int i7, long j6, long j7, byte[] bArr) {
        a(context, str, i6, i7, j6, j7, bArr, true);
    }

    public static void setChannel(Context context, String str) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 9, str, null, new Object[0]);
    }

    public static void triggerSceneCheck(Context context) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 29, null, null, 3);
    }

    public static void futureExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f3710c >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 76, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static int getJCoreSDKVersionInt() {
        Integer num = f3669a;
        if (num != null) {
            return num.intValue();
        }
        Object onEvent = JCoreManager.onEvent(null, null, 25, null, null, new Object[0]);
        if (!(onEvent instanceof Integer)) {
            return 0;
        }
        Integer num2 = (Integer) onEvent;
        f3669a = num2;
        return num2.intValue();
    }

    public static int getJPushSDKVersionInt() {
        return cn.jpush.android.m.a.f3708a;
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i6) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && i6 >= 0) {
                    if (JConstants.SDK_VERSION_INT < 332) {
                        return context.getPackageManager().getPackageInfo(str, i6);
                    }
                    Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 99, null, null, str, Integer.valueOf(i6));
                    if (onEvent instanceof PackageInfo) {
                        return (PackageInfo) onEvent;
                    }
                    return null;
                }
            } catch (Throwable th) {
                Logger.w("JCoreHelper", "get p info failed, error: " + th.getMessage());
                return null;
            }
        }
        Logger.d("JCoreHelper", "get p info failed, because param is illegal");
        return null;
    }

    public static boolean isContinueBusiness(Context context) {
        if (cn.jpush.android.m.a.f3710c < 470) {
            return true;
        }
        Object onEvent = JCoreManager.onEvent(context, null, 123, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static void majorExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f3710c >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 75, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static void normalExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f3710c >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 77, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static void sendData(Context context, String str, int i6, int i7, long j6, byte[] bArr) {
        a(context, str, i6, i7, j6, 0L, bArr, false);
    }

    public static Object getDyInfo(Context context, int i6) {
        return JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 64, null, null, Integer.valueOf(i6));
    }

    public static void reportSdkType(Context context, String str, int i6, int i7, int i8) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 72, true, null, null, str, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }

    public static void updateDy(Context context, int i6) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 65, null, null, Integer.valueOf(i6));
    }
}
