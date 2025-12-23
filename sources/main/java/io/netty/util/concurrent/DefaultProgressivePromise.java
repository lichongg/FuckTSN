package io.netty.util.concurrent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultProgressivePromise<V> extends DefaultPromise<V> implements ProgressivePromise<V> {
    public DefaultProgressivePromise(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public /* bridge */ /* synthetic */ Promise setSuccess(Object obj) {
        return setSuccess((DefaultProgressivePromise<V>) obj);
    }

    @Override // io.netty.util.concurrent.ProgressivePromise
    public boolean tryProgress(long j6, long j7) {
        if (j7 < 0) {
            if (j6 < 0 || isDone()) {
                return false;
            }
            j7 = -1;
        } else if (j6 < 0 || j6 > j7 || isDone()) {
            return false;
        }
        notifyProgressiveListeners(j6, j7);
        return true;
    }

    protected DefaultProgressivePromise() {
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public ProgressivePromise<V> setFailure(Throwable th) {
        super.setFailure(th);
        return this;
    }

    public ProgressivePromise<V> setProgress(long j6, long j7) {
        if (j7 < 0) {
            if (j6 < 0) {
                throw new IllegalArgumentException("progress: " + j6 + " (expected: >= 0)");
            }
            j7 = -1;
        } else if (j6 < 0 || j6 > j7) {
            throw new IllegalArgumentException("progress: " + j6 + " (expected: 0 <= progress <= total (" + j7 + "))");
        }
        if (isDone()) {
            throw new IllegalStateException("complete already");
        }
        notifyProgressiveListeners(j6, j7);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise<V> setSuccess(V v5) {
        super.setSuccess((DefaultProgressivePromise<V>) v5);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> await() throws InterruptedException {
        super.await();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> sync() throws InterruptedException {
        super.sync();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ProgressivePromise<V> syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }
}
