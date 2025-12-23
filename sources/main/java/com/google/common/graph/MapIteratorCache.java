package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class MapIteratorCache<K, V> {
    private final Map<K, V> backingMap;

    @NullableDecl
    private transient Map.Entry<K, V> entrySetCache;

    protected void clearCache() {
        this.entrySetCache = null;
    }

    protected V getIfCached(@NullableDecl Object obj) {
        Map.Entry<K, V> entry = this.entrySetCache;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    public final V getWithoutCaching(@NullableDecl Object obj) {
        return this.backingMap.get(obj);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() { // from class: com.google.common.graph.MapIteratorCache.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return MapIteratorCache.this.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<K> iterator() {
                final Iterator<Map.Entry<K, V>> it = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() { // from class: com.google.common.graph.MapIteratorCache.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        Map.Entry entry = (Map.Entry) it.next();
                        MapIteratorCache.this.entrySetCache = entry;
                        return (K) entry.getKey();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }
        };
    }

    MapIteratorCache(Map<K, V> map) {
        this.backingMap = (Map) Preconditions.checkNotNull(map);
    }

    public void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        if (getIfCached(obj) == null && !this.backingMap.containsKey(obj)) {
            return false;
        }
        return true;
    }

    public V get(@NullableDecl Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        return getWithoutCaching(obj);
    }

    @CanIgnoreReturnValue
    public V put(@NullableDecl K k6, @NullableDecl V v5) {
        clearCache();
        return this.backingMap.put(k6, v5);
    }

    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        clearCache();
        return this.backingMap.remove(obj);
    }
}
