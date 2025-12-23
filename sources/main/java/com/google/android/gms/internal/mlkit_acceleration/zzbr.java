package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbr extends zzbx {
    private String zza;
    private int zzb;
    private int zzc;
    private byte zzd;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbx
    public final zzbx zza(int i6) {
        this.zzb = i6;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbx
    public final zzbx zzb(int i6) {
        this.zzc = i6;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbx
    public final zzbx zzc(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzbx
    public final zzby zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzbt(str, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" rendererName");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" majorVersion");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" minorVersion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    zzbr() {
    }
}
