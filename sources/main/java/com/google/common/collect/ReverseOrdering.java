package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e6, E e7) {
        return (E) this.forwardOrder.min(e6, e7);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e6, E e7) {
        return (E) this.forwardOrder.max(e6, e7);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t5, T t6) {
        return this.forwardOrder.compare(t6, t5);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e6, E e7, E e8, E... eArr) {
        return (E) this.forwardOrder.min(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e6, E e7, E e8, E... eArr) {
        return (E) this.forwardOrder.max(e6, e7, e8, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(ordering);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }
}
