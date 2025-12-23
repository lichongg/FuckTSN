package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {
    final long count;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class RepeatSubscriber<T> extends AtomicInteger implements Subscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> actual;
        long remaining;
        final SubscriptionArbiter sa;
        final Publisher<? extends T> source;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j6 = this.remaining;
            if (j6 != Long.MAX_VALUE) {
                this.remaining = j6 - 1;
            }
            if (j6 != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.actual.onNext(t5);
            this.sa.produced(1L);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.sa.setSubscription(subscription);
        }

        RepeatSubscriber(Subscriber<? super T> subscriber, long j6, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.sa = subscriptionArbiter;
            this.source = publisher;
            this.remaining = j6;
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i6 = 1;
                while (!this.sa.isCancelled()) {
                    this.source.subscribe(this);
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.onSubscribe(subscriptionArbiter);
        long j6 = this.count;
        new RepeatSubscriber(subscriber, j6 != Long.MAX_VALUE ? j6 - 1 : Long.MAX_VALUE, subscriptionArbiter, this.source).subscribeNext();
    }

    public FlowableRepeat(Publisher<T> publisher, long j6) {
        super(publisher);
        this.count = j6;
    }
}
