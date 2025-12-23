package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.ListIterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
abstract class t0<F, T> extends s0<F, T> implements ListIterator<T> {
    private ListIterator<? extends F> b() {
        return v.c(this.f15942a);
    }

    @Override // java.util.ListIterator
    public void add(T t5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void set(T t5) {
        throw new UnsupportedOperationException();
    }

    t0(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }
}
