package com.google.android.gms.internal.mlkit_acceleration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzbg {
    public static zzbb zza(ExecutorService executorService) {
        return executorService instanceof zzbb ? (zzbb) executorService : executorService instanceof ScheduledExecutorService ? new zzbf((ScheduledExecutorService) executorService) : new zzbc(executorService);
    }
}
