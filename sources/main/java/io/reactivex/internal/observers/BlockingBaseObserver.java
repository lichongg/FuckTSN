package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    volatile boolean cancelled;

    /* renamed from: d, reason: collision with root package name */
    Disposable f43122d;
    Throwable error;
    T value;

    public BlockingBaseObserver() {
        super(1);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.cancelled = true;
        Disposable disposable = this.f43122d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f43122d = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e6) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e6);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }
}
