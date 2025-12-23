package io.netty.util.concurrent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ProgressiveFuture<V> extends Future<V> {
    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> await() throws InterruptedException;

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> sync() throws InterruptedException;

    @Override // io.netty.util.concurrent.Future
    ProgressiveFuture<V> syncUninterruptibly();
}
