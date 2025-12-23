package cn.jiguang.bi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.service.AlarmReceiver;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static void a(Context context) {
        Context a6 = cn.jiguang.bz.d.a(context);
        if (Build.VERSION.SDK_INT >= 31) {
            cn.jiguang.bb.f.c("AlarmHelper", "sdk is android 12, return");
            return;
        }
        try {
            ((AlarmManager) a6.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(a6, 0, new Intent(a6, (Class<?>) AlarmReceiver.class), 67108864));
        } catch (Throwable unused) {
            cn.jiguang.bb.f.i("AlarmHelper", "Cancel heartbeat alarm failed.");
        }
    }

    public static void b(Context context) {
        Context a6 = cn.jiguang.bz.d.a(context);
        if (Build.VERSION.SDK_INT >= 31) {
            cn.jiguang.bb.f.c("AlarmHelper", "sdk is android 12, return");
            return;
        }
        if (!cn.jiguang.bz.b.b(a6)) {
            cn.jiguang.bb.f.c("AlarmHelper", "auto wakeup is closed");
            return;
        }
        g.a().e();
        long h6 = g.a().h() * 1000;
        long currentTimeMillis = System.currentTimeMillis() + h6;
        cn.jiguang.bb.f.f("AlarmHelper", "Reset heartbeat alarm, wait " + h6 + "ms.");
        try {
            ((AlarmManager) a6.getSystemService(NotificationCompat.CATEGORY_ALARM)).setWindow(0, currentTimeMillis, 0L, PendingIntent.getBroadcast(a6, 0, new Intent(a6, (Class<?>) AlarmReceiver.class), 67108864));
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("AlarmHelper", "can't trigger alarm cause by exception:" + th);
        }
    }
}
