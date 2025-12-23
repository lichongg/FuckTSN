package io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Future<V> extends java.util.concurrent.Future<V> {
    Future<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Future<V> await() throws InterruptedException;

    boolean await(long j6) throws InterruptedException;

    boolean await(long j6, TimeUnit timeUnit) throws InterruptedException;

    Future<V> awaitUninterruptibly();

    boolean awaitUninterruptibly(long j6);

    boolean awaitUninterruptibly(long j6, TimeUnit timeUnit);

    boolean cancel(boolean z5);

    Throwable cause();

    V getNow();

    boolean isCancellable();

    boolean isSuccess();

    Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Future<V> sync() throws InterruptedException;

    Future<V> syncUninterruptibly();
}
