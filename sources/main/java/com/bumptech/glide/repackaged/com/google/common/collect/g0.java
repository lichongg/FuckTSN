package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class g0<E> extends ImmutableList<E> {

    /* renamed from: d, reason: collision with root package name */
    static final ImmutableList<Object> f15902d = new g0(a0.f15878a);

    /* renamed from: a, reason: collision with root package name */
    private final transient int f15903a;

    /* renamed from: b, reason: collision with root package name */
    private final transient int f15904b;

    /* renamed from: c, reason: collision with root package name */
    private final transient Object[] f15905c;

    g0(Object[] objArr, int i6, int i7) {
        this.f15903a = i6;
        this.f15904b = i7;
        this.f15905c = objArr;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        System.arraycopy(this.f15905c, this.f15903a, objArr, i6, this.f15904b);
        return i6 + this.f15904b;
    }

    @Override // java.util.List
    public E get(int i6) {
        com.bumptech.glide.repackaged.com.google.common.base.d.g(i6, this.f15904b);
        return (E) this.f15905c[i6 + this.f15903a];
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.f15904b != this.f15905c.length;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public v0<E> listIterator(int i6) {
        return v.i(this.f15905c, this.f15903a, this.f15904b, i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15904b;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList
    ImmutableList<E> subListUnchecked(int i6, int i7) {
        return new g0(this.f15905c, this.f15903a + i6, i7 - i6);
    }

    g0(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }
}
