package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private int f16307a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f16307a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k6, V v5) {
        this.f16307a = 0;
        return (V) super.put(k6, v5);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f16307a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i6) {
        this.f16307a = 0;
        return (V) super.removeAt(i6);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i6, V v5) {
        this.f16307a = 0;
        return (V) super.setValueAt(i6, v5);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f16307a == 0) {
            this.f16307a = super.hashCode();
        }
        return this.f16307a;
    }
}
