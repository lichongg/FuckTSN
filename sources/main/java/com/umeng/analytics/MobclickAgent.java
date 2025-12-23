package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.umeng.analytics.pro.j;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.MLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class MobclickAgent {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);


        /* renamed from: a, reason: collision with root package name */
        private int f40758a;

        public int toValue() {
            return this.f40758a;
        }

        EScenarioType(int i6) {
            this.f40758a = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    public static void onEvent(Context context, String str) {
        b.a().a(context, str, (String) null, -1L, 1);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void reportError(Context context, String str) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls, str, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.f41325k, 0, "\\|");
        } else {
            b.a().a(context, str, str2, -1L, 1);
        }
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            UMLog.aq(j.f41315a, 0, "\\|");
        } else {
            b.a().a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i6) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("__ct__", Integer.valueOf(i6));
        b.a().a(context, str, hashMap, -1L);
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.f41334t, 0, "\\|");
            return;
        }
        if (str2.length() > 64) {
            UMLog.aq(j.f41335u, 0, "\\|");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.a().a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.aq(j.f41336v, 0, "\\|");
        } else {
            b.a().a(str, str2);
        }
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.aq(j.f41328n, 0, "\\|");
        } else {
            b.a().b(context);
        }
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    public static void setSessionContinueMillis(long j6) {
        if (j6 <= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            j6 = 30000;
        }
        b.a().a(j6);
    }

    public static void userProfileEMail(String str) {
        if (str == null) {
            MLog.e("userProfileEMail: email value is null, please check!");
        } else {
            b.a().d(str);
        }
    }

    public static void userProfileMobile(String str) {
        if (str == null) {
            MLog.e("userProfileMobile: mobile value is null, please check!");
        } else {
            b.a().c(str);
        }
    }

    public static void clearPreProperties(Context context) {
        getAgent().g(context);
    }

    private static void disableExceptionCatch() {
        b.a().a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    public static b getAgent() {
        return b.a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().h(context);
    }

    private static void init(Context context) {
        b.a().a(context);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        b.a().a(context, str, hashMap);
    }

    public static void onKillProcess(Context context) {
        b.a().d(context);
    }

    public static void onPageEnd(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.a().b(str);
        } else {
            UMLog.aq(j.D, 0, "\\|");
        }
    }

    public static void onPageStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.a().a(str);
        } else {
            UMLog.aq(j.C, 0, "\\|");
        }
    }

    public static void onPause(Context context) {
        b.a().c(context);
    }

    public static void onProfileSignOff() {
        b.a().j();
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().a(context, jSONObject);
    }

    public static void setCatchUncaughtExceptions(boolean z5) {
        b.a().a(z5);
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().a(context, list);
    }

    private static void setGameScenarioType(Context context) {
        b.a().a(context, EScenarioType.E_UM_GAME);
    }

    public static void setLocation(double d6, double d7) {
        b.a().a(d6, d7);
    }

    public static void setOpenGLContext(GL10 gl10) {
        b.a().a(gl10);
    }

    public static void setSecret(Context context, String str) {
        b.a().c(context, str);
    }

    private static void setSysListener(ISysListener iSysListener) {
        b.a().a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().f(context, str);
    }

    public static void userProfile(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            MLog.e("userProfile: key is null or empty, please check!");
            return;
        }
        if (str.startsWith("_")) {
            MLog.e("userProfile: The user-defined key cannot start with an underscore, please check!");
            return;
        }
        if (Character.isDigit(str.charAt(0))) {
            MLog.e("userProfile: The user-defined key cannot start with an number, please check!");
            return;
        }
        for (char c6 : str.toCharArray()) {
            if ((c6 < 'a' || c6 > 'z') && ((c6 < 'A' || c6 > 'Z') && !Character.isDigit(c6) && c6 != '_')) {
                MLog.e("userProfile: The user-defined key contains invalid characters, please check!");
                return;
            }
        }
        if (obj == null) {
            MLog.e("userProfile: value is null, please check!");
        } else {
            b.a().a(str, obj);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            UMLog.aq(j.f41315a, 0, "\\|");
        } else {
            b.a().a(context, str, new HashMap(map), -1L);
        }
    }

    public static void reportError(Context context, Throwable th) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", Throwable.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls, th, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public static void enableEncrypt(boolean z5) {
    }

    @Deprecated
    public static void setCheckDevice(boolean z5) {
    }

    @Deprecated
    public static void setDebugMode(boolean z5) {
    }

    @Deprecated
    public static void setLatencyWindow(long j6) {
    }

    @Deprecated
    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }
}
