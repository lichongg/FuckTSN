package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        public AsyncCallableInterruptibleTask(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            this.callable = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(ListenableFuture<V> listenableFuture) {
            CombinedFuture.this.setFuture(listenableFuture);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        V runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        public CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            this.callable = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        void setValue(V v5) {
            CombinedFuture.this.set(v5);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        boolean thrownByExecute = true;

        abstract void setValue(T t5);

        public CombinedFutureInterruptibleTask(Executor executor) {
            this.listenerExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void afterRanInterruptibly(T t5, Throwable th) {
            if (th == null) {
                setValue(t5);
                return;
            }
            if (th instanceof ExecutionException) {
                CombinedFuture.this.setException(th.getCause());
            } else if (th instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
            } else {
                CombinedFuture.this.setException(th);
            }
        }

        final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e6) {
                if (this.thrownByExecute) {
                    CombinedFuture.this.setException(e6);
                }
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return CombinedFuture.this.isDone();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
        private CombinedFutureInterruptibleTask task;

        CombinedFutureRunningState(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z5, CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
            super(immutableCollection, z5, false);
            this.task = combinedFutureInterruptibleTask;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        void handleAllCompleted() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.execute();
            } else {
                Preconditions.checkState(CombinedFuture.this.isDone());
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        void interruptTask() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.interruptTask();
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.task = null;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        void collectOneValue(boolean z5, int i6, @NullableDecl Object obj) {
        }
    }

    CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z5, Executor executor, AsyncCallable<V> asyncCallable) {
        init(new CombinedFutureRunningState(immutableCollection, z5, new AsyncCallableInterruptibleTask(asyncCallable, executor)));
    }

    CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z5, Executor executor, Callable<V> callable) {
        init(new CombinedFutureRunningState(immutableCollection, z5, new CallableInterruptibleTask(callable, executor)));
    }
}
