package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzac {
    private final zzaf zza;
    private final zzaf zzb;

    public final Map zza(CharSequence charSequence) {
        Iterator zza;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : this.zza.zzf(charSequence)) {
            zza = r2.zzc.zza(this.zzb, str);
            zzv.zzb(zza.hasNext(), "Chunk [%s] is not a valid entry", str);
            String str2 = (String) zza.next();
            zzv.zzb(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
            zzv.zzb(zza.hasNext(), "Chunk [%s] is not a valid entry", str);
            linkedHashMap.put(str2, (String) zza.next());
            zzv.zzb(!zza.hasNext(), "Chunk [%s] is not a valid entry", str);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* synthetic */ zzac(zzaf zzafVar, zzaf zzafVar2, zzab zzabVar) {
        this.zza = zzafVar;
        this.zzb = zzafVar2;
    }
}
