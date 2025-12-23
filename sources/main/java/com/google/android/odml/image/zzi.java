package com.google.android.odml.image;

import android.media.Image;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(19)
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzi implements zzg {
    private final Image zza;
    private final ImageProperties zzb;

    public final Image zza() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties zzb() {
        return this.zzb;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
        this.zza.close();
    }

    public zzi(Image image) {
        int i6;
        this.zza = image;
        zzb zzbVar = new zzb();
        zzbVar.zzb(3);
        int format = image.getFormat();
        if (Build.VERSION.SDK_INT >= 23) {
            if (format == 42) {
                i6 = 1;
            } else if (format == 41) {
                i6 = 2;
            }
            zzbVar.zza(i6);
            this.zzb = zzbVar.zzc();
        }
        if (format != 35) {
            if (format != 256) {
                i6 = 0;
            } else {
                i6 = 9;
            }
        } else {
            i6 = 7;
        }
        zzbVar.zza(i6);
        this.zzb = zzbVar.zzc();
    }
}
