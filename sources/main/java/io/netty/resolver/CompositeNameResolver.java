package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CompositeNameResolver<T> extends SimpleNameResolver<T> {
    private final NameResolver<T>[] resolvers;

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolve(String str, Promise<T> promise) throws Exception {
        doResolveRec(str, promise, 0, null);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String str, Promise<List<T>> promise) throws Exception {
        doResolveAllRec(str, promise, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllRec(final String str, final Promise<List<T>> promise, final int i6, Throwable th) throws Exception {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i6 >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i6].resolveAll(str).addListener(new FutureListener<List<T>>() { // from class: io.netty.resolver.CompositeNameResolver.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<List<T>> future) throws Exception {
                    if (!future.isSuccess()) {
                        CompositeNameResolver.this.doResolveAllRec(str, promise, i6 + 1, future.cause());
                    } else {
                        promise.setSuccess(future.getNow());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveRec(final String str, final Promise<T> promise, final int i6, Throwable th) throws Exception {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i6 >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i6].resolve(str).addListener(new FutureListener<T>() { // from class: io.netty.resolver.CompositeNameResolver.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) throws Exception {
                    if (!future.isSuccess()) {
                        CompositeNameResolver.this.doResolveRec(str, promise, i6 + 1, future.cause());
                    } else {
                        promise.setSuccess(future.getNow());
                    }
                }
            });
        }
    }

    public CompositeNameResolver(EventExecutor eventExecutor, NameResolver<T>... nameResolverArr) {
        super(eventExecutor);
        ObjectUtil.checkNotNull(nameResolverArr, "resolvers");
        for (int i6 = 0; i6 < nameResolverArr.length; i6++) {
            if (nameResolverArr[i6] == null) {
                throw new NullPointerException("resolvers[" + i6 + ']');
            }
        }
        if (nameResolverArr.length >= 2) {
            this.resolvers = (NameResolver[]) nameResolverArr.clone();
            return;
        }
        throw new IllegalArgumentException("resolvers: " + Arrays.asList(nameResolverArr) + " (expected: at least 2 resolvers)");
    }
}
