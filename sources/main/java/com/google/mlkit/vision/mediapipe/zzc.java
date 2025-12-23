package com.google.mlkit.vision.mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zzeg;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzeu;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzev;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfc;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhl;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzic;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzc implements MediaPipeInput {
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

    zzc(String str, String str2) {
        zzeg zza = zzfc.zza();
        zzeu zza2 = zzev.zza();
        zza2.zza(str);
        zza2.zzb(str2);
        zza.zzb(zza2);
        this.zza = (zzfc) zza.zzk();
    }
}
