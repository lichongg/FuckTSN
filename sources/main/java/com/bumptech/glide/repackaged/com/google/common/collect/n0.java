package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class n0<K, V> extends ImmutableBiMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final transient K f15926a;

    /* renamed from: b, reason: collision with root package name */
    final transient V f15927b;

    /* renamed from: c, reason: collision with root package name */
    transient ImmutableBiMap<V, K> f15928c;

    n0(K k6, V v5) {
        f.a(k6, v5);
        this.f15926a = k6;
        this.f15927b = v5;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f15926a.equals(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this.f15927b.equals(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(x.b(this.f15926a, this.f15927b));
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.f15926a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        if (this.f15926a.equals(obj)) {
            return this.f15927b;
        }
        return null;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableBiMap
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> immutableBiMap = this.f15928c;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        n0 n0Var = new n0(this.f15927b, this.f15926a, this);
        this.f15928c = n0Var;
        return n0Var;
    }

    private n0(K k6, V v5, ImmutableBiMap<V, K> immutableBiMap) {
        this.f15926a = k6;
        this.f15927b = v5;
        this.f15928c = immutableBiMap;
    }
}
