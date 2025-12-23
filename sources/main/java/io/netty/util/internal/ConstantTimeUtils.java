package io.netty.util.internal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ConstantTimeUtils {
    public static int equalsConstantTime(int i6, int i7) {
        int i8 = (i6 ^ i7) ^ (-1);
        int i9 = i8 & (i8 >> 16);
        int i10 = i9 & (i9 >> 8);
        int i11 = i10 & (i10 >> 4);
        int i12 = i11 & (i11 >> 2);
        return i12 & (i12 >> 1) & 1;
    }

    public static int equalsConstantTime(long j6, long j7) {
        long j8 = (j6 ^ j7) ^ (-1);
        long j9 = j8 & (j8 >> 32);
        long j10 = j9 & (j9 >> 16);
        long j11 = j10 & (j10 >> 8);
        long j12 = j11 & (j11 >> 4);
        long j13 = j12 & (j12 >> 2);
        return (int) (j13 & (j13 >> 1) & 1);
    }

    private ConstantTimeUtils() {
    }

    public static int equalsConstantTime(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        int i9 = i8 + i6;
        int i10 = 0;
        while (i6 < i9) {
            i10 |= bArr[i6] ^ bArr2[i7];
            i6++;
            i7++;
        }
        return equalsConstantTime(i10, 0);
    }

    public static int equalsConstantTime(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            i6 |= charSequence.charAt(i7) ^ charSequence2.charAt(i7);
        }
        return equalsConstantTime(i6, 0);
    }
}
