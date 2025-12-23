package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzsb {
    private zzpd zza;
    private zzox zzb;
    private zzsk zzc;
    private Long zzd;
    private Long zze;
    private Long zzf;

    public final zzsb zzc(zzsk zzskVar) {
        this.zzc = zzskVar;
        return this;
    }

    public final zzsb zzd(zzox zzoxVar) {
        this.zzb = zzoxVar;
        return this;
    }

    public final zzsb zze(zzpd zzpdVar) {
        this.zza = zzpdVar;
        return this;
    }

    public final zzsd zzi() {
        return new zzsd(this, null);
    }

    public final zzsb zzf(Long l6) {
        this.zzd = Long.valueOf(l6.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzsb zzg(Long l6) {
        this.zze = Long.valueOf(l6.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzsb zzh(Long l6) {
        this.zzf = Long.valueOf(l6.longValue() & Long.MAX_VALUE);
        return this;
    }
}
