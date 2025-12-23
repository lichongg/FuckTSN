package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public class StatsUtils {
    @NonNull
    @KeepForSdk
    public static String getEventKey(@NonNull PowerManager.WakeLock wakeLock, @NonNull String str) {
        String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock));
        if (true == TextUtils.isEmpty(str)) {
            str = "";
        }
        return String.valueOf(valueOf).concat(String.valueOf(str));
    }
}
