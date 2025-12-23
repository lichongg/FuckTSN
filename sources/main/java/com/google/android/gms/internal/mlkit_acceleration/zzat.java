package com.google.android.gms.internal.mlkit_acceleration;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzat extends zzar implements ListenableFuture {
    @Override // com.google.android.gms.internal.mlkit_acceleration.zzar
    protected /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    protected abstract ListenableFuture zzc();

    protected zzat() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }
}
