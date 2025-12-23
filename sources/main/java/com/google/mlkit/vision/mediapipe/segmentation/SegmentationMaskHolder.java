package com.google.mlkit.vision.mediapipe.segmentation;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class SegmentationMaskHolder {
    private final ByteBuffer zza;
    private final int zzb;
    private final int zzc;

    @NonNull
    @KeepForSdk
    public ByteBuffer getBuffer() {
        return this.zza;
    }

    @KeepForSdk
    public int getHeight() {
        return this.zzc;
    }

    @KeepForSdk
    public int getWidth() {
        return this.zzb;
    }

    @KeepForSdk
    public SegmentationMaskHolder(@NonNull ByteBuffer byteBuffer, int i6, int i7) {
        this.zza = byteBuffer;
        this.zzb = i6;
        this.zzc = i7;
    }
}
