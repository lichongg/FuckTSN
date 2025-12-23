package com.google.mlkit.vision.mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhl;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzj implements MediaPipeInput {
    private final ByteBuffer zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final long zza() {
        return this.zzd;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final zzhv zzb(zzhl zzhlVar) {
        return zzhlVar.zzf(this.zza, this.zzb, this.zzc);
    }

    zzj(ByteBuffer byteBuffer, int i6, int i7, long j6) {
        this.zza = byteBuffer;
        this.zzb = i6;
        this.zzc = i7;
        this.zzd = j6;
    }
}
