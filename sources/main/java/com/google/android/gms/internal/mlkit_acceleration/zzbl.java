package com.google.android.gms.internal.mlkit_acceleration;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbl {
    static void zzc(byte b6, byte b7, char[] cArr, int i6) throws IllegalArgumentException {
        if (b6 < -62) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }
        if (zzg(b7)) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        }
        cArr[i6] = (char) (((b6 & Ascii.US) << 6) | (b7 & Utf8.REPLACEMENT_BYTE));
    }

    static boolean zzd(byte b6) {
        return b6 >= 0;
    }

    static boolean zze(byte b6) {
        return b6 < -16;
    }

    static boolean zzf(byte b6) {
        return b6 < -32;
    }

    private static boolean zzg(byte b6) {
        return b6 > -65;
    }

    static void zza(byte b6, byte b7, byte b8, byte b9, char[] cArr, int i6) throws IllegalArgumentException {
        if (!zzg(b7) && (((b6 << 28) + (b7 + 112)) >> 30) == 0 && !zzg(b8) && !zzg(b9)) {
            int i7 = ((b6 & 7) << 18) | ((b7 & Utf8.REPLACEMENT_BYTE) << 12) | ((b8 & Utf8.REPLACEMENT_BYTE) << 6) | (b9 & Utf8.REPLACEMENT_BYTE);
            cArr[i6] = (char) ((i7 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
            cArr[i6 + 1] = (char) ((i7 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            return;
        }
        throw new IllegalArgumentException("Invalid UTF-8");
    }

    static void zzb(byte b6, byte b7, byte b8, char[] cArr, int i6) throws IllegalArgumentException {
        if (!zzg(b7)) {
            if (b6 == -32) {
                if (b7 >= -96) {
                    b6 = -32;
                }
            }
            if (b6 == -19) {
                if (b7 < -96) {
                    b6 = -19;
                }
            }
            if (!zzg(b8)) {
                cArr[i6] = (char) (((b6 & 15) << 12) | ((b7 & Utf8.REPLACEMENT_BYTE) << 6) | (b8 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw new IllegalArgumentException("Invalid UTF-8");
    }
}
