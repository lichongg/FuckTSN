package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    volatile boolean cancelled;

    /* renamed from: d, reason: collision with root package name */
    Disposable f43123d;
    Throwable error;
    T value;

    public BlockingMultiObserver() {
        super(1);
    }

    public T blockingGet() {
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

    public Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e6) {
                dispose();
                return e6;
            }
        }
        return this.error;
    }

    void dispose() {
        this.cancelled = true;
        Disposable disposable = this.f43123d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.error = th;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        this.f43123d = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t5) {
        this.value = t5;
        countDown();
    }

    public boolean blockingAwait(long j6, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                if (!await(j6, timeUnit)) {
                    dispose();
                    return false;
                }
            } catch (InterruptedException e6) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e6);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        countDown();
    }

    public Throwable blockingGetError(long j6, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                if (!await(j6, timeUnit)) {
                    dispose();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException());
                }
            } catch (InterruptedException e6) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e6);
            }
        }
        return this.error;
    }

    public T blockingGet(T t5) {
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
            T t6 = this.value;
            return t6 != null ? t6 : t5;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
