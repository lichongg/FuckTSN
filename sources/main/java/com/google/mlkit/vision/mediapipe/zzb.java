package com.google.mlkit.vision.mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zzeg;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzen;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzet;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfc;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhl;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzic;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzb implements MediaPipeInput {
    private final zzfc zza;

    static {
        zzic.zza(zzfc.class, "drishti.InferenceCalculatorOptions.Delegate");
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final long zza() {
        return 0L;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final zzhv zzb(zzhl zzhlVar) {
        return zzhlVar.zze(this.zza);
    }

    zzb(boolean z5, boolean z6, String str, String str2) {
        zzen zza = zzet.zza();
        zza.zzd(true);
        if (z5) {
            zza.zze(3);
            zza.zza(z6);
            zza.zzc(str);
            zza.zzb(str2);
        } else {
            zza.zze(2);
        }
        zzeg zza2 = zzfc.zza();
        zza2.zza(zza);
        this.zza = (zzfc) zza2.zzk();
    }
}
