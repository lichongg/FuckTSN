package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface NameResolver<T> extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Future<T> resolve(String str);

    Future<T> resolve(String str, Promise<T> promise);

    Future<List<T>> resolveAll(String str);

    Future<List<T>> resolveAll(String str, Promise<List<T>> promise);
}
