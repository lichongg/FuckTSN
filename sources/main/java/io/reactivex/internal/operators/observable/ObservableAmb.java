package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableAmb<T> extends Observable<T> {
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AmbCoordinator<T> implements Disposable {
        final Observer<? super T> actual;
        final AmbInnerObserver<T>[] observers;
        final AtomicInteger winner = new AtomicInteger();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.observers) {
                    ambInnerObserver.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.winner.get() == -1;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.observers;
            int length = ambInnerObserverArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                ambInnerObserverArr[i6] = new AmbInnerObserver<>(this, i7, this.actual);
                i6 = i7;
            }
            this.winner.lazySet(0);
            this.actual.onSubscribe(this);
            for (int i8 = 0; i8 < length && this.winner.get() == 0; i8++) {
                observableSourceArr[i8].subscribe(ambInnerObserverArr[i8]);
            }
        }

        public boolean win(int i6) {
            int i7 = this.winner.get();
            int i8 = 0;
            if (i7 != 0) {
                return i7 == i6;
            }
            if (!this.winner.compareAndSet(0, i6)) {
                return false;
            }
            AmbInnerObserver<T>[] ambInnerObserverArr = this.observers;
            int length = ambInnerObserverArr.length;
            while (i8 < length) {
                int i9 = i8 + 1;
                if (i9 != i6) {
                    ambInnerObserverArr[i8].dispose();
                }
                i8 = i9;
            }
            return true;
        }

        AmbCoordinator(Observer<? super T> observer, int i6) {
            this.actual = observer;
            this.observers = new AmbInnerObserver[i6];
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final Observer<? super T> actual;
        final int index;
        final AmbCoordinator<T> parent;
        boolean won;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (!this.parent.win(this.index)) {
                RxJavaPlugins.onError(th);
            } else {
                this.won = true;
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.won) {
                this.actual.onNext(t5);
            } else if (!this.parent.win(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.actual.onNext(t5);
            }
        }

        AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i6, Observer<? super T> observer) {
            this.parent = ambCoordinator;
            this.index = i6;
            this.actual = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            try {
                length = 0;
                for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                    if (observableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (length == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i6 = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = i6;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(observer);
        } else if (length == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new AmbCoordinator(observer, length).subscribe(observableSourceArr);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
    }
}
