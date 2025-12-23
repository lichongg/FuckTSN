package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class e<F, T> extends b0<F> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final com.bumptech.glide.repackaged.com.google.common.base.a<F, ? extends T> f15887a;

    /* renamed from: b, reason: collision with root package name */
    final b0<T> f15888b;

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f15887a.equals(eVar.f15887a) && this.f15888b.equals(eVar.f15888b)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0, java.util.Comparator
    public int compare(F f6, F f7) {
        return this.f15888b.compare(this.f15887a.apply(f6), this.f15887a.apply(f7));
    }

    public int hashCode() {
        return com.bumptech.glide.repackaged.com.google.common.base.c.b(this.f15887a, this.f15888b);
    }

    public String toString() {
        return this.f15888b + ".onResultOf(" + this.f15887a + ")";
    }

    e(com.bumptech.glide.repackaged.com.google.common.base.a<F, ? extends T> aVar, b0<T> b0Var) {
        this.f15887a = (com.bumptech.glide.repackaged.com.google.common.base.a) com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        this.f15888b = (b0) com.bumptech.glide.repackaged.com.google.common.base.d.i(b0Var);
    }
}
