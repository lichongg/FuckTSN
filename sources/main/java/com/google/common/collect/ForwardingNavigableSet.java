package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet() {
            super(ForwardingNavigableSet.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract NavigableSet<E> delegate();

    protected E standardCeiling(E e6) {
        return (E) Iterators.getNext(tailSet(e6, true).iterator(), null);
    }

    protected E standardFloor(E e6) {
        return (E) Iterators.getNext(headSet(e6, true).descendingIterator(), null);
    }

    protected SortedSet<E> standardHeadSet(E e6) {
        return headSet(e6, false);
    }

    protected E standardHigher(E e6) {
        return (E) Iterators.getNext(tailSet(e6, false).iterator(), null);
    }

    protected E standardLower(E e6) {
        return (E) Iterators.getNext(headSet(e6, false).descendingIterator(), null);
    }

    @Beta
    protected NavigableSet<E> standardSubSet(E e6, boolean z5, E e7, boolean z6) {
        return tailSet(e6, z5).headSet(e7, z6);
    }

    protected SortedSet<E> standardTailSet(E e6) {
        return tailSet(e6, true);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    protected SortedSet<E> standardSubSet(E e6, E e7) {
        return subSet(e6, true, e7, false);
    }

    protected ForwardingNavigableSet() {
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e6) {
        return delegate().ceiling(e6);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e6) {
        return delegate().floor(e6);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e6, boolean z5) {
        return delegate().headSet(e6, z5);
    }

    @Override // java.util.NavigableSet
    public E higher(E e6) {
        return delegate().higher(e6);
    }

    @Override // java.util.NavigableSet
    public E lower(E e6) {
        return delegate().lower(e6);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return delegate().pollLast();
    }

    protected E standardFirst() {
        return iterator().next();
    }

    protected E standardLast() {
        return descendingIterator().next();
    }

    protected E standardPollFirst() {
        return (E) Iterators.pollNext(iterator());
    }

    protected E standardPollLast() {
        return (E) Iterators.pollNext(descendingIterator());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e6, boolean z5, E e7, boolean z6) {
        return delegate().subSet(e6, z5, e7, z6);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e6, boolean z5) {
        return delegate().tailSet(e6, z5);
    }
}
