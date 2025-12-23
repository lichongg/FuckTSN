package com.bxkj.student.run.app.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final long f20201a = 5000;

    /* renamed from: b, reason: collision with root package name */
    private Context f20202b;

    /* renamed from: c, reason: collision with root package name */
    public AlarmManager f20203c;

    /* renamed from: d, reason: collision with root package name */
    public PendingIntent f20204d;

    public void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f20203c;
        if (alarmManager == null || (pendingIntent = this.f20204d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public void b() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f20203c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f20204d);
        } else {
            this.f20203c.setExact(0, System.currentTimeMillis() + 5000, this.f20204d);
        }
    }

    @SuppressLint({"NewApi"})
    public void c() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f20203c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f20204d);
        } else {
            this.f20203c.setExact(0, System.currentTimeMillis() + 5000, this.f20204d);
        }
    }

    public c(Context aContext) {
        this.f20202b = aContext;
        this.f20203c = (AlarmManager) aContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent("WANG_LEI");
        intent.putExtra("msg", "赶紧起床");
        this.f20204d = PendingIntent.getBroadcast(this.f20202b, 0, intent, 0);
    }
}
