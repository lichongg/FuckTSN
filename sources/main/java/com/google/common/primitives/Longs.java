package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AsciiDigits {
        private static final byte[] asciiDigits;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i6 = 0; i6 <= 9; i6++) {
                bArr[i6 + 48] = (byte) i6;
            }
            for (int i7 = 0; i7 <= 26; i7++) {
                byte b6 = (byte) (i7 + 10);
                bArr[i7 + 65] = b6;
                bArr[i7 + 97] = b6;
            }
            asciiDigits = bArr;
        }

        static int digit(char c6) {
            if (c6 < 128) {
                return asciiDigits[c6];
            }
            return -1;
        }

        private AsciiDigits() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = Longs.compare(jArr[i6], jArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != longArrayAsList.array[longArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        LongArrayAsList(long[] jArr, int i6, int i7) {
            this.array = jArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Long.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Longs.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Long) || (indexOf = Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Long) || (lastIndexOf = Longs.lastIndexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long set(int i6, Long l6) {
            Preconditions.checkElementIndex(i6, size());
            long[] jArr = this.array;
            int i7 = this.start;
            long j6 = jArr[i7 + i6];
            jArr[i7 + i6] = ((Long) Preconditions.checkNotNull(l6)).longValue();
            return Long.valueOf(j6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i6 = this.start;
            while (true) {
                i6++;
                if (i6 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i6]);
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            long[] jArr = this.array;
            int i8 = this.start;
            return new LongArrayAsList(jArr, i6 + i8, i8 + i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = new LongConverter();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Long l6) {
            return l6.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Long doForward(String str) {
            return Long.decode(str);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }

        private LongConverter() {
        }
    }

    public static List<Long> asList(long... jArr) {
        return jArr.length == 0 ? Collections.EMPTY_LIST : new LongArrayAsList(jArr);
    }

    public static long[] concat(long[]... jArr) {
        int i6 = 0;
        for (long[] jArr2 : jArr) {
            i6 += jArr2.length;
        }
        long[] jArr3 = new long[i6];
        int i7 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, i7, jArr4.length);
            i7 += jArr4.length;
        }
        return jArr3;
    }

    public static boolean contains(long[] jArr, long j6) {
        for (long j7 : jArr) {
            if (j7 == j6) {
                return true;
            }
        }
        return false;
    }

    public static long[] ensureCapacity(long[] jArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return jArr.length < i6 ? Arrays.copyOf(jArr, i6 + i7) : jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, byte b13) {
        return ((b7 & 255) << 48) | ((b6 & 255) << 56) | ((b8 & 255) << 40) | ((b9 & 255) << 32) | ((b10 & 255) << 24) | ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255);
    }

    public static int indexOf(long[] jArr, long j6) {
        return indexOf(jArr, j6, 0, jArr.length);
    }

    public static int lastIndexOf(long[] jArr, long j6) {
        return lastIndexOf(jArr, j6, 0, jArr.length);
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j6 = jArr[0];
        for (int i6 = 1; i6 < jArr.length; i6++) {
            long j7 = jArr[i6];
            if (j7 > j6) {
                j6 = j7;
            }
        }
        return j6;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j6 = jArr[0];
        for (int i6 = 1; i6 < jArr.length; i6++) {
            long j7 = jArr[i6];
            if (j7 < j6) {
                j6 = j7;
            }
        }
        return j6;
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    @Beta
    @NullableDecl
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    public static int compare(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 > j7 ? 1 : 0;
    }

    @Beta
    public static long constrainToRange(long j6, long j7, long j8) {
        Preconditions.checkArgument(j7 <= j8, "min (%s) must be less than or equal to max (%s)", j7, j8);
        return Math.min(Math.max(j6, j7), j8);
    }

    public static int hashCode(long j6) {
        return (int) (j6 ^ (j6 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(long[] jArr, long j6, int i6, int i7) {
        while (i6 < i7) {
            if (jArr[i6] == j6) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(long[] jArr, long j6, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (jArr[i8] == j6) {
                return i8;
            }
        }
        return -1;
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @Beta
    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i6 = 0; i6 < length; i6++) {
            jArr[i6] = ((Number) Preconditions.checkNotNull(array[i6])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j6) {
        byte[] bArr = new byte[8];
        for (int i6 = 7; i6 >= 0; i6--) {
            bArr[i6] = (byte) (255 & j6);
            j6 >>= 8;
        }
        return bArr;
    }

    @Beta
    @NullableDecl
    public static Long tryParse(String str, int i6) {
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i6 < 2 || i6 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i6);
        }
        int i7 = str.charAt(0) == '-' ? 1 : 0;
        if (i7 == str.length()) {
            return null;
        }
        int i8 = i7 + 1;
        int digit = AsciiDigits.digit(str.charAt(i7));
        if (digit < 0 || digit >= i6) {
            return null;
        }
        long j6 = -digit;
        long j7 = i6;
        long j8 = Long.MIN_VALUE / j7;
        while (i8 < str.length()) {
            int i9 = i8 + 1;
            int digit2 = AsciiDigits.digit(str.charAt(i8));
            if (digit2 < 0 || digit2 >= i6 || j6 < j8) {
                return null;
            }
            long j9 = j6 * j7;
            long j10 = digit2;
            if (j9 < j10 - Long.MIN_VALUE) {
                return null;
            }
            j6 = j9 - j10;
            i8 = i9;
        }
        if (i7 != 0) {
            return Long.valueOf(j6);
        }
        if (j6 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j6);
    }

    private Longs() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(long[] r8, long[] r9) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r8, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r9, r0)
            int r0 = r9.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r8.length
            int r3 = r9.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r9.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r8[r3]
            r5 = r9[r2]
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Longs.indexOf(long[], long[]):int");
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i6 = 1; i6 < jArr.length; i6++) {
            sb.append(str);
            sb.append(jArr[i6]);
        }
        return sb.toString();
    }

    public static void reverse(long[] jArr, int i6, int i7) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i6, i7, jArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            long j6 = jArr[i6];
            jArr[i6] = jArr[i8];
            jArr[i8] = j6;
            i6++;
        }
    }

    public static void sortDescending(long[] jArr, int i6, int i7) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i6, i7, jArr.length);
        Arrays.sort(jArr, i6, i7);
        reverse(jArr, i6, i7);
    }
}
