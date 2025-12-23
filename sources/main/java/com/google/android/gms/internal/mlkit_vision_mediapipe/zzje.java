package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzje {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zzb(byte[] bArr, int i6) {
        int i7 = bArr[i6] & 255;
        int i8 = bArr[i6 + 1] & 255;
        int i9 = bArr[i6 + 2] & 255;
        return ((bArr[i6 + 3] & 255) << 24) | (i8 << 8) | i7 | (i9 << 16);
    }

    static int zzf(byte[] bArr, int i6, zzky zzkyVar, zzjd zzjdVar) throws IOException {
        zzks zzksVar = (zzks) zzkyVar;
        int zzh = zzh(bArr, i6, zzjdVar);
        int i7 = zzjdVar.zza + zzh;
        while (zzh < i7) {
            zzh = zzh(bArr, zzh, zzjdVar);
            zzksVar.zzg(zzjdVar.zza);
        }
        if (zzh == i7) {
            return zzh;
        }
        throw new zzlb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(int i6, byte[] bArr, int i7, int i8, zzmx zzmxVar, zzjd zzjdVar) throws zzlb {
        if ((i6 >>> 3) == 0) {
            throw new zzlb("Protocol message contained an invalid tag (zero).");
        }
        int i9 = i6 & 7;
        if (i9 == 0) {
            int zzk = zzk(bArr, i7, zzjdVar);
            zzmxVar.zzj(i6, Long.valueOf(zzjdVar.zzb));
            return zzk;
        }
        if (i9 == 1) {
            zzmxVar.zzj(i6, Long.valueOf(zzo(bArr, i7)));
            return i7 + 8;
        }
        if (i9 == 2) {
            int zzh = zzh(bArr, i7, zzjdVar);
            int i10 = zzjdVar.zza;
            if (i10 < 0) {
                throw new zzlb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i10 > bArr.length - zzh) {
                throw new zzlb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i10 == 0) {
                zzmxVar.zzj(i6, zzjo.zzb);
            } else {
                zzmxVar.zzj(i6, zzjo.zzj(bArr, zzh, i10));
            }
            return zzh + i10;
        }
        if (i9 != 3) {
            if (i9 != 5) {
                throw new zzlb("Protocol message contained an invalid tag (zero).");
            }
            zzmxVar.zzj(i6, Integer.valueOf(zzb(bArr, i7)));
            return i7 + 4;
        }
        int i11 = (i6 & (-8)) | 4;
        zzmx zzf = zzmx.zzf();
        int i12 = zzjdVar.zze + 1;
        zzjdVar.zze = i12;
        zzp(i12);
        int i13 = 0;
        while (true) {
            if (i7 >= i8) {
                break;
            }
            int zzh2 = zzh(bArr, i7, zzjdVar);
            int i14 = zzjdVar.zza;
            if (i14 == i11) {
                i13 = i14;
                i7 = zzh2;
                break;
            }
            i7 = zzg(i14, bArr, zzh2, i8, zzf, zzjdVar);
            i13 = i14;
        }
        zzjdVar.zze--;
        if (i7 > i8 || i13 != i11) {
            throw new zzlb("Failed to parse the message.");
        }
        zzmxVar.zzj(i6, zzf);
        return i7;
    }

    static int zzh(byte[] bArr, int i6, zzjd zzjdVar) {
        int i7 = i6 + 1;
        byte b6 = bArr[i6];
        if (b6 < 0) {
            return zzi(b6, bArr, i7, zzjdVar);
        }
        zzjdVar.zza = b6;
        return i7;
    }

    static int zzi(int i6, byte[] bArr, int i7, zzjd zzjdVar) {
        byte b6 = bArr[i7];
        int i8 = i7 + 1;
        int i9 = i6 & 127;
        if (b6 >= 0) {
            zzjdVar.zza = i9 | (b6 << 7);
            return i8;
        }
        int i10 = i9 | ((b6 & Byte.MAX_VALUE) << 7);
        int i11 = i7 + 2;
        byte b7 = bArr[i8];
        if (b7 >= 0) {
            zzjdVar.zza = i10 | (b7 << 14);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 14);
        int i13 = i7 + 3;
        byte b8 = bArr[i11];
        if (b8 >= 0) {
            zzjdVar.zza = i12 | (b8 << 21);
            return i13;
        }
        int i14 = i12 | ((b8 & Byte.MAX_VALUE) << 21);
        int i15 = i7 + 4;
        byte b9 = bArr[i13];
        if (b9 >= 0) {
            zzjdVar.zza = i14 | (b9 << 28);
            return i15;
        }
        int i16 = i14 | ((b9 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i17 = i15 + 1;
            if (bArr[i15] >= 0) {
                zzjdVar.zza = i16;
                return i17;
            }
            i15 = i17;
        }
    }

    static int zzj(int i6, byte[] bArr, int i7, int i8, zzky zzkyVar, zzjd zzjdVar) {
        zzks zzksVar = (zzks) zzkyVar;
        int zzh = zzh(bArr, i7, zzjdVar);
        zzksVar.zzg(zzjdVar.zza);
        while (zzh < i8) {
            int zzh2 = zzh(bArr, zzh, zzjdVar);
            if (i6 != zzjdVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzjdVar);
            zzksVar.zzg(zzjdVar.zza);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i6, zzjd zzjdVar) {
        long j6 = bArr[i6];
        int i7 = i6 + 1;
        if (j6 >= 0) {
            zzjdVar.zzb = j6;
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
        zzjdVar.zzb = j7;
        return i8;
    }

    static int zzl(Object obj, zzmi zzmiVar, byte[] bArr, int i6, int i7, int i8, zzjd zzjdVar) throws IOException {
        int i9 = zzjdVar.zze + 1;
        zzjdVar.zze = i9;
        zzp(i9);
        int zzc = ((zzlz) zzmiVar).zzc(obj, bArr, i6, i7, i8, zzjdVar);
        zzjdVar.zze--;
        zzjdVar.zzc = obj;
        return zzc;
    }

    static int zzm(Object obj, zzmi zzmiVar, byte[] bArr, int i6, int i7, zzjd zzjdVar) throws IOException {
        int i8 = i6 + 1;
        int i9 = bArr[i6];
        if (i9 < 0) {
            i8 = zzi(i9, bArr, i8, zzjdVar);
            i9 = zzjdVar.zza;
        }
        int i10 = i8;
        if (i9 < 0 || i9 > i7 - i10) {
            throw new zzlb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i11 = zzjdVar.zze + 1;
        zzjdVar.zze = i11;
        zzp(i11);
        int i12 = i10 + i9;
        zzmiVar.zzh(obj, bArr, i10, i12, zzjdVar);
        zzjdVar.zze--;
        zzjdVar.zzc = obj;
        return i12;
    }

    static int zzn(int i6, byte[] bArr, int i7, int i8, zzjd zzjdVar) throws zzlb {
        if ((i6 >>> 3) == 0) {
            throw new zzlb("Protocol message contained an invalid tag (zero).");
        }
        int i9 = i6 & 7;
        if (i9 == 0) {
            return zzk(bArr, i7, zzjdVar);
        }
        if (i9 == 1) {
            return i7 + 8;
        }
        if (i9 == 2) {
            return zzh(bArr, i7, zzjdVar) + zzjdVar.zza;
        }
        if (i9 != 3) {
            if (i9 == 5) {
                return i7 + 4;
            }
            throw new zzlb("Protocol message contained an invalid tag (zero).");
        }
        int i10 = (i6 & (-8)) | 4;
        int i11 = 0;
        while (i7 < i8) {
            i7 = zzh(bArr, i7, zzjdVar);
            i11 = zzjdVar.zza;
            if (i11 == i10) {
                break;
            }
            i7 = zzn(i11, bArr, i7, i8, zzjdVar);
        }
        if (i7 > i8 || i11 != i10) {
            throw new zzlb("Failed to parse the message.");
        }
        return i7;
    }

    static long zzo(byte[] bArr, int i6) {
        return (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 3] & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((bArr[i6 + 6] & 255) << 48) | ((bArr[i6 + 7] & 255) << 56);
    }

    private static void zzp(int i6) throws zzlb {
        if (i6 >= zzb) {
            throw new zzlb("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    static int zza(byte[] bArr, int i6, zzjd zzjdVar) throws zzlb {
        int zzh = zzh(bArr, i6, zzjdVar);
        int i7 = zzjdVar.zza;
        if (i7 >= 0) {
            if (i7 <= bArr.length - zzh) {
                if (i7 == 0) {
                    zzjdVar.zzc = zzjo.zzb;
                    return zzh;
                }
                zzjdVar.zzc = zzjo.zzj(bArr, zzh, i7);
                return zzh + i7;
            }
            throw new zzlb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzlb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static int zzc(zzmi zzmiVar, byte[] bArr, int i6, int i7, int i8, zzjd zzjdVar) throws IOException {
        Object zze = zzmiVar.zze();
        int zzl = zzl(zze, zzmiVar, bArr, i6, i7, i8, zzjdVar);
        zzmiVar.zzf(zze);
        zzjdVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzmi zzmiVar, byte[] bArr, int i6, int i7, zzjd zzjdVar) throws IOException {
        Object zze = zzmiVar.zze();
        int zzm = zzm(zze, zzmiVar, bArr, i6, i7, zzjdVar);
        zzmiVar.zzf(zze);
        zzjdVar.zzc = zze;
        return zzm;
    }

    static int zze(zzmi zzmiVar, int i6, byte[] bArr, int i7, int i8, zzky zzkyVar, zzjd zzjdVar) throws IOException {
        int zzd = zzd(zzmiVar, bArr, i7, i8, zzjdVar);
        zzkyVar.add(zzjdVar.zzc);
        while (zzd < i8) {
            int zzh = zzh(bArr, zzd, zzjdVar);
            if (i6 != zzjdVar.zza) {
                break;
            }
            zzd = zzd(zzmiVar, bArr, zzh, i8, zzjdVar);
            zzkyVar.add(zzjdVar.zzc);
        }
        return zzd;
    }
}
