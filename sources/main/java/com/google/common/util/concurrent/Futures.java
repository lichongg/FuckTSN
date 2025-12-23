package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.Partially;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Futures extends GwtFuturesCatchingSpecialization {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.callback.onSuccess(Futures.getDone(this.future));
            } catch (Error e6) {
                e = e6;
                this.callback.onFailure(e);
            } catch (RuntimeException e7) {
                e = e7;
                this.callback.onFailure(e);
            } catch (ExecutionException e8) {
                this.callback.onFailure(e8.getCause());
            }
        }

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.future = future;
            this.callback = futureCallback;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.callback).toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    @GwtCompatible
    @CanIgnoreReturnValue
    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        private FutureCombiner(boolean z5, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            this.allMustSucceed = z5;
            this.futures = immutableList;
        }

        @CanIgnoreReturnValue
        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new CombinedFuture(this.futures, this.allMustSucceed, executor, callable);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            return new CombinedFuture(this.futures, this.allMustSucceed, executor, asyncCallable);
        }

        public ListenableFuture<?> run(final Runnable runnable, Executor executor) {
            return call(new Callable<Void>() { // from class: com.google.common.util.concurrent.Futures.FutureCombiner.1
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    runnable.run();
                    return null;
                }
            }, executor);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        private InCompletionOrderState<T> state;

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void afterDone() {
            this.state = null;
        }

        private InCompletionOrderFuture(InCompletionOrderState<T> inCompletionOrderState) {
            this.state = inCompletionOrderState;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z5) {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (!super.cancel(z5)) {
                return false;
            }
            inCompletionOrderState.recordOutputCancellation(z5);
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected String pendingToString() {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (inCompletionOrderState == null) {
                return null;
            }
            return "inputCount=[" + ((InCompletionOrderState) inCompletionOrderState).inputFutures.length + "], remaining=[" + ((InCompletionOrderState) inCompletionOrderState).incompleteOutputCount.get() + "]";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        private final AtomicInteger incompleteOutputCount;
        private final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        /* JADX INFO: Access modifiers changed from: private */
        public void recordOutputCancellation(boolean z5) {
            this.wasCancelled = true;
            if (!z5) {
                this.shouldInterrupt = false;
            }
            recordCompletion();
        }

        private InCompletionOrderState(ListenableFuture<? extends T>[] listenableFutureArr) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = listenableFutureArr;
            this.incompleteOutputCount = new AtomicInteger(listenableFutureArr.length);
        }

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0 && this.wasCancelled) {
                for (ListenableFuture<? extends T> listenableFuture : this.inputFutures) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.shouldInterrupt);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordInputCompletion(ImmutableList<AbstractFuture<T>> immutableList, int i6) {
            ListenableFuture<? extends T>[] listenableFutureArr = this.inputFutures;
            ListenableFuture<? extends T> listenableFuture = listenableFutureArr[i6];
            listenableFutureArr[i6] = null;
            for (int i7 = this.delegateIndex; i7 < immutableList.size(); i7++) {
                if (immutableList.get(i7).setFuture(listenableFuture)) {
                    recordCompletion();
                    this.delegateIndex = i7 + 1;
                    return;
                }
            }
            this.delegateIndex = immutableList.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtIncompatible
    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X> {
        final Function<? super Exception, X> mapper;

        @Override // com.google.common.util.concurrent.AbstractCheckedFuture
        protected X mapException(Exception exc) {
            return this.mapper.apply(exc);
        }

        MappingCheckedFuture(ListenableFuture<V> listenableFuture, Function<? super Exception, X> function) {
            super(listenableFuture);
            this.mapper = (Function) Preconditions.checkNotNull(function);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        private ListenableFuture<V> delegate;

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void afterDone() {
            this.delegate = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected String pendingToString() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + "]";
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }

        NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = listenableFuture;
        }
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), true);
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        return (V) FuturesGetChecked.getChecked(future, cls);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), false);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(listenableFutureArr));
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(listenableFutureArr));
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), true);
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j6, TimeUnit timeUnit) throws Exception {
        return (V) FuturesGetChecked.getChecked(future, cls, j6, timeUnit);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    @Beta
    @GwtIncompatible
    @Deprecated
    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@NullableDecl V v5) {
        return new ImmediateFuture.ImmediateSuccessfulCheckedFuture(v5);
    }

    public static <V> ListenableFuture<V> immediateFuture(@NullableDecl V v5) {
        return v5 == null ? ImmediateFuture.ImmediateSuccessfulFuture.NULL : new ImmediateFuture.ImmediateSuccessfulFuture(v5);
    }

    @Beta
    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        Collection copyOf = iterable instanceof Collection ? (Collection) iterable : ImmutableList.copyOf(iterable);
        ListenableFuture[] listenableFutureArr = (ListenableFuture[]) copyOf.toArray(new ListenableFuture[copyOf.size()]);
        final InCompletionOrderState inCompletionOrderState = new InCompletionOrderState(listenableFutureArr);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i6 = 0; i6 < listenableFutureArr.length; i6++) {
            builder.add((ImmutableList.Builder) new InCompletionOrderFuture(inCompletionOrderState));
        }
        final ImmutableList<ListenableFuture<T>> build = builder.build();
        for (final int i7 = 0; i7 < listenableFutureArr.length; i7++) {
            listenableFutureArr[i7].addListener(new Runnable() { // from class: com.google.common.util.concurrent.Futures.3
                @Override // java.lang.Runnable
                public void run() {
                    InCompletionOrderState.this.recordInputCompletion(build, i7);
                }
            }, MoreExecutors.directExecutor());
        }
        return build;
    }

    @Beta
    @GwtIncompatible
    @Deprecated
    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> listenableFuture, Function<? super Exception, X> function) {
        return new MappingCheckedFuture((ListenableFuture) Preconditions.checkNotNull(listenableFuture), function);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), false);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(iterable));
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(iterable));
    }

    private static void wrapAndThrowUnchecked(Throwable th) {
        if (!(th instanceof Error)) {
            throw new UncheckedExecutionException(th);
        }
        throw new ExecutionError((Error) th);
    }

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, function, executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, asyncFunction, executor);
    }

    @CanIgnoreReturnValue
    public static <V> V getDone(Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.getUninterruptibly(future);
    }

    @CanIgnoreReturnValue
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return (V) Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e6) {
            wrapAndThrowUnchecked(e6.getCause());
            throw new AssertionError();
        }
    }

    @Beta
    @GwtIncompatible
    @Deprecated
    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X x5) {
        Preconditions.checkNotNull(x5);
        return new ImmediateFuture.ImmediateFailedCheckedFuture(x5);
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    @Beta
    @GwtIncompatible
    public static <I, O> Future<O> lazyTransform(final Future<I> future, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Future<O>() { // from class: com.google.common.util.concurrent.Futures.2
            @Override // java.util.concurrent.Future
            public O get() throws InterruptedException, ExecutionException {
                return applyTransformation(future.get());
            }

            private O applyTransformation(I i6) throws ExecutionException {
                try {
                    return (O) function.apply(i6);
                } catch (Throwable th) {
                    throw new ExecutionException(th);
                }
            }

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z5) {
                return future.cancel(z5);
            }

            @Override // java.util.concurrent.Future
            public O get(long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return applyTransformation(future.get(j6, timeUnit));
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return future.isDone();
            }
        };
    }

    @Beta
    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new NonCancellationPropagatingFuture(listenableFuture);
        listenableFuture.addListener(nonCancellationPropagatingFuture, MoreExecutors.directExecutor());
        return nonCancellationPropagatingFuture;
    }

    @Beta
    @GwtIncompatible
    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j6, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask create = TrustedListenableFutureTask.create(asyncCallable);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(create, j6, timeUnit);
        create.addListener(new Runnable() { // from class: com.google.common.util.concurrent.Futures.1
            @Override // java.lang.Runnable
            public void run() {
                schedule.cancel(false);
            }
        }, MoreExecutors.directExecutor());
        return create;
    }

    @Beta
    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        TrustedListenableFutureTask create = TrustedListenableFutureTask.create(asyncCallable);
        executor.execute(create);
        return create;
    }

    @Beta
    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, function, executor);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, asyncFunction, executor);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j6, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return TimeoutFuture.create(listenableFuture, j6, timeUnit, scheduledExecutorService);
    }
}
