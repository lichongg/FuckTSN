package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class z extends b0<Comparable> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    static final z f15971a = new z();

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0
    public <S extends Comparable> b0<S> d() {
        return k0.f15920a;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private z() {
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0, java.util.Comparator
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparable);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparable2);
        return comparable.compareTo(comparable2);
    }
}
