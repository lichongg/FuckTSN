package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zza extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private int zzd;
    private String zze;
    private byte zzf;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zze
    public final zze zza(int i6) {
        this.zzc = i6;
        this.zzf = (byte) (this.zzf | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zze
    public final zze zzb(int i6) {
        this.zzd = i6;
        this.zzf = (byte) (this.zzf | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zze
    public final zze zzc(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zze
    public final zze zzd(String str) {
        this.zze = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zze
    public final zze zze(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zze
    public final zzf zzf() {
        String str;
        String str2;
        String str3;
        if (this.zzf == 3 && (str = this.zza) != null && (str2 = this.zzb) != null && (str3 = this.zze) != null) {
            return new zzc(str, str2, this.zzc, this.zzd, str3, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" rendererName");
        }
        if (this.zzb == null) {
            sb.append(" versionString");
        }
        if ((this.zzf & 1) == 0) {
            sb.append(" majorVersion");
        }
        if ((this.zzf & 2) == 0) {
            sb.append(" minorVersion");
        }
        if (this.zze == null) {
            sb.append(" vendorName");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    zza() {
    }
}
