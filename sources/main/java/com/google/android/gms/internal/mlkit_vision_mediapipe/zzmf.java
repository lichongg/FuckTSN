package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzmf {
    public static final /* synthetic */ int zza = 0;
    private static final zzmf zzb = new zzmf();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzmj zzc = new zzlo();

    public static zzmf zza() {
        return zzb;
    }

    public final zzmi zzb(Class cls) {
        zzkz.zzc(cls, "messageType");
        zzmi zzmiVar = (zzmi) this.zzd.get(cls);
        if (zzmiVar != null) {
            return zzmiVar;
        }
        zzmi zza2 = this.zzc.zza(cls);
        zzkz.zzc(cls, "messageType");
        zzmi zzmiVar2 = (zzmi) this.zzd.putIfAbsent(cls, zza2);
        return zzmiVar2 == null ? zza2 : zzmiVar2;
    }

    private zzmf() {
    }
}
