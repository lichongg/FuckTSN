package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43356s;
        T value;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.value = null;
            this.f43356s.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        void emit() {
            T t5 = this.value;
            if (t5 != null) {
                this.value = null;
                this.actual.onNext(t5);
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43356s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.value = t5;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43356s, disposable)) {
                this.f43356s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        TakeLastOneObserver(Observer<? super T> observer) {
            this.actual = observer;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            emit();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastOneObserver(observer));
    }

    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }
}
