package com.google.android.odml.image;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class BitmapExtractor {
    private BitmapExtractor() {
    }

    @NonNull
    public static Bitmap extract(@NonNull MlImage mlImage) {
        zzg zza = mlImage.zza();
        if (zza.zzb().getStorageType() == 1) {
            return ((zze) zza).zza();
        }
        throw new IllegalArgumentException("Extracting Bitmap from an MlImage created by objects other than Bitmap is not supported");
    }
}
