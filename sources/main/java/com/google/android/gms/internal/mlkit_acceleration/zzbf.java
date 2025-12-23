package com.google.android.gms.internal.mlkit_acceleration;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbf extends zzbc implements ScheduledExecutorService, zzbb {
    final ScheduledExecutorService zza;

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzbi zzn = zzbi.zzn(runnable, null);
        return new zzbd(zzn, scheduledExecutorService.schedule(zzn, j6, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        zzbe zzbeVar = new zzbe(runnable);
        return new zzbd(zzbeVar, this.zza.scheduleAtFixedRate(zzbeVar, j6, j7, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        zzbe zzbeVar = new zzbe(runnable);
        return new zzbd(zzbeVar, this.zza.scheduleWithFixedDelay(zzbeVar, j6, j7, timeUnit));
    }

    zzbf(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j6, TimeUnit timeUnit) {
        zzbi zzbiVar = new zzbi(callable);
        return new zzbd(zzbiVar, this.zza.schedule(zzbiVar, j6, timeUnit));
    }
}
