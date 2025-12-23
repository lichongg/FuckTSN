package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DelaySubscriber<T> implements Subscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        final long delay;
        final boolean delayError;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43166s;
        final TimeUnit unit;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f43167w;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43167w.dispose();
            this.f43166s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f43167w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DelaySubscriber.this.actual.onComplete();
                    } finally {
                        DelaySubscriber.this.f43167w.dispose();
                    }
                }
            }, this.delay, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(final Throwable th) {
            this.f43167w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DelaySubscriber.this.actual.onError(th);
                    } finally {
                        DelaySubscriber.this.f43167w.dispose();
                    }
                }
            }, this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(final T t5) {
            this.f43167w.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.1
                @Override // java.lang.Runnable
                public void run() {
                    DelaySubscriber.this.actual.onNext((Object) t5);
                }
            }, this.delay, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43166s, subscription)) {
                this.f43166s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43166s.request(j6);
        }

        DelaySubscriber(Subscriber<? super T> subscriber, long j6, TimeUnit timeUnit, Scheduler.Worker worker, boolean z5) {
            this.actual = subscriber;
            this.delay = j6;
            this.unit = timeUnit;
            this.f43167w = worker;
            this.delayError = z5;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DelaySubscriber(this.delayError ? subscriber : new SerializedSubscriber(subscriber), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    public FlowableDelay(Publisher<T> publisher, long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5) {
        super(publisher);
        this.delay = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z5;
    }
}
