package com.bxkj.student.run.app.step;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LongRunningService extends Service {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new Date().toString();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new a()).start();
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setExact(2, SystemClock.elapsedRealtime() + 1000, PendingIntent.getBroadcast(this, 0, new Intent(this, (Class<?>) AlarmReceiver.class), 0));
        return super.onStartCommand(intent, flags, startId);
    }
}
