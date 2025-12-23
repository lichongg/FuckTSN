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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Floats {
    public static final int BYTES = 4;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != floatArrayAsList.array[floatArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        FloatArrayAsList(float[] fArr, int i6, int i7) {
            this.array = fArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Float.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Floats.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Float) || (indexOf = Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Float) || (lastIndexOf = Floats.lastIndexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float set(int i6, Float f6) {
            Preconditions.checkElementIndex(i6, size());
            float[] fArr = this.array;
            int i7 = this.start;
            float f7 = fArr[i7 + i6];
            fArr[i7 + i6] = ((Float) Preconditions.checkNotNull(f6)).floatValue();
            return Float.valueOf(f7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        float[] toFloatArray() {
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
        public List<Float> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            float[] fArr = this.array;
            int i8 = this.start;
            return new FloatArrayAsList(fArr, i6 + i8, i8 + i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class FloatConverter extends Converter<String, Float> implements Serializable {
        static final FloatConverter INSTANCE = new FloatConverter();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Float f6) {
            return f6.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Float doForward(String str) {
            return Float.valueOf(str);
        }

        public String toString() {
            return "Floats.stringConverter()";
        }

        private FloatConverter() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = Float.compare(fArr[i6], fArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    public static List<Float> asList(float... fArr) {
        return fArr.length == 0 ? Collections.EMPTY_LIST : new FloatArrayAsList(fArr);
    }

    public static float[] concat(float[]... fArr) {
        int i6 = 0;
        for (float[] fArr2 : fArr) {
            i6 += fArr2.length;
        }
        float[] fArr3 = new float[i6];
        int i7 = 0;
        for (float[] fArr4 : fArr) {
            System.arraycopy(fArr4, 0, fArr3, i7, fArr4.length);
            i7 += fArr4.length;
        }
        return fArr3;
    }

    public static boolean contains(float[] fArr, float f6) {
        for (float f7 : fArr) {
            if (f7 == f6) {
                return true;
            }
        }
        return false;
    }

    public static float[] ensureCapacity(float[] fArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return fArr.length < i6 ? Arrays.copyOf(fArr, i6 + i7) : fArr;
    }

    public static int indexOf(float[] fArr, float f6) {
        return indexOf(fArr, f6, 0, fArr.length);
    }

    public static int lastIndexOf(float[] fArr, float f6) {
        return lastIndexOf(fArr, f6, 0, fArr.length);
    }

    public static float max(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f6 = fArr[0];
        for (int i6 = 1; i6 < fArr.length; i6++) {
            f6 = Math.max(f6, fArr[i6]);
        }
        return f6;
    }

    public static float min(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f6 = fArr[0];
        for (int i6 = 1; i6 < fArr.length; i6++) {
            f6 = Math.min(f6, fArr[i6]);
        }
        return f6;
    }

    public static void reverse(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    @Beta
    public static float constrainToRange(float f6, float f7, float f8) {
        Preconditions.checkArgument(f7 <= f8, "min (%s) must be less than or equal to max (%s)", Float.valueOf(f7), Float.valueOf(f8));
        return Math.min(Math.max(f6, f7), f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(float[] fArr, float f6, int i6, int i7) {
        while (i6 < i7) {
            if (fArr[i6] == f6) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static boolean isFinite(float f6) {
        return Float.NEGATIVE_INFINITY < f6 && f6 < Float.POSITIVE_INFINITY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(float[] fArr, float f6, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (fArr[i8] == f6) {
                return i8;
            }
        }
        return -1;
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @Beta
    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }

    public static float[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).toFloatArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i6 = 0; i6 < length; i6++) {
            fArr[i6] = ((Number) Preconditions.checkNotNull(array[i6])).floatValue();
        }
        return fArr;
    }

    @Beta
    @NullableDecl
    @GwtIncompatible
    public static Float tryParse(String str) {
        if (!Doubles.FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private Floats() {
    }

    public static int compare(float f6, float f7) {
        return Float.compare(f6, f7);
    }

    public static int hashCode(float f6) {
        return Float.valueOf(f6).hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(float[] r5, float[] r6) {
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
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Floats.indexOf(float[], float[]):int");
    }

    public static String join(String str, float... fArr) {
        Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i6 = 1; i6 < fArr.length; i6++) {
            sb.append(str);
            sb.append(fArr[i6]);
        }
        return sb.toString();
    }

    public static void reverse(float[] fArr, int i6, int i7) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i6, i7, fArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            float f6 = fArr[i6];
            fArr[i6] = fArr[i8];
            fArr[i8] = f6;
            i6++;
        }
    }

    public static void sortDescending(float[] fArr, int i6, int i7) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i6, i7, fArr.length);
        Arrays.sort(fArr, i6, i7);
        reverse(fArr, i6, i7);
    }
}
