package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractFuture<V> implements Future<V> {
    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        await();
        Throwable cause = cause();
        if (cause == null) {
            return getNow();
        }
        if (cause instanceof CancellationException) {
            throw ((CancellationException) cause);
        }
        throw new ExecutionException(cause);
    }

    @Override // java.util.concurrent.Future
    public V get(long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (await(j6, timeUnit)) {
            Throwable cause = cause();
            if (cause == null) {
                return getNow();
            }
            if (cause instanceof CancellationException) {
                throw ((CancellationException) cause);
            }
            throw new ExecutionException(cause);
        }
        throw new TimeoutException();
    }
}
