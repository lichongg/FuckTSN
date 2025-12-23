package com.google.mlkit.vision.mediapipe.facemesh;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhy;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzno;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.mediapipe.Converter;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class BlazeFaceHolderConverter implements Converter<FaceMeshListHolder> {
    private final int zza;
    private final int zzb;

    @KeepForSdk
    public BlazeFaceHolderConverter(int i6, int i7) {
        this.zza = i6;
        this.zzb = i7;
    }

    @Override // com.google.mlkit.vision.mediapipe.Converter
    @NonNull
    public final /* bridge */ /* synthetic */ Object zza(@NonNull List list) throws MlKitException {
        boolean z5 = true;
        if (list.size() != 1) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "The output of face mesh detection contains more than one packet, which is not expected.");
        return new FaceMeshListHolder(zzhy.zzc((zzhv) list.get(0), zzno.zzc()), this.zza, this.zzb);
    }
}
