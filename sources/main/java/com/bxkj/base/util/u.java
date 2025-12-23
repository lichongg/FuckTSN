package com.bxkj.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class u {
    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT < 26) {
            v.o(activity);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        intent.putExtra("android.provider.extra.CHANNEL_ID", activity.getApplicationInfo().uid);
        activity.startActivity(intent);
    }

    public static void c(FragmentActivity fragmentActivity, b.a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            v.p(fragmentActivity, aVar);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", fragmentActivity.getPackageName());
        intent.putExtra("android.provider.extra.CHANNEL_ID", fragmentActivity.getApplicationInfo().uid);
        new u.b(fragmentActivity).startActivityForResult(intent).c(aVar);
    }

    public static boolean a(Context context) {
        return NotificationManagerCompat.from(StubApp.getOrigApplicationContext(context.getApplicationContext())).areNotificationsEnabled();
    }
}
