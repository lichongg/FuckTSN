package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
public final class Booleans {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != booleanArrayAsList.array[booleanArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        BooleanArrayAsList(boolean[] zArr, int i6, int i7) {
            this.array = zArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Boolean.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Booleans.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Boolean) || (indexOf = Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Boolean) || (lastIndexOf = Booleans.lastIndexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean set(int i6, Boolean bool) {
            Preconditions.checkElementIndex(i6, size());
            boolean[] zArr = this.array;
            int i7 = this.start;
            boolean z5 = zArr[i7 + i6];
            zArr[i7 + i6] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.array[this.start] ? "[true" : "[false");
            int i6 = this.start;
            while (true) {
                i6++;
                if (i6 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(this.array[i6] ? ", true" : ", false");
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            boolean[] zArr = this.array;
            int i8 = this.start;
            return new BooleanArrayAsList(zArr, i6 + i8, i8 + i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");

        private final String toString;
        private final int trueValue;

        @Override // java.util.Comparator
        public int compare(Boolean bool, Boolean bool2) {
            return (bool2.booleanValue() ? this.trueValue : 0) - (bool.booleanValue() ? this.trueValue : 0);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }

        BooleanComparator(int i6, String str) {
            this.trueValue = i6;
            this.toString = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = Booleans.compare(zArr[i6], zArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr.length - zArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    public static List<Boolean> asList(boolean... zArr) {
        return zArr.length == 0 ? Collections.EMPTY_LIST : new BooleanArrayAsList(zArr);
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i6 = 0;
        for (boolean[] zArr2 : zArr) {
            i6 += zArr2.length;
        }
        boolean[] zArr3 = new boolean[i6];
        int i7 = 0;
        for (boolean[] zArr4 : zArr) {
            System.arraycopy(zArr4, 0, zArr3, i7, zArr4.length);
            i7 += zArr4.length;
        }
        return zArr3;
    }

    public static boolean contains(boolean[] zArr, boolean z5) {
        for (boolean z6 : zArr) {
            if (z6 == z5) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public static int countTrue(boolean... zArr) {
        int i6 = 0;
        for (boolean z5 : zArr) {
            if (z5) {
                i6++;
            }
        }
        return i6;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return zArr.length < i6 ? Arrays.copyOf(zArr, i6 + i7) : zArr;
    }

    public static int indexOf(boolean[] zArr, boolean z5) {
        return indexOf(zArr, z5, 0, zArr.length);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z5) {
        return lastIndexOf(zArr, z5, 0, zArr.length);
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static int compare(boolean z5, boolean z6) {
        if (z5 == z6) {
            return 0;
        }
        return z5 ? 1 : -1;
    }

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean z5) {
        return z5 ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(boolean[] zArr, boolean z5, int i6, int i7) {
        while (i6 < i7) {
            if (zArr[i6] == z5) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(boolean[] zArr, boolean z5, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (zArr[i8] == z5) {
                return i8;
            }
        }
        return -1;
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i6 = 0; i6 < length; i6++) {
            zArr[i6] = ((Boolean) Preconditions.checkNotNull(array[i6])).booleanValue();
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    private Booleans() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(boolean[] r5, boolean[] r6) {
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
            boolean r3 = r5[r3]
            boolean r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Booleans.indexOf(boolean[], boolean[]):int");
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i6 = 1; i6 < zArr.length; i6++) {
            sb.append(str);
            sb.append(zArr[i6]);
        }
        return sb.toString();
    }

    public static void reverse(boolean[] zArr, int i6, int i7) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i6, i7, zArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            boolean z5 = zArr[i6];
            zArr[i6] = zArr[i8];
            zArr[i8] = z5;
            i6++;
        }
    }
}
