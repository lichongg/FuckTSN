package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {
    final int skip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3807491841935125653L;
        final Observer<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43348s;
        final int skip;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43348s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43348s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.skip == size()) {
                this.actual.onNext(poll());
            }
            offer(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43348s, disposable)) {
                this.f43348s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        SkipLastObserver(Observer<? super T> observer, int i6) {
            super(i6);
            this.actual = observer;
            this.skip = i6;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipLastObserver(observer, this.skip));
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i6) {
        super(observableSource);
        this.skip = i6;
    }
}
