package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final T defaultValue;
    final long index;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        long count;
        final T defaultValue;
        boolean done;
        final long index;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43313s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43313s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43313s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t5 = this.defaultValue;
            if (t5 != null) {
                this.actual.onNext(t5);
            }
            this.actual.onComplete();
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
            long j6 = this.count;
            if (j6 != this.index) {
                this.count = j6 + 1;
                return;
            }
            this.done = true;
            this.f43313s.dispose();
            this.actual.onNext(t5);
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43313s, disposable)) {
                this.f43313s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        ElementAtObserver(Observer<? super T> observer, long j6, T t5) {
            this.actual = observer;
            this.index = j6;
            this.defaultValue = t5;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ElementAtObserver(observer, this.index, this.defaultValue));
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j6, T t5) {
        super(observableSource);
        this.index = j6;
        this.defaultValue = t5;
    }
}
