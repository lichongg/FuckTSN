package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.FullArbiterObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> firstTimeoutIndicator;
    final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
    final ObservableSource<? extends T> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface OnTimeout {
        void innerError(Throwable th);

        void timeout(long j6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutInnerObserver<T, U, V> extends DisposableObserver<Object> {
        boolean done;
        final long index;
        final OnTimeout parent;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.timeout(this.index);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.parent.timeout(this.index);
        }

        TimeoutInnerObserver(OnTimeout onTimeout, long j6) {
            this.parent = onTimeout;
            this.index = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutObserver<T, U, V> extends AtomicReference<Disposable> implements Observer<T>, Disposable, OnTimeout {
        private static final long serialVersionUID = 2672739326310051084L;
        final Observer<? super T> actual;
        final ObservableSource<U> firstTimeoutIndicator;
        volatile long index;
        final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43363s;

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void innerError(Throwable th) {
            this.f43363s.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43363s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            long j6 = this.index + 1;
            this.index = j6;
            this.actual.onNext(t5);
            Disposable disposable = (Disposable) get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t5), "The ObservableSource returned is null");
                TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, j6);
                if (compareAndSet(disposable, timeoutInnerObserver)) {
                    observableSource.subscribe(timeoutInnerObserver);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43363s, disposable)) {
                this.f43363s = disposable;
                Observer<? super T> observer = this.actual;
                ObservableSource<U> observableSource = this.firstTimeoutIndicator;
                if (observableSource == null) {
                    observer.onSubscribe(this);
                    return;
                }
                TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, 0L);
                if (compareAndSet(null, timeoutInnerObserver)) {
                    observer.onSubscribe(this);
                    observableSource.subscribe(timeoutInnerObserver);
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void timeout(long j6) {
            if (j6 == this.index) {
                dispose();
                this.actual.onError(new TimeoutException());
            }
        }

        TimeoutObserver(Observer<? super T> observer, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
            this.actual = observer;
            this.firstTimeoutIndicator = observableSource;
            this.itemTimeoutIndicator = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.f43363s.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutOtherObserver<T, U, V> extends AtomicReference<Disposable> implements Observer<T>, Disposable, OnTimeout {
        private static final long serialVersionUID = -1957813281749686898L;
        final Observer<? super T> actual;
        final ObserverFullArbiter<T> arbiter;
        boolean done;
        final ObservableSource<U> firstTimeoutIndicator;
        volatile long index;
        final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
        final ObservableSource<? extends T> other;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43364s;

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void innerError(Throwable th) {
            this.f43364s.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43364s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.onComplete(this.f43364s);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.onError(th, this.f43364s);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index + 1;
            this.index = j6;
            if (this.arbiter.onNext(t5, this.f43364s)) {
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t5), "The ObservableSource returned is null");
                    TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, j6);
                    if (compareAndSet(disposable, timeoutInnerObserver)) {
                        observableSource.subscribe(timeoutInnerObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43364s, disposable)) {
                this.f43364s = disposable;
                this.arbiter.setDisposable(disposable);
                Observer<? super T> observer = this.actual;
                ObservableSource<U> observableSource = this.firstTimeoutIndicator;
                if (observableSource == null) {
                    observer.onSubscribe(this.arbiter);
                    return;
                }
                TimeoutInnerObserver timeoutInnerObserver = new TimeoutInnerObserver(this, 0L);
                if (compareAndSet(null, timeoutInnerObserver)) {
                    observer.onSubscribe(this.arbiter);
                    observableSource.subscribe(timeoutInnerObserver);
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.OnTimeout
        public void timeout(long j6) {
            if (j6 == this.index) {
                dispose();
                this.other.subscribe(new FullArbiterObserver(this.arbiter));
            }
        }

        TimeoutOtherObserver(Observer<? super T> observer, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
            this.actual = observer;
            this.firstTimeoutIndicator = observableSource;
            this.itemTimeoutIndicator = function;
            this.other = observableSource2;
            this.arbiter = new ObserverFullArbiter<>(observer, this, 8);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.f43364s.dispose();
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        if (this.other == null) {
            this.source.subscribe(new TimeoutObserver(new SerializedObserver(observer), this.firstTimeoutIndicator, this.itemTimeoutIndicator));
        } else {
            this.source.subscribe(new TimeoutOtherObserver(observer, this.firstTimeoutIndicator, this.itemTimeoutIndicator, this.other));
        }
    }

    public ObservableTimeout(ObservableSource<T> observableSource, ObservableSource<U> observableSource2, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource3) {
        super(observableSource);
        this.firstTimeoutIndicator = observableSource2;
        this.itemTimeoutIndicator = function;
        this.other = observableSource3;
    }
}
