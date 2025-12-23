package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final UnmodifiableListIterator<Object> EMPTY_ITR = new Itr(RegularImmutableList.EMPTY, 0);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object obj) {
            return add((Builder<E>) obj);
        }

        Builder(int i6) {
            super(i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableList<E> build() {
            this.forceCopy = true;
            return ImmutableList.asImmutableList(this.contents, this.size);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e6) {
            super.add((Builder<E>) e6);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Itr<E> extends AbstractIndexedListIterator<E> {
        private final ImmutableList<E> list;

        @Override // com.google.common.collect.AbstractIndexedListIterator
        protected E get(int i6) {
            return this.list.get(i6);
        }

        Itr(ImmutableList<E> immutableList, int i6) {
            super(immutableList.size(), i6);
            this.list = immutableList;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.forwardList.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return reverseIndex(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            if (indexOf >= 0) {
                return reverseIndex(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i6) {
            return super.listIterator(i6);
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            return this.forwardList.subList(reversePosition(i7), reversePosition(i6)).reverse();
        }

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.forwardList = immutableList;
        }

        private int reverseIndex(int i6) {
            return (size() - 1) - i6;
        }

        private int reversePosition(int i6) {
            return size() - i6;
        }

        @Override // java.util.List
        public E get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return this.forwardList.get(reverseIndex(i6));
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        SubList(int i6, int i7) {
            this.offset = i6;
            this.length = i7;
        }

        @Override // java.util.List
        public E get(int i6) {
            Preconditions.checkElementIndex(i6, this.length);
            return ImmutableList.this.get(i6 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i6) {
            return super.listIterator(i6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i8 = this.offset;
            return immutableList.subList(i6 + i8, i7 + i8);
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) Iterables.toArray(iterable, new Comparable[0]);
        ObjectArrays.checkElementsNotNull(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i6) {
        return i6 == 0 ? of() : new RegularImmutableList(objArr, i6);
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i6) {
        CollectPreconditions.checkNonnegative(i6, "expectedSize");
        return new Builder<>(i6);
    }

    public static <E> ImmutableList<E> of(E e6) {
        return construct(e6);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i6, E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i6, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.indexOfImpl(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.lastIndexOfImpl(this, obj);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i6, E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i7, size());
        int i8 = i7 - i6;
        return i8 == size() ? this : i8 == 0 ? of() : subListUnchecked(i6, i7);
    }

    ImmutableList<E> subListUnchecked(int i6, int i7) {
        return new SubList(i6, i7 - i6);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    ImmutableList() {
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(ObjectArrays.checkElementsNotNull(objArr));
    }

    public static <E> ImmutableList<E> of(E e6, E e7) {
        return construct(e6, e7);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            objArr[i6 + i7] = get(i7);
        }
        return i6 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i6 = 1;
        for (int i7 = 0; i7 < size; i7++) {
            i6 = ~(~((i6 * 31) + get(i7).hashCode()));
        }
        return i6;
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ImmutableList<E> reverse() {
        if (size() <= 1) {
            return this;
        }
        return new ReverseImmutableList(this);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8) {
        return construct(e6, e7, e8);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator(int i6) {
        Preconditions.checkPositionIndex(i6, size());
        if (isEmpty()) {
            return (UnmodifiableListIterator<E>) EMPTY_ITR;
        }
        return new Itr(this, i6);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
        }
        return construct(collection.toArray());
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9) {
        return construct(e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator);
        Object[] array = Iterables.toArray(iterable);
        ObjectArrays.checkElementsNotNull(array);
        Arrays.sort(array, comparator);
        return asImmutableList(array);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10) {
        return construct(e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e6, e7, e8, e9, e10, e11);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E e12) {
        return construct(e6, e7, e8, e9, e10, e11, e12);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13, e14);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return construct(e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e6;
        objArr[1] = e7;
        objArr[2] = e8;
        objArr[3] = e9;
        objArr[4] = e10;
        objArr[5] = e11;
        objArr[6] = e12;
        objArr[7] = e13;
        objArr[8] = e14;
        objArr[9] = e15;
        objArr[10] = e16;
        objArr[11] = e17;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return construct(objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        return construct((Object[]) eArr.clone());
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }
}
