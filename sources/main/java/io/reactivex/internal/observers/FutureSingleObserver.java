package io.reactivex.internal.observers;

import androidx.camera.view.p;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {
    Throwable error;

    /* renamed from: s, reason: collision with root package name */
    final AtomicReference<Disposable> f43128s;
    T value;

    public FutureSingleObserver() {
        super(1);
        this.f43128s = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f43128s.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!p.a(this.f43128s, disposable, disposableHelper));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f43128s.get());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        Disposable disposable;
        do {
            disposable = this.f43128s.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
        } while (!p.a(this.f43128s, disposable, this));
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f43128s, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t5) {
        Disposable disposable = this.f43128s.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return;
        }
        this.value = t5;
        p.a(this.f43128s, disposable, this);
        countDown();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get(long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0 && !await(j6, timeUnit)) {
            throw new TimeoutException();
        }
        if (!isCancelled()) {
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }
}
