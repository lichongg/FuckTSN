package com.bxkj.student.run.app.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d {
    public static void a(Context context, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    public static void b(Context context, long firstTime, long cycTime, String action, int AlarmManagerType) {
        Intent intent = new Intent();
        intent.setAction(action);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(AlarmManagerType, firstTime, cycTime, PendingIntent.getBroadcast(context, 0, intent, 0));
    }
}
