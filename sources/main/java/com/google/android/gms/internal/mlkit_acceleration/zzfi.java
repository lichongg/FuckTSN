package com.google.android.gms.internal.mlkit_acceleration;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfi {
    private static final zzfi zza = new zzfi();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzfn zzb = new zzes();

    public static zzfi zza() {
        return zza;
    }

    public final zzfm zzb(Class cls) {
        zzeb.zzc(cls, "messageType");
        zzfm zzfmVar = (zzfm) this.zzc.get(cls);
        if (zzfmVar != null) {
            return zzfmVar;
        }
        zzfm zza2 = this.zzb.zza(cls);
        zzeb.zzc(cls, "messageType");
        zzfm zzfmVar2 = (zzfm) this.zzc.putIfAbsent(cls, zza2);
        return zzfmVar2 == null ? zza2 : zzfmVar2;
    }

    private zzfi() {
    }
}
