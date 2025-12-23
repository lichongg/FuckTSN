package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzd extends zzg {
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzg) {
            zzg zzgVar = (zzg) obj;
            if (this.zza.equals(zzgVar.zzc()) && this.zzb.equals(zzgVar.zze()) && this.zzc == zzgVar.zza() && this.zzd == zzgVar.zzb() && this.zze.equals(zzgVar.zzd())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc) * 1000003) ^ this.zzd) * 1000003) ^ this.zze.hashCode();
    }

    public final String toString() {
        return "GpuInfo{rendererName=" + this.zza + ", versionString=" + this.zzb + ", majorVersion=" + this.zzc + ", minorVersion=" + this.zzd + ", vendorName=" + this.zze + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzg
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzg
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzg
    public final String zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzg
    public final String zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzg
    public final String zze() {
        return this.zzb;
    }

    /* synthetic */ zzd(String str, String str2, int i6, int i7, String str3, zzc zzcVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i6;
        this.zzd = i7;
        this.zze = str3;
    }
}
