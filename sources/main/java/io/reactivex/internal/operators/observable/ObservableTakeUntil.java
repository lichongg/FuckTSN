package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends U> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TakeUntilObserver<T> extends AtomicBoolean implements Observer<T> {
        private static final long serialVersionUID = 3451719290311127173L;
        final Observer<? super T> actual;
        final ArrayCompositeDisposable frc;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43358s;

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
            this.actual.onNext(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43358s, disposable)) {
                this.f43358s = disposable;
                this.frc.setResource(0, disposable);
            }
        }

        TakeUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.actual = observer;
            this.frc = arrayCompositeDisposable;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        final SerializedObserver serializedObserver = new SerializedObserver(observer);
        final ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        TakeUntilObserver takeUntilObserver = new TakeUntilObserver(serializedObserver, arrayCompositeDisposable);
        observer.onSubscribe(arrayCompositeDisposable);
        this.other.subscribe(new Observer<U>() { // from class: io.reactivex.internal.operators.observable.ObservableTakeUntil.1
            @Override // io.reactivex.Observer
            public void onComplete() {
                arrayCompositeDisposable.dispose();
                serializedObserver.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                arrayCompositeDisposable.dispose();
                serializedObserver.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u5) {
                arrayCompositeDisposable.dispose();
                serializedObserver.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                arrayCompositeDisposable.setResource(1, disposable);
            }
        });
        this.source.subscribe(takeUntilObserver);
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.other = observableSource2;
    }
}
