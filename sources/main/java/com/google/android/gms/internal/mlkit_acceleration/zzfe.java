package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfe implements zzfm {
    private final zzfa zza;
    private final zzgd zzb;
    private final boolean zzc;
    private final zzdj zzd;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzi(Object obj, byte[] bArr, int i6, int i7, zzcf zzcfVar) throws IOException {
        zzdv zzdvVar = (zzdv) obj;
        if (zzdvVar.zzc == zzge.zzc()) {
            zzdvVar.zzc = zzge.zzf();
        }
        throw null;
    }

    static zzfe zzc(zzgd zzgdVar, zzdj zzdjVar, zzfa zzfaVar) {
        return new zzfe(zzgdVar, zzdjVar, zzfaVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final int zza(Object obj) {
        zzgd zzgdVar = this.zzb;
        int zzb = zzgdVar.zzb(zzgdVar.zzd(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final Object zze() {
        zzfa zzfaVar = this.zza;
        return zzfaVar instanceof zzdv ? ((zzdv) zzfaVar).zzB() : zzfaVar.zzF().zzn();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzg(Object obj, Object obj2) {
        zzfo.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzh(Object obj, zzfl zzflVar, zzdi zzdiVar) throws IOException {
        boolean zzO;
        zzgd zzgdVar = this.zzb;
        Object zzc = zzgdVar.zzc(obj);
        zzdj zzdjVar = this.zzd;
        zzdn zzb = zzdjVar.zzb(obj);
        while (zzflVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzflVar.zzd();
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        Object zzc2 = zzdjVar.zzc(zzdiVar, this.zza, zzd >>> 3);
                        if (zzc2 != null) {
                            zzdjVar.zzf(zzflVar, zzc2, zzdiVar, zzb);
                        } else {
                            zzO = zzgdVar.zzq(zzc, zzflVar);
                        }
                    } else {
                        zzO = zzflVar.zzO();
                    }
                    if (!zzO) {
                        break;
                    }
                } else {
                    Object obj2 = null;
                    zzcs zzcsVar = null;
                    int i6 = 0;
                    while (zzflVar.zzc() != Integer.MAX_VALUE) {
                        int zzd2 = zzflVar.zzd();
                        if (zzd2 == 16) {
                            i6 = zzflVar.zzj();
                            obj2 = zzdjVar.zzc(zzdiVar, this.zza, i6);
                        } else if (zzd2 == 26) {
                            if (obj2 != null) {
                                zzdjVar.zzf(zzflVar, obj2, zzdiVar, zzb);
                            } else {
                                zzcsVar = zzflVar.zzp();
                            }
                        } else if (!zzflVar.zzO()) {
                            break;
                        }
                    }
                    if (zzflVar.zzd() != 12) {
                        throw zzed.zzb();
                    }
                    if (zzcsVar != null) {
                        if (obj2 != null) {
                            zzdjVar.zzg(zzcsVar, obj2, zzdiVar, zzb);
                        } else {
                            zzgdVar.zzk(zzc, i6, zzcsVar);
                        }
                    }
                }
            } finally {
                zzgdVar.zzn(obj, zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzj(Object obj, zzgv zzgvVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final boolean zzk(Object obj, Object obj2) {
        zzgd zzgdVar = this.zzb;
        if (!zzgdVar.zzd(obj).equals(zzgdVar.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final boolean zzl(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    private zzfe(zzgd zzgdVar, zzdj zzdjVar, zzfa zzfaVar) {
        this.zzb = zzgdVar;
        this.zzc = zzdjVar.zzh(zzfaVar);
        this.zzd = zzdjVar;
        this.zza = zzfaVar;
    }
}
