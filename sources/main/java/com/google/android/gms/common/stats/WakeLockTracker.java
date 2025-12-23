package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public class WakeLockTracker {
    private static final WakeLockTracker zza = new WakeLockTracker();

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i6, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i7, @NonNull List<String> list) {
    }

    @NonNull
    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zza;
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i6, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i7, @NonNull List<String> list, long j6) {
    }

    @KeepForSdk
    public void registerReleaseEvent(@NonNull Context context, @NonNull Intent intent) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, int i6, @NonNull List<String> list, boolean z5, long j6) {
    }

    @KeepForSdk
    public void registerAcquireEvent(@NonNull Context context, @NonNull Intent intent, @NonNull String str, @NonNull String str2, @NonNull String str3, int i6, @NonNull String str4) {
    }
}
