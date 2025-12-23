package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class i0<E> extends ImmutableSet<E> {

    /* renamed from: e, reason: collision with root package name */
    static final i0<Object> f15911e = new i0<>(a0.f15878a, 0, null, 0);

    /* renamed from: a, reason: collision with root package name */
    private final transient Object[] f15912a;

    /* renamed from: b, reason: collision with root package name */
    final transient Object[] f15913b;

    /* renamed from: c, reason: collision with root package name */
    private final transient int f15914c;

    /* renamed from: d, reason: collision with root package name */
    private final transient int f15915d;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f15913b;
        if (obj == null || objArr == null) {
            return false;
        }
        int c6 = k.c(obj);
        while (true) {
            int i6 = c6 & this.f15914c;
            Object obj2 = objArr[i6];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c6 = i6 + 1;
        }
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        Object[] objArr2 = this.f15912a;
        System.arraycopy(objArr2, 0, objArr, i6, objArr2.length);
        return i6 + this.f15912a.length;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        return this.f15913b == null ? ImmutableList.of() : new e0(this, this.f15912a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f15915d;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<E> iterator() {
        return v.h(this.f15912a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15912a.length;
    }

    i0(Object[] objArr, int i6, Object[] objArr2, int i7) {
        this.f15912a = objArr;
        this.f15913b = objArr2;
        this.f15914c = i7;
        this.f15915d = i6;
    }
}
