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
public final class ImmutableLongArray implements Serializable {
    private static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
    private final long[] array;
    private final int end;
    private final transient int start;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.primitives.ImmutableLongArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

        /* synthetic */ AsList(ImmutableLongArray immutableLongArray, AnonymousClass1 anonymousClass1) {
            this(immutableLongArray);
        }

        private AsList(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
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
                if (obj2 instanceof Long) {
                    int i7 = i6 + 1;
                    if (this.parent.array[i6] == ((Long) obj2).longValue()) {
                        i6 = i7;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i6) {
            return Long.valueOf(this.parent.get(i6));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i6, int i7) {
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
        private long[] array;
        private int count = 0;

        public Builder add(long j6) {
            ensureRoomFor(1);
            long[] jArr = this.array;
            int i6 = this.count;
            jArr[i6] = j6;
            this.count = i6 + 1;
            return this;
        }

        public Builder addAll(long[] jArr) {
            ensureRoomFor(jArr.length);
            System.arraycopy(jArr, 0, this.array, this.count, jArr.length);
            this.count += jArr.length;
            return this;
        }

        private void ensureRoomFor(int i6) {
            int i7 = this.count + i6;
            long[] jArr = this.array;
            if (i7 > jArr.length) {
                long[] jArr2 = new long[expandedCapacity(jArr.length, i7)];
                System.arraycopy(this.array, 0, jArr2, 0, this.count);
                this.array = jArr2;
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
        public ImmutableLongArray build() {
            if (this.count == 0) {
                return ImmutableLongArray.EMPTY;
            }
            return new ImmutableLongArray(this.array, 0, this.count, null);
        }

        Builder(int i6) {
            this.array = new long[i6];
        }

        public Builder addAll(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Long>) iterable);
            }
            Iterator<Long> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().longValue());
            }
            return this;
        }

        public Builder addAll(Collection<Long> collection) {
            ensureRoomFor(collection.size());
            for (Long l6 : collection) {
                long[] jArr = this.array;
                int i6 = this.count;
                this.count = i6 + 1;
                jArr[i6] = l6.longValue();
            }
            return this;
        }

        public Builder addAll(ImmutableLongArray immutableLongArray) {
            ensureRoomFor(immutableLongArray.length());
            System.arraycopy(immutableLongArray.array, immutableLongArray.start, this.array, this.count, immutableLongArray.length());
            this.count += immutableLongArray.length();
            return this;
        }
    }

    /* synthetic */ ImmutableLongArray(long[] jArr, int i6, int i7, AnonymousClass1 anonymousClass1) {
        this(jArr, i6, i7);
    }

    public static Builder builder(int i6) {
        Preconditions.checkArgument(i6 >= 0, "Invalid initialCapacity: %s", i6);
        return new Builder(i6);
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        return jArr.length == 0 ? EMPTY : new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length(); i6++) {
            if (get(i6) != immutableLongArray.get(i6)) {
                return false;
            }
        }
        return true;
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableLongArray of(long j6) {
        return new ImmutableLongArray(new long[]{j6});
    }

    public List<Long> asList() {
        return new AsList(this, null);
    }

    public int hashCode() {
        int i6 = 1;
        for (int i7 = this.start; i7 < this.end; i7++) {
            i6 = (i6 * 31) + Longs.hashCode(this.array[i7]);
        }
        return i6;
    }

    public int indexOf(long j6) {
        for (int i6 = this.start; i6 < this.end; i6++) {
            if (this.array[i6] == j6) {
                return i6 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j6) {
        int i6;
        int i7 = this.end;
        do {
            i7--;
            i6 = this.start;
            if (i7 < i6) {
                return -1;
            }
        } while (this.array[i7] != j6);
        return i7 - i6;
    }

    public int length() {
        return this.end - this.start;
    }

    public long[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    private ImmutableLongArray(long[] jArr, int i6, int i7) {
        this.array = jArr;
        this.start = i6;
        this.end = i7;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableLongArray(Longs.toArray(collection));
    }

    public static ImmutableLongArray of(long j6, long j7) {
        return new ImmutableLongArray(new long[]{j6, j7});
    }

    public boolean contains(long j6) {
        if (indexOf(j6) >= 0) {
            return true;
        }
        return false;
    }

    public long get(int i6) {
        Preconditions.checkElementIndex(i6, length());
        return this.array[this.start + i6];
    }

    Object readResolve() {
        if (isEmpty()) {
            return EMPTY;
        }
        return this;
    }

    public ImmutableLongArray subArray(int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i7, length());
        if (i6 == i7) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i8 = this.start;
        return new ImmutableLongArray(jArr, i6 + i8, i8 + i7);
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

    public ImmutableLongArray trimmed() {
        if (isPartialView()) {
            return new ImmutableLongArray(toArray());
        }
        return this;
    }

    Object writeReplace() {
        return trimmed();
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Long>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableLongArray of(long j6, long j7, long j8) {
        return new ImmutableLongArray(new long[]{j6, j7, j8});
    }

    public static ImmutableLongArray of(long j6, long j7, long j8, long j9) {
        return new ImmutableLongArray(new long[]{j6, j7, j8, j9});
    }

    public static ImmutableLongArray of(long j6, long j7, long j8, long j9, long j10) {
        return new ImmutableLongArray(new long[]{j6, j7, j8, j9, j10});
    }

    public static ImmutableLongArray of(long j6, long j7, long j8, long j9, long j10, long j11) {
        return new ImmutableLongArray(new long[]{j6, j7, j8, j9, j10, j11});
    }

    public static ImmutableLongArray of(long j6, long... jArr) {
        Preconditions.checkArgument(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j6;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }
}
