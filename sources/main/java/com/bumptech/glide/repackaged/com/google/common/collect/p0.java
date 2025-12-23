package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class p0<E> extends ImmutableSet<E> {

    /* renamed from: a, reason: collision with root package name */
    final transient E f15934a;

    /* renamed from: b, reason: collision with root package name */
    private transient int f15935b;

    p0(E e6) {
        this.f15934a = (E) com.bumptech.glide.repackaged.com.google.common.base.d.i(e6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f15934a.equals(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        objArr[i6] = this.f15934a;
        return i6 + 1;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i6 = this.f15935b;
        if (i6 != 0) {
            return i6;
        }
        int hashCode = this.f15934a.hashCode();
        this.f15935b = hashCode;
        return hashCode;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return this.f15935b != 0;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<E> iterator() {
        return v.n(this.f15934a);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f15934a.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    p0(E e6, int i6) {
        this.f15934a = e6;
        this.f15935b = i6;
    }
}
