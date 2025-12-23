package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzpb {
    private Long zza;
    private zzpo zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;
    private Boolean zzf;
    private Boolean zzg;

    public final zzpb zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzpb zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzpb zzd(zzpo zzpoVar) {
        this.zzb = zzpoVar;
        return this;
    }

    public final zzpb zze(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zzpb zzf(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzpb zzg(Boolean bool) {
        this.zzf = bool;
        return this;
    }

    public final zzpd zzh() {
        return new zzpd(this, null);
    }

    public final zzpb zzc(Long l6) {
        this.zza = Long.valueOf(l6.longValue() & Long.MAX_VALUE);
        return this;
    }
}
