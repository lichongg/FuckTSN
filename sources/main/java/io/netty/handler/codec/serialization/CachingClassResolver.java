package io.netty.handler.codec.serialization;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class CachingClassResolver implements ClassResolver {
    private final Map<String, Class<?>> classCache;
    private final ClassResolver delegate;

    @Override // io.netty.handler.codec.serialization.ClassResolver
    public Class<?> resolve(String str) throws ClassNotFoundException {
        Class<?> cls = this.classCache.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> resolve = this.delegate.resolve(str);
        this.classCache.put(str, resolve);
        return resolve;
    }

    CachingClassResolver(ClassResolver classResolver, Map<String, Class<?>> map) {
        this.delegate = classResolver;
        this.classCache = map;
    }
}
