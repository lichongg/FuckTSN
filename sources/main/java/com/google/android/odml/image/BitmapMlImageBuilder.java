package com.google.android.odml.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class BitmapMlImageBuilder {
    private final Bitmap zza;
    private int zzb;
    private Rect zzc;

    public BitmapMlImageBuilder(@NonNull Context context, @NonNull Uri uri) throws IOException {
        this(MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri));
    }

    public BitmapMlImageBuilder(@NonNull Bitmap bitmap) {
        this.zza = bitmap;
        this.zzb = 0;
        this.zzc = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    @NonNull
    public MlImage build() {
        return new MlImage(new zze(this.zza), this.zzb, this.zzc, 0L, this.zza.getWidth(), this.zza.getHeight());
    }

    @NonNull
    public BitmapMlImageBuilder setRotation(int i6) {
        MlImage.zzc(i6);
        this.zzb = i6;
        return this;
    }
}
