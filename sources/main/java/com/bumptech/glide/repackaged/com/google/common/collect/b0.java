package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class b0<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public abstract int compare(T t5, T t6);

    public static <T> b0<T> a(Comparator<T> comparator) {
        return comparator instanceof b0 ? (b0) comparator : new h(comparator);
    }

    public static <C extends Comparable> b0<C> b() {
        return z.f15971a;
    }

    public <F> b0<F> c(com.bumptech.glide.repackaged.com.google.common.base.a<F, ? extends T> aVar) {
        return new e(aVar, this);
    }

    public <S extends T> b0<S> d() {
        return new l0(this);
    }

    protected b0() {
    }
}
