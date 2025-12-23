package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzs extends zzai {
    zzs(String str, Class cls, boolean z5) {
        super("tags", cls, false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzai
    public final /* bridge */ /* synthetic */ void zzb(Object obj, zzah zzahVar) {
        for (Map.Entry entry : ((zzdl) obj).zzd().entrySet()) {
            if (((Set) entry.getValue()).isEmpty()) {
                zzahVar.zza((String) entry.getKey(), null);
            } else {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    zzahVar.zza((String) entry.getKey(), it.next());
                }
            }
        }
    }
}
