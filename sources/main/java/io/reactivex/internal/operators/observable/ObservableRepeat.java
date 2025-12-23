package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {
    final long count;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> actual;
        long remaining;
        final SequentialDisposable sd;
        final ObservableSource<? extends T> source;

        @Override // io.reactivex.Observer
        public void onComplete() {
            long j6 = this.remaining;
            if (j6 != Long.MAX_VALUE) {
                this.remaining = j6 - 1;
            }
            if (j6 != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.actual.onNext(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.sd.replace(disposable);
        }

        RepeatObserver(Observer<? super T> observer, long j6, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.actual = observer;
            this.sd = sequentialDisposable;
            this.source = observableSource;
            this.remaining = j6;
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i6 = 1;
                while (!this.sd.isDisposed()) {
                    this.source.subscribe(this);
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j6 = this.count;
        new RepeatObserver(observer, j6 != Long.MAX_VALUE ? j6 - 1 : Long.MAX_VALUE, sequentialDisposable, this.source).subscribeNext();
    }

    public ObservableRepeat(Observable<T> observable, long j6) {
        super(observable);
        this.count = j6;
    }
}
