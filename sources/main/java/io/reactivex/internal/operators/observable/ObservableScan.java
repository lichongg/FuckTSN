package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> accumulator;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ScanObserver<T> implements Observer<T>, Disposable {
        final BiFunction<T, T, T> accumulator;
        final Observer<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43338s;
        T value;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43338s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43338s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            Observer<? super T> observer = this.actual;
            T t6 = this.value;
            if (t6 == null) {
                this.value = t5;
                observer.onNext(t5);
                return;
            }
            try {
                ?? r42 = (T) ObjectHelper.requireNonNull(this.accumulator.apply(t6, t5), "The value returned by the accumulator is null");
                this.value = r42;
                observer.onNext(r42);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43338s.dispose();
                observer.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43338s, disposable)) {
                this.f43338s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.actual = observer;
            this.accumulator = biFunction;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ScanObserver(observer, this.accumulator));
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.accumulator = biFunction;
    }
}
