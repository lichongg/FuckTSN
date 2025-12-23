package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
    final T defaultValue;
    final long index;
    final ObservableSource<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> actual;
        long count;
        final T defaultValue;
        boolean done;
        final long index;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43315s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43315s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43315s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t5 = this.defaultValue;
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
            long j6 = this.count;
            if (j6 != this.index) {
                this.count = j6 + 1;
                return;
            }
            this.done = true;
            this.f43315s.dispose();
            this.actual.onSuccess(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43315s, disposable)) {
                this.f43315s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j6, T t5) {
            this.actual = singleObserver;
            this.index = j6;
            this.defaultValue = t5;
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.source, this.index, this.defaultValue));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ElementAtObserver(singleObserver, this.index, this.defaultValue));
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j6, T t5) {
        this.source = observableSource;
        this.index = j6;
        this.defaultValue = t5;
    }
}
