package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzce {
    private static final zzce zza = new zzbu();

    public abstract int zza();

    public abstract Set zzb();

    public abstract void zzc(zzbq zzbqVar, Object obj);

    /* synthetic */ zzce(zzcd zzcdVar) {
    }

    public static zzce zzh(zzbh zzbhVar, zzbh zzbhVar2) {
        int zza2 = zzbhVar2.zza();
        if (zza2 == 0) {
            return zza;
        }
        zzbz zzbzVar = null;
        byte b6 = 0;
        if (zza2 <= 28) {
            return new zzca(zzbhVar, zzbhVar2, zzbzVar);
        }
        return new zzcc(zzbhVar, zzbhVar2, b6 == true ? 1 : 0);
    }
}
