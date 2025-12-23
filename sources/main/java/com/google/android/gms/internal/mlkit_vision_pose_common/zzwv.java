package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzwv {

    @Nullable
    private static zzwu zza;

    public static synchronized zzwk zza(zzwd zzwdVar) {
        zzwk zzwkVar;
        synchronized (zzwv.class) {
            try {
                if (zza == null) {
                    zza = new zzwu(null);
                }
                zzwkVar = (zzwk) zza.get(zzwdVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzwkVar;
    }

    public static synchronized zzwk zzb(String str) {
        zzwk zza2;
        synchronized (zzwv.class) {
            zza2 = zza(zzwd.zzd(str).zzd());
        }
        return zza2;
    }
}
