package com.bxkj.base.chat.heart;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final long f16484a = 5000;

    /* renamed from: b, reason: collision with root package name */
    private Context f16485b;

    /* renamed from: c, reason: collision with root package name */
    private AlarmManager f16486c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f16487d;

    public void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f16486c;
        if (alarmManager == null || (pendingIntent = this.f16487d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public void b() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f16486c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f16487d);
        } else {
            this.f16486c.setExact(0, System.currentTimeMillis() + 5000, this.f16487d);
        }
    }

    public b(Context context) {
        this.f16485b = context;
        this.f16486c = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(context, (Class<?>) AlarmChatService.class);
        intent.setAction("CHAT_HEART");
        intent.putExtra("msg", "心跳包");
        this.f16487d = PendingIntent.getService(this.f16485b, 0, intent, 0);
    }
}
