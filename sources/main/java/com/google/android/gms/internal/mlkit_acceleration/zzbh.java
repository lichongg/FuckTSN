package com.google.android.gms.internal.mlkit_acceleration;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbh extends zzaz {
    final /* synthetic */ zzbi zza;
    private final Callable zzb;

    zzbh(zzbi zzbiVar, Callable callable) {
        this.zza = zzbiVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaz
    final Object zza() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaz
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaz
    final void zzc(Throwable th) {
        this.zza.zzl(th);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaz
    final void zzd(Object obj) {
        this.zza.zzk(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaz
    final boolean zzf() {
        return this.zza.isDone();
    }
}
