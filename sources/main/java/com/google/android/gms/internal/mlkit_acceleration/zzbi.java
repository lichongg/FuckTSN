package com.google.android.gms.internal.mlkit_acceleration;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbi extends zzap implements RunnableFuture {

    @CheckForNull
    private volatile zzaz zzc;

    static zzbi zzn(Runnable runnable, Object obj) {
        return new zzbi(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzaz zzazVar = this.zzc;
        if (zzazVar != null) {
            zzazVar.run();
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj
    @CheckForNull
    protected final String zze() {
        zzaz zzazVar = this.zzc;
        if (zzazVar == null) {
            return super.zze();
        }
        return "task=[" + zzazVar.toString() + "]";
    }

    zzbi(Callable callable) {
        this.zzc = new zzbh(this, callable);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj
    protected final void zzj() {
        zzaz zzazVar;
        if (zzm() && (zzazVar = this.zzc) != null) {
            zzazVar.zze();
        }
        this.zzc = null;
    }
}
