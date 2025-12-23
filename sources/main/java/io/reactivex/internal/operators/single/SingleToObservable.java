package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleToObservable<T> extends Observable<T> {
    final SingleSource<? extends T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SingleToObservableObserver<T> implements SingleObserver<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: d, reason: collision with root package name */
        Disposable f43396d;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43396d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43396d.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43396d, disposable)) {
                this.f43396d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t5) {
            this.actual.onNext(t5);
            this.actual.onComplete();
        }

        SingleToObservableObserver(Observer<? super T> observer) {
            this.actual = observer;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SingleToObservableObserver(observer));
    }

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }
}
