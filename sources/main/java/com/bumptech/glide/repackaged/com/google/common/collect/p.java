package com.bumptech.glide.repackaged.com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
abstract class p<K, V> extends ImmutableSet<Map.Entry<K, V>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<K, V> extends p<K, V> {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        private final transient ImmutableMap<K, V> f15932a;

        /* renamed from: b, reason: collision with root package name */
        private final transient Map.Entry<K, V>[] f15933b;

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.p
        ImmutableMap<K, V> a() {
            return this.f15932a;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new e0(this, this.f15933b);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public u0<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        a(ImmutableMap<K, V> immutableMap, Map.Entry<K, V>[] entryArr) {
            this.f15932a = immutableMap;
            this.f15933b = entryArr;
        }
    }

    abstract ImmutableMap<K, V> a();

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            V v5 = a().get(entry.getKey());
            if (v5 != null && v5.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    p() {
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return a().hashCode();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return a().isHashCodeFast();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return a().isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a().size();
    }
}
