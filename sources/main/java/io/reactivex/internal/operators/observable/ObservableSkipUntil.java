package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipUntilObserver<T> implements Observer<T> {
        final Observer<? super T> actual;
        final ArrayCompositeDisposable frc;
        volatile boolean notSkipping;
        boolean notSkippingLocal;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43351s;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.frc.dispose();
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.frc.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.notSkippingLocal) {
                this.actual.onNext(t5);
            } else if (this.notSkipping) {
                this.notSkippingLocal = true;
                this.actual.onNext(t5);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43351s, disposable)) {
                this.f43351s = disposable;
                this.frc.setResource(0, disposable);
            }
        }

        SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.actual = observer;
            this.frc = arrayCompositeDisposable;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        final SerializedObserver serializedObserver = new SerializedObserver(observer);
        final ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        final SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.other.subscribe(new Observer<U>() { // from class: io.reactivex.internal.operators.observable.ObservableSkipUntil.1

            /* renamed from: s, reason: collision with root package name */
            Disposable f43350s;

            @Override // io.reactivex.Observer
            public void onComplete() {
                skipUntilObserver.notSkipping = true;
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                arrayCompositeDisposable.dispose();
                serializedObserver.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u5) {
                this.f43350s.dispose();
                skipUntilObserver.notSkipping = true;
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                if (DisposableHelper.validate(this.f43350s, disposable)) {
                    this.f43350s = disposable;
                    arrayCompositeDisposable.setResource(1, disposable);
                }
            }
        });
        this.source.subscribe(skipUntilObserver);
    }

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.other = observableSource2;
    }
}
