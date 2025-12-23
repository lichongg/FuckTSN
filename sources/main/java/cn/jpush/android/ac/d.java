package cn.jpush.android.ac;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;
import java.util.LinkedList;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f3385a;

    public static cn.jpush.android.d.d a(Context context, String str, String str2) {
        return cn.jpush.android.d.d.a(context, str, str2);
    }

    private static void a(Context context, cn.jpush.android.d.d dVar) {
        Intent b6 = 2 == dVar.ad ? cn.jpush.android.x.b.b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : cn.jpush.android.x.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar);
        if (b6 != null) {
            b6.addFlags(268435456);
            StubApp.getOrigApplicationContext(context.getApplicationContext()).startActivity(b6);
        }
    }

    private static void b(Context context, cn.jpush.android.d.d dVar, String str, int i6) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageUnShow in foreground");
        dVar.f3589e = i6;
        cn.jpush.android.x.b.a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f3588d, str, dVar.ai, 1060L, context);
    }

    private static void c(Context context, cn.jpush.android.d.d dVar, String str, int i6) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageClick");
        if (!dVar.Y) {
            cn.jpush.android.x.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, (Intent) null);
        } else if (dVar.ai == 8) {
            a(context, dVar);
        }
    }

    private static void a(Context context, cn.jpush.android.d.d dVar, String str, int i6) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageArrived");
        cn.jpush.android.x.b.a(context, "cn.jpush.android.intent.NOTIFICATION_ARRIVED", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f3588d, str, dVar.ai, 1018L, context);
    }

    public static void a(Context context, String str, String str2, int i6, byte b6, int i7) {
        if (context == null) {
            Logger.ww("PluginPlatformsNotificationHelper", "context was null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Logger.ww("PluginPlatformsNotificationHelper", "content was null");
            return;
        }
        Logger.v("PluginPlatformsNotificationHelper", "message content:" + str);
        cn.jpush.android.d.d a6 = a(context, str, str2);
        Logger.v("PluginPlatformsNotificationHelper", "entity:" + a6);
        if (a6 == null) {
            Logger.ww("PluginPlatformsNotificationHelper", "entity was null");
            return;
        }
        if (TextUtils.isEmpty(a6.f3588d)) {
            Logger.ww("PluginPlatformsNotificationHelper", "message id was empty");
            return;
        }
        a6.ai = b6;
        a6.f3589e = i6;
        if (i7 == 0) {
            c(context, a6, str2, i6);
            LinkedList linkedList = new LinkedList();
            linkedList.add(a6.f3588d);
            cn.jpush.android.x.d.a(context, linkedList, 1);
            return;
        }
        if (i7 == 1) {
            a(context, a6, str2, i6);
        } else {
            if (i7 != 2) {
                return;
            }
            b(context, a6, str2, i6);
        }
    }
}
