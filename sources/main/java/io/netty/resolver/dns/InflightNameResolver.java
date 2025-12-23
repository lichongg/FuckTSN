package io.netty.resolver.dns;

import io.netty.resolver.NameResolver;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class InflightNameResolver<T> implements NameResolver<T> {
    private final NameResolver<T> delegate;
    private final EventExecutor executor;
    private final ConcurrentMap<String, Promise<List<T>>> resolveAllsInProgress;
    private final ConcurrentMap<String, Promise<T>> resolvesInProgress;

    @Override // io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // io.netty.resolver.NameResolver
    public Future<T> resolve(String str) {
        return resolve(str, (Promise) this.executor.newPromise());
    }

    @Override // io.netty.resolver.NameResolver
    public Future<List<T>> resolveAll(String str) {
        return resolveAll(str, (Promise) this.executor.newPromise());
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.delegate + ')';
    }

    InflightNameResolver(EventExecutor eventExecutor, NameResolver<T> nameResolver, ConcurrentMap<String, Promise<T>> concurrentMap, ConcurrentMap<String, Promise<List<T>>> concurrentMap2) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
        this.delegate = (NameResolver) ObjectUtil.checkNotNull(nameResolver, "delegate");
        this.resolvesInProgress = (ConcurrentMap) ObjectUtil.checkNotNull(concurrentMap, "resolvesInProgress");
        this.resolveAllsInProgress = (ConcurrentMap) ObjectUtil.checkNotNull(concurrentMap2, "resolveAllsInProgress");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void transferResult(Future<T> future, Promise<T> promise) {
        if (future.isSuccess()) {
            promise.trySuccess(future.getNow());
        } else {
            promise.tryFailure(future.cause());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.NameResolver
    public Promise<T> resolve(String str, Promise<T> promise) {
        return (Promise<T>) resolve(this.resolvesInProgress, str, promise, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.NameResolver
    public Promise<List<T>> resolveAll(String str, Promise<List<T>> promise) {
        return (Promise<List<T>>) resolve(this.resolveAllsInProgress, str, promise, true);
    }

    private <U> Promise<U> resolve(final ConcurrentMap<String, Promise<U>> concurrentMap, final String str, final Promise<U> promise, boolean z5) {
        Promise<U> putIfAbsent = concurrentMap.putIfAbsent(str, promise);
        if (putIfAbsent != null) {
            if (putIfAbsent.isDone()) {
                transferResult(putIfAbsent, promise);
                return promise;
            }
            putIfAbsent.addListener((GenericFutureListener<? extends Future<? super U>>) new FutureListener<U>() { // from class: io.netty.resolver.dns.InflightNameResolver.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<U> future) throws Exception {
                    InflightNameResolver.transferResult(future, promise);
                }
            });
            return promise;
        }
        try {
            if (z5) {
                this.delegate.resolveAll(str, promise);
            } else {
                this.delegate.resolve(str, promise);
            }
            if (promise.isDone()) {
                concurrentMap.remove(str);
                return promise;
            }
            promise.addListener((GenericFutureListener<? extends Future<? super U>>) new FutureListener<U>() { // from class: io.netty.resolver.dns.InflightNameResolver.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<U> future) throws Exception {
                    concurrentMap.remove(str);
                }
            });
            return promise;
        } catch (Throwable th) {
            if (promise.isDone()) {
                concurrentMap.remove(str);
            } else {
                promise.addListener((GenericFutureListener<? extends Future<? super U>>) new FutureListener<U>() { // from class: io.netty.resolver.dns.InflightNameResolver.2
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<U> future) throws Exception {
                        concurrentMap.remove(str);
                    }
                });
            }
            throw th;
        }
    }
}
