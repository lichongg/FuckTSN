package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        final long delay;
        final boolean delayError;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43307s;
        final TimeUnit unit;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f43308w;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43308w.dispose();
            this.f43307s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43308w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f43308w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DelayObserver.this.actual.onComplete();
                    } finally {
                        DelayObserver.this.f43308w.dispose();
                    }
                }
            }, this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onError(final Throwable th) {
            this.f43308w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DelayObserver.this.actual.onError(th);
                    } finally {
                        DelayObserver.this.f43308w.dispose();
                    }
                }
            }, this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onNext(final T t5) {
            this.f43308w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    DelayObserver.this.actual.onNext((Object) t5);
                }
            }, this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43307s, disposable)) {
                this.f43307s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        DelayObserver(Observer<? super T> observer, long j6, TimeUnit timeUnit, Scheduler.Worker worker, boolean z5) {
            this.actual = observer;
            this.delay = j6;
            this.unit = timeUnit;
            this.f43308w = worker;
            this.delayError = z5;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DelayObserver(this.delayError ? observer : new SerializedObserver(observer), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5) {
        super(observableSource);
        this.delay = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z5;
    }
}
