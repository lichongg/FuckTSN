package io.netty.util.concurrent;

import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class FailedFuture<V> extends CompleteFuture<V> {
    private final Throwable cause;

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<V> sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override // io.netty.util.concurrent.CompleteFuture, io.netty.util.concurrent.Future
    public Future<V> syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    public FailedFuture(EventExecutor eventExecutor, Throwable th) {
        super(eventExecutor);
        if (th != null) {
            this.cause = th;
            return;
        }
        throw new NullPointerException("cause");
    }
}
