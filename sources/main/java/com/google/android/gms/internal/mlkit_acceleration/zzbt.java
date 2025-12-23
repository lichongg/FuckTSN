package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbt extends zzby {
    private final String zza;
    private final int zzb;
    private final int zzc;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzby) {
            zzby zzbyVar = (zzby) obj;
            if (this.zza.equals(zzbyVar.zzc()) && this.zzb == zzbyVar.zza() && this.zzc == zzbyVar.zzb()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        return "GpuInfo{rendererName=" + this.zza + ", majorVersion=" + this.zzb + ", minorVersion=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzby
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzby
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzby
    public final String zzc() {
        return this.zza;
    }

    /* synthetic */ zzbt(String str, int i6, int i7, zzbs zzbsVar) {
        this.zza = str;
        this.zzb = i6;
        this.zzc = i7;
    }
}
