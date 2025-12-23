package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.FullArbiterSubscriber;
import io.reactivex.internal.subscriptions.FullArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    static final Disposable NEW_TIMER = new Disposable() { // from class: io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.1
        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }
    };
    final Publisher<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutTimedOtherSubscriber<T> implements Subscriber<T>, Disposable {
        final Subscriber<? super T> actual;
        final FullArbiter<T> arbiter;
        volatile boolean done;
        volatile long index;
        final Publisher<? extends T> other;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43230s;
        final long timeout;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;
        final Scheduler.Worker worker;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.worker.dispose();
            DisposableHelper.dispose(this.timer);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.worker.dispose();
            DisposableHelper.dispose(this.timer);
            this.arbiter.onComplete(this.f43230s);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.worker.dispose();
            DisposableHelper.dispose(this.timer);
            this.arbiter.onError(th, this.f43230s);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index + 1;
            this.index = j6;
            if (this.arbiter.onNext(t5, this.f43230s)) {
                scheduleTimeout(j6);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43230s, subscription)) {
                this.f43230s = subscription;
                if (this.arbiter.setSubscription(subscription)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        void scheduleTimeout(final long j6) {
            Disposable disposable = this.timer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            if (p.a(this.timer, disposable, FlowableTimeoutTimed.NEW_TIMER)) {
                DisposableHelper.replace(this.timer, this.worker.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutTimedOtherSubscriber.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j6 == TimeoutTimedOtherSubscriber.this.index) {
                            TimeoutTimedOtherSubscriber.this.done = true;
                            TimeoutTimedOtherSubscriber.this.f43230s.cancel();
                            DisposableHelper.dispose(TimeoutTimedOtherSubscriber.this.timer);
                            TimeoutTimedOtherSubscriber.this.subscribeNext();
                            TimeoutTimedOtherSubscriber.this.worker.dispose();
                        }
                    }
                }, this.timeout, this.unit));
            }
        }

        void subscribeNext() {
            this.other.subscribe(new FullArbiterSubscriber(this.arbiter));
        }

        TimeoutTimedOtherSubscriber(Subscriber<? super T> subscriber, long j6, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.timeout = j6;
            this.unit = timeUnit;
            this.worker = worker;
            this.other = publisher;
            this.arbiter = new FullArbiter<>(subscriber, this, 8);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutTimedSubscriber<T> implements Subscriber<T>, Disposable, Subscription {
        final Subscriber<? super T> actual;
        volatile boolean done;
        volatile long index;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43231s;
        final long timeout;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;
        final Scheduler.Worker worker;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.worker.dispose();
            DisposableHelper.dispose(this.timer);
            this.f43231s.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index + 1;
            this.index = j6;
            this.actual.onNext(t5);
            scheduleTimeout(j6);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43231s, subscription)) {
                this.f43231s = subscription;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43231s.request(j6);
        }

        void scheduleTimeout(final long j6) {
            Disposable disposable = this.timer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            if (p.a(this.timer, disposable, FlowableTimeoutTimed.NEW_TIMER)) {
                DisposableHelper.replace(this.timer, this.worker.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutTimedSubscriber.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j6 == TimeoutTimedSubscriber.this.index) {
                            TimeoutTimedSubscriber.this.done = true;
                            TimeoutTimedSubscriber.this.dispose();
                            TimeoutTimedSubscriber.this.actual.onError(new TimeoutException());
                        }
                    }
                }, this.timeout, this.unit));
            }
        }

        TimeoutTimedSubscriber(Subscriber<? super T> subscriber, long j6, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.actual = subscriber;
            this.timeout = j6;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.other == null) {
            this.source.subscribe(new TimeoutTimedSubscriber(new SerializedSubscriber(subscriber), this.timeout, this.unit, this.scheduler.createWorker()));
        } else {
            this.source.subscribe(new TimeoutTimedOtherSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker(), this.other));
        }
    }

    public FlowableTimeoutTimed(Publisher<T> publisher, long j6, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher2) {
        super(publisher);
        this.timeout = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = publisher2;
    }
}
