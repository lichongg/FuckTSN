package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzac {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();

    protected abstract Object zza();

    public final Object zzb(zzaa zzaaVar, zzbh zzbhVar) {
        Object obj = this.zza.get(zzaaVar);
        if (obj != null) {
            return obj;
        }
        Object zza = zza();
        Object putIfAbsent = this.zza.putIfAbsent(zzaaVar, zza);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        int zza2 = zzbhVar.zza();
        zzab zzabVar = null;
        for (int i6 = 0; i6 < zza2; i6++) {
            if (zzt.zzf.equals(zzbhVar.zzb(i6))) {
                Object zzd = zzbhVar.zzd(i6);
                if (zzd instanceof zzag) {
                    if (zzabVar == null) {
                        zzabVar = new zzab(this, zzaaVar);
                    }
                    ((zzag) zzd).zza();
                }
            }
        }
        return zza;
    }

    protected zzac() {
    }
}
