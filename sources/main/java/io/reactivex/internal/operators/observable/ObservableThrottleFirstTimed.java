package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        final Observer<? super T> actual;
        boolean done;
        volatile boolean gate;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43361s;
        final long timeout;
        final TimeUnit unit;
        final Scheduler.Worker worker;

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            DisposableHelper.dispose(this);
            this.worker.dispose();
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.actual.onNext(t5);
            Disposable disposable = get();
            if (disposable != null) {
                disposable.dispose();
            }
            DisposableHelper.replace(this, this.worker.schedule(this, this.timeout, this.unit));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43361s, disposable)) {
                this.f43361s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        DebounceTimedObserver(Observer<? super T> observer, long j6, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.actual = observer;
            this.timeout = j6;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.worker.dispose();
            this.f43361s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.timeout, this.unit, this.scheduler.createWorker()));
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.timeout = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }
}
