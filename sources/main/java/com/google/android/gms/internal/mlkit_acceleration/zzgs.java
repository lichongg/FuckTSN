package com.google.android.gms.internal.mlkit_acceleration;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzgs {
    private static final zzgp zza;

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i6, int i7) {
        int i8 = i7 - i6;
        byte b6 = bArr[i6 - 1];
        if (i8 == 0) {
            if (b6 <= -12) {
                return b6;
            }
            return -1;
        }
        if (i8 == 1) {
            byte b7 = bArr[i6];
            if (b6 > -12 || b7 > -65) {
                return -1;
            }
            return (b7 << 8) ^ b6;
        }
        if (i8 != 2) {
            throw new AssertionError();
        }
        byte b8 = bArr[i6];
        byte b9 = bArr[i6 + 1];
        if (b6 > -12 || b8 > -65 || b9 > -65) {
            return -1;
        }
        return (b9 << 16) ^ ((b8 << 8) ^ b6);
    }

    static String zzd(byte[] bArr, int i6, int i7) throws zzed {
        int i8;
        int length = bArr.length;
        if ((((length - i6) - i7) | i6 | i7) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i6), Integer.valueOf(i7)));
        }
        int i9 = i6 + i7;
        char[] cArr = new char[i7];
        int i10 = 0;
        while (i6 < i9) {
            byte b6 = bArr[i6];
            if (!zzgo.zzd(b6)) {
                break;
            }
            i6++;
            cArr[i10] = (char) b6;
            i10++;
        }
        int i11 = i10;
        while (i6 < i9) {
            int i12 = i6 + 1;
            byte b7 = bArr[i6];
            if (zzgo.zzd(b7)) {
                cArr[i11] = (char) b7;
                i11++;
                i6 = i12;
                while (i6 < i9) {
                    byte b8 = bArr[i6];
                    if (zzgo.zzd(b8)) {
                        i6++;
                        cArr[i11] = (char) b8;
                        i11++;
                    }
                }
            } else {
                if (b7 < -32) {
                    if (i12 >= i9) {
                        throw zzed.zzd();
                    }
                    i8 = i11 + 1;
                    i6 += 2;
                    zzgo.zzc(b7, bArr[i12], cArr, i11);
                } else if (b7 < -16) {
                    if (i12 >= i9 - 1) {
                        throw zzed.zzd();
                    }
                    i8 = i11 + 1;
                    int i13 = i6 + 2;
                    i6 += 3;
                    zzgo.zzb(b7, bArr[i12], bArr[i13], cArr, i11);
                } else {
                    if (i12 >= i9 - 2) {
                        throw zzed.zzd();
                    }
                    byte b9 = bArr[i12];
                    int i14 = i6 + 3;
                    byte b10 = bArr[i6 + 2];
                    i6 += 4;
                    zzgo.zza(b7, b9, b10, bArr[i14], cArr, i11);
                    i11 += 2;
                }
                i11 = i8;
            }
        }
        return new String(cArr, 0, i11);
    }

    static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzf(byte[] bArr, int i6, int i7) {
        return zza.zzb(bArr, i6, i7);
    }

    static {
        if (zzgn.zzx() && zzgn.zzy()) {
            int i6 = zzce.zza;
        }
        zza = new zzgq();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int zzb(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzgs.zzb(java.lang.String, byte[], int, int):int");
    }

    static int zzc(String str) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        while (i7 < length && str.charAt(i7) < 128) {
            i7++;
        }
        int i8 = length;
        while (true) {
            if (i7 >= length) {
                break;
            }
            char charAt = str.charAt(i7);
            if (charAt < 2048) {
                i8 += (127 - charAt) >>> 31;
                i7++;
            } else {
                int length2 = str.length();
                while (i7 < length2) {
                    char charAt2 = str.charAt(i7);
                    if (charAt2 < 2048) {
                        i6 += (127 - charAt2) >>> 31;
                    } else {
                        i6 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i7) >= 65536) {
                                i7++;
                            } else {
                                throw new zzgr(i7, length2);
                            }
                        }
                    }
                    i7++;
                }
                i8 += i6;
            }
        }
        if (i8 >= length) {
            return i8;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i8 + IjkMediaMeta.AV_CH_WIDE_RIGHT));
    }
}
