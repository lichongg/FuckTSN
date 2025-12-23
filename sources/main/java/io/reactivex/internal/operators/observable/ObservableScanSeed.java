package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Callable<R> seedSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {
        final BiFunction<R, ? super T, R> accumulator;
        final Observer<? super R> actual;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43339s;
        R value;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43339s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43339s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            try {
                R r5 = (R) ObjectHelper.requireNonNull(this.accumulator.apply(this.value, t5), "The accumulator returned a null value");
                this.value = r5;
                this.actual.onNext(r5);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43339s.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43339s, disposable)) {
                this.f43339s = disposable;
                this.actual.onSubscribe(this);
                this.actual.onNext(this.value);
            }
        }

        ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r5) {
            this.actual = observer;
            this.accumulator = biFunction;
            this.value = r5;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        try {
            this.source.subscribe(new ScanSeedObserver(observer, this.accumulator, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }

    public ObservableScanSeed(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.accumulator = biFunction;
        this.seedSupplier = callable;
    }
}
