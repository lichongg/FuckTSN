package io.netty.util.concurrent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SucceededFuture<V> extends CompleteFuture<V> {
    private final V result;

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        return this.result;
    }

    public SucceededFuture(EventExecutor eventExecutor, V v5) {
        super(eventExecutor);
        this.result = v5;
    }
}
