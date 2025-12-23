package com.google.mlkit.vision.mediapipe.segmentation;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhy;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.mediapipe.Converter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class SegmentationMaskConverter implements Converter<SegmentationMaskHolder> {
    @Override // com.google.mlkit.vision.mediapipe.Converter
    @NonNull
    public final /* bridge */ /* synthetic */ Object zza(@NonNull List list) throws MlKitException {
        boolean z5 = true;
        if (list.size() != 1) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "The output of Segmentation contains more than one packet, which is not expected.");
        zzhv zzhvVar = (zzhv) list.get(0);
        int zzb = zzhy.zzb(zzhvVar);
        int zza = zzhy.zza(zzhvVar);
        ByteBuffer order = ByteBuffer.allocateDirect(zzb * zza * 4).order(ByteOrder.nativeOrder());
        zzhy.zzd(zzhvVar, order);
        return new SegmentationMaskHolder(order, zzb, zza);
    }
}
