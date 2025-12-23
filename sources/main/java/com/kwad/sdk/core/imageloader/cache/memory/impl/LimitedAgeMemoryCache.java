package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LimitedAgeMemoryCache implements MemoryCache {
    private final MemoryCache cache;
    private final Map<String, Long> loadingDates = Collections.synchronizedMap(new HashMap());
    private final long maxAge;

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.cache.clear();
        this.loadingDates.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult get(String str) {
        Long l6 = this.loadingDates.get(str);
        if (l6 != null && System.currentTimeMillis() - l6.longValue() > this.maxAge) {
            this.cache.remove(str);
            this.loadingDates.remove(str);
        }
        return this.cache.get(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        return this.cache.keys();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        boolean put = this.cache.put(str, decodedResult);
        if (put) {
            this.loadingDates.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return put;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        this.loadingDates.remove(str);
        return this.cache.remove(str);
    }

    public LimitedAgeMemoryCache(MemoryCache memoryCache, long j6) {
        this.cache = memoryCache;
        this.maxAge = j6 * 1000;
    }
}
