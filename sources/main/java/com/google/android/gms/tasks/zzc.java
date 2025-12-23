package com.google.android.gms.tasks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzc implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzd zzb;

    zzc(zzd zzdVar, Task task) {
        this.zzb = zzdVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw zzwVar;
        zzw zzwVar2;
        zzw zzwVar3;
        Continuation continuation;
        zzw zzwVar4;
        zzw zzwVar5;
        if (this.zza.isCanceled()) {
            zzwVar5 = this.zzb.zzc;
            zzwVar5.zzc();
            return;
        }
        try {
            continuation = this.zzb.zzb;
            Object then = continuation.then(this.zza);
            zzwVar4 = this.zzb.zzc;
            zzwVar4.zzb(then);
        } catch (RuntimeExecutionException e6) {
            if (e6.getCause() instanceof Exception) {
                zzwVar3 = this.zzb.zzc;
                zzwVar3.zza((Exception) e6.getCause());
            } else {
                zzwVar2 = this.zzb.zzc;
                zzwVar2.zza(e6);
            }
        } catch (Exception e7) {
            zzwVar = this.zzb.zzc;
            zzwVar.zza(e7);
        }
    }
}
