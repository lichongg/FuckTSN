package cn.jpush.android.api;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JThirdPlatFormInterface {
    public static final String ACTION_NOTIFICATION_ARRIVED = "action_notification_arrived";
    public static final String ACTION_NOTIFICATION_CLCKED = "action_notification_clicked";
    public static final String ACTION_NOTIFICATION_SHOW = "action_notification_show";
    public static final String ACTION_NOTIFICATION_UN_SHOW = "action_notification_unshow";
    public static final String ACTION_PLUGIN_PALTFORM_ON_MESSAGING = "intent.plugin.platform.ON_MESSAGING";
    public static final String ACTION_PLUGIN_PALTFORM_REFRESSH_REGID = "intent.plugin.platform.REFRESSH_REGID";
    public static final String ACTION_PLUGIN_PALTFORM_REQUEST_REGID = "intent.plugin.platform.REQUEST_REGID";
    public static final String ACTION_REGISTER_TOKEN = "action_register_token";
    public static final String ACTION_SEND_EXCEPTION = "action_send_exception";
    public static final int CMD_CALL_BACK = 10000;
    public static final String EXCEPTION_TYPE = "exception_type";
    public static final String KEY_CODE = "code";
    public static final String KEY_DATA = "data";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_MSG = "msg";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_NOTI_ID = "noti_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_PLUGIN_SDK_VER = "plugin_sdk_ver";
    public static final String KEY_ROM_TYPE = "rom_type";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_VENDOR_PUSH_APP_KEY_MISS = "j10000";
    public static final String KEY_VENDOR_PUSH_INIT_UNKNOWN_EXCEPTION = "j10001";
    public static final String KEY_VENDOR_PUSH_MANUFACTURE_UNKNOWN = "j10003";
    public static final String KEY_VENDOR_PUSH_STATUS_EXCEPTION = "j10002";
    public static final String KEY_VENDOR_SDK_VER = "vendor_sdk_ver";

    public static void setNotificationChannel(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i6, int i7, int i8) {
        cn.jpush.android.x.a.a(context, builder, str, charSequence, i6, i7, (String) null, i8);
    }

    public abstract void clearAllNotification(Context context);

    public abstract void clearNotification(Context context, int i6);

    public abstract String getAppId(Context context);

    public abstract String getAppkey(Context context);

    public abstract String getRomName();

    public abstract byte getRomType(Context context);

    public abstract String getToken(Context context);

    public abstract void init(Context context);

    public abstract boolean isNeedClearToken(Context context);

    public abstract boolean isSupport(Context context);

    public boolean needSendToMainProcess() {
        return false;
    }

    public abstract void register(Context context, Bundle bundle);

    public static void doAction(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("third_key_action", str);
        ActionHelper.getInstance().doAction(context, "third_action", bundle);
    }

    public static NotificationMessage parseMessage(Context context, String str) {
        return d.a(context, str, "").b();
    }

    public static void sendActionByJCore(Context context, Bundle bundle, String str) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, str, bundle);
    }

    public static void setNotificationChannel(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i6, int i7, String str2, int i8) {
        cn.jpush.android.x.a.a(context, builder, str, charSequence, i6, i7, str2, i8);
    }

    public static int getNofiticationID(String str, int i6) {
        return cn.jpush.android.x.b.a(str, i6);
    }

    public static void onEvent(Thread thread, Throwable th) {
        ActionHelper.getInstance().onEvent(thread, th);
    }

    public static void reportThirdSDKMsgActionResult(String str, String str2, byte b6, long j6, Context context) {
        cn.jpush.android.helper.c.a(str, str2, b6, j6, context);
    }

    public static void setNotification(Context context, Notification notification, String str, CharSequence charSequence, int i6, int i7, String str2, int i8) {
        cn.jpush.android.x.a.a(context, notification, str, charSequence, i6, i7, str2, i8);
    }

    public static String toHash(String str) {
        return cn.jpush.android.ad.a.d(str);
    }

    public void resumePush(Context context) {
    }

    public void stopPush(Context context) {
    }
}
