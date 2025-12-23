package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class WakeLocks {
    private static final String TAG = Logger.tagWithPrefix("WakeLocks");
    private static final WeakHashMap<PowerManager.WakeLock, String> sWakeLocks = new WeakHashMap<>();

    public static void checkWakeLocks() {
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().warning(TAG, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
    }

    private WakeLocks() {
    }

    public static PowerManager.WakeLock newWakeLock(@NonNull Context context, @NonNull String tag) {
        String str = "WorkManager: " + tag;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = sWakeLocks;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, str);
        }
        return newWakeLock;
    }
}
