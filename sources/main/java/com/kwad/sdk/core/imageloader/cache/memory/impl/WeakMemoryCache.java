package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class WeakMemoryCache extends BaseMemoryCache {
    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache
    public Reference<DecodedResult> createReference(DecodedResult decodedResult) {
        return new WeakReference(decodedResult);
    }
}
