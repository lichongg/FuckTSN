package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = SignedBytes.compare(bArr[i6], bArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    public static byte checkedCast(long j6) {
        byte b6 = (byte) j6;
        Preconditions.checkArgument(((long) b6) == j6, "Out of range: %s", j6);
        return b6;
    }

    public static int compare(byte b6, byte b7) {
        return b6 - b7;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b6 = bArr[0];
        for (int i6 = 1; i6 < bArr.length; i6++) {
            byte b7 = bArr[i6];
            if (b7 > b6) {
                b6 = b7;
            }
        }
        return b6;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b6 = bArr[0];
        for (int i6 = 1; i6 < bArr.length; i6++) {
            byte b7 = bArr[i6];
            if (b7 < b6) {
                b6 = b7;
            }
        }
        return b6;
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte saturatedCast(long j6) {
        if (j6 > 127) {
            return Byte.MAX_VALUE;
        }
        if (j6 < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) j6;
    }

    private SignedBytes() {
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        for (int i6 = 1; i6 < bArr.length; i6++) {
            sb.append(str);
            sb.append((int) bArr[i6]);
        }
        return sb.toString();
    }

    public static void sortDescending(byte[] bArr, int i6, int i7) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i6, i7, bArr.length);
        Arrays.sort(bArr, i6, i7);
        Bytes.reverse(bArr, i6, i7);
    }
}
