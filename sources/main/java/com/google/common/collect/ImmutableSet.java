package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient ImmutableList<E> asList;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        private int hashCode;

        @VisibleForTesting
        @NullableDecl
        Object[] hashTable;

        public Builder() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object obj) {
            return add((Builder<E>) obj);
        }

        Builder(int i6) {
            super(i6);
            this.hashTable = new Object[ImmutableSet.chooseTableSize(i6)];
        }

        private void addDeduping(E e6) {
            int length = this.hashTable.length - 1;
            int hashCode = e6.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i6 = smear & length;
                Object[] objArr = this.hashTable;
                Object obj = objArr[i6];
                if (obj == null) {
                    objArr[i6] = e6;
                    this.hashCode += hashCode;
                    super.add((Builder<E>) e6);
                    return;
                } else if (obj.equals(e6)) {
                    return;
                } else {
                    smear = i6 + 1;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            ImmutableSet<E> construct;
            int i6 = this.size;
            if (i6 == 0) {
                return ImmutableSet.of();
            }
            if (i6 == 1) {
                return ImmutableSet.of(this.contents[0]);
            }
            if (this.hashTable == null || ImmutableSet.chooseTableSize(i6) != this.hashTable.length) {
                construct = ImmutableSet.construct(this.size, this.contents);
                this.size = construct.size();
            } else {
                Object[] copyOf = ImmutableSet.shouldTrim(this.size, this.contents.length) ? Arrays.copyOf(this.contents, this.size) : this.contents;
                construct = new RegularImmutableSet<>(copyOf, this.hashCode, this.hashTable, r5.length - 1, this.size);
            }
            this.forceCopy = true;
            this.hashTable = null;
            return construct;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (this.hashTable != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((Builder<E>) it.next());
                }
                return this;
            }
            super.addAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e6) {
            Preconditions.checkNotNull(e6);
            if (this.hashTable != null && ImmutableSet.chooseTableSize(this.size) <= this.hashTable.length) {
                addDeduping(e6);
                return this;
            }
            this.hashTable = null;
            super.add((Builder<E>) e6);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            Preconditions.checkNotNull(it);
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            if (this.hashTable != null) {
                for (E e6 : eArr) {
                    add((Builder<E>) e6);
                }
                return this;
            }
            super.add((Object[]) eArr);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }
    }

    @VisibleForTesting
    static int chooseTableSize(int i6) {
        int max = Math.max(i6, 2);
        if (max >= CUTOFF) {
            Preconditions.checkArgument(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i6) {
        CollectPreconditions.checkNonnegative(i6, "expectedSize");
        return new Builder<>(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i6, Object... objArr) {
        if (i6 == 0) {
            return of();
        }
        if (i6 == 1) {
            return of(objArr[0]);
        }
        int chooseTableSize = chooseTableSize(i6);
        Object[] objArr2 = new Object[chooseTableSize];
        int i7 = chooseTableSize - 1;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            Object checkElementNotNull = ObjectArrays.checkElementNotNull(objArr[i10], i10);
            int hashCode = checkElementNotNull.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i11 = smear & i7;
                Object obj = objArr2[i11];
                if (obj == null) {
                    objArr[i9] = checkElementNotNull;
                    objArr2[i11] = checkElementNotNull;
                    i8 += hashCode;
                    i9++;
                    break;
                }
                if (obj.equals(checkElementNotNull)) {
                    break;
                }
                smear++;
            }
        }
        Arrays.fill(objArr, i9, i6, (Object) null);
        if (i9 == 1) {
            return new SingletonImmutableSet(objArr[0], i8);
        }
        if (chooseTableSize(i9) < chooseTableSize / 2) {
            return construct(i9, objArr);
        }
        if (shouldTrim(i9, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i9);
        }
        return new RegularImmutableSet(objArr, i8, objArr2, i7, i9);
    }

    public static <E> ImmutableSet<E> of(E e6) {
        return new SingletonImmutableSet(e6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i6, int i7) {
        return i6 < (i7 >> 1) + (i7 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    ImmutableSet() {
    }

    public static <E> ImmutableSet<E> of(E e6, E e7) {
        return construct(2, e6, e7);
    }

    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    public static <E> ImmutableSet<E> of(E e6, E e7, E e8) {
        return construct(3, e6, e7, e8);
    }

    public static <E> ImmutableSet<E> of(E e6, E e7, E e8, E e9) {
        return construct(4, e6, e7, e8, e9);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e6, E e7, E e8, E e9, E e10) {
        return construct(5, e6, e7, e8, e9, e10);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e6;
        objArr[1] = e7;
        objArr[2] = e8;
        objArr[3] = e9;
        objArr[4] = e10;
        objArr[5] = e11;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
