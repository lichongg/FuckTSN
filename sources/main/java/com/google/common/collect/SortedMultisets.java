package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class SortedMultisets {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {

        @Weak
        private final SortedMultiset<E> multiset;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.ElementSet
        public final SortedMultiset<E> multiset() {
            return this.multiset;
        }

        ElementSet(SortedMultiset<E> sortedMultiset) {
            this.multiset = sortedMultiset;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) SortedMultisets.getElementOrThrow(multiset().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e6) {
            return multiset().headMultiset(e6, BoundType.OPEN).elementSet();
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) SortedMultisets.getElementOrThrow(multiset().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e6, E e7) {
            return multiset().subMultiset(e6, BoundType.CLOSED, e7, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e6) {
            return multiset().tailMultiset(e6, BoundType.CLOSED).elementSet();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtIncompatible
    static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(multiset().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e6, boolean z5) {
            return new NavigableElementSet(multiset().headMultiset(e6, BoundType.forBoolean(z5)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e6, boolean z5, E e7, boolean z6) {
            return new NavigableElementSet(multiset().subMultiset(e6, BoundType.forBoolean(z5), e7, BoundType.forBoolean(z6)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e6, boolean z5) {
            return new NavigableElementSet(multiset().tailMultiset(e6, BoundType.forBoolean(z5)));
        }

        NavigableElementSet(SortedMultiset<E> sortedMultiset) {
            super(sortedMultiset);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e6) {
            return (E) SortedMultisets.getElementOrNull(multiset().tailMultiset(e6, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public E floor(E e6) {
            return (E) SortedMultisets.getElementOrNull(multiset().headMultiset(e6, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E higher(E e6) {
            return (E) SortedMultisets.getElementOrNull(multiset().tailMultiset(e6, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e6) {
            return (E) SortedMultisets.getElementOrNull(multiset().headMultiset(e6, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) SortedMultisets.getElementOrNull(multiset().pollLastEntry());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E getElementOrNull(@NullableDecl Multiset.Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E getElementOrThrow(Multiset.Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }

    private SortedMultisets() {
    }
}
