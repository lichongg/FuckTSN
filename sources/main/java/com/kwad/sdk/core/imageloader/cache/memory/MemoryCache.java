package com.kwad.sdk.core.imageloader.cache.memory;

import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.Collection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface MemoryCache {
    void clear();

    DecodedResult get(String str);

    Collection<String> keys();

    boolean put(String str, DecodedResult decodedResult);

    DecodedResult remove(String str);
}
