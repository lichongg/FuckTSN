package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final DebounceTimedObserver<T> parent;
        final T value;

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.emit(this.idx, this.value, this);
            }
        }

        DebounceEmitter(T t5, long j6, DebounceTimedObserver<T> debounceTimedObserver) {
            this.value = t5;
            this.idx = j6;
            this.parent = debounceTimedObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        boolean done;
        volatile long index;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43306s;
        final long timeout;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;
        final Scheduler.Worker worker;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.timer);
            this.worker.dispose();
            this.f43306s.dispose();
        }

        void emit(long j6, T t5, DebounceEmitter<T> debounceEmitter) {
            if (j6 == this.index) {
                this.actual.onNext(t5);
                debounceEmitter.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.timer.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.timer.get();
            if (disposable != DisposableHelper.DISPOSED) {
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                DisposableHelper.dispose(this.timer);
                this.worker.dispose();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            DisposableHelper.dispose(this.timer);
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index + 1;
            this.index = j6;
            Disposable disposable = this.timer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t5, j6, this);
            if (p.a(this.timer, disposable, debounceEmitter)) {
                debounceEmitter.setResource(this.worker.schedule(debounceEmitter, this.timeout, this.unit));
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43306s, disposable)) {
                this.f43306s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        DebounceTimedObserver(Observer<? super T> observer, long j6, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.actual = observer;
            this.timeout = j6;
            this.unit = timeUnit;
            this.worker = worker;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.timeout, this.unit, this.scheduler.createWorker()));
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.timeout = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }
}
