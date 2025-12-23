package com.google.mlkit.vision.mediapipe;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhl;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzh implements MediaPipeInput {
    private final Bitmap zza;
    private final long zzb;

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.mediapipe.MediaPipeInput
    public final zzhv zzb(zzhl zzhlVar) {
        Bitmap.Config config = this.zza.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config == config2) {
            return zzhlVar.zza(this.zza);
        }
        if (Log.isLoggable("MediaPipeInputBitmap", 3)) {
            "Input bitmap is not ARGB_8888 config. Converting it to ARGB_8888 from ".concat(String.valueOf(this.zza.getConfig()));
        }
        Bitmap bitmap = this.zza;
        return zzhlVar.zza(bitmap.copy(config2, bitmap.isMutable()));
    }

    zzh(Bitmap bitmap, long j6) {
        this.zza = bitmap;
        this.zzb = j6;
    }
}
