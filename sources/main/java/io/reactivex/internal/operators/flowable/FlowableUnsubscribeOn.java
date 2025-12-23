package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler scheduler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;
        final Subscriber<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43234s;
        final Scheduler scheduler;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.scheduleDirect(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn.UnsubscribeSubscriber.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UnsubscribeSubscriber.this.f43234s.cancel();
                    }
                });
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43234s, subscription)) {
                this.f43234s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43234s.request(j6);
        }

        UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.actual = subscriber;
            this.scheduler = scheduler;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (!get()) {
                this.actual.onNext(t5);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new UnsubscribeSubscriber(subscriber, this.scheduler));
    }

    public FlowableUnsubscribeOn(Publisher<T> publisher, Scheduler scheduler) {
        super(publisher);
        this.scheduler = scheduler;
    }
}
