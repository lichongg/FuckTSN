package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzin {
    private Long zza;
    private zzio zzb;
    private zzii zzc;
    private Integer zzd;
    private Integer zze;
    private Integer zzf;
    private Integer zzg;

    public final zzin zzd(zzii zziiVar) {
        this.zzc = zziiVar;
        return this;
    }

    public final zzin zzf(zzio zzioVar) {
        this.zzb = zzioVar;
        return this;
    }

    public final zziq zzj() {
        return new zziq(this, null);
    }

    public final zzin zzb(Long l6) {
        this.zza = Long.valueOf(l6.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzin zzc(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzin zze(Integer num) {
        this.zzf = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzin zzg(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzin zzh(Integer num) {
        this.zzg = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }
}
