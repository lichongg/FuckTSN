package com.google.android.odml.image;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ByteBufferExtractor {
    private ByteBufferExtractor() {
    }

    @NonNull
    public static ByteBuffer extract(@NonNull MlImage mlImage) {
        zzg zza = mlImage.zza();
        if (zza.zzb().getStorageType() == 2) {
            return ((zzf) zza).zza().asReadOnlyBuffer();
        }
        throw new IllegalArgumentException("Extract ByteBuffer from an MlImage created by objects other than Bytebuffer is not supported");
    }
}
