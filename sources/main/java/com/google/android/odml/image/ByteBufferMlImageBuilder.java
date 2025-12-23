package com.google.android.odml.image;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ByteBufferMlImageBuilder {
    private final ByteBuffer zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private int zze = 0;
    private Rect zzf;

    @NonNull
    public MlImage build() {
        return new MlImage(new zzf(this.zza, this.zzd), this.zze, this.zzf, 0L, this.zzb, this.zzc);
    }

    public ByteBufferMlImageBuilder(@NonNull ByteBuffer byteBuffer, int i6, int i7, int i8) {
        this.zza = byteBuffer;
        this.zzb = i6;
        this.zzc = i7;
        this.zzd = i8;
        this.zzf = new Rect(0, 0, i6, i7);
    }

    @NonNull
    public ByteBufferMlImageBuilder setRotation(int i6) {
        MlImage.zzc(i6);
        this.zze = i6;
        return this;
    }
}
