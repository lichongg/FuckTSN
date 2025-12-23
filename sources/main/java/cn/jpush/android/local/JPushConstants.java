package cn.jpush.android.local;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ad.a;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.x.b;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushConstants {
    public static int BUILD_ID = 61;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final int FORE_GROUND = 0;
    public static final int FORE_GROUND_NO = 1;
    public static final int FORE_GROUND_UNKNOWN = -1;
    public static final String HTTPS_PRE = "https://";
    public static final String HTTP_PRE = "http://";
    public static final boolean IG = false;
    public static boolean IS_HB_PERIOD_ENABLE = true;
    public static String SDK_NAME = "";
    public static final String SDK_TYPE = "JPUSH";
    public static int SDK_VERSION_CODE = 570;
    public static String SDK_VERSION_NAME = "5.7.0";
    public static boolean SUPPORT_DY = true;
    private static final String TAG = "JPushConstants";
    public static boolean THIRD_ENABLE = true;
    private static final String USER_MESSAGE_RECEIVER_ACTION = "cn.jpush.android.intent.RECEIVER_MESSAGE";
    private static Bundle configBundle = null;
    public static int isForeGround = -1;
    private static boolean isInitLife;
    private static Boolean isSameProcessWithJCommonReceiver;
    private static boolean isTestAndroidQ;
    private static JPushMessageReceiver jPushMessageReceiver;
    public static Context mApplicationContext;
    private static String messageReceiverClass;
    private static String messageReceiverProcess;
    private static boolean tcpConnected;

    public static class TEST_CONFIG {
        public static String TEST_FILE_URL = "";
        public static String TEST_FILE_VERSION = "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r3.getApplicationInfo().targetSdkVersion <= 28) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isAndroidQ(android.content.Context r3, boolean r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 1
            r2 = 28
            if (r4 != 0) goto L15
            boolean r3 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r3 == 0) goto L10
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r2) goto L2b
        Le:
            r0 = 1
            goto L2b
        L10:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 <= r2) goto L2b
            goto Le
        L15:
            boolean r4 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r4 == 0) goto L1e
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r2) goto L2b
            goto L22
        L1e:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 <= r2) goto L2b
        L22:
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            if (r3 <= r2) goto L2b
            goto Le
        L2b:
            if (r0 == 0) goto L43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "is Android Q, msg: "
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "JPushConstants"
            cn.jpush.android.helper.Logger.d(r4, r3)
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.local.JPushConstants.isAndroidQ(android.content.Context, boolean, java.lang.String):boolean");
    }

    public static boolean canGetLbsInBackGround(Context context) {
        String str;
        if (isAndroidQ(context, true, "canGetLbsInBackGround")) {
            if (isForeGround != 1 || a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                str = (isForeGround == -1 && !a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) ? "app is unkonwn foreground stat and no android.permission.ACCESS_BACKGROUND_LOCATION" : "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION";
            }
            Logger.ww(TAG, str);
            return false;
        }
        return true;
    }

    public static void changeForegroudStat(Context context, boolean z5) {
        Logger.d(TAG, "changeForegroudStat:" + z5);
        isForeGround = !z5 ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", z5);
        JCoreHelper.runActionWithService(context, SDK_TYPE, "change_foreground", bundle);
    }

    private static void defaultRegister(Context context, ActivityLifeCallBack activityLifeCallBack) {
        Activity k6;
        if (context instanceof Application) {
            String d6 = a.d(context);
            String packageName = context.getPackageName();
            if (d6 == null || packageName == null || !context.getPackageName().equals(d6)) {
                Logger.d(TAG, "need not initPageLifecycle in other process :" + d6);
                d dVar = new d();
                dVar.f3602r = 1;
                b.a(context, "sync_reg_lifecycle", dVar, (Intent) null);
                return;
            }
            ((Application) context).registerActivityLifecycleCallbacks(activityLifeCallBack);
            if (ActivityLifeCallBack.activityTaskCount == 0 && (k6 = a.k(context)) != null) {
                activityLifeCallBack.onActivityCreated(k6, null);
                activityLifeCallBack.onActivityStarted(k6);
                activityLifeCallBack.onActivityResumed(k6);
            }
            Logger.d(TAG, "initPageLifecycle in main process, packageName:" + packageName + ", currentProcessName:" + d6);
        }
    }

    public static Context getAppContext(Context context) {
        if (mApplicationContext == null && context != null) {
            mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return mApplicationContext;
    }

    public static Bundle getBundle() {
        return configBundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00cf, code lost:
    
        cn.jpush.android.local.JPushConstants.messageReceiverClass = r5;
        cn.jpush.android.local.JPushConstants.messageReceiverProcess = r4.activityInfo.processName;
        cn.jpush.android.helper.Logger.ii(cn.jpush.android.local.JPushConstants.TAG, "found messageReceiverClass :" + cn.jpush.android.local.JPushConstants.messageReceiverClass + " at " + cn.jpush.android.local.JPushConstants.messageReceiverProcess + " by getCommonReceiverNames");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fa, code lost:
    
        r0 = cn.jpush.android.local.JPushConstants.messageReceiverProcess;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00fc, code lost:
    
        if (r0 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0106, code lost:
    
        if (r0.equals(cn.jpush.android.ad.a.d(r12)) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0108, code lost:
    
        cn.jpush.android.local.JPushConstants.jPushMessageReceiver = (cn.jpush.android.service.JPushMessageReceiver) r6.newInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMessageReceiverClass(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.local.JPushConstants.getMessageReceiverClass(android.content.Context):java.lang.String");
    }

    private static void initPageLifecycle(Context context) {
        if (context == null) {
            Logger.w(TAG, "[initPageLifecycle] context is null");
            return;
        }
        Logger.d(TAG, "initPageLifecycle init, isInitLife: " + isInitLife);
        if (isInitLife) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            isInitLife = true;
            ActivityLifeCallBack activityLifeCallBack = new ActivityLifeCallBack();
            try {
                JCoreManager.addActivityLifeCallback(activityLifeCallBack);
                Logger.d(TAG, "initPageLifecycle init to JCore ");
            } catch (Throwable unused) {
                defaultRegister(origApplicationContext, activityLifeCallBack);
                Logger.d(TAG, "initPageLifecycle init to JPush ");
            }
        } catch (Throwable th) {
            Logger.ww(TAG, "registerActivityLifecycleCallbacks failed:" + th.getMessage());
        }
    }

    public static boolean isSameProcessWithJCommonService(Context context) {
        Boolean bool;
        try {
            Boolean bool2 = isSameProcessWithJCommonReceiver;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (messageReceiverProcess == null) {
                getMessageReceiverClass(context);
            }
            ComponentInfo a6 = a.a(context, context.getPackageName(), (Class<?>) JCommonService.class);
            if (a6 == null) {
                return false;
            }
            if (a6.processName.equals(messageReceiverProcess)) {
                Logger.dd(TAG, "same process with JCommonService");
                bool = Boolean.TRUE;
            } else {
                Logger.dd(TAG, "is not same process with JCommonService");
                bool = Boolean.FALSE;
            }
            isSameProcessWithJCommonReceiver = bool;
            return isSameProcessWithJCommonReceiver.booleanValue();
        } catch (Throwable th) {
            Logger.w(TAG, "call isSameProcessWithJCommonService failed:" + th.getMessage());
            return false;
        }
    }

    public static boolean isTcpConnected() {
        return tcpConnected;
    }

    public static void setBundle(Bundle bundle) {
        configBundle = bundle;
    }

    public static void setTcpConnected(boolean z5) {
        tcpConnected = z5;
    }

    public static JPushMessageReceiver getPushMessageReceiver(Context context) {
        getMessageReceiverClass(getAppContext(context));
        return jPushMessageReceiver;
    }

    public static void init(Context context) {
        initPageLifecycle(context);
    }

    public static void testAndroidQ() {
    }
}
