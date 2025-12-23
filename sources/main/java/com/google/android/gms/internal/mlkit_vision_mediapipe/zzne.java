package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzne {
    static /* bridge */ /* synthetic */ void zzc(byte b6, byte b7, char[] cArr, int i6) {
        if (b6 < -62 || zze(b7)) {
            throw new zzlb("Protocol message had invalid UTF-8.");
        }
        cArr[i6] = (char) (((b6 & Ascii.US) << 6) | (b7 & Utf8.REPLACEMENT_BYTE));
    }

    static /* bridge */ /* synthetic */ boolean zzd(byte b6) {
        return b6 >= 0;
    }

    private static boolean zze(byte b6) {
        return b6 > -65;
    }

    static /* bridge */ /* synthetic */ void zza(byte b6, byte b7, byte b8, byte b9, char[] cArr, int i6) {
        if (!zze(b7) && (((b6 << 28) + (b7 + 112)) >> 30) == 0 && !zze(b8) && !zze(b9)) {
            int i7 = ((b6 & 7) << 18) | ((b7 & Utf8.REPLACEMENT_BYTE) << 12) | ((b8 & Utf8.REPLACEMENT_BYTE) << 6) | (b9 & Utf8.REPLACEMENT_BYTE);
            cArr[i6] = (char) ((i7 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
            cArr[i6 + 1] = (char) ((i7 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            return;
        }
        throw new zzlb("Protocol message had invalid UTF-8.");
    }

    static /* bridge */ /* synthetic */ void zzb(byte b6, byte b7, byte b8, char[] cArr, int i6) {
        if (!zze(b7)) {
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
            if (!zze(b8)) {
                cArr[i6] = (char) (((b6 & 15) << 12) | ((b7 & Utf8.REPLACEMENT_BYTE) << 6) | (b8 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw new zzlb("Protocol message had invalid UTF-8.");
    }
}
