package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        final Observer<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;

        /* renamed from: s, reason: collision with root package name */
        Disposable f43349s;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

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
            this.f43349s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = this.actual;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            boolean z5 = this.delayError;
            TimeUnit timeUnit = this.unit;
            Scheduler scheduler = this.scheduler;
            long j6 = this.time;
            int i6 = 1;
            while (!this.cancelled) {
                boolean z6 = this.done;
                Long l6 = (Long) spscLinkedArrayQueue.peek();
                boolean z7 = l6 == null;
                long now = scheduler.now(timeUnit);
                if (!z7 && l6.longValue() > now - j6) {
                    z7 = true;
                }
                if (z6) {
                    if (!z5) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            observer.onError(th);
                            return;
                        } else if (z7) {
                            observer.onComplete();
                            return;
                        }
                    } else if (z7) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                }
                if (z7) {
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    spscLinkedArrayQueue.poll();
                    observer.onNext(spscLinkedArrayQueue.poll());
                }
            }
            this.queue.clear();
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
            this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), t5);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f43349s, disposable)) {
                this.f43349s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        SkipLastTimedObserver(Observer<? super T> observer, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
            this.actual = observer;
            this.time = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.delayError = z5;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipLastTimedObserver(observer, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
        super(observableSource);
        this.time = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
