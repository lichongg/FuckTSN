package com.kwad.sdk.core.imageloader.cache.memory;

import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class LimitedMemoryCache extends BaseMemoryCache {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final List<DecodedResult> hardCache = Collections.synchronizedList(new LinkedList());
    private final AtomicInteger cacheSize = new AtomicInteger();

    protected abstract int getSize(DecodedResult decodedResult);

    protected abstract DecodedResult removeNext();

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected int getSizeLimit() {
        return this.sizeLimit;
    }

    public LimitedMemoryCache(int i6) {
        this.sizeLimit = i6;
        if (i6 > 16777216) {
            L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        boolean z5;
        int size = getSize(decodedResult);
        int sizeLimit = getSizeLimit();
        int i6 = this.cacheSize.get();
        if (size < sizeLimit) {
            while (i6 + size > sizeLimit) {
                DecodedResult removeNext = removeNext();
                if (this.hardCache.remove(removeNext)) {
                    i6 = this.cacheSize.addAndGet(-getSize(removeNext));
                }
            }
            this.hardCache.add(decodedResult);
            this.cacheSize.addAndGet(size);
            z5 = true;
        } else {
            z5 = false;
        }
        super.put(str, decodedResult);
        return z5;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        DecodedResult decodedResult = super.get(str);
        if (decodedResult != null && this.hardCache.remove(decodedResult)) {
            this.cacheSize.addAndGet(-getSize(decodedResult));
        }
        return super.remove(str);
    }
}
