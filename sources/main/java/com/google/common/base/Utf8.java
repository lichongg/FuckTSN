package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Utf8 {
    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormed(byte[] bArr, int i6, int i7) {
        int i8 = i7 + i6;
        Preconditions.checkPositionIndexes(i6, i8, bArr.length);
        while (i6 < i8) {
            if (bArr[i6] < 0) {
                return isWellFormedSlowPath(bArr, i6, i8);
            }
            i6++;
        }
        return true;
    }

    private static boolean isWellFormedSlowPath(byte[] bArr, int i6, int i7) {
        byte b6;
        while (i6 < i7) {
            int i8 = i6 + 1;
            byte b7 = bArr[i6];
            if (b7 < 0) {
                if (b7 < -32) {
                    if (i8 != i7 && b7 >= -62) {
                        i6 += 2;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return false;
                }
                if (b7 < -16) {
                    int i9 = i6 + 2;
                    if (i9 < i7 && (b6 = bArr[i8]) <= -65 && ((b7 != -32 || b6 >= -96) && (b7 != -19 || -96 > b6))) {
                        i6 += 3;
                        if (bArr[i9] > -65) {
                        }
                    }
                    return false;
                }
                if (i6 + 3 >= i7) {
                    return false;
                }
                int i10 = i6 + 2;
                byte b8 = bArr[i8];
                if (b8 <= -65 && (((b7 << 28) + (b8 + 112)) >> 30) == 0) {
                    int i11 = i6 + 3;
                    if (bArr[i10] <= -65) {
                        i6 += 4;
                        if (bArr[i11] > -65) {
                        }
                    }
                }
                return false;
            }
            i6 = i8;
        }
        return true;
    }

    private static String unpairedSurrogateMsg(int i6) {
        return "Unpaired surrogate at index " + i6;
    }

    private Utf8() {
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length && charSequence.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (true) {
            if (i6 < length) {
                char charAt = charSequence.charAt(i6);
                if (charAt < 2048) {
                    i7 += (127 - charAt) >>> 31;
                    i6++;
                } else {
                    i7 += encodedLengthGeneral(charSequence, i6);
                    break;
                }
            } else {
                break;
            }
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i7 + IjkMediaMeta.AV_CH_WIDE_RIGHT));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int i7 = 0;
        while (i6 < length) {
            char charAt = charSequence.charAt(i6);
            if (charAt < 2048) {
                i7 += (127 - charAt) >>> 31;
            } else {
                i7 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i6) != charAt) {
                        i6++;
                    } else {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i6));
                    }
                }
            }
            i6++;
        }
        return i7;
    }
}
