package com.google.mlkit.vision.mediapipe.facemesh;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfq;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhj;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhy;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzii;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.mediapipe.Converter;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class FaceMeshHolderConverter implements Converter<FaceMeshListHolder> {
    private final int zza;
    private final int zzb;

    @KeepForSdk
    public FaceMeshHolderConverter(int i6, int i7) {
        this.zza = i6;
        this.zzb = i7;
    }

    @Override // com.google.mlkit.vision.mediapipe.Converter
    @NonNull
    public final /* bridge */ /* synthetic */ Object zza(@NonNull List list) throws MlKitException {
        boolean z5;
        int size = list.size();
        String format = String.format("The output of face detection contains %s packet, expecting 3 packets.", Integer.valueOf(list.size()));
        if (size == 3) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, format);
        return new FaceMeshListHolder(zzhy.zzc((zzhv) list.get(0), zzfq.zzc()), zzhy.zzc((zzhv) list.get(1), zzhj.zzg()), zzhy.zzc((zzhv) list.get(2), zzii.zzd()), this.zza, this.zzb);
    }
}
