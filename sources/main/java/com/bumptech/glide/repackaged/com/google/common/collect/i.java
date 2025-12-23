package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class i<E> extends ImmutableSortedSet<E> {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableSortedSet<E> f15910a;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e6) {
        return this.f15910a.floor(e6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f15910a.contains(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public u0<E> descendingIterator() {
        return this.f15910a.iterator();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        return this.f15910a;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e6) {
        return this.f15910a.ceiling(e6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> headSetImpl(E e6, boolean z5) {
        return this.f15910a.tailSet((ImmutableSortedSet<E>) e6, z5).descendingSet();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e6) {
        return this.f15910a.lower(e6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    int indexOf(Object obj) {
        int indexOf = this.f15910a.indexOf(obj);
        return indexOf == -1 ? indexOf : (size() - 1) - indexOf;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.f15910a.isPartialView();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<E> iterator() {
        return this.f15910a.descendingIterator();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e6) {
        return this.f15910a.higher(e6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15910a.size();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E e6, boolean z5, E e7, boolean z6) {
        return this.f15910a.subSet((boolean) e7, z6, (boolean) e6, z5).descendingSet();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E e6, boolean z5) {
        return this.f15910a.headSet((ImmutableSortedSet<E>) e6, z5).descendingSet();
    }

    i(ImmutableSortedSet<E> immutableSortedSet) {
        super(b0.a(immutableSortedSet.comparator()).d());
        this.f15910a = immutableSortedSet;
    }
}
