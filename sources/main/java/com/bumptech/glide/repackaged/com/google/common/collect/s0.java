package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
abstract class s0<F, T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    final Iterator<? extends F> f15942a;

    abstract T a(F f6);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15942a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f15942a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f15942a.remove();
    }

    s0(Iterator<? extends F> it) {
        this.f15942a = (Iterator) com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
    }
}
