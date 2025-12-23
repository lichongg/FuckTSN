package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcg {
    static int zzb(byte[] bArr, int i6) {
        int i7 = bArr[i6] & 255;
        int i8 = bArr[i6 + 1] & 255;
        int i9 = bArr[i6 + 2] & 255;
        return ((bArr[i6 + 3] & 255) << 24) | (i8 << 8) | i7 | (i9 << 16);
    }

    static int zzf(byte[] bArr, int i6, zzea zzeaVar, zzcf zzcfVar) throws IOException {
        zzdw zzdwVar = (zzdw) zzeaVar;
        int zzh = zzh(bArr, i6, zzcfVar);
        int i7 = zzcfVar.zza + zzh;
        while (zzh < i7) {
            zzh = zzh(bArr, zzh, zzcfVar);
            zzdwVar.zzf(zzcfVar.zza);
        }
        if (zzh == i7) {
            return zzh;
        }
        throw zzed.zzj();
    }

    static int zzg(int i6, byte[] bArr, int i7, int i8, zzge zzgeVar, zzcf zzcfVar) throws zzed {
        if ((i6 >>> 3) == 0) {
            throw zzed.zzc();
        }
        int i9 = i6 & 7;
        if (i9 == 0) {
            int zzk = zzk(bArr, i7, zzcfVar);
            zzgeVar.zzj(i6, Long.valueOf(zzcfVar.zzb));
            return zzk;
        }
        if (i9 == 1) {
            zzgeVar.zzj(i6, Long.valueOf(zzn(bArr, i7)));
            return i7 + 8;
        }
        if (i9 == 2) {
            int zzh = zzh(bArr, i7, zzcfVar);
            int i10 = zzcfVar.zza;
            if (i10 < 0) {
                throw zzed.zzf();
            }
            if (i10 > bArr.length - zzh) {
                throw zzed.zzj();
            }
            if (i10 == 0) {
                zzgeVar.zzj(i6, zzcs.zzb);
            } else {
                zzgeVar.zzj(i6, zzcs.zzl(bArr, zzh, i10));
            }
            return zzh + i10;
        }
        if (i9 != 3) {
            if (i9 != 5) {
                throw zzed.zzc();
            }
            zzgeVar.zzj(i6, Integer.valueOf(zzb(bArr, i7)));
            return i7 + 4;
        }
        int i11 = (i6 & (-8)) | 4;
        zzge zzf = zzge.zzf();
        int i12 = 0;
        while (true) {
            if (i7 >= i8) {
                break;
            }
            int zzh2 = zzh(bArr, i7, zzcfVar);
            i12 = zzcfVar.zza;
            if (i12 == i11) {
                i7 = zzh2;
                break;
            }
            i7 = zzg(i12, bArr, zzh2, i8, zzf, zzcfVar);
        }
        if (i7 > i8 || i12 != i11) {
            throw zzed.zzg();
        }
        zzgeVar.zzj(i6, zzf);
        return i7;
    }

    static int zzh(byte[] bArr, int i6, zzcf zzcfVar) {
        int i7 = i6 + 1;
        byte b6 = bArr[i6];
        if (b6 < 0) {
            return zzi(b6, bArr, i7, zzcfVar);
        }
        zzcfVar.zza = b6;
        return i7;
    }

    static int zzi(int i6, byte[] bArr, int i7, zzcf zzcfVar) {
        byte b6 = bArr[i7];
        int i8 = i7 + 1;
        int i9 = i6 & 127;
        if (b6 >= 0) {
            zzcfVar.zza = i9 | (b6 << 7);
            return i8;
        }
        int i10 = i9 | ((b6 & Byte.MAX_VALUE) << 7);
        int i11 = i7 + 2;
        byte b7 = bArr[i8];
        if (b7 >= 0) {
            zzcfVar.zza = i10 | (b7 << 14);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 14);
        int i13 = i7 + 3;
        byte b8 = bArr[i11];
        if (b8 >= 0) {
            zzcfVar.zza = i12 | (b8 << 21);
            return i13;
        }
        int i14 = i12 | ((b8 & Byte.MAX_VALUE) << 21);
        int i15 = i7 + 4;
        byte b9 = bArr[i13];
        if (b9 >= 0) {
            zzcfVar.zza = i14 | (b9 << 28);
            return i15;
        }
        int i16 = i14 | ((b9 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i17 = i15 + 1;
            if (bArr[i15] >= 0) {
                zzcfVar.zza = i16;
                return i17;
            }
            i15 = i17;
        }
    }

    static int zzj(int i6, byte[] bArr, int i7, int i8, zzea zzeaVar, zzcf zzcfVar) {
        zzdw zzdwVar = (zzdw) zzeaVar;
        int zzh = zzh(bArr, i7, zzcfVar);
        zzdwVar.zzf(zzcfVar.zza);
        while (zzh < i8) {
            int zzh2 = zzh(bArr, zzh, zzcfVar);
            if (i6 != zzcfVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzcfVar);
            zzdwVar.zzf(zzcfVar.zza);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i6, zzcf zzcfVar) {
        long j6 = bArr[i6];
        int i7 = i6 + 1;
        if (j6 >= 0) {
            zzcfVar.zzb = j6;
            return i7;
        }
        int i8 = i6 + 2;
        byte b6 = bArr[i7];
        long j7 = (j6 & 127) | ((b6 & Byte.MAX_VALUE) << 7);
        int i9 = 7;
        while (b6 < 0) {
            int i10 = i8 + 1;
            i9 += 7;
            j7 |= (r10 & Byte.MAX_VALUE) << i9;
            b6 = bArr[i8];
            i8 = i10;
        }
        zzcfVar.zzb = j7;
        return i8;
    }

    static int zzl(Object obj, zzfm zzfmVar, byte[] bArr, int i6, int i7, int i8, zzcf zzcfVar) throws IOException {
        int zzc = ((zzfd) zzfmVar).zzc(obj, bArr, i6, i7, i8, zzcfVar);
        zzcfVar.zzc = obj;
        return zzc;
    }

    static int zzm(Object obj, zzfm zzfmVar, byte[] bArr, int i6, int i7, zzcf zzcfVar) throws IOException {
        int i8 = i6 + 1;
        int i9 = bArr[i6];
        if (i9 < 0) {
            i8 = zzi(i9, bArr, i8, zzcfVar);
            i9 = zzcfVar.zza;
        }
        int i10 = i8;
        if (i9 < 0 || i9 > i7 - i10) {
            throw zzed.zzj();
        }
        int i11 = i10 + i9;
        zzfmVar.zzi(obj, bArr, i10, i11, zzcfVar);
        zzcfVar.zzc = obj;
        return i11;
    }

    static long zzn(byte[] bArr, int i6) {
        return (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 3] & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((bArr[i6 + 6] & 255) << 48) | ((bArr[i6 + 7] & 255) << 56);
    }

    static int zza(byte[] bArr, int i6, zzcf zzcfVar) throws zzed {
        int zzh = zzh(bArr, i6, zzcfVar);
        int i7 = zzcfVar.zza;
        if (i7 >= 0) {
            if (i7 <= bArr.length - zzh) {
                if (i7 == 0) {
                    zzcfVar.zzc = zzcs.zzb;
                    return zzh;
                }
                zzcfVar.zzc = zzcs.zzl(bArr, zzh, i7);
                return zzh + i7;
            }
            throw zzed.zzj();
        }
        throw zzed.zzf();
    }

    static int zzc(zzfm zzfmVar, byte[] bArr, int i6, int i7, int i8, zzcf zzcfVar) throws IOException {
        Object zze = zzfmVar.zze();
        int zzl = zzl(zze, zzfmVar, bArr, i6, i7, i8, zzcfVar);
        zzfmVar.zzf(zze);
        zzcfVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzfm zzfmVar, byte[] bArr, int i6, int i7, zzcf zzcfVar) throws IOException {
        Object zze = zzfmVar.zze();
        int zzm = zzm(zze, zzfmVar, bArr, i6, i7, zzcfVar);
        zzfmVar.zzf(zze);
        zzcfVar.zzc = zze;
        return zzm;
    }

    static int zze(zzfm zzfmVar, int i6, byte[] bArr, int i7, int i8, zzea zzeaVar, zzcf zzcfVar) throws IOException {
        int zzd = zzd(zzfmVar, bArr, i7, i8, zzcfVar);
        zzeaVar.add(zzcfVar.zzc);
        while (zzd < i8) {
            int zzh = zzh(bArr, zzd, zzcfVar);
            if (i6 != zzcfVar.zza) {
                break;
            }
            zzd = zzd(zzfmVar, bArr, zzh, i8, zzcfVar);
            zzeaVar.add(zzcfVar.zzc);
        }
        return zzd;
    }
}
