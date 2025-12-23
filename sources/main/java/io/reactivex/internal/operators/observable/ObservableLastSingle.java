package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableLastSingle<T> extends Single<T> {
    final T defaultItem;
    final ObservableSource<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LastObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> actual;
        final T defaultItem;
        T item;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43329s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43329s.dispose();
            this.f43329s = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43329s == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f43329s = DisposableHelper.DISPOSED;
            T t5 = this.item;
            if (t5 != null) {
                this.item = null;
                this.actual.onSuccess(t5);
                return;
            }
            T t6 = this.defaultItem;
            if (t6 != null) {
                this.actual.onSuccess(t6);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f43329s = DisposableHelper.DISPOSED;
            this.item = null;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.item = t5;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43329s, disposable)) {
                this.f43329s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        LastObserver(SingleObserver<? super T> singleObserver, T t5) {
            this.actual = singleObserver;
            this.defaultItem = t5;
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new LastObserver(singleObserver, this.defaultItem));
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t5) {
        this.source = observableSource;
        this.defaultItem = t5;
    }
}
