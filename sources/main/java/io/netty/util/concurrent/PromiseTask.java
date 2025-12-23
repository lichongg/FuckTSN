package io.netty.util.concurrent;

import io.netty.util.internal.StringUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class PromiseTask<V> extends DefaultPromise<V> implements RunnableFuture<V> {
    protected final Callable<V> task;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class RunnableAdapter<T> implements Callable<T> {
        final T result;
        final Runnable task;

        @Override // java.util.concurrent.Callable
        public T call() {
            this.task.run();
            return this.result;
        }

        public String toString() {
            return "Callable(task: " + this.task + ", result: " + this.result + ')';
        }

        RunnableAdapter(Runnable runnable, T t5) {
            this.task = runnable;
            this.result = t5;
        }
    }

    PromiseTask(EventExecutor eventExecutor, Runnable runnable, V v5) {
        this(eventExecutor, toCallable(runnable, v5));
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean tryFailure(Throwable th) {
        return false;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean trySuccess(V v5) {
        return false;
    }

    PromiseTask(EventExecutor eventExecutor, Callable<V> callable) {
        super(eventExecutor);
        this.task = callable;
    }

    static <T> Callable<T> toCallable(Runnable runnable, T t5) {
        return new RunnableAdapter(runnable, t5);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public final Promise<V> setFailure(Throwable th) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public final Promise<V> setSuccess(V v5) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean setUncancellable() {
        throw new IllegalStateException();
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (setUncancellableInternal()) {
                setSuccessInternal(this.task.call());
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    protected final Promise<V> setFailureInternal(Throwable th) {
        super.setFailure(th);
        return this;
    }

    protected final Promise<V> setSuccessInternal(V v5) {
        super.setSuccess(v5);
        return this;
    }

    protected final boolean setUncancellableInternal() {
        return super.setUncancellable();
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    protected StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, StringUtil.COMMA);
        stringBuilder.append(" task: ");
        stringBuilder.append(this.task);
        stringBuilder.append(')');
        return stringBuilder;
    }

    protected final boolean tryFailureInternal(Throwable th) {
        return super.tryFailure(th);
    }

    protected final boolean trySuccessInternal(V v5) {
        return super.trySuccess(v5);
    }
}
