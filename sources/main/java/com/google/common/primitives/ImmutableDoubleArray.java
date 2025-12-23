package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    private final double[] array;
    private final int end;
    private final transient int start;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.primitives.ImmutableDoubleArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        /* synthetic */ AsList(ImmutableDoubleArray immutableDoubleArray, AnonymousClass1 anonymousClass1) {
            this(immutableDoubleArray);
        }

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i6 = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    int i7 = i6 + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[i6], ((Double) obj2).doubleValue())) {
                        i6 = i7;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int i6) {
            return Double.valueOf(this.parent.get(i6));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i6, int i7) {
            return this.parent.subArray(i6, i7).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            if (indexOf(obj) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @CanIgnoreReturnValue
    public static final class Builder {
        private double[] array;
        private int count = 0;

        public Builder add(double d6) {
            ensureRoomFor(1);
            double[] dArr = this.array;
            int i6 = this.count;
            dArr[i6] = d6;
            this.count = i6 + 1;
            return this;
        }

        public Builder addAll(double[] dArr) {
            ensureRoomFor(dArr.length);
            System.arraycopy(dArr, 0, this.array, this.count, dArr.length);
            this.count += dArr.length;
            return this;
        }

        private void ensureRoomFor(int i6) {
            int i7 = this.count + i6;
            double[] dArr = this.array;
            if (i7 > dArr.length) {
                double[] dArr2 = new double[expandedCapacity(dArr.length, i7)];
                System.arraycopy(this.array, 0, dArr2, 0, this.count);
                this.array = dArr2;
            }
        }

        private static int expandedCapacity(int i6, int i7) {
            if (i7 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i8 = i6 + (i6 >> 1) + 1;
            if (i8 < i7) {
                i8 = Integer.highestOneBit(i7 - 1) << 1;
            }
            if (i8 < 0) {
                return Integer.MAX_VALUE;
            }
            return i8;
        }

        @CheckReturnValue
        public ImmutableDoubleArray build() {
            if (this.count == 0) {
                return ImmutableDoubleArray.EMPTY;
            }
            return new ImmutableDoubleArray(this.array, 0, this.count, null);
        }

        Builder(int i6) {
            this.array = new double[i6];
        }

        public Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Double>) iterable);
            }
            Iterator<Double> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().doubleValue());
            }
            return this;
        }

        public Builder addAll(Collection<Double> collection) {
            ensureRoomFor(collection.size());
            for (Double d6 : collection) {
                double[] dArr = this.array;
                int i6 = this.count;
                this.count = i6 + 1;
                dArr[i6] = d6.doubleValue();
            }
            return this;
        }

        public Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            ensureRoomFor(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.start, this.array, this.count, immutableDoubleArray.length());
            this.count += immutableDoubleArray.length();
            return this;
        }
    }

    /* synthetic */ ImmutableDoubleArray(double[] dArr, int i6, int i7, AnonymousClass1 anonymousClass1) {
        this(dArr, i6, i7);
    }

    public static Builder builder(int i6) {
        Preconditions.checkArgument(i6 >= 0, "Invalid initialCapacity: %s", i6);
        return new Builder(i6);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        return dArr.length == 0 ? EMPTY : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length(); i6++) {
            if (!areEqual(get(i6), immutableDoubleArray.get(i6))) {
                return false;
            }
        }
        return true;
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableDoubleArray of(double d6) {
        return new ImmutableDoubleArray(new double[]{d6});
    }

    public List<Double> asList() {
        return new AsList(this, null);
    }

    public int hashCode() {
        int i6 = 1;
        for (int i7 = this.start; i7 < this.end; i7++) {
            i6 = (i6 * 31) + Doubles.hashCode(this.array[i7]);
        }
        return i6;
    }

    public int indexOf(double d6) {
        for (int i6 = this.start; i6 < this.end; i6++) {
            if (areEqual(this.array[i6], d6)) {
                return i6 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d6) {
        int i6 = this.end;
        do {
            i6--;
            if (i6 < this.start) {
                return -1;
            }
        } while (!areEqual(this.array[i6], d6));
        return i6 - this.start;
    }

    public int length() {
        return this.end - this.start;
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    private ImmutableDoubleArray(double[] dArr, int i6, int i7) {
        this.array = dArr;
        this.start = i6;
        this.end = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areEqual(double d6, double d7) {
        if (Double.doubleToLongBits(d6) == Double.doubleToLongBits(d7)) {
            return true;
        }
        return false;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    public static ImmutableDoubleArray of(double d6, double d7) {
        return new ImmutableDoubleArray(new double[]{d6, d7});
    }

    public boolean contains(double d6) {
        if (indexOf(d6) >= 0) {
            return true;
        }
        return false;
    }

    public double get(int i6) {
        Preconditions.checkElementIndex(i6, length());
        return this.array[this.start + i6];
    }

    Object readResolve() {
        if (isEmpty()) {
            return EMPTY;
        }
        return this;
    }

    public ImmutableDoubleArray subArray(int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i7, length());
        if (i6 == i7) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i8 = this.start;
        return new ImmutableDoubleArray(dArr, i6 + i8, i8 + i7);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i6 = this.start;
        while (true) {
            i6++;
            if (i6 < this.end) {
                sb.append(", ");
                sb.append(this.array[i6]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableDoubleArray trimmed() {
        if (isPartialView()) {
            return new ImmutableDoubleArray(toArray());
        }
        return this;
    }

    Object writeReplace() {
        return trimmed();
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableDoubleArray of(double d6, double d7, double d8) {
        return new ImmutableDoubleArray(new double[]{d6, d7, d8});
    }

    public static ImmutableDoubleArray of(double d6, double d7, double d8, double d9) {
        return new ImmutableDoubleArray(new double[]{d6, d7, d8, d9});
    }

    public static ImmutableDoubleArray of(double d6, double d7, double d8, double d9, double d10) {
        return new ImmutableDoubleArray(new double[]{d6, d7, d8, d9, d10});
    }

    public static ImmutableDoubleArray of(double d6, double d7, double d8, double d9, double d10, double d11) {
        return new ImmutableDoubleArray(new double[]{d6, d7, d8, d9, d10, d11});
    }

    public static ImmutableDoubleArray of(double d6, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d6;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }
}
