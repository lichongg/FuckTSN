package com.google.mlkit.vision.mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhl;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzi implements MediaPipeInput {
    private final boolean zza;
    private final long zzb;

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final zzhv zzb(zzhl zzhlVar) {
        return zzhlVar.zzb(this.zza);
    }

    zzi(boolean z5, long j6) {
        this.zza = z5;
        this.zzb = j6;
    }
}
