package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.m.a;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JPushAction {
    public abstract Object beforLogin(Context context, String str, int i6, String str2);

    public abstract ProxyActivityAction getPopWinActivity(Context context);

    public abstract ProxyActivityAction getPushActivity(Context context);

    public abstract Object handleAction(Context context, String str, Object obj);

    public abstract void handleNotificationIntent(Context context, Intent intent);

    public boolean isSupportedCMD(String str, int i6) {
        return i6 == 3 || i6 == 29 || i6 == 28 || i6 == 27 || i6 == 10 || i6 == 26 || i6 == 25 || i6 == 34 || i6 == 36 || i6 == 37;
    }

    public abstract void onActivityLifeCallback(Activity activity, String str);

    public abstract void onInAppMessageClick(Context context, NotificationMessage notificationMessage);

    public abstract void onInAppMessageShow(Context context, NotificationMessage notificationMessage);

    public abstract void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent);

    public abstract void onJPushMessageReceive(Context context, String str, String str2, Bundle bundle);

    public abstract void onMessage(Context context, CustomMessage customMessage);

    public abstract void onMultiAction(Context context, Intent intent);

    public abstract void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage);

    public abstract void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage);

    public abstract void onTagAliasResponse(Context context, long j6, int i6, Intent intent);

    public abstract void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams);

    public String getSdkVersion(String str) {
        return a.f3709b;
    }
}
