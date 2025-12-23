package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DetachObserver<T> implements Observer<T>, Disposable {
        Observer<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43310s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f43310s;
            this.f43310s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asObserver();
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43310s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer<? super T> observer = this.actual;
            this.f43310s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asObserver();
            observer.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Observer<? super T> observer = this.actual;
            this.f43310s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asObserver();
            observer.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.actual.onNext(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43310s, disposable)) {
                this.f43310s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        DetachObserver(Observer<? super T> observer) {
            this.actual = observer;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DetachObserver(observer));
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }
}
