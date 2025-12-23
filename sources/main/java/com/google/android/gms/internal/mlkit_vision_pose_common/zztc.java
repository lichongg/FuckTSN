package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zztc {
    private Long zza;
    private zzbd zzb;
    private zzbd zzc;
    private zzbd zzd;
    private Integer zze;

    public final zztc zze(zzbd zzbdVar) {
        this.zzb = zzbdVar;
        return this;
    }

    public final zztc zzf(Integer num) {
        this.zze = num;
        return this;
    }

    public final zztc zzg(zzbd zzbdVar) {
        this.zzc = zzbdVar;
        return this;
    }

    public final zztc zzh(zzbd zzbdVar) {
        this.zzd = zzbdVar;
        return this;
    }

    public final zztf zzi() {
        return new zztf(this, null);
    }

    public final zztc zzd(Long l6) {
        this.zza = Long.valueOf(l6.longValue() & Long.MAX_VALUE);
        return this;
    }
}
