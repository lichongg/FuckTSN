package com.google.android.gms.internal.mlkit_acceleration;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzar extends zzah implements Future {
    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        return zzb().get();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzah
    protected /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    protected abstract Future zzb();

    @Override // java.util.concurrent.Future
    public final Object get(long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzb().get(j6, timeUnit);
    }

    protected zzar() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return zzb().cancel(z5);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return zzb().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return zzb().isDone();
    }
}
