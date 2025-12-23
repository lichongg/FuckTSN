package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzct extends zzcz {
    private static final zzct zza = new zzct(zzcz.zze());
    private final AtomicReference zzb;

    public static final zzct zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzcz
    public final zzbh zza() {
        return ((zzcz) this.zzb.get()).zza();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzcz
    public final zzdl zzc() {
        return ((zzcz) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzcz
    public final boolean zzd(String str, Level level, boolean z5) {
        ((zzcz) this.zzb.get()).zzd(str, level, z5);
        return false;
    }

    zzct(zzcz zzczVar) {
        this.zzb = new AtomicReference(zzczVar);
    }
}
