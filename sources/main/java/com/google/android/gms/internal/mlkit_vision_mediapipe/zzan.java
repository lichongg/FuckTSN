package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzan {
    private static final zzac zza = new zzal();
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final AtomicInteger zzc = new AtomicInteger();

    private zzan() {
    }

    static int zza(zzao zzaoVar, zzaa zzaaVar, zzbh zzbhVar) {
        zzan zzanVar = (zzan) zza.zzb(zzaaVar, zzbhVar);
        int incrementAndGet = zzanVar.zzc.incrementAndGet();
        if (zzaoVar == zzao.zzc || !zzanVar.zzb.compareAndSet(false, true)) {
            return -1;
        }
        try {
            zzaoVar.zzb();
            zzanVar.zzb.set(false);
            zzanVar.zzc.addAndGet(-incrementAndGet);
            return incrementAndGet - 1;
        } catch (Throwable th) {
            zzanVar.zzb.set(false);
            throw th;
        }
    }

    /* synthetic */ zzan(zzam zzamVar) {
    }
}
