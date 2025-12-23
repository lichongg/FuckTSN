package com.google.mlkit.vision.mediapipe;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zze {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ Converter zzb;

    zze(zzg zzgVar, TaskCompletionSource taskCompletionSource, Converter converter) {
        this.zza = taskCompletionSource;
        this.zzb = converter;
    }

    public final void zza(List list) {
        try {
            this.zza.setResult(this.zzb.zza(list));
        } catch (MlKitException e6) {
            this.zza.setException(e6);
        }
    }
}
