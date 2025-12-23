package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class OnErrorNextObserver<T> implements Observer<T> {
        final Observer<? super T> actual;
        final boolean allowFatal;
        final SequentialDisposable arbiter = new SequentialDisposable();
        boolean done;
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;
        boolean once;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.once = true;
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.once) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.actual.onError(th);
                    return;
                }
            }
            this.once = true;
            if (this.allowFatal && !(th instanceof Exception)) {
                this.actual.onError(th);
                return;
            }
            try {
                ObservableSource<? extends T> apply = this.nextSupplier.apply(th);
                if (apply != null) {
                    apply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.actual.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            this.actual.onNext(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.arbiter.replace(disposable);
        }

        OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z5) {
            this.actual = observer;
            this.nextSupplier = function;
            this.allowFatal = z5;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.nextSupplier, this.allowFatal);
        observer.onSubscribe(onErrorNextObserver.arbiter);
        this.source.subscribe(onErrorNextObserver);
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z5) {
        super(observableSource);
        this.nextSupplier = function;
        this.allowFatal = z5;
    }
}
