package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: n, reason: collision with root package name */
    final long f43346n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        Disposable f43347d;
        long remaining;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43347d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43347d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            long j6 = this.remaining;
            if (j6 != 0) {
                this.remaining = j6 - 1;
            } else {
                this.actual.onNext(t5);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f43347d = disposable;
            this.actual.onSubscribe(this);
        }

        SkipObserver(Observer<? super T> observer, long j6) {
            this.actual = observer;
            this.remaining = j6;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.f43346n));
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j6) {
        super(observableSource);
        this.f43346n = j6;
    }
}
