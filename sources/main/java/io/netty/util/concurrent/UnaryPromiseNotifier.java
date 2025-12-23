package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class UnaryPromiseNotifier<T> implements FutureListener<T> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) UnaryPromiseNotifier.class);
    private final Promise<? super T> promise;

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future<T> future) throws Exception {
        cascadeTo(future, this.promise);
    }

    public UnaryPromiseNotifier(Promise<? super T> promise) {
        this.promise = (Promise) ObjectUtil.checkNotNull(promise, "promise");
    }

    public static <X> void cascadeTo(Future<X> future, Promise<? super X> promise) {
        if (future.isSuccess()) {
            if (!promise.trySuccess(future.getNow())) {
                logger.warn("Failed to mark a promise as success because it is done already: {}", promise);
            }
        } else if (future.isCancelled()) {
            if (!promise.cancel(false)) {
                logger.warn("Failed to cancel a promise because it is done already: {}", promise);
            }
        } else if (!promise.tryFailure(future.cause())) {
            logger.warn("Failed to mark a promise as failure because it's done already: {}", promise, future.cause());
        }
    }
}
