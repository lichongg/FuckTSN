package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzz implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ Callable zzb;

    zzz(zzw zzwVar, Callable callable) {
        this.zza = zzwVar;
        this.zzb = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.zzb(this.zzb.call());
        } catch (Exception e6) {
            this.zza.zza(e6);
        } catch (Throwable th) {
            this.zza.zza(new RuntimeException(th));
        }
    }
}
