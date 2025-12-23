package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                long j6 = jArr[i6];
                long j7 = jArr2[i6];
                if (j6 != j7) {
                    return UnsignedLongs.compare(j6, j7);
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ParseOverflowDetection {
        static final long[] maxValueDivs = new long[37];
        static final int[] maxValueMods = new int[37];
        static final int[] maxSafeDigits = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i6 = 2; i6 <= 36; i6++) {
                long j6 = i6;
                maxValueDivs[i6] = UnsignedLongs.divide(-1L, j6);
                maxValueMods[i6] = (int) UnsignedLongs.remainder(-1L, j6);
                maxSafeDigits[i6] = bigInteger.toString(i6).length() - 1;
            }
        }

        static boolean overflowInParse(long j6, int i6, int i7) {
            if (j6 < 0) {
                return true;
            }
            long j7 = maxValueDivs[i7];
            if (j6 < j7) {
                return false;
            }
            return j6 > j7 || i6 > maxValueMods[i7];
        }

        private ParseOverflowDetection() {
        }
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i6 = 1; i6 < jArr.length; i6++) {
            long flip2 = flip(jArr[i6]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i6 = 1; i6 < jArr.length; i6++) {
            long flip2 = flip(jArr[i6]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j6) {
        return toString(j6, 10);
    }

    public static long divide(long j6, long j7) {
        if (j7 < 0) {
            return compare(j6, j7) < 0 ? 0L : 1L;
        }
        if (j6 >= 0) {
            return j6 / j7;
        }
        long j8 = ((j6 >>> 1) / j7) << 1;
        return j8 + (compare(j6 - (j8 * j7), j7) < 0 ? 0 : 1);
    }

    private static long flip(long j6) {
        return j6 ^ Long.MIN_VALUE;
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i6) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i6 < 2 || i6 > 36) {
            throw new NumberFormatException("illegal radix: " + i6);
        }
        int i7 = ParseOverflowDetection.maxSafeDigits[i6] - 1;
        long j6 = 0;
        for (int i8 = 0; i8 < str.length(); i8++) {
            int digit = Character.digit(str.charAt(i8), i6);
            if (digit == -1) {
                throw new NumberFormatException(str);
            }
            if (i8 > i7 && ParseOverflowDetection.overflowInParse(j6, digit, i6)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j6 = (j6 * i6) + digit;
        }
        return j6;
    }

    public static long remainder(long j6, long j7) {
        if (j7 < 0) {
            return compare(j6, j7) < 0 ? j6 : j6 - j7;
        }
        if (j6 >= 0) {
            return j6 % j7;
        }
        long j8 = j6 - ((((j6 >>> 1) / j7) << 1) * j7);
        if (compare(j8, j7) < 0) {
            j7 = 0;
        }
        return j8 - j7;
    }

    public static String toString(long j6, int i6) {
        Preconditions.checkArgument(i6 >= 2 && i6 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i6);
        if (j6 == 0) {
            return "0";
        }
        if (j6 > 0) {
            return Long.toString(j6, i6);
        }
        int i7 = 64;
        char[] cArr = new char[64];
        int i8 = i6 - 1;
        if ((i6 & i8) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i6);
            do {
                i7--;
                cArr[i7] = Character.forDigit(((int) j6) & i8, i6);
                j6 >>>= numberOfTrailingZeros;
            } while (j6 != 0);
        } else {
            long divide = (i6 & 1) == 0 ? (j6 >>> 1) / (i6 >>> 1) : divide(j6, i6);
            long j7 = i6;
            int i9 = 63;
            cArr[63] = Character.forDigit((int) (j6 - (divide * j7)), i6);
            while (divide > 0) {
                i9--;
                cArr[i9] = Character.forDigit((int) (divide % j7), i6);
                divide /= j7;
            }
            i7 = i9;
        }
        return new String(cArr, i7, 64 - i7);
    }

    private UnsignedLongs() {
    }

    public static int compare(long j6, long j7) {
        return Longs.compare(flip(j6), flip(j7));
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e6) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e6);
            throw numberFormatException;
        }
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i6 = 1; i6 < jArr.length; i6++) {
            sb.append(str);
            sb.append(toString(jArr[i6]));
        }
        return sb.toString();
    }

    public static void sort(long[] jArr, int i6, int i7) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i6, i7, jArr.length);
        for (int i8 = i6; i8 < i7; i8++) {
            jArr[i8] = flip(jArr[i8]);
        }
        Arrays.sort(jArr, i6, i7);
        while (i6 < i7) {
            jArr[i6] = flip(jArr[i6]);
            i6++;
        }
    }

    public static void sortDescending(long[] jArr, int i6, int i7) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i6, i7, jArr.length);
        for (int i8 = i6; i8 < i7; i8++) {
            jArr[i8] = Long.MAX_VALUE ^ jArr[i8];
        }
        Arrays.sort(jArr, i6, i7);
        while (i6 < i7) {
            jArr[i6] = jArr[i6] ^ Long.MAX_VALUE;
            i6++;
        }
    }
}
