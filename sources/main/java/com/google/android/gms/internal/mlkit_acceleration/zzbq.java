package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbq extends zzbw {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbw) {
            zzbw zzbwVar = (zzbw) obj;
            if (this.zza.equals(zzbwVar.zza()) && this.zzb.equals(zzbwVar.zzd()) && this.zzc.equals(zzbwVar.zzb()) && this.zzd.equals(zzbwVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode();
    }

    public final String toString() {
        return "AndroidInfo{androidSdkVersion=" + this.zza + ", model=" + this.zzb + ", device=" + this.zzc + ", manufacturer=" + this.zzd + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbw
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbw
    public final String zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbw
    public final String zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbw
    public final String zzd() {
        return this.zzb;
    }

    /* synthetic */ zzbq(String str, String str2, String str3, String str4, zzbp zzbpVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }
}
