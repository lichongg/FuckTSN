package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {
    final int count;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 7240042530241604978L;
        final Observer<? super T> actual;
        volatile boolean cancelled;
        final int count;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43355s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43355s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer<? super T> observer = this.actual;
            while (!this.cancelled) {
                T poll = poll();
                if (poll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    observer.onComplete();
                    return;
                }
                observer.onNext(poll);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.count == size()) {
                poll();
            }
            offer(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43355s, disposable)) {
                this.f43355s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        TakeLastObserver(Observer<? super T> observer, int i6) {
            this.actual = observer;
            this.count = i6;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastObserver(observer, this.count));
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i6) {
        super(observableSource);
        this.count = i6;
    }
}
