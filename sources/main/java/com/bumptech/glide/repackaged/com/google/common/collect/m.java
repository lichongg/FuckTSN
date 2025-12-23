package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class m<K, V> extends c<K, V> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final K f15922a;

    /* renamed from: b, reason: collision with root package name */
    final V f15923b;

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.c, java.util.Map.Entry
    public final K getKey() {
        return this.f15922a;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.c, java.util.Map.Entry
    public final V getValue() {
        return this.f15923b;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.c, java.util.Map.Entry
    public final V setValue(V v5) {
        throw new UnsupportedOperationException();
    }

    m(K k6, V v5) {
        this.f15922a = k6;
        this.f15923b = v5;
    }
}
