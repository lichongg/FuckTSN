package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient long[] cumulativeCounts;

    @VisibleForTesting
    final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;
    private static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    private int getCount(int i6) {
        long[] jArr = this.cumulativeCounts;
        int i7 = this.offset;
        return (int) (jArr[(i7 + i6) + 1] - jArr[i7 + i6]);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int i6) {
        return Multisets.immutableEntry(this.elementSet.asList().get(i6), getCount(i6));
    }

    ImmutableSortedMultiset<E> getSubMultiset(int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i7, this.length);
        return i6 == i7 ? ImmutableSortedMultiset.emptyMultiset(comparator()) : (i6 == 0 && i7 == this.length) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i6, i7), this.cumulativeCounts, this.offset + i6, i7 - i6);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E e6, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e6, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i6 = this.offset;
        return Ints.saturatedCast(jArr[this.length + i6] - jArr[i6]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E e6, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e6, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i6, int i7) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i6;
        this.length = i7;
    }
}
