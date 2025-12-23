package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        final Observer<? super T> actual;
        volatile boolean cancelled;
        final long count;

        /* renamed from: d, reason: collision with root package name */
        Disposable f43357d;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

        void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.actual;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                boolean z5 = this.delayError;
                while (!this.cancelled) {
                    if (!z5 && (th = this.error) != null) {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                    Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                    Object poll2 = spscLinkedArrayQueue.poll();
                    if (((Long) poll).longValue() >= this.scheduler.now(this.unit) - this.time) {
                        observer.onNext(poll2);
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43357d.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            long now = this.scheduler.now(this.unit);
            long j6 = this.time;
            long j7 = this.count;
            boolean z5 = j7 == Long.MAX_VALUE;
            spscLinkedArrayQueue.offer(Long.valueOf(now), t5);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() > now - j6 && (z5 || (spscLinkedArrayQueue.size() >> 1) <= j7)) {
                    return;
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43357d, disposable)) {
                this.f43357d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        TakeLastTimedObserver(Observer<? super T> observer, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
            this.actual = observer;
            this.count = j6;
            this.time = j7;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.delayError = z5;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastTimedObserver(observer, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
        super(observableSource);
        this.count = j6;
        this.time = j7;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
