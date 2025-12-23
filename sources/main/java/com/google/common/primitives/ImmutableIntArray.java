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
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.primitives.ImmutableIntArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        /* synthetic */ AsList(ImmutableIntArray immutableIntArray, AnonymousClass1 anonymousClass1) {
            this(immutableIntArray);
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
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
                if (obj2 instanceof Integer) {
                    int i7 = i6 + 1;
                    if (this.parent.array[i6] == ((Integer) obj2).intValue()) {
                        i6 = i7;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i6) {
            return Integer.valueOf(this.parent.get(i6));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i6, int i7) {
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
        private int[] array;
        private int count = 0;

        public Builder add(int i6) {
            ensureRoomFor(1);
            int[] iArr = this.array;
            int i7 = this.count;
            iArr[i7] = i6;
            this.count = i7 + 1;
            return this;
        }

        public Builder addAll(int[] iArr) {
            ensureRoomFor(iArr.length);
            System.arraycopy(iArr, 0, this.array, this.count, iArr.length);
            this.count += iArr.length;
            return this;
        }

        private void ensureRoomFor(int i6) {
            int i7 = this.count + i6;
            int[] iArr = this.array;
            if (i7 > iArr.length) {
                int[] iArr2 = new int[expandedCapacity(iArr.length, i7)];
                System.arraycopy(this.array, 0, iArr2, 0, this.count);
                this.array = iArr2;
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
        public ImmutableIntArray build() {
            if (this.count == 0) {
                return ImmutableIntArray.EMPTY;
            }
            return new ImmutableIntArray(this.array, 0, this.count, null);
        }

        Builder(int i6) {
            this.array = new int[i6];
        }

        public Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Integer>) iterable);
            }
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().intValue());
            }
            return this;
        }

        public Builder addAll(Collection<Integer> collection) {
            ensureRoomFor(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.array;
                int i6 = this.count;
                this.count = i6 + 1;
                iArr[i6] = num.intValue();
            }
            return this;
        }

        public Builder addAll(ImmutableIntArray immutableIntArray) {
            ensureRoomFor(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.array, this.count, immutableIntArray.length());
            this.count += immutableIntArray.length();
            return this;
        }
    }

    /* synthetic */ ImmutableIntArray(int[] iArr, int i6, int i7, AnonymousClass1 anonymousClass1) {
        this(iArr, i6, i7);
    }

    public static Builder builder(int i6) {
        Preconditions.checkArgument(i6 >= 0, "Invalid initialCapacity: %s", i6);
        return new Builder(i6);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length(); i6++) {
            if (get(i6) != immutableIntArray.get(i6)) {
                return false;
            }
        }
        return true;
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.toArray(collection));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of(int i6) {
        return new ImmutableIntArray(new int[]{i6});
    }

    public List<Integer> asList() {
        return new AsList(this, null);
    }

    public int hashCode() {
        int i6 = 1;
        for (int i7 = this.start; i7 < this.end; i7++) {
            i6 = (i6 * 31) + Ints.hashCode(this.array[i7]);
        }
        return i6;
    }

    public int indexOf(int i6) {
        for (int i7 = this.start; i7 < this.end; i7++) {
            if (this.array[i7] == i6) {
                return i7 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i6) {
        int i7;
        int i8 = this.end;
        do {
            i8--;
            i7 = this.start;
            if (i8 < i7) {
                return -1;
            }
        } while (this.array[i8] != i6);
        return i8 - i7;
    }

    public int length() {
        return this.end - this.start;
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    private ImmutableIntArray(int[] iArr, int i6, int i7) {
        this.array = iArr;
        this.start = i6;
        this.end = i7;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableIntArray of(int i6, int i7) {
        return new ImmutableIntArray(new int[]{i6, i7});
    }

    public boolean contains(int i6) {
        if (indexOf(i6) >= 0) {
            return true;
        }
        return false;
    }

    public int get(int i6) {
        Preconditions.checkElementIndex(i6, length());
        return this.array[this.start + i6];
    }

    Object readResolve() {
        if (isEmpty()) {
            return EMPTY;
        }
        return this;
    }

    public ImmutableIntArray subArray(int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i7, length());
        if (i6 == i7) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i8 = this.start;
        return new ImmutableIntArray(iArr, i6 + i8, i8 + i7);
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

    public ImmutableIntArray trimmed() {
        if (isPartialView()) {
            return new ImmutableIntArray(toArray());
        }
        return this;
    }

    Object writeReplace() {
        return trimmed();
    }

    public static ImmutableIntArray of(int i6, int i7, int i8) {
        return new ImmutableIntArray(new int[]{i6, i7, i8});
    }

    public static ImmutableIntArray of(int i6, int i7, int i8, int i9) {
        return new ImmutableIntArray(new int[]{i6, i7, i8, i9});
    }

    public static ImmutableIntArray of(int i6, int i7, int i8, int i9, int i10) {
        return new ImmutableIntArray(new int[]{i6, i7, i8, i9, i10});
    }

    public static ImmutableIntArray of(int i6, int i7, int i8, int i9, int i10, int i11) {
        return new ImmutableIntArray(new int[]{i6, i7, i8, i9, i10, i11});
    }

    public static ImmutableIntArray of(int i6, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i6;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
