package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> actual;
        final long period;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43336s;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;

        @Override // java.lang.Runnable
        public void run() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43336s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43336s, disposable)) {
                this.f43336s = disposable;
                this.actual.onSubscribe(this);
                Scheduler scheduler = this.scheduler;
                long j6 = this.period;
                DisposableHelper.replace(this.timer, scheduler.schedulePeriodicallyDirect(this, j6, j6, this.unit));
            }
        }

        SampleTimedObserver(Observer<? super T> observer, long j6, TimeUnit timeUnit, Scheduler scheduler) {
            this.actual = observer;
            this.period = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancelTimer();
            this.f43336s.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            cancelTimer();
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            lazySet(t5);
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SampleTimedObserver(new SerializedObserver(observer), this.period, this.unit, this.scheduler));
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.period = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }
}
