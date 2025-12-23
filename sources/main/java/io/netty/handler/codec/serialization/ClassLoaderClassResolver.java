package io.netty.handler.codec.serialization;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class ClassLoaderClassResolver implements ClassResolver {
    private final ClassLoader classLoader;

    @Override // io.netty.handler.codec.serialization.ClassResolver
    public Class<?> resolve(String str) throws ClassNotFoundException {
        try {
            return this.classLoader.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return Class.forName(str, false, this.classLoader);
        }
    }

    ClassLoaderClassResolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
