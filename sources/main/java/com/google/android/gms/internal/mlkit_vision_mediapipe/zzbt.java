package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzbt {
    private static final zzbp zza = new zzbr();
    private static final zzbo zzb = new zzbs();

    public static zzbl zza(Set set) {
        zzbl zzblVar = new zzbl(zza, null);
        zzblVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzblVar.zzg((zzai) it.next());
        }
        return zzblVar;
    }
}
