package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzgd {
    abstract int zza(Object obj);

    abstract int zzb(Object obj);

    abstract Object zzc(Object obj);

    abstract Object zzd(Object obj);

    abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i6, int i7);

    abstract void zzi(Object obj, int i6, long j6);

    abstract void zzj(Object obj, int i6, Object obj2);

    abstract void zzk(Object obj, int i6, zzcs zzcsVar);

    abstract void zzl(Object obj, int i6, long j6);

    abstract void zzm(Object obj);

    abstract void zzn(Object obj, Object obj2);

    abstract void zzo(Object obj, Object obj2);

    abstract void zzp(Object obj, zzgv zzgvVar) throws IOException;

    abstract boolean zzr(zzfl zzflVar);

    zzgd() {
    }

    final boolean zzq(Object obj, zzfl zzflVar) throws IOException {
        int zzd = zzflVar.zzd();
        int i6 = zzd >>> 3;
        int i7 = zzd & 7;
        if (i7 != 0) {
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 != 3) {
                        if (i7 != 4) {
                            if (i7 == 5) {
                                zzh(obj, i6, zzflVar.zzf());
                                return true;
                            }
                            throw zzed.zza();
                        }
                        return false;
                    }
                    Object zzf = zzf();
                    int i8 = i6 << 3;
                    while (zzflVar.zzc() != Integer.MAX_VALUE && zzq(zzf, zzflVar)) {
                    }
                    if ((4 | i8) == zzflVar.zzd()) {
                        zzg(zzf);
                        zzj(obj, i6, zzf);
                        return true;
                    }
                    throw zzed.zzb();
                }
                zzk(obj, i6, zzflVar.zzp());
                return true;
            }
            zzi(obj, i6, zzflVar.zzk());
            return true;
        }
        zzl(obj, i6, zzflVar.zzl());
        return true;
    }
}
