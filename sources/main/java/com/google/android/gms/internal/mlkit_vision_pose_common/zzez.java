package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzez {
    private zzfc zza;
    private Integer zzb;
    private zzoq zzc;

    public final zzez zzb(zzoq zzoqVar) {
        this.zzc = zzoqVar;
        return this;
    }

    public final zzez zzc(zzfc zzfcVar) {
        this.zza = zzfcVar;
        return this;
    }

    public final zzfe zze() {
        return new zzfe(this, null);
    }

    public final zzez zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }
}
