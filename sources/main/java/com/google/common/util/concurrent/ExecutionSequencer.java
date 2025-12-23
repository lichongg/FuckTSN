package com.google.common.util.concurrent;

import androidx.camera.view.p;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Object>> ref = new AtomicReference<>(Futures.immediateFuture(null));

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    private ExecutionSequencer() {
    }

    public <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        return submitAsync(new AsyncCallable<T>() { // from class: com.google.common.util.concurrent.ExecutionSequencer.1
            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> asyncCallable, final Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        final AtomicReference atomicReference = new AtomicReference(RunningState.NOT_RUN);
        AsyncCallable<T> asyncCallable2 = new AsyncCallable<T>() { // from class: com.google.common.util.concurrent.ExecutionSequencer.2
            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<T> call() throws Exception {
                return !p.a(atomicReference, RunningState.NOT_RUN, RunningState.STARTED) ? Futures.immediateCancelledFuture() : asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        final SettableFuture create = SettableFuture.create();
        final ListenableFuture<Object> andSet = this.ref.getAndSet(create);
        final ListenableFuture submitAsync = Futures.submitAsync(asyncCallable2, new Executor() { // from class: com.google.common.util.concurrent.ExecutionSequencer.3
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                andSet.addListener(runnable, executor);
            }
        });
        final ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(submitAsync);
        Runnable runnable = new Runnable() { // from class: com.google.common.util.concurrent.ExecutionSequencer.4
            @Override // java.lang.Runnable
            public void run() {
                if (submitAsync.isDone() || (nonCancellationPropagating.isCancelled() && p.a(atomicReference, RunningState.NOT_RUN, RunningState.CANCELLED))) {
                    create.setFuture(andSet);
                }
            }
        };
        nonCancellationPropagating.addListener(runnable, MoreExecutors.directExecutor());
        submitAsync.addListener(runnable, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }
}
