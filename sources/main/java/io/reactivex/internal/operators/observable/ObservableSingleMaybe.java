package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSingleMaybe<T> extends Maybe<T> {
    final ObservableSource<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> actual;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43344s;
        T value;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43344s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43344s.isDisposed();
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
                this.actual.onComplete();
            } else {
                this.actual.onSuccess(t5);
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
            this.f43344s.dispose();
            this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43344s, disposable)) {
                this.f43344s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new SingleElementObserver(maybeObserver));
    }

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }
}
