package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSingleSingle<T> extends Single<T> {
    final T defaultValue;
    final ObservableSource<? extends T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> actual;
        final T defaultValue;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43345s;
        T value;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43345s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43345s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t5 = this.value;
            this.value = null;
            if (t5 == null) {
                t5 = this.defaultValue;
            }
            if (t5 != null) {
                this.actual.onSuccess(t5);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.value == null) {
                this.value = t5;
                return;
            }
            this.done = true;
            this.f43345s.dispose();
            this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43345s, disposable)) {
                this.f43345s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        SingleElementObserver(SingleObserver<? super T> singleObserver, T t5) {
            this.actual = singleObserver;
            this.defaultValue = t5;
        }
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new SingleElementObserver(singleObserver, this.defaultValue));
    }

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t5) {
        this.source = observableSource;
        this.defaultValue = t5;
    }
}
