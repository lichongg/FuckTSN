package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private ReverseNaturalOrdering() {
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e6, E e7) {
        return (E) NaturalOrdering.INSTANCE.min(e6, e7);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e6, E e7) {
        return (E) NaturalOrdering.INSTANCE.max(e6, e7);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e6, E e7, E e8, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.min(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e6, E e7, E e8, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.max(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.max(iterable);
    }
}
