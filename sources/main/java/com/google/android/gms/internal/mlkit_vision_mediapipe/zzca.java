package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzca extends zzce {
    private final zzbh zza;
    private final zzbh zzb;
    private final int[] zzc;
    private final int zzd;

    /* synthetic */ zzca(zzbh zzbhVar, zzbh zzbhVar2, zzbz zzbzVar) {
        super(null);
        this.zza = zzbhVar;
        this.zzb = zzbhVar2;
        int zza = zzbhVar2.zza();
        zzdy.zzc(zza <= 28, "metadata size too large");
        int[] iArr = new int[zza];
        this.zzc = iArr;
        long j6 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < iArr.length) {
            zzai zzi = zzi(i6);
            long zzc = zzi.zzc() | j6;
            if (zzc == j6) {
                int i8 = 0;
                while (true) {
                    if (i8 >= i7) {
                        i8 = -1;
                        break;
                    } else if (zzi.equals(zzi(iArr[i8] & 31))) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (i8 != -1) {
                    iArr[i8] = zzi.zzi() ? iArr[i8] | (1 << (i6 + 4)) : i6;
                    i6++;
                    j6 = zzc;
                }
            }
            iArr[i7] = i6;
            i7++;
            i6++;
            j6 = zzc;
        }
        this.zzd = i7;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzce
    public final void zzc(zzbq zzbqVar, Object obj) {
        for (int i6 = 0; i6 < this.zzd; i6++) {
            int i7 = this.zzc[i6];
            zzai zzi = zzi(i7 & 31);
            if (zzi.zzi()) {
                zzbqVar.zzb(zzi, new zzby(this, zzi, i7, null), obj);
            } else {
                zzbqVar.zza(zzi, zzi.zze(zzj(i7)), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzai zzi(int i6) {
        zzbh zzbhVar = this.zza;
        int zza = zzbhVar.zza();
        return i6 >= zza ? this.zzb.zzb(i6 - zza) : zzbhVar.zzb(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzj(int i6) {
        zzbh zzbhVar = this.zza;
        int zza = zzbhVar.zza();
        return i6 >= zza ? this.zzb.zzd(i6 - zza) : zzbhVar.zzd(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzce
    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzce
    public final Set zzb() {
        return new zzbw(this);
    }
}
