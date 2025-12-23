package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final ObservableSource<? extends U> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final Observer<? super R> actual;
        final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Disposable> f43382s = new AtomicReference<>();
        final AtomicReference<Disposable> other = new AtomicReference<>();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.f43382s);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f43382s.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f43382s, disposable);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.f43382s);
            this.actual.onError(th);
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.actual = observer;
            this.combiner = biFunction;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            U u5 = get();
            if (u5 != null) {
                try {
                    this.actual.onNext(this.combiner.apply(t5, u5));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    this.actual.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        final WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(new SerializedObserver(observer), this.combiner);
        observer.onSubscribe(withLatestFromObserver);
        this.other.subscribe(new Observer<U>() { // from class: io.reactivex.internal.operators.observable.ObservableWithLatestFrom.1
            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                withLatestFromObserver.otherError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u5) {
                withLatestFromObserver.lazySet(u5);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                withLatestFromObserver.setOther(disposable);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
            }
        });
        this.source.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.combiner = biFunction;
        this.other = observableSource2;
    }
}
