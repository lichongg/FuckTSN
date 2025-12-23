package okhttp3.internal.cache;

import kotlin.jvm.internal.g0;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.internal.http.HttpMethod;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CacheInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Request requestForCache(Request request) {
        HttpUrl cacheUrlOverride = request.cacheUrlOverride();
        if (cacheUrlOverride != null) {
            if (HttpMethod.INSTANCE.isCacheable(request.method()) || g0.g(request.method(), "POST")) {
                return request.newBuilder().get().url(cacheUrlOverride).cacheUrlOverride(null).build();
            }
            return request;
        }
        return request;
    }
}
