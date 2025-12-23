package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    @Beta
    public static ContiguousSet<Integer> closed(int i6, int i7) {
        return create(Range.closed(Integer.valueOf(i6), Integer.valueOf(i7)), DiscreteDomain.integers());
    }

    @Beta
    public static ContiguousSet<Integer> closedOpen(int i6, int i7) {
        return create(Range.closedOpen(Integer.valueOf(i6), Integer.valueOf(i7)), DiscreteDomain.integers());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> headSetImpl(C c6, boolean z5);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> subSetImpl(C c6, boolean z5, C c7, boolean z6);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> tailSetImpl(C c6, boolean z5);

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Beta
    public static ContiguousSet<Long> closed(long j6, long j7) {
        return create(Range.closed(Long.valueOf(j6), Long.valueOf(j7)), DiscreteDomain.longs());
    }

    @Beta
    public static ContiguousSet<Long> closedOpen(long j6, long j7) {
        return create(Range.closedOpen(Long.valueOf(j6), Long.valueOf(j7)), DiscreteDomain.longs());
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Range<C> range2;
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            if (!range.hasLowerBound()) {
                range2 = range.intersection(Range.atLeast(discreteDomain.minValue()));
            } else {
                range2 = range;
            }
            if (!range.hasUpperBound()) {
                range2 = range2.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            if (!range2.isEmpty() && Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) <= 0) {
                return new RegularContiguousSet(range2, discreteDomain);
            }
            return new EmptyContiguousSet(discreteDomain);
        } catch (NoSuchElementException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> headSet(C c6) {
        return headSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c6), false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c6, C c7) {
        Preconditions.checkNotNull(c6);
        Preconditions.checkNotNull(c7);
        Preconditions.checkArgument(comparator().compare(c6, c7) <= 0);
        return subSetImpl((boolean) c6, true, (boolean) c7, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> tailSet(C c6) {
        return tailSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c6), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> headSet(C c6, boolean z5) {
        return headSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c6), z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c6, boolean z5) {
        return tailSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c6), z5);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ContiguousSet<C> subSet(C c6, boolean z5, C c7, boolean z6) {
        Preconditions.checkNotNull(c6);
        Preconditions.checkNotNull(c7);
        Preconditions.checkArgument(comparator().compare(c6, c7) <= 0);
        return subSetImpl((boolean) c6, z5, (boolean) c7, z6);
    }
}
