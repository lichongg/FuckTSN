package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzjn extends zzjm {
    protected final byte[] zza;

    zzjn(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjo) || zzd() != ((zzjo) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjn)) {
            return obj.equals(this);
        }
        zzjn zzjnVar = (zzjn) obj;
        int zzi = zzi();
        int zzi2 = zzjnVar.zzi();
        if (zzi != 0 && zzi2 != 0 && zzi != zzi2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzjnVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzjnVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzjnVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzjnVar.zza;
        zzjnVar.zzc();
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

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    public byte zza(int i6) {
        return this.zza[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    byte zzb(int i6) {
        return this.zza[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    protected final int zze(int i6, int i7, int i8) {
        return zzkz.zzb(i6, this.zza, 0, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    public final zzjo zzf(int i6, int i7) {
        int zzh = zzjo.zzh(0, i7, zzd());
        if (zzh == 0) {
            return zzjo.zzb;
        }
        return new zzjj(this.zza, 0, zzh);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
    final void zzg(zzjg zzjgVar) throws IOException {
        ((zzjt) zzjgVar).zzc(this.zza, 0, zzd());
    }
}
