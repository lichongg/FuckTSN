package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Lists {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AbstractListWrapper<E> extends AbstractList<E> {
        final List<E> backingList;

        @Override // java.util.AbstractList, java.util.List
        public void add(int i6, E e6) {
            this.backingList.add(i6, e6);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i6, Collection<? extends E> collection) {
            return this.backingList.addAll(i6, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.backingList.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i6) {
            return this.backingList.get(i6);
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i6) {
            return this.backingList.remove(i6);
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i6, E e6) {
            return this.backingList.set(i6, e6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.backingList.size();
        }

        AbstractListWrapper(List<E> list) {
            this.backingList = (List) Preconditions.checkNotNull(list);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Character.valueOf(this.sequence.charAt(i6));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.sequence.length();
        }

        CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final E first;
        final E[] rest;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }

        OnePlusArrayList(@NullableDecl E e6, E[] eArr) {
            this.first = e6;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            if (i6 == 0) {
                return this.first;
            }
            return this.rest[i6 - 1];
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Partition<T> extends AbstractList<List<T>> {
        final List<T> list;
        final int size;

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            int i7 = this.size;
            int i8 = i6 * i7;
            return this.list.subList(i8, Math.min(i7 + i8, this.list.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }

        Partition(List<T> list, int i6) {
            this.list = list;
            this.size = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ReverseList<T> extends AbstractList<T> {
        private final List<T> forwardList;

        @Override // java.util.AbstractList, java.util.List
        public void add(int i6, @NullableDecl T t5) {
            this.forwardList.add(reversePosition(i6), t5);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.forwardList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i6) {
            return this.forwardList.get(reverseIndex(i6));
        }

        List<T> getForwardList() {
            return this.forwardList;
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i6) {
            return this.forwardList.remove(reverseIndex(i6));
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int i6, @NullableDecl T t5) {
            return this.forwardList.set(reverseIndex(i6), t5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        ReverseList(List<T> list) {
            this.forwardList = (List) Preconditions.checkNotNull(list);
        }

        private int reverseIndex(int i6) {
            int size = size();
            Preconditions.checkElementIndex(i6, size);
            return (size - 1) - i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int reversePosition(int i6) {
            int size = size();
            Preconditions.checkPositionIndex(i6, size);
            return size - i6;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i6) {
            final ListIterator<T> listIterator = this.forwardList.listIterator(reversePosition(i6));
            return new ListIterator<T>() { // from class: com.google.common.collect.Lists.ReverseList.1
                boolean canRemoveOrSet;

                @Override // java.util.ListIterator
                public void add(T t5) {
                    listIterator.add(t5);
                    listIterator.previous();
                    this.canRemoveOrSet = false;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return ReverseList.this.reversePosition(listIterator.nextIndex());
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    CollectPreconditions.checkRemove(this.canRemoveOrSet);
                    listIterator.remove();
                    this.canRemoveOrSet = false;
                }

                @Override // java.util.ListIterator
                public void set(T t5) {
                    Preconditions.checkState(this.canRemoveOrSet);
                    listIterator.set(t5);
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public T next() {
                    if (hasNext()) {
                        this.canRemoveOrSet = true;
                        return (T) listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.ListIterator
                public T previous() {
                    if (hasPrevious()) {
                        this.canRemoveOrSet = true;
                        return (T) listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return nextIndex() - 1;
                }
            };
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i6, int i7) {
            subList(i6, i7).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(i7), reversePosition(i6)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.List
        public Character get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Character.valueOf(this.string.charAt(i6));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            return Lists.charactersOf(this.string.substring(i6, i7));
        }

        StringAsImmutableList(String str) {
            this.string = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i6) {
            return this.function.apply(this.fromList.get(i6));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i6) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i6)) { // from class: com.google.common.collect.Lists.TransformingRandomAccessList.1
                @Override // com.google.common.collect.TransformedIterator
                T transform(F f6) {
                    return TransformingRandomAccessList.this.function.apply(f6);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i6) {
            return this.function.apply(this.fromList.remove(i6));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i6) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i6)) { // from class: com.google.common.collect.Lists.TransformingSequentialList.1
                @Override // com.google.common.collect.TransformedIterator
                T transform(F f6) {
                    return TransformingSequentialList.this.function.apply(f6);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final E first;
        final E[] rest;

        @NullableDecl
        final E second;

        @Override // java.util.AbstractList, java.util.List
        public E get(int i6) {
            if (i6 == 0) {
                return this.first;
            }
            if (i6 == 1) {
                return this.second;
            }
            Preconditions.checkElementIndex(i6, size());
            return this.rest[i6 - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }

        TwoPlusArrayList(@NullableDecl E e6, @NullableDecl E e7, E[] eArr) {
            this.first = e6;
            this.second = e7;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }
    }

    public static <E> List<E> asList(@NullableDecl E e6, E[] eArr) {
        return new OnePlusArrayList(e6, eArr);
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        return CartesianList.create(list);
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(str));
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        RandomAccessListWrapper(List<E> list) {
            super(list);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        RandomAccessPartition(List<T> list, int i6) {
            super(list, i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    public static <E> List<E> asList(@NullableDecl E e6, @NullableDecl E e7, E[] eArr) {
        return new TwoPlusArrayList(e6, e7, eArr);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    static <T> List<T> cast(Iterable<T> iterable) {
        return (List) iterable;
    }

    @Beta
    public static List<Character> charactersOf(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    @VisibleForTesting
    static int computeArrayListCapacity(int i6) {
        CollectPreconditions.checkNonnegative(i6, "arraySize");
        return Ints.saturatedCast(i6 + 5 + (i6 / 10));
    }

    static int indexOfImpl(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    static int lastIndexOfImpl(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int lastIndexOfRandomAccess(List<?> list, @NullableDecl Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    static <E> ListIterator<E> listIteratorImpl(List<E> list, int i6) {
        return new AbstractListWrapper(list).listIterator(i6);
    }

    @SafeVarargs
    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i6) {
        CollectPreconditions.checkNonnegative(i6, "initialArraySize");
        return new ArrayList<>(i6);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i6) {
        return new ArrayList<>(computeArrayListCapacity(i6));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> iterable) {
        return new CopyOnWriteArrayList<>(iterable instanceof Collection ? Collections2.cast(iterable) : newArrayList(iterable));
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    public static <T> List<T> reverse(List<T> list) {
        return list instanceof ImmutableList ? ((ImmutableList) list).reverse() : list instanceof ReverseList ? ((ReverseList) list).getForwardList() : list instanceof RandomAccess ? new RandomAccessReverseList(list) : new ReverseList(list);
    }

    static <E> List<E> subListImpl(List<E> list, int i6, int i7) {
        return (list instanceof RandomAccess ? new RandomAccessListWrapper<E>(list) { // from class: com.google.common.collect.Lists.1
            private static final long serialVersionUID = 0;

            @Override // java.util.AbstractList, java.util.List
            public ListIterator<E> listIterator(int i8) {
                return this.backingList.listIterator(i8);
            }
        } : new AbstractListWrapper<E>(list) { // from class: com.google.common.collect.Lists.2
            private static final long serialVersionUID = 0;

            @Override // java.util.AbstractList, java.util.List
            public ListIterator<E> listIterator(int i8) {
                return this.backingList.listIterator(i8);
            }
        }).subList(i6, i7);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    private Lists() {
    }

    static <E> boolean addAllImpl(List<E> list, int i6, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i6);
        Iterator<? extends E> it = iterable.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z5 = true;
        }
        return z5;
    }

    static boolean equalsImpl(List<?> list, @NullableDecl Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i6 = 0; i6 < size; i6++) {
                if (!Objects.equal(list.get(i6), list2.get(i6))) {
                    return false;
                }
            }
            return true;
        }
        return Iterators.elementsEqual(list.iterator(), list2.iterator());
    }

    static int hashCodeImpl(List<?> list) {
        int hashCode;
        int i6 = 1;
        for (Object obj : list) {
            int i7 = i6 * 31;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i6 = ~(~(i7 + hashCode));
        }
        return i6;
    }

    private static int indexOfRandomAccess(List<?> list, @NullableDecl Object obj) {
        int size = list.size();
        int i6 = 0;
        if (obj == null) {
            while (i6 < size) {
                if (list.get(i6) == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        while (i6 < size) {
            if (obj.equals(list.get(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static <T> List<List<T>> partition(List<T> list, int i6) {
        boolean z5;
        Preconditions.checkNotNull(list);
        if (i6 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        if (list instanceof RandomAccess) {
            return new RandomAccessPartition(list, i6);
        }
        return new Partition(list, i6);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(Collections2.cast(iterable));
        }
        return newArrayList(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }
}
