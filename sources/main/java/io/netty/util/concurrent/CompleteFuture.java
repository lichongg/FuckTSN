package io.netty.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class CompleteFuture<V> extends AbstractFuture<V> {
    private final EventExecutor executor;

    @Override // io.netty.util.concurrent.Future
    public Future<V> await() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> awaitUninterruptibly() {
        return this;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        if (genericFutureListener == null) {
            throw new NullPointerException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        DefaultPromise.notifyListener(executor(), this, genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        if (genericFutureListenerArr == null) {
            throw new NullPointerException("listeners");
        }
        for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
            if (genericFutureListener == null) {
                break;
            }
            DefaultPromise.notifyListener(executor(), this, genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6) {
        return true;
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    protected CompleteFuture(EventExecutor eventExecutor) {
        this.executor = eventExecutor;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6, TimeUnit timeUnit) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6, TimeUnit timeUnit) {
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6) throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> sync() throws InterruptedException {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> syncUninterruptibly() {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        return this;
    }
}
