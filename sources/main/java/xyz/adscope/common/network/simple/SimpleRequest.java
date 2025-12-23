package xyz.adscope.common.network.simple;

import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.simple.cache.CacheMode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface SimpleRequest {
    String cacheKey();

    CacheMode cacheMode();

    Converter converter();

    Headers headers();

    Url url();
}
