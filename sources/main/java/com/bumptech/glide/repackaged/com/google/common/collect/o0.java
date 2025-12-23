package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class o0<E> extends ImmutableList<E> {

    /* renamed from: a, reason: collision with root package name */
    final transient E f15931a;

    @Override // java.util.List
    public E get(int i6) {
        com.bumptech.glide.repackaged.com.google.common.base.d.g(i6, 1);
        return this.f15931a;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<E> iterator() {
        return v.n(this.f15931a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int i6, int i7) {
        com.bumptech.glide.repackaged.com.google.common.base.d.m(i6, i7, 1);
        return i6 == i7 ? ImmutableList.of() : this;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f15931a.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    o0(E e6) {
        this.f15931a = (E) com.bumptech.glide.repackaged.com.google.common.base.d.i(e6);
    }
}
