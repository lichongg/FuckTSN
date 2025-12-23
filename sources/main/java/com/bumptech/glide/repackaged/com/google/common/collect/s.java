package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class s<E> extends e0<E> implements q0<E> {
    s(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super(immutableSortedSet, immutableList);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.q0, java.util.SortedSet
    public Comparator<? super E> comparator() {
        return a().comparator();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.l, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.e0, com.bumptech.glide.repackaged.com.google.common.collect.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> a() {
        return (ImmutableSortedSet) super.a();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(Object obj) {
        int indexOf = a().indexOf(obj);
        if (indexOf >= 0 && get(indexOf).equals(obj)) {
            return indexOf;
        }
        return -1;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList
    ImmutableList<E> subListUnchecked(int i6, int i7) {
        return new j0(super.subListUnchecked(i6, i7), comparator()).asList();
    }
}
