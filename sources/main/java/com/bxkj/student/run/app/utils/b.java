package com.bxkj.student.run.app.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.bxkj.student.run.app.location.service.LocationService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final long f20191a = 5000;

    /* renamed from: b, reason: collision with root package name */
    private Context f20192b;

    /* renamed from: c, reason: collision with root package name */
    private AlarmManager f20193c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f20194d;

    public void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f20193c;
        if (alarmManager == null || (pendingIntent = this.f20194d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public void b() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f20193c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f20194d);
        } else {
            this.f20193c.setExact(0, System.currentTimeMillis() + 5000, this.f20194d);
        }
    }

    public b(Context aContext) {
        this.f20192b = aContext;
        this.f20193c = (AlarmManager) aContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(aContext, (Class<?>) LocationService.class);
        intent.setAction("REQUEST_LOCATION");
        intent.putExtra("msg", "心跳包");
        this.f20194d = PendingIntent.getService(this.f20192b, 0, intent, 0);
    }
}
