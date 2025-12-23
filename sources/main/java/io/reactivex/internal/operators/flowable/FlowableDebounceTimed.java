package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final DebounceTimedSubscriber<T> parent;
        final T value;

        void emit() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.emit(this.idx, this.value, this);
            }
        }

        DebounceEmitter(T t5, long j6, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.value = t5;
            this.idx = j6;
            this.parent = debounceTimedSubscriber;
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

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DebounceTimedSubscriber<T> extends AtomicLong implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;
        final Subscriber<? super T> actual;
        boolean done;
        volatile long index;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43165s;
        final long timeout;
        final SequentialDisposable timer = new SequentialDisposable();
        final TimeUnit unit;
        final Scheduler.Worker worker;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.timer);
            this.worker.dispose();
            this.f43165s.cancel();
        }

        void emit(long j6, T t5, DebounceEmitter<T> debounceEmitter) {
            if (j6 == this.index) {
                if (get() == 0) {
                    cancel();
                    this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                } else {
                    this.actual.onNext(t5);
                    BackpressureHelper.produced(this, 1L);
                    debounceEmitter.dispose();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.timer.get();
            if (DisposableHelper.isDisposed(disposable)) {
                return;
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
            if (debounceEmitter != null) {
                debounceEmitter.emit();
            }
            DisposableHelper.dispose(this.timer);
            this.worker.dispose();
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            DisposableHelper.dispose(this.timer);
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
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
            if (this.timer.replace(debounceEmitter)) {
                debounceEmitter.setResource(this.worker.schedule(debounceEmitter, this.timeout, this.unit));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43165s, subscription)) {
                this.f43165s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j6, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.actual = subscriber;
            this.timeout = j6;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this, j6);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.timeout, this.unit, this.scheduler.createWorker()));
    }

    public FlowableDebounceTimed(Publisher<T> publisher, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        super(publisher);
        this.timeout = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }
}
