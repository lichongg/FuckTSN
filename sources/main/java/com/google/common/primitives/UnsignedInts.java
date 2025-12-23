package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class UnsignedInts {
    static final long INT_MASK = 4294967295L;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int i7 = iArr[i6];
                int i8 = iArr2[i6];
                if (i7 != i8) {
                    return UnsignedInts.compare(i7, i8);
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i6 = 1; i6 < iArr.length; i6++) {
            int flip2 = flip(iArr[i6]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i6 = 1; i6 < iArr.length; i6++) {
            int flip2 = flip(iArr[i6]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static long toLong(int i6) {
        return i6 & 4294967295L;
    }

    public static String toString(int i6) {
        return toString(i6, 10);
    }

    public static int checkedCast(long j6) {
        Preconditions.checkArgument((j6 >> 32) == 0, "out of range: %s", j6);
        return (int) j6;
    }

    static int flip(int i6) {
        return i6 ^ Integer.MIN_VALUE;
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str, int i6) {
        Preconditions.checkNotNull(str);
        long parseLong = Long.parseLong(str, i6);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i6 + " is not in the range of an unsigned integer");
    }

    public static int saturatedCast(long j6) {
        if (j6 <= 0) {
            return 0;
        }
        if (j6 >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            return -1;
        }
        return (int) j6;
    }

    public static String toString(int i6, int i7) {
        return Long.toString(i6 & 4294967295L, i7);
    }

    private UnsignedInts() {
    }

    public static int compare(int i6, int i7) {
        return Ints.compare(flip(i6), flip(i7));
    }

    @CanIgnoreReturnValue
    public static int decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedInt(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e6) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e6);
            throw numberFormatException;
        }
    }

    public static int divide(int i6, int i7) {
        return (int) (toLong(i6) / toLong(i7));
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(toString(iArr[0]));
        for (int i6 = 1; i6 < iArr.length; i6++) {
            sb.append(str);
            sb.append(toString(iArr[i6]));
        }
        return sb.toString();
    }

    public static int remainder(int i6, int i7) {
        return (int) (toLong(i6) % toLong(i7));
    }

    public static void sort(int[] iArr, int i6, int i7) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i6, i7, iArr.length);
        for (int i8 = i6; i8 < i7; i8++) {
            iArr[i8] = flip(iArr[i8]);
        }
        Arrays.sort(iArr, i6, i7);
        while (i6 < i7) {
            iArr[i6] = flip(iArr[i6]);
            i6++;
        }
    }

    public static void sortDescending(int[] iArr, int i6, int i7) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i6, i7, iArr.length);
        for (int i8 = i6; i8 < i7; i8++) {
            iArr[i8] = Integer.MAX_VALUE ^ iArr[i8];
        }
        Arrays.sort(iArr, i6, i7);
        while (i6 < i7) {
            iArr[i6] = iArr[i6] ^ Integer.MAX_VALUE;
            i6++;
        }
    }
}
