package com.google.android.gms.internal.mlkit_vision_mediapipe;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzng {
    public static final /* synthetic */ int zza = 0;

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

    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean zzd(byte[] r6, int r7, int r8) {
        /*
        L0:
            if (r7 >= r8) goto L9
            r0 = r6[r7]
            if (r0 < 0) goto L9
            int r7 = r7 + 1
            goto L0
        L9:
            if (r7 < r8) goto Ld
            goto L7a
        Ld:
            if (r7 >= r8) goto L7a
            int r0 = r7 + 1
            r1 = r6[r7]
            if (r1 >= 0) goto L78
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L29
            if (r0 < r8) goto L1e
            goto L57
        L1e:
            r2 = -62
            if (r1 < r2) goto L76
            int r7 = r7 + 2
            r0 = r6[r0]
            if (r0 <= r3) goto Ld
            goto L76
        L29:
            r4 = -16
            if (r1 >= r4) goto L4f
            int r4 = r8 + (-1)
            if (r0 < r4) goto L36
            int r1 = zza(r6, r0, r8)
            goto L57
        L36:
            int r4 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            r5 = -96
            if (r1 != r2) goto L42
            if (r0 < r5) goto L76
        L42:
            r2 = -19
            if (r1 != r2) goto L48
            if (r0 >= r5) goto L76
        L48:
            int r7 = r7 + 3
            r0 = r6[r4]
            if (r0 <= r3) goto Ld
            goto L76
        L4f:
            int r2 = r8 + (-2)
            if (r0 < r2) goto L5a
            int r1 = zza(r6, r0, r8)
        L57:
            if (r1 == 0) goto L7a
            goto L76
        L5a:
            int r2 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r1 = r1 + r0
            int r0 = r1 >> 30
            if (r0 != 0) goto L76
            int r0 = r7 + 3
            r1 = r6[r2]
            if (r1 > r3) goto L76
            int r7 = r7 + 4
            r0 = r6[r0]
            if (r0 > r3) goto L76
            goto Ld
        L76:
            r6 = 0
            return r6
        L78:
            r7 = r0
            goto Ld
        L7a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzng.zzd(byte[], int, int):boolean");
    }

    static {
        if (zznd.zzx() && zznd.zzy()) {
            int i6 = zziz.zza;
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzng.zzb(java.lang.String, byte[], int, int):int");
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
                                throw new zznf(i7, length2);
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
