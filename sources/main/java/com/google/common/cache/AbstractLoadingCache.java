package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k6) {
        throw new UnsupportedOperationException();
    }

    protected AbstractLoadingCache() {
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final V apply(K k6) {
        return getUnchecked(k6);
    }

    @Override // com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (K k6 : iterable) {
            if (!newLinkedHashMap.containsKey(k6)) {
                newLinkedHashMap.put(k6, get(k6));
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K k6) {
        try {
            return get(k6);
        } catch (ExecutionException e6) {
            throw new UncheckedExecutionException(e6.getCause());
        }
    }
}
