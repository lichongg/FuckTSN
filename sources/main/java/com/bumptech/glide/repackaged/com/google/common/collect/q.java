package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import com.google.j2objc.annotations.Weak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class q<K, V> extends ImmutableSet.b<K> {

    /* renamed from: a, reason: collision with root package name */
    @Weak
    private final ImmutableMap<K, V> f15936a;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return true;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f15936a.containsKey(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet.b
    K get(int i6) {
        return this.f15936a.entrySet().asList().get(i6).getKey();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet.b, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public u0<K> iterator() {
        return this.f15936a.keyIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15936a.size();
    }

    q(ImmutableMap<K, V> immutableMap) {
        this.f15936a = immutableMap;
    }
}
