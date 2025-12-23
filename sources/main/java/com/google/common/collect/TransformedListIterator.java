package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    private ListIterator<? extends F> backingIterator() {
        return Iterators.cast(this.backingIterator);
    }

    @Override // java.util.ListIterator
    public void add(T t5) {
        throw new UnsupportedOperationException();
    }

    public void set(T t5) {
        throw new UnsupportedOperationException();
    }

    TransformedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return backingIterator().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return backingIterator().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return transform(backingIterator().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return backingIterator().previousIndex();
    }
}
