package xyz.adscope.common.v2.cache2;

import android.content.Context;
import xyz.adscope.common.v2.cache.LruCacheModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IResourceLruCache2 {
    void cacheResource(Context context, String str, LruCacheModel lruCacheModel);

    void getCacheResource(Context context, String str, LruCacheModel lruCacheModel, IResourceCacheCallback iResourceCacheCallback);

    void releaseCacheDirMemory(Context context);
}
