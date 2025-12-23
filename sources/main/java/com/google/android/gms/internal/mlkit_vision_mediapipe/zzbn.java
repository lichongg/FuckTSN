package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbn extends zzbq {
    private final Map zza;
    private final Map zzb;
    private final zzbp zzc;
    private final zzbo zzd;

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbq
    protected final void zza(zzai zzaiVar, Object obj, Object obj2) {
        zzbp zzbpVar = (zzbp) this.zza.get(zzaiVar);
        if (zzbpVar != null) {
            zzbpVar.zza(zzaiVar, obj, obj2);
        } else {
            this.zzc.zza(zzaiVar, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbq
    protected final void zzb(zzai zzaiVar, Iterator it, Object obj) {
        zzbo zzboVar = (zzbo) this.zzb.get(zzaiVar);
        if (zzboVar != null) {
            zzboVar.zza(zzaiVar, it, obj);
        } else if (this.zzd != null && !this.zza.containsKey(zzaiVar)) {
            this.zzd.zza(zzaiVar, it, obj);
        } else {
            while (it.hasNext()) {
                zza(zzaiVar, it.next(), obj);
            }
        }
    }

    /* synthetic */ zzbn(zzbl zzblVar, zzbm zzbmVar) {
        Map map;
        Map map2;
        zzbp zzbpVar;
        zzbo zzboVar;
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        HashMap hashMap2 = new HashMap();
        this.zzb = hashMap2;
        map = zzblVar.zzc;
        hashMap.putAll(map);
        map2 = zzblVar.zzd;
        hashMap2.putAll(map2);
        zzbpVar = zzblVar.zze;
        this.zzc = zzbpVar;
        zzboVar = zzblVar.zzf;
        this.zzd = zzboVar;
    }
}
