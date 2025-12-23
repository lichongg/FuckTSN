package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.SortedLists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class j0<E> extends ImmutableSortedSet<E> {

    /* renamed from: a, reason: collision with root package name */
    private final transient ImmutableList<E> f15918a;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e6) {
        int e7 = e(e6, true);
        if (e7 == size()) {
            return null;
        }
        return this.f15918a.get(e7);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (f(obj) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!r0.b(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            u0<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || unsafeCompare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e6) {
        int d6 = d(e6, true) - 1;
        if (d6 == -1) {
            return null;
        }
        return this.f15918a.get(d6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> headSetImpl(E e6, boolean z5) {
        return a(0, d(e6, z5));
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e6) {
        int e7 = e(e6, false);
        if (e7 == size()) {
            return null;
        }
        return this.f15918a.get(e7);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    int indexOf(Object obj) {
        int a6;
        if (obj == null) {
            return -1;
        }
        try {
            a6 = SortedLists.a(this.f15918a, obj, g(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
        } catch (ClassCastException unused) {
        }
        if (a6 >= 0) {
            return a6;
        }
        return -1;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e6) {
        int d6 = d(e6, false) - 1;
        if (d6 == -1) {
            return null;
        }
        return this.f15918a.get(d6);
    }

    private int f(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.f15918a, obj, g());
    }

    j0<E> a(int i6, int i7) {
        return (i6 == 0 && i7 == size()) ? this : i6 < i7 ? new j0<>(this.f15918a.subList(i6, i7), this.comparator) : ImmutableSortedSet.emptySet(this.comparator);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof y) {
            collection = ((y) collection).elementSet();
        }
        if (!r0.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        c0 m6 = v.m(iterator());
        Iterator<?> it = collection.iterator();
        Object next = it.next();
        while (m6.hasNext()) {
            try {
                int unsafeCompare = unsafeCompare(m6.peek(), next);
                if (unsafeCompare < 0) {
                    m6.next();
                } else if (unsafeCompare == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (unsafeCompare > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        return this.f15918a.copyIntoArray(objArr, i6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        b0 d6 = b0.a(this.comparator).d();
        return isEmpty() ? ImmutableSortedSet.emptySet(d6) : new j0(this.f15918a.reverse(), d6);
    }

    int d(E e6, boolean z5) {
        return SortedLists.a(this.f15918a, com.bumptech.glide.repackaged.com.google.common.base.d.i(e6), comparator(), z5 ? SortedLists.KeyPresentBehavior.FIRST_AFTER : SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public u0<E> descendingIterator() {
        return this.f15918a.reverse().iterator();
    }

    int e(E e6, boolean z5) {
        return SortedLists.a(this.f15918a, com.bumptech.glide.repackaged.com.google.common.base.d.i(e6), comparator(), z5 ? SortedLists.KeyPresentBehavior.FIRST_PRESENT : SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }

    Comparator<Object> g() {
        return this.comparator;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.f15918a.isPartialView();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<E> iterator() {
        return this.f15918a.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15918a.size();
    }

    j0(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.f15918a = immutableList;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        if (size() <= 1) {
            return this.f15918a;
        }
        return new s(this, this.f15918a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.f15918a.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.f15918a.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E e6, boolean z5, E e7, boolean z6) {
        return tailSetImpl(e6, z5).headSetImpl(e7, z6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E e6, boolean z5) {
        return a(e(e6, z5), size());
    }
}
