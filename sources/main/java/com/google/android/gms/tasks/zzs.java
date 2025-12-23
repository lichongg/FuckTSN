package com.google.android.gms.tasks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzs implements OnTokenCanceledListener {
    final /* synthetic */ TaskCompletionSource zza;

    zzs(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        zzw zzwVar;
        zzwVar = this.zza.zza;
        zzwVar.zzc();
    }
}
