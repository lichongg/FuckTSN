package com.google.android.odml.image;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(19)
/* loaded from: D:\Downloads\app\classes5.dex */
public class MediaImageExtractor {
    private MediaImageExtractor() {
    }

    @NonNull
    public static Image extract(@NonNull MlImage mlImage) {
        zzg zza = mlImage.zza();
        if (zza.zzb().getStorageType() == 3) {
            return ((zzi) zza).zza();
        }
        throw new IllegalArgumentException("Extract Media Image from an MlImage created by objects other than Media Image is not supported");
    }
}
