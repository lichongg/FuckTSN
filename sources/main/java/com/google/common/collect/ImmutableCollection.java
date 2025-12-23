package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] contents;
        boolean forceCopy;
        int size;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ Builder add(Object obj) {
            return add((ArrayBasedBuilder<E>) obj);
        }

        private void getReadyToExpandTo(int i6) {
            Object[] objArr = this.contents;
            if (objArr.length < i6) {
                this.contents = Arrays.copyOf(objArr, Builder.expandedCapacity(objArr.length, i6));
                this.forceCopy = false;
            } else if (this.forceCopy) {
                this.contents = (Object[]) objArr.clone();
                this.forceCopy = false;
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public ArrayBasedBuilder<E> add(E e6) {
            Preconditions.checkNotNull(e6);
            getReadyToExpandTo(this.size + 1);
            Object[] objArr = this.contents;
            int i6 = this.size;
            this.size = i6 + 1;
            objArr[i6] = e6;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                getReadyToExpandTo(this.size + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.size = ((ImmutableCollection) collection).copyIntoArray(this.contents, this.size);
                    return this;
                }
            }
            super.addAll(iterable);
            return this;
        }

        ArrayBasedBuilder(int i6) {
            CollectPreconditions.checkNonnegative(i6, "initialCapacity");
            this.contents = new Object[i6];
            this.size = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            ObjectArrays.checkElementsNotNull(eArr);
            getReadyToExpandTo(this.size + eArr.length);
            System.arraycopy(eArr, 0, this.contents, this.size, eArr.length);
            this.size += eArr.length;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        @CanIgnoreReturnValue
        public abstract Builder<E> add(E e6);

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            for (E e6 : eArr) {
                add((Builder<E>) e6);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        public abstract ImmutableCollection<E> build();

        static int expandedCapacity(int i6, int i7) {
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

        Builder() {
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@NullableDecl Object obj);

    Object[] internalArray() {
        return null;
    }

    abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) Platform.copy(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) ObjectArrays.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    ImmutableCollection() {
    }

    public ImmutableList<E> asList() {
        if (isEmpty()) {
            return ImmutableList.of();
        }
        return ImmutableList.asImmutableList(toArray());
    }

    @CanIgnoreReturnValue
    int copyIntoArray(Object[] objArr, int i6) {
        UnmodifiableIterator<E> it = iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return i6;
    }
}
