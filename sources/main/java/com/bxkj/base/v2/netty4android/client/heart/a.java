package com.bxkj.base.v2.netty4android.client.heart;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f17131a;

    /* renamed from: b, reason: collision with root package name */
    private final long f17132b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final AlarmManager f17133c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final PendingIntent f17134d;

    public a(@NotNull Context context) {
        g0.p(context, "context");
        this.f17131a = context;
        this.f17132b = 10000L;
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        g0.n(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        this.f17133c = (AlarmManager) systemService;
        this.f17134d = PendingIntent.getService(context, 0, new Intent(context, (Class<?>) AlarmNettyService.class), 0);
    }

    public final void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f17133c;
        if (alarmManager == null || (pendingIntent = this.f17134d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public final void b() {
        a();
        if (Build.VERSION.SDK_INT >= 23) {
            AlarmManager alarmManager = this.f17133c;
            g0.m(alarmManager);
            alarmManager.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + this.f17132b, this.f17134d);
        } else {
            AlarmManager alarmManager2 = this.f17133c;
            g0.m(alarmManager2);
            alarmManager2.setExact(0, System.currentTimeMillis() + this.f17132b, this.f17134d);
        }
    }
}
