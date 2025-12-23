package com.google.android.odml.image;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zze implements zzg {
    private final Bitmap zza;
    private final ImageProperties zzb;

    public final Bitmap zza() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties zzb() {
        return this.zzb;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
        this.zza.recycle();
    }

    public zze(Bitmap bitmap) {
        int i6;
        this.zza = bitmap;
        zzb zzbVar = new zzb();
        int i7 = zzd.zza[bitmap.getConfig().ordinal()];
        if (i7 != 1) {
            if (i7 != 2) {
                i6 = 0;
            } else {
                i6 = 1;
            }
        } else {
            i6 = 8;
        }
        zzbVar.zza(i6);
        zzbVar.zzb(1);
        this.zzb = zzbVar.zzc();
    }
}
