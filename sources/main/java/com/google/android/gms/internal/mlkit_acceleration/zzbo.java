package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbo extends zzbv {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbv
    public final zzbv zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbv
    public final zzbv zzb(String str) {
        if (str == null) {
            throw new NullPointerException("Null device");
        }
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbv
    public final zzbv zzc(String str) {
        if (str == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbv
    public final zzbv zzd(String str) {
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbv
    public final zzbw zze() {
        String str;
        String str2;
        String str3;
        String str4 = this.zza;
        if (str4 != null && (str = this.zzb) != null && (str2 = this.zzc) != null && (str3 = this.zzd) != null) {
            return new zzbq(str4, str, str2, str3, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" androidSdkVersion");
        }
        if (this.zzb == null) {
            sb.append(" model");
        }
        if (this.zzc == null) {
            sb.append(" device");
        }
        if (this.zzd == null) {
            sb.append(" manufacturer");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    zzbo() {
    }
}
