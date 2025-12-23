package cn.jiguang.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import cn.jiguang.ba.h;
import cn.jiguang.bb.f;
import cn.jiguang.bz.b;
import cn.jiguang.bz.q;
import cn.jiguang.d.a;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.weapon.p0.g;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JCoreManager {
    private static final String TAG = "JCoreManager";
    private static final AtomicBoolean isInited = new AtomicBoolean();
    private static int DEFAULT_CMD = -1;

    public static void init(Context context) {
        init(context, null);
    }

    public static void initCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 70, true, null, null, new Object[0]);
    }

    public static boolean isInternal() {
        return false;
    }

    public static Object onEvent(Context context, String str, int i6, String str2, Bundle bundle, Object... objArr) {
        boolean z5;
        switch (i6) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 18:
            case 19:
            case 20:
            case 21:
            case 25:
            case 26:
            case 32:
            case 33:
            case 34:
            case 42:
            case 43:
            case 45:
            case 46:
            case 47:
            case 49:
            case 52:
            case 53:
            case 58:
            case 60:
            case 63:
            case 64:
            case 67:
            case 68:
            case 69:
            case 75:
            case 76:
            case 77:
            case 78:
            case 82:
            case 83:
            case 90:
            case 91:
            case 92:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 108:
            case 109:
            case 110:
            case 119:
            case 120:
            case 121:
            case 123:
            case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS /* 134 */:
                z5 = false;
                break;
            default:
                z5 = true;
                break;
        }
        return onEvent(context, str, i6, z5, str2, bundle, objArr);
    }

    public static void register(Context context, String str) {
        try {
            register(context, str, null);
        } catch (Throwable unused) {
        }
    }

    public static void stopCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 71, true, null, null, new Object[0]);
    }

    public static boolean getDebugMode() {
        return JConstants.DEBUG_MODE;
    }

    public static void init(Context context, int i6, Bundle bundle) {
        Context appContext = JConstants.getAppContext(context);
        if (appContext == null) {
            return;
        }
        if (!b.a()) {
            f.l(TAG, "user don't auth, so return init");
            return;
        }
        JConstants.isCallInit.set(true);
        AtomicBoolean atomicBoolean = isInited;
        if (atomicBoolean.get()) {
            if (96 == i6) {
                JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", bundle, new Object[0]);
                return;
            }
            return;
        }
        atomicBoolean.set(true);
        try {
            if (h.a(appContext)) {
                atomicBoolean.set(false);
                JConstants.isCallInit.set(false);
            } else {
                a.a(appContext);
                JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", bundle, new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    public static Object onEvent(Context context, String str, int i6, boolean z5, String str2, Bundle bundle, Object... objArr) {
        if (96 == i6) {
            try {
                boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                f.d(TAG, "saveAuth：" + booleanValue);
                b.a(booleanValue, true);
            } catch (Throwable unused) {
            }
        }
        if (!cn.jiguang.c.b.f2800a.contains(Integer.valueOf(i6))) {
            init(context, i6, bundle);
        }
        return JCoreInternalHelper.getInstance().onEvent(context, str, i6, z5, str2, bundle, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:2:0x0000, B:5:0x000c, B:8:0x0013, B:9:0x001b, B:11:0x0040, B:14:0x0046, B:16:0x0051, B:17:0x0056, B:19:0x0019), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:2:0x0000, B:5:0x000c, B:8:0x0013, B:9:0x001b, B:11:0x0040, B:14:0x0046, B:16:0x0051, B:17:0x0056, B:19:0x0019), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void register(android.content.Context r10, java.lang.String r11, android.os.Bundle r12) {
        /*
            java.lang.String r0 = cn.jiguang.ba.a.b(r10)     // Catch: java.lang.Throwable -> L6d
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = "JCoreManager"
            if (r1 != 0) goto L19
            boolean r0 = r0.equals(r11)     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L13
            goto L19
        L13:
            java.lang.String r0 = "[register] not same appkey with manifest,please check it"
            cn.jiguang.bb.f.j(r2, r0)     // Catch: java.lang.Throwable -> L6d
            goto L1b
        L19:
            cn.jiguang.internal.JConstants.APP_KEY = r11     // Catch: java.lang.Throwable -> L6d
        L1b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r0.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = "[register]  appkey ="
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = cn.jiguang.internal.JConstants.APP_KEY     // Catch: java.lang.Throwable -> L6d
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = " originKep="
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            r0.append(r11)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6d
            cn.jiguang.bb.f.e(r2, r0)     // Catch: java.lang.Throwable -> L6d
            boolean r0 = cn.jiguang.ba.h.a(r10)     // Catch: java.lang.Throwable -> L6d
            r1 = 0
            if (r0 == 0) goto L46
            java.util.concurrent.atomic.AtomicBoolean r10 = cn.jiguang.internal.JConstants.isCallInit     // Catch: java.lang.Throwable -> L6d
            r10.set(r1)     // Catch: java.lang.Throwable -> L6d
            return
        L46:
            java.util.concurrent.atomic.AtomicBoolean r0 = cn.jiguang.internal.JConstants.isCallInit     // Catch: java.lang.Throwable -> L6d
            r2 = 1
            r0.set(r2)     // Catch: java.lang.Throwable -> L6d
            cn.jiguang.d.a.a(r10)     // Catch: java.lang.Throwable -> L6d
            if (r12 != 0) goto L56
            android.os.Bundle r12 = new android.os.Bundle     // Catch: java.lang.Throwable -> L6d
            r12.<init>()     // Catch: java.lang.Throwable -> L6d
        L56:
            r8 = r12
            java.lang.String r12 = "appkey"
            r8.putString(r12, r11)     // Catch: java.lang.Throwable -> L6d
            cn.jiguang.internal.JCoreInternalHelper r2 = cn.jiguang.internal.JCoreInternalHelper.getInstance()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = "JCore"
            java.lang.String r7 = "a5"
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L6d
            r5 = 10
            r6 = 1
            r3 = r10
            r2.onEvent(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6d
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.JCoreManager.register(android.content.Context, java.lang.String, android.os.Bundle):void");
    }

    public static void reportWakedData(Context context, Bundle bundle, int i6) {
        if (context == null) {
            f.j(TAG, "[reportWakedData] context was null");
            return;
        }
        if (bundle == null) {
            f.j(TAG, "[reportWakedData] bundle was null");
            return;
        }
        int i7 = bundle.getInt("type", -1);
        if (i7 != -1) {
            i6 = i7;
        }
        if (i6 != 1 && i6 != 2 && i6 != 4 && i6 != 8 && i6 != 16 && i6 != 32) {
            f.j(TAG, "[reportWakedData] wrong type:" + i6);
            return;
        }
        bundle.putInt("type", i6);
        f.c(TAG, "action - reportWakedData" + bundle.toString());
        onEvent(context, null, 74, null, bundle, new Object[0]);
    }

    public static void requestPermission(Context context) {
        String str;
        if (context == null) {
            str = "[requestPermission] context was null";
        } else if (context instanceof Activity) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 23) {
                str = "[requestPermission] android.os.Build.VERSION.SDK_INT<23";
            } else if (context.getApplicationInfo().targetSdkVersion < 23) {
                str = "[requestPermission] app targetSdkVersion<23";
            } else {
                if (i6 < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
                    return;
                }
                try {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(g.f36050j);
                    linkedList.add(g.f36049i);
                    linkedList.add(g.f36047g);
                    linkedList.add(g.f36043c);
                    if (JConstants.isAndroidQ(context, false, "will request background location permission")) {
                        linkedList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    }
                    List<String> a6 = q.a(context, linkedList);
                    if (a6 != null && !a6.isEmpty()) {
                        f.a(TAG, "lackPermissions:" + a6);
                        Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, a6.toArray(new String[a6.size()]), 1);
                        return;
                    }
                    return;
                } catch (Exception e6) {
                    str = "#unexcepted - requestPermission e:" + e6;
                }
            }
        } else {
            str = "[requestPermission] context must instanceof Activity";
        }
        f.j(TAG, str);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        JConstants.jAnalyticsAction = jAnalyticsAction;
    }

    public static void setDebugMode(boolean z5) {
        JConstants.DEBUG_MODE = z5;
    }

    public static void setLBSEnable(Context context, boolean z5) {
        f.c(TAG, "action - setLBSEnable-control:" + z5);
        f.j(TAG, "Since the SDK has provided a new geographical location control interface, part of the control logic has become invalid, and this interface will be gradually deprecated. Please adapt to the new interface as soon as possible.");
        if (!z5) {
            try {
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ae().a((cn.jiguang.e.a<Boolean>) Boolean.FALSE)});
            } catch (Throwable unused) {
            }
        }
        onEvent(context, null, 27, null, null, Boolean.valueOf(z5));
    }

    public static void unRegister(Context context) {
        JConstants.isCallInit.set(true);
        a.a(context);
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "tcp_a23", null, new Object[0]);
    }

    public static void addActivityLifeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        a.a(activityLifecycleCallbacks);
    }

    public static void addDispatchAction(String str, String str2) {
        a.a(str, str2);
    }

    public static Context getAppContext(Context context) {
        return JConstants.getAppContext(context);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        Object onEvent = JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 67, false, null, null, new Object[0]);
        if (!(onEvent instanceof Boolean)) {
            return false;
        }
        return ((Boolean) onEvent).booleanValue();
    }

    public static void init(Context context, Bundle bundle) {
        init(context, DEFAULT_CMD, bundle);
    }

    public static boolean isTestEnv() {
        return JConstants.isTestEnv();
    }

    public static void removeActivityLifeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        a.b(activityLifecycleCallbacks);
    }

    public static void setSDKConfigs(Context context, Bundle bundle) {
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 55, true, null, bundle, new Object[0]);
    }

    public static void changeLiveStatus(boolean z5) {
    }
}
