package com.google.android.gms.internal.mlkit_acceleration;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbd extends zzas implements ScheduledFuture, ListenableFuture {
    private final ScheduledFuture zza;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }

    public zzbd(ListenableFuture listenableFuture, ScheduledFuture scheduledFuture) {
        super(listenableFuture);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzar, java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        boolean cancel = zzb().cancel(z5);
        if (cancel) {
            this.zza.cancel(z5);
        }
        return cancel;
    }
}
