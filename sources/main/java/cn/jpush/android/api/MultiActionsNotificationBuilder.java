package cn.jpush.android.api;

import android.content.Context;
import cn.jpush.android.helper.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class MultiActionsNotificationBuilder extends DefaultPushNotificationBuilder {
    private static final String INTENT_NOTIFICATION_CLICK_ACTION_PROXY = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY";
    private static final String NOTI_ACT_EXTRA_STR = "notification_action_extra_string";
    private static final String NOTI_ACT_RES_ID = "notification_action_res_id";
    private static final String NOTI_ACT_TEXT = "notification_action_text";
    private static final String TAG = "MultiActionsNotificationBuilder";
    private JSONArray actionJSONArray = new JSONArray();
    protected Context mContext;

    public static PushNotificationBuilder parseFromPreference(Context context, String str) {
        MultiActionsNotificationBuilder multiActionsNotificationBuilder = new MultiActionsNotificationBuilder(context);
        try {
            multiActionsNotificationBuilder.actionJSONArray = new JSONArray(str);
            return multiActionsNotificationBuilder;
        } catch (JSONException e6) {
            Logger.ww(TAG, "Parse builder from preference failed!" + e6);
            return multiActionsNotificationBuilder;
        }
    }

    public void addJPushAction(int i6, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NOTI_ACT_RES_ID, i6);
            jSONObject.put(NOTI_ACT_TEXT, str);
            jSONObject.put(NOTI_ACT_EXTRA_STR, str2);
            this.actionJSONArray.put(jSONObject);
            Logger.i(TAG, this.actionJSONArray.toString());
        } catch (JSONException e6) {
            Logger.ww(TAG, "Construct action failed!" + e6);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:4|5|6|(12:23|24|26|27|9|(1:11)(1:22)|12|13|14|15|17|18)|8|9|(0)(0)|12|13|14|15|17|18|2) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d2, code lost:
    
        cn.jpush.android.helper.Logger.ww(cn.jpush.android.api.MultiActionsNotificationBuilder.TAG, "Parse Action from preference preference failed!" + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[Catch: JSONException -> 0x00cf, TryCatch #3 {JSONException -> 0x00cf, blocks: (B:5:0x0014, B:9:0x0054, B:12:0x0085, B:22:0x0081), top: B:4:0x0014 }] */
    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.app.Notification getNotification(android.app.Notification.Builder r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "notification_action_text"
            java.lang.String r3 = "notification_action_res_id"
            java.lang.String r4 = "MultiActionsNotificationBuilder"
            java.lang.String r5 = "notification_action_extra_string"
            r6 = 0
            r7 = 0
        Lc:
            org.json.JSONArray r0 = r1.actionJSONArray
            int r0 = r0.length()
            if (r7 >= r0) goto Lea
            org.json.JSONArray r0 = r1.actionJSONArray     // Catch: org.json.JSONException -> Lcf
            org.json.JSONObject r0 = r0.getJSONObject(r7)     // Catch: org.json.JSONException -> Lcf
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch: org.json.JSONException -> Lcf
            r9 = 34
            r10 = 1
            r11 = 0
            if (r8 < r9) goto L53
            android.app.ActivityOptions r8 = cn.jpush.android.api.c.a()     // Catch: java.lang.Throwable -> L53
            java.lang.Class<android.app.ActivityOptions> r9 = android.app.ActivityOptions.class
            java.lang.String r12 = "MODE_BACKGROUND_ACTIVITY_START_ALLOWED"
            java.lang.reflect.Field r12 = r9.getField(r12)     // Catch: java.lang.Throwable -> L54
            int r12 = r12.getInt(r11)     // Catch: java.lang.Throwable -> L54
            java.lang.String r13 = "MODE_BACKGROUND_ACTIVITY_START_DENIED"
            java.lang.reflect.Field r13 = r9.getField(r13)     // Catch: java.lang.Throwable -> L54
            r13.getInt(r11)     // Catch: java.lang.Throwable -> L54
            java.lang.String r13 = "setPendingIntentCreatorBackgroundActivityStartMode"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch: java.lang.Throwable -> L54
            java.lang.Class r15 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L54
            r14[r6] = r15     // Catch: java.lang.Throwable -> L54
            java.lang.reflect.Method r9 = r9.getMethod(r13, r14)     // Catch: java.lang.Throwable -> L54
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L54
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L54
            r13[r6] = r12     // Catch: java.lang.Throwable -> L54
            r9.invoke(r8, r13)     // Catch: java.lang.Throwable -> L54
            goto L54
        L53:
            r8 = r11
        L54:
            android.content.Intent r9 = new android.content.Intent     // Catch: org.json.JSONException -> Lcf
            java.lang.String r12 = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY"
            r9.<init>(r12)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r12 = "cn.jpush.android.NOTIFIACATION_ACTION_EXTRA"
            java.lang.String r13 = r0.getString(r5)     // Catch: org.json.JSONException -> Lcf
            r9.putExtra(r12, r13)     // Catch: org.json.JSONException -> Lcf
            android.content.Context r12 = r1.mContext     // Catch: org.json.JSONException -> Lcf
            java.lang.Class<cn.jpush.android.service.JNotifyActivity> r13 = cn.jpush.android.service.JNotifyActivity.class
            r9.setClass(r12, r13)     // Catch: org.json.JSONException -> Lcf
            r12 = 8388608(0x800000, float:1.1754944E-38)
            r9.setFlags(r12)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r12 = "isNotification"
            r9.putExtra(r12, r10)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r12 = "multi_notification_msg"
            cn.jpush.android.api.NotificationMessage r13 = r1.notificationMessage     // Catch: org.json.JSONException -> Lcf
            r9.putExtra(r12, r13)     // Catch: org.json.JSONException -> Lcf
            android.content.Context r12 = r1.mContext     // Catch: org.json.JSONException -> Lcf
            if (r8 != 0) goto L81
            goto L85
        L81:
            android.os.Bundle r11 = r8.toBundle()     // Catch: org.json.JSONException -> Lcf
        L85:
            r8 = 201326592(0xc000000, float:9.8607613E-32)
            android.app.PendingIntent r8 = android.app.PendingIntent.getActivity(r12, r7, r9, r8, r11)     // Catch: org.json.JSONException -> Lcf
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> Lcf
            r9.<init>()     // Catch: org.json.JSONException -> Lcf
            java.lang.String r11 = "Add notification action: res - "
            r9.append(r11)     // Catch: org.json.JSONException -> Lcf
            int r11 = r0.getInt(r3)     // Catch: org.json.JSONException -> Lcf
            r9.append(r11)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r11 = ", string - "
            r9.append(r11)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r11 = r0.getString(r2)     // Catch: org.json.JSONException -> Lcf
            r9.append(r11)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r11 = ", extra - "
            r9.append(r11)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r11 = r0.getString(r5)     // Catch: org.json.JSONException -> Lcf
            r9.append(r11)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r9 = r9.toString()     // Catch: org.json.JSONException -> Lcf
            cn.jpush.android.helper.Logger.i(r4, r9)     // Catch: org.json.JSONException -> Lcf
            int r9 = r0.getInt(r3)     // Catch: org.json.JSONException -> Lcf
            java.lang.String r0 = r0.getString(r2)     // Catch: org.json.JSONException -> Lcf
            r11 = r17
            android.app.Notification$Builder r0 = r11.addAction(r9, r0, r8)     // Catch: org.json.JSONException -> Lcd
            r0.setAutoCancel(r10)     // Catch: org.json.JSONException -> Lcd
            goto Le6
        Lcd:
            r0 = move-exception
            goto Ld2
        Lcf:
            r0 = move-exception
            r11 = r17
        Ld2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Parse Action from preference preference failed!"
            r8.append(r9)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            cn.jpush.android.helper.Logger.ww(r4, r0)
        Le6:
            int r7 = r7 + 1
            goto Lc
        Lea:
            r11 = r17
            android.app.Notification r0 = r11.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.MultiActionsNotificationBuilder.getNotification(android.app.Notification$Builder):android.app.Notification");
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return this.actionJSONArray.toString();
    }

    public MultiActionsNotificationBuilder(Context context) {
        this.mContext = context;
    }
}
