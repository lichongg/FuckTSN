package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class l0<T> extends b0<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final b0<? super T> f15921a;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0, java.util.Comparator
    public int compare(T t5, T t6) {
        return this.f15921a.compare(t6, t5);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0
    public <S extends T> b0<S> d() {
        return this.f15921a;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l0) {
            return this.f15921a.equals(((l0) obj).f15921a);
        }
        return false;
    }

    public int hashCode() {
        return -this.f15921a.hashCode();
    }

    public String toString() {
        return this.f15921a + ".reverse()";
    }

    l0(b0<? super T> b0Var) {
        this.f15921a = (b0) com.bumptech.glide.repackaged.com.google.common.base.d.i(b0Var);
    }
}
