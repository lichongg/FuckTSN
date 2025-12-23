package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SafeObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    boolean done;

    /* renamed from: s, reason: collision with root package name */
    Disposable f43428s;

    void onNextNoSubscription() {
        this.done = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.actual.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.actual.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f43428s.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f43428s.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        if (this.f43428s == null) {
            onCompleteNoSubscription();
            return;
        }
        try {
            this.actual.onComplete();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    void onCompleteNoSubscription() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.actual.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.actual.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        if (this.f43428s != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.actual.onError(th);
                return;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.actual.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.actual.onError(new CompositeException(th, nullPointerException));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th4));
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        if (this.done) {
            return;
        }
        if (this.f43428s == null) {
            onNextNoSubscription();
            return;
        }
        if (t5 == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f43428s.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(new CompositeException(nullPointerException, th));
                return;
            }
        }
        try {
            this.actual.onNext(t5);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            try {
                this.f43428s.dispose();
                onError(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                onError(new CompositeException(th2, th3));
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f43428s, disposable)) {
            this.f43428s = disposable;
            try {
                this.actual.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.done = true;
                try {
                    disposable.dispose();
                    RxJavaPlugins.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }
    }

    public SafeObserver(Observer<? super T> observer) {
        this.actual = observer;
    }
}
