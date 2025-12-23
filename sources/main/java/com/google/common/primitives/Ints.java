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
public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != intArrayAsList.array[intArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        IntArrayAsList(int[] iArr, int i6, int i7) {
            this.array = iArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Integer.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Ints.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Integer) || (indexOf = Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Integer) || (lastIndexOf = Ints.lastIndexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i6, Integer num) {
            Preconditions.checkElementIndex(i6, size());
            int[] iArr = this.array;
            int i7 = this.start;
            int i8 = iArr[i7 + i6];
            iArr[i7 + i6] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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
        public List<Integer> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            int[] iArr = this.array;
            int i8 = this.start;
            return new IntArrayAsList(iArr, i6 + i8, i8 + i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter INSTANCE = new IntConverter();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Integer num) {
            return num.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Integer doForward(String str) {
            return Integer.decode(str);
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        private IntConverter() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = Ints.compare(iArr[i6], iArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    public static List<Integer> asList(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new IntArrayAsList(iArr);
    }

    public static int checkedCast(long j6) {
        int i6 = (int) j6;
        Preconditions.checkArgument(((long) i6) == j6, "Out of range: %s", j6);
        return i6;
    }

    public static int[] concat(int[]... iArr) {
        int i6 = 0;
        for (int[] iArr2 : iArr) {
            i6 += iArr2.length;
        }
        int[] iArr3 = new int[i6];
        int i7 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, i7, iArr4.length);
            i7 += iArr4.length;
        }
        return iArr3;
    }

    public static boolean contains(int[] iArr, int i6) {
        for (int i7 : iArr) {
            if (i7 == i6) {
                return true;
            }
        }
        return false;
    }

    public static int[] ensureCapacity(int[] iArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return iArr.length < i6 ? Arrays.copyOf(iArr, i6 + i7) : iArr;
    }

    public static int fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int indexOf(int[] iArr, int i6) {
        return indexOf(iArr, i6, 0, iArr.length);
    }

    public static int lastIndexOf(int[] iArr, int i6) {
        return lastIndexOf(iArr, i6, 0, iArr.length);
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i6 = iArr[0];
        for (int i7 = 1; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            if (i8 > i6) {
                i6 = i8;
            }
        }
        return i6;
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i6 = iArr[0];
        for (int i7 = 1; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            if (i8 < i6) {
                i6 = i8;
            }
        }
        return i6;
    }

    public static void reverse(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        reverse(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    @Beta
    @NullableDecl
    public static Integer tryParse(String str) {
        return tryParse(str, 10);
    }

    public static int compare(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 > i7 ? 1 : 0;
    }

    @Beta
    public static int constrainToRange(int i6, int i7, int i8) {
        Preconditions.checkArgument(i7 <= i8, "min (%s) must be less than or equal to max (%s)", i7, i8);
        return Math.min(Math.max(i6, i7), i8);
    }

    public static int fromBytes(byte b6, byte b7, byte b8, byte b9) {
        return (b6 << 24) | ((b7 & 255) << 16) | ((b8 & 255) << 8) | (b9 & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(int[] iArr, int i6, int i7, int i8) {
        while (i7 < i8) {
            if (iArr[i7] == i6) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(int[] iArr, int i6, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (iArr[i9] == i6) {
                return i9;
            }
        }
        return -1;
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @Beta
    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = ((Number) Preconditions.checkNotNull(array[i6])).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(int i6) {
        return new byte[]{(byte) (i6 >> 24), (byte) (i6 >> 16), (byte) (i6 >> 8), (byte) i6};
    }

    @Beta
    @NullableDecl
    public static Integer tryParse(String str, int i6) {
        Long tryParse = Longs.tryParse(str, i6);
        if (tryParse == null || tryParse.longValue() != tryParse.intValue()) {
            return null;
        }
        return Integer.valueOf(tryParse.intValue());
    }

    private Ints() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(int[] r5, int[] r6) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2a
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L29
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            if (r3 == r4) goto L26
            int r0 = r0 + 1
            goto L10
        L26:
            int r2 = r2 + 1
            goto L18
        L29:
            return r0
        L2a:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Ints.indexOf(int[], int[]):int");
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i6 = 1; i6 < iArr.length; i6++) {
            sb.append(str);
            sb.append(iArr[i6]);
        }
        return sb.toString();
    }

    public static void reverse(int[] iArr, int i6, int i7) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i6, i7, iArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            int i9 = iArr[i6];
            iArr[i6] = iArr[i8];
            iArr[i8] = i9;
            i6++;
        }
    }

    public static int saturatedCast(long j6) {
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j6 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j6;
    }

    public static void sortDescending(int[] iArr, int i6, int i7) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i6, i7, iArr.length);
        Arrays.sort(iArr, i6, i7);
        reverse(iArr, i6, i7);
    }

    public static int hashCode(int i6) {
        return i6;
    }
}
