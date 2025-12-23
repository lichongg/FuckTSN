package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class k0 extends b0<Comparable> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    static final k0 f15920a = new k0();

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private k0() {
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0
    public <S extends Comparable> b0<S> d() {
        return b0.b();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0, java.util.Comparator
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }
}
