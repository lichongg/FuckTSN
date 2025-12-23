package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzhv {
    private long zza;

    private final native long zzf(long j6);

    private final native long zzg(long j6);

    private final native void zzh(long j6);

    public static zzhv zzd(long j6) {
        return new zzhv(j6);
    }

    public long zza() {
        return this.zza;
    }

    public final long zzb() {
        return zzg(this.zza);
    }

    public final zzhv zzc() {
        return new zzhv(zzf(this.zza));
    }

    public void zze() {
        long j6 = this.zza;
        if (j6 != 0) {
            zzh(j6);
            this.zza = 0L;
        }
    }

    private zzhv(long j6) {
        this.zza = j6;
    }
}
