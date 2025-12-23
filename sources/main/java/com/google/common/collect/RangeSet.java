package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public interface RangeSet<C extends Comparable> {
    void add(Range<C> range);

    void addAll(RangeSet<C> rangeSet);

    void addAll(Iterable<Range<C>> iterable);

    Set<Range<C>> asDescendingSetOfRanges();

    Set<Range<C>> asRanges();

    void clear();

    RangeSet<C> complement();

    boolean contains(C c6);

    boolean encloses(Range<C> range);

    boolean enclosesAll(RangeSet<C> rangeSet);

    boolean enclosesAll(Iterable<Range<C>> iterable);

    boolean equals(@NullableDecl Object obj);

    int hashCode();

    boolean intersects(Range<C> range);

    boolean isEmpty();

    Range<C> rangeContaining(C c6);

    void remove(Range<C> range);

    void removeAll(RangeSet<C> rangeSet);

    void removeAll(Iterable<Range<C>> iterable);

    Range<C> span();

    RangeSet<C> subRangeSet(Range<C> range);

    String toString();
}
