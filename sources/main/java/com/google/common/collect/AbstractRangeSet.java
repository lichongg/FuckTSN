package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    @Override // com.google.common.collect.RangeSet
    public void addAll(RangeSet<C> rangeSet) {
        addAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public abstract boolean encloses(Range<C> range);

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(RangeSet<C> rangeSet) {
        return enclosesAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public abstract Range<C> rangeContaining(C c6);

    @Override // com.google.common.collect.RangeSet
    public void removeAll(RangeSet<C> rangeSet) {
        removeAll(rangeSet.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            if (!encloses(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.collect.RangeSet
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return asRanges().equals(((RangeSet) obj).asRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    AbstractRangeSet() {
    }

    @Override // com.google.common.collect.RangeSet
    public void clear() {
        remove(Range.all());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean contains(C c6) {
        if (rangeContaining(c6) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public final String toString() {
        return asRanges().toString();
    }
}
