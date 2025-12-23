package io.netty.util.concurrent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Promise<V> extends Future<V> {
    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Promise<V> await() throws InterruptedException;

    Promise<V> awaitUninterruptibly();

    Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Promise<V> setFailure(Throwable th);

    Promise<V> setSuccess(V v5);

    boolean setUncancellable();

    Promise<V> sync() throws InterruptedException;

    Promise<V> syncUninterruptibly();

    boolean tryFailure(Throwable th);

    boolean trySuccess(V v5);
}
