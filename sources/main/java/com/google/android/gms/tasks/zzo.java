package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzo implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzp zzb;

    zzo(zzp zzpVar, Task task) {
        this.zzb = zzpVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.zzb.zzb;
            Task then = successContinuation.then(this.zza.getResult());
            if (then == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            zzp zzpVar = this.zzb;
            Executor executor = TaskExecutors.zza;
            then.addOnSuccessListener(executor, zzpVar);
            then.addOnFailureListener(executor, this.zzb);
            then.addOnCanceledListener(executor, this.zzb);
        } catch (RuntimeExecutionException e6) {
            if (e6.getCause() instanceof Exception) {
                this.zzb.onFailure((Exception) e6.getCause());
            } else {
                this.zzb.onFailure(e6);
            }
        } catch (CancellationException unused) {
            this.zzb.onCanceled();
        } catch (Exception e7) {
            this.zzb.onFailure(e7);
        }
    }
}
