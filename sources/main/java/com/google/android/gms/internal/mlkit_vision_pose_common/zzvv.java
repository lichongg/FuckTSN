package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzvv {
    private final zzvk zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;

    public final long zza() {
        return this.zzd;
    }

    public final zzvk zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public zzvv(zzvk zzvkVar, String str, String str2, long j6) {
        this.zza = zzvkVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j6;
    }

    public final boolean zze() {
        if (System.currentTimeMillis() >= this.zzd) {
            return true;
        }
        return false;
    }
}
