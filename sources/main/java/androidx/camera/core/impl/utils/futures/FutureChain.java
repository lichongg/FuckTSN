package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class FutureChain<V> implements ListenableFuture<V> {

    @Nullable
    CallbackToFutureAdapter.Completer<V> mCompleter;

    @NonNull
    private final ListenableFuture<V> mDelegate;

    FutureChain(@NonNull ListenableFuture<V> listenableFuture) {
        this.mDelegate = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public V get() throws InterruptedException, ExecutionException {
        return this.mDelegate.get();
    }

    @NonNull
    public static <V> FutureChain<V> from(@NonNull ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof FutureChain ? (FutureChain) listenableFuture : new FutureChain<>(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return this.mDelegate.cancel(z5);
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public V get(long j6, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mDelegate.get(j6, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    boolean set(@Nullable V v5) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.set(v5);
        }
        return false;
    }

    boolean setException(@NonNull Throwable th) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.setException(th);
        }
        return false;
    }

    FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<V>() { // from class: androidx.camera.core.impl.utils.futures.FutureChain.1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<V> completer) {
                Preconditions.checkState(FutureChain.this.mCompleter == null, "The result can only set once!");
                FutureChain.this.mCompleter = completer;
                return "FutureChain[" + FutureChain.this + "]";
            }
        });
    }

    public final void addCallback(@NonNull FutureCallback<? super V> futureCallback, @NonNull Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    @NonNull
    public final <T> FutureChain<T> transform(@NonNull Function<? super V, T> function, @NonNull Executor executor) {
        return (FutureChain) Futures.transform(this, function, executor);
    }

    @NonNull
    public final <T> FutureChain<T> transformAsync(@NonNull AsyncFunction<? super V, T> asyncFunction, @NonNull Executor executor) {
        return (FutureChain) Futures.transformAsync(this, asyncFunction, executor);
    }
}
