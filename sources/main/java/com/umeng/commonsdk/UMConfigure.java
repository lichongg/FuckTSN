package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.c;
import com.umeng.commonsdk.utils.d;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog;
    private static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    private static boolean preInitComplete = false;
    private static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static int preInitInvokedFlag = 0;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean shouldCheckShareSdk = true;
    private static boolean shouldCollectAid = true;
    private static volatile boolean shouldOutputRT = false;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", bi.al};
    private static boolean isFinish = false;
    private static Object lockObject = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        if (cls == null) {
            return null;
        }
        try {
            constructor = cls.getDeclaredConstructor(null);
        } catch (NoSuchMethodException unused) {
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        constructor.setAccessible(true);
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(Context context, int i6, String str) {
        init(context, null, null, i6, str);
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j6) {
        a.f41873c = ((int) j6) * 1000;
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.trim().getBytes().length > 64) {
                return;
            }
            int ordinal = bs_type.ordinal();
            String[] strArr = BUSINESS_TYPE;
            String str2 = ordinal < strArr.length ? strArr[ordinal] : "";
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            TagHelper.deleteModuleTag(str2 + "_" + str);
        } catch (Throwable unused) {
        }
    }

    private static void disableAidCollect() {
        try {
            if (getClass("com.umeng.socialize.UMShareAPI") != null) {
                shouldCollectAid = false;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean getInitStatus() {
        boolean z5;
        synchronized (lockObject) {
            z5 = isFinish;
        }
        return z5;
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        mOnGetOaidListener = onGetOaidListener;
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
            @Override // java.lang.Runnable
            public void run() {
                String a6 = aw.a(origApplicationContext);
                if (UMConfigure.mOnGetOaidListener != null) {
                    UMConfigure.mOnGetOaidListener.onGetOaid(a6);
                }
            }
        }).start();
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    public static void init(Context context, String str, String str2, int i6, String str3) {
        Object invoke;
        Method declaredMethod;
        Class<?> cls;
        Method declaredMethod2;
        Method declaredMethod3;
        Object invoke2;
        Method declaredMethod4;
        Method declaredMethod5;
        try {
            try {
                if (debugLog) {
                    int i7 = SdkVersion.SDK_TYPE;
                }
            } catch (Throwable th) {
                if (debugLog) {
                    th.toString();
                }
            }
        } catch (Exception e6) {
            if (debugLog) {
                e6.toString();
            }
        }
        if (context == null || isInit) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        UMGlobalContext.getInstance(origApplicationContext);
        if (c.a()) {
            if (!isPreInit()) {
                preInitInternal(origApplicationContext, str, str2);
                if (!isPreInit()) {
                    return;
                }
            }
            UMWorkDispatch.sendEvent(origApplicationContext, com.umeng.commonsdk.internal.a.D, b.a(origApplicationContext).a(), null);
            return;
        }
        try {
            if (getClass("com.umeng.umzid.ZIDManager") == null) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(origApplicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                            Looper.loop();
                        } catch (Throwable unused) {
                        }
                    }
                }.start();
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls2 = getClass("com.umeng.message.PushAgent");
            if (cls2 != null && !checkShareSdk(cls2) && shouldCheckShareSdk) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(origApplicationContext, UMLogCommon.SC_10015, 1).show();
                            Looper.loop();
                        } catch (Throwable unused2) {
                        }
                    }
                }.start();
            }
        } catch (Throwable unused2) {
        }
        try {
            Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
            if (cls3 != null && !checkShareSdk(cls3) && shouldCheckShareSdk) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(origApplicationContext, UMLogCommon.SC_10015, 1).show();
                            Looper.loop();
                        } catch (Throwable unused3) {
                        }
                    }
                }.start();
            }
        } catch (Throwable unused3) {
        }
        if (!isPreInit()) {
            preInitInternal(origApplicationContext, str, str2);
            if (!isPreInit()) {
                return;
            }
        }
        UMEnvelopeBuild.registerNetReceiver(origApplicationContext);
        UMUtils.setAppkey(origApplicationContext, sAppkey);
        String lastAppkey = UMUtils.getLastAppkey(origApplicationContext);
        if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
            if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
            }
            UMUtils.setLastAppkey(origApplicationContext, sAppkey);
        }
        if (debugLog) {
            String appkeyByXML = UMUtils.getAppkeyByXML(origApplicationContext);
            if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
            }
        }
        UMUtils.setChannel(origApplicationContext, sChannel);
        try {
            Method declaredMethod6 = MobclickAgent.class.getDeclaredMethod("init", Context.class);
            if (declaredMethod6 != null) {
                declaredMethod6.setAccessible(true);
                declaredMethod6.invoke(MobclickAgent.class, origApplicationContext);
                if (FieldManager.allow(d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                    l.a(origApplicationContext).b(origApplicationContext);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                }
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                }
            }
            Class.forName("com.umeng.analytics.game.UMGameAgent");
            Method declaredMethod7 = MobclickAgent.class.getDeclaredMethod("setGameScenarioType", Context.class);
            if (declaredMethod7 != null) {
                declaredMethod7.setAccessible(true);
                declaredMethod7.invoke(MobclickAgent.class, origApplicationContext);
            }
            if (com.umeng.commonsdk.statistics.b.f41874a.indexOf("e") >= 0 && (declaredMethod5 = MobclickAgent.class.getDeclaredMethod("disableExceptionCatch", null)) != null) {
                declaredMethod5.setAccessible(true);
                declaredMethod5.invoke(MobclickAgent.class, null);
            }
        } catch (Throwable unused4) {
        }
        try {
            Class<?> cls4 = Class.forName("com.umeng.message.PushAgent");
            Method declaredMethod8 = cls4.getDeclaredMethod("init", Context.class);
            if (declaredMethod8 != null) {
                declaredMethod8.setAccessible(true);
                declaredMethod8.invoke(cls4, origApplicationContext);
            }
        } catch (Throwable unused5) {
        }
        try {
            Class<?> cls5 = Class.forName("com.umeng.message.MessageSharedPrefs");
            Method declaredMethod9 = cls5.getDeclaredMethod("getInstance", Context.class);
            if (declaredMethod9 != null && (invoke2 = declaredMethod9.invoke(cls5, origApplicationContext)) != null) {
                Method declaredMethod10 = cls5.getDeclaredMethod("setMessageAppKey", String.class);
                if (declaredMethod10 != null) {
                    declaredMethod10.setAccessible(true);
                    declaredMethod10.invoke(invoke2, sAppkey);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                    }
                }
                Method declaredMethod11 = cls5.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                if (declaredMethod11 != null) {
                    declaredMethod11.setAccessible(true);
                    declaredMethod11.invoke(invoke2, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                    }
                }
                if (!TextUtils.isEmpty(str3) && (declaredMethod4 = cls5.getDeclaredMethod("setMessageAppSecret", String.class)) != null) {
                    declaredMethod4.setAccessible(true);
                    declaredMethod4.invoke(invoke2, str3);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                    }
                }
            }
        } catch (Exception unused6) {
        }
        try {
            Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
            setFile(cls6, KEY_FILE_NAME_APPKEY, sAppkey);
            if (cls6 != null && (declaredMethod3 = cls6.getDeclaredMethod("init", Context.class, String.class)) != null) {
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(cls6, origApplicationContext, sAppkey);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                }
            }
        } catch (Throwable unused7) {
        }
        AnalyticsConstants.setDeviceType(i6);
        try {
            Class<?> cls7 = Class.forName("com.umeng.error.UMError");
            Method declaredMethod12 = cls7.getDeclaredMethod("init", Context.class);
            if (declaredMethod12 != null) {
                declaredMethod12.setAccessible(true);
                declaredMethod12.invoke(cls7, origApplicationContext);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                }
            }
        } catch (Throwable unused8) {
        }
        try {
            if (getClass("com.umeng.umefs.UMEfs") == null && (cls = getClass("com.umeng.umcrash.UMCrash")) != null) {
                if (SdkVersion.SDK_TYPE == 1 && (declaredMethod2 = cls.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(cls, Boolean.TRUE);
                }
                Method declaredMethod13 = cls.getDeclaredMethod("init", Context.class, String.class, String.class);
                if (declaredMethod13 != null) {
                    declaredMethod13.setAccessible(true);
                    declaredMethod13.invoke(cls, origApplicationContext, sAppkey, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                    }
                }
            }
        } catch (Throwable unused9) {
        }
        try {
            Method declaredMethod14 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
            if (declaredMethod14 != null) {
                declaredMethod14.invoke(null, origApplicationContext, sAppkey, sChannel, Integer.valueOf(i6), str3);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
            }
        } catch (Throwable unused10) {
        }
        try {
            Method declaredMethod15 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
            if (declaredMethod15 != null) {
                declaredMethod15.invoke(null, origApplicationContext, sAppkey);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
            }
        } catch (Throwable unused11) {
        }
        synchronized (lockObject) {
            isFinish = true;
        }
        if (needCheckPolicyResult(origApplicationContext)) {
            synchronized (lock) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.umeng.commonsdk.internal.a.J, preInitInvokedFlag);
                    jSONObject.put(com.umeng.commonsdk.internal.a.K, policyGrantInvokedFlag);
                    jSONObject.put("policyGrantResult", policyGrantResult);
                    UMWorkDispatch.sendEvent(origApplicationContext, com.umeng.commonsdk.internal.a.A, b.a(origApplicationContext).a(), jSONObject);
                } catch (Throwable unused12) {
                }
            }
        }
        if (needSendZcfgEnv(origApplicationContext)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
            UMWorkDispatch.sendEvent(origApplicationContext, com.umeng.commonsdk.internal.a.f41762p, b.a(origApplicationContext).a(), null);
        } else if (UMUtils.isMainProgress(origApplicationContext)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
            if (FieldManager.b()) {
                UMWorkDispatch.sendEvent(origApplicationContext, com.umeng.commonsdk.internal.a.f41771y, b.a(origApplicationContext).a(), null);
            }
            if (FieldManager.allow(d.G)) {
                com.umeng.commonsdk.internal.c.a(origApplicationContext, false);
            }
        }
        if (isDebugLog()) {
            UMConfigureInternation.doSelfCheck(origApplicationContext);
        }
        try {
            Context origApplicationContext2 = StubApp.getOrigApplicationContext(context.getApplicationContext());
            Class<?> cls8 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
            Method declaredMethod16 = cls8.getDeclaredMethod("getInstance", null);
            if (declaredMethod16 != null && (invoke = declaredMethod16.invoke(cls8, null)) != null && (declaredMethod = cls8.getDeclaredMethod("init", Context.class)) != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(invoke, origApplicationContext2);
            }
        } catch (Exception unused13) {
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.F, b.a(context).a(), null);
        if (isInit) {
            return;
        }
        isInit = true;
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static boolean isPreInit() {
        boolean z5;
        synchronized (PreInitLock) {
            z5 = preInitComplete;
        }
        return z5;
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if ("1".equals(UMUtils.getSystemProperty("debug.umeng.rtlog", "0"))) {
            shouldOutputRT = true;
        }
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(origApplicationContext);
        l.a(origApplicationContext);
        if (!needSendZcfgEnv(origApplicationContext)) {
            FieldManager.a().a(origApplicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
        boolean a6 = c.a();
        if (debugLog && a6) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
        }
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    private static void setCheckDevice(boolean z5) {
        AnalyticsConstants.CHECK_DEVICE = z5;
    }

    public static void setLogEnabled(boolean z5) {
        try {
            debugLog = z5;
            MLog.DEBUG = z5;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            Object decInstanceObject = getDecInstanceObject(cls);
            Class cls2 = Boolean.TYPE;
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{cls2}), decInstanceObject, new Object[]{Boolean.valueOf(z5)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z5);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{cls2}), new Object[]{Boolean.valueOf(z5)});
        } catch (Exception e6) {
            if (debugLog) {
                e6.toString();
            }
        } catch (Throwable th) {
            if (debugLog) {
                th.toString();
            }
        }
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        if (bs_type == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.trim().getBytes().length > 64 || str2.trim().getBytes().length > 128) {
                return;
            }
            int ordinal = bs_type.ordinal();
            String[] strArr = BUSINESS_TYPE;
            String str3 = ordinal < strArr.length ? strArr[ordinal] : "";
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            TagHelper.setModuleTag(str3 + "_" + str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void setProcessEvent(boolean z5) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z5;
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    public static void enableAzxSwitch(boolean z5) {
        com.umeng.ccg.b.a(z5);
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static String getCurrentActivityName() {
        return PageNameMonitor.getInstance().getCurrentActivityName();
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Boolean isInForeground() {
        return Boolean.valueOf(com.umeng.analytics.vshelper.b.d());
    }

    private static boolean isSilentMode() {
        boolean a6 = c.a();
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + a6);
        return a6;
    }

    private static boolean needCheckPolicyResult(Context context) {
        if (new File(context.getFilesDir().getAbsolutePath() + File.separator + bm.f41048m).exists()) {
            return false;
        }
        return true;
    }

    public static boolean needSendZcfgEnv(Context context) {
        if (new File(context.getFilesDir().getAbsolutePath() + File.separator + bm.f41047l).exists()) {
            return false;
        }
        return true;
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        CcgAgent.registerActionInfo(actionInfo);
    }

    public static void resetStorePrefix(String str) {
        au.b().a(str);
    }

    public static void setDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UMServerURL.DEFAULT_URL = str;
        UMServerURL.SECONDARY_URL = str;
    }

    public static void setEncryptEnabled(boolean z5) {
        com.umeng.commonsdk.statistics.b.a(z5);
    }

    private static void setFile(Class<?> cls, String str, boolean z5) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z5));
            } catch (Exception unused) {
            }
        }
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("native")) {
                com.umeng.commonsdk.stateless.a.f41841a = "native";
                a.f41871a = "native";
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.f41841a = WRAPER_TYPE_COCOS2DX_X;
                a.f41871a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.f41841a = WRAPER_TYPE_COCOS2DX_XLUA;
                a.f41871a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.f41841a = WRAPER_TYPE_UNITY;
                a.f41871a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.f41841a = WRAPER_TYPE_REACTNATIVE;
                a.f41871a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.f41841a = WRAPER_TYPE_PHONEGAP;
                a.f41871a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.f41841a = WRAPER_TYPE_WEEX;
                a.f41871a = WRAPER_TYPE_WEEX;
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.f41841a = "hybrid";
                a.f41871a = "hybrid";
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.f41841a = WRAPER_TYPE_FLUTTER;
                a.f41871a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.umeng.commonsdk.stateless.a.f41842b = str2;
        a.f41872b = str2;
    }

    public static void submitPolicyGrantResult(Context context, boolean z5) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.B, b.a(context).a(), null);
        synchronized (lock) {
            try {
                policyGrantInvokedFlag = 1;
                if (z5) {
                    policyGrantResult = 1;
                } else {
                    policyGrantResult = 2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f41772z, b.a(context).a(), Integer.valueOf(policyGrantResult));
    }
}
