package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements SortedMultiset<E> {
    private static final long serialVersionUID = 0;

    @MonotonicNonNullDecl
    private transient UnmodifiableSortedMultiset<E> descendingMultiset;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public NavigableSet<E> createElementSet() {
        return Sets.unmodifiableNavigableSet(delegate().elementSet());
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset != null) {
            return unmodifiableSortedMultiset;
        }
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(delegate().descendingMultiset());
        unmodifiableSortedMultiset2.descendingMultiset = this;
        this.descendingMultiset = unmodifiableSortedMultiset2;
        return unmodifiableSortedMultiset2;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    UnmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        super(sortedMultiset);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E e6, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(delegate().headMultiset(e6, boundType));
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E e6, BoundType boundType, E e7, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(delegate().subMultiset(e6, boundType, e7, boundType2));
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E e6, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(delegate().tailMultiset(e6, boundType));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public SortedMultiset<E> delegate() {
        return (SortedMultiset) super.delegate();
    }
}
