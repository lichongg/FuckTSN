package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SimpleNameResolver<T> implements NameResolver<T> {
    private final EventExecutor executor;

    protected abstract void doResolve(String str, Promise<T> promise) throws Exception;

    protected abstract void doResolveAll(String str, Promise<List<T>> promise) throws Exception;

    @Override // io.netty.resolver.NameResolver
    public final Future<T> resolve(String str) {
        return resolve(str, executor().newPromise());
    }

    @Override // io.netty.resolver.NameResolver
    public final Future<List<T>> resolveAll(String str) {
        return resolveAll(str, executor().newPromise());
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    protected SimpleNameResolver(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    @Override // io.netty.resolver.NameResolver
    public Future<T> resolve(String str, Promise<T> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolve(str, promise);
            return promise;
        } catch (Exception e6) {
            return promise.setFailure(e6);
        }
    }

    @Override // io.netty.resolver.NameResolver
    public Future<List<T>> resolveAll(String str, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolveAll(str, promise);
            return promise;
        } catch (Exception e6) {
            return promise.setFailure(e6);
        }
    }

    @Override // io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
