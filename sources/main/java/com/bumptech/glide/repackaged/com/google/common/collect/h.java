package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class h<T> extends b0<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final Comparator<T> f15906a;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.b0, java.util.Comparator
    public int compare(T t5, T t6) {
        return this.f15906a.compare(t5, t6);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            return this.f15906a.equals(((h) obj).f15906a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15906a.hashCode();
    }

    public String toString() {
        return this.f15906a.toString();
    }

    h(Comparator<T> comparator) {
        this.f15906a = (Comparator) com.bumptech.glide.repackaged.com.google.common.base.d.i(comparator);
    }
}
