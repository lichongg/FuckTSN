package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Notification<T>> actual;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43331s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43331s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43331s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.actual.onNext(Notification.createOnNext(t5));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43331s, disposable)) {
                this.f43331s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.actual = observer;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onNext(Notification.createOnComplete());
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onNext(Notification.createOnError(th));
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Notification<T>> observer) {
        this.source.subscribe(new MaterializeObserver(observer));
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }
}
