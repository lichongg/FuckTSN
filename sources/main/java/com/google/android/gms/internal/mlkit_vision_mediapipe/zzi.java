package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzi extends zzao {
    private static final zzac zza = new zzg();
    private final AtomicLong zzb = new AtomicLong(-1);

    @NullableDecl
    static zzao zza(zzbh zzbhVar, zzaa zzaaVar, long j6) {
        if (((zzh) zzbhVar.zzc(zzt.zzd)) == null) {
            return null;
        }
        zzi zziVar = (zzi) zza.zzb(zzaaVar, zzbhVar);
        zzdy.zzc(j6 >= 0, "timestamp cannot be negative");
        long j7 = zziVar.zzb.get();
        if (j7 >= 0) {
            throw null;
        }
        zziVar.zzb.compareAndSet(j7, -j6);
        return zziVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzao
    public final void zzb() {
        this.zzb.set(Math.max(-this.zzb.get(), 0L));
    }

    zzi() {
    }
}
