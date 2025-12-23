package com.google.common.graph;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry1;

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry2;

    private void addToCache(K k6, V v5) {
        addToCache(new CacheEntry<>(k6, v5));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CacheEntry<K, V> {
        final K key;
        final V value;

        CacheEntry(K k6, V v5) {
            this.key = k6;
            this.value = v5;
        }
    }

    private void addToCache(CacheEntry<K, V> cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }

    MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    @Override // com.google.common.graph.MapIteratorCache
    protected void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    public V get(@NullableDecl Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        V withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }

    @Override // com.google.common.graph.MapIteratorCache
    protected V getIfCached(@NullableDecl Object obj) {
        V v5 = (V) super.getIfCached(obj);
        if (v5 != null) {
            return v5;
        }
        CacheEntry<K, V> cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.key == obj) {
            return cacheEntry.value;
        }
        CacheEntry<K, V> cacheEntry2 = this.cacheEntry2;
        if (cacheEntry2 != null && cacheEntry2.key == obj) {
            addToCache(cacheEntry2);
            return cacheEntry2.value;
        }
        return null;
    }
}
