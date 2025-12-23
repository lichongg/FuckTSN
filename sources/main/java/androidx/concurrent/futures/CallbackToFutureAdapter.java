package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CallbackToFutureAdapter {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
        SafeFuture<T> future;
        Object tag;

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T t5) {
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            boolean z5 = safeFuture != null && safeFuture.set(t5);
            if (z5) {
                setCompletedNormally();
            }
            return z5;
        }

        public boolean setCancelled() {
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            boolean z5 = safeFuture != null && safeFuture.cancelWithoutNotifyingCompleter(true);
            if (z5) {
                setCompletedNormally();
            }
            return z5;
        }

        public boolean setException(@NonNull Throwable th) {
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            boolean z5 = safeFuture != null && safeFuture.setException(th);
            if (z5) {
                setCompletedNormally();
            }
            return z5;
        }

        public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        protected void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
            }
            if (this.attemptedSetting || (resolvableFuture = this.cancellationFuture) == null) {
                return;
            }
            resolvableFuture.set(null);
        }

        Completer() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> completer) throws Exception;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SafeFuture<T> implements ListenableFuture<T> {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>() { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            protected String pendingToString() {
                Completer<T> completer = SafeFuture.this.completerWeakReference.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.tag + "]";
            }
        };

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.delegate.addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z5) {
            Completer<T> completer = this.completerWeakReference.get();
            boolean cancel = this.delegate.cancel(z5);
            if (cancel && completer != null) {
                completer.fireCancellationListeners();
            }
            return cancel;
        }

        boolean cancelWithoutNotifyingCompleter(boolean z5) {
            return this.delegate.cancel(z5);
        }

        @Override // java.util.concurrent.Future
        public T get(long j6, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(j6, timeUnit);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegate.isDone();
        }

        boolean set(T t5) {
            return this.delegate.set(t5);
        }

        boolean setException(Throwable th) {
            return this.delegate.setException(th);
        }

        public String toString() {
            return this.delegate.toString();
        }

        SafeFuture(Completer<T> completer) {
            this.completerWeakReference = new WeakReference<>(completer);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FutureGarbageCollectedException extends Throwable {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }

        FutureGarbageCollectedException(String str) {
            super(str);
        }
    }

    @NonNull
    public static <T> ListenableFuture<T> getFuture(@NonNull Resolver<T> resolver) {
        Completer<T> completer = new Completer<>();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.future = safeFuture;
        completer.tag = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter == null) {
                return safeFuture;
            }
            completer.tag = attachCompleter;
            return safeFuture;
        } catch (Exception e6) {
            safeFuture.setException(e6);
            return safeFuture;
        }
    }

    private CallbackToFutureAdapter() {
    }
}
