package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SampleTimedSubscriber<T> extends AtomicReference<T> implements Subscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Subscriber<? super T> actual;
        final long period;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43203s;
        final Scheduler scheduler;
        final TimeUnit unit;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable timer = new SequentialDisposable();

        @Override // java.lang.Runnable
        public void run() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    BackpressureHelper.produced(this.requested, 1L);
                } else {
                    cancel();
                    this.actual.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43203s, subscription)) {
                this.f43203s = subscription;
                this.actual.onSubscribe(this);
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler scheduler = this.scheduler;
                long j6 = this.period;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j6, j6, this.unit));
                subscription.request(Long.MAX_VALUE);
            }
        }

        SampleTimedSubscriber(Subscriber<? super T> subscriber, long j6, TimeUnit timeUnit, Scheduler scheduler) {
            this.actual = subscriber;
            this.period = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            cancelTimer();
            this.f43203s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            cancelTimer();
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            lazySet(t5);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SampleTimedSubscriber(new SerializedSubscriber(subscriber), this.period, this.unit, this.scheduler));
    }

    public FlowableSampleTimed(Publisher<T> publisher, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        super(publisher);
        this.period = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }
}
