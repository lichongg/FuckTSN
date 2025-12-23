package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableLastMaybe<T> extends Maybe<T> {
    final ObservableSource<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LastObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> actual;
        T item;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43328s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43328s.dispose();
            this.f43328s = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43328s == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f43328s = DisposableHelper.DISPOSED;
            T t5 = this.item;
            if (t5 == null) {
                this.actual.onComplete();
            } else {
                this.item = null;
                this.actual.onSuccess(t5);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f43328s = DisposableHelper.DISPOSED;
            this.item = null;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.item = t5;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43328s, disposable)) {
                this.f43328s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new LastObserver(maybeObserver));
    }

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }
}
