package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
    final long limit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TakeSubscriber<T> extends AtomicBoolean implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;
        final Subscriber<? super T> actual;
        boolean done;
        final long limit;
        long remaining;
        Subscription subscription;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.subscription.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                return;
            }
            this.done = true;
            this.subscription.cancel();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.remaining;
            long j7 = j6 - 1;
            this.remaining = j7;
            if (j6 > 0) {
                boolean z5 = j7 == 0;
                this.actual.onNext(t5);
                if (z5) {
                    this.subscription.cancel();
                    onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.subscription, subscription)) {
                this.subscription = subscription;
                if (this.limit != 0) {
                    this.actual.onSubscribe(this);
                    return;
                }
                subscription.cancel();
                this.done = true;
                EmptySubscription.complete(this.actual);
            }
        }

        TakeSubscriber(Subscriber<? super T> subscriber, long j6) {
            this.actual = subscriber;
            this.limit = j6;
            this.remaining = j6;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (!SubscriptionHelper.validate(j6)) {
                return;
            }
            if (!get() && compareAndSet(false, true) && j6 >= this.limit) {
                this.subscription.request(Long.MAX_VALUE);
            } else {
                this.subscription.request(j6);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeSubscriber(subscriber, this.limit));
    }

    public FlowableTake(Publisher<T> publisher, long j6) {
        super(publisher);
        this.limit = j6;
    }
}
