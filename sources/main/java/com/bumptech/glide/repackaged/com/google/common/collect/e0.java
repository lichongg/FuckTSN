package com.bumptech.glide.repackaged.com.google.common.collect;

import com.google.j2objc.annotations.Weak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class e0<E> extends l<E> {

    /* renamed from: a, reason: collision with root package name */
    @Weak
    private final ImmutableCollection<E> f15889a;

    /* renamed from: b, reason: collision with root package name */
    private final ImmutableList<? extends E> f15890b;

    e0(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.f15889a = immutableCollection;
        this.f15890b = immutableList;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.l
    ImmutableCollection<E> a() {
        return this.f15889a;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        return this.f15890b.copyIntoArray(objArr, i6);
    }

    @Override // java.util.List
    public E get(int i6) {
        return this.f15890b.get(i6);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public v0<E> listIterator(int i6) {
        return this.f15890b.listIterator(i6);
    }

    e0(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }
}
