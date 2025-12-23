package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzbl {
    private static final zzbp zza = new zzbi();
    private static final zzbo zzb = new zzbj();
    private final zzbp zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzbo zzf = null;

    public final zzbl zza(zzbo zzboVar) {
        this.zzf = zzboVar;
        return this;
    }

    public final zzbq zzd() {
        return new zzbn(this, null);
    }

    final void zzg(zzai zzaiVar) {
        zzdy.zza(zzaiVar, "key");
        if (!zzaiVar.zzi()) {
            zzbp zzbpVar = zza;
            zzdy.zza(zzaiVar, "key");
            this.zzd.remove(zzaiVar);
            this.zzc.put(zzaiVar, zzbpVar);
            return;
        }
        zzbo zzboVar = zzb;
        zzdy.zza(zzaiVar, "key");
        zzdy.zzc(zzaiVar.zzi(), "key must be repeating");
        this.zzc.remove(zzaiVar);
        this.zzd.put(zzaiVar, zzboVar);
    }
}
