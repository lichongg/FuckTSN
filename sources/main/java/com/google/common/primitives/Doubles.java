package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.huawei.hms.common.util.Logger;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Doubles {
    public static final int BYTES = 8;

    @GwtIncompatible
    static final Pattern FLOATING_POINT_PATTERN = fpPattern();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != doubleArrayAsList.array[doubleArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        DoubleArrayAsList(double[] dArr, int i6, int i7) {
            this.array = dArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Double.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Doubles.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Double) || (indexOf = Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Double) || (lastIndexOf = Doubles.lastIndexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double set(int i6, Double d6) {
            Preconditions.checkElementIndex(i6, size());
            double[] dArr = this.array;
            int i7 = this.start;
            double d7 = dArr[i7 + i6];
            dArr[i7 + i6] = ((Double) Preconditions.checkNotNull(d6)).doubleValue();
            return Double.valueOf(d7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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
        public List<Double> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            double[] dArr = this.array;
            int i8 = this.start;
            return new DoubleArrayAsList(dArr, i6 + i8, i8 + i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = new DoubleConverter();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Double d6) {
            return d6.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Double doForward(String str) {
            return Double.valueOf(str);
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }

        private DoubleConverter() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = Double.compare(dArr[i6], dArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    public static List<Double> asList(double... dArr) {
        return dArr.length == 0 ? Collections.EMPTY_LIST : new DoubleArrayAsList(dArr);
    }

    public static double[] concat(double[]... dArr) {
        int i6 = 0;
        for (double[] dArr2 : dArr) {
            i6 += dArr2.length;
        }
        double[] dArr3 = new double[i6];
        int i7 = 0;
        for (double[] dArr4 : dArr) {
            System.arraycopy(dArr4, 0, dArr3, i7, dArr4.length);
            i7 += dArr4.length;
        }
        return dArr3;
    }

    public static boolean contains(double[] dArr, double d6) {
        for (double d7 : dArr) {
            if (d7 == d6) {
                return true;
            }
        }
        return false;
    }

    public static double[] ensureCapacity(double[] dArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return dArr.length < i6 ? Arrays.copyOf(dArr, i6 + i7) : dArr;
    }

    public static int indexOf(double[] dArr, double d6) {
        return indexOf(dArr, d6, 0, dArr.length);
    }

    public static int lastIndexOf(double[] dArr, double d6) {
        return lastIndexOf(dArr, d6, 0, dArr.length);
    }

    public static double max(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d6 = dArr[0];
        for (int i6 = 1; i6 < dArr.length; i6++) {
            d6 = Math.max(d6, dArr[i6]);
        }
        return d6;
    }

    public static double min(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d6 = dArr[0];
        for (int i6 = 1; i6 < dArr.length; i6++) {
            d6 = Math.min(d6, dArr[i6]);
        }
        return d6;
    }

    public static void reverse(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        reverse(dArr, 0, dArr.length);
    }

    public static void sortDescending(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        sortDescending(dArr, 0, dArr.length);
    }

    @Beta
    public static double constrainToRange(double d6, double d7, double d8) {
        Preconditions.checkArgument(d7 <= d8, "min (%s) must be less than or equal to max (%s)", Double.valueOf(d7), Double.valueOf(d8));
        return Math.min(Math.max(d6, d7), d8);
    }

    @GwtIncompatible
    private static Pattern fpPattern() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + Logger.f33116c + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", Marker.ANY_NON_NULL_MARKER));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(double[] dArr, double d6, int i6, int i7) {
        while (i6 < i7) {
            if (dArr[i6] == d6) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static boolean isFinite(double d6) {
        return Double.NEGATIVE_INFINITY < d6 && d6 < Double.POSITIVE_INFINITY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(double[] dArr, double d6, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (dArr[i8] == d6) {
                return i8;
            }
        }
        return -1;
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @Beta
    public static Converter<String, Double> stringConverter() {
        return DoubleConverter.INSTANCE;
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i6 = 0; i6 < length; i6++) {
            dArr[i6] = ((Number) Preconditions.checkNotNull(array[i6])).doubleValue();
        }
        return dArr;
    }

    @Beta
    @NullableDecl
    @GwtIncompatible
    public static Double tryParse(String str) {
        if (!FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private Doubles() {
    }

    public static int compare(double d6, double d7) {
        return Double.compare(d6, d7);
    }

    public static int hashCode(double d6) {
        return Double.valueOf(d6).hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(double[] r8, double[] r9) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Doubles.indexOf(double[], double[]):int");
    }

    public static String join(String str, double... dArr) {
        Preconditions.checkNotNull(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i6 = 1; i6 < dArr.length; i6++) {
            sb.append(str);
            sb.append(dArr[i6]);
        }
        return sb.toString();
    }

    public static void reverse(double[] dArr, int i6, int i7) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i6, i7, dArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            double d6 = dArr[i6];
            dArr[i6] = dArr[i8];
            dArr[i8] = d6;
            i6++;
        }
    }

    public static void sortDescending(double[] dArr, int i6, int i7) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i6, i7, dArr.length);
        Arrays.sort(dArr, i6, i7);
        reverse(dArr, i6, i7);
    }
}
