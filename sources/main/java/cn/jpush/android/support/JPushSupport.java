package cn.jpush.android.support;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.MultiActionsNotificationBuilder;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.cache.a;
import cn.jpush.android.helper.Logger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushSupport {

    /* renamed from: a, reason: collision with root package name */
    private static final Integer f3813a = 0;

    public static PushNotificationBuilder getNotificationBuilder(Context context, NotificationMessage notificationMessage) {
        try {
            int i6 = notificationMessage.notificationBuilderId;
            if (i6 < 1) {
                i6 = f3813a.intValue();
            }
            String d6 = a.d(context, i6 + "");
            if (TextUtils.isEmpty(d6)) {
                Logger.d("JPushSupport", "not found custom notification");
                return null;
            }
            Logger.ii("JPushSupport", "get customBuilder:" + d6);
            if (!d6.startsWith("basic") && !d6.startsWith("custom")) {
                return MultiActionsNotificationBuilder.parseFromPreference(context, d6);
            }
            return BasicPushNotificationBuilder.parseFromPreference(context, d6);
        } catch (Throwable th) {
            Logger.ww("JPushSupport", "getNotification failed:" + th.getMessage());
            return null;
        }
    }
}
