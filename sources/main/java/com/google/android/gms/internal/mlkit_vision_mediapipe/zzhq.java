package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhq implements zzhm {
    private long zza;

    private static native void zze(long j6);

    private static native void zzf(long j6);

    private static native void zzg(long j6);

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzhm
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzhm
    public final void zzb() {
        long j6 = this.zza;
        if (j6 != 0) {
            zze(j6);
            this.zza = 0L;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzhm
    public final void zzc() {
        long j6 = this.zza;
        if (j6 != 0) {
            zzf(j6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzhm
    public final void zzd() {
        long j6 = this.zza;
        if (j6 != 0) {
            zzg(j6);
        }
    }

    public zzhq(long j6) {
        this.zza = j6;
    }
}
