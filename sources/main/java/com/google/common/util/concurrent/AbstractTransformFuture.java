package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {

    @NullableDecl
    F function;

    @NullableDecl
    ListenableFuture<? extends I> inputFuture;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* bridge */ /* synthetic */ Object doTransform(Object obj, @NullableDecl Object obj2) throws Exception {
            return doTransform((AsyncFunction<? super AsyncFunction<? super I, ? extends O>, ? extends O>) obj, (AsyncFunction<? super I, ? extends O>) obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, @NullableDecl I i6) throws Exception {
            ListenableFuture<? extends O> apply = asyncFunction.apply(i6);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }

        AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @NullableDecl
        /* bridge */ /* synthetic */ Object doTransform(Object obj, @NullableDecl Object obj2) throws Exception {
            return doTransform((Function<? super Function<? super I, ? extends O>, ? extends O>) obj, (Function<? super I, ? extends O>) obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NullableDecl
        O doTransform(Function<? super I, ? extends O> function, @NullableDecl I i6) {
            return function.apply(i6);
        }

        TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        void setResult(@NullableDecl O o5) {
            set(o5);
        }
    }

    static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    @NullableDecl
    @ForOverride
    abstract T doTransform(F f6, @NullableDecl I i6) throws Exception;

    @ForOverride
    abstract void setResult(@NullableDecl T t5);

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f6 = this.function;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f6 != null) {
            return str + "function=[" + f6 + "]";
        }
        if (pendingToString == null) {
            return null;
        }
        return str + pendingToString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f6 = this.function;
        if ((isCancelled() | (listenableFuture == null)) || (f6 == null)) {
            return;
        }
        this.inputFuture = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object doTransform = doTransform(f6, Futures.getDone(listenableFuture));
                this.function = null;
                setResult(doTransform);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.function = null;
                }
            }
        } catch (Error e6) {
            setException(e6);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e7) {
            setException(e7);
        } catch (ExecutionException e8) {
            setException(e8.getCause());
        }
    }

    AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f6) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.function = (F) Preconditions.checkNotNull(f6);
    }

    static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function);
        listenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, transformFuture));
        return transformFuture;
    }
}
