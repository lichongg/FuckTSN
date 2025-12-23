package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AlarmManagerCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        @DoNotInline
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long j6, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j6, pendingIntent);
        }

        @DoNotInline
        static void setAlarmClock(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }

        private Api21Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setAndAllowWhileIdle(AlarmManager alarmManager, int i6, long j6, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i6, j6, pendingIntent);
        }

        @DoNotInline
        static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i6, long j6, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i6, j6, pendingIntent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }

    public static boolean canScheduleExactAlarms(@NonNull AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.canScheduleExactAlarms(alarmManager);
        }
        return true;
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i6, long j6, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setAndAllowWhileIdle(alarmManager, i6, j6, pendingIntent);
        } else {
            alarmManager.set(i6, j6, pendingIntent);
        }
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i6, long j6, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setExactAndAllowWhileIdle(alarmManager, i6, j6, pendingIntent);
        } else {
            setExact(alarmManager, i6, j6, pendingIntent);
        }
    }

    private AlarmManagerCompat() {
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j6, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(j6, pendingIntent), pendingIntent2);
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i6, long j6, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExact(i6, j6, pendingIntent);
    }
}
