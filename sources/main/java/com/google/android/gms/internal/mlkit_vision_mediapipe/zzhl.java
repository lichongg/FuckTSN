package com.google.android.gms.internal.mlkit_vision_mediapipe;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhl extends zzhx {
    private final native long zzh(long j6, Bitmap bitmap);

    public zzhl(zzhp zzhpVar) {
        super(zzhpVar);
    }

    public final zzhv zza(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return zzhv.zzd(zzh(this.zza.zza(), bitmap));
        }
        throw new RuntimeException("bitmap must use ARGB_8888 config.");
    }
}
