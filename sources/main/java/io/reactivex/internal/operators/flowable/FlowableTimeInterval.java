package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeIntervalSubscriber<T> implements Subscriber<T>, Subscription {
        final Subscriber<? super Timed<T>> actual;
        long lastTime;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43227s;
        final Scheduler scheduler;
        final TimeUnit unit;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43227s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            long now = this.scheduler.now(this.unit);
            long j6 = this.lastTime;
            this.lastTime = now;
            this.actual.onNext(new Timed(t5, now - j6, this.unit));
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43227s, subscription)) {
                this.lastTime = this.scheduler.now(this.unit);
                this.f43227s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43227s.request(j6);
        }

        TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.actual = subscriber;
            this.scheduler = scheduler;
            this.unit = timeUnit;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.source.subscribe(new TimeIntervalSubscriber(subscriber, this.unit, this.scheduler));
    }

    public FlowableTimeInterval(Publisher<T> publisher, TimeUnit timeUnit, Scheduler scheduler) {
        super(publisher);
        this.scheduler = scheduler;
        this.unit = timeUnit;
    }
}
