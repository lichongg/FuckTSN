package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    abstract E get(int i6);

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return new ImmutableList<E>() { // from class: com.google.common.collect.IndexedImmutableSet.1
            @Override // java.util.List
            public E get(int i6) {
                return (E) IndexedImmutableSet.this.get(i6);
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    IndexedImmutableSet() {
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    int copyIntoArray(Object[] objArr, int i6) {
        return asList().copyIntoArray(objArr, i6);
    }
}
