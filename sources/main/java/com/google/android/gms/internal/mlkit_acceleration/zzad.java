package com.google.android.gms.internal.mlkit_acceleration;

import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzad extends zzi {
    final CharSequence zzb;
    final zzp zzc;
    final boolean zzd;
    int zze = 0;
    int zzf;

    abstract int zzc(int i6);

    abstract int zzd(int i6);

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzi
    @CheckForNull
    protected final /* bridge */ /* synthetic */ Object zza() {
        int zzd;
        int zzc;
        int i6 = this.zze;
        while (true) {
            int i7 = this.zze;
            if (i7 == -1) {
                zzb();
                return null;
            }
            zzd = zzd(i7);
            if (zzd == -1) {
                zzd = this.zzb.length();
                this.zze = -1;
                zzc = -1;
            } else {
                zzc = zzc(zzd);
                this.zze = zzc;
            }
            if (zzc == i6) {
                int i8 = zzc + 1;
                this.zze = i8;
                if (i8 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                while (i6 < zzd && this.zzc.zza(this.zzb.charAt(i6))) {
                    i6++;
                }
                while (zzd > i6) {
                    int i9 = zzd - 1;
                    if (!this.zzc.zza(this.zzb.charAt(i9))) {
                        break;
                    }
                    zzd = i9;
                }
                if (!this.zzd || i6 != zzd) {
                    break;
                }
                i6 = this.zze;
            }
        }
        int i10 = this.zzf;
        if (i10 == 1) {
            zzd = this.zzb.length();
            this.zze = -1;
            while (zzd > i6) {
                int i11 = zzd - 1;
                if (!this.zzc.zza(this.zzb.charAt(i11))) {
                    break;
                }
                zzd = i11;
            }
        } else {
            this.zzf = i10 - 1;
        }
        return this.zzb.subSequence(i6, zzd).toString();
    }

    protected zzad(zzaf zzafVar, CharSequence charSequence) {
        zzp zzpVar;
        boolean z5;
        zzpVar = zzafVar.zza;
        this.zzc = zzpVar;
        z5 = zzafVar.zzb;
        this.zzd = z5;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }
}
