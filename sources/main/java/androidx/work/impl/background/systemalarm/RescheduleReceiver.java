package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                WorkManagerImpl.getInstance(context).setReschedulePendingResult(goAsync());
                return;
            } catch (IllegalStateException e6) {
                Logger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e6);
                return;
            }
        }
        context.startService(CommandHandler.createRescheduleIntent(context));
    }
}
