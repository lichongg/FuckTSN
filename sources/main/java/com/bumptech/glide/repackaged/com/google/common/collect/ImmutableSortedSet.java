package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ImmutableSortedSet<E> extends t<E> implements q0<E>, NavigableSet<E> {
    private static final j0<Comparable> NATURAL_EMPTY_SET;
    private static final Comparator<Comparable> NATURAL_ORDER;
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    @Override // java.util.NavigableSet
    public E ceiling(E e6) {
        return (E) u.c(tailSet((ImmutableSortedSet<E>) e6, true), null);
    }

    @Override // java.util.NavigableSet
    public abstract u0<E> descendingIterator();

    @Override // java.util.NavigableSet
    public E floor(E e6) {
        return (E) v.j(headSet((ImmutableSortedSet<E>) e6, true).descendingIterator(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z5) {
        return headSet((ImmutableSortedSet<E>) obj, z5);
    }

    abstract ImmutableSortedSet<E> headSetImpl(E e6, boolean z5);

    @Override // java.util.NavigableSet
    public E higher(E e6) {
        return (E) u.c(tailSet((ImmutableSortedSet<E>) e6, false), null);
    }

    abstract int indexOf(Object obj);

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract u0<E> iterator();

    @Override // java.util.NavigableSet
    public E lower(E e6) {
        return (E) v.j(headSet((ImmutableSortedSet<E>) e6, false).descendingIterator(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z5, Object obj2, boolean z6) {
        return subSet((boolean) obj, z5, (boolean) obj2, z6);
    }

    abstract ImmutableSortedSet<E> subSetImpl(E e6, boolean z5, E e7, boolean z6);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z5) {
        return tailSet((ImmutableSortedSet<E>) obj, z5);
    }

    abstract ImmutableSortedSet<E> tailSetImpl(E e6, boolean z5);

    int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    static <E> j0<E> emptySet(Comparator<? super E> comparator) {
        return NATURAL_ORDER.equals(comparator) ? (j0<E>) NATURAL_EMPTY_SET : new j0<>(ImmutableList.of(), comparator);
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.q0, java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    ImmutableSortedSet<E> createDescendingSet() {
        return new i(this);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    static {
        b0 b6 = b0.b();
        NATURAL_ORDER = b6;
        NATURAL_EMPTY_SET = new j0<>(ImmutableList.of(), b6);
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e6) {
        return headSet((ImmutableSortedSet<E>) e6, false);
    }

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e6, E e7) {
        return subSet((boolean) e6, true, (boolean) e7, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E e6) {
        return tailSet((ImmutableSortedSet<E>) e6, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e6, boolean z5) {
        return headSetImpl(com.bumptech.glide.repackaged.com.google.common.base.d.i(e6), z5);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e6, boolean z5, E e7, boolean z6) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(e6);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(e7);
        com.bumptech.glide.repackaged.com.google.common.base.d.d(this.comparator.compare(e6, e7) <= 0);
        return subSetImpl(e6, z5, e7, z6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> tailSet(E e6, boolean z5) {
        return tailSetImpl(com.bumptech.glide.repackaged.com.google.common.base.d.i(e6), z5);
    }
}
