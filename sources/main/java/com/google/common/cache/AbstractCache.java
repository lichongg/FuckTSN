package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class SimpleStatsCounter implements StatsCounter {
        private final LongAddable hitCount = LongAddables.create();
        private final LongAddable missCount = LongAddables.create();
        private final LongAddable loadSuccessCount = LongAddables.create();
        private final LongAddable loadExceptionCount = LongAddables.create();
        private final LongAddable totalLoadTime = LongAddables.create();
        private final LongAddable evictionCount = LongAddables.create();

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
            this.evictionCount.increment();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i6) {
            this.hitCount.add(i6);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j6) {
            this.loadExceptionCount.increment();
            this.totalLoadTime.add(j6);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j6) {
            this.loadSuccessCount.increment();
            this.totalLoadTime.add(j6);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i6) {
            this.missCount.add(i6);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return new CacheStats(this.hitCount.sum(), this.missCount.sum(), this.loadSuccessCount.sum(), this.loadExceptionCount.sum(), this.totalLoadTime.sum(), this.evictionCount.sum());
        }

        public void incrementBy(StatsCounter statsCounter) {
            CacheStats snapshot = statsCounter.snapshot();
            this.hitCount.add(snapshot.hitCount());
            this.missCount.add(snapshot.missCount());
            this.loadSuccessCount.add(snapshot.loadSuccessCount());
            this.loadExceptionCount.add(snapshot.loadExceptionCount());
            this.totalLoadTime.add(snapshot.totalLoadTime());
            this.evictionCount.add(snapshot.evictionCount());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface StatsCounter {
        void recordEviction();

        void recordHits(int i6);

        void recordLoadException(long j6);

        void recordLoadSuccess(long j6);

        void recordMisses(int i6);

        CacheStats snapshot();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            invalidate(it.next());
        }
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public V get(K k6, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void put(K k6, V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    protected AbstractCache() {
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        V ifPresent;
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (Object obj : iterable) {
            if (!newLinkedHashMap.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                newLinkedHashMap.put(obj, ifPresent);
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }
}
