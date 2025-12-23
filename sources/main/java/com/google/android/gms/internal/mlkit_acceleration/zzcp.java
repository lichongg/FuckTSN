package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzcp extends zzco {
    protected final byte[] zza;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcs) || zzd() != ((zzcs) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzcp)) {
            return obj.equals(this);
        }
        zzcp zzcpVar = (zzcp) obj;
        int zzk = zzk();
        int zzk2 = zzcpVar.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzcpVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzcpVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzcpVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzcpVar.zza;
        zzcpVar.zzc();
        int i6 = 0;
        int i7 = 0;
        while (i6 < zzd) {
            if (bArr[i6] != bArr2[i7]) {
                return false;
            }
            i6++;
            i7++;
        }
        return true;
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    public byte zza(int i6) {
        return this.zza[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    byte zzb(int i6) {
        return this.zza[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    protected final int zze(int i6, int i7, int i8) {
        return zzeb.zzb(i6, this.zza, 0, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    zzcp(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    public final zzcs zzf(int i6, int i7) {
        int zzj = zzcs.zzj(0, i7, zzd());
        if (zzj == 0) {
            return zzcs.zzb;
        }
        return new zzcm(this.zza, 0, zzj);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    final void zzh(zzci zzciVar) throws IOException {
        ((zzda) zzciVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcs
    public final boolean zzi() {
        return zzgs.zzf(this.zza, 0, zzd());
    }
}
