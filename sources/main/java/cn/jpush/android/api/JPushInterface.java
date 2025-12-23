package cn.jpush.android.api;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.data.JPushCollectControl;
import cn.jpush.android.data.JPushConfig;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.v.d;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushInterface {
    public static final String ACTION_CONNECTION_CHANGE = "cn.jpush.android.intent.CONNECTION";
    public static final String ACTION_IN_APP_MSG_CLICK = "cn.jpush.android.intent.IN_APP_MSG_CLICK";
    public static final String ACTION_IN_APP_MSG_SHOW = "cn.jpush.android.intent.IN_APP_MSG_SHOW";
    public static final String ACTION_MESSAGE_RECEIVED = "cn.jpush.android.intent.MESSAGE_RECEIVED";
    public static final String ACTION_NOTIFICATION_CLICK_ACTION = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION";
    public static final String ACTION_NOTIFICATION_CLICK_ACTION_PROXY = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY";
    public static final String ACTION_NOTIFICATION_OPENED = "cn.jpush.android.intent.NOTIFICATION_OPENED";
    public static final String ACTION_NOTIFICATION_RECEIVED = "cn.jpush.android.intent.NOTIFICATION_RECEIVED";
    public static final String ACTION_NOTIFICATION_RECEIVED_PROXY = "cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY";
    public static final String ACTION_REGISTRATION_ID = "cn.jpush.android.intent.REGISTRATION";
    public static final String ACTION_RICHPUSH_CALLBACK = "cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK";
    public static int DEFAULT_NOTIFICATION_NUM = 5;
    public static final String EXTRA_ACTIVITY_PARAM = "cn.jpush.android.ACTIVITY_PARAM";
    public static final String EXTRA_ALERT = "cn.jpush.android.ALERT";
    public static final String EXTRA_ALERT_TYPE = "cn.jpush.android.ALERT_TYPE";
    public static final String EXTRA_APP_KEY = "cn.jpush.android.APPKEY";
    public static final String EXTRA_BIG_PIC_PATH = "cn.jpush.android.BIG_PIC_PATH";
    public static final String EXTRA_BIG_TEXT = "cn.jpush.android.BIG_TEXT";
    public static final String EXTRA_CONNECTION_CHANGE = "cn.jpush.android.CONNECTION_CHANGE";
    public static final String EXTRA_CONTENT_TYPE = "cn.jpush.android.CONTENT_TYPE";
    public static final String EXTRA_EXTRA = "cn.jpush.android.EXTRA";
    public static final String EXTRA_INBOX = "cn.jpush.android.INBOX";
    public static final String EXTRA_MESSAGE = "cn.jpush.android.MESSAGE";
    public static final String EXTRA_MSG_ID = "cn.jpush.android.MSG_ID";
    public static final String EXTRA_NOTIFICATION_ACTION_EXTRA = "cn.jpush.android.NOTIFIACATION_ACTION_EXTRA";
    public static final String EXTRA_NOTIFICATION_DEVELOPER_ARG0 = "cn.jpush.android.NOTIFICATION_DEVELOPER_ARG0";
    public static final String EXTRA_NOTIFICATION_ID = "cn.jpush.android.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_LARGET_ICON = "cn.jpush.android.NOTIFICATION_LARGE_ICON";
    public static final String EXTRA_NOTIFICATION_SMALL_ICON = "cn.jpush.android.NOTIFICATION_SMALL_ICON";
    public static final String EXTRA_NOTIFICATION_TITLE = "cn.jpush.android.NOTIFICATION_CONTENT_TITLE";
    public static final String EXTRA_NOTIFICATION_URL = "cn.jpush.android.NOTIFICATION_URL";
    public static final String EXTRA_NOTI_CATEGORY = "cn.jpush.android.NOTI_CATEGORY";
    public static final String EXTRA_NOTI_IMPORTANCE = "cn.jpush.android.NOTI_IMPORTANCE";
    public static final String EXTRA_NOTI_PRIORITY = "cn.jpush.android.NOTI_PRIORITY";
    public static final String EXTRA_NOTI_TYPE = "cn.jpush.android.NOTIFICATION_TYPE";
    public static final String EXTRA_PUSH_ID = "cn.jpush.android.PUSH_ID";
    public static final String EXTRA_REGISTRATION_ID = "cn.jpush.android.REGISTRATION_ID";
    public static final String EXTRA_RICHPUSH_FILE_PATH = "cn.jpush.android.FILE_PATH";
    public static final String EXTRA_RICHPUSH_FILE_TYPE = "cn.jpush.android.FILE_TYPE";
    public static final String EXTRA_RICHPUSH_HTML_PATH = "cn.jpush.android.HTML_PATH";
    public static final String EXTRA_RICHPUSH_HTML_RES = "cn.jpush.android.HTML_RES";
    public static final String EXTRA_STATUS = "cn.jpush.android.STATUS";
    public static final String EXTRA_TITLE = "cn.jpush.android.TITLE";
    public static final String EXTRA_TYPE_PLATFORM = "cn.jpush.android.TYPE_PLATFORM";
    public static final String PUSH_MESSAGE_PERMISSION_POSTFIX = ".permission.JPUSH_MESSAGE";

    /* renamed from: a, reason: collision with root package name */
    private static final Integer f3498a = 0;

    public static class ErrorCode {
        public static int ERROR_CODE_ALIAS_LIMIT = 6027;
        public static int ERROR_CODE_ALIAS_OPERATORING = 6022;
        public static int ERROR_CODE_APPKEY_NOT_AUTH_TO_SET_PROPERTY = 6036;
        public static int ERROR_CODE_BLACKLIST = 6015;
        public static int ERROR_CODE_GET_FAILED = 6019;
        public static int ERROR_CODE_INTERNEL_SERVER_ERROR = 6024;
        public static int ERROR_CODE_INVALIDREQ = 6017;
        public static int ERROR_CODE_INVALIDUSER = 6016;
        public static int ERROR_CODE_INVALID_MOBILENUMBER = 6023;
        public static int ERROR_CODE_MODE_NOT_MATCH = 6034;
        public static int ERROR_CODE_NOT_PULL_IN_BLOCK_LIST = 6035;
        public static int ERROR_CODE_NO_IN_APP_DATA = 6029;
        public static int ERROR_CODE_OVER_FREQUENCY = 6031;
        public static int ERROR_CODE_OVER_FREQUENCY_SRV = 6030;
        public static int ERROR_CODE_PROPERTIES_OPERATORING = 6038;
        public static int ERROR_CODE_PROPERTY_ERROR = 6037;
        public static int ERROR_CODE_SERVER_INTERNAL_ERROR = 6033;
        public static int ERROR_CODE_SERVER_UNAVAILABLE = 6020;
        public static int ERROR_CODE_STYLE_NOT_SUPPORT = 6032;
        public static int ERROR_CODE_TAG_OPERATORING = 6021;
        public static int ERROR_CODE_TOO_BUSY = 6014;
        public static int ERROR_CODE_TOO_LONG_MOBILENUMBER = 6025;
        public static int ERROR_CODE_TOO_MANY_TAGS = 6018;
        public static int HAS_IN_APP_DATA = 6028;
        public static int INCORRECT_TIME = 6013;
        public static int INVALID_ALIAS = 6003;
        public static int INVALID_JSON = 6010;
        public static int INVALID_TAGS = 6005;
        public static int INVOKE_TOO_SOON = 6011;
        public static int NULL_TAGANDALIAS = 6001;
        public static int PUSH_STOPED = 6012;
        public static int SUCCESS = 0;
        public static int TIMEOUT = 6002;
        public static int TOO_LONG_ALIAS = 6004;
        public static int TOO_LONG_TAGALIAS = 6008;
        public static int TOO_LONG_TAGS = 6006;
        public static int TOO_MANY_TAGS = 6007;
        public static int UNKNOWN_ERROR = 6009;
    }

    public static class InAppStyle {
        public static int STYLE_BANNER = 1;
        public static int STYLE_FLOAT = 4;
        public static int STYLE_MODAL = 2;
    }

    static {
        JCoreManager.addDispatchAction(JPushConstants.SDK_TYPE, cn.jpush.android.helper.b.class.getName());
    }

    public static void init(Context context) {
        Logger.ki("JPushInterface", "action:init - jpush, SdkVersion:" + JPushConstants.SDK_VERSION_NAME + ", build id:" + JPushConstants.BUILD_ID + ", build type:release");
        checkContext(context);
        if (cn.jpush.android.ad.a.h(context)) {
            Logger.kd("JPushInterface", "check config suceess!!! ");
            JPushConstants.init(context);
            JCoreManager.init(context);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "init", null);
        }
    }

    @Deprecated
    public static void pullInAppMessage(Context context, int i6) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i6);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void reportNotificationOpened(Context context, String str) {
        checkContext(context);
        if (!TextUtils.isEmpty(str)) {
            cn.jpush.android.helper.c.a(str, 1028L, context);
            return;
        }
        Logger.ee("JPushInterface", "The msgId is not valid - " + str);
    }

    public static void setAlias(Context context, int i6, String str) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i6, str, 2, 2);
        Logger.kd("JPushInterface", "current use set alias is:" + str);
    }

    public static void setTags(Context context, int i6, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i6, set, 1, 2);
        Logger.kd("JPushInterface", "current use set tags is:" + set);
    }

    @Deprecated
    public void setAliasAndTags(Context context, String str, Set<String> set) {
        checkContext(context);
        setAliasAndTags(context, str, set, null);
    }

    private static void checkContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        JPushConstants.mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static void goToAppNotificationSettings(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "go_settings", null);
        if (cn.jpush.android.x.b.e(context)) {
            return;
        }
        cn.jpush.android.x.b.f(context);
    }

    public static void init(Context context, JPushConfig jPushConfig) {
        Logger.ki("JPushInterface", "action:init - jpush, SdkVersion:" + JPushConstants.SDK_VERSION_NAME + ", build id:" + JPushConstants.BUILD_ID + ", build type:release");
        checkContext(context);
        if (cn.jpush.android.ad.a.h(context)) {
            Logger.kd("JPushInterface", "check config suceess!!!");
            if (jPushConfig == null) {
                Logger.kw("JPushInterface", "JPushConfig is null, return");
                return;
            }
            JPushConstants.init(context);
            Bundle bundle = new Bundle();
            bundle.putSerializable("config", jPushConfig);
            if (!TextUtils.isEmpty(jPushConfig.getjAppKey())) {
                JCoreManager.register(context, jPushConfig.getjAppKey());
            }
            ActionHelper.getInstance().doSingleAction(context, "third_init", bundle);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "init", bundle);
        }
    }

    public static int isNotificationEnabled(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "is_enable", null);
        return cn.jpush.android.x.b.d(context);
    }

    public static void onFragmentPause(Context context, String str) {
        JCoreHelper.saEvent(context, "f_pause", str);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "fragmentName can not null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putBoolean("state", false);
        ActionHelper.getInstance().doSingleAction(context, "sync_fragment_life", bundle);
    }

    public static void onFragmentResume(Context context, String str) {
        JCoreHelper.saEvent(context, "f_resume", str);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "fragmentName can not null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putBoolean("state", true);
        ActionHelper.getInstance().doSingleAction(context, "sync_fragment_life", bundle);
    }

    public static void onKillProcess(Context context) {
        JCoreHelper.saEvent(context, "kill", null);
    }

    public static void onPause(Context context) {
        JCoreHelper.saEvent(context, "pause", null);
    }

    public static void onResume(Context context) {
        JCoreHelper.saEvent(context, "resume", null);
    }

    @Deprecated
    public static void pullInAppMessage(Context context, int i6, int i7) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i6);
            bundle.putInt("type", i7);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void reportNotificationOpened(Context context, String str, byte b6) {
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            Logger.ww("JPushInterface", "[requestPermission] unexcepted - context was null");
        } else {
            JCoreManager.requestPermission(context);
        }
    }

    public static void requestRequiredPermission(Activity activity) {
        if (activity == null) {
            Logger.ww("JPushInterface", "[requestRequiredPermission] unexcepted - context was null");
        } else {
            cn.jpush.android.ad.a.l(activity);
        }
    }

    public static void resumePush(Context context) {
        Logger.kd("JPushInterface", "action:resumePush");
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "resume", null);
        ActionHelper.getInstance().doSingleAction(context, "third_resume", null);
        ActionHelper.getInstance().setPushStatusWithCallBack(context, 4, 1);
    }

    @Deprecated
    public static void setAlias(Context context, String str, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        setAliasAndTags(context, str, null, tagAliasCallback);
    }

    @Deprecated
    public static void setAliasAndTags(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        ActionHelper.getInstance().setAliasAndTagsWithCallBack(context, str, set, tagAliasCallback, 0, 0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x0062
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public static void setDataInsightsEnable(android.content.Context r6, boolean r7) {
        /*
            java.lang.String r0 = "JPUSH"
            java.lang.String r1 = " jcore version="
            java.lang.String r2 = "JPushInterface"
            java.lang.String r3 = "enable_data_insights"
            android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> L81
            r4.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "enable"
            r4.putBoolean(r5, r7)     // Catch: java.lang.Throwable -> L81
            r4.putBoolean(r3, r7)     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.cache.a.g(r6, r7)     // Catch: java.lang.Throwable -> L81
            int r7 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r5 = 490(0x1ea, float:6.87E-43)
            if (r7 < r5) goto L42
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r7.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "setDataInsightsEnable   bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            r7.append(r4)     // Catch: java.lang.Throwable -> L62
            r7.append(r1)     // Catch: java.lang.Throwable -> L62
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.local.ActionHelper r7 = cn.jpush.android.local.ActionHelper.getInstance()     // Catch: java.lang.Throwable -> L62
            r7.doSingleAction(r6, r3, r4)     // Catch: java.lang.Throwable -> L62
            goto L81
        L42:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r7.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "setDataInsightsEnable  runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            r7.append(r4)     // Catch: java.lang.Throwable -> L62
            r7.append(r1)     // Catch: java.lang.Throwable -> L62
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L62
            goto L81
        L62:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r7.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "setDataInsightsEnable  err runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L81
            r7.append(r4)     // Catch: java.lang.Throwable -> L81
            r7.append(r1)     // Catch: java.lang.Throwable -> L81
            int r1 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L81
            r7.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L81
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.JPushInterface.setDataInsightsEnable(android.content.Context, boolean):void");
    }

    private static void setDefaultNotifactionNumber(Context context) {
        setLatestNotificationNumber(context, DEFAULT_NOTIFICATION_NUM);
    }

    public static void setDefaultPushNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        if (pushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL notification");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("buidler_id", f3498a.intValue());
        bundle.putString("buidler_string", pushNotificationBuilder.toString());
        JCoreHelper.runActionWithService(JPushConstants.mApplicationContext, JPushConstants.SDK_TYPE, "set_custom_notify", bundle);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x0062
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public static void setGeofenceEnable(android.content.Context r6, boolean r7) {
        /*
            java.lang.String r0 = "JPUSH"
            java.lang.String r1 = " jcore version="
            java.lang.String r2 = "JPushInterface"
            java.lang.String r3 = "enable_geo_push"
            android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> L81
            r4.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "enable"
            r4.putBoolean(r5, r7)     // Catch: java.lang.Throwable -> L81
            r4.putBoolean(r3, r7)     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.cache.a.e(r6, r7)     // Catch: java.lang.Throwable -> L81
            int r7 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r5 = 490(0x1ea, float:6.87E-43)
            if (r7 < r5) goto L42
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r7.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "setGeofenceEnable  for 129 bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            r7.append(r4)     // Catch: java.lang.Throwable -> L62
            r7.append(r1)     // Catch: java.lang.Throwable -> L62
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.local.ActionHelper r7 = cn.jpush.android.local.ActionHelper.getInstance()     // Catch: java.lang.Throwable -> L62
            r7.doSingleAction(r6, r3, r4)     // Catch: java.lang.Throwable -> L62
            goto L81
        L42:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r7.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "setGeofenceEnable  runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            r7.append(r4)     // Catch: java.lang.Throwable -> L62
            r7.append(r1)     // Catch: java.lang.Throwable -> L62
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L62
            goto L81
        L62:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r7.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "setGeofenceEnable  err runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L81
            r7.append(r4)     // Catch: java.lang.Throwable -> L81
            r7.append(r1)     // Catch: java.lang.Throwable -> L81
            int r1 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L81
            r7.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L81
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.JPushInterface.setGeofenceEnable(android.content.Context, boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x0065
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public static void setLinkMergeEnable(android.content.Context r6, boolean r7) {
        /*
            java.lang.String r0 = "JPUSH"
            java.lang.String r1 = " jcore version="
            java.lang.String r2 = "JPushInterface"
            java.lang.String r3 = "enable_link_push"
            android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> L84
            r4.<init>()     // Catch: java.lang.Throwable -> L84
            java.lang.String r5 = "enable"
            r4.putBoolean(r5, r7)     // Catch: java.lang.Throwable -> L84
            r4.putBoolean(r3, r7)     // Catch: java.lang.Throwable -> L84
            cn.jpush.android.cache.a.f(r6, r7)     // Catch: java.lang.Throwable -> L84
            cn.jiguang.api.JCoreInterface.setWakeEnable(r6, r7)     // Catch: java.lang.Throwable -> L84
            int r7 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L65
            r5 = 490(0x1ea, float:6.87E-43)
            if (r7 < r5) goto L45
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r7.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = "setLinkMergeEnable  for 129 bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L65
            r7.append(r4)     // Catch: java.lang.Throwable -> L65
            r7.append(r1)     // Catch: java.lang.Throwable -> L65
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L65
            r7.append(r5)     // Catch: java.lang.Throwable -> L65
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L65
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L65
            cn.jpush.android.local.ActionHelper r7 = cn.jpush.android.local.ActionHelper.getInstance()     // Catch: java.lang.Throwable -> L65
            r7.doSingleAction(r6, r3, r4)     // Catch: java.lang.Throwable -> L65
            goto L84
        L45:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r7.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = "setLinkMergeEnable  runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L65
            r7.append(r4)     // Catch: java.lang.Throwable -> L65
            r7.append(r1)     // Catch: java.lang.Throwable -> L65
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L65
            r7.append(r5)     // Catch: java.lang.Throwable -> L65
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L65
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L65
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L65
            goto L84
        L65:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r7.<init>()     // Catch: java.lang.Throwable -> L84
            java.lang.String r5 = "setLinkMergeEnable  err runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L84
            r7.append(r4)     // Catch: java.lang.Throwable -> L84
            r7.append(r1)     // Catch: java.lang.Throwable -> L84
            int r1 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L84
            r7.append(r1)     // Catch: java.lang.Throwable -> L84
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L84
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L84
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L84
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.JPushInterface.setLinkMergeEnable(android.content.Context, boolean):void");
    }

    public static void setNotificationCallBackEnable(Context context, boolean z5) {
        Logger.dd("JPushInterface", "setNotificationCallBackEnable");
        checkContext(context);
        try {
            cn.jpush.android.cache.a.h(context, z5);
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z5);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_notification_callback", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setPushNotificationBuilder(Integer num, PushNotificationBuilder pushNotificationBuilder) {
        Logger.vv("JPushInterface", "action:setPushNotificationBuilder - id:" + num);
        if (pushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL pushNotificationBuilder");
        }
        if (num.intValue() < 1) {
            Logger.ee("JPushInterface", "id should be larger than 0");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("buidler_id", num.intValue());
        bundle.putString("buidler_string", pushNotificationBuilder.toString());
        JCoreHelper.runActionWithService(JPushConstants.mApplicationContext, JPushConstants.SDK_TYPE, "set_custom_notify", bundle);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x0062
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public static void setSmartPushEnable(android.content.Context r6, boolean r7) {
        /*
            java.lang.String r0 = "JPUSH"
            java.lang.String r1 = " jcore version="
            java.lang.String r2 = "JPushInterface"
            java.lang.String r3 = "enable_smart_push"
            android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> L81
            r4.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "enable"
            r4.putBoolean(r5, r7)     // Catch: java.lang.Throwable -> L81
            r4.putBoolean(r3, r7)     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.cache.a.i(r6, r7)     // Catch: java.lang.Throwable -> L81
            int r7 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r5 = 490(0x1ea, float:6.87E-43)
            if (r7 < r5) goto L42
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r7.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "setSmartPushEnable  for 129 bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            r7.append(r4)     // Catch: java.lang.Throwable -> L62
            r7.append(r1)     // Catch: java.lang.Throwable -> L62
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.local.ActionHelper r7 = cn.jpush.android.local.ActionHelper.getInstance()     // Catch: java.lang.Throwable -> L62
            r7.doSingleAction(r6, r3, r4)     // Catch: java.lang.Throwable -> L62
            goto L81
        L42:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r7.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "setSmartPushEnable  runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            r7.append(r4)     // Catch: java.lang.Throwable -> L62
            r7.append(r1)     // Catch: java.lang.Throwable -> L62
            int r5 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L62
            r7.append(r5)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L62
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L62
            goto L81
        L62:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r7.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "setSmartPushEnable  err runActionWithService bundle="
            r7.append(r5)     // Catch: java.lang.Throwable -> L81
            r7.append(r4)     // Catch: java.lang.Throwable -> L81
            r7.append(r1)     // Catch: java.lang.Throwable -> L81
            int r1 = cn.jiguang.internal.JConstants.SDK_VERSION_INT     // Catch: java.lang.Throwable -> L81
            r7.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.helper.Logger.d(r2, r7)     // Catch: java.lang.Throwable -> L81
            cn.jpush.android.helper.JCoreHelper.runActionWithService(r6, r0, r3, r4)     // Catch: java.lang.Throwable -> L81
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.JPushInterface.setSmartPushEnable(android.content.Context, boolean):void");
    }

    @Deprecated
    public static void setTags(Context context, Set<String> set, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        setAliasAndTags(context, null, set, tagAliasCallback);
    }

    public static void setThirdPushEnable(Context context, boolean z5) {
        try {
            JPushConstants.THIRD_ENABLE = z5;
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z5);
            ActionHelper.getInstance().doSingleAction(context, "third_enable", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setThirdToken(Context context, String str) {
        if (!JPushConstants.THIRD_ENABLE) {
            Logger.ee("JPushInterface", "thirdEnable is false,won't set third token");
            return;
        }
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("third_token", str);
            ActionHelper.getInstance().doSingleAction(context, "set_third_token", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void stopPush(Context context) {
        Logger.kd("JPushInterface", "action:stopPush");
        checkContext(context);
        ActionHelper.getInstance().setPushStatusWithCallBack(context, 4, 0);
    }

    public static void addLocalNotification(Context context, JPushLocalNotification jPushLocalNotification) {
        checkContext(context);
        d.a(context, jPushLocalNotification);
    }

    public static void addTags(Context context, int i6, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i6, set, 1, 1);
    }

    public static void attachBaseContext(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("attachBaseContext", Context.class).invoke(null, context);
            Logger.d("JPushInterface", "use time:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable unused) {
        }
    }

    private static boolean checkLengthOfTags(String str) {
        int i6;
        if (!TextUtils.isEmpty(str)) {
            i6 = str.getBytes().length;
        } else {
            i6 = 0;
        }
        Logger.v("JPushInterface", "tags length:" + i6);
        if (i6 > 7000) {
            return false;
        }
        return true;
    }

    public static void checkSupportVasMessage(Context context, int i6) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("type", i6);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "check_vas_integrate", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void checkTagBindState(Context context, int i6, String str) {
        HashSet hashSet;
        checkContext(context);
        if (!TextUtils.isEmpty(str)) {
            hashSet = new HashSet();
            hashSet.add(str);
        } else {
            hashSet = null;
        }
        ActionHelper.getInstance().setTagsWithCallBack(context, i6, hashSet, 1, 6);
    }

    public static void cleanProperties(Context context, int i6) {
        checkContext(context);
        ActionHelper.getInstance().setPropertyWithCallBack(context, i6, new HashMap(), 3, 2);
    }

    public static void cleanTags(Context context, int i6) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i6, new HashSet(), 1, 4);
    }

    public static void clearAllNotifications(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "clear_all_notify", null);
        ActionHelper.getInstance().doSingleAction(context, "third_all_notify", null);
    }

    public static void clearLocalNotifications(Context context) {
        checkContext(context);
        d.a(context);
    }

    public static void clearNotificationById(Context context, int i6) {
        checkContext(context);
        if (i6 <= 0) {
            Logger.ee("JPushInterface", "Invalid notificationId, Give up action..");
            return;
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(i6);
        Bundle bundle = new Bundle();
        bundle.putInt("id", i6);
        ActionHelper.getInstance().doSingleAction(context, "clear_by_id", bundle);
    }

    public static void deleteAlias(Context context, int i6) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i6, null, 2, 3);
    }

    public static void deleteGeofence(Context context, String str) {
        checkContext(context);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "delete_geo_fence", bundle);
    }

    public static void deleteProperties(Context context, int i6, Map<String, Object> map) {
        checkContext(context);
        ActionHelper.getInstance().setPropertyWithCallBack(context, i6, map, 3, 1);
    }

    public static void deleteTags(Context context, int i6, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i6, set, 1, 3);
    }

    public static Set<String> filterValidTags(Set<String> set) {
        return cn.jpush.android.ab.b.a(set);
    }

    public static void getAlias(Context context, int i6) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i6, null, 2, 5);
    }

    public static void getAllTags(Context context, int i6) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i6, new HashSet(), 1, 5);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "get_connection", null);
        return JCoreManager.getConnectionState(context);
    }

    public static String getRegistrationID(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "get_rid", null);
        return JCoreHelper.getRegistrationID(context);
    }

    public static String getStringTags(Set<String> set) {
        return cn.jpush.android.ab.b.b(set);
    }

    public static String getUdid(Context context) {
        checkContext(context);
        return JCoreHelper.getDeviceId(context);
    }

    public static void initCrashHandler(Context context) {
        checkContext(context);
        JCoreManager.initCrashHandler(context);
    }

    public static boolean isPushStopped(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "check_stop", null);
        return cn.jpush.android.cache.a.e(context);
    }

    public static void pullInAppMessage(Context context, int i6, String str) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i6);
            bundle.putString("AdPositionKey", str);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void pullInAppMessageWithParams(Context context, InAppSlotParams inAppSlotParams) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            if (inAppSlotParams != null) {
                bundle.putString("inapp_param", inAppSlotParams.toJSONString());
            }
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void registerByKey(Context context, String str) {
        checkContext(context);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "devKey is not valid - " + str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("dev_key", str);
        ActionHelper.getInstance().doSingleAction(context, "dy_register", bundle);
    }

    public static void removeLocalNotification(Context context, long j6) {
        checkContext(context);
        d.a(context, j6);
    }

    public static void reportMessageOpened(Context context, String str, byte b6) {
        checkContext(context);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "The msgId is not valid - " + str);
            return;
        }
        cn.jpush.android.helper.c.a(str, "", b6, 1028L, context);
    }

    public static void reportNotificationOpened(Context context, String str, byte b6, String str2) {
    }

    public static void reportWakedData(Context context, Bundle bundle, int i6) {
        checkContext(context);
        try {
            JCoreManager.reportWakedData(context, bundle, i6);
        } catch (Throwable unused) {
            Logger.ee("JPushInterface", "not found [reportWakedData] in jcore");
        }
    }

    public static void setBadgeNumber(Context context, int i6) {
        Context appContext = JPushConstants.getAppContext(context);
        if (i6 < 0) {
            i6 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i6);
        JCoreHelper.runActionWithService(appContext, JPushConstants.SDK_TYPE, "set_badge", bundle);
    }

    public static void setChannel(Context context, String str) {
        JCoreHelper.setChannel(context, str);
    }

    public static void setCollectControl(Context context, JPushCollectControl jPushCollectControl) {
        checkContext(context);
        if (jPushCollectControl != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("enable_c_c", jPushCollectControl.getEnableDatas());
                bundle.putIntegerArrayList("disable_c_c", jPushCollectControl.getDisableDatas());
                JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 111, null, bundle, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setDebugMode(boolean z5) {
        JCoreManager.setDebugMode(z5);
    }

    public static void setGeofenceInterval(Context context, long j6) {
        checkContext(context);
        if (j6 >= 180000 && j6 <= 86400000) {
            Bundle bundle = new Bundle();
            bundle.putLong(bi.aX, j6);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "geo_interval", bundle);
            return;
        }
        Logger.ee("JPushInterface", "Invalid interval, it should be a ms number between 3 mins and 1 day!");
    }

    public static void setHbPeriodEnable(Context context, boolean z5) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z5);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "set_hb_period_enable", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setLatestNotificationNumber(Context context, int i6) {
        checkContext(context);
        Logger.dd("JPushInterface", "action:setLatestNotificationNumber : " + i6);
        if (i6 <= 0) {
            Logger.ee("JPushInterface", "maxNum should > 0, Give up action..");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i6);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "max_num", bundle);
    }

    public static void setMaxGeofenceNumber(Context context, int i6) {
        checkContext(context);
        if (i6 >= 1 && i6 <= 100) {
            Bundle bundle = new Bundle();
            bundle.putInt("num", i6);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "geo_fence_max_num", bundle);
            return;
        }
        Logger.ee("JPushInterface", "Invalid maxNumber,it should be a number between 1 and 100!");
    }

    public static void setMobileNumber(Context context, int i6, String str) {
        checkContext(context);
        cn.jpush.android.helper.d.a().a(context, i6, str);
    }

    public static void setProperties(Context context, int i6, Map<String, Object> map) {
        checkContext(context);
        ActionHelper.getInstance().setPropertyWithCallBack(context, i6, map, 3, 0);
    }

    public static void setPushTime(Context context, Set<Integer> set, int i6, int i7) {
        checkContext(context);
        if (!cn.jpush.android.ad.a.a(context)) {
            Logger.dd("JPushInterface", "检测到当前没有网络。此动作将在有网络时自动继续执行。");
        }
        if (set == null) {
            Bundle bundle = new Bundle();
            bundle.putString("time", "0123456_0^23");
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "pushtime", bundle);
            return;
        }
        if (set.size() != 0 && !set.isEmpty()) {
            if (i6 > i7) {
                Logger.ee("JPushInterface", "Invalid time format - startHour should less than endHour");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Integer num : set) {
                if (num.intValue() <= 6 && num.intValue() >= 0) {
                    sb.append(num);
                } else {
                    Logger.ee("JPushInterface", "Invalid day format - " + num);
                    return;
                }
            }
            sb.append("_");
            sb.append(i6);
            sb.append("^");
            sb.append(i7);
            Bundle bundle2 = new Bundle();
            bundle2.putString("time", sb.toString());
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "pushtime", bundle2);
            return;
        }
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "disable_push", null);
    }

    public static void setSilenceTime(Context context, int i6, int i7, int i8, int i9) {
        checkContext(context);
        if (i6 >= 0 && i7 >= 0 && i8 >= 0 && i9 >= 0 && i7 <= 59 && i9 <= 59 && i8 <= 23 && i6 <= 23) {
            if (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("time", "");
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "silenceTime", bundle);
                Logger.dd("JPushInterface", "Remove the silence time!");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("startHour", i6);
                jSONObject.put("startMins", i7);
                jSONObject.put("endHour", i8);
                jSONObject.put("endtMins", i9);
                Bundle bundle2 = new Bundle();
                bundle2.putString("time", jSONObject.toString());
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "silenceTime", bundle2);
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        Logger.ee("JPushInterface", "Invalid parameter format, startHour and endHour should between 0 ~ 23, startMins and endMins should between 0 ~ 59. ");
    }

    public static void si(Context context, Bundle bundle) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "si", bundle);
    }

    public static void stopCrashHandler(Context context) {
        checkContext(context);
        JCoreManager.stopCrashHandler(context);
    }

    private static void taq() {
        JPushConstants.testAndroidQ();
    }

    public static void triggerInAppMsgByEvent(Context context, int i6, String str) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i6);
            bundle.putString("event_name", str);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "trigger_in_app_event", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setDaemonAction(String str) {
    }

    public static void setStatisticsEnable(boolean z5) {
    }

    public static void setStatisticsSessionTimeout(long j6) {
    }

    public static void setPowerSaveMode(Context context, boolean z5) {
    }
}
