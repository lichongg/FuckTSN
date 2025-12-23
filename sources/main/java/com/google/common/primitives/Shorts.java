package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
import kotlin.jvm.internal.q0;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = Shorts.compare(sArr[i6], sArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return sArr.length - sArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != shortArrayAsList.array[shortArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        ShortArrayAsList(short[] sArr, int i6, int i7) {
            this.array = sArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@NullableDecl Object obj) {
            return (obj instanceof Short) && Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Short.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Shorts.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int indexOf;
            if (!(obj instanceof Short) || (indexOf = Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Short) || (lastIndexOf = Shorts.lastIndexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short set(int i6, Short sh) {
            Preconditions.checkElementIndex(i6, size());
            short[] sArr = this.array;
            int i7 = this.start;
            short s5 = sArr[i7 + i6];
            sArr[i7 + i6] = ((Short) Preconditions.checkNotNull(sh)).shortValue();
            return Short.valueOf(s5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i6 = this.start;
            while (true) {
                i6++;
                if (i6 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.array[i6]);
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            short[] sArr = this.array;
            int i8 = this.start;
            return new ShortArrayAsList(sArr, i6 + i8, i8 + i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Short sh) {
            return sh.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Short doForward(String str) {
            return Short.decode(str);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        private ShortConverter() {
        }
    }

    public static List<Short> asList(short... sArr) {
        return sArr.length == 0 ? Collections.EMPTY_LIST : new ShortArrayAsList(sArr);
    }

    public static short checkedCast(long j6) {
        short s5 = (short) j6;
        Preconditions.checkArgument(((long) s5) == j6, "Out of range: %s", j6);
        return s5;
    }

    public static int compare(short s5, short s6) {
        return s5 - s6;
    }

    public static short[] concat(short[]... sArr) {
        int i6 = 0;
        for (short[] sArr2 : sArr) {
            i6 += sArr2.length;
        }
        short[] sArr3 = new short[i6];
        int i7 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, i7, sArr4.length);
            i7 += sArr4.length;
        }
        return sArr3;
    }

    public static boolean contains(short[] sArr, short s5) {
        for (short s6 : sArr) {
            if (s6 == s5) {
                return true;
            }
        }
        return false;
    }

    public static short[] ensureCapacity(short[] sArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return sArr.length < i6 ? Arrays.copyOf(sArr, i6 + i7) : sArr;
    }

    @GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    public static int indexOf(short[] sArr, short s5) {
        return indexOf(sArr, s5, 0, sArr.length);
    }

    public static int lastIndexOf(short[] sArr, short s5) {
        return lastIndexOf(sArr, s5, 0, sArr.length);
    }

    public static short max(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s5 = sArr[0];
        for (int i6 = 1; i6 < sArr.length; i6++) {
            short s6 = sArr[i6];
            if (s6 > s5) {
                s5 = s6;
            }
        }
        return s5;
    }

    public static short min(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s5 = sArr[0];
        for (int i6 = 1; i6 < sArr.length; i6++) {
            short s6 = sArr[i6];
            if (s6 < s5) {
                s5 = s6;
            }
        }
        return s5;
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    @Beta
    public static short constrainToRange(short s5, short s6, short s7) {
        Preconditions.checkArgument(s6 <= s7, "min (%s) must be less than or equal to max (%s)", (int) s6, (int) s7);
        return s5 < s6 ? s6 : s5 < s7 ? s5 : s7;
    }

    @GwtIncompatible
    public static short fromBytes(byte b6, byte b7) {
        return (short) ((b6 << 8) | (b7 & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(short[] sArr, short s5, int i6, int i7) {
        while (i6 < i7) {
            if (sArr[i6] == s5) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(short[] sArr, short s5, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (sArr[i8] == s5) {
                return i8;
            }
        }
        return -1;
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static short saturatedCast(long j6) {
        return j6 > 32767 ? q0.f44053c : j6 < -32768 ? q0.f44052b : (short) j6;
    }

    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i6 = 0; i6 < length; i6++) {
            sArr[i6] = ((Number) Preconditions.checkNotNull(array[i6])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(short s5) {
        return new byte[]{(byte) (s5 >> 8), (byte) s5};
    }

    private Shorts() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(short[] r5, short[] r6) {
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
            short r3 = r5[r3]
            short r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Shorts.indexOf(short[], short[]):int");
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i6 = 1; i6 < sArr.length; i6++) {
            sb.append(str);
            sb.append((int) sArr[i6]);
        }
        return sb.toString();
    }

    public static void reverse(short[] sArr, int i6, int i7) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i6, i7, sArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            short s5 = sArr[i6];
            sArr[i6] = sArr[i8];
            sArr[i8] = s5;
            i6++;
        }
    }

    public static void sortDescending(short[] sArr, int i6, int i7) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i6, i7, sArr.length);
        Arrays.sort(sArr, i6, i7);
        reverse(sArr, i6, i7);
    }

    public static int hashCode(short s5) {
        return s5;
    }
}
