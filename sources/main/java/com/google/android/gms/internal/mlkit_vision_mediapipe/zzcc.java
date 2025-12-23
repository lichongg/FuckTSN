package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcc extends zzce {
    private final Map zza;

    /* synthetic */ zzcc(zzbh zzbhVar, zzbh zzbhVar2, zzcb zzcbVar) {
        super(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzd(linkedHashMap, zzbhVar);
        zzd(linkedHashMap, zzbhVar2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((zzai) entry.getKey()).zzi()) {
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.zza = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void zzd(Map map, zzbh zzbhVar) {
        for (int i6 = 0; i6 < zzbhVar.zza(); i6++) {
            zzai zzb = zzbhVar.zzb(i6);
            Object obj = map.get(zzb);
            if (zzb.zzi()) {
                List list = (List) obj;
                if (list == null) {
                    list = new ArrayList();
                    map.put(zzb, list);
                }
                list.add(zzb.zze(zzbhVar.zzd(i6)));
            } else {
                map.put(zzb, zzb.zze(zzbhVar.zzd(i6)));
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzce
    public final int zza() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzce
    public final Set zzb() {
        return this.zza.keySet();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzce
    public final void zzc(zzbq zzbqVar, Object obj) {
        for (Map.Entry entry : this.zza.entrySet()) {
            zzai zzaiVar = (zzai) entry.getKey();
            Object value = entry.getValue();
            if (zzaiVar.zzi()) {
                zzbqVar.zzb(zzaiVar, ((List) value).iterator(), obj);
            } else {
                zzbqVar.zza(zzaiVar, value, obj);
            }
        }
    }
}
